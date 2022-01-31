package com.tencent.mobileqq.activity.phone;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import eqe;
import eqf;

public class PhoneMatchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private Button a;
  public ContactBindObserver a;
  
  private void e()
  {
    this.l.setText(getResources().getString(2131558979));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232046));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(2131561842, this);
  }
  
  private void f()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131562488);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new eqe(this);
      this.b.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.b.a(new eqf(this));
    a(2131562875, 1000L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if ((paramBundle == null) && ((!this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.f()) || (!this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.e())))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.j();
    c(2130903309);
    e();
    return true;
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.b.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968590);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      f();
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity
 * JD-Core Version:    0.7.0.1
 */