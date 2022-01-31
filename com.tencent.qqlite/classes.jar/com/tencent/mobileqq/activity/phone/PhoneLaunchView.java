package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.statistics.ReportController;

@SuppressLint({"ViewConstructor"})
public class PhoneLaunchView
  extends BaseActivityView
  implements View.OnClickListener
{
  private static final int g = 1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private boolean jdField_a_of_type_Boolean;
  
  public PhoneLaunchView(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    a(2130903262);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131297409));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void j()
  {
    b(new Intent(getContext(), BindNumberActivity.class), 1);
    a(2130968639, 2130968589);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Int == 3) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("通讯录");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean) {
        j();
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("启用通讯录");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label26;
      }
      this.jdField_a_of_type_AndroidAppActivity.setResult(paramInt2);
      f();
    }
    label26:
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
      this.jdField_a_of_type_Boolean = true;
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
      a(2130968639, 2130968589);
      return;
    }
    a("请求出错", "请稍后重试");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchView
 * JD-Core Version:    0.7.0.1
 */