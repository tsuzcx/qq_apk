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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import ekl;
import ekn;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener, SMSBodyObserver
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
  
  private void f()
  {
    setTitle(getResources().getString(2131558961));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232025));
    String str = getIntent().getStringExtra("k_number");
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131559979, new Object[] { str }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131232026));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232017));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_a_of_type_Boolean) {
        findViewById(2131232027).setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131232019));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232020));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
      if (1 == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131559980, new Object[] { str }));
      }
    }
  }
  
  private void g()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131562488);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ekl(this);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_Int);
    a(2131562875, 1000L);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    e();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903303);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kBindType", 0);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("kShowAgree", false);
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.doOnDestroy();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() >= 4))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new ekn(this, paramString1, paramString2));
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox) {
      e();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131232018: 
    case 2131232019: 
    default: 
      return;
    case 2131232017: 
      g();
      return;
    }
    startActivity(new Intent(this, TosActivity.class));
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */