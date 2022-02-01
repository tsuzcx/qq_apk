package com.tencent.mobileqq.apollo;

import abhh;
import abii;
import abix;
import abiz;
import abja;
import abju;
import abjw;
import abmt;
import abqt;
import abrj;
import abvh;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class ApolloSurfaceView
  extends GLSurfaceView
  implements abix, abiz
{
  public static final int INPUT_MARGIN = 10;
  private static final int MSG_CODE_SURFACECHANGED = 255;
  public static final String TAG = "ApolloSurfaceView";
  public static final int TOUCH_MODE_GAME = 1;
  public static final int TOUCH_MODE_NORMAL = 0;
  private static final int UI_STATE_DETACHFROMWINDOW = 2;
  private static final int UI_STATE_SURFACECREATE = 1;
  private static final int UI_STATE_SURFACEDESTROY = 3;
  private static Field sGLThreadField;
  private d events = new d();
  private boolean mAddPredrawListener;
  String mApolloId;
  protected ApolloRenderDriver mApolloWorker;
  protected WeakReference<abjw> mBarrageViewRef;
  private WeakReference<abja> mCallbackRef;
  private boolean mCanDraw;
  private boolean mCloseGame;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private boolean mDetectTouchMoved;
  private boolean mDisableParentIntercept;
  private final byte[] mEngineLock = new byte[0];
  private long mEngineWaitTime;
  private int mGameId;
  private boolean mHasPerformedLongPress;
  private int mHeight;
  private int mInitHeight;
  public AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public boolean mIsGameReady;
  private MotionEvent mLastTouchEvent;
  private int mNode = -1;
  private float mPX;
  private float mPY;
  private CheckForLongPress mPendingCheckForLongPress = new CheckForLongPress();
  ApolloRender mRender;
  protected abii mRenderImpl;
  public int mRenderMode = 1;
  private long mRenderThreadId = -2147483648L;
  private boolean mSendEventToNatived;
  public c mSurfaceCallBackData;
  private Runnable mSurfaceChangeRunnable = new ApolloSurfaceView.6(this);
  private float mTouchDownX;
  private float mTouchDownY;
  private int mTouchMode = 0;
  private AtomicInteger mUIState = new AtomicInteger();
  private boolean mUpdateSurfaceDirect = true;
  private boolean mWaitGameDrawed;
  private int mWidth;
  public int uiOptions;
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(abhh.lf());
    int i = ApolloUtil.Ac();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "ApolloSurfaceView MSAA_level:" + i);
    }
    if (i != 0) {
      if (1 == i)
      {
        super.setEGLConfigChooser(new a(4));
        if (paramBoolean)
        {
          super.setZOrderOnTop(true);
          super.getHolder().setFormat(-2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloSurfaceView", 2, "[ApolloSurfaceView] constructor");
        }
        initTouchEvent();
        paramAttributeSet = BaseApplicationImpl.getApplication();
        if ((paramAttributeSet != null) && ((paramContext instanceof Activity)))
        {
          paramAttributeSet = paramAttributeSet.getRuntime();
          if ((paramAttributeSet instanceof QQAppInterface)) {
            ApolloCmdChannel.getChannel((QQAppInterface)paramAttributeSet).setActivityContext((Activity)paramContext);
          }
        }
        if (this.mDensity > 0.0F) {
          break label344;
        }
      }
    }
    label344:
    for (float f = 1.2F;; f = this.mDensity)
    {
      this.mEngineWaitTime = ((300.0F / f));
      return;
      if (2 == i)
      {
        super.setEGLConfigChooser(new a(2));
        break;
      }
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      break;
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      break;
    }
  }
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(2);
    if (!paramBoolean2)
    {
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
      if (paramBoolean1) {
        super.setZOrderOnTop(true);
      }
      if (paramBoolean3) {
        super.getHolder().setFormat(-2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "[ApolloSurfaceView] constructor");
      }
      initTouchEvent();
      paramAttributeSet = BaseApplicationImpl.getApplication();
      if ((paramAttributeSet != null) && ((paramContext instanceof Activity)))
      {
        paramAttributeSet = paramAttributeSet.getRuntime();
        if ((paramAttributeSet instanceof QQAppInterface)) {
          ApolloCmdChannel.getChannel((QQAppInterface)paramAttributeSet).setActivityContext((Activity)paramContext);
        }
      }
      if (this.mDensity > 0.0F) {
        break label317;
      }
    }
    label317:
    for (float f = 1.2F;; f = this.mDensity)
    {
      this.mEngineWaitTime = ((300.0F / f));
      return;
      int i = abmt.zH();
      if (1 == i)
      {
        super.setEGLConfigChooser(new a(4));
        break;
      }
      if (2 == i)
      {
        super.setEGLConfigChooser(new a(2));
        break;
      }
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
      break;
    }
  }
  
  private native void nativeDestroySurfaceView();
  
  public static native void nativeTouchInput(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private void sendDownTouchNative(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (this.events.size >= 4) {
      return;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 5) {}
    for (int i = paramMotionEvent.getActionIndex();; i = 0)
    {
      this.events.aY[this.events.size] = paramMotionEvent.getX(i);
      this.events.y[this.events.size] = (getMeasuredHeight() - paramMotionEvent.getY(i));
      this.events.jK[this.events.size] = 2;
      this.events.bl[this.events.size] = paramMotionEvent.getPointerId(i);
      Object localObject = this.events;
      ((d)localObject).size += 1;
      if (this.events.size <= 0) {
        break;
      }
      localObject = new float[this.events.size];
      float[] arrayOfFloat = new float[this.events.size];
      int[] arrayOfInt1 = new int[this.events.size];
      int[] arrayOfInt2 = new int[this.events.size];
      i = j;
      while (i < this.events.size)
      {
        localObject[i] = this.events.aY[i];
        arrayOfFloat[i] = this.events.y[i];
        arrayOfInt1[i] = this.events.jK[i];
        arrayOfInt2[i] = this.events.bl[i];
        i += 1;
      }
      runRenderTask(new ApolloSurfaceView.2(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
      paramMotionEvent.recycle();
      return;
    }
  }
  
  private void sendMoveTouchToNative(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= this.events.size) || (i > paramMotionEvent.getPointerCount() - 1) || (i >= 4)) {}
      int k;
      do
      {
        if (this.events.size > 0) {
          break;
        }
        return;
        k = paramMotionEvent.findPointerIndex(this.events.bl[i]);
      } while ((k > paramMotionEvent.getPointerCount() - 1) || (k < 0));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "move event index =" + k + ",event.count=" + paramMotionEvent.getPointerCount());
      }
      if ((paramMotionEvent.getX(k) != this.events.aY[i]) || (paramMotionEvent.getY(k) != this.events.y[i]))
      {
        this.events.aY[i] = paramMotionEvent.getX(k);
        this.events.y[i] = (getMeasuredHeight() - paramMotionEvent.getY(k));
        this.events.jK[i] = 3;
      }
      i += 1;
    }
    float[] arrayOfFloat1 = new float[this.events.size];
    float[] arrayOfFloat2 = new float[this.events.size];
    int[] arrayOfInt1 = new int[this.events.size];
    int[] arrayOfInt2 = new int[this.events.size];
    i = j;
    while (i < this.events.size)
    {
      arrayOfFloat1[i] = this.events.aY[i];
      arrayOfFloat2[i] = this.events.y[i];
      arrayOfInt1[i] = this.events.jK[i];
      arrayOfInt2[i] = this.events.bl[i];
      i += 1;
    }
    runRenderTask(new ApolloSurfaceView.3(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
    paramMotionEvent.recycle();
  }
  
  private void sendUpTouchToNative(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        if ((paramMotionEvent.getAction() & 0xFF) != 6) {
          break label506;
        }
        i = paramMotionEvent.getActionIndex();
        if ((paramMotionEvent.getAction() & 0xFF) != 1) {
          break label503;
        }
        i = -1;
      }
      catch (Throwable localThrowable)
      {
        float[] arrayOfFloat1;
        float[] arrayOfFloat2;
        int[] arrayOfInt1;
        int[] arrayOfInt2;
        paramMotionEvent.recycle();
        QLog.e("ApolloSurfaceView", 1, "send touch event err e=" + localThrowable.toString());
        return;
      }
      if (j < this.events.size)
      {
        if (i == -1)
        {
          this.events.jK[j] = 1;
        }
        else if (paramMotionEvent.getPointerId(i) == this.events.bl[j])
        {
          this.events.aY[j] = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.events.bl[j]));
          this.events.y[j] = (getMeasuredHeight() - paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.events.bl[j])));
          this.events.jK[j] = 1;
        }
      }
      else
      {
        if (this.events.size <= 0) {
          return;
        }
        arrayOfFloat1 = new float[this.events.size];
        arrayOfFloat2 = new float[this.events.size];
        arrayOfInt1 = new int[this.events.size];
        arrayOfInt2 = new int[this.events.size];
        j = 0;
        if (j < this.events.size)
        {
          arrayOfFloat1[j] = this.events.aY[j];
          arrayOfFloat2[j] = this.events.y[j];
          arrayOfInt1[j] = this.events.jK[j];
          arrayOfInt2[j] = this.events.bl[j];
          j += 1;
          continue;
        }
        runRenderTask(new ApolloSurfaceView.4(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
        if (i == -1)
        {
          this.events.size = 0;
          return;
        }
        i = 0;
        for (;;)
        {
          if (i < this.events.size)
          {
            if (this.events.jK[i] == 1)
            {
              while (i < this.events.size - 1)
              {
                this.events.aY[i] = this.events.aY[(i + 1)];
                this.events.y[i] = this.events.y[(i + 1)];
                this.events.jK[i] = this.events.jK[(i + 1)];
                this.events.bl[i] = this.events.bl[(i + 1)];
                i += 1;
              }
              d locald = this.events;
              locald.size -= 1;
            }
          }
          else
          {
            paramMotionEvent.recycle();
            return;
          }
          i += 1;
        }
        label503:
        break label511;
        label506:
        i = 0;
        continue;
        label511:
        j = 0;
        continue;
      }
      j += 1;
    }
  }
  
  private void superSurfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceRedrawNeeded(paramSurfaceHolder);
  }
  
  private void touchDownToNativeDirect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    try
    {
      if ((this.mApolloWorker != null) && (this.mApolloWorker.a != null)) {
        this.mApolloWorker.a.BA("mainTicker.paused = false;");
      }
      nativeTouchInput(getRender().getSavaWrapper().Nn, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt1, paramArrayOfInt2);
      return;
    }
    catch (Throwable paramArrayOfFloat1)
    {
      QLog.e("ApolloSurfaceView", 1, "send touch event err e=" + paramArrayOfFloat1.toString());
    }
  }
  
  public void bulkApolloBarrages(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.mBarrageViewRef != null) && (!TextUtils.isEmpty(paramString2)))
    {
      abjw localabjw = (abjw)this.mBarrageViewRef.get();
      if (localabjw != null) {
        abju.a(localabjw, BaseApplicationImpl.getContext(), paramString1, paramString2, paramBoolean);
      }
    }
  }
  
  public void exeJsOnEngine(String paramString)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.BH(paramString);
    }
  }
  
  public int getGameId()
  {
    return this.mGameId;
  }
  
  public int getInitHeight()
  {
    return this.mInitHeight;
  }
  
  public long getLuaState()
  {
    if ((this.mRender != null) && (this.mRender.getSavaWrapper() != null)) {
      return this.mRender.getSavaWrapper().getLuaState();
    }
    return -1L;
  }
  
  public String getQtaTestResult()
  {
    return this.mRender.getQtaTestResult();
  }
  
  public ApolloRender getRender()
  {
    return this.mRender;
  }
  
  public abii getRenderImpl()
  {
    return this.mRenderImpl;
  }
  
  public long getRenderThreadId()
  {
    try
    {
      if (this.mRenderThreadId != -2147483648L) {
        return this.mRenderThreadId;
      }
      if (sGLThreadField == null)
      {
        sGLThreadField = getClass().getSuperclass().getDeclaredField("mGLThread");
        sGLThreadField.setAccessible(true);
      }
      this.mRenderThreadId = ((Thread)sGLThreadField.get(this)).getId();
      long l = this.mRenderThreadId;
      return l;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloSurfaceView", 1, localException, new Object[0]);
    }
    return 0L;
  }
  
  public long getRuntimeState()
  {
    if (!this.mIsDestroy.get()) {
      return getLuaState();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "apollochannel_,getRuntimeState,mIsGameReady:" + this.mIsGameReady + ",mIsDestroy:" + this.mIsDestroy);
    }
    return -1L;
  }
  
  public int getStatus()
  {
    return this.mApolloWorker.aS.get();
  }
  
  public AtomicInteger getUIState()
  {
    return this.mUIState;
  }
  
  public ApolloRenderDriver getWorker()
  {
    return this.mApolloWorker;
  }
  
  public void init(abja paramabja)
  {
    try
    {
      init(paramabja, 0);
      return;
    }
    finally
    {
      paramabja = finally;
      throw paramabja;
    }
  }
  
  public void init(abja paramabja, int paramInt)
  {
    try
    {
      init(paramabja, paramInt, null);
      return;
    }
    finally
    {
      paramabja = finally;
      throw paramabja;
    }
  }
  
  /* Error */
  public void init(abja paramabja, int paramInt, ApolloRender paramApolloRender)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +39 -> 44
    //   8: ldc 32
    //   10: iconst_2
    //   11: new 191	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 554
    //   21: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 556
    //   31: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: new 441	java/lang/ref/WeakReference
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 559	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   53: putfield 273	com/tencent/mobileqq/apollo/ApolloSurfaceView:mCallbackRef	Ljava/lang/ref/WeakReference;
    //   56: aload_3
    //   57: ifnull +95 -> 152
    //   60: aload_0
    //   61: aload_3
    //   62: putfield 467	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   65: ldc 32
    //   67: iconst_1
    //   68: ldc_w 561
    //   71: invokestatic 564	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: new 16	com/tencent/mobileqq/apollo/ApolloSurfaceView$b
    //   78: dup
    //   79: aload_0
    //   80: aconst_null
    //   81: invokespecial 567	com/tencent/mobileqq/apollo/ApolloSurfaceView$b:<init>	(Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;Lcom/tencent/mobileqq/apollo/ApolloSurfaceView$1;)V
    //   84: invokespecial 571	android/opengl/GLSurfaceView:setEGLContextFactory	(Landroid/opengl/GLSurfaceView$EGLContextFactory;)V
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 467	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   92: invokespecial 575	android/opengl/GLSurfaceView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 106	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderMode	I
    //   100: invokespecial 578	android/opengl/GLSurfaceView:setRenderMode	(I)V
    //   103: aload_0
    //   104: new 403	com/tencent/mobileqq/apollo/ApolloRenderDriver
    //   107: dup
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 467	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   113: invokevirtual 424	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   116: invokespecial 581	com/tencent/mobileqq/apollo/ApolloRenderDriver:<init>	(Labiz;Lcom/tencent/mobileqq/apollo/ApolloEngine;)V
    //   119: putfield 401	com/tencent/mobileqq/apollo/ApolloSurfaceView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   122: aload_0
    //   123: getfield 467	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   126: aload_0
    //   127: invokevirtual 585	com/tencent/mobileqq/apollo/ApolloRender:setRenderView	(Landroid/view/View;)V
    //   130: aload_0
    //   131: new 587	abii
    //   134: dup
    //   135: aload_0
    //   136: getfield 401	com/tencent/mobileqq/apollo/ApolloSurfaceView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   139: aload_0
    //   140: getfield 467	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   143: invokespecial 590	abii:<init>	(Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;Lcom/tencent/mobileqq/apollo/ApolloRender;)V
    //   146: putfield 478	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderImpl	Labii;
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: aload_0
    //   153: new 420	com/tencent/mobileqq/apollo/ApolloRender
    //   156: dup
    //   157: aload_0
    //   158: getfield 168	com/tencent/mobileqq/apollo/ApolloSurfaceView:mDensity	F
    //   161: aload_1
    //   162: iload_2
    //   163: invokespecial 593	com/tencent/mobileqq/apollo/ApolloRender:<init>	(FLabja;I)V
    //   166: putfield 467	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   169: goto -95 -> 74
    //   172: astore_1
    //   173: ldc 32
    //   175: iconst_1
    //   176: new 191	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 595
    //   186: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 598	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   193: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: goto -53 -> 149
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: ldc 32
    //   213: iconst_1
    //   214: new 191	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 600
    //   224: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokevirtual 601	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: goto -91 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	ApolloSurfaceView
    //   0	243	1	paramabja	abja
    //   0	243	2	paramInt	int
    //   0	243	3	paramApolloRender	ApolloRender
    // Exception table:
    //   from	to	target	type
    //   44	56	172	java/lang/OutOfMemoryError
    //   60	74	172	java/lang/OutOfMemoryError
    //   74	149	172	java/lang/OutOfMemoryError
    //   152	169	172	java/lang/OutOfMemoryError
    //   2	44	205	finally
    //   44	56	205	finally
    //   60	74	205	finally
    //   74	149	205	finally
    //   152	169	205	finally
    //   173	202	205	finally
    //   211	240	205	finally
    //   44	56	210	java/lang/Throwable
    //   60	74	210	java/lang/Throwable
    //   74	149	210	java/lang/Throwable
    //   152	169	210	java/lang/Throwable
  }
  
  public void initTouchEvent()
  {
    if (this.events != null)
    {
      int i = 0;
      while (i < 4)
      {
        this.events.aY[i] = 0.0F;
        this.events.y[i] = 0.0F;
        this.events.jK[i] = 0;
        this.events.bl[i] = 0;
        i += 1;
      }
    }
  }
  
  public boolean isGameMode()
  {
    return this.mTouchMode == 1;
  }
  
  public boolean isJsRuntime()
  {
    return (this.mGameId != 1) && (this.mGameId != 2);
  }
  
  public native void nativeSetSurfaceView(ApolloSurfaceView paramApolloSurfaceView);
  
  protected void onAttachedToWindow()
  {
    try
    {
      super.onAttachedToWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSurfaceView", 1, localThrowable, new Object[] { "[onAttachedToWindow]" });
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.mUIState.set(2);
    super.onDetachedFromWindow();
    this.mUIState.set(0);
  }
  
  public void onDrawRectHeightChanged(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = abrj.a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    int j = getWidth();
    int i = paramInt;
    if (paramInt == 0) {
      i = getHeight();
    }
    paramQQAppInterface.gI(j, i);
  }
  
  public void onEnterGame(String paramString)
  {
    if (this.mApolloWorker != null)
    {
      this.mApolloWorker.aNu();
      this.mApolloWorker.onEnterGame(paramString);
      if (this.mGameId == 1000) {}
    }
  }
  
  public float onGetLittleManHeight()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[onGetLittleManHeight]");
    }
    ReentrantLock localReentrantLock = abvh.a().a();
    QLog.d("ApolloLock", 2, "onGetManHeight");
    localReentrantLock.lock();
    for (;;)
    {
      try
      {
        if ((this.mRender == null) || (this.mRender.getSavaWrapper() == null))
        {
          localReentrantLock.unlock();
          return 0.0F;
        }
        RectF localRectF = this.mRender.getSavaWrapper().g();
        if (localRectF != null)
        {
          float f2 = localRectF.top + localRectF.bottom;
          f1 = f2;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloSurfaceView", 2, "left:" + localRectF.left + ",top:" + localRectF.top + ",right:" + localRectF.right + ",bottom:" + localRectF.bottom);
            f1 = f2;
          }
          localReentrantLock.unlock();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSurfaceView", 2, "height:" + f1);
          }
          return f1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return 0.0F;
      }
      finally
      {
        localReentrantLock.unlock();
      }
      float f1 = 0.0F;
    }
  }
  
  public void onRender()
  {
    if ((getRender() == null) || (getRender().getSavaWrapper() == null)) {
      return;
    }
    runRenderTask(new ApolloSurfaceView.1(this, getRender()));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mCallbackRef == null) {}
    abja localabja;
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.mIsDestroy != null) && (this.mIsDestroy.get()));
        localabja = (abja)this.mCallbackRef.get();
      } while (localabja == null);
      if (!ApolloEngine.BJ())
      {
        QLog.i("ApolloSurfaceView", 1, "apollo lib NOT loaded, [onTouchEvent] return.");
        return false;
      }
    } while ((this.mApolloWorker == null) || ((this.mApolloWorker.a != null) && (!this.mApolloWorker.a.jk("surface.touch"))));
    if (this.mTouchMode == 1)
    {
      try
      {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        case 0: 
          if (this.events.size >= 4) {
            QLog.e("ApolloSurfaceView", 1, "touch down is over 4");
          }
          break;
        }
      }
      catch (Throwable paramMotionEvent)
      {
        this.events.size = 0;
        QLog.e("ApolloSurfaceView", 2, "touch event err e=" + paramMotionEvent.toString());
      }
      sendDownTouchNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
      sendDownTouchNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
      if (super.getParent() != null) {
        super.getParent().requestDisallowInterceptTouchEvent(true);
      }
      sendMoveTouchToNative(MotionEvent.obtain(paramMotionEvent));
    }
    else
    {
      this.mLastTouchEvent = MotionEvent.obtain(paramMotionEvent);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.mDetectTouchMoved = false;
        this.mSendEventToNatived = false;
        this.mHasPerformedLongPress = false;
        this.mDisableParentIntercept = false;
        if (this.mPendingCheckForLongPress == null) {
          this.mPendingCheckForLongPress = new CheckForLongPress();
        }
        this.mPendingCheckForLongPress.cCe();
        super.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
        this.mPY = paramMotionEvent.getY();
        this.mPX = paramMotionEvent.getX();
        this.mTouchDownX = this.mPX;
        this.mTouchDownY = this.mPY;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        f2 = super.getBottom() - super.getTop() - f2;
        this.mNode = -1;
        this.mApolloId = "";
        if (this.mRender != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSurfaceView", 2, "list length:" + this.mRender.mBoundingList.size() + "mPY = " + this.mPY + ", pty = " + f2 + ",mPX = " + this.mPX + ", xInView = " + f1 + "super.getBottom() = " + super.getBottom() + "super.getTop()" + super.getTop());
          }
          paramMotionEvent = ApolloUtil.a(f1, f2, this.mRender.mBoundingList);
          this.mNode = Integer.parseInt(paramMotionEvent[0]);
          this.mApolloId = paramMotionEvent[1];
        }
        if ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
        if (this.mPendingCheckForLongPress != null) {
          super.removeCallbacks(this.mPendingCheckForLongPress);
        }
        if ((!this.mHasPerformedLongPress) && (!this.mDetectTouchMoved) && ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))))
        {
          Object localObject = BaseApplicationImpl.getApplication();
          if (localObject != null)
          {
            localObject = ((BaseApplicationImpl)localObject).getRuntime();
            if ((localObject instanceof QQAppInterface)) {
              localObject = (QQAppInterface)localObject;
            }
          }
          if (this.mNode == 1000) {
            localabja.onNotifyStatusChanged(7, this.mApolloId);
          }
          for (;;)
          {
            this.mApolloId = null;
            break;
            if (this.mNode == 2) {
              localabja.onNotifyStatusChanged(9, this.mApolloId);
            } else {
              localabja.onNotifyStatusChanged(8, this.mApolloId);
            }
          }
          this.mPX = paramMotionEvent.getX();
          this.mPY = paramMotionEvent.getY();
          if ((!this.mDisableParentIntercept) && (super.getParent() != null))
          {
            this.mDisableParentIntercept = true;
            super.getParent().requestDisallowInterceptTouchEvent(true);
          }
          if ((Math.abs(this.mPX - this.mTouchDownX) > ViewConfiguration.get(getContext()).getScaledTouchSlop()) || (Math.abs(this.mPY - this.mTouchDownY) > ViewConfiguration.get(getContext()).getScaledTouchSlop()))
          {
            super.removeCallbacks(this.mPendingCheckForLongPress);
            this.mHasPerformedLongPress = false;
            this.mDetectTouchMoved = true;
          }
          return true;
          if (this.mPendingCheckForLongPress != null) {
            super.removeCallbacks(this.mPendingCheckForLongPress);
          }
        }
      }
    }
    label946:
    return true;
  }
  
  public boolean performLongClick()
  {
    return super.performLongClick();
  }
  
  @Deprecated
  public void queueEvent(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof IApolloRunnableTask))
    {
      if (this.mRender != null) {
        this.mRender.queueRenderTask((IApolloRunnableTask)paramRunnable);
      }
      for (;;)
      {
        requestRender();
        return;
        QLog.e("ApolloSurfaceView", 1, "queueEvent mRender== null");
      }
    }
    throw new RuntimeException("queueEvent r must instanceof IApolloRunnableTask");
  }
  
  public void removeAllApolloBarrages(boolean paramBoolean)
  {
    if (this.mBarrageViewRef != null)
    {
      abjw localabjw = (abjw)this.mBarrageViewRef.get();
      if (localabjw != null) {
        localabjw.DI(paramBoolean);
      }
    }
  }
  
  public void run()
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.aNu();
    }
  }
  
  public void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if ((!this.mIsDestroy.get()) && (paramIApolloRunnableTask != null)) {
      queueEvent(paramIApolloRunnableTask);
    }
  }
  
  public void setBarrageView(abjw paramabjw)
  {
    this.mBarrageViewRef = new WeakReference(paramabjw);
  }
  
  public void setBubbleType(int paramInt)
  {
    if (this.mRender != null) {
      this.mRender.setBubbleType(paramInt);
    }
  }
  
  public void setCanDraw(boolean paramBoolean)
  {
    this.mCanDraw = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, new Object[] { "setCanDraw canDraw:", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void setFrameNum(int paramInt)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.mFrameNum = paramInt;
    }
  }
  
  public void setGameId(int paramInt)
  {
    this.mGameId = paramInt;
  }
  
  public void setGameName(String paramString)
  {
    if (this.mRender != null) {
      this.mRender.setGameName(paramString);
    }
  }
  
  public void setGameStatListener(ApolloRenderDriver.a parama)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.setGameStatListener(parama);
    }
  }
  
  public void setInitHeight(int paramInt)
  {
    this.mInitHeight = paramInt;
  }
  
  public void setMainLoadingGameMode(boolean paramBoolean)
  {
    this.mWaitGameDrawed = paramBoolean;
  }
  
  public void setOnDestroyCloseGame(boolean paramBoolean)
  {
    this.mCloseGame = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "setOnDestroyCloseGame, closeGame:" + paramBoolean);
    }
  }
  
  public void setRenderWidthAndHeight(int paramInt1, int paramInt2)
  {
    if (this.mRender != null) {
      this.mRender.setRenderWidthAndHeight(paramInt1, paramInt2);
    }
  }
  
  public void setStatus(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, new Object[] { "[setStatus],status:", Integer.valueOf(paramInt) });
    }
    this.mApolloWorker.aS.set(paramInt);
  }
  
  public void setTouchMode(int paramInt)
  {
    this.mTouchMode = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    try
    {
      super.setVisibility(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloSurfaceView", 1, localException, new Object[0]);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, new Object[] { "surfaceChanged h:", Integer.valueOf(paramInt3) });
    }
    if (abhh.ce("surfaceChangeClose") == 0)
    {
      if ((this.mWidth != paramInt2) || (this.mHeight != paramInt3))
      {
        this.mWidth = paramInt2;
        this.mHeight = paramInt3;
        c localc = new c();
        localc.format = paramInt1;
        localc.d = paramSurfaceHolder;
        localc.w = paramInt2;
        localc.h = paramInt3;
        this.mSurfaceCallBackData = localc;
        ThreadManagerV2.removeJobFromThreadPool(this.mSurfaceChangeRunnable, 16);
        ThreadManagerV2.excute(this.mSurfaceChangeRunnable, 16, null, false);
      }
      return;
    }
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mUIState.set(1);
    super.surfaceCreated(paramSurfaceHolder);
    this.mUIState.set(0);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mUIState.set(3);
    super.surfaceDestroyed(paramSurfaceHolder);
    this.mUIState.set(0);
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25)) {
      if (this.mRender != null) {
        if (this.mRender.isDrawTaskRunning())
        {
          ThreadManagerV2.excute(new ApolloSurfaceView.5(this, paramSurfaceHolder), 16, null, false);
          QLog.i("ApolloSurfaceView", 1, "surfaceRedrawNeeded mRender.isDrawTaskRunning()");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloSurfaceView", 2, "surfaceRedrawNeeded width:" + getWidth() + " height:" + getHeight());
      }
      return;
      super.surfaceRedrawNeeded(paramSurfaceHolder);
      continue;
      super.surfaceRedrawNeeded(paramSurfaceHolder);
    }
  }
  
  class CheckForLongPress
    implements Runnable
  {
    private int cpb;
    
    CheckForLongPress() {}
    
    public void cCe()
    {
      this.cpb = ApolloSurfaceView.this.getWindowAttachCount();
    }
    
    public void run()
    {
      if (ApolloSurfaceView.this.mCallbackRef == null) {}
      abja localabja;
      do
      {
        do
        {
          do
          {
            return;
            localabja = (abja)ApolloSurfaceView.this.mCallbackRef.get();
          } while (localabja == null);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSurfaceView", 2, "CheckForLongPress onLongClick");
          }
        } while (this.cpb != ApolloSurfaceView.this.getWindowAttachCount());
        ApolloSurfaceView.access$302(ApolloSurfaceView.this, true);
        ApolloSurfaceView.this.sendAccessibilityEvent(2);
      } while ((TextUtils.isEmpty(ApolloSurfaceView.this.mApolloId)) || (ApolloSurfaceView.this.mNode < 0) || (localabja == null));
      localabja.onNotifyLongTouch(ApolloSurfaceView.this.mApolloId);
    }
  }
  
  static class a
    implements GLSurfaceView.EGLConfigChooser
  {
    private int cpa;
    
    public a(int paramInt)
    {
      QLog.i("ApolloSurfaceView", 1, "[ApolloConfigChooser], multiValue:" + paramInt);
      this.cpa = paramInt;
    }
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int i = this.cpa;
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      paramEGL10.eglChooseConfig(paramEGLDisplay, new int[] { 12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12321, 8, 12326, 0, 12338, 1, 12337, i, 12344 }, arrayOfEGLConfig, 1, arrayOfInt);
      if (arrayOfInt[0] == 0)
      {
        QLog.e("ApolloSurfaceView", 1, "[ApolloConfigChooser], fail to set config");
        return null;
      }
      return arrayOfEGLConfig[0];
    }
  }
  
  class b
    implements GLSurfaceView.EGLContextFactory
  {
    private b() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      if (ApolloSurfaceView.this.mGameId != 0) {}
      for (int i = 2;; i = abhh.lf())
      {
        QLog.d("ApolloSurfaceView", 1, new Object[] { "[createContext], id:" + Thread.currentThread().getId(), ",openGLVersion:", Integer.valueOf(i) });
        int[] arrayOfInt = new int[3];
        arrayOfInt[0] = 12440;
        arrayOfInt[1] = i;
        arrayOfInt[2] = 12344;
        EGLContext localEGLContext2 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
        EGLContext localEGLContext1 = localEGLContext2;
        if (localEGLContext2 == null)
        {
          localEGLContext1 = localEGLContext2;
          if (arrayOfInt[1] == 3)
          {
            QLog.e("ApolloSurfaceView", 1, "[createContext], context error, try foll back opengl 2.0");
            arrayOfInt[1] = 2;
            localEGLContext1 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
          }
        }
        ApolloSurfaceView.this.mIsDestroy.set(false);
        return localEGLContext1;
      }
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      QLog.d("ApolloSurfaceView", 1, "[destroyContext], id:" + Thread.currentThread().getId());
      Object localObject;
      if (ApolloSurfaceView.this.mCloseGame)
      {
        localObject = abmt.getAppInterface();
        if (localObject != null)
        {
          if (!(localObject instanceof QQAppInterface)) {
            break label161;
          }
          localObject = ApolloCmdChannel.getChannel((QQAppInterface)localObject);
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((ApolloCmdChannel)localObject).callbackDirect(ApolloSurfaceView.this.isJsRuntime(), ApolloSurfaceView.this.getLuaState(), 0, "sc.force_stop_game.local", "{}");
          ((ApolloCmdChannel)localObject).destroyMusic();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSurfaceView", 2, "destroyContext, closeGame)");
          }
        }
        for (;;)
        {
          ApolloSurfaceView.this.mIsDestroy.set(true);
          if (ApolloSurfaceView.this.mRender != null) {
            ApolloSurfaceView.this.mRender.onDestroy();
          }
          if (paramEGL10 != null) {
            paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
          }
          return;
          label161:
          if (!(localObject instanceof CmGameAppInterface)) {
            break label226;
          }
          QLog.i("cmgame_process.", 1, "[destroyContext] in game.");
          localObject = abmt.a();
          break;
          if ((ApolloSurfaceView.this.mApolloWorker != null) && (ApolloSurfaceView.this.mApolloWorker.a != null)) {
            ApolloSurfaceView.this.mApolloWorker.a.BA("if(\"undefined\" != typeof clearSprite && clearSprite){clearSprite();}");
          }
        }
        label226:
        localObject = null;
      }
    }
  }
  
  static class c
  {
    SurfaceHolder d;
    int format;
    int h;
    int w;
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("SurfaceCallBackData{");
      localStringBuffer.append("holder=").append(this.d);
      localStringBuffer.append(", format=").append(this.format);
      localStringBuffer.append(", w=").append(this.w);
      localStringBuffer.append(", h=").append(this.h);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
  
  public static class d
  {
    float[] aY = new float[4];
    int[] bl = new int[4];
    int[] jK = new int[4];
    int size = 0;
    float[] y = new float[4];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView
 * JD-Core Version:    0.7.0.1
 */