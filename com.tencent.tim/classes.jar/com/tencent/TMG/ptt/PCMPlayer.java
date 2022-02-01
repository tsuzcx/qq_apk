package com.tencent.TMG.ptt;

import android.media.AudioTrack;
import android.util.Log;

public class PCMPlayer
{
  public String TAG = "PCMPlayer";
  private AudioTrack audioTrack;
  private int bufferSize;
  private int channel = 4;
  private int format = 2;
  PlayThread pcmPlayer = null;
  private int sampleRate = 16000;
  
  public PCMPlayer() {}
  
  public PCMPlayer(int paramInt1, int paramInt2, int paramInt3)
  {
    this.sampleRate = paramInt1;
    this.channel = paramInt2;
    this.format = paramInt3;
  }
  
  public int getBufferSize()
  {
    return this.bufferSize;
  }
  
  /* Error */
  public int getSilkFilePlayTime(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: iconst_0
    //   9: istore 5
    //   11: iconst_0
    //   12: istore 6
    //   14: new 56	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 63	java/io/File:exists	()Z
    //   27: istore 9
    //   29: iload 9
    //   31: ifne +50 -> 81
    //   34: aload_0
    //   35: getfield 26	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   38: new 65	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   45: ldc 68
    //   47: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iconst_0
    //   51: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc 77
    //   56: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iconst_0
    //   60: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc 79
    //   65: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iconst_0
    //   69: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 89	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: iconst_0
    //   80: ireturn
    //   81: new 91	java/io/FileInputStream
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 97	java/io/FileInputStream:available	()I
    //   94: istore 8
    //   96: bipush 9
    //   98: istore_2
    //   99: iload 8
    //   101: newarray byte
    //   103: astore 10
    //   105: aload_1
    //   106: aload 10
    //   108: invokevirtual 101	java/io/FileInputStream:read	([B)I
    //   111: pop
    //   112: iconst_0
    //   113: istore 5
    //   115: iload_2
    //   116: istore_3
    //   117: iload 6
    //   119: istore 4
    //   121: iload_3
    //   122: iload 8
    //   124: if_icmpge +104 -> 228
    //   127: iload 5
    //   129: iconst_1
    //   130: iadd
    //   131: istore_2
    //   132: aload 10
    //   134: iload_3
    //   135: iconst_1
    //   136: iadd
    //   137: baload
    //   138: istore 5
    //   140: aload 10
    //   142: iload_3
    //   143: baload
    //   144: iload 5
    //   146: bipush 8
    //   148: ishl
    //   149: iadd
    //   150: istore 5
    //   152: iload 4
    //   154: bipush 20
    //   156: iadd
    //   157: istore 4
    //   159: iload_3
    //   160: iload 5
    //   162: iconst_2
    //   163: iadd
    //   164: iadd
    //   165: istore_3
    //   166: aload_0
    //   167: getfield 26	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   170: new 65	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   177: ldc 103
    //   179: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload_2
    //   183: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: ldc 105
    //   188: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload 5
    //   193: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc 107
    //   198: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload_3
    //   202: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: ldc 109
    //   207: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload 4
    //   212: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 89	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: iload_2
    //   223: istore 5
    //   225: goto -104 -> 121
    //   228: aload_0
    //   229: getfield 26	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   232: new 65	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   239: ldc 68
    //   241: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload_3
    //   245: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc 77
    //   250: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 4
    //   255: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc 79
    //   260: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 5
    //   265: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 89	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   274: pop
    //   275: iload 4
    //   277: ireturn
    //   278: astore_1
    //   279: iconst_0
    //   280: istore 5
    //   282: iconst_0
    //   283: istore 6
    //   285: iload 7
    //   287: istore 4
    //   289: iload 5
    //   291: istore_3
    //   292: iload 6
    //   294: istore_2
    //   295: aload_1
    //   296: invokevirtual 112	java/io/FileNotFoundException:printStackTrace	()V
    //   299: aload_0
    //   300: getfield 26	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   303: new 65	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   310: ldc 68
    //   312: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: iload 5
    //   317: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: ldc 77
    //   322: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: iload 7
    //   327: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: ldc 79
    //   332: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 6
    //   337: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 89	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   346: pop
    //   347: iload 7
    //   349: ireturn
    //   350: astore_1
    //   351: iconst_0
    //   352: istore 5
    //   354: iconst_0
    //   355: istore 6
    //   357: iload_3
    //   358: istore 7
    //   360: iload 7
    //   362: istore 4
    //   364: iload 5
    //   366: istore_3
    //   367: iload 6
    //   369: istore_2
    //   370: aload_1
    //   371: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   374: aload_0
    //   375: getfield 26	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   378: new 65	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   385: ldc 68
    //   387: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 5
    //   392: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc 77
    //   397: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iload 7
    //   402: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc 79
    //   407: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload 6
    //   412: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 89	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   421: pop
    //   422: iload 7
    //   424: ireturn
    //   425: astore_1
    //   426: iconst_0
    //   427: istore 5
    //   429: iconst_0
    //   430: istore 6
    //   432: iload 4
    //   434: istore 7
    //   436: iload 7
    //   438: istore 4
    //   440: iload 5
    //   442: istore_3
    //   443: iload 6
    //   445: istore_2
    //   446: aload_1
    //   447: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   450: aload_0
    //   451: getfield 26	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   454: new 65	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   461: ldc 68
    //   463: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: iload 5
    //   468: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc 77
    //   473: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: iload 7
    //   478: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: ldc 79
    //   483: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: iload 6
    //   488: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 89	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   497: pop
    //   498: iload 7
    //   500: ireturn
    //   501: astore_1
    //   502: iconst_0
    //   503: istore_3
    //   504: iconst_0
    //   505: istore_2
    //   506: iload 5
    //   508: istore 4
    //   510: aload_0
    //   511: getfield 26	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   514: new 65	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   521: ldc 68
    //   523: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: iload_3
    //   527: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: ldc 77
    //   532: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: iload 4
    //   537: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: ldc 79
    //   542: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: iload_2
    //   546: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 89	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   555: pop
    //   556: iload 4
    //   558: ireturn
    //   559: astore_1
    //   560: iconst_0
    //   561: istore 6
    //   563: iload 5
    //   565: istore 4
    //   567: iload_2
    //   568: istore_3
    //   569: iload 6
    //   571: istore_2
    //   572: goto -62 -> 510
    //   575: astore_1
    //   576: goto -66 -> 510
    //   579: astore_1
    //   580: goto -70 -> 510
    //   583: astore_1
    //   584: iconst_0
    //   585: istore 6
    //   587: iload 4
    //   589: istore 7
    //   591: iload_2
    //   592: istore 5
    //   594: goto -158 -> 436
    //   597: astore_1
    //   598: iload 4
    //   600: istore 7
    //   602: iload_3
    //   603: istore 5
    //   605: iload_2
    //   606: istore 6
    //   608: goto -172 -> 436
    //   611: astore_1
    //   612: iconst_0
    //   613: istore 6
    //   615: iload_3
    //   616: istore 7
    //   618: iload_2
    //   619: istore 5
    //   621: goto -261 -> 360
    //   624: astore_1
    //   625: iload 4
    //   627: istore 7
    //   629: iload_3
    //   630: istore 5
    //   632: iload_2
    //   633: istore 6
    //   635: goto -275 -> 360
    //   638: astore_1
    //   639: iconst_0
    //   640: istore 6
    //   642: iload_2
    //   643: istore 5
    //   645: goto -360 -> 285
    //   648: astore_1
    //   649: iload 4
    //   651: istore 7
    //   653: iload_3
    //   654: istore 5
    //   656: iload_2
    //   657: istore 6
    //   659: goto -374 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	PCMPlayer
    //   0	662	1	paramString	String
    //   98	559	2	i	int
    //   4	650	3	j	int
    //   6	644	4	k	int
    //   9	646	5	m	int
    //   12	646	6	n	int
    //   1	651	7	i1	int
    //   94	31	8	i2	int
    //   27	3	9	bool	boolean
    //   103	38	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	29	278	java/io/FileNotFoundException
    //   81	96	278	java/io/FileNotFoundException
    //   14	29	350	java/io/IOException
    //   81	96	350	java/io/IOException
    //   14	29	425	java/lang/Exception
    //   81	96	425	java/lang/Exception
    //   14	29	501	finally
    //   81	96	501	finally
    //   99	112	559	finally
    //   295	299	575	finally
    //   370	374	575	finally
    //   446	450	575	finally
    //   166	222	579	finally
    //   99	112	583	java/lang/Exception
    //   166	222	597	java/lang/Exception
    //   99	112	611	java/io/IOException
    //   166	222	624	java/io/IOException
    //   99	112	638	java/io/FileNotFoundException
    //   166	222	648	java/io/FileNotFoundException
  }
  
