package com.huawei.hms.update.manager;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

public final class a
{
  private static boolean a = false;
  private CountDownLatch b;
  
  public boolean a(long paramLong, TimeUnit paramTimeUnit, String paramString)
  {
    if (a)
    {
      HMSLog.i("PingTask", "ping google return cache");
      return true;
    }
    HMSLog.i("PingTask", "start ping goole");
    this.b = new CountDownLatch(1);
    new a(paramString).execute(new Context[0]);
    try
    {
      if (!this.b.await(paramLong, paramTimeUnit))
      {
        HMSLog.i("PingTask", "await time out");
        return false;
      }
      HMSLog.i("PingTask", "await:isReachable:" + a);
      boolean bool = a;
      return bool;
    }
    catch (InterruptedException paramTimeUnit)
    {
      HMSLog.e("PingTask", "await:InterruptedException:");
    }
    return false;
  }
  
  class a
    extends AsyncTask<Context, Integer, Boolean>
  {
    private String b;
    
    public a(String paramString)
    {
      this.b = paramString;
    }
    
    protected Boolean a(Context... paramVarArgs)
    {
      bool = false;
      try
      {
        paramVarArgs = (HttpsURLConnection)new URL(this.b).openConnection();
        if (paramVarArgs == null) {
          break label138;
        }
        paramVarArgs.setRequestMethod("GET");
        paramVarArgs.setConnectTimeout(30000);
        paramVarArgs.setReadTimeout(30000);
        paramVarArgs.setUseCaches(false);
        paramVarArgs.setInstanceFollowRedirects(true);
        int i = paramVarArgs.getResponseCode();
        HMSLog.i("PingTask", "GET google result:" + i);
        bool = true;
      }
      catch (RuntimeException paramVarArgs)
      {
        for (;;)
        {
          HMSLog.e("PingTask", "GET google result:RuntimeException");
        }
      }
      catch (IOException paramVarArgs)
      {
        for (;;)
        {
          HMSLog.e("PingTask", "GET google result:safe exception");
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          HMSLog.e("PingTask", "GET google result:Exception");
          continue;
          bool = false;
        }
      }
      a.a(bool);
      a.a(a.this).countDown();
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.manager.a
 * JD-Core Version:    0.7.0.1
 */