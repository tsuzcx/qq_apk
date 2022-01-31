package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import eqg;
import eqh;

@SuppressLint({"ViewConstructor"})
public class PhoneMatchView
  extends BaseActivityView
  implements View.OnClickListener
{
  private static final int f = 1;
  private Button a;
  public ContactBindObserver a;
  
  public PhoneMatchView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    a(2130903309, true);
    j();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131232046));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void k()
  {
    if (!NetworkUtil.e(getContext()))
    {
      b(2131562488);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new eqg(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new eqh(this));
    a(2131562875, 1000L, true);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558980));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562896);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      if (paramInt2 == 2)
      {
        paramIntent = new Intent(getContext(), BindNumberActivity.class);
        paramIntent.putExtra("kNeedUnbind", true);
        paramIntent.putExtra("key_is_first_activity", false);
        a(paramIntent);
      }
    }
    else {
      return;
    }
    a(new Intent(getContext(), PhoneLaunchActivity.class));
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.d();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      k();
      return;
    }
    b(new Intent(getContext(), SettingActivity2.class), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView
 * JD-Core Version:    0.7.0.1
 */