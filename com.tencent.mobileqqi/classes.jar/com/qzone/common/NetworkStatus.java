package com.qzone.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.qzone.download.DownloaderFactory;
import com.qzone.utils.NetworkUtil;
import com.qzone.utils.NetworkUtil.DNS;
import com.qzone.utils.thread.ThreadPool;
import com.qzone.utils.thread.ThreadPool.Job;
import com.qzone.utils.thread.ThreadPool.JobContext;

public class NetworkStatus
{
  private static volatile NetworkStatus sInstance;
  private final Context mContext;
  private NetworkUtil.DNS mDNS;
  
  private NetworkStatus(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    init();
  }
  
  public static NetworkStatus getInstance(Context paramContext)
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance != null)
      {
        paramContext = sInstance;
        return paramContext;
      }
    }
    finally {}
    paramContext = new NetworkStatus(paramContext);
    sInstance = paramContext;
    return paramContext;
  }
  
  private void init()
  {
    refreshDNS();
    BroadcastReceiver local1 = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousIntent.getAction())) {
          DownloaderFactory.getGlobalThreadPool().submit(new ThreadPool.Job()
          {
            public Object run(ThreadPool.JobContext paramAnonymous2JobContext)
            {
              NetworkStatus.this.refreshDNS();
              return null;
            }
          });
        }
      }
    };
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.mContext.registerReceiver(local1, localIntentFilter);
  }
  
  private void refreshDNS()
  {
    try
    {
      this.mDNS = NetworkUtil.getDNS(this.mContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public NetworkUtil.DNS getDNS()
  {
    return this.mDNS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.NetworkStatus
 * JD-Core Version:    0.7.0.1
 */