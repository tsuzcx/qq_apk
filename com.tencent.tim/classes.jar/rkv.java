import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;

public class rkv
  extends rkz<RMVideoStateMgr, Void>
{
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, RMVideoStateMgr paramRMVideoStateMgr)
  {
    // Byte code:
    //   0: ldc 18
    //   2: ldc 20
    //   4: invokestatic 26	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 32	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   10: ifeq +185 -> 195
    //   13: ldc 34
    //   15: iconst_0
    //   16: invokestatic 40	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   19: new 42	com/tencent/biz/qqstory/takevideo/publish/GenerateVideoManifestSegment$1
    //   22: dup
    //   23: aload_0
    //   24: aload_2
    //   25: invokespecial 45	com/tencent/biz/qqstory/takevideo/publish/GenerateVideoManifestSegment$1:<init>	(Lrkv;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   28: invokevirtual 51	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   31: invokestatic 32	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   34: ifeq +155 -> 189
    //   37: lconst_0
    //   38: lstore 6
    //   40: aload_2
    //   41: getfield 57	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_2
    //   48: getfield 57	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   51: invokevirtual 62	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   54: istore 10
    //   56: lload 6
    //   58: lstore 4
    //   60: iload 10
    //   62: ifne +82 -> 144
    //   65: lload 6
    //   67: lstore 4
    //   69: ldc 18
    //   71: ldc 64
    //   73: invokestatic 26	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload 6
    //   78: lstore 4
    //   80: invokestatic 70	android/os/SystemClock:elapsedRealtime	()J
    //   83: lstore 8
    //   85: lload 6
    //   87: lstore 4
    //   89: aload_2
    //   90: getfield 57	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   93: ldc2_w 71
    //   96: invokevirtual 78	java/lang/Object:wait	(J)V
    //   99: lload 6
    //   101: lstore 4
    //   103: invokestatic 70	android/os/SystemClock:elapsedRealtime	()J
    //   106: lload 8
    //   108: lsub
    //   109: lstore 6
    //   111: lload 6
    //   113: lstore 4
    //   115: ldc 18
    //   117: new 80	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   124: ldc 83
    //   126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: lload 6
    //   131: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 26	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: lload 6
    //   142: lstore 4
    //   144: aload_1
    //   145: monitorexit
    //   146: ldc 18
    //   148: ldc 96
    //   150: invokestatic 26	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: lload 4
    //   155: ldc2_w 97
    //   158: lcmp
    //   159: ifge +30 -> 189
    //   162: bipush 30
    //   164: lload 4
    //   166: l2i
    //   167: isub
    //   168: istore_3
    //   169: ldc 18
    //   171: ldc 100
    //   173: iload_3
    //   174: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokestatic 110	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   180: iload_3
    //   181: i2l
    //   182: lstore 4
    //   184: lload 4
    //   186: invokestatic 115	java/lang/Thread:sleep	(J)V
    //   189: aload_0
    //   190: aconst_null
    //   191: invokespecial 119	rkz:notifyResult	(Ljava/lang/Object;)V
    //   194: return
    //   195: invokestatic 124	aniu:a	()Laniu;
    //   198: invokevirtual 127	aniu:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   201: invokevirtual 133	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   204: pop
    //   205: ldc 18
    //   207: ldc 135
    //   209: invokestatic 26	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: goto -181 -> 31
    //   215: astore_1
    //   216: ldc 18
    //   218: ldc 137
    //   220: aload_1
    //   221: invokestatic 140	ram:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: goto -193 -> 31
    //   227: astore_2
    //   228: ldc 18
    //   230: new 80	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   237: ldc 142
    //   239: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_2
    //   243: invokevirtual 145	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 26	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: goto -111 -> 144
    //   258: astore_2
    //   259: aload_1
    //   260: monitorexit
    //   261: aload_2
    //   262: athrow
    //   263: astore_1
    //   264: goto -75 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	rkv
    //   0	267	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	267	2	paramRMVideoStateMgr	RMVideoStateMgr
    //   168	13	3	i	int
    //   58	127	4	l1	long
    //   38	103	6	l2	long
    //   83	24	8	l3	long
    //   54	7	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   195	212	215	java/lang/UnsatisfiedLinkError
    //   69	76	227	java/lang/InterruptedException
    //   80	85	227	java/lang/InterruptedException
    //   89	99	227	java/lang/InterruptedException
    //   103	111	227	java/lang/InterruptedException
    //   115	140	227	java/lang/InterruptedException
    //   47	56	258	finally
    //   69	76	258	finally
    //   80	85	258	finally
    //   89	99	258	finally
    //   103	111	258	finally
    //   115	140	258	finally
    //   144	146	258	finally
    //   228	255	258	finally
    //   259	261	258	finally
    //   184	189	263	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkv
 * JD-Core Version:    0.7.0.1
 */