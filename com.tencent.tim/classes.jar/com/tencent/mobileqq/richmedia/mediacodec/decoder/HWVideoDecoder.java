package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import alza;
import alzb;
import alzc;
import alzd;
import alze;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
import pog;
import ram;

@TargetApi(16)
public class HWVideoDecoder
  implements alze
{
  private alzb jdField_a_of_type_Alzb;
  private DecodeRunnable jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
  private Thread currentDecodeThread;
  
  private void a(alza paramalza, Surface paramSurface, alzd paramalzd)
  {
    if ((paramalza == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    ram.d("HWVideoDecoder", "startDecode config = %s", paramalza);
    Thread localThread;
    if (this.currentDecodeThread != null)
    {
      localThread = this.currentDecodeThread;
      stopDecode();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable = new DecodeRunnable(paramalza.inputFilePath, paramSurface, paramalzd);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.a(paramalza);
      this.currentDecodeThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable, "HWVideoDecoder-Thread", 8);
      this.currentDecodeThread.start();
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
  
  public void a(alza paramalza, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, alzd paramalzd)
  {
    this.jdField_a_of_type_Alzb = new alzb(paramInt, paramOnFrameAvailableListener);
    a(paramalza, this.jdField_a_of_type_Alzb.surface, paramalzd);
  }
  
  public int getHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.getVideoHeight();
  }
  
  public int getWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.getVideoWidth();
  }
  
  public void pauseDecode()
  {
    DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      DecodeRunnable.a(localDecodeRunnable, true);
      ram.d("HWVideoDecoder", "pauseDecode");
      return;
    }
    ram.w("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void resumeDecode()
  {
    DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      DecodeRunnable.a(localDecodeRunnable, false);
      synchronized (DecodeRunnable.a(localDecodeRunnable))
      {
        DecodeRunnable.a(localDecodeRunnable).notifyAll();
        ram.d("HWVideoDecoder", "resumeDecode");
        return;
      }
    }
    ram.w("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      ram.b("HWVideoDecoder", "setPlayRange [%d ms, %d ms]", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      localDecodeRunnable.setPlayRange(paramLong1, paramLong2);
      return;
    }
    ram.w("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void setSpeedType(int paramInt)
  {
    DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.setSpeedType(paramInt);
      ram.b("HWVideoDecoder", "setSpeedType %d", Integer.valueOf(paramInt));
      return;
    }
    ram.w("HWVideoDecoder", "setSpeedType %d failed, can not find DecodeRunnable", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void stopDecode()
  {
    if (this.currentDecodeThread != null) {
      this.currentDecodeThread.interrupt();
    }
    this.currentDecodeThread = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable = null;
  }
  
  static class DecodeRunnable
    implements Runnable
  {
    private final AtomicLong G = new AtomicLong(-1L);
    @NonNull
    private final alzd a;
    private final alza b;
    private final alza c;
    private boolean cBy;
    private volatile boolean cuB;
    private MediaCodec decoder;
    private MediaExtractor extractor;
    private final String filePath;
    MediaCodec.BufferInfo info;
    ByteBuffer[] inputBuffers;
    private boolean inputDone;
    boolean interruptedFlag = false;
    private long lastFramePresentationTimeUs;
    private long lastFrameSampleTimeUs;
    private String mTag = "HWVideoDecoder.DecodeRunnable";
    private int mVideoHeight;
    private int mVideoWidth;
    ByteBuffer[] outputBuffers;
    private boolean outputDone;
    private final Object pauseLock = new Object();
    private final AtomicLong seekToTaskUs = new AtomicLong(-1L);
    long startMs = System.currentTimeMillis();
    private Surface surface;
    public final long videoDurationMs;
    
    public DecodeRunnable(@NonNull String paramString, Surface paramSurface, alzd paramalzd)
    {
      ram.d("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: %s", paramString);
      this.surface = paramSurface;
      if (paramalzd != null) {}
      for (;;)
      {
        this.a = paramalzd;
        this.filePath = paramString;
        this.videoDurationMs = pog.getDurationOfVideo(paramString);
        this.b = new alza(paramString, 0, true, false, 0L, this.videoDurationMs);
        this.c = new alza(paramString, 0, true, false, 0L, this.videoDurationMs);
        return;
        paramalzd = new alzc();
      }
    }
    
    private boolean d(boolean paramBoolean, long paramLong)
    {
      if (!this.cBy) {}
      long l;
      do
      {
        do
        {
          do
          {
            return paramBoolean;
          } while (!paramBoolean);
          if (this.outputDone) {
            return false;
          }
          l = this.G.get();
        } while (l <= 0L);
        if ((l > this.c.startTimeMillSecond) && (l < this.c.endTimeMillSecond)) {
          break;
        }
        this.G.compareAndSet(l, -1L);
      } while (!QLog.isColorLevel());
      QLog.d("HWVideoDecoder.DecodeRunnable", 2, "checkToRender, not in playrange, pos:" + l + ": [" + this.c.startTimeMillSecond + "-" + this.c.endTimeMillSecond + "]");
      return paramBoolean;
      if (l > paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoDecoder.DecodeRunnable", 2, "checkToRender, do not render, renderpos:" + l + " sampletime:" + paramLong);
        }
        return false;
      }
      this.G.compareAndSet(l, -1L);
      return paramBoolean;
    }
    
    private void dLI()
    {
      if (this.c.speedType == 3)
      {
        this.lastFrameSampleTimeUs = (this.c.endTimeMillSecond * 1000L);
        return;
      }
      this.lastFrameSampleTimeUs = 0L;
    }
    
    private boolean dequeueDataFromCodec(boolean paramBoolean)
    {
      int i = this.decoder.dequeueOutputBuffer(this.info, 10000L);
      switch (i)
      {
      default: 
        if ((this.info.flags & 0x4) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.mTag, 2, "output EOS");
          }
          this.outputDone = true;
        }
        paramBoolean = d(paramBoolean, this.lastFrameSampleTimeUs / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d(this.mTag, 2, "checkToRender, render :" + paramBoolean + " info.presentationTimeUs:" + this.info.presentationTimeUs / 1000L + " - " + (System.currentTimeMillis() - this.startMs));
        }
        if ((this.c.noSleep) || (!paramBoolean)) {
          break;
        }
      case -3: 
      case -2: 
      case -1: 
        while (this.info.presentationTimeUs / 1000L > System.currentTimeMillis() - this.startMs)
        {
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
            this.interruptedFlag = true;
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(this.mTag, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.decoder.getOutputBuffers();
          do
          {
            do
            {
              return true;
            } while (!QLog.isColorLevel());
            QLog.d(this.mTag, 2, "New format " + this.decoder.getOutputFormat());
            return true;
          } while (!QLog.isColorLevel());
          QLog.d(this.mTag, 2, "dequeueOutputBuffer timed out!");
          return true;
        }
      }
      if ((paramBoolean) && (this.info.size != 0)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.decoder.releaseOutputBuffer(i, paramBoolean);
        if (!paramBoolean) {
          break;
        }
        try
        {
          this.a.fp(this.info.presentationTimeUs * 1000L);
          return true;
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
          this.interruptedFlag = true;
          return true;
        }
      }
    }
    
    private long getPresentationTime(int paramInt, long paramLong1, long paramLong2)
    {
      switch (paramInt)
      {
      default: 
        return paramLong1 + paramLong2;
      case 1: 
        return paramLong2 / 2L + paramLong1;
      case 2: 
        return 2L * paramLong2 + paramLong1;
      }
      return paramLong1 - paramLong2;
    }
    
    /* Error */
    private boolean init()
    {
      // Byte code:
      //   0: aload_0
      //   1: new 284	android/media/MediaExtractor
      //   4: dup
      //   5: invokespecial 285	android/media/MediaExtractor:<init>	()V
      //   8: putfield 287	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:extractor	Landroid/media/MediaExtractor;
      //   11: aload_0
      //   12: getfield 287	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:extractor	Landroid/media/MediaExtractor;
      //   15: aload_0
      //   16: getfield 114	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:filePath	Ljava/lang/String;
      //   19: invokevirtual 291	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
      //   22: iconst_0
      //   23: istore_1
      //   24: iload_1
      //   25: aload_0
      //   26: getfield 287	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:extractor	Landroid/media/MediaExtractor;
      //   29: invokevirtual 294	android/media/MediaExtractor:getTrackCount	()I
      //   32: if_icmpge +217 -> 249
      //   35: aload_0
      //   36: getfield 287	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:extractor	Landroid/media/MediaExtractor;
      //   39: iload_1
      //   40: invokevirtual 298	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
      //   43: astore_2
      //   44: aload_2
      //   45: ldc_w 300
      //   48: invokevirtual 306	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   51: astore_3
      //   52: aload_3
      //   53: ldc_w 308
      //   56: invokevirtual 314	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   59: ifeq +233 -> 292
      //   62: aload_0
      //   63: aload_2
      //   64: ldc_w 316
      //   67: invokevirtual 320	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
      //   70: putfield 322	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mVideoWidth	I
      //   73: aload_0
      //   74: aload_2
      //   75: ldc_w 324
      //   78: invokevirtual 320	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
      //   81: putfield 326	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mVideoHeight	I
      //   84: aload_0
      //   85: getfield 287	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:extractor	Landroid/media/MediaExtractor;
      //   88: iload_1
      //   89: invokevirtual 330	android/media/MediaExtractor:selectTrack	(I)V
      //   92: aload_0
      //   93: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   96: getfield 333	alza:cBx	Z
      //   99: ifeq +131 -> 230
      //   102: aload_0
      //   103: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   106: getfield 336	alza:adjustRotation	I
      //   109: istore_1
      //   110: aload_2
      //   111: ldc_w 338
      //   114: iload_1
      //   115: invokevirtual 342	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
      //   118: aload_0
      //   119: aload_3
      //   120: invokestatic 346	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
      //   123: putfield 196	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:decoder	Landroid/media/MediaCodec;
      //   126: aload_0
      //   127: getfield 110	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:surface	Landroid/view/Surface;
      //   130: invokevirtual 351	android/view/Surface:isValid	()Z
      //   133: ifne +102 -> 235
      //   136: new 353	java/lang/RuntimeException
      //   139: dup
      //   140: ldc_w 355
      //   143: invokespecial 357	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   146: athrow
      //   147: astore_2
      //   148: invokestatic 360	java/lang/Thread:interrupted	()Z
      //   151: ifeq +100 -> 251
      //   154: aload_0
      //   155: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   158: iconst_2
      //   159: ldc_w 362
      //   162: aload_2
      //   163: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   166: iconst_0
      //   167: ireturn
      //   168: astore_2
      //   169: aload_2
      //   170: invokevirtual 367	java/io/IOException:printStackTrace	()V
      //   173: iconst_0
      //   174: ireturn
      //   175: astore_2
      //   176: invokestatic 360	java/lang/Thread:interrupted	()Z
      //   179: ifeq +17 -> 196
      //   182: aload_0
      //   183: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   186: iconst_2
      //   187: ldc_w 362
      //   190: aload_2
      //   191: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   194: iconst_0
      //   195: ireturn
      //   196: new 353	java/lang/RuntimeException
      //   199: dup
      //   200: aload_2
      //   201: invokespecial 370	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   204: astore_3
      //   205: aload_0
      //   206: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	Lalzd;
      //   209: iconst_1
      //   210: aload_3
      //   211: invokeinterface 374 3 0
      //   216: aload_0
      //   217: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   220: iconst_2
      //   221: ldc_w 376
      //   224: aload_2
      //   225: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   228: iconst_0
      //   229: ireturn
      //   230: iconst_0
      //   231: istore_1
      //   232: goto -122 -> 110
      //   235: aload_0
      //   236: getfield 196	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:decoder	Landroid/media/MediaCodec;
      //   239: aload_2
      //   240: aload_0
      //   241: getfield 110	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:surface	Landroid/view/Surface;
      //   244: aconst_null
      //   245: iconst_0
      //   246: invokevirtual 380	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
      //   249: iconst_1
      //   250: ireturn
      //   251: new 353	java/lang/RuntimeException
      //   254: dup
      //   255: aload_2
      //   256: invokespecial 370	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   259: astore_3
      //   260: aload_0
      //   261: getfield 59	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:interruptedFlag	Z
      //   264: ifne +14 -> 278
      //   267: aload_0
      //   268: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	Lalzd;
      //   271: iconst_1
      //   272: aload_3
      //   273: invokeinterface 374 3 0
      //   278: aload_0
      //   279: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   282: iconst_2
      //   283: ldc_w 382
      //   286: aload_2
      //   287: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   290: iconst_0
      //   291: ireturn
      //   292: iload_1
      //   293: iconst_1
      //   294: iadd
      //   295: istore_1
      //   296: goto -272 -> 24
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	299	0	this	DecodeRunnable
      //   23	273	1	i	int
      //   43	68	2	localMediaFormat	android.media.MediaFormat
      //   147	16	2	localThrowable	Throwable
      //   168	2	2	localIOException	java.io.IOException
      //   175	112	2	localIllegalArgumentException	IllegalArgumentException
      //   51	222	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   118	147	147	java/lang/Throwable
      //   235	249	147	java/lang/Throwable
      //   11	22	168	java/io/IOException
      //   35	44	175	java/lang/IllegalArgumentException
    }
    
    private void loopInternal(boolean paramBoolean)
    {
      if (!this.inputDone) {
        queueSampleToCodec();
      }
      if (!this.outputDone) {
        dequeueDataFromCodec(paramBoolean);
      }
    }
    
    private boolean queueSampleToCodec()
    {
      int i = this.decoder.dequeueInputBuffer(10000L);
      if (i >= 0)
      {
        ByteBuffer localByteBuffer = this.inputBuffers[i];
        long l1;
        MediaExtractor localMediaExtractor;
        long l2;
        int j;
        long l3;
        if (this.c.speedType == 3)
        {
          l1 = this.lastFrameSampleTimeUs - 1000;
          if (("xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("MI 6".equalsIgnoreCase(Build.MODEL)))
          {
            localMediaExtractor = this.extractor;
            l2 = l1;
            if (l1 < 0L) {
              l2 = 0L;
            }
            localMediaExtractor.seekTo(l2, 1);
          }
        }
        else
        {
          j = this.extractor.readSampleData(localByteBuffer, 0);
          l3 = this.extractor.getSampleTime();
          l2 = 1000L * this.c.startTimeMillSecond;
          long l4 = 1000L * this.c.endTimeMillSecond;
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoDecoder.DecodeRunnable", 2, "intput sampleTime = " + l3 + " sampleSize = " + j + " endTime = " + l4);
          }
          if ((j >= 0) && ((l4 <= 0L) || (l3 <= l4)))
          {
            if (this.c.speedType != 3) {
              break label364;
            }
            if (l2 <= 0L) {
              break label356;
            }
            l1 = l2;
            label234:
            if (l3 >= l1) {
              break label364;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.mTag, 2, "InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=" + l3 + " endTime=" + l4 + " startTime=" + l2 + " sampleSize=" + j);
          }
          this.decoder.queueInputBuffer(i, 0, 0, 0L, 4);
          this.inputDone = true;
        }
        for (;;)
        {
          return true;
          localMediaExtractor = this.extractor;
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          localMediaExtractor.seekTo(l2, 0);
          break;
          label356:
          l1 = 10000;
          break label234;
          label364:
          l1 = this.lastFrameSampleTimeUs;
          this.lastFrameSampleTimeUs = l3;
          this.lastFramePresentationTimeUs = getPresentationTime(this.c.speedType, this.lastFramePresentationTimeUs, l3 - l1);
          this.decoder.queueInputBuffer(i, 0, j, this.lastFramePresentationTimeUs, 0);
          this.extractor.advance();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.mTag, 2, "queueSampleToCodec inIndex = " + i);
      }
      return false;
    }
    
    private long seekInLoop(long paramLong)
    {
      long l1 = System.currentTimeMillis();
      try
      {
        this.decoder.flush();
        this.extractor.seekTo(paramLong, 0);
        long l2 = this.extractor.getSampleTime();
        this.a.onDecodeSeekTo(l2 / 1000L);
        this.startMs = System.currentTimeMillis();
        this.inputDone = false;
        this.outputDone = false;
        if (l2 == -1L) {
          dLI();
        }
        this.lastFrameSampleTimeUs = l2;
        this.lastFramePresentationTimeUs = 0L;
        if (QLog.isColorLevel()) {
          QLog.d(this.mTag, 4, "end seekTo seekTime=" + 0 + " timecost=" + (System.currentTimeMillis() - l1) + " seekTargetTimeUs:" + paramLong + " realStartTime:" + l2);
        }
        return l2;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          QLog.e("HWVideoDecoder.DecodeRunnable", 1, "decoder flush error " + localRuntimeException.toString());
        }
      }
    }
    
    private boolean start()
    {
      if (this.decoder == null)
      {
        QLog.e(this.mTag, 2, "Can't find video info!");
        return false;
      }
      this.a.onDecodeStart();
      try
      {
        this.decoder.start();
        RuntimeException localRuntimeException;
        return false;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          this.inputBuffers = this.decoder.getInputBuffers();
          this.outputBuffers = this.decoder.getOutputBuffers();
          this.info = new MediaCodec.BufferInfo();
          this.startMs = System.currentTimeMillis();
          if (this.c.speedType == 3) {
            this.lastFrameSampleTimeUs = (this.c.endTimeMillSecond * 1000L);
          }
          return true;
        }
        catch (Exception localException)
        {
          if (this.interruptedFlag) {
            break label185;
          }
          this.a.onDecodeError(2, localException);
          QLog.e(this.mTag, 2, "decode start error2", localException);
        }
        localThrowable = localThrowable;
        if (Thread.interrupted())
        {
          QLog.e(this.mTag, 2, "Thread is interrupted.", localThrowable);
          return false;
        }
        localRuntimeException = new RuntimeException(localThrowable);
        if (!this.interruptedFlag) {
          this.a.onDecodeError(2, localRuntimeException);
        }
        QLog.e(this.mTag, 2, "decode start error", localThrowable);
        return false;
      }
    }
    
    public void a(@NonNull alza paramalza)
    {
      if (!TextUtils.equals(this.filePath, paramalza.inputFilePath)) {
        ram.w("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
      }
      setSpeedType(paramalza.speedType);
      setPlayRange(paramalza.startTimeMillSecond, paramalza.endTimeMillSecond);
      setRepeat(paramalza.repeat);
      setNoSleep(paramalza.noSleep);
      this.b.adjustRotation = paramalza.adjustRotation;
      this.b.cBx = paramalza.cBx;
    }
    
    public int getVideoHeight()
    {
      return this.mVideoHeight;
    }
    
    public int getVideoWidth()
    {
      return this.mVideoWidth;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 65	java/lang/System:currentTimeMillis	()J
      //   3: lstore_3
      //   4: aload_0
      //   5: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   8: aload_0
      //   9: getfield 129	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:b	Lalza;
      //   12: invokevirtual 531	alza:a	(Lalza;)Z
      //   15: pop
      //   16: aload_0
      //   17: invokespecial 533	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:init	()Z
      //   20: ifne +4 -> 24
      //   23: return
      //   24: aload_0
      //   25: invokespecial 535	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:start	()Z
      //   28: ifeq -5 -> 23
      //   31: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   34: ifeq +35 -> 69
      //   37: aload_0
      //   38: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   41: iconst_2
      //   42: new 82	java/lang/StringBuilder
      //   45: dup
      //   46: invokespecial 83	java/lang/StringBuilder:<init>	()V
      //   49: ldc_w 537
      //   52: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: invokestatic 65	java/lang/System:currentTimeMillis	()J
      //   58: lload_3
      //   59: lsub
      //   60: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   63: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   66: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   69: invokestatic 360	java/lang/Thread:interrupted	()Z
      //   72: ifne +416 -> 488
      //   75: aload_0
      //   76: getfield 59	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:interruptedFlag	Z
      //   79: ifne +409 -> 488
      //   82: aload_0
      //   83: getfield 129	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:b	Lalza;
      //   86: getfield 186	alza:speedType	I
      //   89: aload_0
      //   90: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   93: getfield 186	alza:speedType	I
      //   96: if_icmpeq +29 -> 125
      //   99: aload_0
      //   100: getfield 129	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:b	Lalza;
      //   103: getfield 186	alza:speedType	I
      //   106: iconst_3
      //   107: if_icmpne +18 -> 125
      //   110: aload_0
      //   111: aload_0
      //   112: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   115: getfield 154	alza:endTimeMillSecond	J
      //   118: ldc2_w 187
      //   121: lmul
      //   122: putfield 190	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:lastFrameSampleTimeUs	J
      //   125: aload_0
      //   126: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   129: aload_0
      //   130: getfield 129	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:b	Lalza;
      //   133: invokevirtual 531	alza:a	(Lalza;)Z
      //   136: pop
      //   137: aload_0
      //   138: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   141: getfield 151	alza:startTimeMillSecond	J
      //   144: ldc2_w 187
      //   147: lmul
      //   148: lstore_3
      //   149: ldc2_w 187
      //   152: aload_0
      //   153: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   156: getfield 154	alza:endTimeMillSecond	J
      //   159: lmul
      //   160: lstore 5
      //   162: iconst_0
      //   163: istore_2
      //   164: aload_0
      //   165: getfield 76	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:seekToTaskUs	Ljava/util/concurrent/atomic/AtomicLong;
      //   168: invokevirtual 148	java/util/concurrent/atomic/AtomicLong:get	()J
      //   171: lstore 7
      //   173: iload_2
      //   174: istore_1
      //   175: lload 7
      //   177: lconst_0
      //   178: lcmp
      //   179: iflt +31 -> 210
      //   182: iload_2
      //   183: istore_1
      //   184: lload 7
      //   186: lload_3
      //   187: lcmp
      //   188: iflt +22 -> 210
      //   191: iload_2
      //   192: istore_1
      //   193: lload 7
      //   195: lload 5
      //   197: lcmp
      //   198: ifgt +12 -> 210
      //   201: aload_0
      //   202: lload 7
      //   204: invokespecial 539	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:seekInLoop	(J)J
      //   207: pop2
      //   208: iconst_1
      //   209: istore_1
      //   210: aload_0
      //   211: getfield 76	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:seekToTaskUs	Ljava/util/concurrent/atomic/AtomicLong;
      //   214: lload 7
      //   216: ldc2_w 70
      //   219: invokevirtual 158	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
      //   222: pop
      //   223: invokestatic 65	java/lang/System:currentTimeMillis	()J
      //   226: lstore 7
      //   228: aload_0
      //   229: iconst_1
      //   230: invokespecial 541	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:loopInternal	(Z)V
      //   233: iload_1
      //   234: ifeq +42 -> 276
      //   237: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   240: ifeq +36 -> 276
      //   243: aload_0
      //   244: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   247: iconst_2
      //   248: new 82	java/lang/StringBuilder
      //   251: dup
      //   252: invokespecial 83	java/lang/StringBuilder:<init>	()V
      //   255: ldc_w 537
      //   258: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   261: invokestatic 65	java/lang/System:currentTimeMillis	()J
      //   264: lload 7
      //   266: lsub
      //   267: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   270: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   273: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   276: aload_0
      //   277: getfield 145	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:outputDone	Z
      //   280: ifeq +59 -> 339
      //   283: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   286: ifeq +14 -> 300
      //   289: aload_0
      //   290: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   293: iconst_2
      //   294: ldc_w 543
      //   297: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   300: aload_0
      //   301: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   304: getfield 519	alza:repeat	Z
      //   307: ifeq +181 -> 488
      //   310: aload_0
      //   311: getfield 131	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	Lalza;
      //   314: getfield 186	alza:speedType	I
      //   317: iconst_3
      //   318: if_icmpne +159 -> 477
      //   321: lload 5
      //   323: lstore_3
      //   324: aload_0
      //   325: lload_3
      //   326: invokespecial 539	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:seekInLoop	(J)J
      //   329: pop2
      //   330: aload_0
      //   331: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	Lalzd;
      //   334: invokeinterface 546 1 0
      //   339: aload_0
      //   340: getfield 140	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:cuB	Z
      //   343: ifeq -274 -> 69
      //   346: aload_0
      //   347: getfield 80	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:pauseLock	Ljava/lang/Object;
      //   350: astore 9
      //   352: aload 9
      //   354: monitorenter
      //   355: aload_0
      //   356: getfield 59	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:interruptedFlag	Z
      //   359: ifne +10 -> 369
      //   362: aload_0
      //   363: getfield 80	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:pauseLock	Ljava/lang/Object;
      //   366: invokevirtual 549	java/lang/Object:wait	()V
      //   369: aload 9
      //   371: monitorexit
      //   372: aload_0
      //   373: invokestatic 65	java/lang/System:currentTimeMillis	()J
      //   376: aload_0
      //   377: getfield 198	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:info	Landroid/media/MediaCodec$BufferInfo;
      //   380: getfield 225	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
      //   383: ldc2_w 187
      //   386: ldiv
      //   387: lsub
      //   388: putfield 67	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:startMs	J
      //   391: goto -322 -> 69
      //   394: astore 9
      //   396: aload 9
      //   398: invokevirtual 240	java/lang/InterruptedException:printStackTrace	()V
      //   401: aload_0
      //   402: iconst_1
      //   403: putfield 59	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:interruptedFlag	Z
      //   406: goto -337 -> 69
      //   409: astore 9
      //   411: invokestatic 360	java/lang/Thread:interrupted	()Z
      //   414: ifeq +19 -> 433
      //   417: aload_0
      //   418: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   421: iconst_2
      //   422: ldc_w 362
      //   425: aload 9
      //   427: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   430: goto -197 -> 233
      //   433: new 353	java/lang/RuntimeException
      //   436: dup
      //   437: aload 9
      //   439: invokespecial 370	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   442: astore 10
      //   444: aload_0
      //   445: getfield 59	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:interruptedFlag	Z
      //   448: ifne +15 -> 463
      //   451: aload_0
      //   452: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	Lalzd;
      //   455: iconst_3
      //   456: aload 10
      //   458: invokeinterface 374 3 0
      //   463: aload_0
      //   464: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   467: iconst_2
      //   468: ldc_w 382
      //   471: aload 9
      //   473: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   476: return
      //   477: goto -153 -> 324
      //   480: astore 10
      //   482: aload 9
      //   484: monitorexit
      //   485: aload 10
      //   487: athrow
      //   488: aload_0
      //   489: getfield 196	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:decoder	Landroid/media/MediaCodec;
      //   492: invokevirtual 552	android/media/MediaCodec:stop	()V
      //   495: aload_0
      //   496: getfield 196	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:decoder	Landroid/media/MediaCodec;
      //   499: invokevirtual 555	android/media/MediaCodec:release	()V
      //   502: aload_0
      //   503: getfield 287	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:extractor	Landroid/media/MediaExtractor;
      //   506: invokevirtual 556	android/media/MediaExtractor:release	()V
      //   509: aload_0
      //   510: getfield 145	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:outputDone	Z
      //   513: ifeq +48 -> 561
      //   516: aload_0
      //   517: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	Lalzd;
      //   520: invokeinterface 559 1 0
      //   525: return
      //   526: astore 9
      //   528: ldc 55
      //   530: iconst_1
      //   531: new 82	java/lang/StringBuilder
      //   534: dup
      //   535: invokespecial 83	java/lang/StringBuilder:<init>	()V
      //   538: ldc_w 561
      //   541: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   544: aload 9
      //   546: invokevirtual 562	java/lang/Exception:toString	()Ljava/lang/String;
      //   549: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   552: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   555: invokestatic 476	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   558: goto -49 -> 509
      //   561: aload_0
      //   562: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	Lalzd;
      //   565: invokeinterface 565 1 0
      //   570: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	571	0	this	DecodeRunnable
      //   174	60	1	i	int
      //   163	29	2	j	int
      //   3	323	3	l1	long
      //   160	162	5	l2	long
      //   171	94	7	l3	long
      //   394	3	9	localInterruptedException	InterruptedException
      //   409	74	9	localThrowable	Throwable
      //   526	19	9	localException	Exception
      //   442	15	10	localRuntimeException	RuntimeException
      //   480	6	10	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   346	355	394	java/lang/InterruptedException
      //   372	391	394	java/lang/InterruptedException
      //   485	488	394	java/lang/InterruptedException
      //   228	233	409	java/lang/Throwable
      //   355	369	480	finally
      //   369	372	480	finally
      //   482	485	480	finally
      //   488	509	526	java/lang/Exception
    }
    
    public void seekTo(long paramLong)
    {
      this.seekToTaskUs.set(1000L * paramLong);
    }
    
    public void setNoSleep(boolean paramBoolean)
    {
      this.b.noSleep = paramBoolean;
    }
    
    public void setPlayRange(long paramLong1, long paramLong2)
    {
      if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
        throw new IllegalArgumentException("both start time and end time should not less than 0");
      }
      if (paramLong2 < paramLong1) {
        throw new IllegalArgumentException("end time should not less than start time");
      }
      if (paramLong1 >= this.videoDurationMs)
      {
        ram.e("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=%d, videoDuration=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.videoDurationMs) });
        return;
      }
      if (paramLong2 > this.videoDurationMs) {
        paramLong2 = this.videoDurationMs;
      }
      for (;;)
      {
        long l = paramLong2;
        if (paramLong2 == 0L) {
          l = this.videoDurationMs;
        }
        if ((paramLong1 == this.b.startTimeMillSecond) && (l == this.b.endTimeMillSecond))
        {
          ram.w("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l) });
          return;
        }
        this.b.startTimeMillSecond = paramLong1;
        this.b.endTimeMillSecond = l;
        if (this.b.speedType == 3)
        {
          seekTo(l);
          return;
        }
        seekTo(paramLong1);
        return;
      }
    }
    
    public void setRepeat(boolean paramBoolean)
    {
      this.b.repeat = paramBoolean;
    }
    
    public void setSpeedType(int paramInt)
    {
      this.b.speedType = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */