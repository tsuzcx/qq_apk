package com.tencent.mobileqq.activity;

import MyCarrier.Carrier;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.activity.voip.VoipAddressBookActivity;
import com.tencent.mobileqq.activity.voip.VoipHistoryActivity;
import com.tencent.mobileqq.activity.voip.VoipPayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.filemanager.activity.FileAssistantActivity;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import ddc;
import ddd;
import ddh;
import ddi;
import ddk;
import ddl;
import ddm;
import ddn;
import ddo;
import ddq;
import dds;
import java.util.ArrayList;
import mqq.manager.TicketManager;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingMe
  implements View.OnClickListener
{
  public static int a = 0;
  public static final String a = "QQSettingRedesign";
  private static final int jdField_b_of_type_Int = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 4;
  private static final int g = 5;
  private static final int h = 6;
  private static final int i = 7;
  private static final int j = 8;
  private static final int k = 9;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ddc(this);
  protected View a;
  protected ViewGroup a;
  public ImageView a;
  protected TextView a;
  private QQSettingMe.UpdateMyBusinessReceiver jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe$UpdateMyBusinessReceiver;
  public BaseActivity a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dds(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new ddq(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ddd(this);
  public QQAppInterface a;
  private VipInfoObserver jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver = new ddo(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new ddn(this);
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  NightModeLogic.NightModeCallback jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = new ddh(this);
  private NightModeLogic jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic;
  protected RedDotTextView a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  protected boolean a;
  protected View[] a;
  protected View b;
  public ImageView b;
  public TextView b;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  protected View c;
  protected ImageView c;
  public boolean c;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public QQSettingMe(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903620, null));
  }
  
  private boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInfo != null)
    {
      bool1 = bool2;
      if (paramAppInfo.iNewFlag != null)
      {
        bool1 = bool2;
        if (paramAppInfo.iNewFlag.get() != 0)
        {
          bool1 = bool2;
          if (paramAppInfo.type.has())
          {
            bool1 = bool2;
            if (paramAppInfo.type.get() == 3) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = "http://mc.vip.qq.com?platform=1&sid=" + paramString + "&_bid=138";; paramString = "http://mc.vip.qq.com?platform=1&_bid=138")
    {
      Object localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(String.valueOf(100400));
      paramString = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(paramString, (BusinessInfoCheckUpdate.AppInfo)localObject);
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131561582));
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, 256L, (Intent)localObject, false, -1);
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(String.valueOf(100400));
      CustomWidgetUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131233118), 0, 0, 0);
      return;
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateVipInfo");
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(str1);
    ((VipInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(29)).a(str2, str1);
  }
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean) {
      f();
    }
    o();
    h();
    g();
    j();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((str != null) && (str.equals(this.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
  }
  
  public void a(Resources paramResources, ImageView paramImageView, String paramString)
  {
    try
    {
      Object localObject = paramResources.getDrawable(2130839215);
      localObject = URLDrawable.getDrawable(paramString, (Drawable)localObject, (Drawable)localObject, false);
      if (localObject != null)
      {
        int m = (int)(paramResources.getDisplayMetrics().density * 35.0F);
        ((URLDrawable)localObject).setBounds(0, 0, m, m);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingMe", 2, "red icon load fail, iconUrl=" + paramString);
      }
      paramImageView.setImageDrawable(paramResources.getDrawable(2130839215));
      paramImageView.setVisibility(0);
      localException.printStackTrace();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "fillData, " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      e();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.onAccountChanged(paramQQAppInterface);
      h();
      o();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    ThreadManager.a().post(new ddi(this, paramString));
  }
  
  boolean a()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    switch (localPhoneContactManagerImp.b())
    {
    case 5: 
    default: 
      return true;
    case 0: 
    case 4: 
    case 6: 
    case 7: 
      return true;
    case 1: 
    case 2: 
      return false;
    }
    return localPhoneContactManagerImp.i();
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.destroy();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QQSettingRedesign", 2, localException.toString());
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe$UpdateMyBusinessReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QQSettingRedesign", 2, localException.toString());
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver, true);
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("aciont_up_my_bus");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe$UpdateMyBusinessReceiver, localIntentFilter);
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.registerModeCallback(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "init, " + this.jdField_c_of_type_Boolean);
    }
    if (true == this.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Boolean = true;
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe$UpdateMyBusinessReceiver = new QQSettingMe.UpdateMyBusinessReceiver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233094);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setContentDescription("进入我的资料卡");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232300));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231090));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233096);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
      int[] arrayOfInt = new int[9];
      int[] tmp208_206 = arrayOfInt;
      tmp208_206[0] = 2131562010;
      int[] tmp214_208 = tmp208_206;
      tmp214_208[1] = 2131563300;
      int[] tmp220_214 = tmp214_208;
      tmp220_214[2] = 2131562425;
      int[] tmp226_220 = tmp220_214;
      tmp226_220[3] = 2131562110;
      int[] tmp232_226 = tmp226_220;
      tmp232_226[4] = 2131561637;
      int[] tmp238_232 = tmp232_226;
      tmp238_232[5] = 2131561902;
      int[] tmp244_238 = tmp238_232;
      tmp244_238[6] = 2131563394;
      int[] tmp251_244 = tmp244_238;
      tmp251_244[7] = 2131563395;
      int[] tmp258_251 = tmp251_244;
      tmp258_251[8] = 2131562419;
      tmp258_251;
      int m = 0;
      while (m < 9)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[m] = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(new int[] { 2131233107, 2131233108, 2131233111, 2131233113, 2131233112, 2131233110, 2131233114, 2131233115, 2131233109 }[m]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[m].setFocusable(true);
        this.jdField_a_of_type_ArrayOfAndroidViewView[m].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidViewView[m].setOnClickListener(this);
        ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[m].findViewById(2131233116);
        if (localImageView != null) {
          localImageView.setImageResource(new int[] { 2130839055, 2130839069, 2130839071, 2130839072, 2130839073, 2130839074, 2130839054, 2130839054, 2130839054 }[m]);
        }
        ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[m].findViewById(2131233117)).setText(arrayOfInt[m]);
        ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[m].findViewById(2131233118)).setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[m].setContentDescription(((Resources)localObject).getString(arrayOfInt[m]));
        m += 1;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233100);
      ((View)localObject).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)((View)localObject).findViewById(2131233101));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233102);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233104));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233103));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[5].findViewById(2131233119));
      e();
      h();
      o();
      g();
      j();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("QQSettingRedesign", 4, "init, cosume: " + (System.currentTimeMillis() - l));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "initUpdateVipInfoReceiver:" + localException.toString());
          }
        }
      }
    }
  }
  
  public void g()
  {
    k();
    l();
    m();
    p();
    n();
  }
  
  public void h()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (TextUtils.isEmpty(str2))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.a());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    a(str2);
    String str3 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
    String str1;
    if (str3 != null)
    {
      str1 = str3;
      if (!"".equals(str3.trim())) {}
    }
    else
    {
      str1 = str2;
    }
    if (!Utils.a(str1, this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = str1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131559093));
    this.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.onPostThemeChanged();
    }
  }
  
  public void j()
  {
    String str = null;
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int m = this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.getNightModeStatus();
    Drawable localDrawable;
    if (m == 1)
    {
      localDrawable = localResources.getDrawable(2130839066);
      str = localResources.getString(2131562469);
    }
    for (;;)
    {
      if (localDrawable != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
      if (str != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      }
      return;
      if (m == 2)
      {
        localDrawable = localResources.getDrawable(2130839065);
        str = localResources.getString(2131562469);
      }
      else
      {
        localDrawable = null;
      }
    }
  }
  
  public void k()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
          break label96;
        }
        bool1 = true;
        if (!bool1) {
          break label106;
        }
        if (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp)) {
          break label101;
        }
        bool1 = bool2;
      }
    }
    label96:
    label101:
    label106:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool1);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  protected void l()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(String.valueOf(100007));
      QQSettingUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131233118), localAppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void m()
  {
    try
    {
      Object localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(String.valueOf(100005));
      if (a((BusinessInfoCheckUpdate.AppInfo)localObject))
      {
        localObject = ((BusinessInfoCheckUpdate.AppInfo)localObject).icon_url.get();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_c_of_type_AndroidWidgetImageView, (String)localObject);
        }
      }
      else
      {
        QQSettingUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[5].findViewById(2131233118), (BusinessInfoCheckUpdate.AppInfo)localObject);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void n()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(String.valueOf(100400));
      QQSettingUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131233118), localAppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new ddk(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ddl(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new ddm(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
    Object localObject = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131233097);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131233098);
    StringBuilder localStringBuilder = new StringBuilder(100);
    RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a();
    if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.c)))
    {
      ((ImageView)localObject).setBackgroundResource(2130839067);
      ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.b, 200));
      localStringBuilder.append(localRichStatus.c);
      if (!TextUtils.isEmpty(localRichStatus.d)) {
        localStringBuilder.append(localRichStatus.d);
      }
      localStringBuilder.append(' ');
      if ((localRichStatus != null) && (localRichStatus.a != null))
      {
        if (localRichStatus.a.size() <= 0) {
          break label400;
        }
        localObject = (String)localRichStatus.a.get(0);
        label271:
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localStringBuilder.append((String)localObject);
        }
      }
      localObject = localStringBuilder.toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label405;
      }
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131559094));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131559095)).append((String)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131559096));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      ((ImageView)localObject).setBackgroundResource(0);
      ((ImageView)localObject).setPadding(0, 0, 0, 0);
      ((ImageView)localObject).setImageResource(2130839068);
      break;
      label400:
      localObject = null;
      break label271;
      label405:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    long l1;
    do
    {
      return;
      Object localObject;
      switch (paramView.getId())
      {
      case 2131233108: 
      case 2131233095: 
      case 2131233097: 
      case 2131233098: 
      case 2131233099: 
      case 2131233100: 
      case 2131233101: 
      case 2131233103: 
      case 2131233104: 
      case 2131233105: 
      case 2131233106: 
      default: 
        return;
      case 2131233094: 
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        paramView.e = 1;
        paramView.f = 8;
        ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
        com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
        return;
      case 2131233111: 
        QfavHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1);
        QfavReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
        return;
      case 2131233112: 
        l1 = 0L;
        try
        {
          long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
          l1 = l2;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            QZoneHelper.UserInfo localUserInfo;
            paramView.printStackTrace();
          }
        }
        localUserInfo = QZoneHelper.UserInfo.a();
        localUserInfo.a = String.valueOf(l1);
        localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
        paramView = (View)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramView = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        }
        localUserInfo.jdField_b_of_type_JavaLangString = paramView;
        QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localUserInfo, Long.valueOf(l1), 0, -1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
        com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
        return;
      case 2131233110: 
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(String.valueOf(100005));
        CustomWidgetUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[5].findViewById(2131233118), 0, 0, 0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, IndividuationSetActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
        com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
        return;
      case 2131233114: 
        if (a())
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VoipHistoryActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        }
        for (;;)
        {
          com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
          return;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VoipAddressBookActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        }
      case 2131233115: 
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VoipPayActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
        return;
      case 2131233102: 
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(null);
        this.jdField_c_of_type_AndroidViewView.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.startNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        com.tencent.mobileqq.activity.recent.DrawerFrame.d = 0;
        return;
      case 2131233096: 
        if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a()))
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, EditActivity.class);
          paramView.putExtra("k_source", 0);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
          com.tencent.mobileqq.activity.recent.DrawerFrame.d = 0;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004036", "0X8004036", 0, 0, "", "", "", "");
        return;
      case 2131233109: 
        paramView = ((MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a();
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(String.valueOf(100200));
        CustomWidgetUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[8].findViewById(2131233118), 0, 0, 0);
        if ((paramView == null) || (TextUtils.isEmpty(paramView.carrierURL)))
        {
          p();
          if (jdField_a_of_type_Int > 0) {
            com.tencent.mobileqq.activity.recent.DrawerFrame.d = 2;
          }
        }
        else
        {
          if (paramView.carrierURL.indexOf("&") > -1) {}
          for (paramView = paramView.carrierURL + "&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();; paramView = paramView.carrierURL + "?sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid())
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, MyBusinessActivity.class);
            ((Intent)localObject).putExtra("hide_operation_bar", true);
            ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            ((Intent)localObject).putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562419));
            ((Intent)localObject).putExtra("url", paramView);
            ((Intent)localObject).putExtra("hideRightButton", true);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800432A", "0X800432A", 0, 0, "", "", "", "");
            break;
          }
        }
        com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
        return;
      case 2131233107: 
        l1 = System.currentTimeMillis();
      }
    } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
    this.jdField_a_of_type_Long = l1;
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
    if (jdField_a_of_type_Int > 0)
    {
      com.tencent.mobileqq.activity.recent.DrawerFrame.d = 2;
      return;
    }
    com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
    return;
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, FileAssistantActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.recent.DrawerFrame.d = jdField_a_of_type_Int;
  }
  
  public void p()
  {
    Object localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject1).a("100200");
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {}
    for (int m = 1;; m = 0)
    {
      Object localObject2 = ((MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a();
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
      if ((localObject2 == null) || (TextUtils.isEmpty(((Carrier)localObject2).carrierURL)))
      {
        localView.setVisibility(8);
        if (m != 0) {
          ((RedTouchManager)localObject1).a("100200", false);
        }
        return;
      }
      if ((localView.getVisibility() == 8) || (localView.getVisibility() == 4)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800433C", "0X800433C", 0, 0, "", "", "", "");
      }
      localView.setVisibility(0);
      localObject1 = (TextView)localView.findViewById(2131233120);
      if (!TextUtils.isEmpty(((Carrier)localObject2).carrierLogo))
      {
        localObject2 = URLDrawable.getDrawable(((Carrier)localObject2).carrierLogo, new ColorDrawable(0), new ColorDrawable(0));
        m = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131427600);
        Rect localRect = new Rect();
        localRect.set(0, 0, m, m);
        ((URLDrawable)localObject2).setBounds(localRect);
        ((URLDrawable)localObject2).startDownload();
        ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
        ((TextView)localObject1).setText("");
        ((TextView)localObject1).setVisibility(0);
      }
      for (;;)
      {
        QQSettingUtil.a((TextView)localView.findViewById(2131233118), localAppInfo);
        return;
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */