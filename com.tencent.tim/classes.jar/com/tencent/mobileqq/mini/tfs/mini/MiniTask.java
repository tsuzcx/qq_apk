package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.tfs.AsyncTask;

public class MiniTask
{
  public static class RuntimeContainerInitTask
    extends AsyncTask
  {
    private AppBrandRuntimeContainer mRuntimeContainer;
    
    public RuntimeContainerInitTask(Context paramContext, AppBrandRuntimeContainer paramAppBrandRuntimeContainer)
    {
      super();
      this.mRuntimeContainer = paramAppBrandRuntimeContainer;
    }
    
    public void executeAsync()
    {
      this.mRuntimeContainer.initDebugUI();
      onTaskSucceed();
    }
  }
  
  public static class RuntimeCreateTask
    extends AsyncTask
  {
    private AppBrandRuntimeContainer mRuntimeContainer;
    
    public RuntimeCreateTask(Context paramContext, AppBrandRuntimeContainer paramAppBrandRuntimeContainer)
    {
      super();
      this.mRuntimeContainer = paramAppBrandRuntimeContainer;
    }
    
    public void executeAsync()
    {
      this.mRuntimeContainer.preloadEmptyRuntime();
      onTaskSucceed();
    }
    
    public AppBrandRuntimeContainer getRuntimeContainer()
    {
      return this.mRuntimeContainer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.MiniTask
 * JD-Core Version:    0.7.0.1
 */