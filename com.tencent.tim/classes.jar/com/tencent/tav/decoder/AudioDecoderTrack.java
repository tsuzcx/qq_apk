package com.tencent.tav.decoder;

import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudioDecoderTrack
  implements IDecoderTrack
{
  private static String TAG = "AudioDecoderTrack";
  private float _speed = 1.0F;
  private AudioInfo audioInfo = new AudioInfo();
  private AudioMixer audioMixer = new AudioMixer();
  private AudioDecoder currentDecoder;
  private final Object currentDecoderLock = new Object();
  private CMTime currentSegmentStartTime = CMTime.CMTimeZero;
  private IDecoder.DecodeType decodeType = IDecoder.DecodeType.Audio;
  private AudioDecoderCreateThread decoderCreateThread = null;
  private final DecoderThread decoderThread = new DecoderThread();
  private CMTime duration = CMTime.CMTimeZero;
  private ByteBuffer emptyAudioBuffer;
  private CMTime frameDuration = new CMTime(92880L, 1000000);
  private int frameRate = 11;
  private boolean isEmptyFrame = false;
  private boolean isReleased = false;
  private CMTime lastSampleTime = CMTime.CMTimeInvalid;
  private DecoderWrapper nextDecoder;
  private final Object nextDecoderLock = new Object();
  private boolean preRead = false;
  private int segmentIndex = -1;
  private ArrayList<DecoderTrackSegment> segments = new ArrayList();
  private boolean started = false;
  private int trackID = -1;
  private float volume = 1.0F;
  
  /* Error */
  private IDecoder createDecoder(@NonNull DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 193	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   6: astore 8
    //   8: getstatic 68	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   11: new 195	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   18: ldc 198
    //   20: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload 8
    //   25: getfield 207	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   28: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 209
    //   33: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 218	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: iconst_5
    //   47: istore_3
    //   48: aconst_null
    //   49: astore 5
    //   51: aload 5
    //   53: ifnonnull +586 -> 639
    //   56: iload_3
    //   57: ifle +582 -> 639
    //   60: iload_3
    //   61: iconst_1
    //   62: isub
    //   63: istore_3
    //   64: aload_0
    //   65: getfield 116	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   68: ifnull +206 -> 274
    //   71: aload_0
    //   72: getfield 116	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   75: invokestatic 222	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:access$000	(Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;)I
    //   78: istore 4
    //   80: iload 4
    //   82: aload_0
    //   83: getfield 95	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   86: invokevirtual 226	java/util/ArrayList:size	()I
    //   89: if_icmpge +158 -> 247
    //   92: aload_0
    //   93: getfield 95	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   96: iload 4
    //   98: invokevirtual 230	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   101: checkcast 189	com/tencent/tav/decoder/DecoderTrackSegment
    //   104: invokevirtual 193	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   107: aload 8
    //   109: invokestatic 158	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   112: ifeq +135 -> 247
    //   115: aload_0
    //   116: getfield 118	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   119: astore 6
    //   121: aload 6
    //   123: monitorenter
    //   124: aload_0
    //   125: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   128: ifnull +116 -> 244
    //   131: aload_0
    //   132: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   135: getfield 234	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   138: aload 8
    //   140: invokestatic 158	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   143: ifeq +101 -> 244
    //   146: aload_0
    //   147: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   150: getfield 238	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   153: ifnull +91 -> 244
    //   156: aload_0
    //   157: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   160: getfield 238	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   163: astore_2
    //   164: aload_0
    //   165: getfield 95	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   168: aload_0
    //   169: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   172: getfield 239	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   175: invokevirtual 230	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   178: aload_1
    //   179: if_acmpeq +17 -> 196
    //   182: aload_2
    //   183: aload_1
    //   184: invokevirtual 243	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   187: aload_1
    //   188: invokevirtual 247	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   191: invokeinterface 253 3 0
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   201: getstatic 68	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   204: new 195	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   211: ldc 255
    //   213: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_2
    //   217: invokeinterface 258 1 0
    //   222: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 218	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload 6
    //   237: monitorexit
    //   238: aload_2
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: areturn
    //   244: aload 6
    //   246: monitorexit
    //   247: aload_1
    //   248: invokevirtual 243	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   251: astore 6
    //   253: aload 6
    //   255: ifnonnull +251 -> 506
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -20 -> 240
    //   263: astore_1
    //   264: aload 6
    //   266: monitorexit
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aload_0
    //   271: monitorexit
    //   272: aload_1
    //   273: athrow
    //   274: getstatic 68	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   277: new 195	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 260
    //   287: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 8
    //   292: getfield 207	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   295: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 218	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: aload_0
    //   309: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   312: ifnull -65 -> 247
    //   315: aload_0
    //   316: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   319: getfield 234	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   322: aload 8
    //   324: invokestatic 158	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   327: ifeq -80 -> 247
    //   330: aload_0
    //   331: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   334: getfield 238	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   337: ifnull -90 -> 247
    //   340: aload_0
    //   341: getfield 118	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   344: astore 6
    //   346: aload 6
    //   348: monitorenter
    //   349: aload_0
    //   350: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   353: ifnull +147 -> 500
    //   356: aload_0
    //   357: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   360: getfield 234	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   363: aload 8
    //   365: if_acmpne +135 -> 500
    //   368: aload_0
    //   369: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   372: getfield 238	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   375: ifnull +125 -> 500
    //   378: aload_0
    //   379: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   382: getfield 238	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   385: astore_2
    //   386: aload_0
    //   387: getfield 95	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   390: aload_0
    //   391: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   394: getfield 239	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   397: invokevirtual 230	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   400: aload_1
    //   401: if_acmpeq +17 -> 418
    //   404: aload_2
    //   405: aload_1
    //   406: invokevirtual 243	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   409: aload_1
    //   410: invokevirtual 247	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   413: invokeinterface 253 3 0
    //   418: getstatic 68	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   421: new 195	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   428: ldc 255
    //   430: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_2
    //   434: invokeinterface 258 1 0
    //   439: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc_w 262
    //   445: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_0
    //   449: getfield 104	com/tencent/tav/decoder/AudioDecoderTrack:segmentIndex	I
    //   452: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   455: ldc_w 267
    //   458: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_0
    //   462: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   465: getfield 239	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   468: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: iconst_0
    //   475: anewarray 4	java/lang/Object
    //   478: invokestatic 218	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: aload_0
    //   482: aconst_null
    //   483: putfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   486: aload 6
    //   488: monitorexit
    //   489: aload_2
    //   490: astore_1
    //   491: goto -251 -> 240
    //   494: astore_1
    //   495: aload 6
    //   497: monitorexit
    //   498: aload_1
    //   499: athrow
    //   500: aload 6
    //   502: monitorexit
    //   503: goto -256 -> 247
    //   506: new 269	com/tencent/tav/decoder/AudioDecoder
    //   509: dup
    //   510: aload 8
    //   512: getfield 207	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   515: invokespecial 272	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;)V
    //   518: astore 6
    //   520: aload 6
    //   522: aload_1
    //   523: invokevirtual 243	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   526: aload_2
    //   527: invokeinterface 253 3 0
    //   532: getstatic 68	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   535: new 195	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   542: ldc_w 274
    //   545: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload 8
    //   550: getfield 207	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   553: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: iconst_0
    //   560: anewarray 4	java/lang/Object
    //   563: invokestatic 218	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: aload 6
    //   568: astore 5
    //   570: goto -519 -> 51
    //   573: astore 7
    //   575: aload 6
    //   577: astore 5
    //   579: aload 7
    //   581: astore 6
    //   583: getstatic 68	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   586: new 195	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   593: ldc_w 276
    //   596: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 6
    //   601: invokevirtual 279	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   604: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload 6
    //   609: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 286	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 5
    //   620: ifnull +10 -> 630
    //   623: aload 5
    //   625: invokeinterface 289 1 0
    //   630: aconst_null
    //   631: astore 5
    //   633: goto -582 -> 51
    //   636: astore_1
    //   637: aload_1
    //   638: athrow
    //   639: aload 5
    //   641: astore_1
    //   642: goto -402 -> 240
    //   645: astore 5
    //   647: goto -17 -> 630
    //   650: astore 6
    //   652: goto -69 -> 583
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	this	AudioDecoderTrack
    //   0	655	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	655	2	paramCMTime	CMTime
    //   47	17	3	i	int
    //   78	19	4	j	int
    //   49	591	5	localObject1	Object
    //   645	1	5	localException1	Exception
    //   119	489	6	localObject2	Object
    //   650	1	6	localException2	Exception
    //   573	7	7	localException3	Exception
    //   6	543	8	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   124	196	263	finally
    //   196	238	263	finally
    //   244	247	263	finally
    //   264	267	263	finally
    //   2	46	269	finally
    //   64	124	269	finally
    //   247	253	269	finally
    //   267	269	269	finally
    //   274	349	269	finally
    //   498	500	269	finally
    //   506	520	269	finally
    //   520	566	269	finally
    //   583	618	269	finally
    //   637	639	269	finally
    //   349	418	494	finally
    //   418	489	494	finally
    //   495	498	494	finally
    //   500	503	494	finally
    //   520	566	573	java/lang/Exception
    //   623	630	636	finally
    //   623	630	645	java/lang/Exception
    //   506	520	650	java/lang/Exception
  }
  
  private void createNextDecoder(int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.segments != null)
        {
          bool = this.preRead;
          if (bool) {}
        }
        else
        {
          return;
        }
        int i = paramInt + 1;
        if ((i >= this.segments.size()) || (this.decoderCreateThread != null)) {
          continue;
        }
        DecoderAssetTrack localDecoderAssetTrack = ((DecoderTrackSegment)this.segments.get(i)).getVideoAsset();
        if (localDecoderAssetTrack != null)
        {
          if (this.nextDecoder != null)
          {
            bool = isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack);
            if (bool) {
              continue;
            }
          }
          try
          {
            this.decoderCreateThread = new AudioDecoderCreateThread(localDecoderAssetTrack, null, i, null);
            this.decoderCreateThread.start();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          continue;
        }
        if (this.nextDecoder == null) {
          continue;
        }
      }
      finally {}
      if ((paramInt >= 0) && (paramInt < this.segments.size()) && (this.nextDecoder.segmentIndex != paramInt))
      {
        this.nextDecoder.decoder.start(((DecoderTrackSegment)this.segments.get(paramInt)).getTimeRange());
        this.nextDecoder.segmentIndex = paramInt;
      }
    }
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        if (this.isReleased)
        {
          Logger.e(TAG, "doReadSample: has released");
          paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
          return paramCMTime;
        }
        paramCMTime = IDecoder.SAMPLE_TIME_FINISH;
        this.isEmptyFrame = false;
        if (this.segmentIndex != -1) {
          break;
        }
        if (Logger.LOG_VERBOSE) {
          Logger.e(TAG, "doReadSample: segmentIndex == -1");
        }
        if (this.lastSampleTime.smallThan(IDecoder.SAMPLE_TIME_FINISH))
        {
          paramCMTime = new CMSampleBuffer(AudioDecoder.SAMPLE_TIME_UNSTART);
          return paramCMTime;
        }
      }
      finally {}
      paramCMTime = new CMSampleBuffer(VideoDecoder.SAMPLE_TIME_FINISH);
    }
    Object localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    CMTime localCMTime2 = this.lastSampleTime.clone();
    CMTime localCMTime1;
    if (this.currentDecoder == null)
    {
      localCMTime1 = localCMTime2.add(this.frameDuration);
      if (localCMTime2.equalsTo(CMTime.CMTimeInvalid)) {
        localCMTime1 = CMTime.CMTimeZero;
      }
      if (!localCMTime1.smallThan(this.currentSegmentStartTime.add(((DecoderTrackSegment)localObject1).getScaledDuration()))) {
        break label656;
      }
      this.isEmptyFrame = true;
      if (Logger.LOG_VERBOSE) {
        Logger.d(TAG, "doReadSample: return emptyBuffer currentDecoder == null");
      }
      paramCMTime = new CMSampleBuffer(localCMTime1, outputBuffer());
      return paramCMTime;
    }
    label645:
    label656:
    for (;;)
    {
      if (paramCMTime.equalsTo(IDecoder.SAMPLE_TIME_FINISH))
      {
        localObject1 = ((DecoderTrackSegment)localObject1).getScaledDuration().add(this.currentSegmentStartTime);
        localCMTime1 = localCMTime2.add(this.frameDuration);
        if (((CMTime)localObject1).bigThan(localCMTime1))
        {
          if (this.currentDecoder == null) {}
          for (paramCMTime = getEmptyAudioBuffer();; paramCMTime = this.currentDecoder.outputBuffer())
          {
            if (Logger.LOG_VERBOSE) {
              Logger.i(TAG, "doReadSample: finish && !end", new Object[0]);
            }
            localObject1 = paramCMTime;
            if (paramCMTime == null) {
              localObject1 = getEmptyAudioBuffer();
            }
            paramCMTime = new CMSampleBuffer(localCMTime1, (ByteBuffer)localObject1);
            return paramCMTime;
            if (localCMTime2.sub(this.currentSegmentStartTime).multi(this._speed).bigThan(((DecoderTrackSegment)localObject1).getScaledDuration().multi(this._speed)))
            {
              paramCMTime = IDecoder.SAMPLE_TIME_FINISH;
              break;
            }
            paramCMTime = this.currentDecoder.readSample(CMTime.CMTimeInvalid);
            break;
          }
        }
        if (!nextSegment(true))
        {
          if (Logger.LOG_VERBOSE) {
            Logger.i(TAG, "doReadSample: finish && end && next failed", new Object[0]);
          }
          localObject1 = AudioDecoder.SAMPLE_TIME_FINISH;
          if (this.currentDecoder == null) {}
          for (paramCMTime = localObject3;; paramCMTime = this.currentDecoder.outputBuffer())
          {
            paramCMTime = new CMSampleBuffer((CMTime)localObject1, paramCMTime);
            return paramCMTime;
          }
        }
        localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
        break;
      }
      if (paramCMTime.getTimeUs() >= 0L)
      {
        localCMTime1 = paramCMTime.sub(((DecoderTrackSegment)localObject1).getDecoderStartTime()).divide(this._speed);
        paramCMTime = localCMTime1;
        if (localCMTime1.getTimeUs() > ((DecoderTrackSegment)localObject1).getScaledDuration().getTimeUs()) {
          paramCMTime = ((DecoderTrackSegment)localObject1).getScaledDuration();
        }
        localObject1 = paramCMTime.add(this.currentSegmentStartTime);
        if (Logger.LOG_VERBOSE) {
          Logger.i(TAG, "doReadSample: [success] " + localObject1, new Object[0]);
        }
        if (this.currentDecoder != null) {
          break label645;
        }
      }
      for (paramCMTime = localObject2;; paramCMTime = this.currentDecoder.outputBuffer())
      {
        paramCMTime = new CMSampleBuffer((CMTime)localObject1, paramCMTime);
        return paramCMTime;
        if ((paramCMTime.getValue() != AudioDecoder.SAMPLE_TIME_ERROR.getValue()) && (paramCMTime.getValue() != AudioDecoder.SAMPLE_TIME_UNSTART.getValue()))
        {
          paramCMTime = new CMSampleBuffer(localCMTime2);
          return paramCMTime;
        }
        paramCMTime = new CMSampleBuffer(paramCMTime);
        return paramCMTime;
      }
    }
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Iterator localIterator = this.segments.iterator();
    int i = 0;
    CMTime localCMTime2;
    if (localIterator.hasNext())
    {
      localCMTime2 = ((DecoderTrackSegment)localIterator.next()).getScaledDuration();
      if ((paramCMTime.compare(localCMTime1) < 0) || (!paramCMTime.smallThan(localCMTime1.add(localCMTime2)))) {}
    }
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && (paramCMTime == localCMTime1) && (i > 0) && (paramBoolean))
      {
        i -= 1;
        j = 1;
      }
      for (;;)
      {
        if (j != 0)
        {
          return i;
          localCMTime1 = localCMTime1.add(localCMTime2);
          i += 1;
          break;
        }
        return -1;
      }
    }
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while (i < paramInt)
    {
      localCMTime = CMTime.add(localCMTime, ((DecoderTrackSegment)this.segments.get(i)).getScaledDuration());
      i += 1;
    }
    return localCMTime;
  }
  
  private static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    return (paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath));
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    Logger.d(TAG, "nextSegment:" + paramBoolean);
    this.segmentIndex += 1;
    if (this.segmentIndex >= this.segments.size())
    {
      this.segmentIndex = -1;
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleTime = this.currentSegmentStartTime;
    if (this.lastSampleTime.equalsTo(CMTime.CMTimeZero)) {
      this.lastSampleTime = CMTime.CMTimeInvalid;
    }
    Object localObject2 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    IDecoder localIDecoder;
    if (((DecoderTrackSegment)localObject2).getVideoAsset() != null) {
      synchronized (this.currentDecoderLock)
      {
        if ((this.currentDecoder != null) && (this.currentDecoder.getSourcePath() != null))
        {
          new ReleaseDecoderThread(this.currentDecoder).start();
          this.currentDecoder = null;
        }
        if (paramBoolean)
        {
          ??? = ((DecoderTrackSegment)this.segments.get(this.segmentIndex)).getDecoderStartTime();
          localIDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
        }
      }
    }
    for (;;)
    {
      synchronized (this.currentDecoderLock)
      {
        this.currentDecoder = ((AudioDecoder)localIDecoder);
        if (this.audioMixer != null) {
          this.audioMixer.release();
        }
        this.audioMixer = new AudioMixer();
        if ((this.currentDecoder != null) && (this.currentDecoder.hasTrack()) && (paramBoolean)) {
          this.currentDecoder.seekTo(((DecoderTrackSegment)localObject2).getDecoderStartTime());
        }
        if (((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs() > 0L) {
          this._speed = ((float)((DecoderTrackSegment)localObject2).getTimeRange().getDurationUs() * 1.0F / (float)((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs());
        }
        ??? = TAG;
        localObject2 = new StringBuilder().append("nextSegment:");
        if (this.currentDecoder != null) {
          break label427;
        }
        paramBoolean = true;
        Logger.d((String)???, paramBoolean + " " + this._speed);
        return true;
        localObject3 = finally;
        throw localObject3;
        ??? = CMTime.CMTimeInvalid;
      }
      Logger.e(TAG, "nextSegment: videoAsset is null");
      synchronized (this.currentDecoderLock)
      {
        if (this.currentDecoder != null)
        {
          new ReleaseDecoderThread(this.currentDecoder).start();
          this.currentDecoder = null;
        }
      }
      label427:
      paramBoolean = false;
    }
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    if (this.decoderThread.pcmFrame == null) {
      synchronized (this.decoderThread)
      {
        if (this.decoderThread.pcmFrame == null) {
          this.decoderThread.action();
        }
        return;
      }
    }
  }
  
  public void clearTimeRanges()
  {
    release();
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0)) {}
    CMTime localCMTime2;
    CMTime localCMTime3;
    do
    {
      return;
      CMTime localCMTime1 = paramCMTimeRange.getStart();
      localCMTime2 = paramCMTimeRange.getEnd();
      localCMTime3 = duration();
      clipRangeAndRemoveRange(paramCMTimeRange);
      if (localCMTime1.getValue() != 0L) {
        this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1), null));
      }
    } while (localCMTime2.getTimeUs() >= localCMTime3.getTimeUs());
    this.segments.add(new DecoderTrackSegment(new CMTimeRange(localCMTime2, new CMTime(localCMTime3.getTimeSeconds() - localCMTime2.getTimeSeconds())), null));
  }
  
  public void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0)) {}
    Object localObject;
    CMTime localCMTime1;
    int k;
    do
    {
      return;
      localObject = paramCMTimeRange.getStart();
      localCMTime1 = paramCMTimeRange.getEnd();
      k = findSegmentIndexAt((CMTime)localObject, false);
    } while (k == -1);
    int i = findSegmentIndexAt(localCMTime1, false);
    if (i == -1) {
      i = this.segments.size() - 1;
    }
    for (;;)
    {
      localCMTime1 = getSegmentStartTime(k);
      CMTime localCMTime2 = getSegmentStartTime(i);
      localObject = (DecoderTrackSegment)this.segments.get(k);
      DecoderTrackSegment localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(i);
      localCMTime2 = paramCMTimeRange.getEnd().sub(localCMTime2);
      float f = (float)localDecoderTrackSegment.getScaledDuration().getTimeUs() * 1.0F / (float)localDecoderTrackSegment.getTimeRange().getDurationUs();
      localDecoderTrackSegment.setTimeRange(new CMTimeRange(localDecoderTrackSegment.getTimeRange().getStart(), localCMTime2.divide(f)));
      localDecoderTrackSegment.setScaledDuration(localCMTime2);
      f = (float)((DecoderTrackSegment)localObject).getScaledDuration().getTimeUs() * 1.0F / (float)((DecoderTrackSegment)localObject).getTimeRange().getDurationUs();
      paramCMTimeRange = paramCMTimeRange.getStart().sub(localCMTime1);
      localCMTime1 = paramCMTimeRange.divide(f);
      ((DecoderTrackSegment)localObject).setTimeRange(new CMTimeRange(((DecoderTrackSegment)localObject).getTimeRange().getStart().add(localCMTime1), ((DecoderTrackSegment)localObject).getTimeRange().getDuration().sub(localCMTime1)));
      ((DecoderTrackSegment)localObject).setScaledDuration(((DecoderTrackSegment)localObject).getScaledDuration().sub(paramCMTimeRange));
      int j = this.segments.size() - 1;
      while (j >= 0)
      {
        if ((j > i) || (j < k)) {
          this.segments.remove(j);
        }
        j -= 1;
      }
      break;
      if (getSegmentStartTime(i) == localCMTime1) {
        i -= 1;
      }
    }
  }
  
  public CMTime duration()
  {
    return getSegmentStartTime(this.segments.size());
  }
  
  public AudioInfo getAudioInfo()
  {
    if (this.currentDecoder != null) {
      return this.currentDecoder.getAudioInfo();
    }
    return this.audioInfo;
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMTime getDuration()
  {
    if (this.duration == CMTime.CMTimeZero)
    {
      CMTime localCMTime = CMTime.CMTimeZero;
      Iterator localIterator = this.segments.iterator();
      while (localIterator.hasNext()) {
        localCMTime = localCMTime.add(((DecoderTrackSegment)localIterator.next()).getScaledDuration());
      }
      this.duration = localCMTime;
    }
    return this.duration;
  }
  
  public ByteBuffer getEmptyAudioBuffer()
  {
    if (this.emptyAudioBuffer == null)
    {
      long l = this.audioInfo.channelCount * this.audioInfo.sampleRate * this.frameDuration.getTimeUs() / 1000000L;
      this.emptyAudioBuffer = ByteBuffer.allocate((int)l * 2);
      this.emptyAudioBuffer.order(ByteOrder.LITTLE_ENDIAN);
      short[] arrayOfShort = new short[(int)l];
      int i = 0;
      while (i < l)
      {
        arrayOfShort[i] = 0;
        i += 1;
      }
      this.emptyAudioBuffer.asShortBuffer().put(arrayOfShort, 0, (int)l);
    }
    this.emptyAudioBuffer.position(0);
    return this.emptyAudioBuffer;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public int getTrackId()
  {
    return this.trackID;
  }
  
  public ByteBuffer outputBuffer()
  {
    if (this.isEmptyFrame) {
      return getEmptyAudioBuffer();
    }
    if (this.currentDecoder == null) {
      return null;
    }
    return this.currentDecoder.outputBuffer();
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    try
    {
      if (this.audioMixer.getDestAudioChannelCount() != paramAudioInfo.channelCount)
      {
        this.audioMixer.release();
        this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
      }
      paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      return paramByteBuffer;
    }
    finally {}
  }
  
  public CMSampleBuffer readSample()
  {
    return readSample(CMTime.CMTimeInvalid);
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    if (Logger.LOG_VERBOSE) {
      Logger.d(TAG, "readSample: [start]" + paramCMTime);
    }
    if (this.isReleased)
    {
      Logger.e(TAG, "readSample: [error] has released");
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    }
    do
    {
      return paramCMTime;
      synchronized (this.decoderThread.nextFrameDecoderLock)
      {
        if ((this.decoderThread.pcmFrame != null) && (DecoderThread.access$200(this.decoderThread).frameTime == this.lastSampleTime))
        {
          paramCMTime = DecoderThread.access$200(this.decoderThread).sampleBuffer;
          this.lastSampleTime = DecoderThread.access$200(this.decoderThread).frameTime;
          createNextDecoder(this.segmentIndex);
          if (Logger.LOG_VERBOSE) {
            Logger.d(TAG, "readSample: [success] hit asyncRead - " + this.lastSampleTime);
          }
          return paramCMTime;
        }
      }
      ??? = doReadSample(paramCMTime);
      if ((((CMSampleBuffer)???).getSampleByteBuffer() != null) && (this._speed > 0.1F) && (this._speed < 16.0F))
      {
        if (Logger.LOG_VERBOSE) {
          Logger.i(TAG, "readSample: processFrame [volume " + this.volume + "] [_speed " + this._speed + "]", new Object[0]);
        }
        ((CMSampleBuffer)???).setSampleByteBuffer(processFrame(((CMSampleBuffer)???).getSampleByteBuffer(), this.volume, this._speed, getAudioInfo()));
        if (Logger.LOG_VERBOSE) {
          Logger.i(TAG, "readSample: processFrame finish [volume " + this.volume + "] [_speed " + this._speed + "]", new Object[0]);
        }
      }
      this.lastSampleTime = ((CMSampleBuffer)???).getTime();
      createNextDecoder(this.segmentIndex);
      paramCMTime = (CMTime)???;
    } while (!Logger.LOG_VERBOSE);
    Logger.d(TAG, "readSample: [success]  - " + this.lastSampleTime);
    return ???;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 68	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   5: ldc_w 623
    //   8: invokestatic 346	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 127	com/tencent/tav/decoder/AudioDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderThread;
    //   15: invokevirtual 624	com/tencent/tav/decoder/AudioDecoderTrack$DecoderThread:release	()V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 122	com/tencent/tav/decoder/AudioDecoderTrack:isReleased	Z
    //   23: aload_0
    //   24: getfield 162	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   27: ifnull +15 -> 42
    //   30: aload_0
    //   31: getfield 162	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   34: invokevirtual 625	com/tencent/tav/decoder/AudioDecoder:release	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 162	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   42: aload_0
    //   43: getfield 118	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   46: astore_1
    //   47: aload_1
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   53: ifnull +15 -> 68
    //   56: aload_0
    //   57: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   60: invokestatic 629	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 151	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   68: aload_1
    //   69: monitorexit
    //   70: getstatic 68	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   73: ldc_w 631
    //   76: invokestatic 346	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_2
    //   83: aload_1
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	AudioDecoderTrack
    //   87	4	1	localObject2	Object
    //   82	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	68	82	finally
    //   68	70	82	finally
    //   83	85	82	finally
    //   2	42	87	finally
    //   42	49	87	finally
    //   70	79	87	finally
    //   85	87	87	finally
  }
  
  public CMTime sampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Logger.LOG_VERBOSE) {
      Logger.d(TAG, "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    }
    if (this.isReleased)
    {
      Logger.e(TAG, "seekTo: [failed] has released");
      return new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    }
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      DecoderThread.access$202(this.decoderThread, null);
      if (!this.started)
      {
        Logger.e(TAG, "seekTo: [failed] un started");
        return null;
      }
    }
    int i = findSegmentIndexAt(paramCMTime, true);
    if (i == -1)
    {
      this.segmentIndex = -1;
      Logger.e(TAG, "seekTo: [failed] segmentIndex = -1");
      return null;
    }
    ??? = getSegmentStartTime(i);
    if ((this.segmentIndex != i) || (this.currentDecoder == null))
    {
      this.segmentIndex = (i - 1);
      nextSegment(false);
    }
    ??? = paramCMTime.sub((CMTime)???).multi(this._speed);
    DecoderTrackSegment localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    if (this.currentDecoder == null)
    {
      this.lastSampleTime = paramCMTime;
      Logger.e(TAG, "seekTo: [failed] currentDecoder == null ");
      return null;
    }
    this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???));
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleTime = paramCMTime.sub(this.frameDuration);; this.lastSampleTime = paramCMTime)
    {
      if (Logger.LOG_VERBOSE) {
        Logger.d(TAG, "seekTo: [success] [lastSampleTime " + this.lastSampleTime + "]");
      }
      return null;
    }
  }
  
  public void setAudioInfo(@NonNull AudioInfo paramAudioInfo)
  {
    this.audioInfo = paramAudioInfo.clone();
    if (this.emptyAudioBuffer != null) {
      this.emptyAudioBuffer = null;
    }
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.frameDuration = this.frameDuration.divide(paramInt / this.frameRate);
    this.frameRate = paramInt;
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
  
  public float speed()
  {
    return this._speed;
  }
  
  public void start()
  {
    start(null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    start(paramSurfaceCreator, null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    if (this.segments.size() == 0)
    {
      release();
      return;
    }
    this.isReleased = false;
    this.decoderThread.start();
    this.started = true;
    this.segmentIndex = -1;
    clipRangeAndRemoveRange(paramCMTimeRange);
    nextSegment(true);
  }
  
  class AudioDecoderCreateThread
    extends Thread
  {
    DecoderAssetTrack extractor;
    private Surface outputSurface;
    private int segmentIndex = 0;
    
    private AudioDecoderCreateThread(DecoderAssetTrack paramDecoderAssetTrack, Surface paramSurface, int paramInt)
    {
      super();
      this.extractor = paramDecoderAssetTrack;
      this.outputSurface = paramSurface;
      this.segmentIndex = paramInt;
    }
    
    /* Error */
    private void createDecoder()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   4: invokestatic 62	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   7: ifnull +43 -> 50
      //   10: aload_0
      //   11: getfield 45	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   14: aload_0
      //   15: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   18: invokestatic 62	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   21: invokevirtual 68	java/util/ArrayList:size	()I
      //   24: if_icmpge +26 -> 50
      //   27: aload_0
      //   28: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   31: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   34: ifne +16 -> 50
      //   37: aload_0
      //   38: getfield 47	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   41: getfield 36	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   44: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   47: ifeq +35 -> 82
      //   50: invokestatic 81	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   53: new 21	java/lang/StringBuilder
      //   56: dup
      //   57: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   60: ldc 83
      //   62: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   65: aload_0
      //   66: getfield 47	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   69: getfield 36	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   72: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   78: invokestatic 89	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   81: return
      //   82: new 91	com/tencent/tav/decoder/AudioDecoder
      //   85: dup
      //   86: aload_0
      //   87: getfield 47	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   90: getfield 36	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   93: invokespecial 92	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;)V
      //   96: astore_2
      //   97: aload_2
      //   98: astore_1
      //   99: aload_2
      //   100: aload_0
      //   101: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   104: invokestatic 62	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   107: aload_0
      //   108: getfield 45	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   111: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   114: checkcast 98	com/tencent/tav/decoder/DecoderTrackSegment
      //   117: invokevirtual 102	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
      //   120: aload_0
      //   121: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   124: invokestatic 62	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   127: aload_0
      //   128: getfield 45	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   131: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   134: checkcast 98	com/tencent/tav/decoder/DecoderTrackSegment
      //   137: invokevirtual 106	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
      //   140: invokeinterface 112 3 0
      //   145: aload_2
      //   146: astore_1
      //   147: aload_0
      //   148: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   151: new 114	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper
      //   154: dup
      //   155: aconst_null
      //   156: invokespecial 117	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:<init>	(Lcom/tencent/tav/decoder/AudioDecoderTrack$1;)V
      //   159: invokestatic 121	com/tencent/tav/decoder/AudioDecoderTrack:access$1102	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   162: pop
      //   163: aload_2
      //   164: astore_1
      //   165: aload_0
      //   166: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   169: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   172: aload_2
      //   173: putfield 129	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
      //   176: aload_2
      //   177: astore_1
      //   178: aload_0
      //   179: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   182: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   185: aload_0
      //   186: getfield 47	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   189: putfield 130	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   192: aload_2
      //   193: astore_1
      //   194: aload_0
      //   195: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   198: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   201: aload_0
      //   202: getfield 45	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   205: putfield 131	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
      //   208: aload_2
      //   209: astore_1
      //   210: invokestatic 81	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   213: new 21	java/lang/StringBuilder
      //   216: dup
      //   217: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   220: ldc 133
      //   222: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   225: aload_0
      //   226: getfield 47	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   229: getfield 36	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   232: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   235: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   238: invokestatic 136	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   241: aload_0
      //   242: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   245: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   248: ifeq -167 -> 81
      //   251: invokestatic 81	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   254: ldc 138
      //   256: invokestatic 89	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   259: aload_2
      //   260: ifnull +9 -> 269
      //   263: aload_2
      //   264: invokeinterface 141 1 0
      //   269: aload_0
      //   270: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   273: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   276: ifnull -195 -> 81
      //   279: aload_0
      //   280: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   283: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   286: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   289: return
      //   290: astore_1
      //   291: return
      //   292: astore_3
      //   293: aconst_null
      //   294: astore_2
      //   295: aload_2
      //   296: astore_1
      //   297: aload_3
      //   298: invokevirtual 148	java/lang/Exception:printStackTrace	()V
      //   301: aload_2
      //   302: ifnull +11 -> 313
      //   305: aload_2
      //   306: astore_1
      //   307: aload_2
      //   308: invokeinterface 141 1 0
      //   313: aload_0
      //   314: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   317: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   320: ifeq -239 -> 81
      //   323: invokestatic 81	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   326: ldc 138
      //   328: invokestatic 89	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   331: aload_2
      //   332: ifnull +9 -> 341
      //   335: aload_2
      //   336: invokeinterface 141 1 0
      //   341: aload_0
      //   342: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   345: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   348: ifnull -267 -> 81
      //   351: aload_0
      //   352: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   355: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   358: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   361: return
      //   362: astore_1
      //   363: return
      //   364: astore_2
      //   365: aconst_null
      //   366: astore_1
      //   367: aload_0
      //   368: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   371: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   374: ifeq +41 -> 415
      //   377: invokestatic 81	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   380: ldc 138
      //   382: invokestatic 89	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   385: aload_1
      //   386: ifnull +9 -> 395
      //   389: aload_1
      //   390: invokeinterface 141 1 0
      //   395: aload_0
      //   396: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   399: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   402: ifnull +13 -> 415
      //   405: aload_0
      //   406: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   409: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   412: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   415: aload_2
      //   416: athrow
      //   417: astore_1
      //   418: goto -149 -> 269
      //   421: astore_1
      //   422: goto -109 -> 313
      //   425: astore_1
      //   426: goto -85 -> 341
      //   429: astore_1
      //   430: goto -35 -> 395
      //   433: astore_1
      //   434: goto -19 -> 415
      //   437: astore_2
      //   438: goto -71 -> 367
      //   441: astore_3
      //   442: goto -147 -> 295
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	445	0	this	AudioDecoderCreateThread
      //   98	112	1	localAudioDecoder1	AudioDecoder
      //   290	1	1	localException1	Exception
      //   296	11	1	localAudioDecoder2	AudioDecoder
      //   362	1	1	localException2	Exception
      //   366	24	1	localObject1	Object
      //   417	1	1	localException3	Exception
      //   421	1	1	localException4	Exception
      //   425	1	1	localException5	Exception
      //   429	1	1	localException6	Exception
      //   433	1	1	localException7	Exception
      //   96	240	2	localAudioDecoder3	AudioDecoder
      //   364	52	2	localObject2	Object
      //   437	1	2	localObject3	Object
      //   292	6	3	localException8	Exception
      //   441	1	3	localException9	Exception
      // Exception table:
      //   from	to	target	type
      //   269	289	290	java/lang/Exception
      //   82	97	292	java/lang/Exception
      //   341	361	362	java/lang/Exception
      //   82	97	364	finally
      //   263	269	417	java/lang/Exception
      //   307	313	421	java/lang/Exception
      //   335	341	425	java/lang/Exception
      //   389	395	429	java/lang/Exception
      //   395	415	433	java/lang/Exception
      //   99	145	437	finally
      //   147	163	437	finally
      //   165	176	437	finally
      //   178	192	437	finally
      //   194	208	437	finally
      //   210	241	437	finally
      //   297	301	437	finally
      //   307	313	437	finally
      //   99	145	441	java/lang/Exception
      //   147	163	441	java/lang/Exception
      //   165	176	441	java/lang/Exception
      //   178	192	441	java/lang/Exception
      //   194	208	441	java/lang/Exception
      //   210	241	441	java/lang/Exception
    }
    
    public void run()
    {
      ??? = AudioDecoderTrack.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("AudioDecoderCreateThread start - ").append(this.extractor.assetPath).append(" - ");
      if (this.outputSurface != null) {}
      for (boolean bool = true;; bool = false)
      {
        Logger.d((String)???, bool);
        if (!AudioDecoderTrack.this.isReleased) {
          break;
        }
        AudioDecoderTrack.access$902(AudioDecoderTrack.this, null);
        return;
      }
      for (;;)
      {
        synchronized (AudioDecoderTrack.this.nextDecoderLock)
        {
          if ((AudioDecoderTrack.this.nextDecoder != null) && (AudioDecoderTrack.isSameExtractor(AudioDecoderTrack.this.nextDecoder.extractor, this.extractor)))
          {
            AudioDecoderTrack.access$902(AudioDecoderTrack.this, null);
            if (!AudioDecoderTrack.this.isReleased) {}
          }
        }
        synchronized (AudioDecoderTrack.this.nextDecoderLock)
        {
          if (AudioDecoderTrack.this.nextDecoder != null)
          {
            AudioDecoderTrack.DecoderWrapper.access$600(AudioDecoderTrack.this.nextDecoder);
            AudioDecoderTrack.access$1102(AudioDecoderTrack.this, null);
          }
          Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread finish - " + this.extractor.assetPath);
          return;
          if (AudioDecoderTrack.this.nextDecoder != null)
          {
            Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread create - " + this.extractor.assetPath);
            if ((AudioDecoderTrack.this.nextDecoder.decoder != null) && (AudioDecoderTrack.this.nextDecoder.decoder != AudioDecoderTrack.this.currentDecoder))
            {
              AudioDecoderTrack.DecoderWrapper.access$600(AudioDecoderTrack.this.nextDecoder);
              AudioDecoderTrack.access$1102(AudioDecoderTrack.this, null);
            }
            createDecoder();
            continue;
            localObject2 = finally;
            throw localObject2;
          }
          createDecoder();
        }
      }
    }
  }
  
  static class CacheBuffer
  {
    private CMTime frameTime;
    private CMTime preFrameTime;
    private CMSampleBuffer sampleBuffer;
  }
  
  class DecoderThread
    extends ReActionThread
  {
    private static final String NAME = "AudioDecoderThread";
    private final Object nextFrameDecoderLock = new Object();
    private AudioDecoderTrack.CacheBuffer pcmFrame;
    
    public DecoderThread()
    {
      super();
    }
    
    protected void doAction()
    {
      CMSampleBuffer localCMSampleBuffer = null;
      synchronized (this.nextFrameDecoderLock)
      {
        if (this.pcmFrame != null)
        {
          if (AudioDecoderTrack.this.lastSampleTime != CMTime.CMTimeInvalid) {
            break label259;
          }
          if (Logger.LOG_VERBOSE) {
            Logger.d(AudioDecoderTrack.TAG, "doAction: CMTime.CMTimeZero");
          }
          localCMSampleBuffer = AudioDecoderTrack.this.doReadSample(CMTime.CMTimeZero);
        }
        label259:
        while (AudioDecoderTrack.this.lastSampleTime.smallThan(CMTime.CMTimeZero))
        {
          if (localCMSampleBuffer != null)
          {
            if (localCMSampleBuffer.getSampleByteBuffer() != null)
            {
              if (Logger.LOG_VERBOSE) {
                Logger.i(AudioDecoderTrack.TAG, "doAction: processFrame [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]", new Object[0]);
              }
              localCMSampleBuffer.setSampleByteBuffer(AudioDecoderTrack.this.processFrame(localCMSampleBuffer.getSampleByteBuffer(), 1.0F, AudioDecoderTrack.this._speed, AudioDecoderTrack.this.getAudioInfo()));
              if (Logger.LOG_VERBOSE) {
                Logger.i(AudioDecoderTrack.TAG, "doAction: processFrame finish [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]", new Object[0]);
              }
            }
            this.pcmFrame = new AudioDecoderTrack.CacheBuffer(null);
            AudioDecoderTrack.CacheBuffer.access$2202(this.pcmFrame, AudioDecoderTrack.this.lastSampleTime);
            AudioDecoderTrack.CacheBuffer.access$302(this.pcmFrame, localCMSampleBuffer.getTime());
          }
          return;
        }
        if (Logger.LOG_VERBOSE) {
          Logger.d(AudioDecoderTrack.TAG, "doAction: lastSampleTime.add(frameDuration)");
        }
        localCMSampleBuffer = AudioDecoderTrack.this.doReadSample(AudioDecoderTrack.this.lastSampleTime.add(AudioDecoderTrack.this.frameDuration));
      }
    }
  }
  
  static class DecoderWrapper
  {
    IDecoder decoder;
    DecoderAssetTrack extractor;
    int segmentIndex = -1;
    
    private void release()
    {
      Logger.d(AudioDecoderTrack.TAG, "Audio DecoderWrapper release: ");
      try
      {
        if (this.decoder != null) {
          this.decoder.release();
        }
        return;
      }
      catch (Exception localException) {}catch (Error localError) {}
    }
  }
  
  static class ReleaseDecoderThread
    extends Thread
  {
    private IDecoder decoder;
    
    ReleaseDecoderThread(IDecoder paramIDecoder)
    {
      super();
      this.decoder = paramIDecoder;
    }
    
    public void run()
    {
      if (this.decoder != null) {
        this.decoder.release();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack
 * JD-Core Version:    0.7.0.1
 */