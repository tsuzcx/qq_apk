package com.tencent.tav.core;

import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioCompositor
{
  private final String TAG = "AudioCompositor@" + Integer.toHexString(hashCode());
  private AudioMixer audioMixer;
  private ShortBuffer currentSamples;
  private ShortBuffer lastSamples;
  
  public AudioCompositor(AudioInfo paramAudioInfo)
  {
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
  }
  
  public void clear()
  {
    try
    {
      this.currentSamples = null;
      this.lastSamples = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    this.audioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
    return this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
  }
  
  /* Error */
  public com.tencent.tav.coremedia.CMSampleBuffer readMergeSample(com.tencent.tav.decoder.AudioDecoderTrack paramAudioDecoderTrack, AudioMixInputParameters paramAudioMixInputParameters, com.tencent.tav.coremedia.CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_3
    //   6: ifnull +14 -> 20
    //   9: aload_3
    //   10: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   13: ifnull +7 -> 20
    //   16: aload_1
    //   17: ifnonnull +21 -> 38
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   30: aload_3
    //   31: astore 9
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 9
    //   37: areturn
    //   38: aload_3
    //   39: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   42: invokevirtual 92	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   45: invokevirtual 97	java/nio/ShortBuffer:limit	()I
    //   48: istore 8
    //   50: aload_0
    //   51: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   54: ifnull +15 -> 69
    //   57: aload_0
    //   58: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   61: invokevirtual 100	java/nio/ShortBuffer:capacity	()I
    //   64: iload 8
    //   66: if_icmpge +495 -> 561
    //   69: iload 8
    //   71: iconst_2
    //   72: imul
    //   73: invokestatic 104	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   76: astore 9
    //   78: aload 9
    //   80: aload_3
    //   81: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   84: invokevirtual 108	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   87: invokevirtual 111	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   90: pop
    //   91: aload_0
    //   92: aload 9
    //   94: invokevirtual 92	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   97: putfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   100: aload_0
    //   101: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   104: ifnull +91 -> 195
    //   107: aload_0
    //   108: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   111: invokevirtual 114	java/nio/ShortBuffer:remaining	()I
    //   114: ifle +81 -> 195
    //   117: iload 8
    //   119: aload_0
    //   120: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   123: invokevirtual 114	java/nio/ShortBuffer:remaining	()I
    //   126: if_icmpge +451 -> 577
    //   129: aload_0
    //   130: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   133: invokevirtual 117	java/nio/ShortBuffer:position	()I
    //   136: istore 5
    //   138: aload_0
    //   139: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   142: invokevirtual 97	java/nio/ShortBuffer:limit	()I
    //   145: istore 6
    //   147: aload_0
    //   148: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   151: iload 5
    //   153: iload 8
    //   155: iadd
    //   156: invokevirtual 120	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   159: pop
    //   160: aload_0
    //   161: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   164: aload_0
    //   165: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   168: invokevirtual 124	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   171: pop
    //   172: aload_0
    //   173: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   176: iload 6
    //   178: invokevirtual 120	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   181: pop
    //   182: aload_0
    //   183: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   186: iload 5
    //   188: iload 8
    //   190: iadd
    //   191: invokevirtual 126	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   194: pop
    //   195: aload_0
    //   196: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   199: invokevirtual 117	java/nio/ShortBuffer:position	()I
    //   202: istore 5
    //   204: iload 5
    //   206: iload 8
    //   208: if_icmpge +309 -> 517
    //   211: aload_1
    //   212: aload_3
    //   213: invokevirtual 130	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   216: invokevirtual 136	com/tencent/tav/decoder/AudioDecoderTrack:readSample	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   219: astore 10
    //   221: iload 7
    //   223: istore 6
    //   225: getstatic 142	com/tencent/tav/decoder/logger/Logger:LOG_VERBOSE	Z
    //   228: ifeq +46 -> 274
    //   231: aload_0
    //   232: getfield 41	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   235: new 18	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   242: ldc 144
    //   244: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload 7
    //   249: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: ldc 149
    //   254: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 10
    //   259: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 156	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: iload 7
    //   270: iconst_1
    //   271: iadd
    //   272: istore 6
    //   274: aload_3
    //   275: astore 9
    //   277: aload 10
    //   279: invokevirtual 130	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   282: getstatic 162	com/tencent/tav/decoder/IDecoder:SAMPLE_TIME_FINISH	Lcom/tencent/tav/coremedia/CMTime;
    //   285: invokevirtual 168	com/tencent/tav/coremedia/CMTime:bigThan	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   288: ifeq -255 -> 33
    //   291: aload_1
    //   292: aload 10
    //   294: invokevirtual 130	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   297: invokevirtual 172	com/tencent/tav/decoder/AudioDecoderTrack:asyncReadNextSample	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   300: aload_2
    //   301: ifnull +306 -> 607
    //   304: aload_2
    //   305: aload 10
    //   307: invokevirtual 130	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   310: invokevirtual 178	com/tencent/tav/core/AudioMixInputParameters:getVolumeAtTime	(Lcom/tencent/tav/coremedia/CMTime;)F
    //   313: fstore 4
    //   315: iload 6
    //   317: istore 7
    //   319: aload 10
    //   321: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   324: ifnull -120 -> 204
    //   327: aload_2
    //   328: ifnull +38 -> 366
    //   331: aload_2
    //   332: invokevirtual 182	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   335: ifnull +31 -> 366
    //   338: aload 10
    //   340: aload_2
    //   341: invokevirtual 182	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   344: aload 10
    //   346: invokevirtual 130	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   349: aload 10
    //   351: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   354: aload_1
    //   355: invokevirtual 186	com/tencent/tav/decoder/AudioDecoderTrack:getAudioInfo	()Lcom/tencent/tav/decoder/AudioInfo;
    //   358: invokeinterface 192 4 0
    //   363: invokevirtual 196	com/tencent/tav/coremedia/CMSampleBuffer:setSampleByteBuffer	(Ljava/nio/ByteBuffer;)V
    //   366: aload_0
    //   367: aload 10
    //   369: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   372: fload 4
    //   374: fconst_1
    //   375: aload_1
    //   376: invokevirtual 186	com/tencent/tav/decoder/AudioDecoderTrack:getAudioInfo	()Lcom/tencent/tav/decoder/AudioInfo;
    //   379: invokevirtual 198	com/tencent/tav/core/AudioCompositor:processFrame	(Ljava/nio/ByteBuffer;FFLcom/tencent/tav/decoder/AudioInfo;)Ljava/nio/ByteBuffer;
    //   382: invokevirtual 92	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   385: astore 9
    //   387: aload 9
    //   389: invokevirtual 97	java/nio/ShortBuffer:limit	()I
    //   392: iload 8
    //   394: iload 5
    //   396: isub
    //   397: if_icmple +255 -> 652
    //   400: aload 9
    //   402: invokevirtual 97	java/nio/ShortBuffer:limit	()I
    //   405: iload 8
    //   407: iload 5
    //   409: isub
    //   410: isub
    //   411: istore 6
    //   413: aload_0
    //   414: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   417: ifnull +15 -> 432
    //   420: aload_0
    //   421: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   424: invokevirtual 100	java/nio/ShortBuffer:capacity	()I
    //   427: iload 6
    //   429: if_icmpge +184 -> 613
    //   432: iload 6
    //   434: iconst_2
    //   435: imul
    //   436: invokestatic 104	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   439: astore_1
    //   440: aload_1
    //   441: aload_3
    //   442: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   445: invokevirtual 108	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   448: invokevirtual 111	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   451: pop
    //   452: aload_0
    //   453: aload_1
    //   454: invokevirtual 92	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   457: putfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   460: aload 9
    //   462: iload 8
    //   464: iload 5
    //   466: isub
    //   467: invokevirtual 126	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   470: pop
    //   471: aload_0
    //   472: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   475: aload 9
    //   477: invokevirtual 124	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   480: pop
    //   481: aload_0
    //   482: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   485: invokevirtual 202	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   488: pop
    //   489: aload 9
    //   491: iconst_0
    //   492: invokevirtual 126	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   495: pop
    //   496: aload 9
    //   498: iload 8
    //   500: iload 5
    //   502: isub
    //   503: invokevirtual 120	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   506: pop
    //   507: aload_0
    //   508: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   511: aload 9
    //   513: invokevirtual 124	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   516: pop
    //   517: aload_0
    //   518: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   521: invokevirtual 202	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   524: pop
    //   525: aload_0
    //   526: getfield 57	com/tencent/tav/core/AudioCompositor:audioMixer	Lcom/tencent/tav/decoder/AudioMixer;
    //   529: aload_3
    //   530: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   533: invokevirtual 92	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   536: aload_0
    //   537: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   540: invokevirtual 206	com/tencent/tav/decoder/AudioMixer:mergeSamples	(Ljava/nio/ShortBuffer;Ljava/nio/ShortBuffer;)Ljava/nio/ByteBuffer;
    //   543: astore_1
    //   544: new 82	com/tencent/tav/coremedia/CMSampleBuffer
    //   547: dup
    //   548: aload_3
    //   549: invokevirtual 130	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   552: aload_1
    //   553: invokespecial 209	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;Ljava/nio/ByteBuffer;)V
    //   556: astore 9
    //   558: goto -525 -> 33
    //   561: aload_0
    //   562: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   565: invokevirtual 211	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   568: pop
    //   569: goto -469 -> 100
    //   572: astore_1
    //   573: aload_0
    //   574: monitorexit
    //   575: aload_1
    //   576: athrow
    //   577: aload_0
    //   578: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   581: aload_0
    //   582: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   585: invokevirtual 124	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   588: pop
    //   589: aload_0
    //   590: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   593: aload_0
    //   594: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   597: invokevirtual 97	java/nio/ShortBuffer:limit	()I
    //   600: invokevirtual 126	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   603: pop
    //   604: goto -409 -> 195
    //   607: fconst_1
    //   608: fstore 4
    //   610: goto -295 -> 315
    //   613: aload_0
    //   614: getfield 63	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   617: invokevirtual 211	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   620: pop
    //   621: goto -161 -> 460
    //   624: astore_1
    //   625: aload_0
    //   626: getfield 41	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   629: aload_1
    //   630: invokestatic 215	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   633: new 82	com/tencent/tav/coremedia/CMSampleBuffer
    //   636: dup
    //   637: getstatic 162	com/tencent/tav/decoder/IDecoder:SAMPLE_TIME_FINISH	Lcom/tencent/tav/coremedia/CMTime;
    //   640: aconst_null
    //   641: checkcast 88	java/nio/ByteBuffer
    //   644: invokespecial 209	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;Ljava/nio/ByteBuffer;)V
    //   647: astore 9
    //   649: goto -616 -> 33
    //   652: aload_0
    //   653: getfield 61	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   656: aload 9
    //   658: invokevirtual 124	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   661: pop
    //   662: aload 9
    //   664: invokevirtual 97	java/nio/ShortBuffer:limit	()I
    //   667: istore 7
    //   669: iload 7
    //   671: iload 5
    //   673: iadd
    //   674: istore 5
    //   676: iload 6
    //   678: istore 7
    //   680: goto -476 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	this	AudioCompositor
    //   0	683	1	paramAudioDecoderTrack	com.tencent.tav.decoder.AudioDecoderTrack
    //   0	683	2	paramAudioMixInputParameters	AudioMixInputParameters
    //   0	683	3	paramCMSampleBuffer	com.tencent.tav.coremedia.CMSampleBuffer
    //   313	296	4	f	float
    //   136	539	5	i	int
    //   145	532	6	j	int
    //   1	678	7	k	int
    //   48	455	8	m	int
    //   31	632	9	localObject	Object
    //   219	149	10	localCMSampleBuffer	com.tencent.tav.coremedia.CMSampleBuffer
    // Exception table:
    //   from	to	target	type
    //   9	16	572	finally
    //   20	30	572	finally
    //   38	69	572	finally
    //   69	100	572	finally
    //   100	195	572	finally
    //   195	204	572	finally
    //   211	221	572	finally
    //   225	268	572	finally
    //   277	300	572	finally
    //   304	315	572	finally
    //   319	327	572	finally
    //   331	366	572	finally
    //   366	432	572	finally
    //   432	460	572	finally
    //   460	517	572	finally
    //   517	558	572	finally
    //   561	569	572	finally
    //   577	604	572	finally
    //   613	621	572	finally
    //   625	649	572	finally
    //   652	669	572	finally
    //   211	221	624	java/lang/Throwable
    //   225	268	624	java/lang/Throwable
    //   277	300	624	java/lang/Throwable
    //   304	315	624	java/lang/Throwable
    //   319	327	624	java/lang/Throwable
    //   331	366	624	java/lang/Throwable
    //   366	432	624	java/lang/Throwable
    //   432	460	624	java/lang/Throwable
    //   460	517	624	java/lang/Throwable
    //   517	558	624	java/lang/Throwable
    //   613	621	624	java/lang/Throwable
    //   652	669	624	java/lang/Throwable
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositor
 * JD-Core Version:    0.7.0.1
 */