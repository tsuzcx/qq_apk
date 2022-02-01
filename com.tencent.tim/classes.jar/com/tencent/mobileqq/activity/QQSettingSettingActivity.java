package com.tencent.mobileqq.activity;

import accn;
import accz;
import acfd;
import acff;
import acha;
import aciu;
import acll;
import aclm;
import aehn;
import aiyw;
import aiyw.c;
import aizo;
import ajdo;
import aklk;
import altq;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqap;
import aqdj;
import aqgz;
import asxv;
import auvj;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Date;
import java.util.Locale;
import jnm;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;
import rpq;
import vqf;
import vqg;
import vqh;
import vqi;
import vqj;
import vqk;
import wvo;
import yuu;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final boolean aTl = AppSetting.enableTalkBack;
  private RedTouch A;
  TextView Em = null;
  TextView Ft;
  TextView Fu = null;
  private ProgressBar O;
  private accn jdField_a_of_type_Accn = new vqg(this);
  aiyw.c jdField_a_of_type_Aiyw$c = null;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  MultiImageTextView jdField_a_of_type_ComTencentWidgetMultiImageTextView;
  ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  private boolean aZV;
  private boolean aZW;
  private Bundle af;
  FormSimpleItem ag;
  FormSimpleItem ah;
  public boolean avH;
  private accz b = new vqi(this);
  public int bKg;
  aclm c = new vqh(this);
  private aklk e = new vqf(this);
  acfd g = new vqk(this);
  LinearLayout gs;
  RelativeLayout hd;
  FormItemRelativeLayout i;
  ImageView qV;
  ImageView qW = null;
  Resources res = BaseApplication.getContext().getResources();
  private RedTouch z;
  
  private void I(long paramLong, String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_qs_settings", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qsec_status_expired_time" + this.app.getCurrentAccountUin(), paramLong).putString("qsec_status_tip_text" + this.app.getCurrentAccountUin(), paramString).putLong("qsec_status_update_last_time" + this.app.getCurrentAccountUin(), new Date().getTime()).commit();
    }
  }
  
  private void bRk()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(asxv.getAppPackageName());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.getAppId());
    jnm.a(this.app, new vqj(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void bUA()
  {
    if (this.z != null)
    {
      altq localaltq = (altq)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("100190.100191");
      this.z.e(localAppInfo);
      localaltq.i(localAppInfo);
    }
  }
  
  private void bUB()
  {
    View localView = findViewById(2131370431);
    if (!TextUtils.isEmpty(AboutActivity.oJ()))
    {
      if (Integer.parseInt(AboutActivity.oJ()) == 5)
      {
        localView.setVisibility(0);
        z(2131370431, 2131701603, 0, 2130839682);
        return;
      }
      ArkIDESettingFragment.a().cUh();
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void bUC()
  {
    View localView = findViewById(2131361825);
    Drawable localDrawable = this.res.getDrawable(2130851403);
    boolean bool = Qz();
    if (bool) {
      a(localView, 0, localDrawable);
    }
    for (;;)
    {
      if ((!bool) && (aciu.ix(1))) {
        a(localView, 0, this.res.getDrawable(2130851400));
      }
      return;
      a(localView, 8, localDrawable);
    }
  }
  
  private void bUD()
  {
    ((ImageView)findViewById(2131375076).findViewById(2131381235)).setVisibility(8);
  }
  
  private void bUE()
  {
    ThreadManager.post(new QQSettingSettingActivity.6(this), 8, null, true);
  }
  
  private void bUG()
  {
    if (!this.aZW)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.cIL();
      }
      this.aZW = true;
    }
  }
  
  private void bUz()
  {
    if (this.A != null)
    {
      altq localaltq = (altq)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("100190.100199");
      this.A.g(localAppInfo);
      bUE();
      localaltq.i(localAppInfo);
    }
  }
  
  private void g(Card paramCard)
  {
    int j = 1;
    Object localObject = aehn.aS(this.app.getCurrentUin(), "hide_qq_xman");
    QLog.d("QQSetting2Activity", 2, "newxman_cfg =" + (String)localObject);
    try
    {
      int k = new JSONObject((String)localObject).getInt("hide_qq_xman");
      if (k == 1) {
        j = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        j = 0;
        continue;
        FriendProfileCardActivity.lQQMasterLogindays = 30L;
        continue;
        this.gs.setVisibility(8);
      }
    }
    if ((paramCard != null) && (paramCard.isShowXMan()) && (j != 0)) {
      if (paramCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.lQQMasterLogindays = paramCard.lQQMasterLogindays;
        if (paramCard.allowClick) {
          break label236;
        }
        this.hd.setVisibility(8);
        if (this.ah != null) {
          this.ah.setBgType(0);
        }
        this.i.setBGType(3);
        this.gs.setBackgroundDrawable(null);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuffer(200);
          ((StringBuffer)localObject).append("updataQQLoginDays card.lQQMasterLogindays=");
          ((StringBuffer)localObject).append(paramCard.lQQMasterLogindays);
          ((StringBuffer)localObject).append(";card.allowClick=");
          ((StringBuffer)localObject).append(paramCard.allowClick);
          QLog.d("QQSetting2Activity", 2, ((StringBuffer)localObject).toString());
        }
      }
    }
    label236:
    StringBuffer localStringBuffer;
    String str;
    if (QLog.isColorLevel())
    {
      localStringBuffer = new StringBuffer(200);
      localStringBuffer.append("updataQQLoginDays card=");
      if (paramCard != null) {
        break label381;
      }
      str = "null";
      label284:
      localStringBuffer.append(str);
      localStringBuffer.append(";card.isShowXMan()=");
      if (paramCard != null) {
        break label389;
      }
    }
    label389:
    for (paramCard = "null";; paramCard = Boolean.toString(paramCard.isShowXMan()))
    {
      localStringBuffer.append(paramCard);
      QLog.d("QQSetting2Activity", 2, localStringBuffer.toString());
      this.gs.setVisibility(8);
      this.hd.setVisibility(8);
      paramCard = findViewById(2131375077);
      if ((this.ah == null) || (paramCard == null) || (paramCard.getVisibility() == 0)) {
        break;
      }
      this.ah.setBgType(0);
      return;
      label381:
      str = "obj";
      break label284;
    }
  }
  
  private void wk(String paramString)
  {
    if ((this.A != null) && (this.A.aux()))
    {
      this.Em.setVisibility(8);
      return;
    }
    wl(paramString);
  }
  
  private void wl(String paramString)
  {
    if (this.Em != null)
    {
      if (acha.isLocaleCN())
      {
        this.Em.setVisibility(0);
        this.Em.setText(paramString);
      }
      if (AppSetting.enableTalkBack) {
        this.Em.setContentDescription(paramString);
      }
    }
  }
  
  private void x(boolean paramBoolean, Bundle paramBundle)
  {
    int j = 1;
    int k = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSetting2Activity", 4, String.format(Locale.getDefault(), "updatePhoneUnityInfo suc: %s, data: %s", new Object[] { Boolean.valueOf(paramBoolean), paramBundle }));
    }
    if ((this.Fu == null) || (this.qW == null) || (this.O == null)) {
      return;
    }
    if (!paramBoolean)
    {
      this.Fu.setText("");
      this.qW.setVisibility(8);
      this.O.setVisibility(8);
      return;
    }
    if (paramBundle == null)
    {
      this.Fu.setText(2131696805);
      this.qW.setVisibility(8);
      this.O.setVisibility(8);
      return;
    }
    this.af = paramBundle;
    this.O.setVisibility(8);
    this.Fu.setVisibility(0);
    String str = paramBundle.getString("phone");
    if (!TextUtils.isEmpty(str))
    {
      this.Fu.setText(str);
      if (paramBundle.getInt("need_unify", 0) != 1) {
        break label221;
      }
      label190:
      paramBundle = this.qW;
      if (j == 0) {
        break label226;
      }
    }
    label221:
    label226:
    for (j = k;; j = 8)
    {
      paramBundle.setVisibility(j);
      return;
      this.Fu.setText(2131696805);
      break;
      j = 0;
      break label190;
    }
  }
  
  public boolean Qz()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
          break label84;
        }
      }
    }
    label84:
    for (bool1 = bool2; !bool1; bool1 = false)
    {
      aizo localaizo = (aizo)this.app.getManager(244);
      if (localaizo == null) {
        break;
      }
      return localaizo.aqc();
    }
    return bool1;
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131375089);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131375090)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131375084);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void bUF()
  {
    if (this.ag == null) {
      return;
    }
    this.ag.setVisibility(8);
    this.ag.setOnClickListener(null);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int k = 0;
    int j = 0;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      if (paramInt2 != 0)
      {
        paramInt1 = k;
        if (paramInt2 != -1) {}
      }
      else
      {
        paramInt1 = k;
        if (paramIntent != null)
        {
          paramInt1 = k;
          if (paramIntent.getExtras() != null)
          {
            boolean bool = paramIntent.getExtras().getBoolean("auth_dev_open", false);
            paramInt1 = j;
            if (this.aZV != bool) {
              paramInt1 = 1;
            }
            this.aZV = bool;
          }
        }
      }
      if (paramInt1 != 0) {
        xT(true);
      }
    }
    do
    {
      return;
      if (paramInt1 == 2001)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSetting2Activity", 2, String.format("REQ_CODE_PHONE_UNITY_BIND_INFO [%s]", new Object[] { Integer.valueOf(paramInt2) }));
        }
        if (paramInt2 == 4001)
        {
          xT(true);
          return;
        }
        x(true, ((yuu)this.app.getManager(102)).aj);
        return;
      }
    } while ((paramInt1 != 1000000) || (!((ajdo)this.app.getManager(11)).Uv()));
    Intent localIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
    localIntent.putExtra("kSrouce", 1);
    if (paramIntent != null) {
      localIntent.putExtra("check_permission_result", paramIntent.getStringExtra("check_permission_result"));
    }
    startActivityForResult(localIntent, 2001);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561690);
    setTitle(getString(2131701668));
    if (AppSetting.enableTalkBack)
    {
      paramBundle = getString(2131701668);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130838900);
    this.ah = ((FormSimpleItem)findViewById(2131361943));
    this.ah.setLeftText(getString(2131701599));
    if (aTl) {
      this.ah.setContentDescription(getString(2131701599));
    }
    this.ah.setOnClickListener(this);
    z(2131375077, 2131701652, 0, 2130839695);
    z(2131375070, 2131701610, 0, 2130839689);
    paramBundle = (FormSimpleItem)findViewById(2131375075);
    paramBundle.ac().setText(2131701646);
    this.hd = paramBundle;
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = new ThemeImageView(getBaseContext());
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(auvj.euM);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(rpq.dip2px(this.app.getApp(), 47.0F), rpq.dip2px(this.app.getApp(), 21.0F));
    localLayoutParams.addRule(0, 2131367517);
    localLayoutParams.setMargins(0, rpq.dip2px(this.app.getApp(), 14.0F), 0, 0);
    this.hd.addView(this.jdField_a_of_type_ComTencentWidgetThemeImageView, localLayoutParams);
    this.hd.setVisibility(8);
    paramBundle.setOnClickListener(this);
    z(2131375074, 2131701634, 0, 2130839701);
    z(2131375076, 2131701650, 0, 2130839695);
    z(2131375071, 2131701616, 0, 2130839695);
    z(2131375069, 2131701604, 0, 2130839689);
    z(2131374966, 2131701651, 0, 2130839682);
    z(2131361825, 2131701598, 0, 2130839682);
    paramBundle = aqdj.a(this.app, this.app.getCurrentAccountUin(), (byte)1);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon width =" + paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon height =" + paramBundle.getMinimumHeight());
      }
      this.ah.setRightIcon(paramBundle, (int)(aqgz.getDesity() * 40.0F), (int)(aqgz.getDesity() * 40.0F));
    }
    this.app.addObserver(this.b);
    addObserver(this.jdField_a_of_type_Accn);
    addObserver(this.g);
    addObserver(this.c);
    this.app.registObserver(this.e);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = aqap.a().b();
    this.gs = ((LinearLayout)findViewById(2131374734));
    this.qV = ((ImageView)findViewById(2131374732));
    this.Ft = ((TextView)findViewById(2131374733));
    this.gs.setVisibility(8);
    ((CardHandler)this.app.getBusinessHandler(2)).cHB();
    this.ag = ((FormSimpleItem)findViewById(2131365548));
    paramBundle = (aiyw)this.app.getManager(221);
    if (paramBundle.isInit())
    {
      this.jdField_a_of_type_Aiyw$c = paramBundle.a(0);
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide has init entry: %s ", new Object[] { this.jdField_a_of_type_Aiyw$c }));
      }
    }
    for (;;)
    {
      bUF();
      this.avH = true;
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, "cu_open_card_guide not init");
      }
      this.jdField_a_of_type_Aiyw$c = null;
      ThreadManager.post(new QQSettingSettingActivity.4(this), 5, null, true);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.g);
    this.app.removeObserver(this.b);
    removeObserver(this.jdField_a_of_type_Accn);
    removeObserver(this.c);
    this.app.unRegistObserver(this.e);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.mSystemBarComp != null)
    {
      int j = getResources().getColor(2131167361);
      this.mSystemBarComp.setStatusColor(j);
    }
    super.doOnResume();
    bUD();
    bUA();
    bUz();
    bUE();
    ((yuu)this.app.getManager(102)).cmc();
    bUG();
    bUB();
    bUC();
    wm(this.app.getCurrentAccountUin());
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.addObserver(this.b);
    addObserver(this.jdField_a_of_type_Accn);
    addObserver(this.g);
    addObserver(this.c);
    aqdj localaqdj = aqdj.a(this.app, this.app.getCurrentAccountUin(), (byte)1);
    if (localaqdj != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon width =" + localaqdj.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon height =" + localaqdj.getMinimumHeight());
      }
      this.ah.setRightIcon(localaqdj, (int)(aqgz.getDesity() * 40.0F), (int)(aqgz.getDesity() * 40.0F));
    }
    xT(true);
    bUz();
    bUE();
    wm(this.app.getCurrentAccountUin());
  }
  
  public boolean onBackEvent()
  {
    wvo.c(this, SplashActivity.class);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131361943: 
    case 2131375074: 
    case 2131375076: 
    case 2131375070: 
    case 2131375071: 
    case 2131375069: 
    case 2131370431: 
    case 2131374966: 
    case 2131361825: 
    case 2131375075: 
    case 2131375077: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        startActivity(new Intent(this, AccountManageActivity.class));
        anot.a(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
        anot.a(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), PermisionPrivacyActivity.class));
        anot.a(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
        continue;
        startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
        anot.a(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), GeneralSettingActivity.class));
        anot.a(this.app, "CliOper", "", "", "Setting_tab", "0X8009C04", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
        anot.a(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
        continue;
        PublicFragmentActivity.start(this, new Intent(), ArkIDESettingFragment.class);
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://accounts.qq.com/info/management/index?_wv=3&_wwv=128");
        startActivity((Intent)localObject);
        continue;
        startActivity(new Intent(getActivity(), AboutActivity.class));
        if (Qz()) {
          anot.a(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", aqap.BI(), "");
        }
        anot.a(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=set");
        ((Intent)localObject).putExtra("hide_more_button", true);
        startActivity((Intent)localObject);
        anot.a(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
        continue;
        anot.a(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
        int j = ((ajdo)this.app.getManager(11)).xy();
        if ((j == 1) || (j == 5)) {
          anot.a(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
        }
        localObject = new Intent(this, PhoneUnityBindInfoActivity.class);
        ((Intent)localObject).putExtra("kSrouce", 1);
        if (this.af != null) {
          ((Intent)localObject).putExtra("kBindPhoneData", this.af);
        }
        startActivityForResult((Intent)localObject, 2001);
      }
    }
    if (this.jdField_a_of_type_Aiyw$c != null) {}
    for (Object localObject = this.jdField_a_of_type_Aiyw$c.jumpUrl;; localObject = "")
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("hide_more_button", true);
        startActivity(localIntent);
        ThreadManager.post(new QQSettingSettingActivity.8(this), 5, null, false);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "click cu_open_card_guide url: %s", new Object[] { localObject }));
      break;
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    aqdj localaqdj = aqdj.a(this.app, this.app.getCurrentAccountUin(), (byte)1);
    if (localaqdj != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon width =" + localaqdj.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon height =" + localaqdj.getMinimumHeight());
      }
      this.ah.setRightIcon(localaqdj, (int)(aqgz.getDesity() * 40.0F), (int)(aqgz.getDesity() * 40.0F));
    }
  }
  
  public void wm(String paramString)
  {
    try
    {
      if (this.app != null)
      {
        acff localacff = (acff)this.app.getManager(51);
        if (localacff != null) {
          ThreadManager.post(new QQSettingSettingActivity.11(this, localacff, paramString), 8, null, true);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("QQSetting2Activity", 2, "updateQQLevelInfo Exception!");
    }
  }
  
  public void xT(boolean paramBoolean)
  {
    yuu localyuu = (yuu)this.app.getManager(102);
    if ((System.currentTimeMillis() - localyuu.KK > 1800000L) || (localyuu.bpb) || (paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      acll localacll = (acll)this.app.getBusinessHandler(34);
      Locale localLocale;
      if (QLog.isColorLevel())
      {
        localLocale = Locale.getDefault();
        if (localacll != null) {
          break label206;
        }
      }
      label206:
      for (String str = "null";; str = "is not null")
      {
        QLog.i("QQSetting2Activity", 2, String.format(localLocale, "startGetPhoneUnityStatus force: %s, need: %s, h: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), str }));
        if ((!bool) || (localacll == null)) {
          break;
        }
        this.bKg += 1;
        localyuu.KK = System.currentTimeMillis();
        localyuu.bpb = false;
        localacll.f(0, 31, null, null);
        if (this.O != null) {
          this.O.setVisibility(0);
        }
        if (this.qW != null) {
          this.qW.setVisibility(8);
        }
        if (this.Fu != null) {
          this.Fu.setVisibility(8);
        }
        return;
      }
      x(true, localyuu.aj);
      return;
    }
  }
  
  public void z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = findViewById(paramInt1);
    if (localView == null) {}
    label213:
    label230:
    do
    {
      do
      {
        return;
        Object localObject = (TextView)localView.findViewById(2131375088);
        ((TextView)localObject).setText(paramInt2);
        if (aTl) {
          ((TextView)localObject).setContentDescription(getString(paramInt2));
        }
        if (paramInt3 > 0) {
          ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
        }
        localView.setBackgroundResource(paramInt4);
        localView.setOnClickListener(this);
        if ((localView instanceof FormItemRelativeLayout))
        {
          localObject = (FormItemRelativeLayout)localView;
          if (paramInt4 != 2130839701) {
            break label213;
          }
          ((FormItemRelativeLayout)localObject).setBGType(1);
        }
        for (;;)
        {
          if (paramInt1 != 2131375070) {
            break label230;
          }
          this.A = new RedTouch(this, localView).c(30).a();
          bUz();
          this.i = ((FormItemRelativeLayout)localView);
          localView.findViewById(2131373700).setVisibility(8);
          localView.findViewById(2131365798).setVisibility(8);
          this.Em = ((TextView)localView.findViewById(2131365797));
          if (this.Em == null) {
            break;
          }
          this.Em.setVisibility(8);
          return;
          if (paramInt4 == 2130839695) {
            ((FormItemRelativeLayout)localObject).setBGType(2);
          }
        }
        if (paramInt1 == 2131375079)
        {
          this.z = new RedTouch(this, localView).c(30).a();
          bUA();
          localView.findViewById(2131373700).setVisibility(8);
          localView.findViewById(2131365798).setVisibility(8);
          ((TextView)localView.findViewById(2131365797)).setVisibility(8);
          return;
        }
        if (paramInt1 != 2131375077) {
          break;
        }
        this.Fu = ((TextView)localView.findViewById(2131365797));
        if (this.Fu != null)
        {
          this.Fu.setVisibility(0);
          this.Fu.setText(2131696858);
          if (aTl) {
            this.Fu.setContentDescription(null);
          }
        }
        this.O = ((ProgressBar)localView.findViewById(2131373700));
        if (this.O != null) {
          this.O.setVisibility(8);
        }
        this.qW = ((ImageView)localView.findViewById(2131365798));
      } while (this.qW == null);
      this.qW.setImageResource(2130851400);
      this.qW.setVisibility(8);
      return;
    } while ((paramInt1 == 2131375076) || (!aTl));
    localView.setContentDescription(getString(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */