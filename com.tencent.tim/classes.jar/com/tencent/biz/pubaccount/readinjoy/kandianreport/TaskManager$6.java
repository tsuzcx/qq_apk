package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class TaskManager$6
  implements Runnable
{
  TaskManager$6(TaskManager paramTaskManager, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      Task localTask;
      Object localObject2;
      synchronized (this.this$0)
      {
        if (TaskManager.access$200(this.this$0).size() == 0) {
          return;
        }
        Iterator localIterator1 = TaskManager.access$200(this.this$0).iterator();
        continue;
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        localTask = (Task)localIterator1.next();
        if (localTask.status != Task.STATUS_ACCEPT) {
          break label583;
        }
        Iterator localIterator2 = localTask.filter.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        localObject2 = (Task.CONFIG_ITEM)localIterator2.next();
        if ((TextUtils.isEmpty(((Task.CONFIG_ITEM)localObject2).value)) || (TextUtils.isEmpty(this.val$data))) {
          continue;
        }
        boolean bool = this.val$data.contains(((Task.CONFIG_ITEM)localObject2).value);
        if (!bool) {
          continue;
        }
      }
      try
      {
        localObject2 = TaskManager.access$300(this.this$0, localTask.filter, ((Task.CONFIG_ITEM)localObject2).value);
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          continue;
        }
        localObject2 = TaskManager.access$400(this.this$0, localTask.extraction, (ArrayList)localObject2);
        if ((localObject2 == null) || (localObject2.length <= 0)) {
          continue;
        }
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject2[i];
          Object localObject4 = TaskManager.access$500(this.this$0, localTask.extraction, (String)localObject3);
          localObject4 = (String)localObject3 + "('" + this.val$data + "'," + TaskManager.access$600(this.this$0, (ArrayList)localObject4) + ")";
          if (localTask.jsContext != null)
          {
            localObject3 = new StringBuffer();
            localObject4 = ((String)localObject4).replaceAll("\"", "\\\\\"");
            localTask.jsContext.evaluteStringWithException((String)localObject4, (StringBuffer)localObject3);
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              this.this$0.markTaskFail(localTask);
              QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + (String)localObject4 + " " + localObject3);
              TaskException.reportException(localTask.id, "evaluate js exception: " + (String)localObject4 + " " + localObject3);
              return;
              localObject1 = finally;
              throw localObject1;
            }
          }
          i += 1;
        }
      }
      catch (Exception localException)
      {
        this.this$0.markTaskFail(localTask);
        QLog.d("kandianreport.taskmanager", 1, "accept unexpected exception: " + localException.getMessage());
        TaskException.reportException(localTask.id, "accept unexpected exception: " + localException.getMessage());
      }
      catch (Error localError)
      {
        this.this$0.markTaskFail(localTask);
        QLog.d("kandianreport.taskmanager", 1, "accept unexpected error: " + localError.getMessage());
        TaskException.reportException(localTask.id, "accept unexpected error: " + localError.getMessage());
      }
      continue;
      label583:
      QLog.d("kandianreport.taskmanager", 2, localTask.id + " not accept status is " + localTask.status);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.6
 * JD-Core Version:    0.7.0.1
 */