package dov.com.qq.im.ptv;

import acfp;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import aqcl;
import ayaj;
import aybb;
import aybc;
import aybd;
import aybe;
import aybf;
import aybg;
import aybh;
import aybi;
import aybj;
import aybk;
import aybl;
import azbx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class LightWeightCaptureButtonLayout
  extends RelativeLayout
  implements SimpleEffectsCaptureView.a
{
  protected float Fs = azbx.dip2px(2.0F);
  protected float Ft = azbx.dip2px(5.0F);
  protected float Fu = azbx.dip2px(2.0F);
  protected ArrayList<Animator> Gm = new ArrayList();
  public BaseButton a;
  private StartRunnable a;
  public a a;
  protected b a;
  protected c a;
  protected long ahO;
  protected SimpleEffectsCaptureView b;
  public BaseButton b;
  public LightWeightProgress b;
  public BaseButton c;
  protected boolean cAn;
  private LWMotionEvent d = new LWMotionEvent();
  protected AtomicBoolean dE = new AtomicBoolean(false);
  protected AtomicBoolean dF = new AtomicBoolean(false);
  protected boolean dxH;
  protected boolean dxI;
  public boolean dxJ;
  private boolean dxK;
  private boolean dxL;
  protected int eJe;
  protected final int eJf = 30;
  protected final int eJg = 3;
  protected Handler handler = new aybe(this, Looper.getMainLooper());
  private Random i = new Random();
  protected boolean isOver;
  protected boolean isPaused;
  private boolean mIsEnable = true;
  public int mSessionType;
  private View.OnTouchListener onTouchListener = new aybb(this);
  protected float za = 20000.0F;
  
  public LightWeightCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable = new StartRunnable(null);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a = new a();
    init();
  }
  
  public LightWeightCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable = new StartRunnable(null);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a = new a();
    init();
  }
  
  private AnimatorSet a(View paramView, float paramFloat1, float paramFloat2)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(100L);
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat2, 0.0F });
    paramView.setDuration(40L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator).before(paramView);
    return localAnimatorSet;
  }
  
  private boolean a(LWMotionEvent paramLWMotionEvent, boolean paramBoolean)
  {
    if (this.isPaused) {
      return false;
    }
    if (paramBoolean) {
      if (this.dxH)
      {
        this.handler.postDelayed(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable, 800L);
        this.dxI = true;
      }
    }
    for (;;)
    {
      c(paramLWMotionEvent);
      return true;
      ePS();
      continue;
      ePS();
    }
  }
  
  @TargetApi(19)
  private void aeX(int paramInt)
  {
    String str = MotionEvent.actionToString(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "cocohe onTouchHook handleTouch  actionName=" + str);
    }
  }
  
  private void ePS()
  {
    this.handler.sendEmptyMessage(2);
    this.ahO = System.currentTimeMillis();
    this.handler.sendEmptyMessage(4);
    this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.setVisibility(0);
    this.cAn = true;
  }
  
  private void ePU()
  {
    if (this.cAn)
    {
      if (this.dE.get()) {
        this.handler.sendEmptyMessage(3);
      }
      this.cAn = false;
    }
  }
  
  private void ePW()
  {
    if (this.cAn)
    {
      if (this.dE.get()) {
        this.handler.sendEmptyMessage(6);
      }
      this.cAn = false;
    }
  }
  
  public int RE()
  {
    return Math.abs(this.jdField_b_of_type_DovComQqImPtvBaseButton.getLeft() + this.jdField_b_of_type_DovComQqImPtvBaseButton.getWidth() / 2 - (this.jdField_a_of_type_DovComQqImPtvBaseButton.getLeft() + this.jdField_a_of_type_DovComQqImPtvBaseButton.getWidth() / 2));
  }
  
  public int RF()
  {
    int j = this.c.getLeft();
    int k = this.c.getWidth() / 2;
    return Math.abs(this.jdField_a_of_type_DovComQqImPtvBaseButton.getLeft() + this.jdField_a_of_type_DovComQqImPtvBaseButton.getWidth() / 2 - (j + k));
  }
  
  public int RG()
  {
    int j = this.jdField_b_of_type_DovComQqImPtvBaseButton.getTop();
    int k = this.jdField_b_of_type_DovComQqImPtvBaseButton.getHeight() / 2;
    return Math.abs(this.jdField_a_of_type_DovComQqImPtvBaseButton.getTop() + this.jdField_a_of_type_DovComQqImPtvBaseButton.getHeight() / 2 - (j + k));
  }
  
  protected AnimatorSet a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Animator paramAnimator, ArrayList<Animator> paramArrayList, long paramLong1, long paramLong2)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat1, paramFloat2 });
    Object localObject = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat1, paramFloat2 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator).with((Animator)localObject);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (Animator)paramArrayList.next();
        localAnimatorSet.play(localObjectAnimator).with((Animator)localObject);
      }
    }
    localAnimatorSet.setDuration(paramLong1);
    paramArrayList = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat3, paramFloat4 });
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat3, paramFloat4 });
    paramView = new AnimatorSet();
    paramView.play(paramArrayList).with(localObjectAnimator);
    paramView.setDuration(paramLong2);
    paramArrayList = new AnimatorSet();
    paramArrayList.play(localAnimatorSet).before(paramView);
    if (paramAnimator != null) {
      paramArrayList.play(localAnimatorSet).with(paramAnimator);
    }
    return paramArrayList;
  }
  
  public void a(b paramb, SimpleEffectsCaptureView paramSimpleEffectsCaptureView, LightWeightProgress paramLightWeightProgress)
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView = paramSimpleEffectsCaptureView;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setAudioVolumeListener(this);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b = paramb;
    this.jdField_b_of_type_DovComQqImPtvLightWeightProgress = paramLightWeightProgress;
  }
  
  protected boolean a(View paramView, LWMotionEvent paramLWMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action:" + paramLWMotionEvent.getAction() + ", shortVideoShot:" + this.dE.get() + ", actionUp:" + this.dF.get() + ", isOver:" + this.isOver);
    }
    if (this.isOver) {}
    while (!this.mIsEnable) {
      return false;
    }
    switch (paramLWMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      return a(paramLWMotionEvent, false);
    case 1: 
    case 3: 
      a(paramLWMotionEvent);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action: mHaveIPCEvent: " + this.dxL + " isStarting: " + this.cAn);
    }
    if ((this.dxL) && (!this.cAn))
    {
      if ((this.dxH) && (this.dxI))
      {
        d(paramLWMotionEvent);
        return false;
      }
      return a(paramLWMotionEvent, true);
    }
    d(paramLWMotionEvent);
    return false;
  }
  
  protected boolean a(LWMotionEvent paramLWMotionEvent)
  {
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowDraw(false);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxQ = true;
    if (!this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN)
    {
      stopCapture();
      return true;
    }
    switch (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status)
    {
    default: 
      return false;
    case 0: 
      stopCapture();
      return true;
    }
    stopCapture();
    return true;
  }
  
  protected boolean aQb()
  {
    return false;
  }
  
  public boolean aQc()
  {
    return this.jdField_a_of_type_DovComQqImPtvBaseButton.isEnabled();
  }
  
  public void aZ(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.dE.get());
    }
    if (!this.jdField_a_of_type_DovComQqImPtvBaseButton.isEnabled()) {
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "handleCaptureMessage[isEnabled= false]: what: " + paramMessage.what + ", shortVideoShot:" + this.dE.get());
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 1: 
            default: 
              return;
            case 2: 
              if (!this.dE.get())
              {
                if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b != null) {
                  this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b.coA();
                }
                this.dE.set(true);
                return;
              }
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("CameraCaptureLayout", 2, "handleCaptureMessage[Have Already started]: what: " + paramMessage.what + ", shortVideoShot:" + this.dE.get());
          return;
        } while (!this.dE.get());
        if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b != null) {
          this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b.coB();
        }
        this.dE.set(false);
        return;
      } while (!this.dE.get());
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b != null) {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b.ePB();
      }
      this.dE.set(false);
      ePD();
      return;
    } while (!this.dE.get());
    adc();
    this.handler.sendEmptyMessageDelayed(4, 50L);
    return;
    reset();
  }
  
  protected void adc()
  {
    long l = System.currentTimeMillis() - this.ahO;
    boolean bool;
    if ((float)l >= this.za)
    {
      bool = true;
      this.isOver = bool;
      if (!this.isOver) {
        break label147;
      }
    }
    label147:
    for (int j = 10000;; j = (int)((float)l / this.za * 10000.0F))
    {
      String str = (int)l / 1000 + acfp.m(2131707738);
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "updateProgress percent:" + j + ", time:" + str);
      }
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b != null) {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$b.onProgress(j);
      }
      if (this.isOver) {
        stopCapture();
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void b(int paramInt, float[] paramArrayOfFloat)
  {
    int j = 0;
    while (j < paramInt)
    {
      postDelayed(new DelayRefresh(j, paramArrayOfFloat[j]), j * 50);
      j += 1;
    }
  }
  
  public void b(LWMotionEvent paramLWMotionEvent)
  {
    int j;
    if (aQb())
    {
      j = paramLWMotionEvent.getAction();
      if (((j != 3) && (j != 1)) || (this.dxL)) {
        break label117;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "onTouchHook [mHaveIPCEvent:false]  action=" + j + " isStarting:" + this.cAn);
      }
      if (this.dxH)
      {
        this.handler.removeCallbacks(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable);
        this.dE.set(false);
      }
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c != null) {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c.ePA();
      }
    }
    label117:
    do
    {
      return;
      if (((!this.dxL) || (paramLWMotionEvent.eIZ != 1)) || (!this.dxL))
      {
        this.dxL = true;
        if (QLog.isColorLevel()) {
          QLog.i("CameraCaptureLayout", 2, "onTouchHook [move-down event]  action=" + j + " isStarting:" + this.cAn);
        }
      }
      a(this.jdField_a_of_type_DovComQqImPtvBaseButton, paramLWMotionEvent);
      if ((j == 3) || (j == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraCaptureLayout", 2, "onTouchHook[ACTION_UP-CANCEL]  action=" + j + " mHaveIPCEvent:" + this.dxL);
        }
        this.dxL = false;
      }
    } while (Build.VERSION.SDK_INT < 19);
    aeX(j);
  }
  
  protected void c(LWMotionEvent paramLWMotionEvent)
  {
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.startX = paramLWMotionEvent.getRawX();
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.startY = paramLWMotionEvent.getRawY();
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.lastX = paramLWMotionEvent.getRawX();
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.lastY = paramLWMotionEvent.getRawY();
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN = false;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxP = false;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxO = false;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 0;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxQ = false;
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxR = false;
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleTouch[Adsorption] startX=" + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.startX + " startY=" + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.startY + " lastX=" + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.lastX + " lastY=" + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.lastY);
    }
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowDraw(true);
  }
  
  protected void d(LWMotionEvent paramLWMotionEvent)
  {
    float f1 = paramLWMotionEvent.getRawX();
    float f2 = paramLWMotionEvent.getRawY();
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff = (f1 - this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.lastX);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff = (f2 - this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.lastY);
    ePE();
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.dxN)
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.lastX = f1;
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.lastY = f2;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleTouch[Adsorption] xDiff=" + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.xDiff + " currentX=" + f1 + " yDiff=" + this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.yDiff + " currentY=" + f2);
    }
  }
  
  protected void ePD()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setOnTouchListener(this.onTouchListener);
    this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.setStatus(false);
    this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.setCurrentProgress(0.0F);
    Animation localAnimation = this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.getAnimation();
    if (localAnimation != null) {}
    for (boolean bool1 = localAnimation.hasEnded();; bool1 = true)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("cancelResetViewState endAnim:").append(bool1).append(", anim !=null:");
        if (localAnimation == null) {
          break label115;
        }
      }
      label115:
      for (bool1 = bool2;; bool1 = false)
      {
        QLog.i("CameraCaptureLayout", 2, bool1);
        this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.clearAnimation();
        this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.setVisibility(8);
        return;
      }
    }
  }
  
  abstract void ePE();
  
  protected void ePT()
  {
    if (this.cAn)
    {
      ePU();
      return;
    }
    if (this.dxH)
    {
      this.handler.removeCallbacks(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable);
      ePU();
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c != null) {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c.ePA();
      }
    }
    this.dE.set(false);
  }
  
  public void ePV()
  {
    if (this.cAn)
    {
      ePW();
      return;
    }
    if (this.dxH)
    {
      this.handler.removeCallbacks(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable);
      ePW();
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c != null) {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c.ePA();
      }
    }
    this.dE.set(false);
  }
  
  protected void ePX()
  {
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 3;
    int j = getResources().getColor(2131165743);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j });
    localObjectAnimator.setEvaluator(ayaj.a());
    int k = getResources().getColor(2131165744);
    Object localObject2 = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { k });
    ((ObjectAnimator)localObject2).setEvaluator(ayaj.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "rotation", new float[] { 0.0F, 180.0F });
    localObjectAnimator.addListener(new aybf(this));
    this.Gm.clear();
    this.Gm.add(localObjectAnimator);
    a(this.jdField_b_of_type_DovComQqImPtvBaseButton, 1.0F, 1.533F, 1.533F, 1.5F, (Animator)localObject1, this.Gm, 140L, 50L).start();
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130845314);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j });
    ((ObjectAnimator)localObject1).setEvaluator(ayaj.a());
    j = getResources().getColor(2131165519);
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { j });
    localObjectAnimator.setEvaluator(ayaj.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new aybg(this));
    ((AnimatorSet)localObject1).start();
    j = getResources().getColor(2131166538);
    localObject1 = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvLightWeightProgress, "deleteColor", new int[] { this.jdField_b_of_type_DovComQqImPtvLightWeightProgress.RH(), j });
    ((ObjectAnimator)localObject1).setStartDelay(90L);
    ((ObjectAnimator)localObject1).setDuration(50L);
    ((ObjectAnimator)localObject1).addListener(new aybh(this));
    ((ObjectAnimator)localObject1).start();
  }
  
  protected void ePY()
  {
    int j = getResources().getColor(2131165978);
    int k = getResources().getColor(2131165979);
    int m = getResources().getColor(2131165321);
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$a.status = 3;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.c, "backgroundColor", new int[] { -1, j });
    localObjectAnimator.setEvaluator(ayaj.a());
    Object localObject2 = ObjectAnimator.ofInt(this.c, "shadowColor", new int[] { m, k });
    ((ObjectAnimator)localObject2).setEvaluator(ayaj.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.c, "rotation", new float[] { 0.0F, 0.0F });
    localObjectAnimator.addListener(new aybi(this));
    this.Gm.clear();
    this.Gm.add(localObjectAnimator);
    a(this.c, 1.0F, 1.533F, 1.533F, 1.5F, (Animator)localObject1, this.Gm, 140L, 50L).start();
    this.c.setImageResource(2130845319);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j });
    ((ObjectAnimator)localObject1).setEvaluator(ayaj.a());
    j = getResources().getColor(2131165522);
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { j });
    localObjectAnimator.setEvaluator(ayaj.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new aybj(this));
    ((AnimatorSet)localObject1).start();
  }
  
  protected void ePZ()
  {
    int j = getResources().getColor(2131165978);
    int k = getResources().getColor(2131165979);
    int m = getResources().getColor(2131165321);
    Object localObject1 = ObjectAnimator.ofInt(this.c, "backgroundColor", new int[] { j, -1 });
    ((ObjectAnimator)localObject1).setEvaluator(ayaj.a());
    Object localObject2 = ObjectAnimator.ofInt(this.c, "shadowColor", new int[] { k, m });
    ((ObjectAnimator)localObject2).setEvaluator(ayaj.a());
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.c, "scaleX", new float[] { 1.5F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.c, "scaleY", new float[] { 1.5F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject1);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject2);
    localAnimatorSet.setDuration(170L);
    localObject1 = a(this.c, this.c.getTranslationX(), -this.Fs);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play(localAnimatorSet).with((Animator)localObject1);
    ((AnimatorSet)localObject2).addListener(new aybk(this));
    ((AnimatorSet)localObject2).start();
    m = getResources().getColor(2131165520);
    k = getResources().getColor(2131165521);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j, m });
    ((ObjectAnimator)localObject1).setEvaluator(ayaj.a());
    j = getResources().getColor(2131165522);
    localObject2 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { j, k });
    ((ObjectAnimator)localObject2).setEvaluator(ayaj.a());
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "scaleX", new float[] { 1.0F, 0.7889F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "scaleY", new float[] { 1.0F, 0.7889F });
    localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject1);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject2);
    localAnimatorSet.setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX(), this.Fs);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play(localAnimatorSet).with((Animator)localObject1);
    ((AnimatorSet)localObject2).addListener(new aybl(this));
    ((AnimatorSet)localObject2).start();
  }
  
  protected void eQa()
  {
    int j = getResources().getColor(2131165978);
    int k = getResources().getColor(2131165979);
    int m = getResources().getColor(2131165321);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.c, "backgroundColor", new int[] { j, -1 });
    localObjectAnimator.setEvaluator(ayaj.a());
    Object localObject2 = ObjectAnimator.ofInt(this.c, "shadowColor", new int[] { k, m });
    ((ObjectAnimator)localObject2).setEvaluator(ayaj.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.c, "rotation", new float[] { 0.0F, 0.0F });
    localObject2 = ObjectAnimator.ofFloat(this.c, "translationX", new float[] { this.c.getTranslationX(), 0.0F });
    localObjectAnimator.addListener(new aybc(this));
    this.Gm.clear();
    this.Gm.add(localObjectAnimator);
    this.Gm.add(localObject2);
    a(this.c, 1.5F, 1.533F, 1.533F, 1.0F, (Animator)localObject1, this.Gm, 140L, 50L).start();
    this.c.setImageResource(2130845331);
    m = getResources().getColor(2131165516);
    k = getResources().getColor(2131165523);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j, m });
    ((ObjectAnimator)localObject1).setEvaluator(ayaj.a());
    j = getResources().getColor(2131165522);
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { j, k });
    localObjectAnimator.setEvaluator(ayaj.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new aybd(this));
    ((AnimatorSet)localObject1).start();
  }
  
  abstract int getLayoutId();
  
  protected void init()
  {
    this.eJe = getResources().getColor(2131166534);
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
    this.jdField_a_of_type_DovComQqImPtvBaseButton = ((BaseButton)findViewById(2131376981));
    this.jdField_b_of_type_DovComQqImPtvBaseButton = ((BaseButton)findViewById(2131365705));
    this.c = ((BaseButton)findViewById(2131370870));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowDraw(false);
    if (AppSetting.enableTalkBack)
    {
      aqcl.Q(this.jdField_a_of_type_DovComQqImPtvBaseButton, true);
      aqcl.changeAccessibilityForView(this.jdField_a_of_type_DovComQqImPtvBaseButton, acfp.m(2131707708), Button.class.getName());
      aqcl.changeAccessibilityForView(this.jdField_b_of_type_DovComQqImPtvBaseButton, acfp.m(2131707734), Button.class.getName());
      aqcl.changeAccessibilityForView(this.c, acfp.m(2131707736), Button.class.getName());
    }
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setOnTouchListener(this.onTouchListener);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setEnabled(true);
    this.c.setShadowStrokeWidth(azbx.dip2px(3.0F));
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setShadowStrokeWidth(azbx.dip2px(3.0F));
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setShadowDraw(true);
    this.c.setShadowDraw(true);
  }
  
  protected void oj(long paramLong)
  {
    Object localObject = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, "surfaceAlpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, "alpha", new float[] { 1.0F, 0.0F });
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2);
    ((AnimatorSet)localObject).setDuration(paramLong);
    ((AnimatorSet)localObject).start();
    localObject = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvLightWeightProgress, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(paramLong);
    ((ObjectAnimator)localObject).start();
  }
  
  public void onPause()
  {
    this.isPaused = true;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureLayout", 2, "onPause isStarting=" + this.cAn);
    }
    ePV();
  }
  
  public void onResume()
  {
    this.isPaused = false;
    reset();
  }
  
  public boolean r(View paramView, MotionEvent paramMotionEvent)
  {
    this.d.ak(paramMotionEvent);
    return a(paramView, this.d);
  }
  
  public void reset() {}
  
  public void setCaptureEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setEnabled(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.mIsEnable == paramBoolean) {
      return;
    }
    this.mIsEnable = paramBoolean;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.za = paramFloat;
  }
  
  public void setUIButtonListener(c paramc)
  {
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c = paramc;
  }
  
  public void stopCapture()
  {
    long l = 0L;
    if (this.cAn) {
      l = System.currentTimeMillis() - this.ahO;
    }
    if (l < 1000L)
    {
      if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c != null) {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$c.ePy();
      }
      ePV();
      return;
    }
    ePT();
  }
  
  class DelayRefresh
    implements Runnable
  {
    int mIndex;
    float mVolume;
    
    DelayRefresh(int paramInt, float paramFloat)
    {
      this.mVolume = paramFloat;
      this.mIndex = paramInt;
    }
    
    public void run()
    {
      float f2 = this.mVolume;
      float f1 = f2;
      if (f2 > 100.0F) {
        f1 = 100.0F;
      }
      f2 = f1;
      if (f1 < 0.0F) {
        f2 = 30.0F;
      }
      if (LightWeightCaptureButtonLayout.a(LightWeightCaptureButtonLayout.this)) {
        LightWeightCaptureButtonLayout.a(LightWeightCaptureButtonLayout.this).setSeed(System.nanoTime());
      }
      for (f1 = LightWeightCaptureButtonLayout.a(LightWeightCaptureButtonLayout.this).nextFloat();; f1 = f2 / 100.0F)
      {
        f2 = 2.0F + 28.0F * f1;
        LightWeightCaptureButtonLayout.this.a.setShadowStrokeWidth(azbx.dip2px(f2));
        if (QLog.isColorLevel()) {
          QLog.d("CameraCaptureLayout", 2, "onAudioFrames mIndex=" + this.mIndex + " volume=" + this.mVolume + " volumeSafe=" + f1 + " dipSize:" + f2);
        }
        return;
      }
    }
  }
  
  class StartRunnable
    implements Runnable
  {
    private StartRunnable() {}
    
    public void run()
    {
      boolean bool = LightWeightCaptureButtonLayout.this.b.auR();
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, " StartRunnable: canCapture: " + bool + " isStarting: " + LightWeightCaptureButtonLayout.this.cAn);
      }
      if (bool)
      {
        LightWeightCaptureButtonLayout.a(LightWeightCaptureButtonLayout.this);
        return;
      }
      LightWeightCaptureButtonLayout.this.handler.postDelayed(LightWeightCaptureButtonLayout.a(LightWeightCaptureButtonLayout.this), 20L);
    }
  }
  
  public static class a
  {
    public static final int eJh = azbx.dip2px(8.0F);
    public static final int eJi = azbx.dip2px(15.0F);
    public static final int eJj = azbx.dip2px(23.0F);
    public float Fv;
    public float Fw;
    public long aCE;
    public long duration;
    public boolean dxN;
    public boolean dxO;
    boolean dxP;
    boolean dxQ;
    boolean dxR;
    boolean dxS;
    boolean dxT;
    boolean dxU;
    boolean dxV;
    int eJk = 0;
    int eJl = 0;
    public float lastX;
    public float lastY;
    public float startX;
    public float startY;
    public int status = 0;
    public float xDiff;
    public float yDiff;
  }
  
  public static abstract interface b
  {
    public abstract void coA();
    
    public abstract void coB();
    
    public abstract void ePB();
    
    public abstract void onProgress(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void ePA();
    
    public abstract void ePy();
    
    public abstract void ePz();
    
    public abstract void ecC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */