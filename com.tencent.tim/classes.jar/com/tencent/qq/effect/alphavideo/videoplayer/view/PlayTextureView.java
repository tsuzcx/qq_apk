package com.tencent.qq.effect.alphavideo.videoplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import com.tencent.qq.effect.alphavideo.common.IntervalFpsLogTimer;
import com.tencent.qq.effect.alphavideo.videoplayer.decoder.HardwareFileDecoder;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.qq.effect.alphavideo.videoplayer.render.BaseRender;
import com.tencent.qq.effect.alphavideo.videoplayer.render.SurfaceTextureBlendRender;
import com.tencent.qq.effect.utils.LogUtil;
import com.tencent.qq.effect.utils.QEffectUtils;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PlayTextureView
  extends GLTextureView
  implements GLSurfaceView.Renderer
{
  private final int DEFAULT_FRAME_RATE = 25;
  private String TAG = "VideoPlayer|PlayView";
  private boolean mContentVisible = true;
  private Context mContext;
  private float mCropValue = 0.0F;
  private int mCurFrameCount = 0;
  private BaseRender mCurRender = null;
  private long mCurTime = 0L;
  private IVideoFileDecodeListener mDecodeListener = new PlayTextureView.1(this);
  private Thread mDecodeThread = null;
  private String mFilepath = null;
  private int mFrameTime = 0;
  private int mGLViewHeight = 0;
  private int mGLViewWidth = 0;
  private int mHalfVideoWidth = 0;
  private IVideoFileDecoder mHardDecoder = null;
  private Runnable mHardwareDecodeWaitForRunnable = new PlayTextureView.6(this);
  private boolean mIsPortrait = true;
  private Object mLock = new Object();
  private boolean mLoop = false;
  private boolean mNeedConfigViewport = true;
  private IntervalFpsLogTimer mOnPreviewFrameLogTimer = new IntervalFpsLogTimer(4000);
  private IVideoPLayListener mPlayListener = null;
  private boolean mPlayStarting = false;
  private boolean mStopping = false;
  private BaseRender mSurfaceTextureRender = null;
  private String mTmpFilePath = null;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private Handler mViewHandler = new Handler();
  private boolean mViewReady = false;
  
  public PlayTextureView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public PlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public PlayTextureView(Context paramContext, IVideoPLayListener paramIVideoPLayListener)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mPlayListener = paramIVideoPLayListener;
    init();
  }
  
  private float CalCrop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 != 0) && (paramInt3 != 0) && (paramInt1 != 0) && (paramInt4 != 0))
    {
      if (paramInt2 * paramInt3 == paramInt1 * paramInt4) {
        LogUtil.v(this.TAG, " crop 0");
      }
    }
    else {
      return 0.0F;
    }
    if (paramInt2 * paramInt3 > paramInt1 * paramInt4)
    {
      f = 0.5F - paramInt4 * paramInt1 * 0.5F / paramInt3 / paramInt2;
      LogUtil.v(this.TAG, " crop height = " + f);
      return f;
    }
    float f = paramInt3 * paramInt2 * 0.5F / paramInt4 / paramInt1 - 0.5F;
    LogUtil.v(this.TAG, " crop width = " + f);
    return f;
  }
  
  private void _calcCropValue()
  {
    if (this.mIsPortrait)
    {
      if (this.mHalfVideoWidth > this.mVideoHeight)
      {
        this.mCropValue = CalCrop(this.mVideoHeight, this.mHalfVideoWidth, this.mGLViewWidth, this.mGLViewHeight);
        return;
      }
      this.mCropValue = CalCrop(this.mHalfVideoWidth, this.mVideoHeight, this.mGLViewWidth, this.mGLViewHeight);
      return;
    }
    if (this.mHalfVideoWidth * 9 >= this.mVideoHeight * 16)
    {
      this.mCropValue = CalCrop(this.mHalfVideoWidth, this.mVideoHeight, this.mGLViewWidth, this.mGLViewHeight);
      return;
    }
    this.mCropValue = 0.0F;
  }
  
  private void callbackError(int paramInt)
  {
    if ((this.mPlayListener != null) && (this.mViewHandler != null)) {
      this.mViewHandler.post(new PlayTextureView.3(this, paramInt));
    }
  }
  
  private void configViewportOnDraw()
  {
    if (this.mIsPortrait) {
      if (this.mHalfVideoWidth < this.mVideoHeight) {
        if (this.mCurRender != null)
        {
          this.mCurRender.setCropValue(this.mCropValue);
          GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
        }
      }
    }
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          i = this.mGLViewWidth * 9 / 16;
          if (this.mHalfVideoWidth != 0) {
            i = this.mGLViewWidth * this.mVideoHeight / this.mHalfVideoWidth;
          }
          j = (this.mGLViewHeight - i) * 2 / 3;
        } while (this.mCurRender == null);
        this.mCurRender.setCropValue(this.mCropValue);
        GLES20.glViewport(0, j, this.mGLViewWidth, i);
        return;
        if (this.mHalfVideoWidth * 9 < this.mVideoHeight * 16) {
          break;
        }
      } while (this.mCurRender == null);
      this.mCurRender.setCropValue(this.mCropValue);
      GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
      return;
      i = this.mHalfVideoWidth * this.mGLViewHeight / this.mVideoHeight;
      j = (this.mGLViewWidth - i) / 2;
    } while (this.mCurRender == null);
    this.mCurRender.setCropValue(this.mCropValue);
    GLES20.glViewport(j, 0, i, this.mGLViewHeight);
  }
  
  private Surface getSurface()
  {
    if ((this.mSurfaceTextureRender != null) && ((this.mSurfaceTextureRender instanceof SurfaceTextureBlendRender))) {
      return ((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getSurface();
    }
    return null;
  }
  
  private void init()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    setRenderer(this);
    setRenderMode(0);
    setVisibility(8);
  }
  
  private void processDecodeEnd()
  {
    queueEvent(new PlayTextureView.4(this));
  }
  
  private void processDecodeError(int paramInt)
  {
    queueEvent(new PlayTextureView.5(this, paramInt));
  }
  
  private void releaseRenderGLThread()
  {
    if (this.mSurfaceTextureRender != null)
    {
      this.mSurfaceTextureRender.destroy();
      this.mSurfaceTextureRender = null;
    }
  }
  
  private void setupDecodeRender()
  {
    this.mHardDecoder = new HardwareFileDecoder(this.mLoop);
    this.mHardDecoder.setDecodeListener(this.mDecodeListener);
    try
    {
      this.mSurfaceTextureRender = new SurfaceTextureBlendRender();
      this.mSurfaceTextureRender.setup();
      setupFrameListenerOES();
      return;
    }
    catch (Exception localException)
    {
      LogUtil.v(this.TAG, "mSurfaceTextureRender Exception switch  soft decode Exception=" + localException);
      localException.printStackTrace();
    }
  }
  
  private void setupFrameListenerOES()
  {
    if ((this.mSurfaceTextureRender != null) && (this.mSurfaceTextureRender.getRenderType() == 1) && (((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getVideoTexture() != null)) {
      ((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getVideoTexture().setOnFrameAvailableListener(new PlayTextureView.9(this));
    }
  }
  
  private void startDecode()
  {
    this.mFrameTime = 0;
    this.mDecodeThread = new Thread(this.mHardwareDecodeWaitForRunnable);
    this.mDecodeThread.start();
  }
  
  public boolean getContentVisible()
  {
    return this.mContentVisible;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((!this.mViewReady) || (this.mCurRender == null) || (this.mVideoWidth <= 0) || (this.mVideoHeight <= 0)) {}
    do
    {
      return;
      if ((this.mNeedConfigViewport) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0))
      {
        _calcCropValue();
        configViewportOnDraw();
        this.mNeedConfigViewport = false;
      }
      this.mCurRender.draw(null, 0, 0, false);
      if (this.mFrameTime > 0)
      {
        this.mCurFrameCount += 1;
        this.mCurTime = (this.mFrameTime * this.mCurFrameCount);
        this.mViewHandler.post(new PlayTextureView.8(this));
      }
      if (this.mOnPreviewFrameLogTimer.isTimeToWriteLog()) {
        LogUtil.i(this.TAG, "onDrawFrame fps= " + this.mOnPreviewFrameLogTimer.getFps());
      }
    } while (this.mContentVisible);
    GLES20.glClear(16384);
    GLES20.glFinish();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    LogUtil.e(this.TAG, "===================gl render onSurfaceChanged " + paramInt1 + " h=" + paramInt2);
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.mGLViewWidth = paramInt1;
    this.mGLViewHeight = paramInt2;
    if (this.mGLViewWidth > this.mGLViewHeight) {}
    for (boolean bool = false;; bool = true)
    {
      this.mIsPortrait = bool;
      if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0)) {
        this.mNeedConfigViewport = true;
      }
      if (!this.mViewReady)
      {
        this.mViewReady = true;
        this.mViewHandler.post(new PlayTextureView.7(this));
      }
      return;
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    LogUtil.e(this.TAG, "===================gl render onSurfaceCreated");
    setupDecodeRender();
  }
  
  public void playFile(String paramString)
  {
    if (this.mStopping) {}
    for (this.mTmpFilePath = paramString;; this.mTmpFilePath = null)
    {
      LogUtil.e(this.TAG, " playFile , want to play filepath =" + paramString);
      if (!this.mPlayStarting) {
        break;
      }
      LogUtil.v(this.TAG, " playFile , one has played , return");
      return;
    }
    if (this.mViewReady)
    {
      LogUtil.v(this.TAG, " playFile , view not ready , return ");
      return;
    }
    this.mPlayStarting = true;
    if (QEffectUtils.fileIsExists(paramString))
    {
      this.mFilepath = paramString;
      this.mCurRender = null;
      new Thread(new PlayTextureView.2(this)).start();
      setVisibility(0);
      return;
    }
    LogUtil.e(this.TAG, " file , get error");
    callbackError(-1);
    this.mPlayStarting = false;
  }
  
  public void setContentVisible(boolean paramBoolean)
  {
    this.mContentVisible = paramBoolean;
  }
  
  public void setLoopState(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
    if (this.mHardDecoder != null) {
      this.mHardDecoder.setLoopState(this.mLoop);
    }
  }
  
  public void setPlayListener(IVideoPLayListener paramIVideoPLayListener)
  {
    this.mPlayListener = paramIVideoPLayListener;
  }
  
  public void stop()
  {
    Log.v(this.TAG, "==============PlayView Stop");
    if (!this.mViewReady) {
      return;
    }
    if (this.mHardDecoder != null) {
      this.mHardDecoder.stop();
    }
    this.mStopping = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView
 * JD-Core Version:    0.7.0.1
 */