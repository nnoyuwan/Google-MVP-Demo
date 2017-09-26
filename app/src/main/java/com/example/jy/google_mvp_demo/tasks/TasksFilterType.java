package com.example.jy.google_mvp_demo.tasks;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/9/26 2:00
 * Created by JY
 */

public enum TasksFilterType {
    /**
     * Do not filter tasks.
     */
    ALL_TASKS,

    /**
     * Filters only the active (not completed yet) tasks.
     */
    ACTIVE_TASKS,

    /**
     * Filters only the completed tasks.
     */
    COMPLETED_TASKS
}
