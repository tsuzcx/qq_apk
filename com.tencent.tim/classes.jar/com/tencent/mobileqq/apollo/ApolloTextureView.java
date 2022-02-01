package com.tencent.mobileqq.apollo;

import abhh;
import abii;
import abix;
import abiz;
import abja;
import abju;
import abjw;
import abkh;
import abqt;
import abrj;
import abvh;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class ApolloTextureView
  extends GLTextureView
  implements abix, abiz
{
  public static final String TAG = "ApolloTextureView";
  public static long sReAttachTime;
  private ApolloSurfaceView.d events = new ApolloSurfaceView.d();
  private String mApolloId;
  protected ApolloRenderDriver mApolloWorker;
  private int mAttachCount;
  private WeakReference<abjw> mBarrageViewRef;
  private abja mCallback;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private boolean mDetectTouchMoved;
  private boolean mDisableParentIntercept;
  private boolean mDisableTouchEvent;
  private boolean mDispatchEvent2native;
  private final byte[] mEngineLock = new byte[0];
  private final long mEngineWaitTime;
  private boolean mHasPerformedLongPress;
  private int mInitHeight;
  public AtomicBoolean mIsDestroy;
  public boolean mIsDrawerView;
  boolean mIsReAttach;
  private long mLastClickT;
  private MotionEvent mLastTouchEvent;
  private long mLongPressTimeout;
  public float mManHeight;
  private int mNode;
  private float mPX;
  private float mPY;
  private CheckForLongPress mPendingCheckForLongPress = new CheckForLongPress();
  public ApolloRender mRender;
  protected abii mRenderImpl;
  private boolean mSendEventToNatived;
  private float mTouchDownX;
  private float mTouchDownY;
  private RectF mTouchableRect;
  
  @TargetApi(14)
  public ApolloTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(abhh.lf());
    int i = ApolloUtil.Ac();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "ApolloTextureView MSAA_level:" + i);
    }
    if (i != 0) {
      if (1 == i)
      {
        super.setEGLConfigChooser(new a(4));
        super.setOpaque(false);
        this.mLongPressTimeout = ViewConfiguration.getLongPressTimeout();
        this.mIsDestroy = new AtomicBoolean(false);
        if (this.mDensity > 0.0F) {
          break label285;
        }
      }
    }
    label285:
    for (float f = 1.2F;; f = this.mDensity)
    {
      this.mEngineWaitTime = ((300.0F / f));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTextureView", 2, "[ApolloSurfaceView4Drawer] constructor");
      }
      paramAttributeSet = BaseApplicationImpl.getApplication();
      if ((paramAttributeSet != null) && ((paramContext instanceof Activity)))
      {
        paramAttributeSet = paramAttributeSet.getRuntime();
        if ((paramAttributeSet instanceof QQAppInterface))
        {
          paramAttributeSet = ApolloCmdChannel.getChannel((QQAppInterface)paramAttributeSet);
          if (paramAttributeSet != null) {
            paramAttributeSet.setActivityContext((Activity)paramContext);
          }
        }
      }
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
  
  private native void nativeDestroyTextureView();
  
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
      ((ApolloSurfaceView.d)localObject).size += 1;
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
      queueEvent(new ApolloTextureView.4(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
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
        QLog.d("ApolloTextureView", 2, "move event index =" + k + ",event.count=" + paramMotionEvent.getPointerCount());
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
    queueEvent(new ApolloTextureView.2(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
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
        QLog.e("ApolloTextureView", 1, "send touch event err e=" + localThrowable.toString());
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
        queueEvent(new ApolloTextureView.3(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
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
              ApolloSurfaceView.d locald = this.events;
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
  
  private void touchDownToNativeDirect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    try
    {
      if ((this.mApolloWorker != null) && (this.mApolloWorker.a != null)) {
        this.mApolloWorker.a.BA("mainTicker.paused = false;");
      }
      ApolloSurfaceView.nativeTouchInput(getRender().getSavaWrapper().Nn, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt1, paramArrayOfInt2);
      return;
    }
    catch (Throwable paramArrayOfFloat1)
    {
      QLog.e("ApolloTextureView", 1, "send touch event err e=" + paramArrayOfFloat1.toString());
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
  
  public void disableTouchEvent(boolean paramBoolean)
  {
    this.mDisableTouchEvent = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    QLog.d("sava", 2, "texture view dispatchDraw");
  }
  
  public void exeJsOnEngine(String paramString)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.BH(paramString);
    }
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
  
  public float getManRectMaxHeight()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[getManRectMaxHeight]");
    }
    if (this.mRender == null) {
      return 0.0F;
    }
    Iterator localIterator = this.mRender.mBoundingList.iterator();
    for (float f = 0.0F; localIterator.hasNext(); f = Math.max(f, ((abkh)localIterator.next()).height)) {}
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, new Object[] { "[getManRectMaxHeight] height:", Float.valueOf(f) });
    }
    return f;
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
    if (this.mGLThread != null) {
      return this.mGLThread.getId();
    }
    return -1L;
  }
  
  public String getRenderThreadName()
  {
    return "Apollo_GL";
  }
  
  public long getRuntimeState()
  {
    if ((this.mRender != null) && (this.mRender.getSavaWrapper() != null)) {
      return this.mRender.getSavaWrapper().getLuaState();
    }
    return -1L;
  }
  
  public ApolloRenderDriver getWorker()
  {
    return this.mApolloWorker;
  }
  
  public void init(abja paramabja)
  {
    try
    {
      init(paramabja, 0, null);
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
    //   2: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +51 -> 56
    //   8: ldc 21
    //   10: iconst_2
    //   11: new 137	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 484
    //   21: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 489
    //   31: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc_w 491
    //   41: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokestatic 494	com/tencent/mobileqq/apollo/ApolloEngine:BJ	()Z
    //   47: invokevirtual 497	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: aload_1
    //   58: putfield 244	com/tencent/mobileqq/apollo/ApolloTextureView:mCallback	Labja;
    //   61: aload_3
    //   62: ifnull +92 -> 154
    //   65: aload_0
    //   66: aload_3
    //   67: putfield 406	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   70: ldc 21
    //   72: iconst_1
    //   73: ldc_w 499
    //   76: invokestatic 502	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_0
    //   80: new 16	com/tencent/mobileqq/apollo/ApolloTextureView$b
    //   83: dup
    //   84: aload_0
    //   85: aconst_null
    //   86: invokespecial 505	com/tencent/mobileqq/apollo/ApolloTextureView$b:<init>	(Lcom/tencent/mobileqq/apollo/ApolloTextureView;Lcom/tencent/mobileqq/apollo/ApolloTextureView$1;)V
    //   89: invokespecial 509	com/tencent/mobileqq/apollo/GLTextureView:setEGLContextFactory	(Lcom/tencent/mobileqq/apollo/GLTextureView$f;)V
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 406	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   97: invokespecial 513	com/tencent/mobileqq/apollo/GLTextureView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   100: aload_0
    //   101: iconst_0
    //   102: invokespecial 516	com/tencent/mobileqq/apollo/GLTextureView:setRenderMode	(I)V
    //   105: aload_0
    //   106: new 328	com/tencent/mobileqq/apollo/ApolloRenderDriver
    //   109: dup
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 406	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   115: invokevirtual 349	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   118: invokespecial 519	com/tencent/mobileqq/apollo/ApolloRenderDriver:<init>	(Labiz;Lcom/tencent/mobileqq/apollo/ApolloEngine;)V
    //   121: putfield 326	com/tencent/mobileqq/apollo/ApolloTextureView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   124: aload_0
    //   125: getfield 406	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   128: aload_0
    //   129: invokevirtual 523	com/tencent/mobileqq/apollo/ApolloRender:setRenderView	(Landroid/view/View;)V
    //   132: aload_0
    //   133: new 525	abii
    //   136: dup
    //   137: aload_0
    //   138: getfield 326	com/tencent/mobileqq/apollo/ApolloTextureView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   141: aload_0
    //   142: getfield 406	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   145: invokespecial 528	abii:<init>	(Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;Lcom/tencent/mobileqq/apollo/ApolloRender;)V
    //   148: putfield 460	com/tencent/mobileqq/apollo/ApolloTextureView:mRenderImpl	Labii;
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: aload_0
    //   155: new 345	com/tencent/mobileqq/apollo/ApolloRender
    //   158: dup
    //   159: aload_0
    //   160: getfield 114	com/tencent/mobileqq/apollo/ApolloTextureView:mDensity	F
    //   163: aload_0
    //   164: getfield 244	com/tencent/mobileqq/apollo/ApolloTextureView:mCallback	Labja;
    //   167: iload_2
    //   168: invokespecial 531	com/tencent/mobileqq/apollo/ApolloRender:<init>	(FLabja;I)V
    //   171: putfield 406	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   174: goto -95 -> 79
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	ApolloTextureView
    //   0	182	1	paramabja	abja
    //   0	182	2	paramInt	int
    //   0	182	3	paramApolloRender	ApolloRender
    // Exception table:
    //   from	to	target	type
    //   2	56	177	finally
    //   56	61	177	finally
    //   65	79	177	finally
    //   79	151	177	finally
    //   154	174	177	finally
  }
  
  public boolean isJsRuntime()
  {
    return true;
  }
  
  public native void nativeSetTextureView(ApolloTextureView paramApolloTextureView);
  
  protected void onAttachedToWindow()
  {
    this.mAttachCount += 1;
    if ((this.mAttachCount > 1) && (!this.mIsDrawerView) && (BaseApplicationImpl.sProcessId == 1))
    {
      this.mIsReAttach = true;
      Object localObject = Thread.currentThread().getStackTrace();
      if (localObject != null)
      {
        localObject = Arrays.toString((Object[])localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.i("ApolloTextureView", 1, "onAttachedToWindow found re_attach:" + (String)localObject);
          sReAttachTime = System.currentTimeMillis();
        }
      }
    }
    super.onAttachedToWindow();
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
  
  public void onExecDispose()
  {
    if (this.mRenderImpl != null) {
      this.mRenderImpl.onExecDispose();
    }
  }
  
  public void onExecDispose(String paramString)
  {
    if (this.mRenderImpl != null) {
      this.mRenderImpl.onExecDispose(paramString);
    }
  }
  
  public RectF onGetDressRect(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[onGetDressRect], dressName:" + paramString);
    }
    RectF localRectF = new RectF();
    ReentrantLock localReentrantLock = abvh.a().a();
    QLog.d("ApolloLock", 2, "onGetDressRect");
    localReentrantLock.lock();
    try
    {
      if (this.mRender != null)
      {
        paramString = this.mRender.getSavaWrapper().a(paramString);
        if (paramString != null)
        {
          localRectF.left = paramString.left;
          localRectF.bottom = paramString.top;
          paramString.top += paramString.bottom;
          float f = paramString.right;
          localRectF.right = (paramString.left + f);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloTextureView", 2, "x:" + localRectF.left + ",deltaY:" + localRectF.top + ",width:" + localRectF.right + ",height:" + localRectF.bottom);
          }
        }
      }
      return localRectF;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public float onGetLittleManHeight()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[onGetLittleManHeight]");
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
            QLog.d("ApolloTextureView", 2, "left:" + localRectF.left + ",top:" + localRectF.top + ",right:" + localRectF.right + ",bottom:" + localRectF.bottom);
            f1 = f2;
          }
          localReentrantLock.unlock();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloTextureView", 2, "height:" + f1);
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    QLog.d("sava", 2, "texture view onLayout");
  }
  
  public void onRender()
  {
    queueEvent(new ApolloTextureView.1(this));
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("sava", 2, "texture view onresume");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (this.mDisableTouchEvent) {}
    label103:
    do
    {
      do
      {
        float f1;
        float f2;
        float f3;
        float f4;
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
              } while ((this.mIsDestroy != null) && (this.mIsDestroy.get()));
              if (!ApolloEngine.BJ())
              {
                QLog.w("ApolloTextureView", 1, "apollo lib NOT loaded, textureview ontouch return.");
                return false;
              }
              if (this.mTouchableRect == null) {
                break label103;
              }
              if (this.mTouchableRect.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("ApolloTextureView", 2, "touch not in mTouchableRect!");
            return false;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloTextureView", 2, "touch in mTouchableRect!");
            }
            this.mLastTouchEvent = MotionEvent.obtain(paramMotionEvent);
            switch (paramMotionEvent.getAction())
            {
            default: 
              return false;
            case 0: 
              this.mDetectTouchMoved = false;
              this.mHasPerformedLongPress = false;
              if (this.mPendingCheckForLongPress == null) {
                this.mPendingCheckForLongPress = new CheckForLongPress();
              }
              if (!this.mIsDrawerView)
              {
                this.mPendingCheckForLongPress.cCe();
                super.postDelayed(this.mPendingCheckForLongPress, this.mLongPressTimeout);
              }
              this.mPY = paramMotionEvent.getY();
              this.mPX = paramMotionEvent.getX();
              this.mDisableParentIntercept = false;
              f1 = this.mPX;
              f2 = this.mPY;
              f2 = super.getBottom() - super.getTop() - f2;
            }
          } while (this.mCallback == null);
          System.currentTimeMillis();
          long l = this.mLastClickT;
          this.mLastClickT = System.currentTimeMillis();
          this.mPY = paramMotionEvent.getY();
          this.mPX = paramMotionEvent.getX();
          this.mTouchDownX = this.mPX;
          this.mTouchDownY = this.mPY;
          this.mNode = -1;
          this.mApolloId = "";
          if (this.mRender != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloTextureView", 2, "list length:" + this.mRender.mBoundingList.size() + "mPY = " + this.mPY + ", pty = " + f2 + ",mPX = " + this.mPX + ", xInView = " + f1 + "super.getBottom() = " + super.getBottom() + "super.getTop()" + super.getTop());
            }
            paramMotionEvent = ApolloUtil.a(f1, f2, this.mRender.mBoundingList);
            this.mNode = Integer.parseInt(paramMotionEvent[0]);
            this.mApolloId = paramMotionEvent[1];
          }
          if (!this.mIsDrawerView) {
            break;
          }
          f3 = getWidth();
          f4 = getHeight();
        } while ((f3 > 0.0F) && (f4 > 0.0F) && (((f1 < f3 / 2.0F) && (f2 < f4) && (this.mNode != 1000)) || (f2 > f4)));
        boolean bool1 = bool2;
        if (this.mNode < 0) {
          if (TextUtils.isEmpty(this.mApolloId)) {
            break label562;
          }
        }
        for (bool1 = bool2;; bool1 = false) {
          return bool1;
        }
        if (this.mPendingCheckForLongPress != null) {
          super.removeCallbacks(this.mPendingCheckForLongPress);
        }
      } while ((this.mCallback == null) || (this.mHasPerformedLongPress) || (this.mDetectTouchMoved) || ((this.mNode < 0) && (TextUtils.isEmpty(this.mApolloId))));
      paramMotionEvent = BaseApplicationImpl.getApplication();
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.getRuntime();
        if ((paramMotionEvent instanceof QQAppInterface)) {
          paramMotionEvent = (QQAppInterface)paramMotionEvent;
        }
      }
      if (this.mNode == 1000) {
        this.mCallback.onNotifyStatusChanged(7, this.mApolloId);
      }
      for (;;)
      {
        this.mApolloId = null;
        return false;
        if (this.mNode == 2) {
          this.mCallback.onNotifyStatusChanged(9, this.mApolloId);
        } else {
          this.mCallback.onNotifyStatusChanged(8, this.mApolloId);
        }
      }
      this.mPX = paramMotionEvent.getX();
      this.mPY = paramMotionEvent.getY();
      if ((Math.abs(this.mPX - this.mTouchDownX) > ViewConfiguration.get(getContext()).getScaledTouchSlop()) || (Math.abs(this.mPY - this.mTouchDownY) > ViewConfiguration.get(getContext()).getScaledTouchSlop()))
      {
        super.removeCallbacks(this.mPendingCheckForLongPress);
        this.mHasPerformedLongPress = false;
        this.mDetectTouchMoved = true;
      }
      return true;
    } while (this.mPendingCheckForLongPress == null);
    label562:
    super.removeCallbacks(this.mPendingCheckForLongPress);
    return false;
  }
  
  @Deprecated
  public void queueEvent(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof IApolloRunnableTask)) {
      if (this.mRender != null) {
        this.mRender.queueRenderTask((IApolloRunnableTask)paramRunnable);
      }
    }
    for (;;)
    {
      requestRender();
      return;
      QLog.e("ApolloTextureView", 1, "queueEvent mRender== null");
      continue;
      if (this.mRender != null) {
        this.mRender.queueRenderTask(new ApolloTextureView.5(this, paramRunnable));
      } else {
        QLog.e("ApolloTextureView", 1, "queueEvent mRender== null");
      }
    }
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
  
  public void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if ((!this.mIsDestroy.get()) && (paramIApolloRunnableTask != null)) {
      queueEvent(paramIApolloRunnableTask);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
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
  
  public void setDispatchEvent2Native(boolean paramBoolean)
  {
    this.mDispatchEvent2native = paramBoolean;
  }
  
  public void setDumplicateCreateRenderThread(boolean paramBoolean)
  {
    this.mDisableCreateRenderThread = paramBoolean;
  }
  
  public void setForeground(Drawable paramDrawable) {}
  
  public void setInitHeight(int paramInt)
  {
    this.mInitHeight = paramInt;
  }
  
  public void setLongPressTimeout(int paramInt)
  {
    this.mLongPressTimeout = paramInt;
  }
  
  public void setTouchableRect(RectF paramRectF)
  {
    this.mTouchableRect = paramRectF;
  }
  
  public void stopLoopDelayed(long paramLong)
  {
    if (this.mRenderImpl != null) {
      this.mRenderImpl.stopLoopDelayed(paramLong);
    }
  }
  
  class CheckForLongPress
    implements Runnable
  {
    private int cpb;
    
    CheckForLongPress() {}
    
    public void cCe()
    {
      this.cpb = ApolloTextureView.this.getWindowAttachCount();
    }
    
    public void run()
    {
      if (this.cpb == ApolloTextureView.this.getWindowAttachCount())
      {
        ApolloTextureView.access$302(ApolloTextureView.this, true);
        ApolloTextureView.this.sendAccessibilityEvent(2);
        if ((!TextUtils.isEmpty(ApolloTextureView.this.mApolloId)) && (ApolloTextureView.this.mNode >= 0) && (ApolloTextureView.this.mCallback != null)) {
          ApolloTextureView.this.mCallback.onNotifyLongTouch(ApolloTextureView.this.mApolloId);
        }
      }
    }
  }
  
  static class a
    implements GLTextureView.e
  {
    private int cpa;
    
    public a(int paramInt)
    {
      QLog.i("ApolloTextureView", 1, "[ApolloConfigChooser], multiValue:" + paramInt);
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
        QLog.e("ApolloTextureView", 1, "[ApolloConfigChooser], fail to set config");
        return null;
      }
      return arrayOfEGLConfig[0];
    }
  }
  
  class b
    implements GLTextureView.f
  {
    private b() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      if (ApolloTextureView.this.mIsDestroy != null) {
        ApolloTextureView.this.mIsDestroy.set(false);
      }
      int i = abhh.lf();
      QLog.d("ApolloTextureView", 1, new Object[] { "[createContext], id:" + Thread.currentThread().getId(), ",openGLVersion: ", i + ", hashCode: " + hashCode() });
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
          QLog.e("ApolloTextureView", 1, "[createContext], context error, try foll back opengl 2.0");
          arrayOfInt[1] = 2;
          localEGLContext1 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
        }
      }
      return localEGLContext1;
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      StringBuilder localStringBuilder = new StringBuilder("[destroyContext], id:").append(Thread.currentThread().getId());
      if ((ApolloTextureView.this.mRender != null) && (ApolloTextureView.this.mRender.getSavaWrapper() != null)) {
        localStringBuilder.append(", director: ").append(ApolloTextureView.this.mRender.getSavaWrapper().toString() + ", hashCode: " + hashCode());
      }
      QLog.d("ApolloTextureView", 1, localStringBuilder.toString());
      if (ApolloTextureView.this.mIsDestroy != null) {
        ApolloTextureView.this.mIsDestroy.set(true);
      }
      if (ApolloTextureView.this.mRender != null) {
        ApolloTextureView.this.mRender.onDestroy();
      }
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTextureView
 * JD-Core Version:    0.7.0.1
 */