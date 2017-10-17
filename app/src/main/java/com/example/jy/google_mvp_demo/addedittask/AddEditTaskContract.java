package com.example.jy.google_mvp_demo.addedittask;

import com.example.jy.google_mvp_demo.BasePresenter;
import com.example.jy.google_mvp_demo.BaseView;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/10/17 15:08
 * Created by JY
 */

public interface AddEditTaskContract {

    interface View extends BaseView<Presenter>{

        void showEmptyTaskError();

        void showTasksList();

        void setTitle(String title);

        void setDescription(String description);

        boolean isActive();
    }

    interface Presenter extends BasePresenter{

        void saveTask(String title, String description);

        void populateTask();

        boolean isDataMissing();
    }
}
