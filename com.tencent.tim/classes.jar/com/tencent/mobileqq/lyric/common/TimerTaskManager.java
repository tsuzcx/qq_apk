package com.tencent.mobileqq.lyric.common;

import acfp;
import aiwl;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTaskManager
{
  private ScheduledThreadPoolExecutor e;
  private Map<String, a> lD = new HashMap();
  
  public TimerTaskManager()
  {
    dve();
  }
  
  private void dve()
  {
    if (this.e == null) {
      this.e = new aiwl(this, 1);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, TimerTaskRunnable paramTimerTaskRunnable)
  {
    try
    {
      Log.i("LyricTimerTaskManager", String.format("schedule begin [%s].", new Object[] { paramString }));
      if (paramString == null) {
        throw new IllegalArgumentException(acfp.m(2131715349));
      }
    }
    finally {}
    if ((paramLong1 < 0L) || (paramLong2 <= 0L)) {
      throw new IllegalArgumentException(acfp.m(2131715347));
    }
    if (paramTimerTaskRunnable == null) {
      throw new IllegalArgumentException(acfp.m(2131715348));
    }
    dve();
    if (this.lD.containsKey(paramString))
    {
      Log.i("LyricTimerTaskManager", String.format("schedule -> cancel duplication of name[%s].", new Object[] { paramString }));
      cancel(paramString);
    }
    Log.i("LyricTimerTaskManager", String.format("schedule -> create new Task [%s][period : %d].", new Object[] { paramString, Long.valueOf(paramLong2) }));
    paramTimerTaskRunnable = a.a(paramTimerTaskRunnable);
    a.a(paramTimerTaskRunnable, paramLong2);
    a.a(paramTimerTaskRunnable, paramString);
    a.a(paramTimerTaskRunnable, this.e.scheduleWithFixedDelay(a.a(paramTimerTaskRunnable), paramLong1, paramLong2, TimeUnit.MILLISECONDS));
    this.lD.put(paramString, paramTimerTaskRunnable);
    Log.i("LyricTimerTaskManager", String.format("schedule end [%s].", new Object[] { paramString }));
  }
  
  /* Error */
  public void cancel(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/mobileqq/lyric/common/TimerTaskManager:lD	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 122 2 0
    //   12: checkcast 9	com/tencent/mobileqq/lyric/common/TimerTaskManager$a
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +128 -> 145
    //   20: ldc 38
    //   22: ldc 124
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: invokestatic 46	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokestatic 52	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aload_3
    //   40: invokestatic 127	com/tencent/mobileqq/lyric/common/TimerTaskManager$a:a	(Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$a;)Ljava/util/concurrent/ScheduledFuture;
    //   43: ifnull +14 -> 57
    //   46: aload_3
    //   47: invokestatic 127	com/tencent/mobileqq/lyric/common/TimerTaskManager$a:a	(Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$a;)Ljava/util/concurrent/ScheduledFuture;
    //   50: iconst_1
    //   51: invokeinterface 132 2 0
    //   56: pop
    //   57: aload_0
    //   58: getfield 30	com/tencent/mobileqq/lyric/common/TimerTaskManager:e	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   61: aload_3
    //   62: invokestatic 97	com/tencent/mobileqq/lyric/common/TimerTaskManager$a:a	(Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$a;)Ljava/lang/Runnable;
    //   65: invokevirtual 136	java/util/concurrent/ScheduledThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   68: istore_2
    //   69: aload_0
    //   70: getfield 30	com/tencent/mobileqq/lyric/common/TimerTaskManager:e	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   73: invokevirtual 139	java/util/concurrent/ScheduledThreadPoolExecutor:purge	()V
    //   76: ldc 38
    //   78: new 141	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   85: ldc 144
    //   87: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_2
    //   91: invokevirtual 151	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: ldc 153
    //   96: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 30	com/tencent/mobileqq/lyric/common/TimerTaskManager:e	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   103: invokevirtual 157	java/util/concurrent/ScheduledThreadPoolExecutor:toString	()Ljava/lang/String;
    //   106: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 161	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aload_3
    //   117: invokestatic 164	com/tencent/mobileqq/lyric/common/TimerTaskManager$a:a	(Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$a;)Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;
    //   120: iconst_0
    //   121: invokestatic 167	com/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable:a	(Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;Z)Z
    //   124: pop
    //   125: aload_3
    //   126: aconst_null
    //   127: invokestatic 170	com/tencent/mobileqq/lyric/common/TimerTaskManager$a:a	(Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$a;Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;)Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;
    //   130: pop
    //   131: aload_0
    //   132: getfield 24	com/tencent/mobileqq/lyric/common/TimerTaskManager:lD	Ljava/util/Map;
    //   135: aload_1
    //   136: invokeinterface 172 2 0
    //   141: pop
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: ldc 38
    //   147: ldc 174
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_1
    //   156: aastore
    //   157: invokestatic 46	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 52	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   163: pop
    //   164: goto -22 -> 142
    //   167: astore_1
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	TimerTaskManager
    //   0	172	1	paramString	String
    //   68	23	2	bool	boolean
    //   15	111	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	16	167	finally
    //   20	57	167	finally
    //   57	142	167	finally
    //   145	164	167	finally
  }
  
  public static abstract class TimerTaskRunnable
    implements Runnable
  {
    private boolean Zm;
    
    public abstract void bkR();
    
    public boolean isCancelled()
    {
      return !this.Zm;
    }
    
    public final void run()
    {
      if (this.Zm) {
        bkR();
      }
    }
  }
  
  static class a
  {
    private TimerTaskManager.TimerTaskRunnable jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable;
    private ScheduledFuture<?> jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
    private String bPP;
    private Runnable gV = new TimerTaskManager.InternalTaskEntry.1(this);
    private long mPeriod = -9223372036854775808L;
    
    public static a a(TimerTaskManager.TimerTaskRunnable paramTimerTaskRunnable)
    {
      a locala = new a();
      TimerTaskManager.TimerTaskRunnable.a(paramTimerTaskRunnable, true);
      locala.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable = paramTimerTaskRunnable;
      return locala;
    }
    
    public String toString()
    {
      boolean bool2 = false;
      long l = this.mPeriod;
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable != null)
      {
        bool1 = bool2;
        if (TimerTaskManager.TimerTaskRunnable.a(this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable)) {
          bool1 = true;
        }
      }
      return String.format("Period = %d; IsValid = %b;", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.common.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */