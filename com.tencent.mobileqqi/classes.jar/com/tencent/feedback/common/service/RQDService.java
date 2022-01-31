package com.tencent.feedback.common.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.feedback.common.e;
import java.util.concurrent.atomic.AtomicInteger;

public class RQDService
  extends IntentService
{
  protected static AtomicInteger currentPendingNum = new AtomicInteger(0);
  
  public RQDService()
  {
    super("RQDSERVICE");
  }
  
  protected void handleIntent(Intent paramIntent)
  {
    if (!"com.tencent.feedback.10".equals(paramIntent.getAction())) {}
    RQDServiceTask localRQDServiceTask;
    do
    {
      return;
      localRQDServiceTask = a.a(paramIntent);
    } while (localRQDServiceTask == null);
    e.b("handle task %d %s", new Object[] { Integer.valueOf(localRQDServiceTask.getTaskId()), localRQDServiceTask.getTaskName() });
    try
    {
      currentPendingNum.addAndGet(1);
      localRQDServiceTask.runInService(this, paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
      return;
    }
    finally
    {
      currentPendingNum.addAndGet(-1);
      e.b("current pending %d", new Object[] { Integer.valueOf(currentPendingNum.get()) });
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    e.a = true;
    super.onCreate();
  }
  
  public void onDestroy()
  {
    e.b("service destory", new Object[0]);
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    handleIntent(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.common.service.RQDService
 * JD-Core Version:    0.7.0.1
 */