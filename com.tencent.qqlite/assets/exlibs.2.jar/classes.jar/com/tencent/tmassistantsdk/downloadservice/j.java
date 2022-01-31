package com.tencent.tmassistantsdk.downloadservice;

final class j
  extends Thread
{
  private int a = 0;
  
  public j(h paramh, int paramInt)
  {
    this.a = paramInt;
    setName("download_thread_" + this.a);
    start();
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 44
    //   2: new 19	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 46
    //   8: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 17	com/tencent/tmassistantsdk/downloadservice/j:a	I
    //   15: invokevirtual 28	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: ldc 48
    //   20: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 56	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   33: getfield 62	com/tencent/tmassistantsdk/downloadservice/h:c	Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: monitorenter
    //   39: ldc 44
    //   41: new 19	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 46
    //   47: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 17	com/tencent/tmassistantsdk/downloadservice/j:a	I
    //   54: invokevirtual 28	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc 64
    //   59: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 56	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   72: getfield 62	com/tencent/tmassistantsdk/downloadservice/h:c	Ljava/lang/Object;
    //   75: invokevirtual 69	java/lang/Object:wait	()V
    //   78: aload_1
    //   79: monitorexit
    //   80: invokestatic 73	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   83: invokevirtual 77	java/lang/Thread:isInterrupted	()Z
    //   86: ifeq +156 -> 242
    //   89: ldc 44
    //   91: new 19	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 46
    //   97: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 17	com/tencent/tmassistantsdk/downloadservice/j:a	I
    //   104: invokevirtual 28	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: ldc 79
    //   109: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 56	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: return
    //   119: astore_2
    //   120: ldc 44
    //   122: new 19	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 46
    //   128: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 17	com/tencent/tmassistantsdk/downloadservice/j:a	I
    //   135: invokevirtual 28	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: ldc 79
    //   140: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 56	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_2
    //   150: invokevirtual 82	java/lang/InterruptedException:printStackTrace	()V
    //   153: aload_1
    //   154: monitorexit
    //   155: return
    //   156: astore_2
    //   157: aload_1
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: aload_1
    //   162: ifnull +52 -> 214
    //   165: ldc 44
    //   167: new 19	java/lang/StringBuilder
    //   170: dup
    //   171: ldc 84
    //   173: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: aload_0
    //   177: invokevirtual 87	com/tencent/tmassistantsdk/downloadservice/j:getName	()Ljava/lang/String;
    //   180: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 89
    //   185: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokevirtual 93	com/tencent/tmassistantsdk/downloadservice/g:c	()Ljava/lang/String;
    //   192: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 56	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: invokestatic 98	com/tencent/tmassistantsdk/downloadservice/c:a	()Landroid/os/PowerManager$WakeLock;
    //   204: pop
    //   205: aload_0
    //   206: invokevirtual 87	com/tencent/tmassistantsdk/downloadservice/j:getName	()Ljava/lang/String;
    //   209: pop
    //   210: aload_1
    //   211: invokevirtual 101	com/tencent/tmassistantsdk/downloadservice/g:e	()V
    //   214: aload_0
    //   215: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   218: getfield 104	com/tencent/tmassistantsdk/downloadservice/h:d	Ljava/lang/Object;
    //   221: astore_2
    //   222: aload_2
    //   223: monitorenter
    //   224: aload_1
    //   225: ifnull +15 -> 240
    //   228: aload_0
    //   229: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   232: getfield 107	com/tencent/tmassistantsdk/downloadservice/h:b	Ljava/util/ArrayList;
    //   235: aload_1
    //   236: invokevirtual 113	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   239: pop
    //   240: aload_2
    //   241: monitorexit
    //   242: aload_0
    //   243: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   246: invokevirtual 115	com/tencent/tmassistantsdk/downloadservice/h:b	()Z
    //   249: ifeq -220 -> 29
    //   252: aconst_null
    //   253: astore_1
    //   254: aload_0
    //   255: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   258: getfield 104	com/tencent/tmassistantsdk/downloadservice/h:d	Ljava/lang/Object;
    //   261: astore_2
    //   262: aload_2
    //   263: monitorenter
    //   264: aload_0
    //   265: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   268: getfield 118	com/tencent/tmassistantsdk/downloadservice/h:a	Ljava/util/PriorityQueue;
    //   271: invokevirtual 124	java/util/PriorityQueue:size	()I
    //   274: ifle +29 -> 303
    //   277: aload_0
    //   278: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   281: getfield 118	com/tencent/tmassistantsdk/downloadservice/h:a	Ljava/util/PriorityQueue;
    //   284: invokevirtual 127	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   287: checkcast 91	com/tencent/tmassistantsdk/downloadservice/g
    //   290: astore_1
    //   291: aload_0
    //   292: getfield 12	com/tencent/tmassistantsdk/downloadservice/j:b	Lcom/tencent/tmassistantsdk/downloadservice/h;
    //   295: getfield 107	com/tencent/tmassistantsdk/downloadservice/h:b	Ljava/util/ArrayList;
    //   298: aload_1
    //   299: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   302: pop
    //   303: aload_2
    //   304: monitorexit
    //   305: invokestatic 73	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   308: invokevirtual 77	java/lang/Thread:isInterrupted	()Z
    //   311: ifeq -150 -> 161
    //   314: ldc 44
    //   316: new 19	java/lang/StringBuilder
    //   319: dup
    //   320: ldc 46
    //   322: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload_0
    //   326: getfield 17	com/tencent/tmassistantsdk/downloadservice/j:a	I
    //   329: invokevirtual 28	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc 79
    //   334: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 56	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: return
    //   344: astore_1
    //   345: aload_2
    //   346: monitorexit
    //   347: aload_1
    //   348: athrow
    //   349: astore_1
    //   350: aload_2
    //   351: monitorexit
    //   352: aload_1
    //   353: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	j
    //   36	263	1	localObject1	java.lang.Object
    //   344	4	1	localObject2	java.lang.Object
    //   349	4	1	localObject3	java.lang.Object
    //   119	31	2	localInterruptedException	java.lang.InterruptedException
    //   156	4	2	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   39	78	119	java/lang/InterruptedException
    //   39	78	156	finally
    //   120	155	156	finally
    //   264	303	344	finally
    //   303	305	344	finally
    //   228	240	349	finally
    //   240	242	349	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.j
 * JD-Core Version:    0.7.0.1
 */