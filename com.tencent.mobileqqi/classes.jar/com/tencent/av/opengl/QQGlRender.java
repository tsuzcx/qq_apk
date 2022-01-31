package com.tencent.av.opengl;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
public final class QQGlRender
  implements GLSurfaceView.Renderer
{
  public static int MSG_FLUSH = 1;
  public static int MSG_RENDER;
  public static int MSG_RESET = 2;
  public static int MSG_SHOW_GLVIEW = 3;
  public static String SHOW1STFRAME_BROADCAST = "com.tencent.av.opengl.show1stframe";
  static String TAG = "QQGlRender";
  static boolean soloaded = false;
  int mAngle = -1;
  public float mBrightness = 1.2F;
  Context mContext;
  public float mContrast = 1.93F;
  QQGlRender.EventHandler mEventHandler;
  long mLastRenderTime = 0L;
  private float[] mMMatrix = new float[16];
  private float[] mMVPMatrix = new float[16];
  int mNativeContext = 0;
  boolean mNativeInit = false;
  private float[] mProjMatrix = new float[16];
  int mRotation = 0;
  public float mSaturation = 1.05F;
  boolean mSetMode = false;
  public boolean mShot = false;
  public Bitmap mShotBitmap = null;
  int mShotHeight = 0;
  int mShotWidth = 0;
  int mTextureH = 0;
  int mTextureW = 0;
  int mUIHeight = 0;
  int mUIWidth = 0;
  private float[] mVMatrix = new float[16];
  int m_drawcount = 0;
  long m_endtime = 0L;
  long m_starttime = 0L;
  WeakReference m_view;
  boolean mbPainted = false;
  boolean mfClip = false;
  boolean mfInited = false;
  boolean mfLandscape = false;
  int mfScaleAndDrag = 0;
  boolean mfStarted = false;
  boolean mfWaitViewResetGestureState = false;
  boolean mfshowbackground = true;
  boolean mfshowbackgroundSet = true;
  WeakReference mlistener;
  
  static
  {
    MSG_RENDER = 0;
  }
  
  public QQGlRender(QQGlView paramQQGlView, QQGlRender.QQGLRenderListener paramQQGLRenderListener, int paramInt)
  {
    this.mfScaleAndDrag = paramInt;
    if (!soloaded) {}
    try
    {
      SoLoadUtil.a(paramQQGlView.getContext(), "xplatform", 0, false);
      UpdateAvSo.a(paramQQGlView.getContext(), "qav_graphics");
      soloaded = true;
      this.m_view = new WeakReference(paramQQGlView);
      paramQQGlView = Looper.myLooper();
      if (paramQQGlView != null)
      {
        this.mEventHandler = new QQGlRender.EventHandler(this, this, paramQQGlView);
        this.mlistener = new WeakReference(paramQQGLRenderListener);
        if (soloaded)
        {
          Init(getGLVersion(((QQGlView)this.m_view.get()).getContext()), this.mfScaleAndDrag, new WeakReference(this));
          this.mNativeInit = true;
        }
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        continue;
        paramQQGlView = Looper.getMainLooper();
        if (paramQQGlView != null) {
          this.mEventHandler = new QQGlRender.EventHandler(this, this, paramQQGlView);
        } else {
          this.mEventHandler = null;
        }
      }
    }
  }
  
  public static int getGLVersion(Context paramContext)
  {
    if (((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072) {
      return 2;
    }
    return 1;
  }
  
  static void onNativeNotify(Object paramObject1, int paramInt, Object paramObject2)
  {
    paramObject1 = (WeakReference)paramObject1;
    if (paramObject1.get() != null)
    {
      if (paramInt != MSG_RENDER) {
        break label32;
      }
      ((QQGlRender)paramObject1.get()).notifyupdateui(0, 0);
    }
    label32:
    do
    {
      do
      {
        return;
        if (paramInt == MSG_RESET)
        {
          ((QQGlRender)paramObject1.get()).onResetRender();
          return;
        }
        if (paramInt != MSG_FLUSH) {
          break;
        }
      } while (((QQGlRender)paramObject1.get()).mlistener.get() == null);
      ((QQGlRender.QQGLRenderListener)((QQGlRender)paramObject1.get()).mlistener.get()).c((QQGlRender)paramObject1.get());
      return;
    } while ((paramInt != MSG_SHOW_GLVIEW) || (((QQGlRender)paramObject1.get()).mlistener.get() == null) || (paramObject2 == null));
    GlStringParser localGlStringParser = new GlStringParser('=', ';');
    localGlStringParser.a(paramObject2.toString());
    ((QQGlRender.QQGLRenderListener)((QQGlRender)paramObject1.get()).mlistener.get()).a((QQGlRender)paramObject1.get(), localGlStringParser.a("width"), localGlStringParser.a("height"), localGlStringParser.a("angle"));
  }
  
  native int ConvertYUV2RGB();
  
  native void Init(int paramInt1, int paramInt2, Object paramObject);
  
  public void SetDisplayMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mSetMode = false;
    this.mfClip = paramBoolean2;
    this.mfLandscape = paramBoolean1;
    if (this.mfInited) {
      flush(false);
    }
  }
  
  native void UniformMatrix(float[] paramArrayOfFloat);
  
  native void Uninit();
  
  native void flush(boolean paramBoolean);
  
  public void flushQueue()
  {
    if (this.mfInited) {
      flush(false);
    }
  }
  
  public void flushQueueAll()
  {
    if (this.mfInited) {
      flush(true);
    }
  }
  
  public float getBrightness()
  {
    return this.mBrightness;
  }
  
  public float getContrast()
  {
    return this.mContrast;
  }
  
  public int getGlRotation()
  {
    return this.mRotation;
  }
  
  native int getImgAngle();
  
  native int getImgHeight();
  
  native int getImgIndex();
  
  native int getImgWidth();
  
  native int getRotation();
  
  public float getSaturation()
  {
    return this.mSaturation;
  }
  
  public Bitmap getShotBitmap(int paramInt1, int paramInt2)
  {
    this.mShotWidth = paramInt1;
    this.mShotHeight = paramInt2;
    if (!this.mShot) {
      this.mShot = true;
    }
    if (this.mShotBitmap == null)
    {
      this.mShotBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.mShotBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(-16777216);
      localCanvas.drawRect(new Rect(0, 0, paramInt1, paramInt2), localPaint);
    }
    return this.mShotBitmap;
  }
  
  public boolean isInited()
  {
    return this.mfInited;
  }
  
  public void notifyupdateui(int paramInt1, int paramInt2)
  {
    if ((!this.mfStarted) || (!this.mfInited)) {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "requestRender !init ! started");
      }
    }
    do
    {
      return;
      if (this.mEventHandler != null)
      {
        Message localMessage = this.mEventHandler.obtainMessage(paramInt1, 0, 0, Integer.valueOf(0));
        if (paramInt2 == 0)
        {
          this.mEventHandler.sendMessage(localMessage);
          return;
        }
        this.mEventHandler.sendMessageDelayed(localMessage, paramInt2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "notifyupdateui()");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.m_view.get() == null) {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "m_view.get() == null");
      }
    }
    label680:
    do
    {
      QQGlView localQQGlView;
      do
      {
        do
        {
          return;
          localQQGlView = (QQGlView)this.m_view.get();
        } while (localQQGlView == null);
        this.mUIWidth = localQQGlView.getWidth();
        this.mUIHeight = localQQGlView.getHeight();
        if ((this.mUIWidth > 8) && (this.mUIHeight > 8)) {
          break;
        }
        flushQueue();
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, "(w <= 8 || h <= 8)");
      return;
      this.mLastRenderTime = System.currentTimeMillis();
      int i;
      float f1;
      float f2;
      if (this.mfScaleAndDrag > 0)
      {
        i = ConvertYUV2RGB();
        if (i == -1) {
          continue;
        }
        int j = getImgWidth();
        int k = getImgHeight();
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "onDrawFrame image W=" + j + "H=" + k + "A=" + i);
        }
        if ((j != this.mTextureW) || (this.mTextureH != k) || (this.mAngle != i))
        {
          this.mTextureW = j;
          this.mTextureH = k;
          this.mAngle = i;
          this.mfWaitViewResetGestureState = true;
          localQQGlView.a(false);
          notifyupdateui(1, 0);
        }
        if ((this.mfWaitViewResetGestureState) && (QLog.isColorLevel())) {
          QLog.e(TAG, 2, "mfWaitViewResetGestureState == true");
        }
        f1 = this.mUIWidth / this.mUIHeight;
        f2 = j / k;
        if ((i != 1) && (i != 3)) {
          break label680;
        }
        f2 = f1 * f2;
        f1 = f2;
        if (f2 == 0.0F) {
          f1 = 1.0F;
        }
        Matrix.orthoM(this.mProjMatrix, 0, -f1, f1, -1.0F, 1.0F, 3.0F, 7.0F);
      }
      for (;;)
      {
        Matrix.setRotateM(this.mMMatrix, 0, 0.0F, 0.0F, 0.0F, 1.0F);
        Matrix.multiplyMM(this.mMVPMatrix, 0, this.mVMatrix, 0, this.mMMatrix, 0);
        Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjMatrix, 0, this.mMVPMatrix, 0);
        if ((localQQGlView != null) && (localQQGlView.c()) && (!this.mfshowbackground) && (!this.mfWaitViewResetGestureState))
        {
          f2 = localQQGlView.a();
          f1 = localQQGlView.b();
          f2 = (localQQGlView.getWidth() / 2 - f2) / (localQQGlView.getWidth() / 2);
          f1 = (localQQGlView.getHeight() / 2 - f1) / (localQQGlView.getHeight() / 2) * localQQGlView.getHeight() / localQQGlView.b();
          f2 = f2 * localQQGlView.getWidth() / localQQGlView.a();
          Matrix.translateM(this.mMVPMatrix, 0, f2, f1, 0.0F);
          Matrix.scaleM(this.mMVPMatrix, 0, localQQGlView.c(), localQQGlView.c(), 1.0F);
        }
        UniformMatrix(this.mMVPMatrix);
        i = getImgIndex();
        render();
        if ((localQQGlView != null) && (localQQGlView.c())) {
          localQQGlView.c();
        }
        if (this.mShot)
        {
          this.mShotBitmap = shotRender(paramGL10);
          if (this.mShotBitmap == null) {
            this.mShotBitmap = shotRender(paramGL10);
          }
        }
        this.mbPainted = true;
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "onDrawFrame cost time:" + (System.currentTimeMillis() - this.mLastRenderTime));
        }
        if ((i != 1) || (this.mlistener.get() == null)) {
          break;
        }
        ((QQGlRender.QQGLRenderListener)this.mlistener.get()).e(this);
        return;
        f2 = 1.0F / f1 * f2;
        f1 = f2;
        if (f2 == 0.0F) {
          f1 = 1.0F;
        }
        Matrix.orthoM(this.mProjMatrix, 0, -1.0F, 1.0F, -f1, f1, 3.0F, 7.0F);
      }
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "ConvertYUV2RGB() == -1");
  }
  
  public native void onPause();
  
  void onResetRender()
  {
    if ((this.mfInited) && (this.mfStarted) && (this.mlistener.get() != null))
    {
      flush(false);
      ((QQGlRender.QQGLRenderListener)this.mlistener.get()).d(this);
    }
  }
  
  public native void onResume();
  
  public void onStarted()
  {
    this.mfStarted = true;
    flushQueue();
  }
  
  public void onStoped()
  {
    this.mfStarted = false;
    this.mSetMode = false;
  }
  
  @SuppressLint({"NewApi"})
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if ((this.mUIWidth != paramInt1) || (this.mUIHeight != paramInt2))
    {
      paramGL10.glViewport(0, 0, paramInt1, paramInt2);
      this.mUIWidth = paramInt1;
      this.mUIHeight = paramInt2;
    }
    this.mSetMode = false;
    this.mTextureW = 0;
    this.mTextureH = 0;
    this.mAngle = -1;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    float f = paramInt1 / paramInt2;
    Matrix.orthoM(this.mProjMatrix, 0, -f, f, -1.0F, 1.0F, 3.0F, 7.0F);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.mSetMode = false;
  }
  
  public void onSurfaceDestroyed()
  {
    if (this.mlistener.get() != null) {
      ((QQGlRender.QQGLRenderListener)this.mlistener.get()).b(this);
    }
    if (this.mEventHandler != null)
    {
      this.mEventHandler.removeMessages(0);
      this.mEventHandler.removeMessages(1);
    }
    Uninit();
    this.mfInited = false;
    this.mNativeInit = false;
    this.mNativeContext = 0;
    this.mUIWidth = 0;
    this.mUIHeight = 0;
    this.mTextureW = 0;
    this.mTextureH = 0;
    this.mAngle = -1;
    this.mSetMode = false;
  }
  
  native void render();
  
  public void requestRender()
  {
    if (!this.mfInited) {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "requestRender !init");
      }
    }
    do
    {
      do
      {
        return;
        if (!this.mfStarted)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "requestRender !started");
          }
          flush(false);
        }
        if (!this.mSetMode)
        {
          setDisplayMode(((QQGlView)this.m_view.get()).getWidth(), ((QQGlView)this.m_view.get()).getHeight(), this.mfLandscape, this.mfClip);
          this.mSetMode = true;
        }
        if (!this.mfshowbackgroundSet)
        {
          showbackground(this.mfshowbackground);
          this.mfshowbackgroundSet = true;
        }
        if (this.m_view.get() == null) {
          break;
        }
      } while (System.currentTimeMillis() - this.mLastRenderTime < 33L);
      ((QQGlView)this.m_view.get()).e();
      return;
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "requestRender Err!");
  }
  
  native void setDisplayMode(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  public void setGlParams(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mBrightness = paramFloat1;
    this.mContrast = paramFloat2;
    this.mSaturation = paramFloat3;
    if (this.mfInited) {
      setParam(this.mBrightness, this.mContrast, this.mSaturation);
    }
  }
  
  public void setGlRotation(int paramInt)
  {
    if (this.mRotation != paramInt)
    {
      this.mRotation = paramInt;
      if (this.mfInited) {
        setRotation(paramInt);
      }
      paramInt = (int)(System.currentTimeMillis() - this.mLastRenderTime);
      if (paramInt >= 150) {
        notifyupdateui(0, 0);
      }
    }
    else
    {
      return;
    }
    notifyupdateui(0, paramInt);
  }
  
  native void setParam(float paramFloat1, float paramFloat2, float paramFloat3);
  
  native void setRotation(int paramInt);
  
  public void setWaitViewResetGestureState(boolean paramBoolean)
  {
    this.mfWaitViewResetGestureState = paramBoolean;
  }
  
  Bitmap shotRender(GL10 paramGL10)
  {
    int m = this.mShotWidth;
    int n = this.mShotHeight;
    int[] arrayOfInt1 = new int[(0 + n) * m];
    int[] arrayOfInt2 = new int[m * n];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    paramGL10.glReadPixels(0, 0, m, 0 + n, 6408, 5121, localIntBuffer);
    int i = 0;
    int j = 0;
    while (j < n)
    {
      int k = 0;
      while (k < m)
      {
        int i1 = arrayOfInt1[(j * m + k)];
        arrayOfInt2[((n - i - 1) * m + k)] = (i1 & 0xFF00FF00 | i1 << 16 & 0xFF0000 | i1 >> 16 & 0xFF);
        k += 1;
      }
      j += 1;
      i += 1;
    }
    paramGL10 = Bitmap.createBitmap(arrayOfInt2, m, n, Bitmap.Config.ARGB_8888);
    this.mShot = false;
    return paramGL10;
  }
  
  public void showBackground(boolean paramBoolean)
  {
    this.mfshowbackground = paramBoolean;
    if (!this.mfInited) {
      this.mfshowbackgroundSet = false;
    }
    do
    {
      return;
      showbackground(paramBoolean);
      requestRender();
    } while (!paramBoolean);
    notifyupdateui(0, 100);
  }
  
  native void showbackground(boolean paramBoolean);
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (soloaded)
    {
      if (!this.mNativeInit) {
        Init(getGLVersion(((QQGlView)this.m_view.get()).getContext()), this.mfScaleAndDrag, new WeakReference(this));
      }
      this.mNativeInit = true;
    }
    this.mfInited = true;
    setParam(this.mBrightness, this.mContrast, this.mSaturation);
    setRotation(this.mRotation);
    Matrix.setLookAtM(this.mVMatrix, 0, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    if (this.mlistener.get() != null) {
      ((QQGlRender.QQGLRenderListener)this.mlistener.get()).a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.QQGlRender
 * JD-Core Version:    0.7.0.1
 */