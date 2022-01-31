package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PhoneLaunchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "key_is_first_activity";
  public static final String b = "k_start_number";
  private Button jdField_a_of_type_AndroidWidgetButton;
  
  private void c()
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
    if ((!bool) && (paramBundle == null) && ((!this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.e()) || (!this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.d())))
    {
      finish();
      return false;
    }
    if (bool)
    {
      paramBundle = ContactUtils.a(this.app, null);
      int i = Integer.valueOf(paramBundle[1]).intValue();
      int j = Integer.valueOf(paramBundle[2]).intValue();
      ContactUtils.a(this.app, System.currentTimeMillis(), i + 1, j);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.h();
    if (getIntent().getStringExtra("leftViewText") == null) {
      getIntent().putExtra("leftViewText", "联系人");
    }
    setContentView(2130903262);
    setTitle("启用通讯录");
    setLeftButton(2131363522, this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297413));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (getIntent().getBooleanExtra("k_start_number", false)) {
      c();
    }
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968589, 2130968639);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b();
      if (i == 1) {
        c();
      }
      for (;;)
      {
        paramView = this.app.a().getSharedPreferences("contact_bind_info" + this.app.getAccount(), 0).edit();
        paramView.putLong("contact_bind_strategy_user_closecount", 0L);
        paramView.commit();
        return;
        if (i == 2)
        {
          paramView = new Intent(this, BindNumberFromPcActivity.class);
          paramView.putExtra("key_is_first_activity", false);
          startActivityForResult(paramView, 1);
        }
        else
        {
          a("请求出错", "请稍后重试");
        }
      }
    }
    paramView = this.app.a().getSharedPreferences("contact_bind_info" + this.app.getAccount(), 0);
    long l = paramView.getLong("contact_bind_strategy_user_closecount", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneLaunchActivity", 2, "UserCloseCount=" + l);
    }
    paramView = paramView.edit();
    paramView.putLong("contact_bind_strategy_user_closecount", l + 1L);
    paramView.commit();
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity
 * JD-Core Version:    0.7.0.1
 */