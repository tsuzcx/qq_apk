package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import bhk;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.observer.WtloginObserver;

public class RegisterPersonalInfoActivity
  extends RegisterBaseActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "RegisterPersonalInfoActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new bhk(this);
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private ClearableEditText jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText;
  private String jdField_b_of_type_JavaLangString = "";
  private String f = null;
  
  protected boolean b()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        a(2131362797, 0);
        return;
      }
      paramView = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if ((TextUtils.isEmpty(paramView)) || (paramView.trim().length() == 0))
      {
        a(2131363355, 1);
        return;
      }
      try
      {
        a(2131363315);
        if (PhoneNumLoginImpl.a().a(this.app, this.jdField_b_of_type_JavaLangString.getBytes(), paramView.getBytes(), this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
        {
          g();
          a(2131363296, 1);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130903579));
    setTitle(2131363339);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key_register_smscode");
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    this.c = getIntent().getStringExtra("phonenum");
    this.d = getIntent().getStringExtra("key");
    this.e = getIntent().getStringExtra("key_register_now_account");
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298614));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298616));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */