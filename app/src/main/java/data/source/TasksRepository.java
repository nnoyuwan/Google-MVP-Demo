package data.source;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import data.source.local.TasksDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/9/26 1:59
 * Created by JY
 * <p>
 * Concrete implementation to load tasks from the data sources into a cache.
 * <p>
 * For simplicity, this implements a dumb synchronisation between locally persisted data and data
 * obtained from the server, by using the remote data source only if the local database doesn't
 * exist or is empty.
 */

public class TasksRepository implements TasksDataSource {

    private static TasksRepository INSTANCE = null;

    private final TasksDataSource mTasksRemoteDataSoure;

    private final TasksDataSource mTasksLocalDataSoure;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     *
     * @param callback
     */
    Map<String, data.source.Task> mCachedTasks;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private TasksRepository(@NonNull TasksDataSource tasksRemoteDataSoure,
                            @NonNull TasksDataSource tasksLocalDataSoure) {
        mTasksRemoteDataSoure = tasksRemoteDataSoure;
        mTasksLocalDataSoure = tasksLocalDataSoure;
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param tasksRemoteDataSource the backend data source
     * @param tasksLocalDataSource  the device storage data source
     * @return the {@link TasksRepository} instance
     */
    public static TasksRepository getInstance(TasksDataSource tasksRemoteDataSource,
                                              TasksDataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new TasksRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    /**
     * Used to force{@link #getInstance(TasksDataSource, TasksDataSource)} to create a new instance
     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }


    /**
     * get task from cache, local data source(SQLite) or remote data source, whichever is available
     * first.
     * <p>
     * Note:{@link LoadTasksCallback#onDataNotAvailable()} is fired if all data source failed to
     * get the data.
     * </p>
     *
     * @param callback
     */
    @Override
    public void getTasks(@NonNull LoadTasksCallback callback) {
        checkNotNull(callback);

        //Respond immediately with cache if available and not dirty
        //缓存可用就先使用缓存
        if (mCachedTasks != null && !mCacheIsDirty) {
            callback.onTasksLoaded(new ArrayList<>(mCachedTasks.values()));
            return;
        }

        if (mCacheIsDirty) {
            //If the cache is dirty we need to fetch new data from the netwrok.
            //缓存数据不对就从网络加载
            getTasksFromRemoteDataSource(callback);
        } else {
            //Query the local storage if available. If not, query the network.
            //没有缓存从数据库加载
            mTasksLocalDataSoure.getTasks(new LoadTasksCallback() {
                @Override
                public void onTasksLoaded(List<data.source.Task> tasks) {
                    refreshCache(tasks);
                }

                @Override
                public void onDataNotAvailable() {

                }
            });
        }
    }

    private void getTasksFromRemoteDataSource(LoadTasksCallback callback) {

    }

    private void refreshCache(List<data.source.Task> tasks) {
        if (mCachedTasks == null) {
            mCachedTasks = new LinkedHashMap<>();
        }
        mCachedTasks.clear();
        for (data.source.Task task : tasks) {
            mCachedTasks.put(task.getId(), task);
        }
        mCacheIsDirty = false;
    }

    @Override
    public void getTask(@NonNull String taskId, @NonNull GetTaskCallback callback) {

    }

    @Override
    public void saveTask(@NonNull data.source.Task task) {

    }

    @Override
    public void completeTask(@NonNull data.source.Task task) {

    }

    @Override
    public void completeTask(@NonNull String taskId) {

    }

    @Override
    public void activateTask(@NonNull data.source.Task task) {

    }

    @Override
    public void activateTask(@NonNull String taskId) {

    }

    @Override
    public void clearCompletedTasks() {

    }

    @Override
    public void refreshTasks() {

    }

    @Override
    public void deleteAllTasks() {

    }

    @Override
    public void deleteTask(@NonNull String taskId) {

    }
}
