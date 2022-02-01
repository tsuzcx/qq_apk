package com.tencent.mobileqq.shortvideo.mtveffects;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.lang.ref.WeakReference;

public class Mp4MaterialLoader
  implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener
{
  private static final int MSG_DECODER_NEXT = 0;
  private static final int MSG_DECODER_PAUSE = 3;
  private static final int MSG_DECODER_RESUME = 4;
  private static final int MSG_DECODER_START = 1;
  private static final int MSG_DECODER_STOP = 2;
  private static final String TAG = "Mp4MaterialLoader";
  private boolean mCacheAvailable = false;
  private int mCacheRef = 0;
  private DecodeHandler mDecodeHandler;
  private HWVideoDecoder mDecoder = new HWVideoDecoder();
  private GPUOESBaseFilter mEncodeGPUOESFilter;
  private EglHandlerThreadEx mHandlerThread;
  private int mHeight;
  private boolean mInited = false;
  private RenderBuffer mMaterialCache;
  private boolean mPause = false;
  private boolean mStop;
  private int mTextureID = -1;
  private Object mWaitRelease = new Object();
  private int mWidth;
  
  public int getCurrentTexture()
  {
    synchronized (this.mWaitRelease)
    {
      if ((this.mMaterialCache == null) || (!this.mCacheAvailable)) {
        return -1;
      }
      this.mCacheRef += 1;
      int i = this.mMaterialCache.getTexId();
      return i;
    }
  }
  
  /* Error */
  @TargetApi(17)
  public void init(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 89
    //   3: invokestatic 95	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(I)I
    //   6: putfield 63	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mTextureID	I
    //   9: aload_0
    //   10: new 78	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   13: dup
    //   14: iload_1
    //   15: iload_2
    //   16: ldc 96
    //   18: invokespecial 99	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   21: putfield 76	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mMaterialCache	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   24: aload_0
    //   25: getfield 101	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   28: ifnull +11 -> 39
    //   31: aload_0
    //   32: getfield 101	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   35: invokevirtual 105	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:quitSafely	()Z
    //   38: pop
    //   39: aload_0
    //   40: new 13	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx
    //   43: dup
    //   44: ldc 107
    //   46: invokestatic 113	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   49: aload_0
    //   50: invokespecial 116	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:<init>	(Ljava/lang/String;Landroid/opengl/EGLContext;Ljava/lang/Object;)V
    //   53: putfield 101	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   56: aload_0
    //   57: getfield 101	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   60: invokevirtual 119	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:start	()V
    //   63: aload_0
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 101	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   69: invokevirtual 122	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:isInitSuccess	()Z
    //   72: istore_3
    //   73: iload_3
    //   74: ifne +10 -> 84
    //   77: aload_0
    //   78: ldc2_w 123
    //   81: invokevirtual 128	java/lang/Object:wait	(J)V
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_0
    //   87: new 10	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$DecodeHandler
    //   90: dup
    //   91: aload_0
    //   92: getfield 101	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   95: invokevirtual 132	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:getLooper	()Landroid/os/Looper;
    //   98: aload_0
    //   99: getfield 61	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;
    //   102: invokespecial 135	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$DecodeHandler:<init>	(Landroid/os/Looper;Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;)V
    //   105: putfield 137	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mDecodeHandler	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$DecodeHandler;
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield 56	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mInited	Z
    //   113: return
    //   114: astore 4
    //   116: aload_0
    //   117: monitorexit
    //   118: aload 4
    //   120: athrow
    //   121: astore 4
    //   123: goto -39 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	Mp4MaterialLoader
    //   0	126	1	paramInt1	int
    //   0	126	2	paramInt2	int
    //   72	2	3	bool	boolean
    //   114	5	4	localObject	Object
    //   121	1	4	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   65	73	114	finally
    //   77	84	114	finally
    //   84	86	114	finally
    //   116	118	114	finally
    //   77	84	121	java/lang/InterruptedException
  }
  
  public boolean isInited()
  {
    return this.mInited;
  }
  
  public void nextTo(long paramLong)
  {
    if (this.mDecodeHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = Long.valueOf(paramLong);
      localMessage.what = 0;
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable) {}
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
    throws InterruptedException
  {}
  
  public void onDecodeRepeat() {}
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart() {}
  
  /* Error */
  public void onFrameAvailable(android.graphics.SurfaceTexture paramSurfaceTexture)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 178	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mStop	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 183	android/graphics/SurfaceTexture:updateTexImage	()V
    //   12: aload_0
    //   13: getfield 69	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mWaitRelease	Ljava/lang/Object;
    //   16: astore_3
    //   17: aload_3
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 65	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mCacheRef	I
    //   23: istore_2
    //   24: iload_2
    //   25: ifle +13 -> 38
    //   28: aload_0
    //   29: getfield 69	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mWaitRelease	Ljava/lang/Object;
    //   32: ldc2_w 123
    //   35: invokevirtual 128	java/lang/Object:wait	(J)V
    //   38: aload_0
    //   39: getfield 65	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mCacheRef	I
    //   42: ifne +88 -> 130
    //   45: bipush 16
    //   47: newarray float
    //   49: astore 4
    //   51: aload_1
    //   52: aload 4
    //   54: invokevirtual 187	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   57: aload_0
    //   58: getfield 189	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   61: ifnonnull +36 -> 97
    //   64: aload_0
    //   65: new 191	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter
    //   68: dup
    //   69: invokespecial 192	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:<init>	()V
    //   72: putfield 189	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   75: aload_0
    //   76: getfield 189	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   79: aload_0
    //   80: getfield 194	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mWidth	I
    //   83: aload_0
    //   84: getfield 196	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHeight	I
    //   87: invokevirtual 199	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:onOutputSizeChanged	(II)V
    //   90: aload_0
    //   91: getfield 189	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   94: invokevirtual 201	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:init	()V
    //   97: aload_0
    //   98: getfield 76	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mMaterialCache	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   101: invokevirtual 204	com/tencent/ttpic/openapi/filter/RenderBuffer:bind	()V
    //   104: aload_0
    //   105: getfield 189	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   108: aload_0
    //   109: getfield 63	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mTextureID	I
    //   112: aload 4
    //   114: aconst_null
    //   115: invokevirtual 208	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:drawTexture	(I[F[F)V
    //   118: aload_0
    //   119: getfield 76	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mMaterialCache	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   122: invokevirtual 211	com/tencent/ttpic/openapi/filter/RenderBuffer:unbind	()V
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 67	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mCacheAvailable	Z
    //   130: aload_3
    //   131: monitorexit
    //   132: return
    //   133: astore_1
    //   134: aload_3
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: ldc 29
    //   141: ldc 213
    //   143: invokestatic 219	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_1
    //   147: invokevirtual 222	java/lang/Exception:printStackTrace	()V
    //   150: return
    //   151: astore 4
    //   153: goto -115 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	Mp4MaterialLoader
    //   0	156	1	paramSurfaceTexture	android.graphics.SurfaceTexture
    //   23	2	2	i	int
    //   49	64	4	arrayOfFloat	float[]
    //   151	1	4	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   19	24	133	finally
    //   28	38	133	finally
    //   38	97	133	finally
    //   97	130	133	finally
    //   130	132	133	finally
    //   134	136	133	finally
    //   8	12	138	java/lang/Exception
    //   28	38	151	java/lang/InterruptedException
  }
  
  public void pause()
  {
    this.mPause = true;
    if (this.mDecodeHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void releaseCurrentTexture()
  {
    synchronized (this.mWaitRelease)
    {
      if (this.mMaterialCache == null) {
        return;
      }
      if (this.mCacheRef > 0)
      {
        this.mCacheRef -= 1;
        this.mWaitRelease.notifyAll();
      }
      return;
    }
  }
  
  public void resume()
  {
    if (!this.mPause) {}
    while (this.mDecodeHandler == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    this.mDecodeHandler.sendMessage(localMessage);
  }
  
  public void seekTo(long paramLong) {}
  
  public void start(String paramString)
  {
    this.mStop = false;
    if ((this.mDecodeHandler != null) && (!TextUtils.isEmpty(paramString)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = new Object[] { Integer.valueOf(this.mTextureID), paramString, this };
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void stop()
  {
    this.mStop = true;
    if (this.mDecodeHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void unInit()
  {
    stop();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quitSafely();
      this.mHandlerThread = null;
    }
    this.mDecodeHandler = null;
    this.mInited = false;
    if (this.mTextureID >= 0)
    {
      GlUtil.deleteTexture(this.mTextureID);
      this.mTextureID = -1;
    }
    if ((this.mMaterialCache != null) && (this.mMaterialCache.getTexId() >= 0))
    {
      GlUtil.deleteTexture(this.mMaterialCache.getTexId());
      this.mMaterialCache.destroy();
      this.mMaterialCache = null;
      this.mCacheRef = 0;
      this.mCacheAvailable = false;
    }
    if (this.mEncodeGPUOESFilter != null)
    {
      this.mEncodeGPUOESFilter.destroy();
      this.mEncodeGPUOESFilter = null;
    }
  }
  
  static class DecodeHandler
    extends Handler
  {
    private WeakReference<HWVideoDecoder> mDecoderRef;
    
    public DecodeHandler(Looper paramLooper, HWVideoDecoder paramHWVideoDecoder)
    {
      super();
      this.mDecoderRef = new WeakReference(paramHWVideoDecoder);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      HWVideoDecoder localHWVideoDecoder = (HWVideoDecoder)this.mDecoderRef.get();
      if (localHWVideoDecoder == null) {}
      do
      {
        do
        {
          do
          {
            return;
            switch (i)
            {
            default: 
              return;
            }
          } while (paramMessage.obj == null);
          long l = ((Long)paramMessage.obj).longValue();
          if (l >= 0L) {
            localHWVideoDecoder.nextTo(l);
          }
          localHWVideoDecoder.decodeFrame();
          return;
        } while (paramMessage.obj == null);
        paramMessage = (Object[])paramMessage.obj;
      } while (paramMessage.length != 3);
      localHWVideoDecoder.startDecode(new DecodeConfig((String)paramMessage[1], 0, true, false), ((Integer)paramMessage[0]).intValue(), (SurfaceTexture.OnFrameAvailableListener)paramMessage[2], (HWDecodeListener)paramMessage[2]);
      return;
      localHWVideoDecoder.pauseDecode();
      return;
      localHWVideoDecoder.resumeDecode();
      return;
      localHWVideoDecoder.stopDecode();
    }
  }
  
  public static class EglHandlerThreadEx
    extends EglHandlerThread
  {
    private WeakReference<Object> mSynObjectRef;
    
    public EglHandlerThreadEx(String paramString, EGLContext paramEGLContext, Object paramObject)
    {
      super(paramEGLContext);
      if (paramObject != null) {
        this.mSynObjectRef = new WeakReference(paramObject);
      }
    }
    
    public void onLooperExited()
    {
      release();
    }
    
    public void onLooperPrepared()
    {
      super.onLooperPrepared();
      if (this.mSynObjectRef != null)
      {
        Object localObject1 = this.mSynObjectRef.get();
        if (localObject1 != null) {
          try
          {
            localObject1.notify();
            return;
          }
          finally {}
        }
      }
    }
    
    @TargetApi(18)
    public boolean quitSafely()
    {
      Looper localLooper = getLooper();
      if (localLooper != null)
      {
        localLooper.quitSafely();
        return true;
      }
      return false;
    }
    
    public void run()
    {
      try
      {
        super.run();
        onLooperExited();
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.Mp4MaterialLoader
 * JD-Core Version:    0.7.0.1
 */