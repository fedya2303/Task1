package com.example.taskone.tasks;

import android.content.Context;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

import dalvik.system.DexClassLoader;

public class AndroidIdFromDexTask implements Callable<String> {

    private Context context;
    private String filePathName;

    public AndroidIdFromDexTask(Context context, String filePathName) {
        this.context = context;
        this.filePathName = filePathName;
    }

    @Override
    public String call() throws Exception {
        DexClassLoader dexClassLoader =
                new DexClassLoader(filePathName, context.getDir("outdex", Context.MODE_PRIVATE).getAbsolutePath(), null, context.getClassLoader());
        Class<?> androidIdManager = dexClassLoader.loadClass("AndroidIdManager");
        Method getAndroidId = androidIdManager.getMethod("getAndroidId", Context.class);
        Object result = getAndroidId.invoke(androidIdManager.newInstance(), context);
        return (String) result;
    }
}
