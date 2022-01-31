package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import baj;
import bal;
import bam;
import ban;
import bao;
import bap;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "Q.security";
  View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ban(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bal(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new bam(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new bap(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public FormSwitchItem a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected QQProgressNotifier a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  View b;
  public FormSwitchItem b;
  public FormSwitchItem c;
  public FormSwitchItem d;
  public FormSwitchItem e;
  
  public PermisionPrivacyActivity()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new bao(this);
  }
  
  private void a(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void f()
  {
    this.d = ((FormSwitchItem)findViewById(2131298441));
    Object localObject = (ContactSyncManager)this.app.getManager(37);
    if (((ContactSyncManager)localObject).d())
    {
      this.d.setChecked(((ContactSyncManager)localObject).c());
      this.d.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.c = ((FormSwitchItem)findViewById(2131298442));
      this.c.setChecked(this.app.c(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298443));
      this.b = ((FormSwitchItem)findViewById(2131298445));
      ((CardHandler)this.app.a(2)).h();
      this.e = ((FormSwitchItem)findViewById(2131298440));
      localObject = this.e;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b())) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      b(this.app.p());
      a(this.app.o());
      ThreadManager.b(new baj(this));
      this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.c.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.e.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.d.setContentDescription("可通过系统通讯录发起QQ聊天");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("对附近的人可见");
      this.c.setContentDescription("向好友展示网络状态");
      this.b.setContentDescription("允许附近的人赞我");
      this.e.setContentDescription("个性签名同步到说说");
      return;
      this.d.setVisibility(8);
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
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
      this.b.setVisibility(0);
      findViewById(2131298444).setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
    findViewById(2131298444).setVisibility(8);
  }
  
  public void b(boolean paramBoolean) {}
  
  protected String b_()
  {
    return getString(2131364282);
  }
  
  void c()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("title", getString(2131364287));
    startActivity(localIntent.putExtra("url", "http://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  void d()
  {
    String str = this.app.getSid();
    int i = this.app.a();
    str = "http://fwd.3g.qq.com:8080/forward.jsp?bid=589&sid=" + str + "&currAppid=" + String.valueOf(i);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("title", getString(2131363748));
    startActivity(localIntent.putExtra("url", str));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903538);
    setTitle(2131364282);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    f();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.q();
    this.app.r();
    this.app.c(true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */