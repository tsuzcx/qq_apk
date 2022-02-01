package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import aqgo;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$26
  implements JSContext.Callback
{
  TaskManager$26(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
    throws Throwable
  {
    return new String(aqgo.decode((String)paramArrayOfObject[0], 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.26
 * JD-Core Version:    0.7.0.1
 */