package com.tencent.mobileqq.intervideo.groupvideo;

import aicu;
import android.os.Bundle;
import java.util.concurrent.Future;

public class GroupVideoManager$3
  implements Runnable
{
  public GroupVideoManager$3(aicu paramaicu, Future paramFuture, long paramLong, Bundle paramBundle) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:g	Ljava/util/concurrent/Future;
    //   4: ldc2_w 32
    //   7: getstatic 39	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   10: invokeinterface 45 4 0
    //   15: checkcast 47	aibz
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +45 -> 65
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 18	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Laicu;
    //   28: invokestatic 53	aicu:a	(Laicu;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   34: aload_0
    //   35: getfield 22	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:abk	J
    //   38: aload_0
    //   39: getfield 24	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:bi	Landroid/os/Bundle;
    //   42: new 61	aicx
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 64	aicx:<init>	(Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3;)V
    //   50: invokeinterface 67 6 0
    //   55: aload_0
    //   56: getfield 18	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Laicu;
    //   59: iconst_0
    //   60: invokestatic 70	aicu:a	(Laicu;Z)Z
    //   63: pop
    //   64: return
    //   65: ldc 72
    //   67: iconst_1
    //   68: ldc 74
    //   70: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: goto -18 -> 55
    //   76: astore_1
    //   77: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +12 -> 92
    //   83: ldc 72
    //   85: iconst_1
    //   86: ldc 86
    //   88: aload_1
    //   89: invokestatic 90	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: getfield 18	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Laicu;
    //   96: iconst_0
    //   97: invokestatic 70	aicu:a	(Laicu;Z)Z
    //   100: pop
    //   101: return
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 18	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Laicu;
    //   107: iconst_0
    //   108: invokestatic 70	aicu:a	(Laicu;Z)Z
    //   111: pop
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	3
    //   18	6	1	localaibz	aibz
    //   76	13	1	localException	java.lang.Exception
    //   102	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	19	76	java/lang/Exception
    //   23	55	76	java/lang/Exception
    //   65	73	76	java/lang/Exception
    //   0	19	102	finally
    //   23	55	102	finally
    //   65	73	102	finally
    //   77	92	102	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.3
 * JD-Core Version:    0.7.0.1
 */