package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;

public class HwNetworkCenter
{
  public static final String Tag = "NetworkCenter";
  public static HwNetworkCenter sNC = null;
  private Runnable checkRun = new Runnable()
  {
    public void run()
    {
      HwNetworkCenter.this.onNetChange(HwNetworkCenter.this.mContext);
      HwNetworkCenter.this.mHandler.postDelayed(this, 120000L);
    }
  };
  private String mApnType = "";
  private Context mContext;
  private Handler mHandler;
  private AtomicInteger mNetworkType = new AtomicInteger(0);
  
  protected HwNetworkCenter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mHandler.postDelayed(this.checkRun, 60000L);
  }
  
  public static HwNetworkCenter getInstance(Context paramContext)
  {
    if (sNC == null) {}
    try
    {
      if (sNC == null) {
        sNC = new HwNetworkCenter(paramContext);
      }
      return sNC;
    }
    finally {}
  }
  
  public String getApnType()
  {
    try
    {
      String str = this.mApnType;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getNetType()
  {
    return this.mNetworkType.get();
  }
  
  public void onDestroy()
  {
    this.mContext = null;
  }
  
  public void onNetChange(Context paramContext)
  {
    try
    {
      updateNetInfo(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void updateNetInfo(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = HwNetworkUtil.getSystemNetwork(paramContext);
        this.mNetworkType.set(i);
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        paramContext = null;
        if (localNetworkInfo != null) {
          paramContext = localNetworkInfo.getExtraInfo();
        }
        this.mApnType = BdhUtils.getApnType(paramContext);
      }
      catch (Exception paramContext)
      {
        BdhLogUtil.LogException("N", "UpdateNetInfo Error.", paramContext);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwNetworkCenter
 * JD-Core Version:    0.7.0.1
 */