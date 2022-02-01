package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import acfd;
import afrz;
import afsb;
import afsf;
import aiak;
import aklk;
import akwp;
import altq;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aneg;
import anot;
import aqeu;
import aqil;
import aqiw;
import aqmj;
import aqmu;
import arhz;
import ariq;
import arnt;
import asxv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqp.app.sec.ScConfigManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.SystemBarCompact;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jnm;
import mqq.app.MobileQQ;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;
import vgb;
import vgc;
import vge;
import vgf;
import vgg;
import vgh;
import vgi;
import vgj;
import vgk;
import vgl;
import vgm;
import vgn;
import vgo;
import vgp;
import vgq;
import wja;

public class LoginInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ariq
{
  public static String aNY = "last_safety_risk_dialog_time";
  private static int bIc;
  private static int bId = 1;
  private static int bIe = 2;
  public static volatile int bIh = 86400000;
  private TextView Ei;
  private TextView Ej;
  private TextView Ek;
  private TextView El;
  private TextView Em;
  private TextView En;
  private FormSimpleItem F;
  private FormSimpleItem G;
  private FormSimpleItem H;
  private FormSimpleItem I;
  private FormSimpleItem J;
  private ProgressBar L;
  private ProgressBar M;
  private Dialog jdField_U_of_type_AndroidAppDialog;
  private FormSwitchItem jdField_U_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem V;
  private FormSwitchItem W;
  private CompoundButton.OnCheckedChangeListener a = new vgh(this);
  private String aKU = "";
  private String aNU = "";
  private String aNV = "";
  private String aNW;
  private String aNX;
  private boolean aRG = true;
  private boolean aYf;
  private boolean aYg;
  private boolean aYh;
  private boolean aYi;
  private boolean aYj;
  private boolean aYk = true;
  private boolean aYl = true;
  private boolean aYm = true;
  private boolean aYn;
  private boolean aYo;
  private boolean aYp;
  private boolean aYq;
  private aklk jdField_b_of_type_Aklk = new vgb(this);
  private BounceScrollView jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FaceSecureCheck.SecureCheckResponse jdField_b_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse;
  private WtloginObserver jdField_b_of_type_MqqObserverWtloginObserver = new vgf(this);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler = new vgk(this);
  private DevlockInfo jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private oidb_0x5e1.RspBody jdField_b_of_type_TencentImOidbOidb_0x5e1$RspBody;
  private int bIb;
  private int bIf = bIc;
  private int bIg;
  private acfd e = new vge(this);
  private RelativeLayout gO;
  private RelativeLayout gP;
  private RelativeLayout gQ;
  private LinearLayout ge;
  private LinearLayout gg;
  private SystemBarCompact mCompactBackup;
  private float pb;
  private float pc;
  private ArrayList<RiskInfoItem> pp = new ArrayList();
  private RedTouch jdField_q_of_type_ComTencentMobileqqRedtouchRedTouch;
  private FormSimpleItem jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private ImageView qA;
  private ImageView qB;
  private ImageView qC;
  private ImageView qD;
  private List<SvcDevLoginInfo> qR;
  private ImageView qu;
  private ImageView qv;
  private ImageView qw;
  private ImageView qx;
  private ImageView qy;
  private ImageView qz;
  private RedTouch r;
  private View tF;
  private arhz w;
  
  private void Bf(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.G.setVisibility(8);
    this.H.setVisibility(8);
    if ((paramInt & 0x4) != 0)
    {
      this.V.setVisibility(0);
      localArrayList.add(this.V);
      paramInt = localArrayList.size();
      if (paramInt != 1) {
        break label91;
      }
      a((RelativeLayout)localArrayList.get(0), 0);
    }
    label91:
    do
    {
      return;
      this.V.setVisibility(8);
      break;
      if (paramInt == 2)
      {
        a((RelativeLayout)localArrayList.get(0), 1);
        a((RelativeLayout)localArrayList.get(1), 3);
        return;
      }
    } while (paramInt != 3);
    a((RelativeLayout)localArrayList.get(0), 1);
    a((RelativeLayout)localArrayList.get(1), 2);
    a((RelativeLayout)localArrayList.get(2), 3);
  }
  
  private void Bg(int paramInt)
  {
    this.mCompactBackup = this.mSystemBarComp;
    this.mSystemBarComp = null;
    new SystemBarCompact(this, true, paramInt).init();
  }
  
  private void I(long paramLong, String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_qs_settings", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qsec_status_expired_time" + this.app.getCurrentAccountUin(), paramLong).putString("qsec_status_tip_text" + this.app.getCurrentAccountUin(), paramString).putLong("qsec_status_update_last_time" + this.app.getCurrentAccountUin(), new Date().getTime()).commit();
    }
  }
  
  private boolean Qc()
  {
    try
    {
      SharedPreferences localSharedPreferences = getSharedPreferences(md5sum(getCurrentAccountUin()) + "_" + aNY, 0);
      int i = bIh;
      long l1 = localSharedPreferences.getLong(aNY, 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 < i) {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private void X(boolean paramBoolean, String paramString)
  {
    if (!this.aYj) {
      return;
    }
    Object localObject1 = new AnimationSet(false);
    Object localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 0.0F, 2, 1.0F);
    ((Animation)localObject2).setDuration(500L);
    Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject3).setDuration(500L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    this.Ej.startAnimation((Animation)localObject1);
    ((AnimationSet)localObject1).setAnimationListener(new vgj(this));
    this.Ei.setVisibility(0);
    this.Ei.setText(paramString);
    if (AppSetting.enableTalkBack) {
      this.Ei.setContentDescription(paramString);
    }
    paramString = new AnimationSet(false);
    localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, -1.0F, 2, 0.0F);
    ((Animation)localObject1).setDuration(500L);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject2).setDuration(500L);
    paramString.addAnimation((Animation)localObject1);
    paramString.addAnimation((Animation)localObject2);
    this.Ei.startAnimation(paramString);
    localObject1 = this.Ei;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      ((TextView)localObject1).setClickable(bool);
      if (!paramBoolean)
      {
        this.qu.setVisibility(0);
        this.qu.startAnimation(paramString);
      }
      paramString = this.qu;
      if (paramBoolean) {
        break label551;
      }
      bool = true;
      label252:
      paramString.setClickable(bool);
      this.qy.setImageResource(2130847885);
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      this.qz.startAnimation(paramString);
      paramString.setAnimationListener(new vgl(this));
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((Animation)localObject2).setDuration(500L);
      localObject3 = new RotateAnimation(90.0F, -5.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject3).setDuration(500L);
      RotateAnimation localRotateAnimation = new RotateAnimation(-5.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L / 10L);
      localRotateAnimation.setStartOffset(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      paramString.addAnimation((Animation)localObject3);
      paramString.addAnimation(localRotateAnimation);
      if (!paramBoolean) {
        break label556;
      }
      this.qA.setVisibility(0);
      this.qA.startAnimation(paramString);
    }
    for (;;)
    {
      setBackground(paramBoolean, true);
      this.aYi = false;
      this.aYj = false;
      return;
      bool = false;
      break;
      label551:
      bool = false;
      break label252;
      label556:
      this.qB.setVisibility(0);
      this.qB.startAnimation(paramString);
    }
  }
  
  private void Y(boolean paramBoolean, String paramString)
  {
    if (!this.aYi) {
      return;
    }
    this.aYj = true;
    Object localObject = new TranslateAnimation(0, 0.0F, 0, 0.0F, 2, -0.25F, 2, 0.9F);
    ((Animation)localObject).setDuration(1500L);
    ((Animation)localObject).setRepeatMode(1);
    this.qw.startAnimation((Animation)localObject);
    ((Animation)localObject).setAnimationListener(new vgm(this));
    localObject = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 1620.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1500L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1500L);
    ((AnimationSet)localObject).addAnimation(localRotateAnimation);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    this.qx.startAnimation((Animation)localObject);
    ((AnimationSet)localObject).setAnimationListener(new vgn(this, paramBoolean, paramString));
  }
  
  private void a(RelativeLayout paramRelativeLayout, int paramInt)
  {
    if ((paramRelativeLayout instanceof FormSimpleItem)) {
      ((FormSimpleItem)paramRelativeLayout).setBgType(paramInt);
    }
    while (!(paramRelativeLayout instanceof FormSwitchItem)) {
      return;
    }
    ((FormSwitchItem)paramRelativeLayout).setBgType(paramInt);
  }
  
  private void am(int paramInt)
  {
    this.jdField_b_of_type_MqqOsMqqHandler.post(new LoginInfoActivity.8(this, paramInt));
  }
  
  private void b(DevlockInfo paramDevlockInfo)
  {
    int j = 1;
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      afsf.a().cR(paramDevlockInfo.MbGuideInfo);
    }
    this.gP.setClickable(true);
    this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
    this.L.setVisibility(4);
    this.Em.setVisibility(0);
    this.qv.setVisibility(0);
    int i;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      TextView localTextView;
      Object localObject;
      if (i != 0)
      {
        afsf.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
        localTextView = this.Em;
        if (this.aRG)
        {
          localObject = getString(2131693153);
          label127:
          localTextView.setText((CharSequence)localObject);
          localObject = this.qv;
          if (!this.aRG) {
            break label256;
          }
          i = 2130845991;
          label151:
          ((ImageView)localObject).setImageResource(i);
          if (paramDevlockInfo == null) {
            break label424;
          }
          if (TextUtils.isEmpty(paramDevlockInfo.Mobile)) {
            break label357;
          }
          i = j;
        }
      }
      for (;;)
      {
        label173:
        if (i != 0) {
          if (afrz.a().Dx() == afrz.cTE)
          {
            this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131693224));
            label203:
            anot.a(this.app, "dc00898", "", "", "0X800AC9D", "0X800AC9D", 0, 0, "1", "", "", "");
          }
        }
        for (;;)
        {
          bQX();
          return;
          i = 0;
          break;
          localObject = getString(2131693163);
          break label127;
          label256:
          i = 2130845990;
          break label151;
          afsf.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
          localTextView = this.Em;
          if (this.aRG)
          {
            localObject = getString(2131693161);
            label305:
            localTextView.setText((CharSequence)localObject);
            localObject = this.qv;
            if (!this.aRG) {
              break label350;
            }
          }
          label350:
          for (i = 2130845988;; i = 2130845989)
          {
            ((ImageView)localObject).setImageResource(i);
            break;
            localObject = getString(2131693168);
            break label305;
          }
          label357:
          i = 0;
          break label173;
          this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramDevlockInfo.Mobile);
          break label203;
          this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131693223));
          anot.a(this.app, "dc00898", "", "", "0X800AC9D", "0X800AC9D", 0, 0, "2", "", "", "");
        }
        label424:
        i = 0;
      }
      i = 0;
    }
  }
  
  private void bQX()
  {
    if (this.jdField_q_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      altq localaltq = (altq)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("100190.100199.100199001");
      this.jdField_q_of_type_ComTencentMobileqqRedtouchRedTouch.e(localAppInfo);
      localaltq.i(localAppInfo);
    }
  }
  
  private void bQY()
  {
    if (this.jdField_q_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      altq localaltq = (altq)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("100190.100199.100199002");
      this.r.e(localAppInfo);
      localaltq.i(localAppInfo);
    }
  }
  
  private void bQZ()
  {
    Object localObject = (altq)this.app.getManager(36);
    ((altq)localObject).OS("100190.100199");
    ((altq)localObject).OS("100190.100199.100199001");
    localObject = ((altq)localObject).getAppInfoByPath("100190.100199.100199001");
    this.jdField_q_of_type_ComTencentMobileqqRedtouchRedTouch.e((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void bRa()
  {
    Object localObject = (altq)this.app.getManager(36);
    ((altq)localObject).OS("100190.100199");
    ((altq)localObject).OS("100190.100199.100199002");
    localObject = ((altq)localObject).getAppInfoByPath("100190.100199.100199002");
    this.r.e((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void bRb()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
    Object localObject1 = new int[2];
    this.Em.getLocationOnScreen((int[])localObject1);
    int i = localObject1[1];
    int j = this.Em.getHeight();
    localObject1 = new TextView(this);
    ((TextView)localObject1).setBackgroundResource(2130845982);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setClickable(false);
    ((TextView)localObject1).setText(getString(2131693157));
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(12.0F);
    int k = wja.dp2px(6.0F, getResources());
    int m = wja.dp2px(6.0F, getResources());
    ((TextView)localObject1).setPadding(k, wja.dp2px(6.0F, getResources()), m, wja.dp2px(12.0F, getResources()));
    Object localObject2 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject2).gravity = 5;
    ((FrameLayout.LayoutParams)localObject2).topMargin = (i - j - wja.dp2px(19.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(20.0F, getResources());
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout(this);
    ((FrameLayout)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)localObject2).addView((View)localObject1);
    ((FrameLayout)localObject2).setId(1);
    localFrameLayout.addView((View)localObject2);
    ((TextView)localObject1).setOnClickListener(new vgo(this, (FrameLayout)localObject2));
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20200313, 3000L);
  }
  
  private void bRc()
  {
    this.M.setVisibility(0);
    aneg.a(this.app, getCurrentAccountUin(), new vgp(this));
    aneg.a(this.app, getCurrentAccountUin(), new vgq(this));
  }
  
  private void bRd()
  {
    try
    {
      SharedPreferences.Editor localEditor = getSharedPreferences(md5sum(getCurrentAccountUin()) + "_" + aNY, 0).edit();
      localEditor.putLong(aNY, System.currentTimeMillis());
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bRg()
  {
    this.gP.setClickable(true);
    this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
    this.Ek.setTextColor(getResources().getColorStateList(2131167309));
    this.L.setVisibility(4);
  }
  
  private void bRh()
  {
    Intent localIntent = new Intent(this, AuthDevActivity.class);
    localIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    localIntent.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
    localIntent.putExtra("auth_dev_gray_switch", this.aRG);
    startActivityForResult(localIntent, 0);
  }
  
  private void bRi()
  {
    this.bIb = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.bIb)
    {
    default: 
      return;
    case 2: 
      this.F.setRightText(getResources().getString(2131694293));
      return;
    case 1: 
      this.F.setRightText(getResources().getString(2131694284));
      return;
    }
    this.F.setRightText(getResources().getString(2131694292));
  }
  
  private void bRj()
  {
    ThreadManager.postImmediately(new CheckPIMStatus(this, this.H), null, true);
  }
  
  private void bRl()
  {
    if (this.aYi) {
      return;
    }
    this.aYi = true;
    this.aYj = false;
    this.Ej.setVisibility(0);
    this.Ei.setVisibility(4);
    this.qu.setVisibility(4);
    setBackground(this.aYk, false);
    this.qz.setVisibility(0);
    this.qA.setVisibility(4);
    this.qB.setVisibility(4);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20170210, 300L);
    Object localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(333L);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    this.qx.startAnimation((Animation)localObject);
    localObject = new TranslateAnimation(0, 0.0F, 0, 0.0F, 2, -0.25F, 2, 0.9F);
    ((Animation)localObject).setDuration(1000L);
    ((Animation)localObject).setRepeatMode(1);
    ((Animation)localObject).setRepeatCount(-1);
    this.qw.startAnimation((Animation)localObject);
  }
  
  private void bRm()
  {
    if (!this.aYn) {
      if (this.aYl)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(-15550475);
        this.aYn = true;
      }
    }
    while (this.aYm == this.aYl) {
      for (;;)
      {
        return;
        this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(-31676);
      }
    }
    if (this.aYl) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(-15550475);
    }
    for (;;)
    {
      this.aYn = true;
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(-31676);
    }
  }
  
  private void bRn()
  {
    this.J = ((FormSimpleItem)findViewById(2131374962));
    this.J.setVisibility(0);
    this.aNX = "https://aq.qq.com";
    this.J.setOnClickListener(this);
  }
  
  private void bRo()
  {
    this.I = ((FormSimpleItem)findViewById(2131361935));
    if (aqmj.b(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_entrance", false))
    {
      this.I.setVisibility(0);
      String str = aqmj.d(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_url", "");
      if (TextUtils.isEmpty(str)) {}
      for (this.aNW = "https://ti.qq.com/qqcancel/index.html";; this.aNW = str)
      {
        this.I.setOnClickListener(this);
        return;
      }
    }
    this.I.setVisibility(8);
  }
  
  private void bwV()
  {
    this.jdField_b_of_type_MqqOsMqqHandler.post(new LoginInfoActivity.9(this));
  }
  
  private void co(String paramString, int paramInt)
  {
    anot.a(null, "dc00899", "Safe_SecCenter", "", "ModifyPwd", paramString, paramInt, 0, "", "", "", "");
  }
  
  private void d(DevlockInfo paramDevlockInfo)
  {
    int i = 1;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup != 1) {
        break label34;
      }
    }
    for (;;)
    {
      if ((i == 0) && (Qc()))
      {
        bRd();
        bRe();
      }
      return;
      label34:
      i = 0;
    }
  }
  
  private void eN(View paramView)
  {
    paramView.setVisibility(8);
    aqmj.m(this, getCurrentAccountUin(), true);
  }
  
  private void fS(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.ge.setVisibility(8);
    }
    int j;
    int i;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.ge.removeAllViews();
      this.ge.setVisibility(0);
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        i += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2131559511, this.ge, false);
    Object localObject1 = (RelativeLayout)localView.findViewById(2131369468);
    label119:
    Object localObject2;
    TextView localTextView1;
    Button localButton;
    TextView localTextView2;
    ImageView localImageView;
    if (j == 1)
    {
      ((RelativeLayout)localObject1).setBackgroundResource(2130839682);
      getResources().getString(2131696147);
      localObject2 = getResources().getString(2131696149);
      localTextView1 = (TextView)localView.findViewById(2131370084);
      localButton = (Button)localView.findViewById(2131370086);
      if (AppSetting.enableTalkBack)
      {
        localTextView1.setContentDescription(getString(2131696149));
        localButton.setContentDescription(getString(2131696147));
      }
      localTextView2 = (TextView)localView.findViewById(2131372190);
      localObject1 = (TextView)localView.findViewById(2131369154);
      localImageView = (ImageView)localView.findViewById(2131368698);
      if (i != 0) {
        break label470;
      }
      localTextView1.setText((CharSequence)localObject2);
      localTextView1.setClickable(false);
      localButton.setVisibility(8);
      localTextView1.setVisibility(0);
      localImageView.setImageResource(2130841409);
      label275:
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label558;
      }
      localTextView2.setText(2131696152);
    }
    for (;;)
    {
      localObject2 = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject2).append(aqmu.getFormatTime(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject2).length() > 0) {
        ((TextView)localObject1).setText(((StringBuffer)localObject2).toString());
      }
      this.ge.addView(localView);
      break;
      if (i == 0)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839701);
        break label119;
      }
      if (i == j - 1)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839689);
        break label119;
      }
      ((RelativeLayout)localObject1).setBackgroundResource(2130839695);
      break label119;
      label470:
      if (localSvcDevLoginInfo.iProductType == 1L)
      {
        localTextView1.setVisibility(8);
        localButton.setVisibility(8);
        localImageView.setImageResource(2130841407);
        break label275;
      }
      localTextView1.setVisibility(8);
      localButton.setVisibility(0);
      localButton.setTag(localSvcDevLoginInfo);
      localButton.setClickable(true);
      localImageView.setImageResource(2130841408);
      localButton.setOnClickListener(new vgc(this, localButton, i));
      break label275;
      label558:
      localTextView2.setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private String hg(String paramString)
  {
    arnt localarnt = (arnt)ScConfigManager.a().a("SecCenterConfig", false);
    if (localarnt != null) {
      return localarnt.getValue("ModifyPwdUrls", paramString);
    }
    return null;
  }
  
  private void logout()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = getString(2131700561);
    String str = getString(2131700562);
    Intent localIntent = new Intent();
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.putExtra("is_from_account_release", true);
    localIntent.putExtra("release_account_uin", this.app.getCurrentAccountUin());
    localIntent.putExtra("release_success_text", (String)localObject);
    localIntent.putExtra("release_bold_text", str);
    ThemeUiPlugin.destroy(this.app);
    ChatBackgroundManager.destroy();
    localObject = this.app.getApp().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", 0);
    ((SharedPreferences.Editor)localObject).commit();
    this.app.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i = aqeu.J(this, this.app.getCurrentAccountUin());
    aqeu.z(this, this.app.getCurrentAccountUin(), i + 1);
    startActivity(localIntent);
    if (QQPlayerService.isPlaying())
    {
      localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      sendBroadcast(localIntent);
    }
    long l2 = System.currentTimeMillis();
    QLog.d("ReleaseAccount", 2, "LoginInfoActivity logout, costTime = " + (l2 - l1));
  }
  
  public static String md5sum(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      while (i < j)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[i] & 0xFF) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void setBackground(boolean paramBoolean1, boolean paramBoolean2)
  {
    setTitleTextColor(-1);
    if (!paramBoolean1)
    {
      Bg(-31676);
      if (!paramBoolean2)
      {
        this.qy.setImageResource(2130847887);
        if (!paramBoolean1) {
          break label109;
        }
      }
    }
    label109:
    for (int i = 2130847894;; i = 2130847884)
    {
      this.aYm = this.aYl;
      this.aYl = paramBoolean1;
      this.gg.setBackgroundResource(i);
      getTitleBarView().setBackgroundResource(i);
      this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(i);
      return;
      this.qy.setImageResource(2130847885);
      break;
      Bg(-15550475);
      this.qy.setImageResource(2130847886);
      break;
    }
  }
  
  private void setTitleTextColor(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(2130851122);
      this.leftView.setBackgroundDrawable(localDrawable);
    }
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setTextColor(paramInt);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(paramInt);
    }
    if (this.rightViewText != null) {
      this.rightViewText.setTextColor(paramInt);
    }
    if (this.rightHighLView != null) {
      this.rightHighLView.setTextColor(paramInt);
    }
  }
  
  private void zJ(int paramInt)
  {
    if ((this.jdField_b_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (this.jdField_b_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.jdField_b_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      TextView localTextView = this.En;
      if (paramInt == 1) {}
      for (String str = getString(2131693360);; str = getString(2131693367))
      {
        localTextView.setText(str);
        return;
      }
    }
    QLog.e("LoginInfoActivity.AccDevSec", 1, "refreshUserFaceState mFAceStateRsp is null or rpt_msg_uin_data is empty");
  }
  
  public void P(View paramView, int paramInt) {}
  
  public void bMU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    this.gP.setClickable(false);
    this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    this.L.setVisibility(0);
    this.Em.setVisibility(4);
    this.qv.setVisibility(4);
    String str = this.app.getCurrentAccountUin();
    int i = afsf.a().a(this.app, str, this.jdField_b_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      bRg();
    }
  }
  
  void bRe()
  {
    try
    {
      bRf();
      ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
      localReportDialog.setContentView(2131559127);
      TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365867);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131693249));
      }
      localTextView1 = (TextView)localReportDialog.findViewById(2131365863);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131693246));
      }
      localTextView1 = (TextView)localReportDialog.findViewById(2131365852);
      if (localTextView1 != null) {
        localTextView1.setText(2131693247);
      }
      TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365858);
      if (localTextView2 != null) {
        localTextView2.setText(2131693248);
      }
      localReportDialog.setOnDismissListener(new vgg(this));
      if (localTextView1 != null) {
        localTextView1.setOnClickListener(this);
      }
      if (localTextView2 != null) {
        localTextView2.setOnClickListener(this);
      }
      this.jdField_U_of_type_AndroidAppDialog = localReportDialog;
      this.jdField_U_of_type_AndroidAppDialog.show();
      anot.a(null, "dc00898", "", "", "0X800A5CF", "0X800A5CF", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void bRf()
  {
    if ((this.jdField_U_of_type_AndroidAppDialog == null) || (this.jdField_U_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_U_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_U_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void bRk()
  {
    if ((this.aYi) || (this.aYj)) {
      return;
    }
    bRl();
    this.pp = null;
    this.pp = new ArrayList();
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(asxv.getAppPackageName());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.getAppId());
    jnm.a(this.app, new vgi(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  public void d(View paramView, float paramFloat1, float paramFloat2)
  {
    if (this.aYg)
    {
      this.aYg = false;
      if ((paramFloat2 - this.pc > 600.0F) && (this.aYh)) {
        bRk();
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    boolean bool1;
    if (paramInt1 == 0) {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
      {
        localObject = paramIntent.getExtras();
        if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          bool1 = true;
          bool1 = ((Bundle)localObject).getBoolean("auth_dev_open", bool1);
          String str = ((Bundle)localObject).getString("phone_num");
          if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1) {}
          boolean bool2 = ((Bundle)localObject).getBoolean("allow_set");
          if (!bool1) {
            break label190;
          }
          this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
          label114:
          if (!TextUtils.isEmpty(str)) {
            this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
          }
          if (!bool2) {
            break label201;
          }
          this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;
          label144:
          b(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          bRk();
        }
      }
      else if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("faceStateKey");
        if (!TextUtils.isEmpty(paramIntent)) {
          zJ(Integer.parseInt(paramIntent));
        }
      }
    }
    label190:
    label201:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            bool1 = false;
            break;
            this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
            break label114;
            this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0;
            break label144;
            if (paramInt1 == 1)
            {
              bRi();
              return;
            }
            if (paramInt1 == 2)
            {
              bRj();
              return;
            }
            if (paramInt1 == 3)
            {
              bRk();
              return;
            }
            if (paramInt1 == 4)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LoginInfoActivity.AccDevSec", 2, String.format("doOnActivityResult, resultCode: %s", new Object[] { Integer.valueOf(paramInt2) }));
              }
              if (paramInt2 == -1)
              {
                this.I.postDelayed(new LoginInfoActivity.16(this), 50L);
                anot.c(this.app, "dc00898", "", "", "0X800989B", "0X800989B", 0, 0, "", "", "", "");
                return;
              }
              anot.c(this.app, "dc00898", "", "", "0X800989A", "0X800989A", 0, 0, "", "", "", "");
              return;
            }
            if ((paramInt1 == 11) || (paramInt1 == 21))
            {
              QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, resultCode is ", Integer.valueOf(paramInt2) });
              if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
              {
                zJ(1);
                return;
              }
              if (paramIntent == null) {}
              for (bool1 = true;; bool1 = false)
              {
                QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, data == null ? ", Boolean.valueOf(bool1) });
                if (paramIntent == null) {
                  break;
                }
                QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, KEY_FACE_SCAN_RESULT is ", Boolean.valueOf(paramIntent.getBooleanExtra("key_face_scan_result", false)) });
                return;
              }
            }
            if (paramInt1 != 12) {
              break label531;
            }
          } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("key_face_scan_result", false)));
          zJ(0);
          return;
        } while ((paramInt1 != 1003) || (paramIntent == null));
        paramIntent = paramIntent.getExtras();
      } while (paramIntent == null);
      paramInt1 = paramIntent.getInt("resultState", 1);
      if (paramInt1 == 2) {
        afrz.a().Nd(afrz.cTF);
      }
      for (;;)
      {
        if (paramInt1 == 1) {
          break label720;
        }
        localObject = paramIntent.getString("resultMobileMask");
        if (paramInt1 != 2) {
          break label700;
        }
        this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
        bool1 = paramIntent.getBoolean("resultSetMobile");
        QLog.d("LoginInfoActivity.AccDevSec", 1, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + (String)localObject + " openSuccess=" + bool1);
        if (!bool1) {
          break;
        }
        afsf.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
        return;
        if (paramInt1 == 3)
        {
          afrz.a().Nd(afrz.cTE);
          afrz.a().je(0L);
        }
      }
    } while (paramInt1 != 3);
    label531:
    label700:
    this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131693224));
    return;
    label720:
    QLog.e("LoginInfoActivity.AccDevSec", 1, "guardPhoneState: error");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559506);
    setTitle(2131701610);
    setTitleTextColor(-1);
    paramBundle = aqmj.aa(this, getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramBundle)) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      if (paramBundle.optInt("securityType", 0) != 0) {
        break label1340;
      }
      bool2 = true;
    }
    catch (Exception paramBundle)
    {
      try
      {
        for (;;)
        {
          boolean bool3;
          boolean bool1;
          this.aKU = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
          if (!this.aRG) {
            break;
          }
          this.Ek.setText(getString(2131693155));
          this.jdField_U_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.ge.setVisibility(8);
          this.El.setVisibility(8);
          findViewById(2131370883).setVisibility(0);
          if (this.aYq)
          {
            anot.a(null, "dc00898", "", "", "0X800AC59", "0X800AC59", 0, 0, "", "", "", "");
            this.Ek.post(new LoginInfoActivity.4(this));
          }
          anot.a(null, "dc00898", "", "", "0X800AC50", "0X800AC50", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "packName = " + this.aKU);
          }
          fS(null);
          if (QLog.isColorLevel()) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "onCreate begin to getLoginDevList");
          }
          if (!aqiw.isNetSupport(this)) {
            break label1429;
          }
          if (!this.aRG)
          {
            bool2 = afsf.a().a(this.app, this.aKU, 0L);
            if (!bool2) {
              QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "onCreate getLoginDevList failed ret=", Boolean.valueOf(bool2) });
            }
          }
          bMU();
          bRc();
          bRi();
          bRj();
          bRk();
          bRo();
          bRn();
          this.app.registObserver(this.jdField_b_of_type_Aklk);
          return true;
          boolean bool2 = false;
          continue;
          bool2 = false;
          continue;
          int i = 0;
          continue;
          paramBundle = paramBundle;
          QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "parse dev gray switch error : ", paramBundle.getMessage() });
        }
        this.jdField_q_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.gP).c(27).a();
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          addObserver(this.e);
          continue;
          QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
        }
      }
    }
    this.aRG = bool2;
    if (paramBundle.optInt("showGroy", 0) == 1)
    {
      bool2 = true;
      this.aYq = bool2;
      bool2 = aqmj.at(this, getCurrentAccountUin());
      bool3 = this.aYq;
      if (bool2) {
        break label1350;
      }
      bool1 = true;
      this.aYq = (bool1 & bool3);
      QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "mIsGrayAccount : ", Boolean.valueOf(this.aRG), " showGory : ", Boolean.valueOf(this.aYq) });
      this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131377355));
      this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setScrollListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setPadding(0, 0, 0, 0);
      this.ge = ((LinearLayout)findViewById(2131372069));
      this.gg = ((LinearLayout)findViewById(2131377351));
      paramBundle = (RelativeLayout)findViewById(2131377344);
      this.qz = ((ImageView)findViewById(2131377353));
      this.qA = ((ImageView)findViewById(2131377346));
      this.qB = ((ImageView)findViewById(2131377348));
      this.qy = ((ImageView)findViewById(2131377345));
      this.qC = ((ImageView)findViewById(2131377358));
      this.qD = ((ImageView)findViewById(2131377352));
      this.qx = ((ImageView)findViewById(2131377359));
      this.qw = ((ImageView)findViewById(2131377347));
      this.gO = ((RelativeLayout)findViewById(2131377357));
      this.Ei = ((TextView)findViewById(2131377356));
      this.Ej = ((TextView)findViewById(2131377354));
      this.qu = ((ImageView)findViewById(2131377342));
      if (AppSetting.enableTalkBack) {
        this.qu.setContentDescription(getString(2131717240));
      }
      this.Ei.setClickable(false);
      this.Ei.setOnClickListener(this);
      this.qu.setClickable(false);
      this.qu.setOnClickListener(this);
      this.gP = ((RelativeLayout)findViewById(2131370882));
      if (!this.aRG) {
        break label1383;
      }
      this.gP.post(new LoginInfoActivity.3(this));
      this.El = ((TextView)findViewById(2131372070));
      this.gP.setOnClickListener(this);
      this.El.setOnClickListener(this);
      this.Ek = ((TextView)findViewById(2131365799));
      this.gQ = ((RelativeLayout)findViewById(2131366651));
      this.En = ((TextView)findViewById(2131380689));
      this.M = ((ProgressBar)findViewById(2131366671));
      this.gQ.setOnClickListener(this);
      this.F = ((FormSimpleItem)findViewById(2131367964));
      this.F.setOnClickListener(this);
      this.jdField_U_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363589));
      if (AppSetting.enableTalkBack) {
        this.jdField_U_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694804));
      }
      this.tF = findViewById(2131381297);
      this.tF.setOnClickListener(this);
      this.r = new RedTouch(this, this.tF).c(27).a();
      this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131377906));
      this.jdField_q_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.G = ((FormSimpleItem)findViewById(2131373289));
      this.G.setOnClickListener(this);
      this.H = ((FormSimpleItem)findViewById(2131375068));
      this.H.setOnClickListener(this);
      if (AppSetting.enableTalkBack) {
        this.H.setContentDescription(getString(2131719380));
      }
      this.V = ((FormSwitchItem)findViewById(2131377912));
      if (AppSetting.enableTalkBack) {
        this.V.setContentDescription(getString(2131719401));
      }
      this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
      bool2 = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
      this.jdField_U_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_U_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.a);
      bool2 = SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
      this.V.setChecked(bool2);
      this.V.setOnCheckedChangeListener(this.a);
      if (!afsf.a().ajU()) {
        this.gP.setVisibility(8);
      }
      this.El.setMovementMethod(LinkMovementMethod.getInstance());
      paramBundle = new SpannableString(getResources().getString(2131696150));
      this.Em = ((TextView)findViewById(2131365797));
      this.L = ((ProgressBar)findViewById(2131373700));
      this.qv = ((ImageView)findViewById(2131365798));
      i = paramBundle.length();
      paramBundle.setSpan(new a(null), 0, i, 33);
      paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131167316)), 0, i, 33);
      this.El.setText(paramBundle);
    }
  }
  
  public void doOnDestroy()
  {
    this.aYi = false;
    this.aYj = false;
    if (this.mCompactBackup != null) {
      this.mSystemBarComp = this.mCompactBackup;
    }
    super.doOnDestroy();
    bwV();
    removeObserver(this.e);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    setTitleTextColor(-1);
    bMU();
    bRi();
    bRj();
    bQX();
    bQY();
    this.aYo = false;
    this.aYp = false;
    this.gQ.setClickable(true);
  }
  
  public void e(View paramView, float paramFloat1, float paramFloat2)
  {
    this.aYg = true;
    this.pb = paramFloat1;
    this.pc = paramFloat2;
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent(this, QQSettingSettingActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 > 0)
    {
      this.aYh = false;
      this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(2130838900);
      this.aYn = false;
      return;
    }
    this.aYh = true;
    bRm();
  }
  
  public boolean onBackEvent()
  {
    boolean bool2 = true;
    Intent localIntent;
    boolean bool1;
    if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
    {
      localIntent = new Intent();
      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup != 1) {
        break label71;
      }
      bool1 = true;
      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
        break label76;
      }
    }
    for (;;)
    {
      localIntent.putExtra("auth_dev_open", bool1);
      localIntent.putExtra("allow_set", bool2);
      setResult(0, localIntent);
      finish();
      return false;
      label71:
      bool1 = false;
      break;
      label76:
      bool2 = false;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject3;
    Object localObject2;
    label807:
    Object localObject4;
    label898:
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131370882: 
    case 2131365858: 
    case 2131366651: 
    case 2131365852: 
    case 2131373289: 
    case 2131372070: 
    case 2131367964: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.aRG) {
          anot.a(null, "dc00898", "", "", "0X800AC51", "0X800AC51", 0, 0, "", "", "", "");
        }
        bQZ();
        anot.a(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
        if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (!aqiw.isNetSupport(this))
          {
            QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
          }
          else
          {
            anot.a(null, "dc00898", "", "", "0X800ACBF", "0X800ACBF", 0, 0, "", "", "", "");
            QQToast.a(this, getString(2131693152), 0).show();
            bMU();
          }
        }
        else
        {
          Object localObject1;
          if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
          {
            this.app.sendWirelessMeibaoReq(1);
            localObject3 = new Intent(this, AuthDevActivity.class);
            ((Intent)localObject3).putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            ((Intent)localObject3).putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            ((Intent)localObject3).putExtra("auth_dev_open", true);
            ((Intent)localObject3).putExtra("auth_dev_gray_switch", this.aRG);
            if (this.jdField_b_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse == null)
            {
              ((Intent)localObject3).putExtra("secureState", "secureStateUNKNOWN");
              startActivityForResult((Intent)localObject3, 0);
            }
            else
            {
              if (this.jdField_b_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {}
              for (localObject1 = "secureStateOk";; localObject1 = "secureStateError")
              {
                ((Intent)localObject3).putExtra("secureState", (String)localObject1);
                if (!this.jdField_b_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {
                  break;
                }
                ((Intent)localObject3).putExtra("faceAppId", this.jdField_b_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_openid.get());
                ((Intent)localObject3).putExtra("faceTmpKey", this.jdField_b_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_tmpkey.get());
                break;
              }
            }
          }
          else
          {
            this.app.sendWirelessMeibaoReq(1);
            if (TextUtils.isEmpty(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
            {
              if (this.aRG)
              {
                bRh();
              }
              else
              {
                localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
                ((Intent)localObject1).putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
                startActivityForResult((Intent)localObject1, 0);
              }
            }
            else if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
            {
              if (this.aRG)
              {
                bRh();
              }
              else
              {
                localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
                ((Intent)localObject1).putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
                startActivityForResult((Intent)localObject1, 0);
              }
            }
            else if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1)
            {
              bRh();
              continue;
              try
              {
                bRf();
                anot.a(null, "dc00898", "", "", "0X800A5D0", "0X800A5D0", 0, 0, "", "", "", "");
                localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
                ((Intent)localObject1).putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
                startActivityForResult((Intent)localObject1, 0);
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
              continue;
              if (this.jdField_b_of_type_TencentImOidbOidb_0x5e1$RspBody == null)
              {
                if (!aqiw.isNetSupport(this)) {
                  QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
                }
                QLog.e("LoginInfoActivity.AccDevSec", 1, "face_login_layout click error : mFaceStateRsp is null");
              }
              else if (this.jdField_b_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.isEmpty())
              {
                QLog.e("LoginInfoActivity.AccDevSec", 1, "faceVerifyLayout click error : mFaceStateRsp.rpt_msg_uin_data is null or empty");
              }
              else
              {
                this.gQ.setClickable(false);
                localObject3 = this.app;
                if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
                {
                  localObject2 = "";
                  aiak.a((QQAppInterface)localObject3, this, (String)localObject2, this.jdField_b_of_type_TencentImOidbOidb_0x5e1$RspBody, this.jdField_b_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse, new LoginInfoActivity.14(this));
                  if (((oidb_0x5e1.UdcUinData)this.jdField_b_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
                    break label898;
                  }
                }
                for (localObject2 = "1";; localObject2 = "0")
                {
                  anot.a(null, "dc00898", "", "", "0X800AA7B", "0X800AA7B", 0, 0, (String)localObject2, "", "", "");
                  break;
                  localObject2 = this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
                  break label807;
                }
                anot.a(null, "dc00898", "", "", "0X800A5D1", "0X800A5D1", 0, 0, "", "", "", "");
                bRf();
                continue;
                startActivity(new Intent(this, SecurityPickproofActivity.class));
                anot.a(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof", "enter pickproof page", 0, 0, "", "", "", "");
                continue;
                if (!aqiw.isNetSupport(this))
                {
                  QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
                }
                else
                {
                  anot.a(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
                  startActivity(new Intent(this, RecentLoginDevActivity.class));
                  continue;
                  startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
                }
              }
            }
          }
        }
      }
    case 2131381297: 
      bRa();
      if (akwp.a().N(this.app, this.app.getCurrentAccountUin()))
      {
        localObject4 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject4).putExtra("uin", this.app.getCurrentAccountUin());
        localObject3 = hg("HasSetPwdUrl");
        i = 1;
        if (localObject3 != null)
        {
          localObject2 = localObject3;
          if (!((String)localObject3).equals("")) {}
        }
        else
        {
          localObject2 = "https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
          i = 0;
        }
        if (((String)localObject2).indexOf("?") == -1) {}
        for (localObject2 = (String)localObject2 + "?uin=" + this.app.getCurrentAccountUin();; localObject2 = (String)localObject2 + "&uin=" + this.app.getCurrentAccountUin())
        {
          startActivity(((Intent)localObject4).putExtra("url", (String)localObject2));
          this.app.sendWirelessPswReq(1);
          if (i == 0) {
            co("FetchUrl", 1);
          }
          co("ClkModifyPwd", 1);
          break;
        }
      }
      localObject3 = this.app.getCurrentAccountUin();
      localObject2 = hg("RegNewUrl");
      if ((localObject2 == null) || (((String)localObject2).equals("")))
      {
        i = 0;
        localObject2 = "https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw";
      }
      break;
    }
    for (;;)
    {
      localObject4 = new StringBuilder((String)localObject2);
      if (((String)localObject2).indexOf("?") == -1) {
        ((StringBuilder)localObject4).append("?");
      }
      for (;;)
      {
        ((StringBuilder)localObject4).append("uin=");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append("&plat=1");
        ((StringBuilder)localObject4).append("&app=1");
        ((StringBuilder)localObject4).append("&version=3.4.4.3058");
        ((StringBuilder)localObject4).append("&device=" + URLEncoder.encode(Build.DEVICE));
        ((StringBuilder)localObject4).append("&system=" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject4).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
        localObject2 = ((StringBuilder)localObject4).toString();
        localObject4 = new Intent();
        ((Intent)localObject4).putExtra("portraitOnly", true);
        ((Intent)localObject4).putExtra("url", (String)localObject2);
        ((Intent)localObject4).putExtra("uin", (String)localObject3);
        ((Intent)localObject4).putExtra("hide_operation_bar", true);
        ((Intent)localObject4).putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserActivity(this, (String)localObject2, 32768L, (Intent)localObject4, false, -1);
        if (i == 0) {
          co("FetchUrl", 2);
        }
        co("ClkModifyPwd", 2);
        break;
        ((StringBuilder)localObject4).append("&");
      }
      startActivityForResult(new Intent(this, SecurityProtectActivity.class), 2);
      anot.a(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on qqpimsecure_detect", 0, 0, "", "", "", "");
      break;
      if ((this.pp == null) || (this.pp.isEmpty())) {
        break;
      }
      localObject2 = new Intent(this, RiskInfoActivity.class);
      ((Intent)localObject2).putParcelableArrayListExtra("data", this.pp);
      ((Intent)localObject2).putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      startActivityForResult((Intent)localObject2, 3);
      anot.a(this.app, "dc00899", "Safe_RiskInfo", "", "RiskDetails", "click on risk details", 0, 0, "", "", "", "");
      anot.a(null, "dc00898", "", "", "0X800A718", "0X800A718", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevRpt", 2, "帐号安全页顶部风险提示区域点击“发现XXX等N项风险”文字进入安全风险页！0X800A718");
      break;
      if (this.aYp) {
        break;
      }
      this.aYp = true;
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", this.aNX);
      startActivity((Intent)localObject2);
      anot.a(this.app, "dc00899", "QQSafetyCenter", this.app.getCurrentAccountUin(), "clickQQSafetyCenter", "qq_safety_center_item", 0, 1, "", "", "", "");
      anot.a(null, "dc00898", "", "", "0X800A719", "0X800A719", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevRpt", 2, "帐号安全页点击“QQ安全中心”用户数、次数！0X800A719");
      break;
      if (this.aYo) {
        break;
      }
      this.aYo = true;
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", this.aNW);
      ((Intent)localObject2).putExtra("is_release_account", true);
      startActivityForResult((Intent)localObject2, 4);
      anot.a(this.app, "dc00898", "", "", "0X8009899", "0X8009899", 0, 0, "", "", "", "");
      break;
      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (!aqiw.isNetSupport(this))
        {
          QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
          break;
        }
        bMU();
        break;
      }
      this.app.sendWirelessMeibaoReq(1);
      if (TextUtils.isEmpty(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
      {
        anot.a(this.app, "dc00898", "", "", "0X800AC9E", "0X800AC9E", 0, 0, "2", "", "", "");
        localObject2 = new Intent(this, AuthDevOpenUgActivity.class);
        ((Intent)localObject2).putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult((Intent)localObject2, 0);
        break;
      }
      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
      {
        anot.a(this.app, "dc00898", "", "", "0X800AC9E", "0X800AC9E", 0, 0, "1", "", "", "");
        localObject2 = new Intent(this, AuthDevOpenUgActivity.class);
        ((Intent)localObject2).putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult((Intent)localObject2, 0);
        break;
      }
      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
        break;
      }
      anot.a(this.app, "dc00898", "", "", "0X800AC9E", "0X800AC9E", 0, 0, "1", "", "", "");
      if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onClick current is empty");
      }
      afsb.a(this, this.app, afsb.cTH, 1003, null);
      break;
      i = 1;
    }
  }
  
  static class CheckPIMStatus
    implements Runnable
  {
    private WeakReference<FormSimpleItem> dL;
    private WeakReference<Activity> mActivity;
    
    public CheckPIMStatus(Activity paramActivity, FormSimpleItem paramFormSimpleItem)
    {
      this.dL = new WeakReference(paramFormSimpleItem);
      this.mActivity = new WeakReference(paramActivity);
    }
    
    public void run()
    {
      boolean bool1 = aqil.bQ(MobileQQ.sMobileQQ);
      boolean bool2 = aqil.bR(MobileQQ.sMobileQQ);
      if (!bool1)
      {
        i = LoginInfoActivity.hN();
        if (i == LoginInfoActivity.vz()) {
          break label85;
        }
      }
      label85:
      for (int i = 2131719381;; i = 2131719384)
      {
        Activity localActivity = (Activity)this.mActivity.get();
        if (localActivity != null) {
          localActivity.runOnUiThread(new LoginInfoActivity.RefreshPIMStatus(i, this.dL));
        }
        return;
        if (!bool2)
        {
          i = LoginInfoActivity.hO();
          break;
        }
        i = LoginInfoActivity.vz();
        break;
      }
    }
  }
  
  static class RefreshPIMStatus
    implements Runnable
  {
    private WeakReference<FormSimpleItem> dL;
    private int mTextId;
    
    public RefreshPIMStatus(int paramInt, WeakReference<FormSimpleItem> paramWeakReference)
    {
      this.mTextId = paramInt;
      this.dL = paramWeakReference;
    }
    
    public void run()
    {
      if (this.dL != null)
      {
        FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.dL.get();
        if (localFormSimpleItem != null) {
          localFormSimpleItem.setRightText(localFormSimpleItem.getResources().getString(this.mTextId));
        }
      }
    }
  }
  
  class a
    extends ClickableSpan
  {
    private a() {}
    
    public void onClick(View paramView) {}
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(paramTextPaint.linkColor);
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */