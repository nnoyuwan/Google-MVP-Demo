package com.example.jy.google_mvp_demo.tasks;

import android.support.v4.app.Fragment;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/9/26 1:51
 * Created by JY
 */

public class TasksFragment extends Fragment implements TasksContract.View{

    public static TasksFragment newInstance() {
        return new TasksFragment();
    }

    @Override
    public void setPresenter(TasksContract.Presenter presenter) {

    }
}
