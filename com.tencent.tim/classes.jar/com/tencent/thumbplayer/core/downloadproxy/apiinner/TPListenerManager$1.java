package com.tencent.thumbplayer.core.downloadproxy.apiinner;

class TPListenerManager$1
  implements Runnable
{
  TPListenerManager$1(TPListenerManager paramTPListenerManager) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$200	()Ljava/lang/Object;
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   12: invokestatic 29	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$300	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)Ljava/util/Map;
    //   15: astore 6
    //   17: aload 5
    //   19: monitorexit
    //   20: aload 6
    //   22: invokeinterface 35 1 0
    //   27: invokeinterface 41 1 0
    //   32: astore 5
    //   34: aload 5
    //   36: invokeinterface 47 1 0
    //   41: ifeq +163 -> 204
    //   44: aload 5
    //   46: invokeinterface 50 1 0
    //   51: checkcast 52	java/util/Map$Entry
    //   54: astore 6
    //   56: aload 6
    //   58: invokeinterface 55 1 0
    //   63: checkcast 57	java/lang/Integer
    //   66: invokevirtual 61	java/lang/Integer:intValue	()I
    //   69: istore_1
    //   70: aload 6
    //   72: invokeinterface 64 1 0
    //   77: checkcast 66	com/tencent/thumbplayer/core/downloadproxy/api/ITPPlayListener
    //   80: astore 6
    //   82: aload 6
    //   84: invokeinterface 70 1 0
    //   89: ldc2_w 71
    //   92: ldiv
    //   93: l2i
    //   94: istore_2
    //   95: aload 6
    //   97: invokeinterface 75 1 0
    //   102: ldc2_w 71
    //   105: ldiv
    //   106: l2i
    //   107: istore_3
    //   108: aload 6
    //   110: invokeinterface 78 1 0
    //   115: ldc2_w 71
    //   118: ldiv
    //   119: l2i
    //   120: istore 4
    //   122: invokestatic 84	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   125: iload_1
    //   126: iload_2
    //   127: iload_3
    //   128: iload 4
    //   130: invokevirtual 88	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:updatePlayerPlayMsg	(IIII)V
    //   133: goto -99 -> 34
    //   136: astore 5
    //   138: ldc 90
    //   140: iconst_0
    //   141: ldc 92
    //   143: new 94	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   150: ldc 97
    //   152: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 5
    //   157: invokevirtual 105	java/lang/Throwable:toString	()Ljava/lang/String;
    //   160: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 112	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   173: invokestatic 116	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$600	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)Landroid/os/Handler;
    //   176: aload_0
    //   177: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   180: invokestatic 120	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$400	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)Ljava/lang/Runnable;
    //   183: aload_0
    //   184: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   187: invokestatic 124	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$500	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)I
    //   190: i2l
    //   191: invokevirtual 130	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   194: pop
    //   195: return
    //   196: astore 6
    //   198: aload 5
    //   200: monitorexit
    //   201: aload 6
    //   203: athrow
    //   204: aload_0
    //   205: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   208: invokestatic 116	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$600	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)Landroid/os/Handler;
    //   211: aload_0
    //   212: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   215: invokestatic 120	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$400	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)Ljava/lang/Runnable;
    //   218: aload_0
    //   219: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   222: invokestatic 124	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$500	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)I
    //   225: i2l
    //   226: invokevirtual 130	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   229: pop
    //   230: return
    //   231: astore 5
    //   233: aload_0
    //   234: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   237: invokestatic 116	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$600	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)Landroid/os/Handler;
    //   240: aload_0
    //   241: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   244: invokestatic 120	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$400	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)Ljava/lang/Runnable;
    //   247: aload_0
    //   248: getfield 12	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager$1:this$0	Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   251: invokestatic 124	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:access$500	(Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;)I
    //   254: i2l
    //   255: invokevirtual 130	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   258: pop
    //   259: aload 5
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	1
    //   69	57	1	i	int
    //   94	33	2	j	int
    //   107	21	3	k	int
    //   120	9	4	m	int
    //   3	42	5	localObject1	Object
    //   136	63	5	localThrowable	java.lang.Throwable
    //   231	29	5	localObject2	Object
    //   15	94	6	localObject3	Object
    //   196	6	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   20	34	136	java/lang/Throwable
    //   34	133	136	java/lang/Throwable
    //   8	20	196	finally
    //   198	201	196	finally
    //   20	34	231	finally
    //   34	133	231	finally
    //   138	169	231	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.1
 * JD-Core Version:    0.7.0.1
 */