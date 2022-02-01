package com.tencent.superplayer.api;

import android.content.Context;
import java.util.Map;

public abstract interface ISPBandwidthMonitor
{
  public static final long DEFAULE_INTERVAL = 60000L;
  public static final long ONE_MINUTE = 60000L;
  public static final long ONE_SECOND = 1000L;
  
  public abstract void start(Context paramContext, Callback paramCallback, long paramLong);
  
  public abstract void stop(Context paramContext);
  
  public static abstract interface Callback
  {
    public abstract void onBandwidthUpdate(Map<String, ISPBandwidthMonitor.Stat> paramMap);
  }
  
  public static class Stat
  {
    public long httpBandwidth;
    public long p2pBandwidth;
    public long pcdnBandwidth;
    
    public static Stat diff(Stat paramStat1, Stat paramStat2)
    {
      Stat localStat = new Stat();
      paramStat2.httpBandwidth -= paramStat1.httpBandwidth;
      paramStat2.pcdnBandwidth -= paramStat1.pcdnBandwidth;
      paramStat2.p2pBandwidth -= paramStat1.p2pBandwidth;
      return localStat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPBandwidthMonitor
 * JD-Core Version:    0.7.0.1
 */