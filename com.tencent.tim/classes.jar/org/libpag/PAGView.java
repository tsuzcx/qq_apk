package org.libpag;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import org.extra.tools.BroadcastUtil;
import org.extra.tools.ScreenBroadcastReceiver.ScreenStateListener;

public class PAGView
  extends TextureView
  implements TextureView.SurfaceTextureListener, ScreenBroadcastReceiver.ScreenStateListener
{
  private static final int MAX_PRECISION = 100000000;
  private static final int MSG_FLUSH = 1;
  private static final int MSG_PLAY = 0;
  private static final int MSG_REMOVE_CALLBACK_MSG = 2;
  private static final Object g_HandlerLock = new Object();
  private static int g_HandlerThreadCount;
  private static Handler g_PAGRendererHandler = null;
  private static HandlerThread g_PAGRendererThread = null;
  private boolean _isPlaying = false;
  private ValueAnimator animator;
  private String filePath = "";
  private SparseArray<PAGImage> imageReplacementMap = new SparseArray();
  private boolean isAttachedToWindow = false;
  private TextureView.SurfaceTextureListener mListener;
  private boolean mSaveVisibleState;
  private ArrayList<PAGViewListener> mViewListeners = new ArrayList();
  private PAGFile pagFile;
  private PAGPlayer pagPlayer;
  private PAGSurface pagSurface;
  private EGLContext sharedContext = null;
  private SparseArray<PAGText> textReplacementMap = new SparseArray();
  
  static
  {
    g_HandlerThreadCount = 0;
    BroadcastUtil.getInstance().registerScreenBroadcast();
  }
  
  public PAGView(Context paramContext)
  {
    super(paramContext);
    setupSurfaceTexture();
  }
  
  public PAGView(Context paramContext, EGLContext paramEGLContext)
  {
    super(paramContext);
    this.sharedContext = paramEGLContext;
    setupSurfaceTexture();
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setupSurfaceTexture();
  }
  
  public PAGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setupSurfaceTexture();
  }
  
  /* Error */
  private static void DestroyHandlerThread(Object paramObject)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 71	org/libpag/PAGView:g_HandlerThreadCount	I
    //   6: iconst_1
    //   7: isub
    //   8: putstatic 71	org/libpag/PAGView:g_HandlerThreadCount	I
    //   11: iconst_2
    //   12: aload_0
    //   13: invokestatic 122	org/libpag/PAGView:sendMessage	(ILjava/lang/Object;)V
    //   16: getstatic 71	org/libpag/PAGView:g_HandlerThreadCount	I
    //   19: ifne +48 -> 67
    //   22: getstatic 69	org/libpag/PAGView:g_PAGRendererThread	Landroid/os/HandlerThread;
    //   25: ifnull +42 -> 67
    //   28: getstatic 69	org/libpag/PAGView:g_PAGRendererThread	Landroid/os/HandlerThread;
    //   31: invokevirtual 128	android/os/HandlerThread:isAlive	()Z
    //   34: ifeq +33 -> 67
    //   37: getstatic 67	org/libpag/PAGView:g_PAGRendererHandler	Landroid/os/Handler;
    //   40: aconst_null
    //   41: invokevirtual 133	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   44: getstatic 138	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 18
    //   49: if_icmple +22 -> 71
    //   52: getstatic 69	org/libpag/PAGView:g_PAGRendererThread	Landroid/os/HandlerThread;
    //   55: invokevirtual 141	android/os/HandlerThread:quitSafely	()Z
    //   58: pop
    //   59: aconst_null
    //   60: putstatic 69	org/libpag/PAGView:g_PAGRendererThread	Landroid/os/HandlerThread;
    //   63: aconst_null
    //   64: putstatic 67	org/libpag/PAGView:g_PAGRendererHandler	Landroid/os/Handler;
    //   67: ldc 2
    //   69: monitorexit
    //   70: return
    //   71: getstatic 69	org/libpag/PAGView:g_PAGRendererThread	Landroid/os/HandlerThread;
    //   74: invokevirtual 144	android/os/HandlerThread:quit	()Z
    //   77: pop
    //   78: goto -19 -> 59
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	59	81	finally
    //   59	67	81	finally
    //   71	78	81	finally
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      g_HandlerThreadCount += 1;
      if (g_PAGRendererThread == null)
      {
        g_PAGRendererThread = new HandlerThread("pag-renderer");
        g_PAGRendererThread.start();
      }
      if (g_PAGRendererHandler == null) {
        g_PAGRendererHandler = new PAGRendererHandler(g_PAGRendererThread.getLooper());
      }
      return;
    }
    finally {}
  }
  
  private void applyReplacements()
  {
    int j = 0;
    PAGFile localPAGFile = (PAGFile)this.pagPlayer.getComposition();
    if (localPAGFile == null) {
      return;
    }
    int i = 0;
    while (i < this.textReplacementMap.size())
    {
      localPAGFile.replaceText(this.textReplacementMap.keyAt(i), (PAGText)this.textReplacementMap.valueAt(i));
      i += 1;
    }
    this.textReplacementMap.clear();
    i = j;
    while (i < this.imageReplacementMap.size())
    {
      localPAGFile.replaceImage(this.imageReplacementMap.keyAt(i), (PAGImage)this.imageReplacementMap.valueAt(i));
      i += 1;
    }
    this.imageReplacementMap.clear();
  }
  
  private void doPlay()
  {
    if (!this.isAttachedToWindow) {
      return;
    }
    double d = this.pagPlayer.getProgress();
    this.animator.setCurrentPlayTime((d * this.animator.getDuration()));
    post(new PAGView.3(this));
  }
  
  private static void sendMessage(int paramInt, Object paramObject)
  {
    if (g_PAGRendererHandler != null)
    {
      Message localMessage = g_PAGRendererHandler.obtainMessage();
      localMessage.what = paramInt;
      localMessage.obj = paramObject;
      if (paramInt == 0) {
        localMessage.arg1 = ((int)(((Float)((PAGView)paramObject).animator.getAnimatedValue()).floatValue() * 1.0E+008F));
      }
      g_PAGRendererHandler.sendMessage(localMessage);
    }
  }
  
  private void setupSurfaceTexture()
  {
    setOpaque(false);
    this.pagPlayer = new PAGPlayer();
    setSurfaceTextureListener(this);
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.setRepeatCount(0);
    this.animator.setInterpolator(new LinearInterpolator());
    this.animator.addUpdateListener(new PAGView.1(this, this));
    this.animator.addListener(new PAGView.2(this, this));
  }
  
  @Deprecated
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.addListener(paramAnimatorListener);
  }
  
  public void addListener(PAGViewListener paramPAGViewListener)
  {
    try
    {
      this.mViewListeners.add(paramPAGViewListener);
      return;
    }
    finally {}
  }
  
  public boolean cacheEnabled()
  {
    return this.pagPlayer.cacheEnabled();
  }
  
  public float cacheScale()
  {
    return this.pagPlayer.cacheScale();
  }
  
  public long duration()
  {
    return this.pagPlayer.duration();
  }
  
  public boolean flush()
  {
    return this.pagPlayer.flush();
  }
  
  public boolean flush(boolean paramBoolean)
  {
    return flush();
  }
  
  public void freeCache()
  {
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
  }
  
  public PAGComposition getComposition()
  {
    return this.pagPlayer.getComposition();
  }
  
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2)
  {
    return this.pagPlayer.getLayersUnderPoint(paramFloat1, paramFloat2);
  }
  
  public String getPath()
  {
    return this.filePath;
  }
  
  public double getProgress()
  {
    return this.pagPlayer.getProgress();
  }
  
  public PAGComposition getRootComposition()
  {
    return this.pagPlayer.getComposition();
  }
  
  public boolean isPlaying()
  {
    if (this.animator != null) {
      return this.animator.isRunning();
    }
    return false;
  }
  
  public Matrix matrix()
  {
    return this.pagPlayer.matrix();
  }
  
  public float maxFrameRate()
  {
    return this.pagPlayer.maxFrameRate();
  }
  
  public void onAttachedToWindow()
  {
    this.isAttachedToWindow = true;
    super.onAttachedToWindow();
    BroadcastUtil.getInstance().registerScreenBroadcast(this);
    synchronized (g_HandlerLock)
    {
      StartHandlerThread();
      if (this._isPlaying) {
        doPlay();
      }
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    boolean bool2 = false;
    this.isAttachedToWindow = false;
    super.onDetachedFromWindow();
    BroadcastUtil.getInstance().unregisterScreenBroadcast(this);
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    boolean bool1 = bool2;
    if (this._isPlaying)
    {
      bool1 = bool2;
      if (this.animator.isRunning()) {
        bool1 = true;
      }
    }
    this._isPlaying = bool1;
    this.animator.cancel();
    synchronized (g_HandlerLock)
    {
      DestroyHandlerThread(this);
      return;
    }
  }
  
  public void onScreenOff()
  {
    if (getVisibility() == 0) {
      this.mSaveVisibleState = true;
    }
  }
  
  public void onScreenOn()
  {
    if (this.mSaveVisibleState)
    {
      if (getVisibility() != 0) {
        break label29;
      }
      dispatchVisibilityChanged(this, getVisibility());
    }
    for (;;)
    {
      this.mSaveVisibleState = false;
      return;
      label29:
      setVisibility(0);
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      this.pagSurface = null;
    }
    this.pagSurface = PAGSurface.FromSurfaceTexture(paramSurfaceTexture, this.sharedContext);
    this.pagPlayer.setSurface(this.pagSurface);
    if (this.pagSurface == null) {}
    do
    {
      return;
      sendMessage(1, this);
    } while (this.mListener == null);
    this.mListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.pagPlayer.setSurface(null);
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureDestroyed(paramSurfaceTexture);
    }
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.pagSurface != null)
    {
      this.pagSurface.updateSize();
      sendMessage(1, this);
    }
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mListener != null) {
      this.mListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
  }
  
  public void play()
  {
    this._isPlaying = true;
    doPlay();
  }
  
  @Deprecated
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.removeListener(paramAnimatorListener);
  }
  
  public void removeListener(PAGViewListener paramPAGViewListener)
  {
    try
    {
      this.mViewListeners.remove(paramPAGViewListener);
      return;
    }
    finally {}
  }
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null)) {
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceImage(paramInt, paramPAGImage);
      return;
    }
    this.imageReplacementMap.put(paramInt, paramPAGImage);
  }
  
  public int scaleMode()
  {
    return this.pagPlayer.scaleMode();
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT < 24) && (paramDrawable != null)) {
      super.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    this.pagPlayer.setCacheEnabled(paramBoolean);
  }
  
  public void setCacheScale(float paramFloat)
  {
    this.pagPlayer.setCacheScale(paramFloat);
  }
  
  public void setComposition(PAGComposition paramPAGComposition)
  {
    this.filePath = null;
    this.pagFile = null;
    this.pagPlayer.setComposition(paramPAGComposition);
    long l = this.pagPlayer.duration();
    this.animator.setDuration(l / 1000L);
  }
  
  public void setFile(PAGFile paramPAGFile)
  {
    if (paramPAGFile != null) {}
    for (PAGFile localPAGFile = paramPAGFile.copyOriginal();; localPAGFile = null)
    {
      setComposition(localPAGFile);
      this.pagFile = paramPAGFile;
      if (this.pagFile != null) {
        applyReplacements();
      }
      return;
    }
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    this.pagPlayer.setMatrix(paramMatrix);
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    this.pagPlayer.setMaxFrameRate(paramFloat);
  }
  
  public boolean setPath(String paramString)
  {
    if ((paramString != null) && (paramString.startsWith("assets://"))) {}
    for (PAGFile localPAGFile = PAGFile.Load(getContext().getAssets(), paramString.substring(9));; localPAGFile = PAGFile.Load(paramString))
    {
      setComposition(localPAGFile);
      this.filePath = paramString;
      if (localPAGFile == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void setProgress(double paramDouble)
  {
    this.pagPlayer.setProgress(paramDouble);
  }
  
  public void setRepeatCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.animator.setRepeatCount(i - 1);
  }
  
  public void setScaleMode(int paramInt)
  {
    this.pagPlayer.setScaleMode(paramInt);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    if (paramSurfaceTextureListener == this)
    {
      super.setSurfaceTextureListener(paramSurfaceTextureListener);
      return;
    }
    this.mListener = paramSurfaceTextureListener;
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    PAGComposition localPAGComposition = this.pagPlayer.getComposition();
    if ((localPAGComposition != null) && (this.pagFile == null)) {
      return;
    }
    if (localPAGComposition != null)
    {
      ((PAGFile)localPAGComposition).replaceText(paramInt, paramPAGText);
      return;
    }
    this.textReplacementMap.put(paramInt, paramPAGText);
  }
  
  public void setVideoEnabled(boolean paramBoolean)
  {
    this.pagPlayer.setVideoEnabled(paramBoolean);
  }
  
  public void stop()
  {
    this._isPlaying = false;
    post(new PAGView.4(this));
  }
  
  public boolean videoEnabled()
  {
    return this.pagPlayer.videoEnabled();
  }
  
  static class PAGRendererHandler
    extends Handler
  {
    public PAGRendererHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!(paramMessage.obj instanceof PAGView)) {}
      PAGView localPAGView;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localPAGView = (PAGView)paramMessage.obj;
            } while (localPAGView == null);
            switch (paramMessage.what)
            {
            default: 
              return;
            }
          } while (localPAGView.pagPlayer == null);
          float f = paramMessage.arg1 / 1.0E+008F;
          localPAGView.pagPlayer.setProgress(f);
          localPAGView.pagPlayer.flush();
          return;
        } while (localPAGView.pagPlayer == null);
        localPAGView.pagPlayer.flush();
        return;
      } while (PAGView.g_PAGRendererHandler == null);
      PAGView.g_PAGRendererHandler.removeCallbacksAndMessages(localPAGView);
    }
  }
  
  public static abstract interface PAGViewListener
  {
    public abstract void onAnimationCancel(PAGView paramPAGView);
    
    public abstract void onAnimationEnd(PAGView paramPAGView);
    
    public abstract void onAnimationRepeat(PAGView paramPAGView);
    
    public abstract void onAnimationStart(PAGView paramPAGView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.PAGView
 * JD-Core Version:    0.7.0.1
 */