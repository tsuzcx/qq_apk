package com.tencent.mobileqq.ar.ARRecord;

import adcr.a;
import amae;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

@TargetApi(18)
public class VideoEncoderCore
{
  private static final Object cN = new Object();
  private static final Object cO = new Object();
  private HandlerThread G;
  private long Se;
  private long Sf;
  private long Sg;
  private long Sh;
  private boolean Zi;
  private boolean Zj;
  private adcr.a jdField_a_of_type_Adcr$a;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private int azv;
  private int azw;
  private MediaCodec.BufferInfo jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_b_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_b_of_type_AndroidMediaMediaFormat;
  private boolean bLu;
  private MediaCodec.BufferInfo c = new MediaCodec.BufferInfo();
  private int cCB;
  private Handler cD;
  private MediaMuxer mMediaMuxer;
  private boolean mMuxerStarted;
  private Thread p;
  
  private void ao(long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      long l;
      try
      {
        l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame1 timestampNanos=%s endOfStream=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
        }
        if (paramBoolean) {
          this.jdField_b_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
        }
        i = 0;
        ByteBuffer[] arrayOfByteBuffer1 = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
        if (!QLog.isColorLevel()) {
          break label571;
        }
        QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return;
      int j = i + 1;
      int i = j;
      if (j > 100)
      {
        throw new RuntimeException("encoder has not output the last frame.");
        label560:
        label571:
        while (j != -1)
        {
          while (j == -2) {
            synchronized (cO)
            {
              localObject5 = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputFormat();
              this.azv = this.mMediaMuxer.addTrack((MediaFormat)localObject5);
              this.Zi = true;
              if ((!this.mMuxerStarted) && (this.Zj))
              {
                this.mMediaMuxer.start();
                this.mMuxerStarted = true;
                if (this.jdField_a_of_type_Adcr$a != null) {
                  this.jdField_a_of_type_Adcr$a.auy();
                }
              }
            }
          }
          ByteBuffer[] arrayOfByteBuffer2;
          if (j == -3)
          {
            arrayOfByteBuffer2 = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
            break;
          }
          if (j < 0) {
            break;
          }
          i = 0;
          Object localObject5 = arrayOfByteBuffer2[j];
          if ((this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0) {
            this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
          }
          if ((this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.mMuxerStarted))
          {
            ((ByteBuffer)localObject5).position(this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
            ((ByteBuffer)localObject5).limit(this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.size);
            if (QLog.isColorLevel()) {
              QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame1 presentationTimeUs=%s, duration=%s", new Object[] { Long.valueOf(this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs), Long.valueOf((this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L - paramLong) / 1000000L) }));
            }
            if (this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs < this.Sg) {
              break label560;
            }
            this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.flags = 1;
          }
          for (;;)
          {
            synchronized (cO)
            {
              this.mMediaMuxer.writeSampleData(this.azv, (ByteBuffer)localObject5, this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo);
              this.cCB += 1;
              this.Sg = this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
              this.jdField_b_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
              j = this.jdField_b_of_type_AndroidMediaMediaCodec$BufferInfo.flags;
              if ((j & 0x4) == 0) {
                break;
              }
            }
            QLog.e("VideoEncoderCore", 1, "handleVideoFrame video timestamp revert? throw this frame.");
          }
        }
        if (paramBoolean) {}
      }
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    label645:
    for (;;)
    {
      int i;
      int j;
      Object localObject2;
      try
      {
        long l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame audioFrame=%s timestampNanos=%s endOfStream=%s", new Object[] { paramArrayOfByte, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
        }
        i = 0;
        ??? = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
        j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        if (QLog.isColorLevel()) {
          QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
        }
        if (j >= 0)
        {
          ??? = ???[j];
          ((ByteBuffer)???).clear();
          ((ByteBuffer)???).put(paramArrayOfByte);
          this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(j, 0, paramArrayOfByte.length, paramLong / 1000L, 0);
          i = 0;
          paramArrayOfByte = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.c, 10000L);
          if (!QLog.isColorLevel()) {
            break label645;
          }
          QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
          break label645;
          if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
          }
          return;
        }
        if (j != -1) {
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        j = i + 1;
        i = j;
        if (j <= 10) {
          continue;
        }
        continue;
        j = i + 1;
        i = j;
        if (j <= 10) {
          continue;
        }
        continue;
        if (j == -2) {
          synchronized (cO)
          {
            localObject2 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
            this.azw = this.mMediaMuxer.addTrack((MediaFormat)localObject2);
            this.Zj = true;
            if ((!this.mMuxerStarted) && (this.Zi))
            {
              this.mMediaMuxer.start();
              this.mMuxerStarted = true;
              if (this.jdField_a_of_type_Adcr$a != null) {
                this.jdField_a_of_type_Adcr$a.auy();
              }
            }
          }
        }
        if (j != -3) {
          break label424;
        }
      }
      finally {}
      paramArrayOfByte = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      continue;
      label424:
      if (j >= 0)
      {
        i = 0;
        localObject2 = paramArrayOfByte[j];
        if ((this.c.flags & 0x2) != 0) {
          this.c.size = 0;
        }
        if ((this.c.size != 0) && (this.mMuxerStarted))
        {
          ((ByteBuffer)localObject2).position(this.c.offset);
          ((ByteBuffer)localObject2).limit(this.c.offset + this.c.size);
          if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame presentationTimeUs=%s", new Object[] { Long.valueOf(this.c.presentationTimeUs) }));
          }
          if (this.c.presentationTimeUs < this.Sf) {
            break label633;
          }
        }
        for (;;)
        {
          synchronized (cO)
          {
            this.mMediaMuxer.writeSampleData(this.azw, (ByteBuffer)localObject2, this.c);
            this.Sf = this.c.presentationTimeUs;
            this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
            j = this.c.flags;
            if ((j & 0x4) == 0) {
              break;
            }
          }
          label633:
          QLog.e("VideoEncoderCore", 1, "handleAudioFrame audio timestamp revert? throw this frame.");
        }
        if (j == -1) {
          if (paramBoolean) {}
        }
      }
    }
  }
  
  private void release()
  {
    int i;
    if (QLog.isColorLevel())
    {
      i = (int)((System.currentTimeMillis() - this.Sh) / 1000L);
      if (i <= 0) {
        break label189;
      }
      i = this.cCB / i;
    }
    for (;;)
    {
      QLog.d("VideoEncoderCore", 2, String.format("release video fps:%s", new Object[] { Integer.valueOf(i) }));
      if (this.p != null) {}
      synchronized (cN)
      {
        this.bLu = true;
        this.p = null;
        cN.notify();
        if (this.G != null)
        {
          this.G.quit();
          this.G = null;
          this.cD = null;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          this.jdField_a_of_type_AndroidMediaMediaCodec = null;
        }
        if (this.jdField_b_of_type_AndroidMediaMediaCodec != null)
        {
          this.jdField_b_of_type_AndroidMediaMediaCodec.stop();
          this.jdField_b_of_type_AndroidMediaMediaCodec.release();
          this.jdField_b_of_type_AndroidMediaMediaCodec = null;
        }
        if (this.mMediaMuxer != null)
        {
          this.mMediaMuxer.stop();
          this.mMediaMuxer.release();
          this.mMediaMuxer = null;
        }
        return;
        label189:
        i = -1;
      }
    }
  }
  
  public void b(amae paramamae, adcr.a parama)
    throws IOException
  {
    this.jdField_a_of_type_Adcr$a = parama;
    this.jdField_b_of_type_AndroidMediaMediaFormat = MediaFormat.createVideoFormat("video/avc", paramamae.width, paramamae.height);
    this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("color-format", 2130708361);
    this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("bitrate", paramamae.bitRate);
    this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("frame-rate", paramamae.frameRate);
    this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("i-frame-interval", paramamae.agP);
    this.jdField_b_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_b_of_type_AndroidMediaMediaCodec.configure(this.jdField_b_of_type_AndroidMediaMediaFormat, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_b_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_b_of_type_AndroidMediaMediaCodec.start();
    this.p = new VideoEncodeThread();
    this.p.start();
    this.jdField_a_of_type_AndroidMediaMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", 2);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-mask", 12);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("bitrate", 128000);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", 20480);
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    this.G = new HandlerThread("VideoEncodeThread");
    this.G.start();
    this.cD = new a(this.G.getLooper(), this);
    parama = new File(paramamae.outputFilePath);
    if (!parama.exists()) {
      aqhq.UD(parama.getAbsolutePath());
    }
    this.mMediaMuxer = new MediaMuxer(paramamae.outputFilePath, 0);
    this.mMediaMuxer.setOrientationHint(paramamae.orientation);
    this.azv = -1;
    this.azw = -1;
    this.Zi = false;
    this.Zj = false;
    this.mMuxerStarted = false;
    this.Sh = System.currentTimeMillis();
    this.cCB = 0;
  }
  
  public void d(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.cD != null) {
      this.cD.obtainMessage(1, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public Surface getInputSurface()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void iA(long paramLong)
  {
    if (this.p != null) {
      synchronized (cN)
      {
        this.Se = paramLong;
        cN.notify();
        return;
      }
    }
  }
  
  public void stop()
  {
    if (this.cD != null) {
      this.cD.removeCallbacksAndMessages(null);
    }
    long l = SystemClock.elapsedRealtimeNanos();
    b(new byte[0], l, true);
    ao(l, true);
    release();
  }
  
  class VideoEncodeThread
    extends Thread
  {
    public VideoEncodeThread()
    {
      super();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 26	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:access$200	()Ljava/lang/Object;
      //   3: astore_3
      //   4: aload_3
      //   5: monitorenter
      //   6: aload_0
      //   7: getfield 13	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore$VideoEncodeThread:this$0	Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;
      //   10: invokestatic 30	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:a	(Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;)Z
      //   13: ifeq +14 -> 27
      //   16: ldc 32
      //   18: iconst_1
      //   19: ldc 34
      //   21: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   24: aload_3
      //   25: monitorexit
      //   26: return
      //   27: aload_0
      //   28: getfield 13	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore$VideoEncodeThread:this$0	Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;
      //   31: invokestatic 43	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:a	(Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;)J
      //   34: lstore_1
      //   35: lload_1
      //   36: lconst_0
      //   37: lcmp
      //   38: ifne +9 -> 47
      //   41: invokestatic 26	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:access$200	()Ljava/lang/Object;
      //   44: invokevirtual 48	java/lang/Object:wait	()V
      //   47: aload_3
      //   48: monitorexit
      //   49: aload_0
      //   50: getfield 13	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore$VideoEncodeThread:this$0	Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;
      //   53: invokestatic 43	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:a	(Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;)J
      //   56: lconst_0
      //   57: lcmp
      //   58: ifeq -58 -> 0
      //   61: aload_0
      //   62: getfield 13	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore$VideoEncodeThread:this$0	Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;
      //   65: aload_0
      //   66: getfield 13	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore$VideoEncodeThread:this$0	Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;
      //   69: invokestatic 43	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:a	(Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;)J
      //   72: iconst_0
      //   73: invokestatic 51	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:a	(Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;JZ)V
      //   76: aload_0
      //   77: getfield 13	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore$VideoEncodeThread:this$0	Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;
      //   80: lconst_0
      //   81: invokestatic 54	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:a	(Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;J)J
      //   84: pop2
      //   85: goto -85 -> 0
      //   88: astore 4
      //   90: ldc 32
      //   92: iconst_1
      //   93: ldc 56
      //   95: aload 4
      //   97: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   100: goto -53 -> 47
      //   103: astore 4
      //   105: aload_3
      //   106: monitorexit
      //   107: aload 4
      //   109: athrow
      //   110: astore_3
      //   111: ldc 32
      //   113: iconst_1
      //   114: ldc 62
      //   116: aload_3
      //   117: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   120: aload_0
      //   121: getfield 13	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore$VideoEncodeThread:this$0	Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;
      //   124: invokestatic 65	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:a	(Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;)Ladcr$a;
      //   127: ifnull -51 -> 76
      //   130: aload_0
      //   131: getfield 13	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore$VideoEncodeThread:this$0	Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;
      //   134: invokestatic 65	com/tencent/mobileqq/ar/ARRecord/VideoEncoderCore:a	(Lcom/tencent/mobileqq/ar/ARRecord/VideoEncoderCore;)Ladcr$a;
      //   137: iconst_4
      //   138: invokeinterface 71 2 0
      //   143: goto -67 -> 76
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	146	0	this	VideoEncodeThread
      //   34	2	1	l	long
      //   3	103	3	localObject1	Object
      //   110	7	3	localException1	Exception
      //   88	8	4	localException2	Exception
      //   103	5	4	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   41	47	88	java/lang/Exception
      //   6	26	103	finally
      //   27	35	103	finally
      //   41	47	103	finally
      //   47	49	103	finally
      //   90	100	103	finally
      //   105	107	103	finally
      //   61	76	110	java/lang/Exception
    }
  }
  
  static class a
    extends Handler
  {
    private WeakReference<VideoEncoderCore> mRef;
    
    public a(Looper paramLooper, VideoEncoderCore paramVideoEncoderCore)
    {
      super();
      this.mRef = new WeakReference(paramVideoEncoderCore);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.mRef != null) {}
      for (VideoEncoderCore localVideoEncoderCore = (VideoEncoderCore)this.mRef.get();; localVideoEncoderCore = null)
      {
        switch (paramMessage.what)
        {
        }
        do
        {
          do
          {
            return;
          } while (localVideoEncoderCore == null);
          paramMessage = (Object[])paramMessage.obj;
          try
          {
            VideoEncoderCore.a(localVideoEncoderCore, (byte[])paramMessage[0], ((Long)paramMessage[1]).longValue(), false);
            return;
          }
          catch (Exception paramMessage)
          {
            QLog.e("VideoEncoderCore", 1, "AudioEncodeHandler encode audio fail.", paramMessage);
          }
        } while (VideoEncoderCore.a(localVideoEncoderCore) == null);
        VideoEncoderCore.a(localVideoEncoderCore).KF(3);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderCore
 * JD-Core Version:    0.7.0.1
 */