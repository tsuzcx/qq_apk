package com.tencent.chirp;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import com.tencent.qphone.base.util.QLog;

public class PcmPlayer
{
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private PlayThread jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread;
  private a jdField_a_of_type_ComTencentChirpPcmPlayer$a;
  private String aHD;
  private int audioFormat = 2;
  private int bzK;
  private int channelConfig = 2;
  private Context mContext;
  private int sampleRate = 44100;
  
  public PcmPlayer(Context paramContext, a parama, int paramInt, String paramString)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentChirpPcmPlayer$a = parama;
    this.sampleRate = paramInt;
    this.aHD = paramString;
  }
  
  public void startPlay()
  {
    if (this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread != null) {}
    for (;;)
    {
      return;
      try
      {
        int i = AudioRecord.getMinBufferSize(this.sampleRate, this.channelConfig, this.audioFormat);
        this.bzK = (this.sampleRate / 1000 * 20 * this.audioFormat);
        this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.sampleRate, this.channelConfig, this.audioFormat, i, 1);
        this.jdField_a_of_type_AndroidMediaAudioTrack.play();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread = new PlayThread(null);
        this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread.start();
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer$a != null)
        {
          this.jdField_a_of_type_ComTencentChirpPcmPlayer$a.onPlayStart();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("PcmPlayer", 1, "startPlay fail.", localException);
      }
    }
  }
  
  public void stopPlay()
  {
    PlayThread localPlayThread = this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread;
    if (localPlayThread != null) {
      localPlayThread.isRunning = false;
    }
  }
  
  class PlayThread
    extends Thread
  {
    volatile boolean isRunning = true;
    
    private PlayThread() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: iconst_2
      //   3: istore_2
      //   4: new 29	java/io/File
      //   7: dup
      //   8: aload_0
      //   9: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   12: invokestatic 33	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Ljava/lang/String;
      //   15: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
      //   18: astore 5
      //   20: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   23: ifeq +32 -> 55
      //   26: ldc 44
      //   28: iconst_2
      //   29: new 46	java/lang/StringBuilder
      //   32: dup
      //   33: invokespecial 47	java/lang/StringBuilder:<init>	()V
      //   36: ldc 49
      //   38: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   41: aload 5
      //   43: invokevirtual 57	java/io/File:length	()J
      //   46: invokevirtual 60	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   49: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   52: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   55: aload 5
      //   57: invokevirtual 71	java/io/File:exists	()Z
      //   60: ifne +36 -> 96
      //   63: aload_0
      //   64: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   67: invokestatic 74	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$a;
      //   70: ifnull +16 -> 86
      //   73: aload_0
      //   74: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   77: invokestatic 74	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$a;
      //   80: iconst_1
      //   81: invokeinterface 80 2 0
      //   86: aload_0
      //   87: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   90: aconst_null
      //   91: invokestatic 83	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lcom/tencent/chirp/PcmPlayer$PlayThread;)Lcom/tencent/chirp/PcmPlayer$PlayThread;
      //   94: pop
      //   95: return
      //   96: aload_0
      //   97: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   100: invokestatic 86	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)I
      //   103: newarray byte
      //   105: astore 4
      //   107: new 88	java/io/FileInputStream
      //   110: dup
      //   111: aload 5
      //   113: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   116: astore 5
      //   118: new 93	java/io/BufferedInputStream
      //   121: dup
      //   122: aload 5
      //   124: invokespecial 96	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   127: astore 6
      //   129: aload_0
      //   130: getfield 20	com/tencent/chirp/PcmPlayer$PlayThread:isRunning	Z
      //   133: ifeq +19 -> 152
      //   136: aload 6
      //   138: aload 4
      //   140: iconst_0
      //   141: aload 4
      //   143: arraylength
      //   144: invokevirtual 100	java/io/BufferedInputStream:read	([BII)I
      //   147: istore_3
      //   148: iload_3
      //   149: ifgt +75 -> 224
      //   152: aload_0
      //   153: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   156: invokestatic 103	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
      //   159: invokevirtual 108	android/media/AudioTrack:stop	()V
      //   162: aload_0
      //   163: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   166: invokestatic 103	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
      //   169: invokevirtual 111	android/media/AudioTrack:release	()V
      //   172: aload 5
      //   174: ifnull +8 -> 182
      //   177: aload 5
      //   179: invokevirtual 114	java/io/FileInputStream:close	()V
      //   182: aload_0
      //   183: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   186: invokestatic 74	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$a;
      //   189: ifnull +16 -> 205
      //   192: aload_0
      //   193: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   196: invokestatic 74	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$a;
      //   199: iconst_0
      //   200: invokeinterface 80 2 0
      //   205: aload_0
      //   206: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   209: aconst_null
      //   210: invokestatic 83	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lcom/tencent/chirp/PcmPlayer$PlayThread;)Lcom/tencent/chirp/PcmPlayer$PlayThread;
      //   213: pop
      //   214: aload_0
      //   215: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   218: aconst_null
      //   219: invokestatic 117	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
      //   222: pop
      //   223: return
      //   224: aload_0
      //   225: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   228: invokestatic 103	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
      //   231: aload 4
      //   233: iconst_0
      //   234: iload_3
      //   235: invokevirtual 120	android/media/AudioTrack:write	([BII)I
      //   238: pop
      //   239: goto -110 -> 129
      //   242: astore 4
      //   244: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   247: ifeq +13 -> 260
      //   250: ldc 44
      //   252: iconst_2
      //   253: ldc 122
      //   255: aload 4
      //   257: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   260: aload_0
      //   261: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   264: invokestatic 103	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
      //   267: invokevirtual 108	android/media/AudioTrack:stop	()V
      //   270: aload_0
      //   271: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   274: invokestatic 103	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
      //   277: invokevirtual 111	android/media/AudioTrack:release	()V
      //   280: aload 5
      //   282: ifnull +8 -> 290
      //   285: aload 5
      //   287: invokevirtual 114	java/io/FileInputStream:close	()V
      //   290: aload_0
      //   291: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   294: invokestatic 74	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$a;
      //   297: ifnull +16 -> 313
      //   300: aload_0
      //   301: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   304: invokestatic 74	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$a;
      //   307: iconst_2
      //   308: invokeinterface 80 2 0
      //   313: aload_0
      //   314: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   317: aconst_null
      //   318: invokestatic 83	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lcom/tencent/chirp/PcmPlayer$PlayThread;)Lcom/tencent/chirp/PcmPlayer$PlayThread;
      //   321: pop
      //   322: aload_0
      //   323: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   326: aconst_null
      //   327: invokestatic 117	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
      //   330: pop
      //   331: return
      //   332: astore 4
      //   334: aconst_null
      //   335: astore 5
      //   337: iconst_0
      //   338: istore_1
      //   339: aload_0
      //   340: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   343: invokestatic 103	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
      //   346: invokevirtual 108	android/media/AudioTrack:stop	()V
      //   349: aload_0
      //   350: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   353: invokestatic 103	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
      //   356: invokevirtual 111	android/media/AudioTrack:release	()V
      //   359: aload 5
      //   361: ifnull +8 -> 369
      //   364: aload 5
      //   366: invokevirtual 114	java/io/FileInputStream:close	()V
      //   369: aload_0
      //   370: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   373: invokestatic 74	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$a;
      //   376: ifnull +26 -> 402
      //   379: aload_0
      //   380: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   383: invokestatic 74	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$a;
      //   386: astore 5
      //   388: iload_1
      //   389: ifeq +34 -> 423
      //   392: iload_2
      //   393: istore_1
      //   394: aload 5
      //   396: iload_1
      //   397: invokeinterface 80 2 0
      //   402: aload_0
      //   403: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   406: aconst_null
      //   407: invokestatic 83	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lcom/tencent/chirp/PcmPlayer$PlayThread;)Lcom/tencent/chirp/PcmPlayer$PlayThread;
      //   410: pop
      //   411: aload_0
      //   412: getfield 15	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
      //   415: aconst_null
      //   416: invokestatic 117	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
      //   419: pop
      //   420: aload 4
      //   422: athrow
      //   423: iconst_0
      //   424: istore_1
      //   425: goto -31 -> 394
      //   428: astore 4
      //   430: goto -248 -> 182
      //   433: astore 4
      //   435: goto -145 -> 290
      //   438: astore 5
      //   440: goto -71 -> 369
      //   443: astore 4
      //   445: iconst_0
      //   446: istore_1
      //   447: goto -108 -> 339
      //   450: astore 4
      //   452: goto -113 -> 339
      //   455: astore 4
      //   457: aconst_null
      //   458: astore 5
      //   460: goto -216 -> 244
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	463	0	this	PlayThread
      //   1	446	1	i	int
      //   3	390	2	j	int
      //   147	88	3	k	int
      //   105	127	4	arrayOfByte	byte[]
      //   242	14	4	localException1	Exception
      //   332	89	4	localObject1	Object
      //   428	1	4	localException2	Exception
      //   433	1	4	localException3	Exception
      //   443	1	4	localObject2	Object
      //   450	1	4	localObject3	Object
      //   455	1	4	localException4	Exception
      //   18	377	5	localObject4	Object
      //   438	1	5	localException5	Exception
      //   458	1	5	localObject5	Object
      //   127	10	6	localBufferedInputStream	java.io.BufferedInputStream
      // Exception table:
      //   from	to	target	type
      //   118	129	242	java/lang/Exception
      //   129	148	242	java/lang/Exception
      //   224	239	242	java/lang/Exception
      //   107	118	332	finally
      //   177	182	428	java/lang/Exception
      //   285	290	433	java/lang/Exception
      //   364	369	438	java/lang/Exception
      //   118	129	443	finally
      //   129	148	443	finally
      //   224	239	443	finally
      //   244	260	450	finally
      //   107	118	455	java/lang/Exception
    }
  }
  
  public static abstract interface a
  {
    public abstract void onPlayStart();
    
    public abstract void yb(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.chirp.PcmPlayer
 * JD-Core Version:    0.7.0.1
 */