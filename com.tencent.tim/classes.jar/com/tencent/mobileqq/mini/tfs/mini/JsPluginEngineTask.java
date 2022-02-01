package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import java.util.Iterator;
import java.util.List;

public class JsPluginEngineTask
  extends AsyncTask
{
  public List<IJsPlugin> pluginList;
  
  public JsPluginEngineTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void executeAsync()
  {
    if ((this.pluginList == null) || (this.pluginList.size() <= 0)) {
      this.pluginList = JsPluginEngine.initJsPluginList();
    }
    Object localObject = getDependTasks();
    BaseTask localBaseTask;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localBaseTask = (BaseTask)((Iterator)localObject).next();
      } while (!(localBaseTask instanceof MiniTask.RuntimeCreateTask));
    }
    for (localObject = ((MiniTask.RuntimeCreateTask)localBaseTask).getRuntimeContainer().getEmptyAppRuntime();; localObject = null)
    {
      if (localObject != null) {
        ((AppBrandRuntime)localObject).setPluginList(this.pluginList);
      }
      onTaskSucceed();
      return;
    }
  }
  
  public void reset()
  {
    super.reset();
    if (this.pluginList != null) {
      this.pluginList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.JsPluginEngineTask
 * JD-Core Version:    0.7.0.1
 */