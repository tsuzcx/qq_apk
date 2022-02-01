package com.tencent.mobileqq.activity;

import accn;
import accy;
import acfp;
import aemi;
import ajcd;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anot;
import aqed;
import aqmj;
import auqw;
import aurf;
import aurw;
import aurw.a;
import ausb;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.NumberWheelView;
import com.tencent.mobileqq.app.utils.TimeWheelPanel;
import com.tencent.mobileqq.app.utils.TimeWheelPanel.a;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.VerticalGallery;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import jjc;
import vjq;
import vjr;
import vjs;
import vjt;
import vju;
import vjv;
import vjw;
import vjx;
import vjy;
import vjz;
import vka;
import vkb;
import vkc;
import vkd;
import vke;
import vkf;
import vkg;
import vkh;
import vki;
import vkj;
import vkk;
import vkl;
import vkm;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  private TextView Ew;
  private FormSimpleItem K;
  private FormSimpleItem L;
  private FormSimpleItem M;
  private FormSimpleItem N;
  private FormSwitchItem X;
  private FormSwitchItem Y;
  private FormSwitchItem Z;
  private ajcd jdField_a_of_type_Ajcd;
  private a jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity$a;
  public BroadcastReceiver aD = new vkg(this);
  private boolean aYO;
  private boolean aYP = true;
  private boolean aYQ = true;
  private boolean aYR = true;
  private boolean aYS;
  private FormSwitchItem aa;
  private FormSwitchItem ab;
  private FormSwitchItem ac;
  private FormSwitchItem ad;
  private FormSwitchItem ae;
  private FormSwitchItem af;
  private FormSwitchItem ag;
  private FormSwitchItem ah;
  private FormSwitchItem ai;
  private FormSwitchItem aj;
  private FormSwitchItem ak;
  private accn cardObserver = new vke(this);
  public String currentUin = "";
  private aurf jdField_d_of_type_Aurf = new aurf(new vkf(this));
  private FormSwitchSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  private AtomicBoolean mSendingRequest = new AtomicBoolean(false);
  public CompoundButton.OnCheckedChangeListener s;
  private CompoundButton.OnCheckedChangeListener jdField_t_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new vjq(this);
  private FormSimpleItem jdField_t_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private View tH;
  private View tI;
  
  public static boolean Ql()
  {
    return new File(Environment.getRootDirectory() + "/etc/permissions", "com.lenovo.keyguard.xml").exists();
  }
  
  public static int d(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + paramString2;
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, paramInt).commit();
  }
  
  private void initUI()
  {
    this.tH = findViewById(2131368149);
    this.M = ((FormSimpleItem)findViewById(2131379295));
    this.ai = ((FormSwitchItem)findViewById(2131372311));
    this.aj = ((FormSwitchItem)findViewById(2131380026));
    this.K = ((FormSimpleItem)findViewById(2131372539));
    this.K.setOnClickListener(new vkb(this));
    this.Ew = ((TextView)findViewById(2131379747));
    this.ah = ((FormSwitchItem)findViewById(2131363145));
    this.X = ((FormSwitchItem)findViewById(2131364059));
    this.Y = ((FormSwitchItem)findViewById(2131378286));
    this.Y.setVisibility(8);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)findViewById(2131372401));
    this.L = ((FormSimpleItem)findViewById(2131372402));
    this.L.setOnClickListener(new vkh(this));
    int i = aqmj.i(this, "open_don_disturb", this.currentUin);
    boolean bool1;
    label601:
    boolean bool3;
    int j;
    if ((i != 1) && (!FriendsStatusUtil.bc(this)))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.L.setVisibility(8);
      findViewById(2131366029).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, " showOpen DISTURB=" + i);
      }
      this.tI = findViewById(2131378576);
      this.tI.setVisibility(8);
      this.Z = ((FormSwitchItem)findViewById(2131378287));
      this.aa = ((FormSwitchItem)findViewById(2131378281));
      this.ab = ((FormSwitchItem)findViewById(2131378289));
      this.ac = ((FormSwitchItem)findViewById(2131378300));
      this.ag = ((FormSwitchItem)findViewById(2131378312));
      this.ad = ((FormSwitchItem)findViewById(2131376832));
      this.ae = ((FormSwitchItem)findViewById(2131370872));
      this.af = ((FormSwitchItem)findViewById(2131372949));
      this.ak = ((FormSwitchItem)findViewById(2131378617));
      Object localObject = (CardHandler)this.app.getBusinessHandler(2);
      this.ak.setOnCheckedChangeListener(new vki(this, (CardHandler)localObject));
      bool1 = ausb.aJK();
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "initUI: invoked. special bar enable: " + bool1);
      }
      this.ak.setChecked(bool1);
      ((CardHandler)localObject).Es(bool1);
      this.jdField_t_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378619));
      this.jdField_t_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new vkj(this));
      if (this.app == null) {
        break label1899;
      }
      if (this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("spcial_care_qq_setting", true)) {
        this.jdField_t_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130851403));
      }
      if (aemi.v(this.app.getApp(), this.app.getAccount()) != 1) {
        break label1894;
      }
      i = 1;
      bool1 = SettingCloneUtil.readValue(this, this.currentUin, getString(2131718988), "qqsetting_notify_showcontent_key", true);
      this.aYS = FriendsStatusUtil.bc(this);
      bool3 = SettingCloneUtil.readValue(this, this.currentUin, getString(2131718980), "qqsetting_notify_blncontrol_key", true);
      boolean bool4 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool5 = LocalMultiProcConfig.getBool(getString(2131718976) + this.currentUin, true);
      boolean bool6 = SettingCloneUtil.readValue(this, this.currentUin, getString(2131718627), "qqsetting_receivemsg_whenexit_key", true);
      boolean bool2 = SettingCloneUtil.readValue(this, this.currentUin, getString(2131695500), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool7 = SettingCloneUtil.readValue(this, this.currentUin, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(this, this.currentUin, null, "qqsetting_kandian_key", true);
      localObject = (BubbleManager)this.app.getManager(44);
      if (localObject != null)
      {
        bool8 = ((BubbleManager)localObject).afO();
        if (bool8)
        {
          this.X.setChecked(((BubbleManager)localObject).afN());
          this.X.setOnCheckedChangeListener(new vkk(this, (BubbleManager)localObject));
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        localObject = this.X;
        if (!bool8) {
          break label1914;
        }
        j = 0;
        label879:
        ((FormSwitchItem)localObject).setVisibility(j);
      }
      boolean bool8 = jjc.cI(this.app.getCurrentAccountUin());
      if (!bool8) {
        break label1920;
      }
      j = 0;
      label904:
      ThreadManager.excute(new NotifyPushSettingActivity.7(this, j), 16, null, false);
      this.ah.setVisibility(0);
      this.ah.setChecked(bool8);
      bool8 = this.jdField_a_of_type_Ajcd.aqn();
      this.ai.setChecked(bool8);
      this.ai.setOnCheckedChangeListener(this.jdField_a_of_type_Ajcd.a(this, this.ai, this.K));
      localObject = aurw.a.a(this.app);
      this.aj.setChecked(((aurw)localObject).aJD());
      this.aj.setOnCheckedChangeListener(((aurw)localObject).b());
      this.aj.setVisibility(8);
      this.jdField_a_of_type_Ajcd.b(this, this.Ew);
      this.s = new vkl(this);
      this.ah.setOnCheckedChangeListener(this.s);
      this.Y.setChecked(bool1);
      this.Y.setOnCheckedChangeListener(new vkm(this));
      if (AppSetting.enableTalkBack) {
        this.Y.setContentDescription(acfp.m(2131709181));
      }
      xI(this.aYS);
      if (Build.VERSION.SDK_INT < 26) {
        break label1925;
      }
      this.Z.setVisibility(8);
      label1125:
      this.aa.setChecked(bool4);
      this.aa.setOnCheckedChangeListener(new vjs(this));
      if (!auqw.isSupportBadge(this.app.getApplication())) {
        break label1960;
      }
      this.aa.setVisibility(0);
      label1170:
      this.ab.setChecked(bool5);
      this.ab.setOnCheckedChangeListener(new vjt(this));
      this.ad.setChecked(bool6);
      this.ad.setOnCheckedChangeListener(new vju(this));
      this.app.addObserver(this.cardObserver, true);
      localObject = (CardHandler)this.app.getBusinessHandler(2);
      this.af.setChecked(bool7);
      this.af.setOnCheckedChangeListener(new vjv(this, (CardHandler)localObject));
      bool3 = SettingCloneUtil.readValue(this, this.currentUin, null, "qqsetting_hello_live_message", true);
      CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(2);
      this.ac.setChecked(bool3);
      this.ac.setContentDescription(getString(2131720297));
      this.ac.setOnCheckedChangeListener(new vjw(this, localCardHandler));
      if (i == 0) {
        break label1972;
      }
      this.ag.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(this, this.currentUin, null, "qqsetting_show_push_message", true);
      this.ag.setChecked(bool3);
      this.ag.setContentDescription(getString(2131720304));
      this.ag.setOnCheckedChangeListener(new vjx(this, localCardHandler));
      label1404:
      if (localObject != null)
      {
        ((CardHandler)localObject).cHu();
        localCardHandler.cHw();
        localCardHandler.cHv();
      }
      SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false);
      this.ae.setChecked(bool2);
      if (!Ql()) {
        break label1984;
      }
      this.ae.setChecked(false);
      this.ae.setVisibility(8);
      label1479:
      this.ae.setOnCheckedChangeListener(new vjy(this));
      if (AppSetting.enableTalkBack) {
        this.ae.setContentDescription(acfp.m(2131709190));
      }
      this.tH.setOnClickListener(new vjz(this));
      this.M.setOnClickListener(new vka(this));
      this.tI.setOnClickListener(new vkc(this));
      this.N = ((FormSimpleItem)findViewById(2131370077));
      if (!aqed.aBX()) {
        break label2020;
      }
      this.N.setOnClickListener(new vkd(this));
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        this.tI.setContentDescription(acfp.m(2131709187));
        this.ai.setContentDescription(getString(2131696307));
        this.aj.setContentDescription(getString(2131721224));
        this.K.setContentDescription(getString(2131696477) + getString(2131719602));
        this.ah.setContentDescription(acfp.m(2131709186));
        this.Y.setContentDescription(acfp.m(2131709177));
        this.Z.setContentDescription(acfp.m(2131718980));
        this.ab.setContentDescription(acfp.m(2131709174));
        this.ad.setContentDescription(acfp.m(2131709188));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131697105));
        this.af.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_t_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131717467));
        this.ak.setContentDescription(getString(2131717468));
        this.tH.setContentDescription(acfp.m(2131709184));
        this.M.setContentDescription(getString(2131720984));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131697105));
        this.L.setContentDescription(getString(2131697106));
      }
      ((accy)this.app.getBusinessHandler(4)).cIc();
      return;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.L.setVisibility(0);
      findViewById(2131366029).setVisibility(0);
      break;
      label1894:
      i = 0;
      break label601;
      label1899:
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
      i = 0;
      break label601;
      label1914:
      j = 8;
      break label879;
      label1920:
      j = 1;
      break label904;
      label1925:
      this.Z.setVisibility(0);
      this.Z.setChecked(bool3);
      this.Z.setOnCheckedChangeListener(new vjr(this));
      break label1125;
      label1960:
      this.aa.setVisibility(8);
      break label1170;
      label1972:
      this.ag.setVisibility(8);
      break label1404;
      label1984:
      if (bool1)
      {
        this.ae.setVisibility(0);
        this.ae.setVisibility(8);
        break label1479;
      }
      this.ae.setVisibility(8);
      break label1479;
      label2020:
      this.N.setVisibility(8);
    }
  }
  
  public static void q(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.execute(new NotifyPushSettingActivity.22(paramQQAppInterface, paramString));
  }
  
  private void vQ(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(this, paramString, null, "qqsetting_pcactive_key", false);
      this.aYO = true;
      this.af.setChecked(bool);
      this.aYO = false;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void vR(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(this, paramString, null, "qqsetting_hello_live_message", true);
      this.aYQ = false;
      this.ac.setChecked(bool);
      this.aYO = true;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void xI(boolean paramBoolean)
  {
    int j = 0;
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(paramBoolean);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(this.jdField_t_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    FormSwitchItem localFormSwitchItem;
    if (paramBoolean)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(2);
      this.L.setVisibility(0);
      this.aYS = paramBoolean;
      localFormSwitchItem = this.ai;
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.isChecked()) {
        break label123;
      }
      i = 0;
      label72:
      localFormSwitchItem.setVisibility(i);
      localFormSwitchItem = this.ah;
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.isChecked()) {
        break label129;
      }
    }
    label129:
    for (int i = j;; i = 8)
    {
      localFormSwitchItem.setVisibility(i);
      return;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(3);
      this.L.setVisibility(8);
      break;
      label123:
      i = 8;
      break label72;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559721);
    setTitle(2131719910);
    if (this.app != null) {
      this.currentUin = this.app.getCurrentAccountUin();
    }
    this.jdField_a_of_type_Ajcd = ajcd.a(this.app);
    initUI();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage");
    registerReceiver(this.aD, paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.app != null)
    {
      this.app.removeObserver(this.cardObserver);
      if (auqw.isSupportBadge(this.app.getApplication())) {
        auqw.clearAll();
      }
    }
    this.jdField_a_of_type_Ajcd.onActivityDestroy();
    unregisterReceiver(this.aD);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.app.getApp().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.aYS)
    {
      int i = (int)NetConnInfoCenter.getServerTime();
      int j = SettingCloneUtil.readValueForInt(getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      this.L.a().setText(acfp.m(2131709176) + a.aU((j - i) * 1000));
    }
    this.jdField_a_of_type_Ajcd.a(this.ai, this.Ew, this.ah);
  }
  
  public String setLastActivityName()
  {
    return getString(2131719611);
  }
  
  public static class a
    extends ReportDialog
    implements DialogInterface.OnCancelListener, DialogInterface.OnShowListener, View.OnClickListener, TimeWheelPanel.a
  {
    private TextView AQ;
    private TextView Ex;
    private FormSimpleItem O;
    private TimeWheelPanel a;
    private FormSwitchSimpleItem e;
    private boolean isChanged;
    private QQAppInterface mApp;
    private TextView mCancelButton;
    private View mContentView;
    private Context mContext;
    private AtomicBoolean mSendingRequest;
    private CompoundButton.OnCheckedChangeListener u;
    
    public a(Context paramContext, QQAppInterface paramQQAppInterface, FormSwitchSimpleItem paramFormSwitchSimpleItem, FormSimpleItem paramFormSimpleItem, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
    {
      super(2131755754);
      requestWindowFeature(1);
      this.mApp = paramQQAppInterface;
      this.e = paramFormSwitchSimpleItem;
      this.O = paramFormSimpleItem;
      this.Ex = paramFormSimpleItem.a();
      this.u = paramOnCheckedChangeListener;
      this.mContext = paramContext;
      this.mContentView = getLayoutInflater().inflate(2131561235, null);
      setContentView(this.mContentView);
      paramContext = getWindow();
      paramQQAppInterface = paramContext.getAttributes();
      paramQQAppInterface.width = -1;
      paramQQAppInterface.height = -2;
      paramQQAppInterface.gravity = 81;
      paramContext.setAttributes(paramQQAppInterface);
      paramContext.setWindowAnimations(2131755755);
      paramContext.setFlags(16777216, 16777216);
      setCancelable(true);
      setCanceledOnTouchOutside(true);
      initUI();
    }
    
    private void a(AtomicBoolean paramAtomicBoolean)
    {
      this.mSendingRequest = paramAtomicBoolean;
    }
    
    public static String aU(long paramLong)
    {
      return g(paramLong, false);
    }
    
    public static String g(long paramLong, boolean paramBoolean)
    {
      boolean bool = DateFormat.is24HourFormat(BaseApplication.getContext());
      paramLong = System.currentTimeMillis() + paramLong;
      if ((!bool) && (!paramBoolean))
      {
        String str = new SimpleDateFormat("hh:mm").format(new Date(paramLong));
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(paramLong);
        if (localCalendar.get(9) == 0) {
          return acfp.m(2131709180) + str;
        }
        return acfp.m(2131709189) + str;
      }
      return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
    }
    
    private void initUI()
    {
      if (this.mContentView == null) {
        return;
      }
      this.a = ((TimeWheelPanel)this.mContentView.findViewById(2131372848));
      this.a.init(0, 24, 60, 0);
      this.a.FP(true);
      this.a.setViewVisibility(0, 8);
      this.a.setViewVisibility(3, 0);
      this.a.setScrollerStateListener(this);
      this.mCancelButton = ((TextView)this.mContentView.findViewById(2131364243));
      this.mCancelButton.setTextColor(getContext().getResources().getColor(2131167337));
      this.AQ = ((TextView)this.mContentView.findViewById(2131365232));
      this.AQ.setTextColor(getContext().getResources().getColor(2131167344));
      this.mCancelButton.setClickable(true);
      this.AQ.setClickable(true);
      this.mCancelButton.setOnClickListener(this);
      this.AQ.setOnClickListener(this);
      this.mCancelButton.setFocusable(true);
      this.AQ.setFocusable(true);
      this.AQ.setEnabled(false);
      this.AQ.setTextColor(getContext().getResources().getColor(2131167532));
      if (this.mContext != null)
      {
        String str1 = acfp.m(2131709179);
        String str2 = acfp.m(2131709178);
        this.mCancelButton.setContentDescription(str1);
        this.AQ.setContentDescription(str2);
      }
      a(null, null);
      setOnCancelListener(this);
    }
    
    public void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery)
    {
      if (paramNumberWheelView != null) {
        this.isChanged = true;
      }
      if (this.a.Bq() == 0)
      {
        this.AQ.setEnabled(false);
        this.AQ.setTextColor(getContext().getResources().getColor(2131167532));
      }
      for (;;)
      {
        paramNumberWheelView = acfp.m(2131709173) + aU(this.a.Bq() * 1000);
        paramVerticalGallery = acfp.m(2131709192) + g(this.a.Bq() * 1000, true);
        this.a.setEndTime(paramNumberWheelView, paramVerticalGallery);
        return;
        if (this.isChanged)
        {
          this.AQ.setEnabled(true);
          this.AQ.setTextColor(getContext().getResources().getColor(2131167620));
        }
      }
    }
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      this.a.init(0, 24, 60, 0);
      a(null, null);
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
        dismiss();
        onCancel(null);
        continue;
        dismiss();
        long l1 = this.a.Bq() / 60;
        String str = acfp.m(2131709193) + aU(this.a.Bq() * 1000);
        this.Ex.setText(str);
        this.mSendingRequest.set(true);
        long l2 = NetConnInfoCenter.getServerTime();
        long l3 = this.a.Bq();
        ((CardHandler)this.mApp.getBusinessHandler(2)).E((int)(l3 + l2), "", "not_disturb_from_notify_push_setting_activity");
        this.a.init(0, 24, 60, 0);
        a(null, null);
        anot.a(this.mApp, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, l1 + "", "0", "", "");
      }
    }
    
    public void onShow(DialogInterface paramDialogInterface)
    {
      this.isChanged = false;
    }
    
    public void setTime(long paramLong)
    {
      long l = paramLong;
      if ((int)paramLong % 86400 % 3600 % 60 != 0) {
        l = paramLong + 60L;
      }
      this.a.cBj = ((int)l / 86400);
      this.a.cBk = ((int)l % 86400 / 3600);
      this.a.cBl = ((int)l % 86400 % 3600 / 60);
      this.a.setValues(true);
      String str1 = acfp.m(2131709182) + aU(this.a.Bq() * 1000);
      String str2 = acfp.m(2131709194) + g(this.a.Bq() * 1000, true);
      this.a.setEndTime(str1, str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */