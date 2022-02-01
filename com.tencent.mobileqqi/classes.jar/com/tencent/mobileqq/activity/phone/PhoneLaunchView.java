package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.statistics.ReportController;

@SuppressLint({"ViewConstructor"})
public class PhoneLaunchView
  extends BaseActivityView
  implements View.OnClickListener
{
  private static final int f = 1;
  private Button a;
  private boolean d;
  
  public PhoneLaunchView(Activity paramActivity, boolean paramBoolean)
  {
    super(paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a(2130903310);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131232041));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void j()
  {
    b(new Intent(getContext(), BindNumberActivity.class), 1);
    a(2130968681, 2130968595);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558976));
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).g(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.d) {
      j();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label25;
      }
      this.jdField_a_of_type_AndroidAppActivity.setResult(paramInt2);
      f();
    }
    label25:
    do
    {
      return;
      if (paramInt2 == -1)
      {
        a(new Intent(getContext(), ContactListView.class));
        return;
      }
    } while (paramInt2 != 1);
    f();
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("k_start_number", false))) {
      this.d = true;
    }
    if (paramIntent != null) {
      paramIntent.putExtra("call_by_select_member", paramIntent.getBooleanExtra("call_by_select_member", false));
    }
    super.a(paramIntent, paramPhoneInnerFrame);
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "QQPim", "Clk_address_on", 0, 0, "", "", "", "");
      if (i == 1) {
        j();
      }
    }
    else
    {
      return;
    }
    if (i == 2)
    {
      b(new Intent(getContext(), BindNumberFromPcActivity.class), 1);
      a(2130968681, 2130968595);
      return;
    }
    a(getResources().getString(2131558977), getResources().getString(2131558978));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchView
 * JD-Core Version:    0.7.0.1
 */