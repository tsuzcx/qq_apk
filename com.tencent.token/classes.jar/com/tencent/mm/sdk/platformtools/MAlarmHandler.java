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
  private static Map ah = new HashMap();
  private static MAlarmHandler.IBumper aj;
  private static boolean ak = false;
  private final int ad;
  private final boolean ae;
  private long af = 0L;
  private long ag = 0L;
  private final MAlarmHandler.CallBack ai;
  
  public MAlarmHandler(MAlarmHandler.CallBack paramCallBack, boolean paramBoolean)
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
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new HashSet();
    ((Set)localObject).addAll(ah.keySet());
    localObject = ((Set)localObject).iterator();
    long l1 = 9223372036854775807L;
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      MAlarmHandler localMAlarmHandler = (MAlarmHandler)ah.get(localInteger);
      if (localMAlarmHandler == null) {
        break label263;
      }
      long l3 = Util.ticksToNow(localMAlarmHandler.af);
      long l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      if (l2 > localMAlarmHandler.ag)
      {
        if ((!localMAlarmHandler.ai.onTimerExpired()) || (!localMAlarmHandler.ae)) {
          localLinkedList.add(localInteger);
        }
        for (;;)
        {
          localMAlarmHandler.af = Util.currentTicks();
          break;
          l1 = localMAlarmHandler.ag;
        }
      }
      if (localMAlarmHandler.ag - l2 >= l1) {
        break label263;
      }
      l1 = localMAlarmHandler.ag - l2;
    }
    label263:
    for (;;)
    {
      break;
      int i = 0;
      while (i < localLinkedList.size())
      {
        ah.remove(localLinkedList.get(i));
        i += 1;
      }
      if ((l1 == 9223372036854775807L) && (aj != null))
      {
        aj.cancel();
        Log.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
      }
      return l1;
    }
  }
  
  public static void initAlarmBumper(MAlarmHandler.IBumper paramIBumper)
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
    Log.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + l3);
    Iterator localIterator = ah.entrySet().iterator();
    paramLong = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      MAlarmHandler localMAlarmHandler = (MAlarmHandler)((Map.Entry)localIterator.next()).getValue();
      if (localMAlarmHandler == null) {
        break label224;
      }
      long l2 = Util.ticksToNow(localMAlarmHandler.af);
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      if (l1 > localMAlarmHandler.ag)
      {
        paramLong = localMAlarmHandler.ag;
      }
      else
      {
        if (localMAlarmHandler.ag - l1 >= paramLong) {
          break label224;
        }
        paramLong = localMAlarmHandler.ag - l1;
      }
    }
    label224:
    for (;;)
    {
      break;
      if (paramLong > l3) {}
      for (int i = 1;; i = 0)
      {
        stopTimer();
        ah.put(Integer.valueOf(this.ad), this);
        if ((aj != null) && (i != 0))
        {
          Log.v("MicroMsg.MAlarmHandler", "prepare bumper");
          aj.prepare();
        }
        return;
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MAlarmHandler
 * JD-Core Version:    0.7.0.1
 */