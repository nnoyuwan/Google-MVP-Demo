package com.example.jy.google_mvp_demo.tasks;

import android.support.annotation.NonNull;

import com.example.jy.google_mvp_demo.BasePresenter;
import com.example.jy.google_mvp_demo.BaseView;

import data.source.Task;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/9/26 1:51
 * Created by JY
 */

public class TasksContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter{

        void result(int requestCode, int resultCode);

        void loadTasks(boolean forceUpdate);

        void addNewTask();

        void openTaskDetails(@NonNull Task requestedTask);

        void completeTask(@NonNull Task completedTask);

        void activateTask(@NonNull Task activeTask);

        void clearCompletedTasks();

        void setFiltering(TasksFilterType requestType);

        TasksFilterType getFiltering();
    }

}
