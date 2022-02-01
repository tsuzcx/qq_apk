package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.qphone.base.util.QLog;

class TaskManager$13
  implements JSContext.Callback
{
  TaskManager$13(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
    throws Throwable
  {
    String str = (String)paramArrayOfObject[0];
    QLog.d("kandianreport.taskmanager", 1, "call reportToServer: " + str + " " + paramArrayOfObject[1]);
    TaskManager.access$800(this.this$0, paramJSContext, (String)paramArrayOfObject[0], (String)paramArrayOfObject[1]);
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.13
 * JD-Core Version:    0.7.0.1
 */