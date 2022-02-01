package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class TaskManager$12$1
  extends TimerTask
{
  TaskManager$12$1(TaskManager.12 param12, JSContext paramJSContext, String paramString) {}
  
  public void run()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.val$jsContext != null)
    {
      this.val$jsContext.evaluteStringWithException(this.val$func, localStringBuffer);
      if (!TextUtils.isEmpty(localStringBuffer))
      {
        this.this$1.this$0.markTaskFail(this.this$1.val$task);
        QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + this.val$func + " " + localStringBuffer);
        TaskException.reportException(this.this$1.val$task.id, "evaluate js exception: " + this.val$func + " " + localStringBuffer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.12.1
 * JD-Core Version:    0.7.0.1
 */