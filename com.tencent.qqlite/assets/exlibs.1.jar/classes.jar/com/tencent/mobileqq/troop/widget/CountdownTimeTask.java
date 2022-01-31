package com.tencent.mobileqq.troop.widget;

import com.tencent.qphone.base.util.QLog;

public class CountdownTimeTask
  implements Runnable
{
  protected static final int a = 100;
  protected static final String a = "CountDownTimeTask";
  protected static final int b = 1000;
  protected static final int c = -1;
  protected long a;
  protected Object a;
  protected Runnable a;
  
  public CountdownTimeTask(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    a(1000L);
  }
  
  public CountdownTimeTask(Runnable paramRunnable, int paramInt)
  {
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    a(paramInt);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Long);
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CountDownTimeTask", 2, "resetTimer: " + paramLong);
      }
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
  }
  
  public void b()
  {
    a(-1L);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/mobileqq/troop/widget/CountdownTimeTask:jdField_a_of_type_Long	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifle +92 -> 98
    //   9: ldc2_w 70
    //   12: invokestatic 76	java/lang/Thread:sleep	(J)V
    //   15: aload_0
    //   16: getfield 30	com/tencent/mobileqq/troop/widget/CountdownTimeTask:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 28	com/tencent/mobileqq/troop/widget/CountdownTimeTask:jdField_a_of_type_Long	J
    //   27: ldc2_w 70
    //   30: lsub
    //   31: putfield 28	com/tencent/mobileqq/troop/widget/CountdownTimeTask:jdField_a_of_type_Long	J
    //   34: aload_1
    //   35: monitorexit
    //   36: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq -39 -> 0
    //   42: ldc 12
    //   44: iconst_2
    //   45: new 46	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   52: ldc 78
    //   54: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: getfield 28	com/tencent/mobileqq/troop/widget/CountdownTimeTask:jdField_a_of_type_Long	J
    //   61: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: goto -70 -> 0
    //   73: astore_1
    //   74: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -77 -> 0
    //   80: ldc 12
    //   82: iconst_2
    //   83: aload_1
    //   84: invokestatic 82	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   87: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: goto -90 -> 0
    //   93: astore_2
    //   94: aload_1
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    //   98: aload_0
    //   99: getfield 28	com/tencent/mobileqq/troop/widget/CountdownTimeTask:jdField_a_of_type_Long	J
    //   102: ldc2_w 65
    //   105: lcmp
    //   106: ifeq +19 -> 125
    //   109: aload_0
    //   110: getfield 32	com/tencent/mobileqq/troop/widget/CountdownTimeTask:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   113: ifnull +12 -> 125
    //   116: aload_0
    //   117: getfield 32	com/tencent/mobileqq/troop/widget/CountdownTimeTask:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   120: invokeinterface 84 1 0
    //   125: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	CountdownTimeTask
    //   73	22	1	localInterruptedException	java.lang.InterruptedException
    //   93	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	73	java/lang/InterruptedException
    //   36	70	73	java/lang/InterruptedException
    //   96	98	73	java/lang/InterruptedException
    //   22	36	93	finally
    //   94	96	93	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.CountdownTimeTask
 * JD-Core Version:    0.7.0.1
 */