package com.tencent.mobileqq.profile.view;

import albb;
import alcn;
import algu;
import algv;
import algw;
import algx;
import algy;
import algz;
import alha;
import alhb;
import alhc;
import alhd;
import alhe;
import alho;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import aqod;
import aqod.a;
import aqod.b;
import aqod.c;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfileTagView
  extends ProfileHeaderView
  implements Animator.AnimatorListener, aqod.a
{
  private static String TAG = "ProfileTagView";
  private static PointF[] e = { new PointF(0.126562F, 0.478873F), new PointF(0.220312F, 0.242077F), new PointF(0.559375F, 0.206866F), new PointF(0.85F, 0.279049F), new PointF(0.889062F, 0.440141F), new PointF(0.815625F, 0.61F), new PointF(0.521875F, 0.75F), new PointF(0.18125F, 0.705F) };
  private static final int[] my = { 3, 1, 0, 5, 4, 2, 6 };
  SharedPreferences W;
  public TextView Xu;
  TextView Xv;
  alho jdField_a_of_type_Alho;
  aqod jdField_a_of_type_Aqod;
  public RatioLayout a;
  public ValueAnimator aI;
  ValueAnimator aJ;
  public PointF aa;
  public PointF ab;
  public BreatheEffectView b;
  ProfileNameView jdField_c_of_type_ComTencentMobileqqWidgetProfileNameView;
  ValueAnimator[] jdField_c_of_type_ArrayOfAndroidAnimationValueAnimator = new ValueAnimator[e.length];
  public boolean cwK = false;
  boolean cwL;
  public boolean cwM;
  private boolean cwN;
  public boolean cwO = true;
  ValueAnimator[] d = new ValueAnimator[e.length];
  int dtr;
  int dts;
  public int dtt;
  private final int dtu;
  Drawable fp;
  public Drawable fq;
  AvatarLayout h;
  int[] mA = new int[2];
  GestureDetector mGestureDetector;
  public boolean mIsDragging;
  public boolean mIsFullScreen;
  int[] mz = new int[2];
  public ImageView qa;
  public View[] x = new View[e.length];
  
  public ProfileTagView(BaseActivity paramBaseActivity, alcn paramalcn)
    throws ProfileTemplateException
  {
    super(paramBaseActivity, paramalcn);
    this.mActivity = paramBaseActivity;
    this.app = paramBaseActivity.app;
    this.jdField_a_of_type_Alcn = paramalcn;
    this.dtu = paramBaseActivity.getResources().getDimensionPixelSize(2131298996);
    k(paramalcn);
    e(paramalcn);
  }
  
  public void SP(int paramInt)
  {
    super.SP(paramInt);
    Object localObject = (View)this.mt.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = (ankt.dip2px(10.0F) + paramInt);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  void SQ(int paramInt)
  {
    int j = -1;
    this.dtr = paramInt;
    Object localObject = this.Xu;
    int i;
    if (2 == paramInt)
    {
      i = -1;
      ((TextView)localObject).setTextColor(i);
      localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetProfileNameView;
      if (2 != paramInt) {
        break label71;
      }
      i = -1;
      label39:
      ((ProfileNameView)localObject).setTextColor(i);
      localObject = this.Xv;
      if (2 != paramInt) {
        break label77;
      }
    }
    label71:
    label77:
    for (paramInt = j;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      return;
      i = -16777216;
      break;
      i = -16777216;
      break label39;
    }
  }
  
  public aqod.b a(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    View[] arrayOfView = this.x;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      if (((localView instanceof aqod.b)) && (localView.getVisibility() == 0))
      {
        localView.getLocationOnScreen(arrayOfInt);
        int k = arrayOfInt[0];
        int m = localView.getWidth();
        int n = arrayOfInt[1];
        int i1 = localView.getHeight();
        if ((paramFloat1 >= arrayOfInt[0]) && (paramFloat1 <= k + m) && (paramFloat2 >= arrayOfInt[1]) && (paramFloat2 <= n + i1)) {
          return (aqod.b)localView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public void a(aqod.b paramb, float paramFloat1, float paramFloat2)
  {
    paramb = (View)paramb;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.F(paramb, (int)paramFloat1 - this.mz[0], (int)paramFloat2 - this.mz[1]);
  }
  
  public void a(aqod.c paramc, aqod.b paramb, float paramFloat1, float paramFloat2)
  {
    this.mIsDragging = false;
    this.b.a(null);
    if (paramc != null)
    {
      ((VipTagView)paramb).setTag(2131375588, Boolean.valueOf(true));
      a((VipTagView)paramb);
      if ((!a((VipTagView)paramb)) && (this.jdField_a_of_type_Alcn.e.pa != 0))
      {
        int i = getResources().getDimensionPixelSize(2131298977);
        this.jdField_a_of_type_Alho.c(getHandler(), 900, i);
      }
      return;
    }
    a((VipTagView)paramb, false);
  }
  
  void a(VipTagView paramVipTagView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.2F, 1.0F, 0.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setAnimationListener(new alhb(this, paramVipTagView));
    paramVipTagView.startAnimation(localScaleAnimation);
  }
  
  public void a(VipTagView paramVipTagView, long paramLong)
  {
    Object localObject = String.format("%s-%d", new Object[] { this.jdField_a_of_type_Alcn.d.uin, Long.valueOf(paramLong) });
    if (!this.W.getBoolean((String)localObject, false))
    {
      anot.a(this.app, "CliOper", "", "", "card_mall", "0X80047EF", 0, 0, Long.toString(paramLong), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "appreciate the label");
      }
      this.W.edit().putBoolean((String)localObject, true).commit();
      localObject = (CardHandler)this.app.getBusinessHandler(2);
      if (localObject == null) {
        return;
      }
      ((CardHandler)localObject).a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.d.uin, Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "submit the network params ：srcUin = " + this.app.getCurrentAccountUin() + "destUin  = " + this.jdField_a_of_type_Alcn.d.uin + " labelId  = " + paramLong);
      }
      paramVipTagView.dFW();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "the label has appreciated");
    }
    paramVipTagView.setShakingState(true);
  }
  
  public void a(VipTagView paramVipTagView, boolean paramBoolean)
  {
    Object localObject1 = (RatioLayout.LayoutParams)paramVipTagView.getLayoutParams();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = paramVipTagView.getTag(2131375591);
    } while (localObject2 == null);
    int i = ((Integer)localObject2).intValue();
    float f1 = e[i].x;
    float f2 = e[i].y;
    float f3 = (paramVipTagView.getLeft() + paramVipTagView.getWidth() * ((RatioLayout.LayoutParams)localObject1).xS) / this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getWidth();
    float f4 = paramVipTagView.getTop();
    float f5 = paramVipTagView.getHeight();
    f4 = (((RatioLayout.LayoutParams)localObject1).xT * f5 + f4) / this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight();
    localObject1 = ObjectAnimator.ofObject(new alhc(this), new Object[] { new PointF(f3, f4), new PointF(f1, f2) });
    ((ValueAnimator)localObject1).addUpdateListener(new alhd(this, paramVipTagView));
    ((ValueAnimator)localObject1).setDuration(400L);
    ((ValueAnimator)localObject1).addListener(new alhe(this, paramBoolean, paramVipTagView));
    ((ValueAnimator)localObject1).start();
  }
  
  public boolean a(aqod.b paramb, float paramFloat1, float paramFloat2)
  {
    this.mIsDragging = true;
    if (((VipTagView)paramb).atD())
    {
      a(paramb, paramFloat1, paramFloat2);
      this.b.dFB();
      return true;
    }
    return false;
  }
  
  boolean a(VipTagView paramVipTagView)
  {
    if (paramVipTagView.getTag(2131375590) == null) {
      return false;
    }
    long l = ((Long)paramVipTagView.getTag(2131375590)).longValue();
    if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.d != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.uin)))
    {
      paramVipTagView = String.format("%s-%d", new Object[] { this.jdField_a_of_type_Alcn.d.uin, Long.valueOf(l) });
      return this.W.getBoolean(paramVipTagView, false);
    }
    return false;
  }
  
  public boolean atA()
  {
    if (this.cwK) {
      return false;
    }
    if (((this.mActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.mActivity).aWx) && (!this.cwN))
    {
      this.cwN = true;
      return false;
    }
    this.cwK = true;
    Object localObject;
    if (this.mIsFullScreen) {
      if (this.aI == null)
      {
        this.aI = ObjectAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight(), getResources().getDimensionPixelSize(2131298987) });
        localObject = this.aI;
        label103:
        if (this.mIsFullScreen) {
          break label324;
        }
      }
    }
    label324:
    for (boolean bool = true;; bool = false)
    {
      this.mIsFullScreen = bool;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).setDuration(500L);
        ((ValueAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        ((ValueAnimator)localObject).removeListener(this);
        ((ValueAnimator)localObject).removeAllUpdateListeners();
        ((ValueAnimator)localObject).addListener(this);
        ((ValueAnimator)localObject).addUpdateListener(new algz(this));
        ((ValueAnimator)localObject).start();
      }
      return true;
      this.aI.start();
      localObject = null;
      break label103;
      ((FriendProfileCardActivity)this.mActivity).bOP();
      if (this.dts == 0)
      {
        localObject = this.mActivity.findViewById(16908290);
        if (localObject == null) {
          break;
        }
        this.dts = ((View)localObject).getHeight();
        localObject = this.mActivity.findViewById(2131364045);
        if (localObject != null) {
          this.dts -= ((View)localObject).getHeight();
        }
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((FriendProfileCardActivity)this.mActivity).bON();
      }
      if (this.aJ == null)
      {
        this.aJ = ObjectAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight(), this.dts });
        localObject = this.aJ;
        break label103;
      }
      this.aJ.start();
      localObject = null;
      break label103;
    }
  }
  
  public boolean atB()
  {
    boolean bool = false;
    if (this.cwL)
    {
      this.cwL = false;
      q(this.jdField_a_of_type_Alcn);
      bool = true;
    }
    return bool;
  }
  
  public void b(alcn paramalcn, boolean paramBoolean)
  {
    super.a(paramalcn.e);
    super.f(paramalcn);
    super.j(paramalcn);
    super.i(paramalcn);
    if (this.cwK) {
      this.cwL = true;
    }
    for (;;)
    {
      super.c(paramalcn, false);
      return;
      q(paramalcn);
    }
  }
  
  public boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mIsFullScreen)
    {
      if (((this.jdField_a_of_type_Aqod == null) || (!this.jdField_a_of_type_Aqod.onTouchEvent(paramMotionEvent))) && (this.mGestureDetector != null) && (!this.mGestureDetector.onTouchEvent(paramMotionEvent))) {
        dispatchTouchEvent(paramMotionEvent);
      }
      if ((this.mActivity != null) && ((this.mActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.mActivity).aWx)) {
        return super.d(paramView, paramMotionEvent);
      }
      return true;
    }
    if (this.mGestureDetector != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getLocationInWindow(this.mA);
      if (this.mA[1] - this.mz[1] == 0) {
        return this.mGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
    return super.d(paramView, paramMotionEvent);
  }
  
  void dFL()
  {
    this.b = ((BreatheEffectView)findViewById(2131369166));
    Object localObject1 = (ImageView)findViewById(2131368497);
    this.jdField_a_of_type_Alho = new alho(5, getResources());
    ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_Alho);
    this.Xu = ((TextView)findViewById(2131379735));
    localObject1 = findViewById(2131368392);
    Object localObject2 = (RatioLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RatioLayout.LayoutParams)localObject2).x = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).y = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).xS = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).xT = 0.5F;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (RatioLayout.LayoutParams)this.Xu.getLayoutParams();
    localObject2 = e[(e.length - 1)];
    ((RatioLayout.LayoutParams)localObject1).x = (((PointF)localObject2).x + 0.07F);
    ((RatioLayout.LayoutParams)localObject1).y = ((PointF)localObject2).y;
    ((RatioLayout.LayoutParams)localObject1).xS = 0.0F;
    ((RatioLayout.LayoutParams)localObject1).xT = 0.5F;
    this.Xu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_Aqod = new aqod(this, this.b, true);
    this.mGestureDetector = new GestureDetector(getContext(), new algu(this));
  }
  
  public void dFM()
  {
    this.dtt = 0;
    View[] arrayOfView = this.x;
    int k = arrayOfView.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = arrayOfView[j];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localObject1 = (Integer)localView.getTag(2131375591);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        j += 1;
        break;
        PointF localPointF = e[localObject1.intValue()];
        this.dtt += 1;
        Object localObject2 = this.jdField_c_of_type_ArrayOfAndroidAnimationValueAnimator[i];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_c_of_type_ArrayOfAndroidAnimationValueAnimator;
          localObject1 = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          localObject2[i] = localObject1;
          ((ValueAnimator)localObject1).addUpdateListener(new algv(this, localView, localPointF));
          ((ValueAnimator)localObject1).setInterpolator(new DecelerateInterpolator());
          ((ValueAnimator)localObject1).addListener(new algw(this, localView, localPointF));
          ((ValueAnimator)localObject1).setDuration(600L);
        }
        localView.setVisibility(0);
        ((ValueAnimator)localObject1).start();
        i += 1;
      }
    }
    if (this.dtt == 0)
    {
      this.cwK = false;
      if (this.cwO)
      {
        l(this.jdField_a_of_type_Alcn);
        this.cwO = false;
      }
    }
  }
  
  public void dFN()
  {
    this.dtt = 0;
    View[] arrayOfView = this.x;
    int k = arrayOfView.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = arrayOfView[j];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        if ((localView instanceof VipTagView)) {
          ((VipTagView)localView).setShakingState(false);
        }
        localObject1 = (Integer)localView.getTag(2131375591);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        j += 1;
        break;
        PointF localPointF = e[localObject1.intValue()];
        localObject1 = (RatioLayout.LayoutParams)localView.getLayoutParams();
        if (localObject1 != null)
        {
          ((RatioLayout.LayoutParams)localObject1).x = this.aa.x;
          ((RatioLayout.LayoutParams)localObject1).y = this.aa.y;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.dtt += 1;
        Object localObject2 = this.d[i];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.d;
          localObject1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          localObject2[i] = localObject1;
          ((ValueAnimator)localObject1).addUpdateListener(new algx(this, localView, localPointF));
          ((ValueAnimator)localObject1).setInterpolator(new AccelerateInterpolator());
          ((ValueAnimator)localObject1).addListener(new algy(this, localView));
          ((ValueAnimator)localObject1).setDuration(600L);
        }
        this.Xu.setVisibility(4);
        ((ValueAnimator)localObject1).start();
        i += 1;
      }
    }
    if (this.dtt == 0)
    {
      this.cwK = false;
      ((FriendProfileCardActivity)this.mActivity).bOy();
    }
  }
  
  public void e(alcn paramalcn)
  {
    Object localObject1 = getContext();
    this.W = this.mActivity.getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    LayoutInflater.from((Context)localObject1).inflate(2131562233, this, true);
    this.h = ((AvatarLayout)findViewById(2131369165));
    this.h.c(0, this.h.findViewById(2131363324), false);
    this.mt.put("map_key_face", this.h);
    super.a(paramalcn.e);
    Object localObject2 = new albb(1, null);
    this.h.setTag(localObject2);
    this.h.setOnClickListener(paramalcn.mOnClickListener);
    if (paramalcn.e.pa == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131692201);; localObject1 = ((Context)localObject1).getString(2131692200))
    {
      this.h.setContentDescription((CharSequence)localObject1);
      this.qa = ((ImageView)findViewById(2131368987));
      this.qa.setVisibility(4);
      this.qa.setOnClickListener(paramalcn.mOnClickListener);
      this.qa.setTag(localObject2);
      this.mt.put("map_key_avatar_pendant", this.qa);
      super.c(paramalcn, true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)findViewById(2131369183));
      this.mt.put("map_key_profile_nick_name", this.jdField_c_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.j(paramalcn);
      this.Xv = ((TextView)findViewById(2131369174));
      this.mt.put("map_key_sex_age_area", this.Xv);
      super.f(paramalcn);
      localObject1 = (VoteView)findViewById(2131382077);
      localObject2 = (HeartLayout)findViewById(2131368498);
      ((HeartLayout)localObject2).setEnabled(false);
      ((VoteView)localObject1).setHeartLayout(this.app, (HeartLayout)localObject2);
      this.mt.put("map_key_like", localObject1);
      super.i(paramalcn);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout = ((RatioLayout)findViewById(2131379200));
      this.mt.put("map_key_tag_cloud", this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout);
      localObject1 = (LinearLayout)findViewById(2131369231);
      this.mt.put("map_key_tips", localObject1);
      super.e(paramalcn);
      dFL();
      q(paramalcn);
      return;
    }
  }
  
  public void k(alcn paramalcn)
    throws ProfileTemplateException
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    super.a(paramalcn, new HashMap());
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator != null)
    {
      if (paramAnimator != this.aJ) {
        break label36;
      }
      this.b.a(new alha(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setSkipMeasure(false);
      return;
      label36:
      if (Build.VERSION.SDK_INT < 11)
      {
        ((FriendProfileCardActivity)this.mActivity).bOO();
      }
      else
      {
        paramAnimator = (FrameLayout)this.mActivity.findViewById(16908290);
        if ((paramAnimator != null) && (paramAnimator.getChildCount() > 0))
        {
          paramAnimator = paramAnimator.getChildAt(0);
          if (paramAnimator != null)
          {
            this.fp = paramAnimator.getBackground();
            paramAnimator.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setSkipMeasure(true);
    paramAnimator = (FrameLayout)this.mActivity.findViewById(16908290);
    if (paramAnimator != null)
    {
      if ((paramAnimator.getBackground() == null) && (this.fq != null)) {
        paramAnimator.setBackgroundDrawable(this.fq);
      }
      if (paramAnimator.getChildCount() > 0)
      {
        paramAnimator = paramAnimator.getChildAt(0);
        if ((paramAnimator != null) && (paramAnimator.getBackground() == null) && (this.fp != null)) {
          paramAnimator.setBackgroundDrawable(this.fp);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    float f;
    if (this.aa == null)
    {
      getLocationOnScreen(this.mz);
      this.jdField_a_of_type_Aqod.Y(this.mz[0], this.mz[1]);
      paramInt3 = this.h.getWidth();
      paramInt1 = this.h.getHeight();
      localObject = new int[2];
      this.h.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = this.mz[0];
      f = (paramInt3 / 2 + (i - j)) / getWidth();
      paramInt3 = localObject[1];
      i = this.mz[1];
      this.aa = new PointF(f, (paramInt1 / 2 + (paramInt3 - i)) / getHeight());
      if (this.jdField_a_of_type_Alcn.e.bIY != 1) {
        postDelayed(new ProfileTagView.3(this), 300L);
      }
    }
    if ((this.dts > 0) && (paramInt4 - paramInt2 == this.dts) && (this.ab == null))
    {
      paramInt2 = this.h.getWidth();
      paramInt1 = this.h.getHeight();
      localObject = new int[2];
      this.h.getLocationOnScreen((int[])localObject);
      this.b.setHoverHotArea(new Rect(localObject[0], localObject[1], localObject[0] + paramInt2, localObject[1] + paramInt1));
      paramInt3 = localObject[0];
      paramInt4 = this.mz[0];
      f = (paramInt2 / 2 + (paramInt3 - paramInt4)) / getWidth();
      paramInt2 = localObject[1];
      paramInt3 = this.mz[1];
      this.ab = new PointF(f, (paramInt1 / 2 + (paramInt2 - paramInt3)) / getHeight());
      paramInt1 = this.Xv.getHeight();
      this.Xv.getLocationOnScreen((int[])localObject);
      paramInt2 = e.length;
      paramInt3 = (int)((45.0F * this.mDensity + 0.5D) / 2.0D);
      f = (paramInt1 + (localObject[1] - this.mz[1]) + paramInt3) / getHeight();
      localObject = e[(paramInt2 - 1)];
      ((PointF)localObject).set(((PointF)localObject).x, f);
      if (this.Xu != null)
      {
        localObject = (RatioLayout.LayoutParams)this.Xu.getLayoutParams();
        if (localObject != null)
        {
          ((RatioLayout.LayoutParams)localObject).y = f;
          this.Xu.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alcn != null)
    {
      super.c(this.jdField_a_of_type_Alcn, false);
      if ((this.jdField_a_of_type_Alcn.e.pa == 0) && (this.jdField_a_of_type_Alcn.d != null) && (this.dtr != (int)this.jdField_a_of_type_Alcn.d.backgroundColor)) {
        SQ((int)this.jdField_a_of_type_Alcn.d.backgroundColor);
      }
    }
    Object localObject = (View)this.mt.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = ankt.dip2px(15.0F);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((!this.cwM) && (this.jdField_a_of_type_Alcn.mOnClickListener != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setTag(new albb(29, null));
        this.jdField_a_of_type_Alcn.mOnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout);
        return true;
      }
      this.cwM = false;
    }
  }
  
  public void q(alcn paramalcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateTagCloud");
    }
    ThreadManager.post(new ProfileTagView.2(this, paramalcn), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileTagView
 * JD-Core Version:    0.7.0.1
 */