package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$16
  implements JSContext.Callback
{
  TaskManager$16(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramJSContext = (String)paramArrayOfObject[0];
    paramArrayOfObject = (Double)paramArrayOfObject[1];
    paramJSContext = ReadInJoyMMapKvStorage.getInstance(TaskManager.access$900(this.this$0, paramJSContext));
    if (paramArrayOfObject.doubleValue() != -1.0D) {
      paramJSContext.setExpiredTime(paramArrayOfObject.intValue());
    }
    return Integer.valueOf(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.16
 * JD-Core Version:    0.7.0.1
 */