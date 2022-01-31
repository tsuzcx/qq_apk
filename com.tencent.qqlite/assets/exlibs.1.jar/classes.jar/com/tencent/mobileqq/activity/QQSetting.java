package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bdz;
import bea;
import bec;
import bed;
import bef;
import bei;
import bej;
import bek;
import bel;
import bem;
import ben;
import beo;
import bep;
import beq;
import ber;
import bes;
import bet;
import beu;
import bey;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.observer.AccountObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import protocol.KQQConfig.UpgradeInfo;

public class QQSetting
  extends Frame
{
  public static final int b = 4000;
  public static final String b = "Setting_Quit";
  public static final String c = "http://mma.qq.com/feedback/index.html?";
  private static final boolean jdField_c_of_type_Boolean = true;
  static String jdField_d_of_type_JavaLangString = "http://m.qzone.com/l?g=755";
  private static final String jdField_e_of_type_JavaLangString = "QQSetting";
  protected int a;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  public View a;
  public ImageView a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new bed(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new bec(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bef(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private StatableSpanTextView jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView;
  String jdField_a_of_type_JavaLangString;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new bdz(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean = false;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private View l;
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getApplicationContext().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("mywallet_flag", 1);
  }
  
  private Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = a().getResources().getString(paramInt1);
    Object localObject1 = a().getResources().getString(paramInt2);
    String str2 = a().getResources().getString(paramInt3);
    String str1 = a().getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject1, new Object[] { paramString });; paramString = (String)localObject1)
    {
      localObject1 = new Dialog(a(), 2131624119);
      ((Dialog)localObject1).setContentView(2130903135);
      TextView localTextView = (TextView)((Dialog)localObject1).findViewById(2131296915);
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject2);
      }
      localObject2 = (TextView)((Dialog)localObject1).findViewById(2131296470);
      if (localObject2 != null) {
        ((TextView)localObject2).setText(paramString);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131296918);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131296919);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return localObject1;
    }
  }
  
  private SpannableString a(int paramInt)
  {
    int i1 = paramInt / 64;
    paramInt %= 64;
    int i2 = paramInt / 16;
    int i4 = paramInt % 16;
    int i3 = i4 / 4;
    int m = 0;
    String str = "";
    Object localObject;
    while (m < 4)
    {
      localObject = "";
      switch (m)
      {
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        int n = 0;
        while (n < paramInt)
        {
          str = str + (String)localObject;
          n += 1;
        }
        localObject = "!";
        paramInt = i1;
        continue;
        localObject = "@";
        paramInt = i2;
        continue;
        localObject = "#";
        paramInt = i3;
        continue;
        localObject = "%";
        paramInt = i4 % 4;
      }
      m += 1;
    }
    SpannableString localSpannableString = new SpannableString(str);
    m = (int)a().getDimension(2131492939);
    paramInt = 0;
    while (paramInt < str.length())
    {
      localObject = null;
      if ("!".equalsIgnoreCase(str.substring(paramInt, paramInt + 1))) {
        localObject = a().getDrawable(2130838913);
      }
      if ("@".equalsIgnoreCase(str.substring(paramInt, paramInt + 1))) {
        localObject = a().getDrawable(2130838917);
      }
      if ("#".equalsIgnoreCase(str.substring(paramInt, paramInt + 1))) {
        localObject = a().getDrawable(2130838914);
      }
      if ("%".equalsIgnoreCase(str.substring(paramInt, paramInt + 1))) {
        localObject = a().getDrawable(2130838916);
      }
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(0, 0, m, m);
        localSpannableString.setSpan(new ImageSpan((Drawable)localObject), paramInt, paramInt + 1, 33);
      }
      paramInt += 1;
    }
    return localSpannableString;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    Object localObject = a(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = a(2131361801) + a(2131361800) + Integer.toString(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
      if (localRedTouchManager != null) {
        localRedTouchManager.b(35);
      }
    }
  }
  
  private void s()
  {
    int m = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (m != 0)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        m = 0;
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
        m = 0;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void t()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)a(2131298600));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.findViewById(2131298605));
    this.jdField_b_of_type_AndroidViewView = a(2131298610);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131298612);
    p();
    this.jdField_c_of_type_AndroidViewView = a(2131298613);
    this.jdField_d_of_type_AndroidViewView = a(2131298615);
    this.jdField_e_of_type_AndroidViewView = a(2131298601);
    this.jdField_f_of_type_AndroidViewView = a(2131298607);
    this.g = a(2131298609);
    this.h = a(2131298608);
    this.i = a(2131298616);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131298618));
    s();
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new beo(this));
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(new bep(this));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new beq(this));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(new ber(this));
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting", 2, "initUI()");
    }
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(new bes(this));
    this.g.setOnClickListener(new bet(this));
    this.h.setOnClickListener(new beu(this));
    this.i.setOnClickListener(new bey(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131296439));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131298603));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131296443));
    b();
    u();
  }
  
  private void u()
  {
    bei localbei = new bei(this);
    this.j = a(2131298606);
    this.j.setOnClickListener(localbei);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.j.findViewById(2131298623));
    this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView = ((StatableSpanTextView)this.j.findViewById(2131298621));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.j.findViewById(2131298620));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.j.findViewById(2131298622));
    this.k = a(2131298624);
    this.k.setOnClickListener(localbei);
    this.l = a(2131298625);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.k.findViewById(2131298629));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.k.findViewById(2131298628));
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return paramLayoutInflater.inflate(2130903580, null);
  }
  
  protected String a()
  {
    return a(2131362939);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    a().setVolumeControlStream(3);
    t();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(a(), paramInt, 0).b(a().getTitleBarHeight());
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (1009 == paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "onActivityResult()");
      }
      n();
    }
    String str;
    do
    {
      do
      {
        return;
      } while ((-1 != paramInt2) || (paramInt1 != 1300) || (paramIntent == null));
      str = paramIntent.getStringExtra("roomId");
    } while (str == null);
    paramIntent = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(str);
    if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.discussionName))) {}
    for (paramIntent = a().getString(2131363221);; paramIntent = paramIntent.discussionName)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "start discussion session " + paramIntent);
      }
      Intent localIntent = new Intent(a(), ChatActivity.class);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", paramIntent);
      a(localIntent);
      return;
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("cur_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (!BaseActivity.isMoveTaskToBack(a(), paramIntent)) {
      paramIntent.addFlags(262144);
    }
    Uri localUri2 = paramIntent.getData();
    Object localObject;
    if ((localUri2 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      localObject = a().getPackageManager();
    }
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(a().getPackageName(), 0);
      if (localObject != null)
      {
        localObject = Uri.parse(localUri2.toString() + "&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid() + "&adtag=" + ((PackageInfo)localObject).versionName);
        paramIntent.setData((Uri)localObject);
        super.a(paramIntent, paramInt);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        Uri localUri1 = null;
        continue;
        localUri1 = Uri.parse(localUri2.toString() + "&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
      }
    }
  }
  
  void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          if (localFriendManager != null)
          {
            paramString = localFriendManager.a(paramString);
            if (paramString == null) {
              continue;
            }
            m = paramString.iQQLevel;
            b(m);
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        int m;
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QQSetting", 2, "updateQQLevelInfo Exception! ");
      }
      m = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_Boolean = false;
    p();
    n();
  }
  
  String b()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (l1 == 11L) {
      return "在线";
    }
    if (l1 == 41L) {
      return "隐身";
    }
    if (l1 == 31L) {
      return "离线";
    }
    return "";
  }
  
  public void b()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (str2 == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839390);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_e_of_type_AndroidViewView.setContentDescription(String.format("%s%s", new Object[] { str1, b() }));
    j();
    b(str2);
    m();
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new bea(this, paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    new Handler().postDelayed(new ben(this, paramBoolean), 150L);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    b();
    n();
  }
  
  public void h()
  {
    a(true);
  }
  
  public void i()
  {
    d();
  }
  
  void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    boolean bool1;
    if (localFriendsManagerImp == null)
    {
      localObject = null;
      if (localObject == null) {
        break label125;
      }
      bool1 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
    }
    for (boolean bool2 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_QQVIP);; bool2 = false)
    {
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839406, 0);
        return;
        localObject = localFriendsManagerImp.c((String)localObject);
        break;
      }
      if (bool2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839483, 0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
      label125:
      bool1 = false;
    }
  }
  
  protected void k()
  {
    super.k();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = null;
    s();
  }
  
  public void m()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting", 2, "online status = " + l1);
    }
    if (l1 == 11L) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839391);
    }
    do
    {
      return;
      if (l1 == 41L)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839386);
        return;
      }
    } while (l1 != 31L);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839388);
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new bej(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new bek(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new bel(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a();
    ProgressBar localProgressBar;
    if (!TextUtils.isEmpty(((RichStatus)localObject).c))
    {
      this.j.setVisibility(0);
      this.l.setVisibility(8);
      this.k.setVisibility(8);
      localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
      this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject).b, 201));
      this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView.setText(((RichStatus)localObject).a(null));
      if (!TextUtils.isEmpty(((RichStatus)localObject).e))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((RichStatus)localObject).a(this.jdField_d_of_type_AndroidWidgetTextView));
        this.jdField_f_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      this.j.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView.getText() + "，连按两次修改个性签名");
      if ((!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a()) && (!this.jdField_f_of_type_Boolean)) {
        break label440;
      }
      localProgressBar.setVisibility(0);
      localObject = new bem(this);
      Message localMessage = new Message();
      localMessage.obj = localProgressBar;
      ((Handler)localObject).sendMessageDelayed(localMessage, 1000L);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.j.setVisibility(8);
      this.k.setVisibility(0);
      localProgressBar = this.jdField_b_of_type_AndroidWidgetProgressBar;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(((RichStatus)localObject).a(null));
      if ((this.jdField_e_of_type_AndroidWidgetTextView.getText() == null) || (this.jdField_e_of_type_AndroidWidgetTextView.getText().length() == 0) || (this.jdField_e_of_type_AndroidWidgetTextView.equals("")))
      {
        this.l.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_f_of_type_Boolean = true;
      }
      else
      {
        this.l.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_Boolean = false;
      }
    }
    label440:
    localProgressBar.setVisibility(8);
  }
  
  public void o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_d_of_type_JavaLangString);
    localStringBuilder.append("&sid=");
    try
    {
      localStringBuilder.append(URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), "UTF-8"));
      localStringBuilder.append("&res_uin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      a(new Intent(a(), QQBrowserActivity.class).putExtra("url", localStringBuilder.toString()));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public void p()
  {
    q();
  }
  
  protected void q()
  {
    for (;;)
    {
      try
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(String.valueOf(100005));
        if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
        {
          m = 1;
          if (m != 0)
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            return;
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      int m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSetting
 * JD-Core Version:    0.7.0.1
 */