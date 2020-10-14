package com.example.taskone.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskone.tasks.LongRunningTask;
import com.example.taskone.tasks.TaskRunner;

public class MyViewModel {

    private MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

    public LiveData<Integer> getNumber() {

        return mutableLiveData;
    }

    public void sendRequest(String... params) {
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.executeAsync(new LongRunningTask(params), (data) -> {
            // MyActivity activity = activityReference.get();
            // activity.progressBar.setVisibility(View.GONE);
            // populateData(activity, data) ;

            mutableLiveData.setValue(data);

        });
    }
}
