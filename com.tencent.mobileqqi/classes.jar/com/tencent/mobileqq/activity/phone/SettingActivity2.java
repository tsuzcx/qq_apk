package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import eqj;
import eqk;

public class SettingActivity2
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "SettingActivity2";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private SettingActivity2.UiHandler jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2$UiHandler;
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public ContactBindObserver b;
  
  private void e()
  {
    setTitle(2131562573);
    this.k.setText(getResources().getString(2131558983));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232050));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    f();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232051));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void f()
  {
    if ((1 != this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b()) && (2 != this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b()))
    {
      findViewById(2131232050).setVisibility(0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a();
      localObject = ((RespondQueryQQBindingStat)localObject).nationCode + " " + ((RespondQueryQQBindingStat)localObject).mobileNo;
      int i = ((String)localObject).length();
      localObject = ((String)localObject).substring(0, i - 5) + "****" + ((String)localObject).substring(i - 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      return;
    }
    findViewById(2131232050).setVisibility(8);
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this, BindNumberFromPcActivity.class);
    localIntent.putExtra("key_is_first_activity", true);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968681, 2130968595);
  }
  
  private void h()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_is_first_activity", true);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968681, 2130968595);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    f();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903311);
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2$UiHandler = new SettingActivity2.UiHandler(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(SettingActivity2.class, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2$UiHandler);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(SettingActivity2.class);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(SettingActivity2.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      throw new RuntimeException("unknown id: " + i);
    case 2131232050: 
      if (1 == this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b())
      {
        h();
        return;
      }
      if (2 == this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b())
      {
        g();
        return;
      }
      paramView = (ActionSheet)ActionSheetHelper.a(this, null);
      paramView.a(2131563090, 1);
      paramView.setCanceledOnTouchOutside(true);
      paramView.a(new eqj(this, paramView));
      paramView.d(2131561746);
      paramView.show();
      return;
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this, null);
    paramView.a(2131561621);
    paramView.setCanceledOnTouchOutside(true);
    paramView.a(2131562545, 3);
    paramView.a(new eqk(this, paramView));
    paramView.d(2131561746);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2
 * JD-Core Version:    0.7.0.1
 */