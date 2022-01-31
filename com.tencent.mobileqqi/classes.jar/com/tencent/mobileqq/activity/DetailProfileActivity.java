package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import cmk;
import cmm;
import cmn;
import cmo;
import cmp;
import cmq;
import cmr;
import cms;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.TimePickerView;
import mqq.manager.AccountManager;

public class DetailProfileActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public byte a;
  public int a;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new cmm(this);
  private View jdField_a_of_type_AndroidViewView;
  public CardHandler a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new cmq(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new cms(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new cmr(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public String a;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new cmn(this);
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public String b;
  private FormSimpleItem c;
  public String c;
  private FormSimpleItem d;
  
  public DetailProfileActivity()
  {
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  private void d()
  {
    setContentView(2130903602);
    setTitle(2131562005);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131230989));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232613));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131233040));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.d = ((FormSimpleItem)findViewById(2131233041));
    this.d.setOnClickListener(this);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131233039);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837875);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput = DialogUtil.a(this, 2131562466, null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
  }
  
  private void f()
  {
    new TimePickerView(this, ProfileUtil.b(this.jdField_a_of_type_Int), ProfileUtil.c(this.jdField_a_of_type_Int), ProfileUtil.d(this.jdField_a_of_type_Int), new cmo(this)).b();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a()))
    {
      Intent localIntent = new Intent(a(), EditActivity.class);
      localIntent.putExtra("k_source", 1);
      startActivity(localIntent);
    }
  }
  
  private void h()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid()))
    {
      AccountManager localAccountManager = (AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
      if (localAccountManager != null) {
        localAccountManager.updateSid(null);
      }
      a(2131561772, 0);
      return;
    }
    ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private void i()
  {
    boolean bool2 = true;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    Object localObject = getResources().getStringArray(2131689498);
    CharSequence localCharSequence = localObject[0];
    if (this.jdField_a_of_type_Byte == 0)
    {
      bool1 = true;
      localActionSheet.a(localCharSequence, bool1);
      localObject = localObject[1];
      if (this.jdField_a_of_type_Byte != 1) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localActionSheet.a((CharSequence)localObject, bool1);
      localActionSheet.a(new cmp(this, localActionSheet));
      localActionSheet.d(2131561746);
      localActionSheet.show();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {}
    for (RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a();; localRichStatus = null)
    {
      ProfileCardUtil.a(getResources(), this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, localRichStatus, true);
      return;
    }
  }
  
  public void a(byte paramByte)
  {
    String str1;
    if (paramByte == 0) {
      str1 = getString(2131562338);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(str1);
      String str2 = getString(2131558415) + getString(2131558413);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str2 + str1);
      return;
      if (paramByte == 1) {
        str1 = getString(2131562104);
      } else {
        str1 = getString(2131562007);
      }
    }
  }
  
  public void a(int paramInt)
  {
    String str1 = ProfileUtil.a(paramInt);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(str1);
    String str2 = getString(2131558416) + getString(2131558413);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str2 + str1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ProfileUtil.a(paramInt1, paramInt2, paramInt3);
    if (paramInt1 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_Int, null);
      a(this.jdField_a_of_type_Int);
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initCard()");
    }
    new cmk(this, paramString).start();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramString);
    String str = getString(2131558414) + getString(2131558413);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str + paramString);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringExtra("result");; paramIntent = null)
    {
      if (paramIntent == null) {
        paramIntent = "";
      }
      while ((!paramIntent.equals(this.jdField_b_of_type_JavaLangString)) && (!"".equals(paramIntent.trim())))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler == null)
        {
          a(2131561424, 1);
          return;
        }
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          this.jdField_b_of_type_JavaLangString = paramIntent;
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_b_of_type_JavaLangString, null);
          b(this.jdField_b_of_type_JavaLangString);
          return;
        }
        a(2131562445, 1);
        return;
      }
      break;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
    a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Byte = -1;
    d();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = null;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      g();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004179", "0X8004179", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem)
      {
        e();
        return;
      }
      if (paramView == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem)
      {
        i();
        return;
      }
      if (paramView == this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem)
      {
        f();
        return;
      }
    } while (paramView != this.d);
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DetailProfileActivity
 * JD-Core Version:    0.7.0.1
 */