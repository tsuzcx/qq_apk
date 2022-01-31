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
import android.view.View.OnTouchListener;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
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
import va;
import vb;
import vc;
import vd;
import ve;
import vg;
import vh;
import vi;
import vj;
import vm;
import vo;
import vq;
import vr;
import vs;
import vt;
import vu;
import vw;
import vx;
import vz;
import wa;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 9876;
  public static final String a = "IS_ADD_ACCOUNT";
  public static final int b = 999;
  public static final String b = "is_change_account";
  public static final int c = 34;
  public static final String c = "login_from_account_change";
  public static final int d = 250;
  private static final String jdField_d_of_type_JavaLangString = "AccountManageActivity";
  private static final int jdField_e_of_type_Int = 2010;
  public float a;
  long jdField_a_of_type_Long;
  public Dialog a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = new va(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vw(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new vu(this);
  public View a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new vj(this);
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public SimpleAccount a;
  public ActionSheet a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new vg(this);
  private wa jdField_a_of_type_Wa = new wa(this);
  public boolean a;
  private float jdField_b_of_type_Float;
  public Dialog b;
  SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new vb(this);
  View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean b;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new vr(this);
  private View jdField_c_of_type_AndroidViewView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean c;
  private float jdField_d_of_type_Float;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new vc(this);
  private boolean jdField_d_of_type_Boolean = false;
  private String jdField_e_of_type_JavaLangString;
  private View.OnClickListener f = new vd(this);
  
  public AccountManageActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131296441);
    }
    return null;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.e, new vz(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.e);
    }
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131296454);
    }
    return null;
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    Object localObject = String.format(getString(2131363744), new Object[0]);
    if (this.jdField_b_of_type_AndroidAppDialog != null)
    {
      localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296470);
      if (localTextView != null)
      {
        localTextView.requestFocus();
        localTextView.setText((CharSequence)localObject);
        localTextView.setContentDescription((CharSequence)localObject);
      }
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131624119);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2130903135);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296911);
    if (localTextView != null) {
      localTextView.setText(getString(2131363742));
    }
    localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296470);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296914);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131362794);
      ((TextView)localObject).setOnClickListener(new vs(this));
    }
    localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296915);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131363743);
      ((TextView)localObject).setOnClickListener(new vt(this));
    }
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624119);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903049);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296470)).setText(getString(2131363251));
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      List localList = getAppRuntime().getApplication().getAllAccounts();
      if (localList == null) {
        break;
      }
      int i = 0;
      while (i < localList.size())
      {
        this.jdField_a_of_type_JavaUtilList.add(localList.get(i));
        this.jdField_a_of_type_JavaUtilList.add(null);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.add(null);
    }
    k();
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject;
      if ((i != this.jdField_a_of_type_JavaUtilList.size() - 1) && (this.jdField_a_of_type_JavaUtilList.get(i) == null))
      {
        localObject = new ImageView(this);
        ((ImageView)localObject).setBackgroundResource(2130837991);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
        localLayoutParams.setMargins((int)this.jdField_c_of_type_Float * 15, 0, (int)this.jdField_c_of_type_Float * 15, 0);
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((i == this.jdField_a_of_type_JavaUtilList.size() - 1) && (this.jdField_a_of_type_JavaUtilList.get(i) == null))
        {
          localObject = getLayoutInflater().inflate(2130903043, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131296450));
          ((View)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          ((View)localObject).setTag(null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        }
        else
        {
          localObject = getLayoutInflater().inflate(2130903044, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
          ((View)localObject).setTag(Integer.valueOf(i));
          ((ImageView)((View)localObject).findViewById(2131296453)).setScaleType(ImageView.ScaleType.FIT_CENTER);
          ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          ((Button)((View)localObject).findViewById(2131296442)).setOnClickListener(this.f);
          ((ImageView)((View)localObject).findViewById(2131296452)).setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        }
      }
    }
    l();
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int i;
    label28:
    Object localObject1;
    SimpleAccount localSimpleAccount;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        i = 0;
        if (i >= k) {
          break;
        }
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject1 = localView.getTag();
      } while (localObject1 == null);
      j = ((Integer)localObject1).intValue();
      localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(j);
    } while (localSimpleAccount == null);
    localImageView2 = (ImageView)localView.findViewById(2131296457);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131296453);
    TextView localTextView1 = (TextView)localView.findViewById(2131296455);
    TextView localTextView2 = (TextView)localView.findViewById(2131296456);
    localImageView2.clearAnimation();
    if ((localSimpleAccount.getUin() != null) && (localSimpleAccount.getUin().length() > 0) && (localSimpleAccount.getUin().equals(this.app.a())) && (!this.jdField_a_of_type_Boolean)) {
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = ContactUtils.g(this.app, localSimpleAccount.getUin());
      try
      {
        if ((!localSimpleAccount.isLogined()) || ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(localSimpleAccount.getUin())))) {
          break label369;
        }
        localObject2 = ((FriendManager)this.app.getManager(8)).a(localSimpleAccount.getUin());
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localException.printStackTrace();
          continue;
          if (localImageView2.getVisibility() == 0) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label420;
            }
            localView.setContentDescription(localException + "已登录");
            break;
          }
          localView.setContentDescription(localException + "未登录");
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = localSimpleAccount.getUin();
      }
      localTextView1.setText((CharSequence)localObject2);
      if (!this.jdField_a_of_type_Boolean) {
        break label372;
      }
      localView.setContentDescription((CharSequence)localObject2);
      localTextView2.setText(this.app.b(localSimpleAccount.getUin()));
      localObject1 = this.app.b(localSimpleAccount.getUin());
      if (localObject1 != null) {
        localImageView1.setBackgroundDrawable((Drawable)localObject1);
      }
      i += 2;
      break label28;
      break;
      localImageView2.setVisibility(8);
    }
  }
  
  private void m()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("login_from_account_change", true);
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    }
    localIntent.putExtra("befault_uin", this.app.a());
    startActivityForResult(localIntent, 9876);
  }
  
  private void n()
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
  
  private void o()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968581);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968582);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
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
    o();
    TextView localTextView = this.j;
    localTextView.setVisibility(0);
    localTextView.setText(2131363436);
    localTextView.setOnClickListener(new vm(this));
    this.k = ((TextView)getLayoutInflater().inflate(2130903133, null));
    setLayerType(this.k);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(8.0F * this.jdField_c_of_type_Float));
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.k, (ViewGroup.LayoutParams)localObject);
    this.k.setVisibility(8);
    this.k.setText(2131363433);
    this.k.setOnClickListener(new vo(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296458));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296459));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296460));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    a(this.app.a());
    this.jdField_c_of_type_AndroidViewView = findViewById(2131296463);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new vq(this));
    i();
    localObject = getResources().getDisplayMetrics();
    this.jdField_d_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_b_of_type_Float = (this.jdField_d_of_type_Float - 110.0F * this.jdField_c_of_type_Float);
    localTextView.setContentDescription("编辑按钮");
    this.k.setContentDescription("完成");
    this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131363742));
  }
  
  public void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624119));
      String[] arrayOfString = getResources().getStringArray(2131230728);
      int i = 0;
      while (i < arrayOfString.length)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(arrayOfString[i], 1);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362794);
      this.jdField_a_of_type_Wa.a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_Wa);
      localObject = getString(2131362926).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)localObject);
    } while (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = ((SimpleAccount)localObject).getUin();
    String str2 = this.app.a();
    this.e = str1;
    if (str1.equals(str2))
    {
      getAppRuntime().logout(true);
      a(this, this.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    a(this.e, paramBoolean);
    HistoryChatMsgSearchKeyUtil.a(str1);
    this.jdField_a_of_type_JavaUtilList.remove(localObject);
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    GesturePWDUtils.clearGestureData(getActivity(), ((SimpleAccount)localObject).getUin());
    if (str1.equals(str2))
    {
      this.app.getApplication().refreAccountList();
      localObject = getAppRuntime().getApplication().getAllAccounts();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (((SimpleAccount)localObject).isLogined()) {
          getAppRuntime().startPCActivePolling(((SimpleAccount)localObject).getUin(), "delAccount");
        }
      }
    }
    new Thread(new ve(this, paramBoolean, str1, paramInt)).start();
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
    BadgeUtils.a(paramQQAppInterface.a(), 0);
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("unreadcount", 0).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
    int i = QQSettingUtil.a(paramActivity, paramQQAppInterface.a());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.a(), i + 1);
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
        ((Animation)localObject).setAnimationListener(new vx(this, paramView, paramInt2));
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
    paramString = this.app.a().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void a(AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363028) + getString(2131364358));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363030) + getString(2131364359));
    }
    do
    {
      return;
      if (paramStatus == AppRuntime.Status.invisiable)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363028) + getString(2131364359));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363030) + getString(2131364358));
        return;
      }
    } while (paramStatus != AppRuntime.Status.away);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    label28:
    View localView;
    if (i < j)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (localView.getTag() != null) {
        break label92;
      }
      if (!paramBoolean) {
        break label74;
      }
      localView.setOnClickListener(null);
      localView.setEnabled(false);
    }
    for (;;)
    {
      i += 2;
      break label28;
      break;
      label74:
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setEnabled(true);
      continue;
      label92:
      ImageView localImageView = (ImageView)localView.findViewById(2131296457);
      if (i == 0)
      {
        if (paramBoolean)
        {
          localView.setOnClickListener(null);
          localImageView.setImageResource(2130839426);
        }
        else
        {
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localImageView.setImageResource(2130839427);
        }
      }
      else if (paramBoolean)
      {
        localView.setOnClickListener(null);
        localImageView.setImageResource(2130839426);
      }
      else
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localImageView.setImageResource(2130839427);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    label28:
    Object localObject2;
    if (i < j)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
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
      i += 2;
      break label28;
      break;
      localImageView1 = (ImageView)((View)localObject2).findViewById(2131296457);
      localImageView2 = (ImageView)((View)localObject2).findViewById(2131296453);
      localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131296454);
      localImageView3 = (ImageView)((View)localObject2).findViewById(2131296452);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131296451);
      if ((localImageView2.getTag() == null) || (localRelativeLayout.getTag() == null))
      {
        localImageView2.setTag("left");
        localRelativeLayout.setTag("left");
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label246;
      }
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2130968577, 5);
      }
      localImageView3.setVisibility(0);
      ((ImageView)localObject2).setVisibility(0);
      localImageView3.setImageResource(2130839120);
      a(localImageView3, 2130968578, 4);
      a((View)localObject2, 2130968578, 4);
      a(localImageView2, 2130968582, 0);
      a(localRelativeLayout, 2130968582, 0);
    }
    label246:
    localImageView3.setVisibility(8);
    ((ImageView)localObject2).setVisibility(8);
    int k = ((Integer)localObject1).intValue();
    Object localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    if ((localObject1 != null) && (((SimpleAccount)localObject1).getUin() != null) && (((SimpleAccount)localObject1).getUin().length() > 0) && (((SimpleAccount)localObject1).getUin().equals(this.app.a()))) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2130968578, 4);
      }
      a(localImageView3, 2130968577, 5);
      a((View)localObject2, 2130968577, 5);
      a(localImageView2, 2130968581, 1);
      a(localRelativeLayout, 2130968581, 1);
      break;
      localImageView1.setVisibility(8);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int i;
    label28:
    Object localObject2;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        i = 0;
        if (i >= j) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int k = ((Integer)localObject2).intValue();
      localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    } while (localObject2 == null);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131296457);
    if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.a())) && (!this.jdField_a_of_type_Boolean)) {
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      i += 2;
      break label28;
      break;
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  void d()
  {
    String str = this.app.getSid();
    int i = this.app.a();
    str = "http://fwd.3g.qq.com:8080/forward.jsp?bid=589&sid=" + str + "&currAppid=" + String.valueOf(i);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("title", getString(2131363748));
    localIntent.putExtra("uin", this.app.a());
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
        j();
        return;
      }
    } while ((paramInt2 != -1) || (paramInt1 != 9876));
    j();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903045);
    setTitle(2131364286);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    d(2130837635);
    a();
    j();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.a(getClass());
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
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
    l();
    f();
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363834);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
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
  
  public void f()
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
  
  void g()
  {
    long l = System.currentTimeMillis();
    String str;
    if (ProfileActivity.a(this.jdField_a_of_type_Long, l))
    {
      this.jdField_a_of_type_Long = l;
      str = ((TicketManager)this.app.getManager(2)).getStweb(this.app.a());
      if ((str != null) && (str.length() != 0)) {
        break label64;
      }
      a(2131363893, 1);
    }
    label64:
    do
    {
      return;
      str = String.format("http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka", new Object[] { this.app.a(), str, "19", this.app.getSid() });
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQLevelWeb() url = " + str);
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 23, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, "getClientKey() time = " + System.currentTimeMillis());
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "onAccountChanged zsw");
    }
    super.onAccountChanged();
    this.app.a(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      l();
    }
    for (;;)
    {
      runOnUiThread(new vh(this, this.app.a()));
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "onAccountChanged2");
      }
      if (this.app != null)
      {
        this.app.saveLastAccountState();
        this.app.getApplication().refreAccountList();
      }
      TroopNotificationHelper.a();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vi(this), 500L);
      return;
      j();
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    f();
    this.jdField_d_of_type_Boolean = false;
    m();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if ((paramLogoutReason == Constants.LogoutReason.user) && (QLog.isColorLevel())) {
      QLog.d("", 2, "zsw onLogout");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */