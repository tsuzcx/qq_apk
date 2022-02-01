package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ankt;
import aqhu;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import mqq.util.WeakReference;
import wja;
import xkr;
import xks;
import xqv;
import xqw;
import xqx;
import xqy;
import xqz;

public class UnlimitedBladeWorks
  extends RelativeLayout
  implements GreatMoveCombolEffectView.a
{
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private CustomFrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$b;
  private c jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c;
  private String aUG = "chat_item_for_qqultnew";
  private CustomFrameAnimationDrawable jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  private MessageForPoke jdField_b_of_type_ComTencentMobileqqDataMessageForPoke;
  private boolean bgO;
  private boolean bif;
  private Drawable dT;
  private Bitmap ek;
  private int jD;
  private WeakReference<Context> mContext;
  private boolean mInit;
  private float mStrength;
  private ImageView tJ;
  private ImageView tK;
  private ImageView tL;
  
  public UnlimitedBladeWorks(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public UnlimitedBladeWorks(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UnlimitedBladeWorks(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131563296, this, true);
  }
  
  @TargetApi(17)
  private void Do(int paramInt)
  {
    if ((this.mContext != null) && (this.mContext.get() != null))
    {
      Activity localActivity = (Activity)this.mContext.get();
      localActivity.runOnUiThread(new UnlimitedBladeWorks.6(this, localActivity, paramInt));
    }
  }
  
  @TargetApi(17)
  private void ceo()
  {
    if ((this.mContext != null) && (this.mContext.get() != null))
    {
      Activity localActivity = (Activity)this.mContext.get();
      localActivity.runOnUiThread(new UnlimitedBladeWorks.7(this, localActivity));
    }
  }
  
  private void cep()
  {
    int[] arrayOfInt = new int[2];
    this.tK.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    xkr.a().send(10);
    if ((this.mContext != null) && (this.mContext.get() != null))
    {
      ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.mContext.get()).getWindow().getDecorView()).getChildAt(0).findViewById(2131362332)).a().a(this.jdField_b_of_type_ComTencentMobileqqDataMessageForPoke, this.bgO, this);
      if (QLog.isColorLevel()) {
        QLog.d("fangdazhao", 2, "[x :" + i + ", y : " + j + "]");
      }
    }
  }
  
  private AnimationSet getAnimationSet(int paramInt)
  {
    int i = 0;
    AnimationSet localAnimationSet = new AnimationSet(false);
    long l = 0L;
    int[] arrayOfInt = new int[8];
    int[] tmp23_21 = arrayOfInt;
    tmp23_21[0] = 80;
    int[] tmp28_23 = tmp23_21;
    tmp28_23[1] = 120;
    int[] tmp33_28 = tmp28_23;
    tmp33_28[2] = 120;
    int[] tmp38_33 = tmp33_28;
    tmp38_33[3] = 120;
    int[] tmp43_38 = tmp38_33;
    tmp43_38[4] = 120;
    int[] tmp48_43 = tmp43_38;
    tmp48_43[5] = 80;
    int[] tmp53_48 = tmp48_43;
    tmp53_48[6] = 80;
    int[] tmp59_53 = tmp53_48;
    tmp59_53[7] = 80;
    tmp59_53;
    int j = arrayOfInt.length;
    while (i < j)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, wja.dp2px(new int[] { paramInt * 5, paramInt * -12, paramInt * 15, paramInt * -15, paramInt * 12, paramInt * -8, paramInt * 6, paramInt * 0 }[i], getResources()), 0.0F, wja.dp2px(new int[] { paramInt * 1, paramInt * -3, paramInt * 2, paramInt * -2, paramInt * 1, paramInt * -1, paramInt * 1, paramInt * 0 }[i], getResources()));
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localAnimationSet.addAnimation(localTranslateAnimation);
      l += arrayOfInt[i];
      i += 1;
    }
    return localAnimationSet;
  }
  
  public CustomFrameAnimationDrawable a()
  {
    String str = PokeBigResHandler.bru + "/dazhao/dazhao2_motion/dazhao2_motion_";
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    ((BitmapFactory.Options)localObject).inMutable = true;
    try
    {
      localObject = aqhu.d(str + "01.png", (BitmapFactory.Options)localObject);
      localObject = new CustomFrameAnimationDrawable(getResources(), (Bitmap)localObject, xkr.a().b());
      ((CustomFrameAnimationDrawable)localObject).clearFrame();
      i = 0;
      for (;;)
      {
        if (i >= 23) {
          break label210;
        }
        if (i + 1 >= 10) {
          break;
        }
        ((CustomFrameAnimationDrawable)localObject).u(i, 40, str + "0" + (i + 1) + ".png");
        i += 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable;
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
        }
        localCustomFrameAnimationDrawable = null;
        continue;
        localCustomFrameAnimationDrawable.u(i, 40, str + (i + 1) + ".png");
      }
      label210:
      localCustomFrameAnimationDrawable.cdG();
      localCustomFrameAnimationDrawable.cdJ();
      return localCustomFrameAnimationDrawable;
    }
  }
  
  public c a()
  {
    c localc = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.pause();
    localc.bWv = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.getCurrentFrameIndex();
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())
    {
      localc.currentTime = this.jdField_a_of_type_AndroidAnimationValueAnimator.getCurrentPlayTime();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.tK.setImageDrawable(null);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.pause();
      localc.bWw = this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.getCurrentFrameIndex();
      return localc;
      localc.currentTime = -1L;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, float paramFloat)
  {
    this.bif = paramBoolean2;
    this.tJ = ((ImageView)findViewById(2131369357));
    this.tK = ((ImageView)findViewById(2131363259));
    this.tL = ((ImageView)findViewById(2131363576));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = b();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = a();
    this.tJ.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    this.bgO = paramBoolean1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.setMirror(paramBoolean1);
    this.tK.clearAnimation();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 1;
    localOptions.inMutable = true;
    try
    {
      this.ek = aqhu.d(PokeBigResHandler.brv, localOptions);
      if (this.ek != null) {
        this.dT = xks.c(this.ek);
      }
      this.mContext = new WeakReference(paramContext);
      setParams(this.bgO);
      if (paramBoolean2) {
        ThreadManager.postImmediately(new UnlimitedBladeWorks.1(this), null, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$a = new a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new xqv(this));
      this.mInit = true;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
        }
        this.ek = null;
      }
    }
  }
  
  public void a(MessageForPoke paramMessageForPoke, float paramFloat)
  {
    this.jdField_b_of_type_ComTencentMobileqqDataMessageForPoke = paramMessageForPoke;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c = this.jdField_b_of_type_ComTencentMobileqqDataMessageForPoke.mUnlimitedState;
    this.mStrength = paramFloat;
  }
  
  public void a(MessageForPoke paramMessageForPoke, boolean paramBoolean, float paramFloat)
  {
    if ((paramFloat == 2.0F) && (GreatMoveCombolEffectView.mIsAnimating == true))
    {
      ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.mContext.get()).getWindow().getDecorView()).getChildAt(0).findViewById(2131362332)).a().a(paramMessageForPoke, this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c = paramMessageForPoke.mUnlimitedState;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.hi = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.aPN = false;
    if (QLog.isColorLevel()) {
      QLog.d("fangdazhao", 2, "[" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWv + "," + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.currentTime + "," + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWw + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWv < 23)
    {
      this.tK.setImageResource(0);
      this.tL.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.Dc(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWv);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.tK.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new xqx(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.resume();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWv >= 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWv < 29))
    {
      this.tL.setImageDrawable(null);
      if (this.bgO)
      {
        this.tK.setImageDrawable(this.dT);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.Dc(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWv);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.currentTime != -1L) {
          break label347;
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.resume();
        return;
        this.tK.setImageBitmap(this.ek);
        break;
        label347:
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setCurrentPlayTime(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.currentTime);
      }
    }
    int i = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
    if (i > 0)
    {
      if (this.bgO) {
        this.tK.setImageDrawable(this.dT);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setCurrentPlayTime(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.currentTime);
        return;
        this.tK.setImageBitmap(this.ek);
      }
    }
    if ((i <= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWw >= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWw < 9))
    {
      this.tK.setImageResource(0);
      this.tL.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new xqy(this));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.setMirror(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.Dc(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWw);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.resume();
      return;
    }
    this.tJ.setImageDrawable(null);
    this.tK.setImageResource(0);
    this.tL.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$b != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$b.end();
      if (this.bif) {
        HapticManager.a().X(this.jD);
      }
      this.jD = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.hi = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.aPN = true;
  }
  
  public CustomFrameAnimationDrawable b()
  {
    String str = PokeBigResHandler.bru + "/dazhao/daozhao_motion/dazhao_motion_";
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    ((BitmapFactory.Options)localObject).inMutable = true;
    try
    {
      localObject = aqhu.d(str + "01.png", (BitmapFactory.Options)localObject);
      localObject = new CustomFrameAnimationDrawable(getResources(), (Bitmap)localObject, xkr.a().b());
      ((CustomFrameAnimationDrawable)localObject).clearFrame();
      i = 0;
      for (;;)
      {
        if (i >= 29) {
          break label210;
        }
        if (i + 1 >= 10) {
          break;
        }
        ((CustomFrameAnimationDrawable)localObject).u(i, 40, str + "0" + (i + 1) + ".png");
        i += 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable;
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
        }
        localCustomFrameAnimationDrawable = null;
        continue;
        localCustomFrameAnimationDrawable.u(i, 40, str + (i + 1) + ".png");
      }
      label210:
      localCustomFrameAnimationDrawable.cdG();
      localCustomFrameAnimationDrawable.cdJ();
      return localCustomFrameAnimationDrawable;
    }
  }
  
  public void cdN()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.aPN = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.hi = false;
    ceo();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$b.end();
    }
  }
  
  public void cen()
  {
    int i = ankt.SCREEN_WIDTH;
    int j = ankt.dip2px(142.0F);
    int k = (int)(ankt.SCREEN_WIDTH - ankt.dip2px(142.0F) * this.mStrength);
    float f = k * 1.0F / (i - j);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { k, -ankt.dip2px(80.0F) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new xqw(this));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$a == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$a = new a(null);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$a);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration((f * 600.0F));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setTarget(this.tK);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
  }
  
  public boolean isInit()
  {
    return this.mInit;
  }
  
  public void setEndListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$b = paramb;
  }
  
  public void setMirror(boolean paramBoolean)
  {
    if (this.bgO == paramBoolean) {
      return;
    }
    this.bgO = paramBoolean;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.tJ.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      this.tJ.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.tL.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      this.tL.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.tK.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = wja.dp2px(100.0F, getResources());
      this.tK.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.setMirror(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.setMirror(paramBoolean);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.tJ.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      this.tJ.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.tL.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      this.tL.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.tK.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = wja.dp2px(100.0F, getResources());
      this.tK.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setParams(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean == true)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.tJ.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ankt.dip2px(90.0F) * this.mStrength));
      localLayoutParams.width = ((int)(ankt.dip2px(90.0F) * this.mStrength));
      this.tJ.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.tL.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ankt.dip2px(90.0F) * this.mStrength));
      localLayoutParams.width = ((int)(ankt.dip2px(90.0F) * this.mStrength));
      this.tL.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.tK.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ankt.dip2px(34.0F) * this.mStrength));
      localLayoutParams.width = ((int)(ankt.dip2px(48.0F) * this.mStrength));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = wja.dp2px(100.0F, getResources());
      this.tK.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      cen();
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.tJ.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ankt.dip2px(90.0F) * this.mStrength));
      localLayoutParams.width = ((int)(ankt.dip2px(90.0F) * this.mStrength));
      this.tJ.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.tL.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ankt.dip2px(90.0F) * this.mStrength));
      localLayoutParams.width = ((int)(ankt.dip2px(90.0F) * this.mStrength));
      this.tL.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.tK.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ankt.dip2px(34.0F) * this.mStrength));
      localLayoutParams.width = ((int)(ankt.dip2px(48.0F) * this.mStrength));
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = wja.dp2px(100.0F, getResources());
      this.tK.setLayoutParams(localLayoutParams);
    }
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "SHOW_PLACEHOLDER Unlimited");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWv = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.bWw = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.currentTime = 0L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.hi = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$c.aPN = false;
    this.tJ.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    this.tK.setImageDrawable(null);
    this.tL.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.start();
    if (this.bif) {
      this.jD = HapticManager.a().h(this.aUG, 2);
    }
  }
  
  public class a
    implements Animator.AnimatorListener
  {
    private a() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (UnlimitedBladeWorks.a(UnlimitedBladeWorks.this).hi)
      {
        if (UnlimitedBladeWorks.a(UnlimitedBladeWorks.this) != 2.0D) {
          break label55;
        }
        UnlimitedBladeWorks.a(UnlimitedBladeWorks.this);
        UnlimitedBladeWorks.a(UnlimitedBladeWorks.this, 5);
      }
      for (;;)
      {
        UnlimitedBladeWorks.a(UnlimitedBladeWorks.this).setImageDrawable(null);
        return;
        label55:
        UnlimitedBladeWorks.b(UnlimitedBladeWorks.this).setImageDrawable(UnlimitedBladeWorks.a(UnlimitedBladeWorks.this));
        UnlimitedBladeWorks.a(UnlimitedBladeWorks.this).setMirror(UnlimitedBladeWorks.a(UnlimitedBladeWorks.this));
        UnlimitedBladeWorks.a(UnlimitedBladeWorks.this).a(new xqz(this));
        UnlimitedBladeWorks.a(UnlimitedBladeWorks.this).start();
        UnlimitedBladeWorks.a(UnlimitedBladeWorks.this, 1);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (UnlimitedBladeWorks.a(UnlimitedBladeWorks.this))
      {
        UnlimitedBladeWorks.a(UnlimitedBladeWorks.this).setImageDrawable(UnlimitedBladeWorks.a(UnlimitedBladeWorks.this));
        return;
      }
      UnlimitedBladeWorks.a(UnlimitedBladeWorks.this).setImageBitmap(UnlimitedBladeWorks.a(UnlimitedBladeWorks.this));
    }
  }
  
  public static abstract interface b
  {
    public abstract void end();
  }
  
  public static class c
  {
    public boolean aPN;
    public int bWv;
    public int bWw;
    public long currentTime;
    public boolean hi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks
 * JD-Core Version:    0.7.0.1
 */