package com.huawei.updatesdk.service.d.a;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.huawei.updatesdk.a.b.d.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class c
{
  private static List<AsyncTask> a = new ArrayList();
  
  public static b a(com.huawei.updatesdk.service.a.c paramc, com.huawei.updatesdk.a.b.d.a.a parama)
  {
    parama = new b(paramc, parama);
    a(parama, paramc);
    return parama;
  }
  
  public static List<AsyncTask> a()
  {
    return a;
  }
  
  public static void a(AsyncTask paramAsyncTask)
  {
    int i = a.size() - 1;
    while (i >= 0)
    {
      AsyncTask localAsyncTask = (AsyncTask)a.get(i);
      if ((localAsyncTask.getStatus() == AsyncTask.Status.FINISHED) || (localAsyncTask.isCancelled())) {
        a.remove(paramAsyncTask);
      }
      i -= 1;
    }
    a.add(paramAsyncTask);
  }
  
  private static void a(b paramb, com.huawei.updatesdk.service.a.c paramc)
  {
    com.huawei.updatesdk.a.a.b.a.a.a.a("StoreAgent", "executeTask, ActiveCount:" + d.a.getActiveCount() + ", TaskCount:" + d.a.getTaskCount());
    paramb.a(d.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.d.a.c
 * JD-Core Version:    0.7.0.1
 */