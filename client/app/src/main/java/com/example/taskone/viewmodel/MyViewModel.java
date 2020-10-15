package com.example.taskone.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskone.tasks.AndroidIdFromDexTask;
import com.example.taskone.tasks.DownloadFileTask;
import com.example.taskone.tasks.LongRunningTask;
import com.example.taskone.tasks.TaskRunner;

import java.io.File;

public class MyViewModel {

    private MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    public LiveData<String> getNumber() {

        return mutableLiveData;
    }

    public void sendRequest(String... params) {
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.executeAsync(new LongRunningTask(params), (data) -> {
            // MyActivity activity = activityReference.get();
            // activity.progressBar.setVisibility(View.GONE);
            // populateData(activity, data) ;

            mutableLiveData.setValue(data.toString());

        });
    }

    public void downloadFile(File fileDir, Context context) {
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.executeAsync(new DownloadFileTask(fileDir, "lib.dex"), (filePathName) -> {
            taskRunner.executeAsync(new AndroidIdFromDexTask(context, filePathName), (androidId) -> {
                mutableLiveData.setValue(androidId);
            });
        });
    }
}
