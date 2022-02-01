package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;

class MediaCodecWrapper
{
  private static final int MAX_RETRY_COUNT = 10;
  private static final long WAIT_TRANSIENT_MS = 20L;
  private final String TAG = "MediaCodecWrapper@" + Integer.toHexString(hashCode());
  private MediaCodec mediaCodec;
  private final VideoDecoder videoDecoder;
  
  MediaCodecWrapper(VideoDecoder paramVideoDecoder)
  {
    this.videoDecoder = paramVideoDecoder;
  }
  
  private boolean isLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private void resetMediaCodec(MediaFormat paramMediaFormat)
    throws IOException
  {
    if (isLollipop())
    {
      this.mediaCodec.reset();
      return;
    }
    try
    {
      this.mediaCodec.stop();
      label22:
      this.mediaCodec.release();
      this.mediaCodec = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  private void tryLogMediaCodecError(MediaCodec.CodecException paramCodecException)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      Logger.e(this.TAG, "CodecException - isTransient = " + paramCodecException.isTransient() + " , isRecoverable = " + paramCodecException.isRecoverable() + " , errorCode = " + paramCodecException.getErrorCode());
    }
  }
  
  boolean decoderConfigure(MediaFormat paramMediaFormat, Surface paramSurface)
    throws IOException
  {
    for (;;)
    {
      try
      {
        this.mediaCodec = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
        boolean bool;
        if (Build.VERSION.SDK_INT < 21)
        {
          this.mediaCodec.configure(paramMediaFormat, paramSurface, null, 0);
          bool = true;
          return bool;
        }
        int i = 0;
        i += 1;
        try
        {
          Logger.d(this.TAG, "createdDecoder---time---" + i);
          if (i > 10)
          {
            bool = false;
            continue;
          }
          this.mediaCodec.configure(paramMediaFormat, paramSurface, null, 0);
          bool = true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (!(localException instanceof MediaCodec.CodecException)) {
            continue;
          }
        }
        if ((!((MediaCodec.CodecException)localException).isTransient()) && (!((MediaCodec.CodecException)localException).isRecoverable()))
        {
          this.mediaCodec.release();
          throw localException;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  int dequeueInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: ldc2_w 146
    //   9: invokevirtual 150	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   22: ldc 151
    //   24: aload_2
    //   25: invokestatic 154	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   28: aload_0
    //   29: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   32: ifeq +43 -> 75
    //   35: aload_2
    //   36: instanceof 103
    //   39: ifeq +36 -> 75
    //   42: aload_0
    //   43: aload_2
    //   44: checkcast 103	android/media/MediaCodec$CodecException
    //   47: invokespecial 156	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   50: aload_2
    //   51: checkcast 103	android/media/MediaCodec$CodecException
    //   54: invokevirtual 106	android/media/MediaCodec$CodecException:isTransient	()Z
    //   57: ifeq +18 -> 75
    //   60: aload_0
    //   61: ldc2_w 10
    //   64: invokevirtual 160	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   67: aload_0
    //   68: invokevirtual 162	com/tencent/tav/decoder/MediaCodecWrapper:dequeueInputBuffer	()I
    //   71: istore_1
    //   72: goto -59 -> 13
    //   75: aload_2
    //   76: athrow
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    //   82: astore_2
    //   83: goto -65 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	MediaCodecWrapper
    //   12	60	1	i	int
    //   17	59	2	localException	Exception
    //   77	4	2	localObject	Object
    //   82	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	13	17	java/lang/Exception
    //   2	13	77	finally
    //   18	72	77	finally
    //   75	77	77	finally
    //   2	13	82	java/lang/Error
  }
  
  int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      i = this.mediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "dequeueOutputBuffer", localException);
        if ((!isLollipop()) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        tryLogMediaCodecError((MediaCodec.CodecException)localException);
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
        int i = dequeueOutputBuffer(paramBufferInfo);
      }
      throw localException;
    }
    finally {}
  }
  
  void flushDecoder()
  {
    this.mediaCodec.flush();
  }
  
  /* Error */
  java.nio.ByteBuffer getInputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: invokestatic 181	com/tencent/tav/decoder/DecoderUtils:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_2
    //   16: aload_0
    //   17: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   20: ldc 182
    //   22: aload_2
    //   23: invokestatic 154	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   26: aload_0
    //   27: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   30: ifeq +44 -> 74
    //   33: aload_2
    //   34: instanceof 103
    //   37: ifeq +37 -> 74
    //   40: aload_0
    //   41: aload_2
    //   42: checkcast 103	android/media/MediaCodec$CodecException
    //   45: invokespecial 156	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   48: aload_2
    //   49: checkcast 103	android/media/MediaCodec$CodecException
    //   52: invokevirtual 106	android/media/MediaCodec$CodecException:isTransient	()Z
    //   55: ifeq +19 -> 74
    //   58: aload_0
    //   59: ldc2_w 10
    //   62: invokevirtual 160	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   65: aload_0
    //   66: iload_1
    //   67: invokevirtual 184	com/tencent/tav/decoder/MediaCodecWrapper:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   70: astore_2
    //   71: goto -60 -> 11
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: astore_2
    //   82: goto -66 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	MediaCodecWrapper
    //   0	85	1	paramInt	int
    //   10	4	2	localByteBuffer1	java.nio.ByteBuffer
    //   15	34	2	localException	Exception
    //   70	5	2	localByteBuffer2	java.nio.ByteBuffer
    //   76	4	2	localObject	Object
    //   81	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	11	15	java/lang/Exception
    //   2	11	76	finally
    //   16	71	76	finally
    //   74	76	76	finally
    //   2	11	81	java/lang/Error
  }
  
  /* Error */
  java.nio.ByteBuffer getOnputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: invokestatic 188	com/tencent/tav/decoder/DecoderUtils:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_2
    //   16: aload_0
    //   17: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   20: ldc 189
    //   22: aload_2
    //   23: invokestatic 154	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   26: aload_0
    //   27: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   30: ifeq +44 -> 74
    //   33: aload_2
    //   34: instanceof 103
    //   37: ifeq +37 -> 74
    //   40: aload_0
    //   41: aload_2
    //   42: checkcast 103	android/media/MediaCodec$CodecException
    //   45: invokespecial 156	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   48: aload_2
    //   49: checkcast 103	android/media/MediaCodec$CodecException
    //   52: invokevirtual 106	android/media/MediaCodec$CodecException:isTransient	()Z
    //   55: ifeq +19 -> 74
    //   58: aload_0
    //   59: ldc2_w 10
    //   62: invokevirtual 160	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   65: aload_0
    //   66: iload_1
    //   67: invokevirtual 191	com/tencent/tav/decoder/MediaCodecWrapper:getOnputBuffer	(I)Ljava/nio/ByteBuffer;
    //   70: astore_2
    //   71: goto -60 -> 11
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: astore_2
    //   82: goto -66 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	MediaCodecWrapper
    //   0	85	1	paramInt	int
    //   10	4	2	localByteBuffer1	java.nio.ByteBuffer
    //   15	34	2	localException	Exception
    //   70	5	2	localByteBuffer2	java.nio.ByteBuffer
    //   76	4	2	localObject	Object
    //   81	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	11	15	java/lang/Exception
    //   2	11	76	finally
    //   16	71	76	finally
    //   74	76	76	finally
    //   2	11	81	java/lang/Error
  }
  
  /* Error */
  void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: iload_2
    //   8: iload_3
    //   9: lload 4
    //   11: iload 6
    //   13: invokevirtual 195	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore 7
    //   21: aload_0
    //   22: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   25: ldc 196
    //   27: aload 7
    //   29: invokestatic 154	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   32: aload_0
    //   33: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   36: ifeq +49 -> 85
    //   39: aload 7
    //   41: instanceof 103
    //   44: ifeq +41 -> 85
    //   47: aload_0
    //   48: aload 7
    //   50: checkcast 103	android/media/MediaCodec$CodecException
    //   53: invokespecial 156	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   56: aload 7
    //   58: checkcast 103	android/media/MediaCodec$CodecException
    //   61: invokevirtual 106	android/media/MediaCodec$CodecException:isTransient	()Z
    //   64: ifeq +21 -> 85
    //   67: aload_0
    //   68: ldc2_w 10
    //   71: invokevirtual 160	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   74: aload_0
    //   75: iload_1
    //   76: iload_2
    //   77: iload_3
    //   78: lload 4
    //   80: iload 6
    //   82: invokevirtual 197	com/tencent/tav/decoder/MediaCodecWrapper:queueInputBuffer	(IIIJI)V
    //   85: aload 7
    //   87: athrow
    //   88: astore 7
    //   90: aload_0
    //   91: monitorexit
    //   92: aload 7
    //   94: athrow
    //   95: astore 7
    //   97: goto -76 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	MediaCodecWrapper
    //   0	100	1	paramInt1	int
    //   0	100	2	paramInt2	int
    //   0	100	3	paramInt3	int
    //   0	100	4	paramLong	long
    //   0	100	6	paramInt4	int
    //   19	67	7	localException	Exception
    //   88	5	7	localObject	Object
    //   95	1	7	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	16	19	java/lang/Exception
    //   2	16	88	finally
    //   21	85	88	finally
    //   85	88	88	finally
    //   2	16	95	java/lang/Error
  }
  
  void release()
  {
    if (this.mediaCodec != null) {
      new MediaCodecWrapper.1(this).start();
    }
  }
  
  /* Error */
  void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: iload_2
    //   8: invokevirtual 209	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   11: iload_2
    //   12: ifeq +11 -> 23
    //   15: aload_0
    //   16: getfield 49	com/tencent/tav/decoder/MediaCodecWrapper:videoDecoder	Lcom/tencent/tav/decoder/VideoDecoder;
    //   19: iconst_1
    //   20: putfield 215	com/tencent/tav/decoder/VideoDecoder:lastFrameValid	Z
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   31: ldc 216
    //   33: aload_3
    //   34: invokestatic 154	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   37: aload_0
    //   38: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   41: ifeq +41 -> 82
    //   44: aload_3
    //   45: instanceof 103
    //   48: ifeq +34 -> 82
    //   51: aload_0
    //   52: aload_3
    //   53: checkcast 103	android/media/MediaCodec$CodecException
    //   56: invokespecial 156	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   59: aload_3
    //   60: checkcast 103	android/media/MediaCodec$CodecException
    //   63: invokevirtual 106	android/media/MediaCodec$CodecException:isTransient	()Z
    //   66: ifeq +16 -> 82
    //   69: aload_0
    //   70: ldc2_w 10
    //   73: invokevirtual 160	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   76: aload_0
    //   77: iload_1
    //   78: iload_2
    //   79: invokevirtual 217	com/tencent/tav/decoder/MediaCodecWrapper:releaseOutputBuffer	(IZ)V
    //   82: aload_3
    //   83: athrow
    //   84: astore_3
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_3
    //   88: athrow
    //   89: astore_3
    //   90: goto -63 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	MediaCodecWrapper
    //   0	93	1	paramInt	int
    //   0	93	2	paramBoolean	boolean
    //   26	57	3	localException	Exception
    //   84	4	3	localObject	Object
    //   89	1	3	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   2	11	26	java/lang/Exception
    //   15	23	26	java/lang/Exception
    //   2	11	84	finally
    //   15	23	84	finally
    //   27	82	84	finally
    //   82	84	84	finally
    //   2	11	89	java/lang/Error
    //   15	23	89	java/lang/Error
  }
  
  /* Error */
  void reset(Surface paramSurface, MediaFormat paramMediaFormat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/tencent/tav/decoder/MediaCodecWrapper:videoDecoder	Lcom/tencent/tav/decoder/VideoDecoder;
    //   6: getfield 221	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifeq +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   21: ldc 222
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokestatic 226	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 228	com/tencent/tav/decoder/MediaCodecWrapper:resetMediaCodec	(Landroid/media/MediaFormat;)V
    //   35: aload_0
    //   36: aload_2
    //   37: aload_1
    //   38: invokevirtual 230	com/tencent/tav/decoder/MediaCodecWrapper:decoderConfigure	(Landroid/media/MediaFormat;Landroid/view/Surface;)Z
    //   41: pop
    //   42: aload_0
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 233	com/tencent/tav/decoder/MediaCodecWrapper:startDecoder	(Landroid/view/Surface;Landroid/media/MediaFormat;)V
    //   48: goto -34 -> 14
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   56: goto -42 -> 14
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	MediaCodecWrapper
    //   0	64	1	paramSurface	Surface
    //   0	64	2	paramMediaFormat	MediaFormat
    //   9	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   30	48	51	java/lang/Exception
    //   2	10	59	finally
    //   17	30	59	finally
    //   30	48	59	finally
    //   52	56	59	finally
  }
  
  void startDecoder(Surface paramSurface, MediaFormat paramMediaFormat)
  {
    for (;;)
    {
      try
      {
        this.mediaCodec.start();
        return;
      }
      catch (Exception localException)
      {
        Logger.e(this.TAG, "start", localException);
        if ((!isLollipop()) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        tryLogMediaCodecError((MediaCodec.CodecException)localException);
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          startDecoder(paramSurface, paramMediaFormat);
          continue;
        }
      }
      finally {}
      if (!((MediaCodec.CodecException)localException).isRecoverable()) {
        break;
      }
      reset(paramSurface, paramMediaFormat);
    }
    this.videoDecoder.release(false);
    throw localException;
  }
  
  void waitTime(long paramLong)
  {
    try
    {
      this.videoDecoder.wait(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecWrapper
 * JD-Core Version:    0.7.0.1
 */