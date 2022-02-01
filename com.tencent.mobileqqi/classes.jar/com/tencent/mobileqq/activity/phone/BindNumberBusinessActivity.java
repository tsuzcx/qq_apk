package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
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
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import ekf;
import ekg;
import ekh;
import eki;

public class BindNumberBusinessActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  static final int jdField_a_of_type_Int = 1;
  protected static final String a = "BindNumberBusinessActivity";
  static final int jdField_b_of_type_Int = 2;
  static final int jdField_c_of_type_Int = 3;
  static final int jdField_d_of_type_Int = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 2;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public EditText a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public QQProgressDialog a;
  boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private int l;
  
  public BindNumberBusinessActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_JavaLangString = "+86";
    this.d = "中国";
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, BindNumberBusinessActivity.class);
    localIntent.putExtra("phone_number", paramString);
    localIntent.putExtra("cmd_param_bind_type", 1);
    localIntent.putExtra("unbind", paramBoolean);
    paramActivity.startActivity(localIntent);
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_Boolean) {
      setTitle("更换手机号码");
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        a(2131561746, null);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232015));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558954) + " " + this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131232016));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
      this.jdField_a_of_type_AndroidViewView = findViewById(2131232018);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131232019));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("已同意");
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232020));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232017));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      if (this.jdField_c_of_type_JavaLangString != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
      }
      return;
      setTitle(getResources().getString(2131558955));
    }
  }
  
  private void f()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("+86")) && (this.jdField_c_of_type_JavaLangString.length() != 11))
    {
      b(2131559978);
      return;
    }
    g();
  }
  
  private void g()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131562488);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  void a(int paramInt)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new ekg(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  protected void a(int paramInt, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramInt, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2) && (paramInt2 != 0))
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("unbind", false);
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("phone_number");
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_is_first_activity", false);
      this.l = getIntent().getIntExtra("cmd_param_bind_type", 1);
    }
    setContentView(2130903301);
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
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
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new ekf(this), 300L);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_b_of_type_Boolean) {
      overridePendingTransition(2130968595, 2130968683);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      a(paramMessage.arg1);
    }
    do
    {
      return true;
      finish();
      return true;
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ekh(this);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      paramMessage = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      a(2131562875, 1000L);
      paramMessage.b(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.l);
      return true;
      paramMessage = new Intent(this, BindVerifyActivity.class);
      paramMessage.putExtra("kBindType", this.l);
      paramMessage.putExtra("k_number", this.jdField_c_of_type_JavaLangString);
      paramMessage.putExtra("kShowAgree", false);
      if ((paramMessage != null) && (!isFinishing()))
      {
        paramMessage.addFlags(536870912);
        startActivityForResult(paramMessage, 2);
      }
      finish();
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new eki(this);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 1);
    } while (5 != paramMessage.what);
    a(2131562875, 1000L);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.jdField_a_of_type_AndroidWidgetButton;
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() > 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCompoundButton.setEnabled(paramBoolean);
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("已同意");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("未同意");
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    case 2131232019: 
    default: 
      return;
    case 2131232017: 
      f();
      return;
    case 2131232020: 
      paramView = new Intent(this, TosActivity.class);
      paramView.putExtra("frombusiness", 0);
      startActivity(paramView);
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      bool = true;
    }
    paramView.setChecked(bool);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberBusinessActivity
 * JD-Core Version:    0.7.0.1
 */