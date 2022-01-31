package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import czc;
import cze;
import czf;
import czg;
import czh;
import czm;
import czn;

public class PermisionPrivacyActivity
  extends DialogBaseActivity
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "Q.security";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new czh(this);
  public View a;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new czf(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new cze(this);
  public ContactBindObserver a;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new czm(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private czn jdField_a_of_type_Czn;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public FormSwitchItem b;
  View jdField_c_of_type_AndroidViewView;
  private CompoundButton jdField_c_of_type_AndroidWidgetCompoundButton;
  public FormSwitchItem c;
  public View d;
  public FormSwitchItem d;
  private View e;
  
  public PermisionPrivacyActivity()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new czg(this);
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void c(int paramInt)
  {
    QQToast.a(a(), paramInt, 0).b(d());
  }
  
  private void f()
  {
    this.jdField_d_of_type_AndroidViewView = findViewById(2131233127);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232053));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131233126);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131233130));
    if (((ContactSyncManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39)).d())
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131233132));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131233134));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131233135));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131233136));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131233129));
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.o());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.q());
      a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.n());
      ThreadManager.b(new czc(this));
      this.jdField_b_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b())) {
        break label429;
      }
    }
    label429:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.e = findViewById(2131233128);
      this.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      g();
      this.jdField_d_of_type_AndroidViewView.setContentDescription("动态权限设置");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("你的手机号");
      this.jdField_a_of_type_AndroidViewView.setContentDescription("加好友设置");
      this.e.setContentDescription("管理陌生人");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("可通过系统通讯录发起QQ聊天");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("个性签名同步到说说");
      return;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break;
    }
  }
  
  private void g()
  {
    if ((1 != this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b()) && (2 != this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b()))
    {
      findViewById(2131232053).setVisibility(0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a();
      if (localObject == null) {
        findViewById(2131232053).setVisibility(8);
      }
      localObject = ((RespondQueryQQBindingStat)localObject).nationCode + " " + ((RespondQueryQQBindingStat)localObject).mobileNo;
      int i = ((String)localObject).length();
      localObject = ((String)localObject).substring(0, i - 5) + "****" + ((String)localObject).substring(i - 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      return;
    }
    findViewById(2131232053).setVisibility(8);
  }
  
  private void h()
  {
    Intent localIntent = new Intent(this, BindNumberFromPcActivity.class);
    localIntent.putExtra("key_is_first_activity", true);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968681, 2130968595);
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_is_first_activity", true);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968681, 2130968595);
  }
  
  void A_()
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    int i = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    str = "http://fwd.3g.qq.com:8080/forward.jsp?bid=589&sid=" + str + "&currAppid=" + String.valueOf(i);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("title", getString(2131562416));
    startActivity(localIntent.putExtra("url", str));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean);
    if (paramBoolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  protected String a_()
  {
    return getString(2131562592);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("title", getString(2131561598));
    startActivity(localIntent.putExtra("url", "http://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    g();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903626);
    setTitle(2131562592);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    f();
    a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.s();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.t();
    this.jdField_a_of_type_Czn = new czn(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(PermisionPrivacyActivity.class, this.jdField_a_of_type_Czn);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(PermisionPrivacyActivity.class);
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(PermisionPrivacyActivity.class);
    super.doOnDestroy();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  void e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */