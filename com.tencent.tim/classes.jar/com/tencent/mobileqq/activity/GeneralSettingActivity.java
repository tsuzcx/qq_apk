package com.tencent.mobileqq.activity;

import acej;
import acfp;
import acha;
import aekl;
import ajgq;
import altq;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anlk;
import anlm;
import anot;
import anvt;
import anvv;
import anvv.a;
import anvv.b;
import anwa;
import aogc;
import aogs;
import aogs.a;
import aqha;
import aqju;
import arhz;
import awcy;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.studymode.ModeRadioGroup;
import com.tencent.mobileqq.studymode.ModeRadioGroup.a;
import com.tencent.mobileqq.theme.ThemeSwitcher.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;
import vca;
import vcb;
import vcc;
import vce;
import vcf;
import vcg;
import vch;
import vci;
import vcj;
import vck;
import vcl;
import vcm;
import vcn;
import vco;
import vcp;
import vur;
import wja;
import wvo;

public class GeneralSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, anvv.a, URLDrawable.URLDrawableListener2, ModeRadioGroup.a
{
  TextView DE;
  FormSwitchItem E;
  FormSwitchItem F;
  aogs.a jdField_a_of_type_Aogs$a = new vcg(this);
  private aogs jdField_a_of_type_Aogs;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  ModeRadioGroup jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
  public FormSwitchSimpleItem a;
  public vur a;
  private boolean aXg;
  private boolean aXh = true;
  FormSwitchSimpleItem b;
  FormSwitchSimpleItem c;
  long clickTime = 0L;
  private String currentUin = "";
  public Handler handler = new vcf(this);
  aqju m;
  private RedTouch o;
  View.OnClickListener onClickListener = new vca(this);
  private CompoundButton.OnCheckedChangeListener q = new vcc(this);
  View sX;
  private View sY;
  private View sZ;
  public arhz v;
  
  public GeneralSettingActivity()
  {
    this.jdField_a_of_type_Vur = new vur();
  }
  
  private TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      Object localObject = (ViewGroup)getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      cf(2131696348, 1);
      if (!paramBoolean1)
      {
        paramBoolean1 = true;
        a(paramCompoundButton, paramBoolean1);
      }
    }
    while (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
      for (;;)
      {
        return;
        paramBoolean1 = false;
      }
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem))
    {
      if (!paramBoolean1) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        a(paramCompoundButton, paramBoolean1);
        return;
      }
    }
    Object localObject = new GeneralSettingActivity.12(this, paramBoolean2, paramInt, paramCompoundButton, paramBoolean1);
    if (paramBoolean1)
    {
      SharedPreferences localSharedPreferences = ThemeUtil.getUinThemePreferences(this.app);
      if (localSharedPreferences.getBoolean("key_simple_should_show_switch_dialog", true))
      {
        localSharedPreferences.edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
        localObject = new vce(this, (Runnable)localObject);
        this.m = aqha.a(this, getString(2131719965), 0, 2131719963, (DialogInterface.OnClickListener)localObject, null);
        this.m.setOnDismissListener(new b(this, paramCompoundButton));
        this.m.show();
        if (!paramBoolean1) {
          break label242;
        }
      }
    }
    label242:
    for (paramCompoundButton = "0X800A0FC";; paramCompoundButton = "0X800A0FD")
    {
      anot.a(this.app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, anlm.Kd(), 0, "0", "0", "", "");
      return;
      ((Runnable)localObject).run();
      break;
      ((Runnable)localObject).run();
      break;
    }
  }
  
  private void a(boolean paramBoolean, FormSwitchSimpleItem paramFormSwitchSimpleItem)
  {
    paramFormSwitchSimpleItem = paramFormSwitchSimpleItem.ad();
    if (paramFormSwitchSimpleItem == null) {
      return;
    }
    Drawable localDrawable;
    if (paramBoolean)
    {
      paramFormSwitchSimpleItem.setVisibility(0);
      localDrawable = getResources().getDrawable(2130839657);
      paramFormSwitchSimpleItem.setTag(localDrawable);
      int i = wja.dp2px(19.0F, getResources());
      localDrawable.setBounds(0, 0, i, i);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, localDrawable, null);
      ((Animatable)localDrawable).start();
      paramFormSwitchSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a();
      if (paramBoolean) {
        break label145;
      }
    }
    label145:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramFormSwitchSimpleItem.setEnabled(paramBoolean);
      return;
      localDrawable = (Drawable)paramFormSwitchSimpleItem.getTag();
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      paramFormSwitchSimpleItem.setTag(null);
      paramFormSwitchSimpleItem.setVisibility(8);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, null, null);
      break;
    }
  }
  
  private boolean a(FormSwitchSimpleItem paramFormSwitchSimpleItem)
  {
    paramFormSwitchSimpleItem = paramFormSwitchSimpleItem.ad();
    if (paramFormSwitchSimpleItem == null) {}
    while (!(paramFormSwitchSimpleItem.getTag() instanceof Animatable)) {
      return false;
    }
    return true;
  }
  
  private void aE(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Vur.aE(paramInt, paramBoolean);
    this.sX.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void aK(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "handleModeSelectRadioByRequest");
    }
    if ((anwa.TK()) && (this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup != null))
    {
      int i = anvt.f(paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(i, false, false);
    }
    at(paramBoolean1, anlm.Kd());
  }
  
  private void bPC()
  {
    ThreadManager.getUIHandler().post(new GeneralSettingActivity.15(this));
  }
  
  private void bPD()
  {
    Activity localActivity = getParent();
    if (localActivity == null) {
      return;
    }
    this.c.setOnClickListener(null);
    this.c.setClickable(false);
    this.jdField_a_of_type_Aogs.ch(localActivity);
  }
  
  private void bPw()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    if ((TextUtils.isEmpty(str)) || ("1000".equals(str)) || ("1103".equals(str))) {}
    for (boolean bool = true;; bool = false)
    {
      this.aXh = bool;
      this.jdField_a_of_type_Aogs = new aogs(this.app);
      this.jdField_a_of_type_Aogs.a(this.jdField_a_of_type_Aogs$a, true);
      return;
    }
  }
  
  private void bPx()
  {
    if (this.o != null)
    {
      altq localaltq = (altq)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("100190.100194");
      this.o.e(localAppInfo);
      localaltq.i(localAppInfo);
    }
  }
  
  private void bPy()
  {
    anvv localanvv = (anvv)this.app.getManager(361);
    localanvv.a(this);
    TextView localTextView = (TextView)findViewById(2131378437);
    localTextView = (TextView)findViewById(2131371877);
    this.sX.findViewById(2131365990);
    this.sX.findViewById(2131364881);
    boolean bool = anlm.ayn();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.ad().setVisibility(8);
    this.jdField_a_of_type_Vur.a(this.sX, this);
    at(bool, anlm.Kd());
    if ((anwa.TK()) && (localanvv.azc()))
    {
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.Qx(false);
      this.jdField_a_of_type_Vur.xY(false);
      if ((anvt.mk() == 1) && (localanvv.Kt() == 1))
      {
        this.jdField_a_of_type_Vur.aI(localanvv.Ku(), true);
        this.sX.setTag(Boolean.valueOf(true));
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(localanvv.Kt(), false, false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(localanvv.Kt(), false, true);
      return;
    }
    ((anlk)this.app.getBusinessHandler(154)).dRx();
    if (anwa.TK())
    {
      int i = anvt.mk();
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(i, false, false);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), bool);
  }
  
  private void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (anvv)this.app.getManager(361);
    boolean bool = ((anvv)localObject).azc();
    localObject = ((anvv)localObject).a(this, paramInt1, paramInt2, paramBoolean1);
    if (((anvv.b)localObject).azc())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : true , mode : " + ((anvv.b)localObject).Kv());
      }
      if (paramBoolean2) {
        aE(paramInt2, true);
      }
      ModeRadioGroup localModeRadioGroup = this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
      paramInt1 = ((anvv.b)localObject).Kv();
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localModeRadioGroup.t(paramInt1, false, paramBoolean1);
        if (bool) {
          QQToast.a(BaseApplication.getContext(), 0, 2131719970, 0).show();
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : false , mode : " + ((anvv.b)localObject).Kw());
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(((anvv.b)localObject).Kw(), false, false);
  }
  
  private void fd(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2, true, false);
  }
  
  private void initUI()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131378433));
    this.sX = super.findViewById(2131378432);
    this.b = ((FormSwitchSimpleItem)super.findViewById(2131361796));
    this.DE = ((TextView)super.findViewById(2131365587));
    this.c = ((FormSwitchSimpleItem)super.findViewById(2131361795));
    this.c.setOnClickListener(this);
    this.E = ((FormSwitchItem)super.findViewById(2131366465));
    this.F = ((FormSwitchItem)super.findViewById(2131372548));
    y(2131375073, 2131701637, 0, 2130839682);
    super.findViewById(2131364557).setOnClickListener(new vci(this));
    super.findViewById(2131363135).setOnClickListener(new vcj(this));
    this.sY = super.findViewById(2131367415);
    this.sY.setVisibility(8);
    this.sZ = super.findViewById(2131371997);
    if (ajgq.aqC()) {
      this.sZ.setVisibility(0);
    }
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.fontCfg.name(), "-1");
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "current fontSetting dpcValue=" + (String)localObject);
    }
    if (("1".equals(localObject)) && (acej.ZU())) {
      this.sY.setVisibility(0);
    }
    for (;;)
    {
      if (aekl.agL())
      {
        acha.printLog("GeneralSettingActivity, entrance1:false, entrance2:" + acha.bHZ);
        View localView2 = findViewById(2131375072);
        if (localView2 != null)
        {
          localView2.setVisibility(0);
          if ((this.sY instanceof FormSimpleItem)) {
            ((FormSimpleItem)this.sY).setBgType(1);
          }
          ((TextView)localView2.findViewById(2131375088)).setText(getResources().getString(2131719595));
          View localView1 = localView2.findViewById(2131375089);
          localObject = localView1;
          if (localView1 == null) {
            localObject = ((ViewStub)localView2.findViewById(2131375090)).inflate();
          }
          ((View)localObject).setVisibility(0);
          localObject = (TextView)((View)localObject).findViewById(2131378513);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296934));
          ((TextView)localObject).setTypeface(Typeface.DEFAULT);
          ((TextView)localObject).setText(acha.dz(acha.Ax()));
          localView2.setOnClickListener(new vck(this));
        }
      }
      boolean bool = SettingCloneUtil.readValue(this, null, getString(2131697083), "qqsetting_enter_sendmsg_key", false);
      this.E.setChecked(bool);
      this.E.setOnCheckedChangeListener(new vcl(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131719914), "qqsetting_notify_icon_key", false);
      this.F.setChecked(bool);
      this.F.setOnCheckedChangeListener(new vcm(this));
      this.sY.setOnClickListener(new vcn(this));
      this.sZ.setOnClickListener(new vco(this));
      if (AppSetting.enableTalkBack)
      {
        this.E.setContentDescription(acfp.m(2131706937));
        this.F.setContentDescription("系统通知栏显示QQ图标");
        this.sZ.setContentDescription(getActivity().getResources().getString(2131719889));
        this.b.setContentDescription(getActivity().getResources().getString(2131719721));
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup = ((ModeRadioGroup)super.findViewById(2131368073));
      bPy();
      return;
      if ("0".equals(localObject))
      {
        this.sY.setVisibility(8);
        acej.dL(this);
      }
      else if (acej.ZT())
      {
        this.sY.setVisibility(0);
      }
      else
      {
        this.sY.setVisibility(8);
        acej.dL(this);
      }
    }
  }
  
  public void AZ(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      cf(2131696348, 1);
      QQToast.a(BaseApplication.getContext(), 1, 2131696348, 0).show(getTitleBarHeight());
    }
    while (PK()) {
      return;
    }
    if (anwa.TK()) {
      d(1, paramInt, false, true);
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X800A3D6", "0X800A3D6", anlj.nJ[paramInt] + 1, 0, "0", "0", "", "");
      return;
      if (!((anlk)this.app.getBusinessHandler(154)).b(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked(), paramInt, false)) {
        cf(2131719970, 0);
      } else {
        aE(paramInt, true);
      }
    }
  }
  
  public boolean PK()
  {
    Object localObject = this.sX.getTag();
    return ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue());
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.q);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBoolean)
      {
        i = 2;
        QQToast.a(this, i, paramString, 0).show();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, "onModeChangeComplete isSuccess : " + paramBoolean + ", curType : " + paramInt1 + ", oldType : " + paramInt2);
      }
      this.jdField_a_of_type_Vur.xY(true);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.Qx(true);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.Vy(paramInt1);
      if (!paramBoolean) {
        break label156;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(paramInt1, false, false);
      if (paramInt1 != 1) {
        break label151;
      }
    }
    label151:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      at(paramBoolean, anlm.Kd());
      awcy.eDk();
      return;
      i = 1;
      break;
    }
    label156:
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(paramInt2, false, false);
    if (paramInt2 == 1) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      at(paramBoolean, anlm.Kd());
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onSwitchSimpleUICallback suc=%b bSwitchElsePref=%b hasChange=%b statusCode=%d", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    Object localObject;
    label159:
    String str;
    if (paramBoolean3)
    {
      paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked();
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          ci(getString(2131719967, new Object[] { acfp.m(2131706940) }), 2);
        }
        a(false, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem);
        at(anlm.ayn(), anlm.Kd());
        if (paramBoolean1) {
          awcy.eDk();
        }
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), anlm.ayn());
      if (paramBoolean2)
      {
        localObject = acfp.m(2131706938);
        str = getString(2131719966, new Object[] { localObject });
        if (1 != paramInt) {
          break label239;
        }
        localObject = acfp.m(2131706935) + (String)localObject + acfp.m(2131706936);
      }
    }
    for (;;)
    {
      ci((String)localObject, 1);
      break;
      localObject = acfp.m(2131706939);
      break label159;
      label239:
      if (6 == paramInt)
      {
        localObject = str + acfp.m(2131706934);
        continue;
        if (paramBoolean1) {
          break;
        }
        cf(2131719964, 1);
        break;
      }
      localObject = str;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onReqGetSimpleUISwitch suc=%b [%b,%d]", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    if ((!paramBoolean1) || (!this.app.getCurrentAccountUin().equals(paramString))) {}
    while ((a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem)) || (PK())) {
      return;
    }
    aK(paramBoolean2, paramBoolean3);
  }
  
  public void at(boolean paramBoolean, int paramInt) {}
  
  protected void bPA()
  {
    if (this.aXg) {
      return;
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout == null)
    {
      QLog.e("GeneralSettingActivity", 2, "processRvTouchEvent failed! topGestureLayout return null!");
      return;
    }
    this.aXg = true;
    localTopGestureLayout.setInterceptTouchEventListener(new vcb(this));
  }
  
  public void bPB()
  {
    this.b.setChecked(aogc.azz());
  }
  
  public void bPz()
  {
    int i = this.jdField_a_of_type_Aogs.KF();
    if ((i == 1) || (i == 2))
    {
      this.c.setChecked(this.aXh);
      this.c.setOnClickListener(this);
      this.c.setClickable(true);
    }
  }
  
  void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight());
  }
  
  void ci(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561670);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131701616);
    this.currentUin = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    bPw();
    initUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.v != null) && (this.v.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.m != null)
    {
      this.m.setOnDismissListener(null);
      if (this.m.isShowing()) {
        this.m.cancel();
      }
    }
    super.doOnDestroy();
    Object localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(null);
    }
    if (this.jdField_a_of_type_Aogs != null)
    {
      this.jdField_a_of_type_Aogs.a(this.jdField_a_of_type_Aogs$a, false);
      this.jdField_a_of_type_Aogs.destroy();
    }
    localObject = (anvv)this.app.getManager(361);
    ((anvv)localObject).b(this);
    ((anvv)localObject).dTE();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    bPA();
  }
  
  public void fc(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeCheckedChanged curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    int i;
    label84:
    int j;
    if (paramInt1 == 2)
    {
      anot.a(this.app, "dc00898", "", "", "0X800AD6B", "0X800AD6B", 0, 0, "", "", "", "");
      if (paramInt1 != 1) {
        break label222;
      }
      i = 1;
      boolean bool = ThemeUtil.isNowThemeIsNight(this.app, false, null);
      j = anlm.Kd();
      paramInt2 = j;
      if (i != 0)
      {
        if (!bool) {
          break label227;
        }
        paramInt2 = anlm.dJU;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label254;
      }
      if (!aogc.a(this, anlj.gS[paramInt2], new vcp(this, paramInt1, paramInt2))) {
        fd(paramInt1, paramInt2);
      }
      return;
      if (paramInt1 == 1)
      {
        anot.a(this.app, "dc00898", "", "", "0X800A0FC", "0X800A0FC", anlm.Kd(), 0, "0", "0", "", "");
        break;
      }
      if (paramInt1 != 0) {
        break;
      }
      anot.a(this.app, "dc00898", "", "", "0X800A0FD", "0X800A0FD", anlm.Kd(), 0, "0", "0", "", "");
      break;
      label222:
      i = 0;
      break label84;
      label227:
      paramInt2 = j;
      if (ThemeUtil.isNowThemeIsNight(this.app, false, anlj.gS[j])) {
        paramInt2 = anlm.Ke();
      }
    }
    label254:
    fd(paramInt1, paramInt2);
  }
  
  public void fe(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeChangeStart curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.Qx(false);
    this.jdField_a_of_type_Vur.xY(false);
  }
  
  public void ff(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onSelectModeRecover curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_Vur.xY(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.Qx(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(paramInt2, false, false);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.Vy(paramInt1);
    if (paramInt2 == 1) {}
    for (;;)
    {
      at(bool, anlm.Kd());
      return;
      bool = false;
    }
  }
  
  public void fg(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeSwitching curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.t(paramInt1, false, true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.Qx(false);
    this.jdField_a_of_type_Vur.xY(false);
    if (paramInt2 == 1) {}
    for (;;)
    {
      at(bool, anlm.Kd());
      return;
      bool = false;
    }
  }
  
  public boolean onBackEvent()
  {
    wvo.b(this, QQSettingSettingActivity.class);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.clickTime != 0L) && (System.currentTimeMillis() - this.clickTime < 500L))
      {
        this.clickTime = System.currentTimeMillis();
      }
      else
      {
        this.clickTime = System.currentTimeMillis();
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131361795: 
          Activity localActivity = getParent();
          if ((localActivity != null) && (!aogc.a(localActivity, "", new vch(this)))) {
            bPD();
          }
          break;
        }
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.v = null;
    this.v = new arhz(this, super.getTitleBarHeight());
    this.v.setMessage(getString(2131691516));
    this.v.setBackAndSearchFilter(true);
    this.v.showTipImageView(false);
    this.v.showProgerss(true);
    return this.v;
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onFileDownloaded", new Object[] { "SimpleUILog" }));
    }
    bPC();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadCanceled", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadFialed", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadCanceled", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadSuccessed", new Object[] { "SimpleUILog" }));
    }
    bPC();
  }
  
  public void onPostThemeChanged()
  {
    boolean bool = false;
    super.onPostThemeChanged();
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onPostThemeChanged", new Object[] { "SimpleUILog" }));
    }
    if (this.jdField_a_of_type_Aogs != null) {
      this.jdField_a_of_type_Aogs.onPostThemeChanged();
    }
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    if ((TextUtils.isEmpty(str)) || ("1000".equals(str)) || ("1103".equals(str))) {
      bool = true;
    }
    this.aXh = bool;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131697046);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
  
  public void y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView2 = findViewById(paramInt1);
    if (localView2 == null) {}
    for (;;)
    {
      return;
      TextView localTextView = (TextView)localView2.findViewById(2131375088);
      localTextView.setText(paramInt2);
      View localView1 = localView2.findViewById(2131375089);
      Object localObject = localView1;
      if (localView1 == null) {
        localObject = ((ViewStub)localView2.findViewById(2131375090)).inflate();
      }
      ((View)localObject).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131378513);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296934));
      ((TextView)localObject).setTypeface(Typeface.DEFAULT);
      ((TextView)localObject).setText(acfp.m(2131706941));
      if (AppSetting.enableTalkBack) {
        localTextView.setContentDescription(getString(paramInt2));
      }
      if (paramInt3 > 0) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
      }
      localView2.setBackgroundResource(paramInt4);
      localView2.setOnClickListener(this.onClickListener);
      if ((localView2 instanceof FormItemRelativeLayout))
      {
        localObject = (FormItemRelativeLayout)localView2;
        if (paramInt4 != 2130839701) {
          break label246;
        }
        ((FormItemRelativeLayout)localObject).setBGType(1);
      }
      while (paramInt1 == 2131375073)
      {
        this.o = new RedTouch(this, localView2).c(30).a();
        bPx();
        return;
        label246:
        if (paramInt4 == 2130839695) {
          ((FormItemRelativeLayout)localObject).setBGType(2);
        }
      }
    }
  }
  
  static class a
    extends ThemeSwitcher.a
  {
    WeakReference<vur> U;
    WeakReference<View> V;
    
    public boolean bu(int paramInt)
    {
      vur localvur = (vur)this.U.get();
      View localView = (View)this.V.get();
      if ((localvur != null) && (localView != null)) {
        localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localvur, localView));
      }
      return super.bu(paramInt);
    }
  }
  
  static class b
    implements DialogInterface.OnDismissListener
  {
    WeakReference<GeneralSettingActivity> W;
    WeakReference<CompoundButton> X;
    
    b(GeneralSettingActivity paramGeneralSettingActivity, CompoundButton paramCompoundButton)
    {
      this.W = new WeakReference(paramGeneralSettingActivity);
      this.X = new WeakReference(paramCompoundButton);
    }
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      CompoundButton localCompoundButton = null;
      if (this.W == null)
      {
        paramDialogInterface = null;
        if (this.X != null) {
          break label47;
        }
      }
      for (;;)
      {
        if ((paramDialogInterface != null) && (localCompoundButton != null)) {
          paramDialogInterface.a(localCompoundButton, false);
        }
        return;
        paramDialogInterface = (GeneralSettingActivity)this.W.get();
        break;
        label47:
        localCompoundButton = (CompoundButton)this.X.get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity
 * JD-Core Version:    0.7.0.1
 */