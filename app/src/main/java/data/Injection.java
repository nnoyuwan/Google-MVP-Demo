package data;

import android.content.Context;
import android.support.annotation.NonNull;

import data.source.TasksRepository;
import data.source.local.TasksLocalDataSource;
import data.source.remote.FakeTasksRemoteDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * ProjectName:Google-MVP-Demo
 * Date:2017/10/16 18:18
 * Created by JY
 */

public class Injection {
    public static TasksRepository provideTasksRepository(@NonNull Context context){
        checkNotNull(context);
        return TasksRepository.getInstance(FakeTasksRemoteDataSource.getINSTANCE(),
                TasksLocalDataSource.getInstance(context));
    }
}
