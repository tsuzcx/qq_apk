package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import chy;
import chz;
import cib;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class SettingActivity2
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "SettingActivity2";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private cib jdField_a_of_type_Cib;
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public ContactBindObserver b;
  
  private void c()
  {
    setTitle(2131363840);
    this.h.setText("通讯录");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297417));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    e();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297418));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void e()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b();
    if ((1 != i) && (2 != i))
    {
      findViewById(2131297417).setVisibility(0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a();
      localObject = ((RespondQueryQQBindingStat)localObject).nationCode + " " + ((RespondQueryQQBindingStat)localObject).mobileNo;
      try
      {
        int j = ((String)localObject).length();
        localObject = ((String)localObject).substring(0, j - 5) + "****" + ((String)localObject).substring(j - 1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SettingActivity2", 2, localException.getMessage());
          QLog.d("SettingActivity2", 2, "error happend! contact bind state is : " + i);
        }
        findViewById(2131297417).setVisibility(8);
        return;
      }
    }
    findViewById(2131297417).setVisibility(8);
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this, BindNumberFromPcActivity.class);
    localIntent.putExtra("key_is_first_activity", true);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968635, 2130968589);
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_is_first_activity", true);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968635, 2130968589);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    e();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903265);
    c();
    this.jdField_a_of_type_Cib = new cib(this);
    this.app.a(SettingActivity2.class, this.jdField_a_of_type_Cib);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.a(SettingActivity2.class);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.b != null)
    {
      this.app.unRegistObserver(this.b);
      this.b = null;
    }
    this.app.a(SettingActivity2.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      throw new RuntimeException("unknown id: " + i);
    case 2131297417: 
      if (1 == this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b())
      {
        g();
        return;
      }
      if (2 == this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b())
      {
        f();
        return;
      }
      paramView = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
      paramView.a(2131363845, 1);
      paramView.setCanceledOnTouchOutside(true);
      paramView.a(new chy(this, paramView));
      paramView.d(2131362794);
      paramView.show();
      return;
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
    paramView.a(2131363843);
    paramView.setCanceledOnTouchOutside(true);
    paramView.a(2131363844, 3);
    paramView.a(new chz(this, paramView));
    paramView.d(2131362794);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2
 * JD-Core Version:    0.7.0.1
 */