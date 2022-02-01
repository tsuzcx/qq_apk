package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import kbp;
import org.json.JSONObject;

class TaskManager$21
  implements JSContext.Callback
{
  TaskManager$21(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramJSContext = (String)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("version", TaskManager.scriptVersion + "");
    localJSONObject.put("info", paramArrayOfObject);
    kbp.a(null, "", paramJSContext, paramJSContext, 0, 0, "", "", "", localJSONObject.toString(), false);
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.21
 * JD-Core Version:    0.7.0.1
 */