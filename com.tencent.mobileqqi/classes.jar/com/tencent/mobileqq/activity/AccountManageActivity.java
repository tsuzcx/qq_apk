package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import bxp;
import bxq;
import bxr;
import bxs;
import bxt;
import bxu;
import bxv;
import bxx;
import bxz;
import bya;
import byb;
import byc;
import bye;
import byf;
import byg;
import byh;
import byi;
import byj;
import byk;
import byl;
import byo;
import byp;
import byq;
import byr;
import bys;
import byu;
import byv;
import byw;
import byx;
import byy;
import bza;
import bzb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import com.tencent.util.EUCountryUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 9876;
  public static final String a = "IS_ADD_ACCOUNT";
  public static final boolean a = true;
  public static final int b = 9875;
  public static final String b = "is_change_account";
  public static final int c = 5000;
  public static final String c = "login_from_account_change";
  public static final int d = 999;
  private static final String jdField_d_of_type_JavaLangString = "AccountManageActivity";
  public static final int e = 0;
  private static final String jdField_e_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/i18n/logoutApplication.html?uin=${uin}&language=${language}";
  public static final int f = 1;
  private static final String jdField_f_of_type_JavaLangString = "0X8004001";
  private static final boolean jdField_f_of_type_Boolean = true;
  public static final int g = 34;
  private static final String jdField_g_of_type_JavaLangString = "0X8004002";
  public static final int h = 250;
  private static final int i = 2010;
  public float a;
  long jdField_a_of_type_Long;
  public Dialog a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bxr(this);
  public View a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public ScrollView a;
  public TextView a;
  private bzb jdField_a_of_type_Bzb = new bzb(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new byl(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new byp(this);
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new byo(this);
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public SimpleAccount a;
  public ActionSheet a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new bxz(this);
  private float jdField_b_of_type_Float;
  public Dialog b;
  SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private Handler jdField_b_of_type_AndroidOsHandler = new bxp(this);
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new bxs(this);
  View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean b;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new byw(this);
  private View jdField_c_of_type_AndroidViewView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean c;
  private float jdField_d_of_type_Float;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new bxt(this);
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean d;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new bxu(this);
  private boolean jdField_e_of_type_Boolean = false;
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean = false;
  
  public AccountManageActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.g = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131230987);
    }
    return null;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.jdField_h_of_type_JavaLangString, new bza(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.jdField_h_of_type_JavaLangString);
    }
  }
  
  /* Error */
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_1
    //   5: ifnull +22 -> 27
    //   8: aload_1
    //   9: invokevirtual 233	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   12: invokevirtual 239	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore_1
    //   16: aload_1
    //   17: ldc 241
    //   19: invokevirtual 246	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 248	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   27: aload_2
    //   28: ifnull +31 -> 59
    //   31: aload_2
    //   32: invokeinterface 254 1 0
    //   37: ifle +22 -> 59
    //   40: iconst_1
    //   41: ireturn
    //   42: astore_2
    //   43: aload_1
    //   44: invokevirtual 248	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   47: aload_3
    //   48: astore_2
    //   49: goto -22 -> 27
    //   52: astore_2
    //   53: aload_1
    //   54: invokevirtual 248	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   57: aload_2
    //   58: athrow
    //   59: iconst_0
    //   60: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	AccountManageActivity
    //   0	61	1	paramQQAppInterface	QQAppInterface
    //   3	29	2	localObject1	Object
    //   42	1	2	localException	Exception
    //   48	1	2	localObject2	Object
    //   52	6	2	localObject3	Object
    //   1	47	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	23	42	java/lang/Exception
    //   16	23	52	finally
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131230999);
    }
    return null;
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (localObject != null) {
          ((FriendManager)localObject).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("AccountManageActivity", 2, "showLogoutDialog getCard Exception! ");
        }
      }
      this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
      this.jdField_b_of_type_AndroidAppDialog.setContentView(2130903162);
      TextView localTextView2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231469);
      if (localTextView2 == null) {
        break label193;
      }
      localTextView2.setText(getString(2131562327));
      localTextView2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231029);
      if (localTextView2 == null) {
        break label226;
      }
      localTextView2.requestFocus();
      localTextView2.setText(localException);
      localTextView2.setContentDescription(localException);
      TextView localTextView1 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231472);
      if (localTextView1 == null) {
        break label263;
      }
      localTextView1.setText(2131561746);
      localTextView1.setOnClickListener(new byx(this));
      localTextView1 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231473);
      if (localTextView1 == null) {
        break label300;
      }
      localTextView1.setText(2131561864);
      localTextView1.setOnClickListener(new bxq(this));
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
    localObject = String.format(getString(2131562368), new Object[0]);
    if (this.jdField_b_of_type_AndroidAppDialog != null)
    {
      localTextView2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231029);
      if (localTextView2 != null)
      {
        localTextView2.requestFocus();
        localTextView2.setText((CharSequence)localObject);
        localTextView2.setContentDescription((CharSequence)localObject);
      }
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    label193:
    label226:
    return;
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903073);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231029)).setText(getString(2131561934));
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      List localList = getAppRuntime().getApplication().getAllAccounts();
      if (localList != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(localList);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
      m();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      View localView;
      if (this.jdField_a_of_type_JavaUtilList.get(j) == null)
      {
        localView = getLayoutInflater().inflate(2130903067, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131230996));
        localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        localView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      for (;;)
      {
        j += 1;
        break;
        localView = getLayoutInflater().inflate(2130903068, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if (j == 0) {
          localView.setBackgroundResource(2130837880);
        }
        localView.setTag(Integer.valueOf(j));
        ((ImageView)localView.findViewById(2131230940)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localView.findViewById(2131230998)).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    n();
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int j;
    label28:
    View localView;
    SimpleAccount localSimpleAccount;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        j = 0;
        if (j >= k) {
          break;
        }
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject1 = localView.getTag();
      } while (localObject1 == null);
      int m = ((Integer)localObject1).intValue();
      localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    } while (localSimpleAccount == null);
    Object localObject1 = (ImageView)localView.findViewById(2131231002);
    ImageView localImageView = (ImageView)localView.findViewById(2131230940);
    TextView localTextView1 = (TextView)localView.findViewById(2131231000);
    TextView localTextView2 = (TextView)localView.findViewById(2131231001);
    ((ImageView)localObject1).clearAnimation();
    if ((localSimpleAccount.getUin() != null) && (localSimpleAccount.getUin().length() > 0) && (localSimpleAccount.getUin().equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (!this.jdField_c_of_type_Boolean)) {
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130840215));
    }
    for (;;)
    {
      localObject1 = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localSimpleAccount.getUin());
      Object localObject2 = SubAccountDataControll.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      try
      {
        if (((!localSimpleAccount.isLogined()) && ((localObject2 == null) || (((SubAccountInfo)localObject2).subuin == null) || (!((SubAccountInfo)localObject2).subuin.equalsIgnoreCase(localSimpleAccount.getUin())))) || ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(localSimpleAccount.getUin())))) {
          break label458;
        }
        localObject2 = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(localSimpleAccount.getUin());
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = localSimpleAccount.getUin();
      }
      localTextView1.setText((CharSequence)localObject2);
      if (1 < this.jdField_a_of_type_JavaUtilList.size()) {
        localView.setContentDescription("已选定" + (String)localObject2 + "可通过上下移动来选择其他帐号");
      }
      localTextView2.setText(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin()));
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin());
      if (localObject1 != null) {
        localImageView.setBackgroundDrawable((Drawable)localObject1);
      }
      j += 1;
      break label28;
      break;
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130840216));
    }
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("login_from_account_change", true);
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    }
    localIntent.putExtra("befault_uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    startActivityForResult(localIntent, 9876);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "onlogout");
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    startActivity(localIntent);
    finish();
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968587);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968588);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
  }
  
  private void r()
  {
    String str1 = "";
    SubAccountInfo localSubAccountInfo = SubAccountDataControll.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = str1;
    if (localSubAccountInfo != null)
    {
      localObject = str1;
      if (!TextUtils.isEmpty(localSubAccountInfo.subuin))
      {
        str1 = localSubAccountInfo.subname;
        String str2 = ContactUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localSubAccountInfo.subuin, true);
        localObject = str1;
        if (!TextUtils.isEmpty(str2)) {
          if (!TextUtils.isEmpty(localSubAccountInfo.subname))
          {
            localObject = str1;
            if (str2.equals(localSubAccountInfo.subname)) {}
          }
          else
          {
            localSubAccountInfo.subname = str2;
            localObject = str2;
          }
        }
      }
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号" + (String)localObject);
  }
  
  public long a(AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online) {}
    do
    {
      return 11L;
      if (paramStatus == AppRuntime.Status.invisiable) {
        return 41L;
      }
    } while (paramStatus != AppRuntime.Status.away);
    return 31L;
  }
  
  public void a()
  {
    q();
    TextView localTextView = this.m;
    localTextView.setVisibility(0);
    localTextView.setText(2131562001);
    localTextView.setOnClickListener(new byc(this));
    this.n = ((TextView)getLayoutInflater().inflate(2130903161, null));
    b(this.n);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231022));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)findViewById(2131231020));
    if (EUCountryUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()) != 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetScrollView.setOnTouchListener(new byq(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new byr(this));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(8.0F * this.jdField_c_of_type_Float));
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.n, (ViewGroup.LayoutParams)localObject);
    this.n.setVisibility(8);
    this.n.setText(2131561977);
    this.n.setOnClickListener(new bys(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231007));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131231009));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131231010));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_c_of_type_AndroidViewView = findViewById(2131231021);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new byu(this));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131231008));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new byv(this));
    k();
    localObject = getResources().getDisplayMetrics();
    this.jdField_d_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_b_of_type_Float = (this.jdField_d_of_type_Float - 110.0F * this.jdField_c_of_type_Float);
    localTextView.setContentDescription("编辑按钮");
    this.n.setContentDescription("完成");
    this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131562327));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号");
  }
  
  public void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2131689499);
      int j = 0;
      while (j < arrayOfString.length)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(arrayOfString[j], 1);
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
      this.jdField_a_of_type_Bzb.a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_Bzb);
      localObject = getString(2131561972).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)localObject);
    } while (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localSimpleAccount == null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = localSimpleAccount.getUin();
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_h_of_type_JavaLangString = str1;
    PrivacyDeclareHelper.a(this.jdField_h_of_type_JavaLangString);
    if (str1.equals(localObject))
    {
      getAppRuntime().logout(true);
      a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    a(this.jdField_h_of_type_JavaLangString, paramBoolean);
    HistoryChatMsgSearchKeyUtil.a(str1);
    this.jdField_a_of_type_JavaUtilList.remove(localSimpleAccount);
    String str2 = SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    SubAccountAssistantImpl localSubAccountAssistantImpl;
    QQAppInterface localQQAppInterface;
    long l;
    if ((str2 != null) && (str2.equalsIgnoreCase(str1)))
    {
      localObject = SubAccountAssistantImpl.a().a();
      localSubAccountAssistantImpl = SubAccountAssistantImpl.a();
      localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
      l = Long.parseLong(String.valueOf(str2));
      if (localObject != null) {
        break label313;
      }
    }
    label313:
    for (localObject = null;; localObject = HexUtil.a((String)localObject))
    {
      localSubAccountAssistantImpl.a(localQQAppInterface, (byte)0, l, (byte[])localObject, 21);
      SubAccountAssistantImpl.a().b(str2);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.O, 7000);
      if (SubAccountAssistantImpl.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false);
      }
      SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str2, null);
      GesturePWDUtils.clearGestureData(a(), localSimpleAccount.getUin());
      new Thread(new bxv(this, paramBoolean, str1, paramInt)).start();
      return;
    }
  }
  
  public void a(long paramLong)
  {
    AppRuntime.Status localStatus = AppRuntime.Status.offline;
    if (paramLong == 11L) {
      localStatus = AppRuntime.Status.online;
    }
    for (;;)
    {
      a(localStatus);
      return;
      if (paramLong == 41L) {
        localStatus = AppRuntime.Status.invisiable;
      } else if (paramLong == 31L) {
        localStatus = AppRuntime.Status.away;
      }
    }
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", 0);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundSettingActivity.f();
    BadgeUtils.d(paramQQAppInterface.a(), 0);
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("unreadcount", 0).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
    int j = QQSettingUtil.a(paramActivity, paramQQAppInterface.a());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.a(), j + 1);
    startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    finish();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new byy(this, paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void a(AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840344));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840346));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131562557) + getString(2131562854));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131562245) + getString(2131558457));
    }
    do
    {
      return;
      if (paramStatus == AppRuntime.Status.invisiable)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840346));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840344));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131562557) + getString(2131558457));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131562245) + getString(2131562854));
        return;
      }
    } while (paramStatus != AppRuntime.Status.away);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840346));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840346));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    label28:
    View localView;
    if (j < k)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
      if (localView.getTag() != null) {
        break label108;
      }
      if (!paramBoolean) {
        break label82;
      }
      localView.setOnClickListener(null);
      localView.setBackgroundResource(2130840178);
      localView.setEnabled(false);
    }
    for (;;)
    {
      j += 1;
      break label28;
      break;
      label82:
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setBackgroundResource(2130837877);
      localView.setEnabled(true);
      continue;
      label108:
      ImageView localImageView = (ImageView)localView.findViewById(2131231002);
      TextView localTextView = (TextView)localView.findViewById(2131231000);
      if (j == 0)
      {
        if (paramBoolean)
        {
          localView.setOnClickListener(null);
          localView.setBackgroundResource(2130840186);
          localImageView.setImageResource(2130840216);
        }
        else
        {
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localView.setBackgroundResource(2130837880);
        }
      }
      else if (paramBoolean)
      {
        localView.setOnClickListener(null);
        localView.setBackgroundResource(2130840184);
        localImageView.setImageResource(2130840216);
      }
      else
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setBackgroundResource(2130837879);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    label28:
    Object localObject2;
    if (j < k)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
      localObject1 = ((View)localObject2).getTag();
      if (localObject1 != null) {
        break label62;
      }
    }
    label62:
    ImageView localImageView1;
    ImageView localImageView2;
    RelativeLayout localRelativeLayout;
    ImageView localImageView3;
    for (;;)
    {
      j += 1;
      break label28;
      break;
      localImageView1 = (ImageView)((View)localObject2).findViewById(2131231002);
      localImageView2 = (ImageView)((View)localObject2).findViewById(2131230940);
      localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131230999);
      localImageView3 = (ImageView)((View)localObject2).findViewById(2131230998);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131230997);
      if ((localImageView2.getTag() == null) || (localRelativeLayout.getTag() == null))
      {
        localImageView2.setTag("left");
        localRelativeLayout.setTag("left");
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label257;
      }
      if (localImageView1.getDrawable() == getResources().getDrawable(2130840215)) {
        a(localImageView1, 2130968583, 5);
      }
      localImageView3.setVisibility(0);
      ((ImageView)localObject2).setVisibility(0);
      localImageView3.setImageResource(2130839712);
      a(localImageView3, 2130968584, 4);
      a((View)localObject2, 2130968584, 4);
      a(localImageView2, 2130968588, 0);
      a(localRelativeLayout, 2130968588, 0);
    }
    label257:
    localImageView3.setVisibility(8);
    ((ImageView)localObject2).setVisibility(8);
    int m = ((Integer)localObject1).intValue();
    Object localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    if ((localObject1 != null) && (((SimpleAccount)localObject1).getUin() != null) && (((SimpleAccount)localObject1).getUin().length() > 0) && (((SimpleAccount)localObject1).getUin().equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      localImageView1.setImageDrawable(getResources().getDrawable(2130840215));
    }
    for (;;)
    {
      if (localImageView1.getDrawable() == getResources().getDrawable(2130840215)) {
        a(localImageView1, 2130968584, 4);
      }
      a(localImageView3, 2130968583, 5);
      a((View)localObject2, 2130968583, 5);
      a(localImageView2, 2130968587, 1);
      a(localRelativeLayout, 2130968587, 1);
      break;
      localImageView1.setImageDrawable(getResources().getDrawable(2130840216));
    }
  }
  
  void b(boolean paramBoolean)
  {
    String str1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_h_of_type_JavaLangString = str1;
    PrivacyDeclareHelper.a(this.jdField_h_of_type_JavaLangString);
    getAppRuntime().logout(true);
    a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    a(this.jdField_h_of_type_JavaLangString, paramBoolean);
    HistoryChatMsgSearchKeyUtil.a(str1);
    String str2 = SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    SubAccountAssistantImpl localSubAccountAssistantImpl;
    QQAppInterface localQQAppInterface;
    long l;
    if ((str2 != null) && (str2.equalsIgnoreCase(str1)))
    {
      localObject = SubAccountAssistantImpl.a().a();
      localSubAccountAssistantImpl = SubAccountAssistantImpl.a();
      localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
      l = Long.parseLong(String.valueOf(str2));
      if (localObject != null) {
        break label237;
      }
    }
    label237:
    for (Object localObject = null;; localObject = HexUtil.a((String)localObject))
    {
      localSubAccountAssistantImpl.a(localQQAppInterface, (byte)0, l, (byte[])localObject, 21);
      SubAccountAssistantImpl.a().b(str2);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.O, 7000);
      if (SubAccountAssistantImpl.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false);
      }
      SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str2, null);
      GesturePWDUtils.clearGestureData(a(), str1);
      new Thread(new bxx(this, paramBoolean, str1)).start();
      return;
    }
  }
  
  void d()
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    int j = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    str = "http://fwd.3g.qq.com:8080/forward.jsp?bid=589&sid=" + str + "&currAppid=" + String.valueOf(j);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("title", getString(2131562416));
    localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    startActivity(localIntent.putExtra("url", str));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2010) {}
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 == 1000))
      {
        l();
        return;
      }
    } while ((paramInt2 != -1) || (paramInt1 != 9876));
    l();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903069);
    setTitle(2131561585);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    j(2130837729);
    a();
    r();
    l();
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_b_of_type_AndroidOsHandler);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    e();
    SubAccountBaseActivity.a = false;
    SubAccountBaseActivity.jdField_b_of_type_Boolean = false;
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SubAccountBaseActivity.jdField_b_of_type_Boolean = false;
    h();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label24:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void f()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131561705)).setMessage(getString(2131562487));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131561704), new bya(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131561746), new byb(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), d());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131563003);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  public void h()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  void i()
  {
    long l = System.currentTimeMillis();
    String str;
    if (ProfileActivity.a(this.jdField_a_of_type_Long, l))
    {
      this.jdField_a_of_type_Long = l;
      str = ((TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getStweb(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((str != null) && (str.length() != 0)) {
        break label64;
      }
      a(2131562038, 1);
    }
    label64:
    do
    {
      return;
      str = String.format("http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka", new Object[] { this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), str, "19", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid() });
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQLevelWeb() url = " + str);
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "QQ_rank", "click_qrank_in", 23, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, "getClientKey() time = " + System.currentTimeMillis());
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "onAccountChanged zsw");
    }
    super.onAccountChanged();
    String str1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    boolean bool = a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((TextUtils.isEmpty(str1)) || (str1.equals(str2)) || (bool) || (this.g) || (SubAccountBaseActivity.jdField_b_of_type_Boolean))
    {
      if (!this.jdField_e_of_type_Boolean) {
        break label376;
      }
      this.jdField_e_of_type_Boolean = false;
      n();
      label114:
      runOnUiThread(new bye(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_b_of_type_AndroidOsHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "onAccountChanged2");
      }
      r();
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.saveLastAccountState();
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
      }
      TroopNotificationHelper.a();
      if (bool) {
        break label383;
      }
      ThreadManager.b(new byf(this, str2));
    }
    for (;;)
    {
      new Handler().postDelayed(new byg(this), 500L);
      if (EUCountryUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 1) {
        break label401;
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.post(new byh(this));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetScrollView.setOnTouchListener(new byi(this));
      return;
      if (!SubAccountAssistantImpl.a().a())
      {
        SubAccountAssistantImpl.a().a(true);
        break;
      }
      this.jdField_h_of_type_Boolean = false;
      ReportController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
      e();
      break;
      label376:
      l();
      break label114;
      label383:
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "has subaccount");
      }
    }
    label401:
    this.jdField_a_of_type_AndroidWidgetScrollView.post(new byj(this));
    this.jdField_a_of_type_AndroidWidgetScrollView.setOnTouchListener(new byk(this));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  protected void onAccoutChangeFailed()
  {
    h();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    o();
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "zsw onAccoutChangeFailed");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 0) && (paramInt2 == 1)) {
      b(true);
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "zsw onLogout");
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void q_()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int j;
    label28:
    Object localObject2;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        j = 0;
        if (j >= k) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int m = ((Integer)localObject2).intValue();
      localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    } while (localObject2 == null);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131231002);
    if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (!this.jdField_c_of_type_Boolean)) {
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130840215));
    }
    for (;;)
    {
      j += 1;
      break label28;
      break;
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130840216));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */