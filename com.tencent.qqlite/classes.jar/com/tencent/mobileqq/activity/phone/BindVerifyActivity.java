package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import cgf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final String a = "k_number";
  public int a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  
  public BindVerifyActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void e()
  {
    setTitle("验证手机号码");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297395));
    String str = getIntent().getStringExtra("k_number");
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362087, new Object[] { str }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297396));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297387));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_a_of_type_Boolean) {
        findViewById(2131297397).setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131297389));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.b = ((TextView)findViewById(2131297390));
      this.b.setOnClickListener(this);
      return;
      if (1 == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362088, new Object[] { str }));
      }
    }
  }
  
  private void f()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131363449);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new cgf(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_Int);
    b(2131363378, 1000L);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() >= 4))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903255);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kBindType", 0);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("kShowAgree", false);
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox) {
      c();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131297388: 
    case 2131297389: 
    default: 
      return;
    case 2131297387: 
      f();
      return;
    }
    paramView = new Intent(this, TosActivity.class);
    paramView.putExtra("frombusiness", 0);
    startActivity(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */