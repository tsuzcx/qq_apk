import android.media.MediaPlayer.OnCompletionListener;

public class abmz
  implements MediaPlayer.OnCompletionListener
{
  int bmm = this.val$count;
  
  abmz(abmy paramabmy, int paramInt, abjq paramabjq, long paramLong) {}
  
  /* Error */
  public void onCompletion(android.media.MediaPlayer paramMediaPlayer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 30	abmz:bmm	I
    //   5: iconst_1
    //   6: isub
    //   7: putfield 30	abmz:bmm	I
    //   10: aload_1
    //   11: iconst_0
    //   12: invokevirtual 41	android/media/MediaPlayer:seekTo	(I)V
    //   15: aload_0
    //   16: getfield 30	abmz:bmm	I
    //   19: ifle +21 -> 40
    //   22: aload_0
    //   23: getfield 19	abmz:a	Labmy;
    //   26: getfield 47	abmy:cp	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   29: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   32: ifne +8 -> 40
    //   35: aload_1
    //   36: invokevirtual 56	android/media/MediaPlayer:start	()V
    //   39: return
    //   40: aload_0
    //   41: getfield 19	abmz:a	Labmy;
    //   44: getfield 47	abmy:cp	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   47: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   50: ifeq +11 -> 61
    //   53: aload_0
    //   54: getfield 19	abmz:a	Labmy;
    //   57: iconst_0
    //   58: invokestatic 59	abmy:a	(Labmy;Z)V
    //   61: aload_0
    //   62: getfield 19	abmz:a	Labmy;
    //   65: invokestatic 62	abmy:a	(Labmy;)Ljava/lang/Object;
    //   68: astore_2
    //   69: aload_2
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 19	abmz:a	Labmy;
    //   75: invokestatic 65	abmy:a	(Labmy;)Ljava/util/List;
    //   78: aload_1
    //   79: invokeinterface 71 2 0
    //   84: ifeq +17 -> 101
    //   87: aload_0
    //   88: getfield 19	abmz:a	Labmy;
    //   91: invokestatic 65	abmy:a	(Labmy;)Ljava/util/List;
    //   94: aload_1
    //   95: invokeinterface 74 2 0
    //   100: pop
    //   101: aload_2
    //   102: monitorexit
    //   103: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +32 -> 138
    //   109: getstatic 83	abmy:TAG	Ljava/lang/String;
    //   112: iconst_2
    //   113: new 85	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   120: ldc 88
    //   122: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 96	android/media/MediaPlayer:getAudioSessionId	()I
    //   129: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: getfield 23	abmz:c	Labjq;
    //   142: instanceof 109
    //   145: ifeq +24 -> 169
    //   148: aload_0
    //   149: getfield 23	abmz:c	Labjq;
    //   152: checkcast 109	com/tencent/mobileqq/apollo/ApolloSurfaceView
    //   155: astore_2
    //   156: aload_2
    //   157: new 111	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1$1
    //   160: dup
    //   161: aload_0
    //   162: aload_2
    //   163: invokespecial 114	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1$1:<init>	(Labmz;Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;)V
    //   166: invokevirtual 118	com/tencent/mobileqq/apollo/ApolloSurfaceView:runRenderTask	(Lcom/tencent/mobileqq/apollo/IApolloRunnableTask;)V
    //   169: aload_1
    //   170: invokevirtual 121	android/media/MediaPlayer:reset	()V
    //   173: aload_1
    //   174: invokevirtual 124	android/media/MediaPlayer:release	()V
    //   177: return
    //   178: astore_2
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 124	android/media/MediaPlayer:release	()V
    //   187: getstatic 83	abmy:TAG	Ljava/lang/String;
    //   190: iconst_1
    //   191: ldc 126
    //   193: aload_2
    //   194: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: return
    //   198: astore_3
    //   199: aload_2
    //   200: monitorexit
    //   201: aload_3
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	abmz
    //   0	203	1	paramMediaPlayer	android.media.MediaPlayer
    //   178	22	2	localThrowable	java.lang.Throwable
    //   198	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	39	178	java/lang/Throwable
    //   40	61	178	java/lang/Throwable
    //   61	71	178	java/lang/Throwable
    //   103	138	178	java/lang/Throwable
    //   138	169	178	java/lang/Throwable
    //   169	177	178	java/lang/Throwable
    //   201	203	178	java/lang/Throwable
    //   71	101	198	finally
    //   101	103	198	finally
    //   199	201	198	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmz
 * JD-Core Version:    0.7.0.1
 */