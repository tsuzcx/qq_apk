package com.tribe.async.async;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.SparseArray;
import com.tribe.async.log.SLog;
import java.util.concurrent.TimeUnit;

public abstract interface ExecutorConfig
{
  public static final String TAG = "ExecutorConfig";
  
  public abstract int getAliveTime();
  
  public abstract int getCore();
  
  public abstract int getMaximum();
  
  public abstract TimeUnit getTimeUnit();
  
  public static class CpuExecutorConfig
    implements ExecutorConfig
  {
    public int getAliveTime()
    {
      return 10000;
    }
    
    public int getCore()
    {
      int i = Runtime.getRuntime().availableProcessors() + 1;
      SLog.d("ExecutorConfig", "cpu core = " + i);
      return i;
    }
    
    public int getMaximum()
    {
      int i = Runtime.getRuntime().availableProcessors() * 2 + 1;
      SLog.d("ExecutorConfig", "cpu max = " + i);
      return i;
    }
    
    public TimeUnit getTimeUnit()
    {
      return TimeUnit.MILLISECONDS;
    }
  }
  
  public static class NetworkExecutorConfig
    implements ExecutorConfig
  {
    private static final int DEFAULT_THREAD_COUNT = 3;
    private static final int NETWORK_TYPE_2G = 4;
    private static final int NETWORK_TYPE_3G = 3;
    private static final int NETWORK_TYPE_4G = 2;
    private static final int NETWORK_TYPE_UNKNOWN = 5;
    private static final int NETWORK_TYPE_WIFI = 1;
    private static final int NO_NETWORK = 0;
    private static final SparseArray<Integer> sThreadCountMap = new SparseArray(6);
    private Context mApplication;
    private NetworkInfo mNetworkInfo;
    
    static
    {
      sThreadCountMap.append(0, Integer.valueOf(3));
      sThreadCountMap.append(1, Integer.valueOf(5));
      sThreadCountMap.append(2, Integer.valueOf(4));
      sThreadCountMap.append(3, Integer.valueOf(3));
      sThreadCountMap.append(4, Integer.valueOf(2));
      sThreadCountMap.append(5, Integer.valueOf(3));
    }
    
    public NetworkExecutorConfig(Context paramContext)
    {
      this.mApplication = paramContext;
    }
    
    private static int getCurrentNetType(NetworkInfo paramNetworkInfo)
    {
      if ((paramNetworkInfo == null) || (!paramNetworkInfo.isConnectedOrConnecting())) {
        return 0;
      }
      switch (paramNetworkInfo.getType())
      {
      default: 
        return 5;
      case 0: 
        switch (paramNetworkInfo.getSubtype())
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        default: 
          return 5;
        case 1: 
        case 2: 
          return 4;
        }
        break;
      }
      return 1;
      return 2;
      return 3;
    }
    
    private int getThreadCount(NetworkInfo paramNetworkInfo)
    {
      return ((Integer)sThreadCountMap.get(getCurrentNetType(paramNetworkInfo))).intValue();
    }
    
    public int getAliveTime()
    {
      return 15000;
    }
    
    public int getCore()
    {
      this.mNetworkInfo = ((ConnectivityManager)this.mApplication.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = getThreadCount(this.mNetworkInfo);
      SLog.d("ExecutorConfig", "network core = " + i);
      return i;
    }
    
    public int getMaximum()
    {
      int i = getCore() * 2;
      SLog.d("ExecutorConfig", "network max = " + i);
      return i;
    }
    
    public TimeUnit getTimeUnit()
    {
      return TimeUnit.MILLISECONDS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.async.ExecutorConfig
 * JD-Core Version:    0.7.0.1
 */