  public boolean initPCMPlayer()
  {
    if (this.audioTrack != null)
    {
      Log.e(this.TAG, "init pcm player, audio track not null, release first!");
      this.audioTrack.release();
      this.audioTrack = null;
    }
    this.audioTrack = new AudioTrack(3, this.sampleRate, this.channel, this.format, this.format, 1);
    return true;
  }
  
  public boolean isPlaying()
  {
    return this.pcmPlayer != null;
  }
  
  public void play(String paramString, PttListener.PlayFileListener paramPlayFileListener)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramPlayFileListener.onCompleted(4101, null);
      return;
    }
    if (this.pcmPlayer == null)
    {
      this.pcmPlayer = new PlayThread(paramString, paramPlayFileListener);
      this.audioTrack.play();
      this.pcmPlayer.start();
      return;
    }
    Log.e(this.TAG, "file is playing , not play again!");
    paramPlayFileListener.onCompleted(20482, null);
  }
  
  public void stop()
  {
    int j = 0;
    int i = j;
    if (this.pcmPlayer != null)
    {
      this.pcmPlayer.isRunning = false;
      i = j;
    }
    for (;;)
    {
      if (this.pcmPlayer != null) {}
      try
      {
        Thread.sleep(10L);
        j = i + 1;
        i = j;
        if (j < 100) {
          continue;
        }
        Log.i(this.TAG, "stop silk player end!");
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  class PlayThread
    extends Thread
  {
    PttListener.PlayFileListener callBack = null;
    public volatile boolean isRunning = true;
    public String playPath = "";
    
    public PlayThread(String paramString, PttListener.PlayFileListener paramPlayFileListener)
    {
      this.playPath = paramString;
      this.callBack = paramPlayFileListener;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: invokestatic 44	com/tencent/TMG/ptt/TraeJni:getInstance	()Lcom/tencent/TMG/ptt/TraeJni;
      //   5: invokevirtual 48	com/tencent/TMG/ptt/TraeJni:initTRAE	()Z
      //   8: pop
      //   9: new 50	java/io/FileInputStream
      //   12: dup
      //   13: new 52	java/io/File
      //   16: dup
      //   17: aload_0
      //   18: getfield 28	com/tencent/TMG/ptt/PCMPlayer$PlayThread:playPath	Ljava/lang/String;
      //   21: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
      //   24: invokespecial 58	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   27: astore 5
      //   29: aload 5
      //   31: invokevirtual 62	java/io/FileInputStream:available	()I
      //   34: istore_3
      //   35: aload_0
      //   36: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   39: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   42: new 67	java/lang/StringBuilder
      //   45: dup
      //   46: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   49: ldc 70
      //   51: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   54: iload_3
      //   55: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   58: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   61: invokestatic 87	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   64: pop
      //   65: iload_3
      //   66: newarray byte
      //   68: astore 6
      //   70: aload 5
      //   72: aload 6
      //   74: invokevirtual 91	java/io/FileInputStream:read	([B)I
      //   77: istore_2
      //   78: aload_0
      //   79: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   82: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   85: new 67	java/lang/StringBuilder
      //   88: dup
      //   89: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   92: ldc 93
      //   94: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: iload_2
      //   98: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   101: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   104: invokestatic 87	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   107: pop
      //   108: aload 5
      //   110: invokevirtual 96	java/io/FileInputStream:close	()V
      //   113: bipush 9
      //   115: istore_2
      //   116: iload_2
      //   117: iload_3
      //   118: if_icmpge +260 -> 378
      //   121: aload_0
      //   122: getfield 24	com/tencent/TMG/ptt/PCMPlayer$PlayThread:isRunning	Z
      //   125: ifeq +253 -> 378
      //   128: aload 6
      //   130: iload_2
      //   131: iconst_1
      //   132: iadd
      //   133: baload
      //   134: bipush 8
      //   136: ishl
      //   137: aload 6
      //   139: iload_2
      //   140: baload
      //   141: iadd
      //   142: istore 4
      //   144: iload_2
      //   145: iconst_2
      //   146: iadd
      //   147: istore_2
      //   148: iload 4
      //   150: newarray byte
      //   152: astore 7
      //   154: aload 6
      //   156: iload_2
      //   157: aload 7
      //   159: iconst_0
      //   160: iload 4
      //   162: invokestatic 102	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   165: invokestatic 44	com/tencent/TMG/ptt/TraeJni:getInstance	()Lcom/tencent/TMG/ptt/TraeJni;
      //   168: aload 7
      //   170: iload 4
      //   172: i2l
      //   173: invokevirtual 106	com/tencent/TMG/ptt/TraeJni:turnPCM	([BJ)[B
      //   176: astore 7
      //   178: iload_2
      //   179: iload 4
      //   181: iadd
      //   182: istore_2
      //   183: aload_0
      //   184: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   187: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   190: aload 7
      //   192: iconst_0
      //   193: aload 7
      //   195: arraylength
      //   196: invokevirtual 116	android/media/AudioTrack:write	([BII)I
      //   199: pop
      //   200: iload_1
      //   201: iconst_1
      //   202: iadd
      //   203: istore_1
      //   204: aload_0
      //   205: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   208: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   211: new 67	java/lang/StringBuilder
      //   214: dup
      //   215: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   218: ldc 118
      //   220: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   223: iload 4
      //   225: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   228: ldc 120
      //   230: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   233: aload 7
      //   235: arraylength
      //   236: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   239: ldc 122
      //   241: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   244: iload_1
      //   245: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   248: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   251: invokestatic 125	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   254: pop
      //   255: goto -139 -> 116
      //   258: astore 5
      //   260: aload_0
      //   261: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   264: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   267: new 67	java/lang/StringBuilder
      //   270: dup
      //   271: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   274: ldc 127
      //   276: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   279: aload 5
      //   281: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   284: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   287: invokestatic 125	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   290: pop
      //   291: aload_0
      //   292: getfield 30	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
      //   295: sipush 20484
      //   298: aconst_null
      //   299: invokeinterface 136 3 0
      //   304: aload_0
      //   305: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   308: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   311: ldc 138
      //   313: invokestatic 87	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   316: pop
      //   317: aload_0
      //   318: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   321: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   324: ifnull +32 -> 356
      //   327: aload_0
      //   328: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   331: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   334: invokevirtual 141	android/media/AudioTrack:stop	()V
      //   337: aload_0
      //   338: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   341: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   344: invokevirtual 144	android/media/AudioTrack:release	()V
      //   347: aload_0
      //   348: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   351: aconst_null
      //   352: invokestatic 148	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
      //   355: pop
      //   356: aload_0
      //   357: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   360: aconst_null
      //   361: putfield 152	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
      //   364: aload_0
      //   365: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   368: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   371: ldc 154
      //   373: invokestatic 157	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   376: pop
      //   377: return
      //   378: aload 5
      //   380: ifnull +8 -> 388
      //   383: aload 5
      //   385: invokevirtual 96	java/io/FileInputStream:close	()V
      //   388: aload_0
      //   389: getfield 30	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
      //   392: iconst_0
      //   393: aload_0
      //   394: getfield 28	com/tencent/TMG/ptt/PCMPlayer$PlayThread:playPath	Ljava/lang/String;
      //   397: invokeinterface 136 3 0
      //   402: aload_0
      //   403: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   406: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   409: ldc 138
      //   411: invokestatic 87	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   414: pop
      //   415: aload_0
      //   416: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   419: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   422: ifnull +32 -> 454
      //   425: aload_0
      //   426: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   429: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   432: invokevirtual 141	android/media/AudioTrack:stop	()V
      //   435: aload_0
      //   436: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   439: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   442: invokevirtual 144	android/media/AudioTrack:release	()V
      //   445: aload_0
      //   446: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   449: aconst_null
      //   450: invokestatic 148	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
      //   453: pop
      //   454: aload_0
      //   455: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   458: aconst_null
      //   459: putfield 152	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
      //   462: aload_0
      //   463: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   466: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   469: ldc 154
      //   471: invokestatic 157	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   474: pop
      //   475: return
      //   476: astore 5
      //   478: aload_0
      //   479: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   482: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   485: new 67	java/lang/StringBuilder
      //   488: dup
      //   489: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   492: ldc 159
      //   494: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   497: aload 5
      //   499: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   502: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   505: invokestatic 125	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   508: pop
      //   509: aload_0
      //   510: getfield 30	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
      //   513: sipush 20484
      //   516: aconst_null
      //   517: invokeinterface 136 3 0
      //   522: aload_0
      //   523: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   526: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   529: ldc 138
      //   531: invokestatic 87	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   534: pop
      //   535: aload_0
      //   536: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   539: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   542: ifnull +32 -> 574
      //   545: aload_0
      //   546: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   549: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   552: invokevirtual 141	android/media/AudioTrack:stop	()V
      //   555: aload_0
      //   556: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   559: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   562: invokevirtual 144	android/media/AudioTrack:release	()V
      //   565: aload_0
      //   566: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   569: aconst_null
      //   570: invokestatic 148	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
      //   573: pop
      //   574: aload_0
      //   575: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   578: aconst_null
      //   579: putfield 152	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
      //   582: aload_0
      //   583: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   586: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   589: ldc 154
      //   591: invokestatic 157	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   594: pop
      //   595: return
      //   596: astore 5
      //   598: aload_0
      //   599: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   602: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   605: new 67	java/lang/StringBuilder
      //   608: dup
      //   609: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   612: ldc 161
      //   614: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   617: aload 5
      //   619: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   622: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   625: invokestatic 125	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   628: pop
      //   629: aload_0
      //   630: getfield 30	com/tencent/TMG/ptt/PCMPlayer$PlayThread:callBack	Lcom/tencent/TMG/ptt/PttListener$PlayFileListener;
      //   633: sipush 20484
      //   636: aconst_null
      //   637: invokeinterface 136 3 0
      //   642: aload_0
      //   643: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   646: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   649: ldc 138
      //   651: invokestatic 87	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   654: pop
      //   655: aload_0
      //   656: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   659: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   662: ifnull +32 -> 694
      //   665: aload_0
      //   666: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   669: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   672: invokevirtual 141	android/media/AudioTrack:stop	()V
      //   675: aload_0
      //   676: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   679: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   682: invokevirtual 144	android/media/AudioTrack:release	()V
      //   685: aload_0
      //   686: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   689: aconst_null
      //   690: invokestatic 148	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
      //   693: pop
      //   694: aload_0
      //   695: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   698: aconst_null
      //   699: putfield 152	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
      //   702: aload_0
      //   703: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   706: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   709: ldc 154
      //   711: invokestatic 157	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   714: pop
      //   715: return
      //   716: astore 5
      //   718: aload_0
      //   719: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   722: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   725: ldc 138
      //   727: invokestatic 87	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   730: pop
      //   731: aload_0
      //   732: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   735: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   738: ifnull +32 -> 770
      //   741: aload_0
      //   742: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   745: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   748: invokevirtual 141	android/media/AudioTrack:stop	()V
      //   751: aload_0
      //   752: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   755: invokestatic 110	com/tencent/TMG/ptt/PCMPlayer:access$000	(Lcom/tencent/TMG/ptt/PCMPlayer;)Landroid/media/AudioTrack;
      //   758: invokevirtual 144	android/media/AudioTrack:release	()V
      //   761: aload_0
      //   762: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   765: aconst_null
      //   766: invokestatic 148	com/tencent/TMG/ptt/PCMPlayer:access$002	(Lcom/tencent/TMG/ptt/PCMPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
      //   769: pop
      //   770: aload_0
      //   771: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   774: aconst_null
      //   775: putfield 152	com/tencent/TMG/ptt/PCMPlayer:pcmPlayer	Lcom/tencent/TMG/ptt/PCMPlayer$PlayThread;
      //   778: aload_0
      //   779: getfield 19	com/tencent/TMG/ptt/PCMPlayer$PlayThread:this$0	Lcom/tencent/TMG/ptt/PCMPlayer;
      //   782: getfield 65	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
      //   785: ldc 154
      //   787: invokestatic 157	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   790: pop
      //   791: aload 5
      //   793: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	794	0	this	PlayThread
      //   1	244	1	i	int
      //   77	106	2	j	int
      //   34	85	3	k	int
      //   142	82	4	m	int
      //   27	82	5	localFileInputStream	java.io.FileInputStream
      //   258	126	5	localFileNotFoundException	java.io.FileNotFoundException
      //   476	22	5	localIOException	java.io.IOException
      //   596	22	5	localException	java.lang.Exception
      //   716	76	5	localObject	Object
      //   68	87	6	arrayOfByte1	byte[]
      //   152	82	7	arrayOfByte2	byte[]
      // Exception table:
      //   from	to	target	type
      //   2	113	258	java/io/FileNotFoundException
      //   121	128	258	java/io/FileNotFoundException
      //   148	178	258	java/io/FileNotFoundException
      //   183	200	258	java/io/FileNotFoundException
      //   204	255	258	java/io/FileNotFoundException
      //   383	388	258	java/io/FileNotFoundException
      //   388	402	258	java/io/FileNotFoundException
      //   2	113	476	java/io/IOException
      //   121	128	476	java/io/IOException
      //   148	178	476	java/io/IOException
      //   183	200	476	java/io/IOException
      //   204	255	476	java/io/IOException
      //   383	388	476	java/io/IOException
      //   388	402	476	java/io/IOException
      //   2	113	596	java/lang/Exception
      //   121	128	596	java/lang/Exception
      //   148	178	596	java/lang/Exception
      //   183	200	596	java/lang/Exception
      //   204	255	596	java/lang/Exception
      //   383	388	596	java/lang/Exception
      //   388	402	596	java/lang/Exception
      //   2	113	716	finally
      //   121	128	716	finally
      //   148	178	716	finally
      //   183	200	716	finally
      //   204	255	716	finally
      //   260	304	716	finally
      //   383	388	716	finally
      //   388	402	716	finally
      //   478	522	716	finally
      //   598	642	716	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.PCMPlayer
 * JD-Core Version:    0.7.0.1
 */