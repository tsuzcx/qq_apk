package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.ContactUtils;

public class PhoneLaunchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "key_is_first_activity";
  public static final String b = "k_start_number";
  private Button jdField_a_of_type_AndroidWidgetButton;
  
  private void e()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_is_first_activity", false);
    startActivityForResult(localIntent, 1);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 != 0)) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    boolean bool = getIntent().hasExtra("needAlert");
    if ((!bool) && (paramBundle == null) && ((!this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.f()) || (!this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.e())))
    {
      finish();
      return false;
    }
    if (bool)
    {
      paramBundle = ContactUtils.a(this.b, null);
      int i = Integer.valueOf(paramBundle[1]).intValue();
      int j = Integer.valueOf(paramBundle[2]).intValue();
      ContactUtils.a(this.b, System.currentTimeMillis(), i, j);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.j();
    if (getIntent().getStringExtra("leftViewText") == null) {
      getIntent().putExtra("leftViewText", getResources().getString(2131558972));
    }
    setContentView(2130903310);
    setTitle(getResources().getString(2131558973));
    a(2131561842, this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232042));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (getIntent().getBooleanExtra("k_start_number", false)) {
      e();
    }
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968595, 2130968683);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b();
      if (i == 1)
      {
        e();
        return;
      }
      if (i == 2)
      {
        paramView = new Intent(this, BindNumberFromPcActivity.class);
        paramView.putExtra("key_is_first_activity", false);
        startActivityForResult(paramView, 1);
        return;
      }
      a(getResources().getString(2131558974), getResources().getString(2131558975));
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity
 * JD-Core Version:    0.7.0.1
 */