package com.tencent.mobileqq.msf.core.push;

class i
  extends Thread
{
  i(g paramg) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 23	com/tencent/mobileqq/msf/core/a/a:D	()J
    //   3: lstore_1
    //   4: lload_1
    //   5: lconst_0
    //   6: lcmp
    //   7: ifle +7 -> 14
    //   10: lload_1
    //   11: invokestatic 27	java/lang/Thread:sleep	(J)V
    //   14: invokestatic 33	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isNetSupport	()Z
    //   17: ifeq +25 -> 42
    //   20: aload_0
    //   21: getfield 10	com/tencent/mobileqq/msf/core/push/i:a	Lcom/tencent/mobileqq/msf/core/push/g;
    //   24: getfield 39	com/tencent/mobileqq/msf/core/push/g:y	Ljava/lang/Object;
    //   27: astore_3
    //   28: aload_3
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 10	com/tencent/mobileqq/msf/core/push/i:a	Lcom/tencent/mobileqq/msf/core/push/g;
    //   34: getfield 39	com/tencent/mobileqq/msf/core/push/g:y	Ljava/lang/Object;
    //   37: invokevirtual 44	java/lang/Object:notify	()V
    //   40: aload_3
    //   41: monitorexit
    //   42: return
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 47	java/lang/InterruptedException:printStackTrace	()V
    //   48: goto -34 -> 14
    //   51: astore 4
    //   53: aload_3
    //   54: monitorexit
    //   55: aload 4
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	i
    //   3	8	1	l	long
    //   43	11	3	localInterruptedException	java.lang.InterruptedException
    //   51	5	4	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	4	43	java/lang/InterruptedException
    //   10	14	43	java/lang/InterruptedException
    //   30	42	51	finally
    //   53	55	51	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.i
 * JD-Core Version:    0.7.0.1
 */