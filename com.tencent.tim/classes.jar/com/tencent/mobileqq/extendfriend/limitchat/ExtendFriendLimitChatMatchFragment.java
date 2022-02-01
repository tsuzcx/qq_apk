package com.tencent.mobileqq.extendfriend.limitchat;

import afsg;
import afsi;
import afsr;
import aftr;
import afub;
import afwh;
import afwh.a;
import afwm;
import afwn;
import afwo;
import afwp;
import afwq;
import afwr;
import afws;
import afwt;
import afwu;
import afwv;
import afwz;
import afxx;
import afys;
import afyv;
import aine;
import aizy;
import ajab;
import ajab.a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqiw;
import aqju;
import ausj;
import auss;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew.a;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ExtendFriendLimitChatMatchFragment
  extends PublicBaseFragment
  implements afwh.a, ajab.a, View.OnClickListener, HorseRaceLampVew.a
{
  public RedTouch I;
  private TextView RR;
  private TextView RS;
  public afub a;
  ajab jdField_a_of_type_Ajab = null;
  private a jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a;
  private MatchingView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView;
  private SignalBombAnimationView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView;
  private HorseRaceLampVew jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew;
  ausj af = null;
  protected aqju am;
  private AnimatorSet an;
  private Boolean av = Boolean.valueOf(false);
  private afwh b;
  public afyv b;
  private String bFP = "";
  private afsr c = new afwt(this);
  private boolean cbc;
  private boolean cbw;
  private DialogInterface.OnDismissListener g = new afwo(this);
  private Card h;
  private View.OnTouchListener j = new afwm(this);
  private RelativeLayout kf;
  private FragmentActivity mActivity;
  private ViewGroup mContainer;
  private int mFromType = 0;
  private ImageView zn;
  private ImageView zo;
  private ImageView zp;
  
  public ExtendFriendLimitChatMatchFragment()
  {
    this.jdField_a_of_type_Afub = null;
  }
  
  private void IF(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a.removeMessages(a.cUS);
    }
    int i = this.jdField_b_of_type_Afwh.getState();
    ddl();
    if (i == 2)
    {
      this.jdField_b_of_type_Afwh.apK();
      if (paramBoolean) {
        Is(this.mActivity.getString(2131701137));
      }
    }
  }
  
  private void IG(boolean paramBoolean)
  {
    anot.a(null, "dc00898", "", "", "0X800AE9C", "0X800AE9C", 0, 0, "", "", "", "");
    afsg localafsg = (afsg)this.mActivity.app.getBusinessHandler(127);
    if (localafsg != null) {
      localafsg.ajW();
    }
    bW(false, paramBoolean);
  }
  
  private void Is(String paramString)
  {
    if ((this.am == null) && (this.mActivity != null) && (this.mActivity.app != null)) {
      this.am = aqha.a(this.mActivity, 230).setMessage(paramString).setPositiveButton(this.mActivity.getString(2131701134), new afws(this)).setNegativeButton(this.mActivity.getString(2131701133), new afwr(this));
    }
    try
    {
      if ((this.am != null) && (!this.am.isShowing())) {
        this.am.show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "match fail dialog error:" + paramString);
    }
  }
  
  private void b(afub paramafub)
  {
    if (this.jdField_b_of_type_Afwh.getState() == 2)
    {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!aqiw.bW(BaseApplication.getContext()))
    {
      cf(this.mActivity.getString(2131701139), false);
      return;
    }
    this.jdField_b_of_type_Afwh.Nx(this.mFromType);
    int i = this.jdField_b_of_type_Afwh.getState();
    if (i == 0)
    {
      this.jdField_b_of_type_Afwh.a(paramafub);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a.sendEmptyMessageDelayed(a.cUS, 35000L);
      }
      c(paramafub);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void bW(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      this.av = Boolean.valueOf(paramBoolean1);
      if (!paramBoolean1) {
        break label90;
      }
      if (!paramBoolean2)
      {
        vibrate();
        QQToast.a(this.mActivity, 2, this.mActivity.getResources().getString(2131701172), 1).show();
      }
      if (akv()) {
        this.zp.setImageDrawable(null);
      }
    }
    else
    {
      return;
    }
    this.zp.setImageResource(2130846090);
    return;
    label90:
    if (!paramBoolean2) {
      QQToast.a(this.mActivity, 2, this.mActivity.getResources().getString(2131701101), 1).show();
    }
    this.zp.setImageResource(2130846087);
    ddt();
  }
  
  private void c(afub paramafub)
  {
    String str = "#" + this.mActivity.getString(2131701164);
    Object localObject = str;
    if (paramafub != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramafub.tagName)) {
        localObject = "# " + paramafub.tagName;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.Iw((String)localObject);
    }
    paramafub = (RelativeLayout)this.mContainer.findViewById(2131365360);
    localObject = (ImageView)this.mContainer.findViewById(2131371181);
    a(paramafub, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView, (View)localObject);
  }
  
  private void cf(String paramString, boolean paramBoolean)
  {
    aqju localaqju;
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      localaqju = aqha.a(this.mActivity, 230);
      if (localaqju != null)
      {
        Object localObject = this.mActivity.getString(2131701117);
        if (paramBoolean)
        {
          localObject = localaqju.getMessageTextView();
          if (localObject != null) {
            ((TextView)localObject).setGravity(17);
          }
          localaqju.setTitle(2131701188);
          localObject = this.mActivity.getString(2131701116);
        }
        localaqju.setMessage(paramString);
        localaqju.setPositiveButton((String)localObject, new afwp(this));
      }
    }
    try
    {
      localaqju.show();
      if (this.an != null)
      {
        this.an.cancel();
        this.an.end();
      }
      ddh();
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "match handleFailAndQuitDialog error:" + paramString);
      }
    }
  }
  
  private void ddg()
  {
    if ((this.I == null) && (this.zn != null)) {
      this.I = new RedTouch(getActivity(), this.zn).a(53).a();
    }
    if (this.I != null) {
      this.I.f(25);
    }
    aizy.a(this.I, this.mActivity.app);
  }
  
  private void ddh()
  {
    ((RelativeLayout)this.mContainer.findViewById(2131365360)).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.setVisibility(8);
  }
  
  private void ddl()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.dec();
  }
  
  private void ddq()
  {
    afsg localafsg = (afsg)this.mActivity.app.getBusinessHandler(127);
    if (localafsg != null) {
      localafsg.md(this.mActivity.app.getCurrentUin());
    }
  }
  
  private void ddr()
  {
    afwz.a(this.mActivity, new afwu(this), 1);
  }
  
  private void dds()
  {
    if (!afwz.aw(this.mActivity.app))
    {
      afwz.E(this.mActivity.app, true);
      afys.a(this.mActivity, new afwn(this));
    }
    afsi localafsi;
    do
    {
      return;
      if (!afwz.yQ())
      {
        ddr();
        return;
      }
      if ((this.mActivity == null) || (this.mActivity.isFinishing()) || (this.mActivity.app == null))
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "openSignalBtn mActivity finish");
        return;
      }
      bW(true, false);
      localafsi = (afsi)this.mActivity.app.getManager(264);
    } while (localafsi == null);
    localafsi.Ip(true);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a.sendEmptyMessageDelayed(a.cUT, a.cUU);
    localafsi.dbU();
    anot.a(null, "dc00898", "", "", "0X800AE9D", "0X800AE9D", 0, 0, "", "", "", "");
  }
  
  private void ddu()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "clearSignalPushWait");
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      afsi localafsi = (afsi)this.mActivity.app.getManager(264);
      if (localafsi != null) {
        localafsi.Ip(false);
      }
    }
  }
  
  private void ddv()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "checkNeedPush");
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      afwz.a(this.mActivity, this.mActivity.app, this.g);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "checkNeedPush activity finish");
  }
  
  private void gB(View paramView)
  {
    if (paramView != null)
    {
      paramView.setAlpha(1.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
    }
  }
  
  private void vibrate()
  {
    Vibrator localVibrator;
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      localVibrator = (Vibrator)this.mActivity.getSystemService("vibrator");
      if (localVibrator != null)
      {
        if (Build.VERSION.SDK_INT <= 25) {
          break label55;
        }
        localVibrator.vibrate(VibrationEffect.createOneShot(50, -1));
      }
    }
    return;
    label55:
    localVibrator.vibrate(50);
  }
  
  int DJ()
  {
    return ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  public void a(aftr paramaftr, String paramString)
  {
    String str1 = paramaftr.bFC;
    String str2 = paramaftr.tipsWording;
    long l = paramaftr.timeStamp;
    aine.a(this.mActivity, str1, paramString, Long.valueOf(l), str2, this.mFromType);
  }
  
  public void a(View paramView1, MatchingView paramMatchingView, View paramView2)
  {
    if ((paramView1 == null) || (paramMatchingView == null) || (paramView2 == null)) {
      return;
    }
    if (this.an == null)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView1, "scaleX", new float[] { 1.0F, 0.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView1, "scaleY", new float[] { 1.0F, 0.0F });
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 1.0F, 0.0F });
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramMatchingView, "alpha", new float[] { 0.0F, 1.0F });
      ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(paramView2, "scaleX", new float[] { 0.0F, 1.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "scaleY", new float[] { 0.0F, 1.0F });
      this.an = new AnimatorSet();
      this.an.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5, paramView2 });
      this.an.addListener(new afwq(this, paramMatchingView, paramView1));
    }
    this.an.start();
  }
  
  public boolean akv()
  {
    if (Build.VERSION.SDK_INT <= 20) {
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startSingalBombAnim NOT SURPORT");
    }
    do
    {
      return false;
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "startSingalBombAnim Build.VERSION.SDK_INT " + Build.VERSION.SDK_INT);
    } while ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView == null) || (!afwv.akx()));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.dee();
    this.cbw = true;
    return true;
  }
  
  public void b(int paramInt, aftr paramaftr, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a.removeMessages(a.cUS);
    }
    if ((paramInt == 0) && (paramaftr != null))
    {
      a(paramaftr, paramString1);
      ddl();
      if (paramaftr == null) {}
      for (paramaftr = "";; paramaftr = paramaftr.bFC)
      {
        anot.a(null, "dc00898", "", paramaftr, "0X80096A6", "0X80096A6", this.mFromType, 0, "", "", "", "");
        return;
      }
    }
    if (paramInt == 7)
    {
      ddl();
      paramString1 = (afsi)this.mActivity.app.getManager(264);
      paramaftr = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.uF();
        paramaftr = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramaftr = this.mActivity.getString(2131701152);
        }
      }
      cf(paramaftr, false);
      return;
    }
    if (paramInt == 2)
    {
      ddl();
      paramaftr = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramaftr = this.mActivity.getString(2131701137);
      }
      Is(paramaftr);
      return;
    }
    if (paramInt == 8)
    {
      ddl();
      paramaftr = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramaftr = this.mActivity.getString(2131701187);
      }
      cf(paramaftr, true);
      return;
    }
    ddl();
    paramaftr = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramaftr = this.mActivity.getString(2131701140);
    }
    cf(paramaftr, false);
  }
  
  public void d(afub paramafub)
  {
    if (afxx.b(this.mActivity))
    {
      QLog.d("ExtendFriendLimitChatMatchFragment", 1, "onTagClick-> campus is not verify");
      return;
    }
    if (paramafub != null)
    {
      this.jdField_a_of_type_Afub = paramafub;
      b(this.jdField_a_of_type_Afub);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "ONTAG CLICK WITH NULL INFO");
  }
  
  public void ddi()
  {
    IF(false);
  }
  
  public void ddj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.stopAnimation();
    }
  }
  
  public void ddk()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.startAnimation();
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startRuningHorse with null view");
  }
  
  public void ddm()
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendLimitChatMatchFragment.7(this));
  }
  
  public void ddn()
  {
    anot.a(this.mActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
    MatchChatMsgListFragment.ap(this.mActivity, 0);
  }
  
  public void ddo()
  {
    if (this.jdField_a_of_type_Ajab == null) {
      this.jdField_a_of_type_Ajab = new ajab(this.mActivity.getBaseContext(), this.mActivity.app, this);
    }
    for (;;)
    {
      if (this.af == null) {
        this.af = ((ausj)auss.a(this.mActivity, this.jdField_a_of_type_Ajab.getView()));
      }
      this.af.show();
      return;
      this.jdField_a_of_type_Ajab.dvJ();
    }
  }
  
  public void ddp()
  {
    if (this.af != null) {
      this.af.dismiss();
    }
  }
  
  public void ddt()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.def();
      this.cbw = false;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.setVisibility(4);
    }
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.mFromType == 1)
    {
      if (this.mActivity != null)
      {
        this.mActivity.finish();
        this.mActivity.overridePendingTransition(0, 2130772013);
      }
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onBackEvent();
      continue;
      if (afxx.b(this.mActivity))
      {
        QLog.d("ExtendFriendLimitChatMatchFragment", 1, "limit_chat_match_start_button-> campus is not verify");
      }
      else
      {
        this.jdField_a_of_type_Afub = null;
        b(null);
        int i = afwh.K(this.mActivity.app);
        int k = this.mFromType;
        anot.a(this.mActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", k + 1, i, "", "", "", "");
        continue;
        ddn();
        continue;
        anot.a(this.mActivity.app, "dc00898", "", "", "0X800A68D", "0X800A68D", 0, 0, "", "", "", "");
        IF(false);
        ddo();
        continue;
        if (!this.av.booleanValue()) {
          dds();
        } else {
          IG(false);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.mFromType = paramBundle.getInt("ExtendFriendLimitChatFromeType", 0);
    }
    this.jdField_b_of_type_Afwh = ((afwh)this.mActivity.app.getManager(292));
    this.jdField_b_of_type_Afwh.a(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a = new a(this);
    this.mActivity.app.addObserver(this.c);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContainer = ((ViewGroup)paramLayoutInflater.inflate(2131561330, null));
    paramLayoutInflater = (RelativeLayout)this.mContainer.findViewById(2131379791);
    if (this.mFromType == 1)
    {
      paramLayoutInflater.setVisibility(0);
      this.mContainer.setClickable(false);
      ((afsi)this.mActivity.app.getManager(264)).dbS();
      paramLayoutInflater = (afsg)this.mActivity.app.getBusinessHandler(127);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.bU(true, true);
      }
      afsi.a(this.mActivity, this.mActivity.app);
      paramLayoutInflater = (afsi)this.mActivity.app.getManager(264);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.bR(this.mActivity);
      }
      ((ImageView)this.mContainer.findViewById(2131370454)).setOnClickListener(this);
      paramLayoutInflater = this.mContainer.findViewById(2131372394);
      if (paramLayoutInflater != null)
      {
        if ((!ThemeUtil.isInNightMode(this.mActivity.app)) || (this.mFromType != 1)) {
          break label821;
        }
        paramLayoutInflater.setVisibility(0);
      }
    }
    for (;;)
    {
      this.RS = ((TextView)this.mContainer.findViewById(2131371179));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew = ((HorseRaceLampVew)this.mContainer.findViewById(2131368637));
      this.RR = ((TextView)this.mContainer.findViewById(2131370455));
      this.RR.setOnClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setTagClickListner(this);
      }
      this.zn = ((ImageView)this.mContainer.findViewById(2131371999));
      this.zn.setOnClickListener(this);
      this.zn.setOnTouchListener(this.j);
      this.zo = ((ImageView)this.mContainer.findViewById(2131367084));
      this.zo.setOnClickListener(this);
      this.zp = ((ImageView)this.mContainer.findViewById(2131378412));
      this.zp.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView = ((SignalBombAnimationView)this.mContainer.findViewById(2131378411));
      this.kf = ((RelativeLayout)this.mContainer.findViewById(2131368415));
      this.jdField_b_of_type_Afyv = new afyv(1);
      if (this.jdField_b_of_type_Afyv.getRootView() != null) {
        this.kf.addView(this.jdField_b_of_type_Afyv.getRootView());
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView = ((MatchingView)this.mContainer.findViewById(2131371187));
      int m = ImmersiveUtils.getStatusBarHeight(this.mActivity);
      int n = this.mActivity.getResources().getDimensionPixelSize(2131297591);
      int i1 = this.mActivity.getResources().getDimensionPixelSize(2131297574);
      int i2 = this.mActivity.getResources().getDimensionPixelSize(2131297575);
      int i3 = this.mActivity.getResources().getDimensionPixelSize(2131297570);
      int i4 = DJ();
      int k = i4 - m - n - i1 - i2 - i3;
      int i = k;
      if (k < 0) {
        i = 0;
      }
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "screentHeight " + i4 + " statusHeight " + m + " titleHeight " + n + " headPanelHeight " + i1 + " horseHeight " + i2 + " btnHeight " + i3 + "leftHeight " + i);
      float f1 = i;
      float f2 = i;
      float f3 = i;
      paramViewGroup = (RelativeLayout)this.mContainer.findViewById(2131371180);
      paramLayoutInflater = (TextView)this.mContainer.findViewById(2131370455);
      if (paramViewGroup != null)
      {
        paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
        paramBundle.setMargins(0, (int)(f1 * 0.21F), 0, 0);
        paramViewGroup.setLayoutParams(paramBundle);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null)
      {
        paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.getLayoutParams();
        paramViewGroup.setMargins(0, (int)(f2 * 0.16F), 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setLayoutParams(paramViewGroup);
      }
      if (paramLayoutInflater != null)
      {
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        paramViewGroup.setMargins(0, (int)(f3 * 0.2F), 0, 0);
        paramLayoutInflater.setLayoutParams(paramViewGroup);
      }
      ddq();
      ddm();
      ddg();
      paramLayoutInflater = this.mContainer;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater.setVisibility(8);
      break;
      label821:
      paramLayoutInflater.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    if (this.mFromType == 1) {
      ((afsi)this.mActivity.app.getManager(264)).dbT();
    }
    ddu();
    super.onDestroy();
    if (this.jdField_b_of_type_Afyv != null)
    {
      this.jdField_b_of_type_Afyv.onDestroy();
      this.jdField_b_of_type_Afyv = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.Destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a.removeMessages(a.cUS);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$a.removeMessages(a.MSG_FINISH);
    }
    if (this.af != null) {
      this.af = null;
    }
    if (this.jdField_a_of_type_Ajab != null) {
      this.jdField_a_of_type_Ajab.onDestroy();
    }
    this.mActivity.app.removeObserver(this.c);
    anot.a(this.mActivity.app, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", this.bFP, "");
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onPause");
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    AbstractGifImage.pauseAll();
    IF(false);
    ddj();
    if (this.cbw)
    {
      ddt();
      this.cbw = true;
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    AbstractGifImage.resumeAll();
    ddh();
    ddk();
    this.RR.setVisibility(0);
    this.zn.setVisibility(0);
    this.zo.setVisibility(0);
    if (this.cbw) {
      akv();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.mFromType == 1) && (!this.cbc)) {
      this.cbc = afwz.a(this.mActivity, this.mActivity.app, this.g);
    }
  }
  
  public static class a
    extends Handler
  {
    public static int MSG_FINISH = 2;
    public static int cUS = 1;
    public static int cUT = 3;
    public static int cUU = 5200;
    private WeakReference<ExtendFriendLimitChatMatchFragment> gO;
    
    public a(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment)
    {
      this.gO = new WeakReference(paramExtendFriendLimitChatMatchFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (paramMessage.what == cUS)
      {
        paramMessage = (ExtendFriendLimitChatMatchFragment)this.gO.get();
        if (paramMessage != null)
        {
          QLog.e("ExtendFriendLimitChatMatchFragment", 1, "limitchat matching time out from ui");
          ExtendFriendLimitChatMatchFragment.a(paramMessage, true);
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
              if (paramMessage.what != MSG_FINISH) {
                break;
              }
              paramMessage = (ExtendFriendLimitChatMatchFragment)this.gO.get();
            } while (paramMessage == null);
            ExtendFriendLimitChatMatchFragment.b(paramMessage);
            paramMessage = paramMessage.getActivity();
          } while (paramMessage == null);
          paramMessage.finish();
          return;
        } while (paramMessage.what != cUT);
        paramMessage = (ExtendFriendLimitChatMatchFragment)this.gO.get();
      } while (paramMessage == null);
      ExtendFriendLimitChatMatchFragment.c(paramMessage);
      ExtendFriendLimitChatMatchFragment.d(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment
 * JD-Core Version:    0.7.0.1
 */