package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;

class TaskManager$19
  implements JSContext.Callback
{
  TaskManager$19(TaskManager paramTaskManager) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramJSContext = (String)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    paramJSContext = ReadInJoyMMapKvStorage.getInstance(TaskManager.access$900(this.this$0, paramJSContext));
    if ((paramJSContext.getExpiredTime() != 0) && (paramJSContext.getExpiredTime() < System.currentTimeMillis() / 1000L))
    {
      paramJSContext.invalidate();
      return Integer.valueOf(0);
    }
    paramJSContext.update(paramArrayOfObject, null);
    return Integer.valueOf(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.19
 * JD-Core Version:    0.7.0.1
 */