package com.tencent.mobileqq.app.automator.step;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mqp.app.sec.SecClientInfoTask;
import com.tencent.mqp.app.sec.SecClientInfoTaskEx;
import java.util.HashMap;
import java.util.Random;

public class ReportClientInfo
  extends AsyncStep
{
  private static HashMap<Long, Long> jj = new HashMap();
  private static Object mLock = new Object();
  
  private static boolean bM(long paramLong)
  {
    try
    {
      Long localLong1 = Long.valueOf(System.currentTimeMillis());
      synchronized (mLock)
      {
        if (jj.containsKey(Long.valueOf(paramLong)))
        {
          Long localLong2 = (Long)jj.get(Long.valueOf(paramLong));
          if (localLong1.longValue() - localLong2.longValue() < 43200000L) {
            return false;
          }
        }
        jj.put(Long.valueOf(paramLong), localLong1);
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void g(long paramLong, boolean paramBoolean)
  {
    try
    {
      if (!bM(paramLong)) {
        return;
      }
      int i = new Random().nextInt() & 0x7FFFFFFF;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new SecClientInfoTask(paramLong, 1, i), 10000L);
      int j = new Random().nextInt(50000);
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new SecClientInfoTask(paramLong, 2, i), j + 120000);
      i = new Random().nextInt() & 0x7FFFFFFF;
      j = new Random().nextInt(50000);
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new SecClientInfoTaskEx(paramLong, 1, i), j + 60000);
      Handler localHandler = new Handler(ThreadManager.getSubThreadLooper());
      j = new Random().nextInt(50000);
      localHandler.postDelayed(new SecClientInfoTaskEx(paramLong, 2, i), j + 180000);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int od()
  {
    g(this.a.app.getLongAccountUin(), true);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ReportClientInfo
 * JD-Core Version:    0.7.0.1
 */