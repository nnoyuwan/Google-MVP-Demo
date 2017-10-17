package com.example.jy.google_mvp_demo.addedittask;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import data.Task;
import data.source.TasksDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/10/17 14:25
 * Created by JY
 */

public class AddEditTaskPresenter implements AddEditTaskContract.Presenter,TasksDataSource.GetTaskCallback{

    @NonNull
    private final TasksDataSource mTasksRepository;

    @NonNull
    private final AddEditTaskContract.View mAddTaskView;

    @Nullable
    private String mTaskId;

    private boolean mIsDataMissing;

    /**
     * Creates a presenter for the add/edit view.
     *
     * @param taskId ID of the task to edit or null for a new task
     * @param tasksRepository a repository of data for tasks
     * @param addTaskView the add/edit view
     * @param shouldLoadDataFromRepo whether data needs to be loaded or not (for config changes)
     */
    public AddEditTaskPresenter(@Nullable String taskId, @NonNull TasksDataSource tasksRepository,
                                @NonNull AddEditTaskContract.View addTaskView, boolean shouldLoadDataFromRepo) {
        mTaskId = taskId;
        mTasksRepository = checkNotNull(tasksRepository);
        mAddTaskView = checkNotNull(addTaskView);
        mIsDataMissing = shouldLoadDataFromRepo;

        mAddTaskView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void saveTask(String title, String description) {

    }

    @Override
    public void populateTask() {

    }

    @Override
    public boolean isDataMissing() {
        return false;
    }

    @Override
    public void onTaskLoaded(Task task) {

    }

    @Override
    public void onDataNotAvailable() {

    }
}
