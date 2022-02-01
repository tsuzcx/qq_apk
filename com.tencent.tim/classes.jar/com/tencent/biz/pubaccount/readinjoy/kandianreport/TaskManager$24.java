package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TaskManager$24
  implements JSContext.Callback
{
  TaskManager$24(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
    throws Throwable
  {
    double d = ((Double)paramArrayOfObject[0]).doubleValue();
    paramJSContext = (String)paramArrayOfObject[1];
    String str = (String)paramArrayOfObject[2];
    paramArrayOfObject = (String)paramArrayOfObject[3];
    if (d != 0.0D) {
      if (d != 1.0D) {}
    }
    for (;;)
    {
      return Integer.valueOf(0);
      ThreadManager.getUIHandler().post(new TaskManager.24.1(this, paramJSContext, str, paramArrayOfObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.24
 * JD-Core Version:    0.7.0.1
 */