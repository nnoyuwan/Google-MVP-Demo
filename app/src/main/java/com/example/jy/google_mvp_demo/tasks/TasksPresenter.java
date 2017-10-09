package com.example.jy.google_mvp_demo.tasks;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.jy.google_mvp_demo.addedittask.AddEditTaskActivity;
import com.example.jy.google_mvp_demo.util.EspressoIdlingResource;

import data.source.Task;
import data.source.TasksRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/9/26 16:39
 * Created by JY
 */

public class TasksPresenter implements TasksContract.Presenter{

    private final TasksRepository mTasksRepository;

    private final TasksContract.View mTasksView;

    private TasksFilterType mCurrentFiltering = TasksFilterType.ALL_TASKS;

    private boolean mFirstLoad = true;

    /**
     * @param tasksRepository 任务库
     * @param tasksView 展示任务列表
     */
    public TasksPresenter(@NonNull TasksRepository tasksRepository, @NonNull TasksContract.View tasksView) {
        mTasksRepository = checkNotNull(tasksRepository, "tasksRepository cannot be null");
        mTasksView = checkNotNull(tasksView, "tasksView cannot be null!");

        mTasksView.setPresenter(this);
    }

    @Override
    public void start() {
        loadTasks(false);
    }

    @Override
    public void result(int requestCode, int resultCode) {
        if (AddEditTaskActivity.REQUEST_ADD_TASK == requestCode && Activity.RESULT_OK == resultCode){
            mTasksView.showSuccessfullySavedMessage();
        }
    }

    @Override
    public void loadTasks(boolean forceUpdate) {
        loadTasks(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    /**
     * @param forceUpdate   Pass in true to refresh the data in the {@link data.source.local.TasksDataSource}
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private void loadTasks(boolean forceUpdate, boolean showLoadingUI) {
        if (showLoadingUI){
            mTasksView.setLoadingIndicator(true);
        }

        if (forceUpdate){
            mTasksRepository.refreshTasks();
        }

        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        //测试环境模拟获取数据延时
        EspressoIdlingResource.increment(); // App is busy until further notice
    }


    @Override
    public void addNewTask() {

    }

    @Override
    public void openTaskDetails(@NonNull Task requestedTask) {

    }

    @Override
    public void completeTask(@NonNull Task completedTask) {

    }

    @Override
    public void activateTask(@NonNull Task activeTask) {

    }

    @Override
    public void clearCompletedTasks() {

    }

    @Override
    public void setFiltering(TasksFilterType requestType) {

    }

    @Override
    public TasksFilterType getFiltering() {
        return mCurrentFiltering;
    }
}
