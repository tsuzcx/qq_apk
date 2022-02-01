package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public class MAlarmHandler
{
  public static final long NEXT_FIRE_INTERVAL = 9223372036854775807L;
  private static int ac;
  private static Map<Integer, MAlarmHandler> ah = new HashMap();
  private static IBumper aj;
  private static boolean ak = false;
  private final int ad;
  private final boolean ae;
  private long af = 0L;
  private long ag = 0L;
  private final CallBack ai;
  
  public MAlarmHandler(CallBack paramCallBack, boolean paramBoolean)
  {
    Assert.assertTrue("bumper not initialized", ak);
    this.ai = paramCallBack;
    this.ae = paramBoolean;
    if (ac >= 8192) {
      ac = 0;
    }
    int i = ac + 1;
    ac = i;
    this.ad = i;
  }
  
  public static long fire()
  {
    Object localObject1 = new LinkedList();
    Object localObject2 = new HashSet();
    ((Set)localObject2).addAll(ah.keySet());
    localObject2 = ((Set)localObject2).iterator();
    long l1 = 9223372036854775807L;
    while (((Iterator)localObject2).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject2).next();
      MAlarmHandler localMAlarmHandler = (MAlarmHandler)ah.get(localInteger);
      if (localMAlarmHandler != null)
      {
        long l3 = Util.ticksToNow(localMAlarmHandler.af);
        long l2 = l3;
        if (l3 < 0L) {
          l2 = 0L;
        }
        l3 = localMAlarmHandler.ag;
        if (l2 > l3)
        {
          if ((localMAlarmHandler.ai.onTimerExpired()) && (localMAlarmHandler.ae)) {
            l1 = localMAlarmHandler.ag;
          } else {
            ((List)localObject1).add(localInteger);
          }
          localMAlarmHandler.af = Util.currentTicks();
        }
        else if (l3 - l2 < l1)
        {
          l1 = l3 - l2;
        }
      }
    }
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      ah.remove(((List)localObject1).get(i));
      i += 1;
    }
    if (l1 == 9223372036854775807L)
    {
      localObject1 = aj;
      if (localObject1 != null)
      {
        ((IBumper)localObject1).cancel();
        Log.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
    }
    return l1;
  }
  
  public static void initAlarmBumper(IBumper paramIBumper)
  {
    ak = true;
    aj = paramIBumper;
  }
  
  protected void finalize()
  {
    stopTimer();
    super.finalize();
  }
  
  public void startTimer(long paramLong)
  {
    this.ag = paramLong;
    this.af = Util.currentTicks();
    long l3 = this.ag;
    Object localObject = new StringBuilder("check need prepare: check=");
    ((StringBuilder)localObject).append(l3);
    Log.d("MicroMsg.MAlarmHandler", ((StringBuilder)localObject).toString());
    localObject = ah.entrySet().iterator();
    paramLong = 9223372036854775807L;
    label163:
    while (((Iterator)localObject).hasNext())
    {
      MAlarmHandler localMAlarmHandler = (MAlarmHandler)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localMAlarmHandler != null)
      {
        long l2 = Util.ticksToNow(localMAlarmHandler.af);
        long l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        l2 = localMAlarmHandler.ag;
        if (l1 > l2) {}
        for (paramLong = l2;; paramLong = l2 - l1)
        {
          break;
          if (l2 - l1 >= paramLong) {
            break label163;
          }
        }
      }
    }
    int i;
    if (paramLong > l3) {
      i = 1;
    } else {
      i = 0;
    }
    stopTimer();
    ah.put(Integer.valueOf(this.ad), this);
    if ((aj != null) && (i != 0))
    {
      Log.v("MicroMsg.MAlarmHandler", "prepare bumper");
      aj.prepare();
    }
  }
  
  public void stopTimer()
  {
    ah.remove(Integer.valueOf(this.ad));
  }
  
  public boolean stopped()
  {
    return !ah.containsKey(Integer.valueOf(this.ad));
  }
  
  public static abstract interface CallBack
  {
    public abstract boolean onTimerExpired();
  }
  
  public static abstract interface IBumper
  {
    public abstract void cancel();
    
    public abstract void prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MAlarmHandler
 * JD-Core Version:    0.7.0.1
 */