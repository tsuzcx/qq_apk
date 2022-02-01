package com.tencent.mobileqq.msf.core.push;

import android.os.Handler;

class h
  extends Handler
{
  h(g paramg) {}
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 22	android/os/Message:what	I
    //   6: istore_2
    //   7: iload_2
    //   8: tableswitch	default:+20 -> 28, 1:+23->31
    //   29: monitorexit
    //   30: return
    //   31: aload_1
    //   32: getfield 26	android/os/Message:obj	Ljava/lang/Object;
    //   35: checkcast 28	java/lang/Boolean
    //   38: invokevirtual 32	java/lang/Boolean:booleanValue	()Z
    //   41: istore_3
    //   42: aload_0
    //   43: getfield 10	com/tencent/mobileqq/msf/core/push/h:a	Lcom/tencent/mobileqq/msf/core/push/g;
    //   46: iload_3
    //   47: invokevirtual 37	com/tencent/mobileqq/msf/core/push/g:a	(Z)V
    //   50: goto -22 -> 28
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	h
    //   0	58	1	paramMessage	android.os.Message
    //   6	2	2	i	int
    //   41	6	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	53	finally
    //   31	50	53	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.h
 * JD-Core Version:    0.7.0.1
 */