package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import aqgz;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.common.config.AppSetting;
import org.json.JSONObject;

class TaskManager$15
  implements JSContext.Callback
{
  TaskManager$15(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramJSContext = new JSONObject();
    paramJSContext.put("platform", "Android");
    paramJSContext.put("sys_version", aqgz.getDeviceOSVersion());
    paramJSContext.put("qq_version", aqgz.getQQVersion());
    paramJSContext.put("framework_version", String.valueOf(TaskManager.scriptVersion));
    paramJSContext.putOpt("app_id", Integer.valueOf(AppSetting.getAppId()));
    return paramJSContext.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.15
 * JD-Core Version:    0.7.0.1
 */