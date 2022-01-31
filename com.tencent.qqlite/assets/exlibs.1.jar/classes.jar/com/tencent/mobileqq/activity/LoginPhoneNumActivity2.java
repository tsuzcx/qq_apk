package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import auq;
import aur;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.observer.WtloginObserver;

public class LoginPhoneNumActivity2
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "LoginPhoneNumActivity";
  public static final int b = 2014;
  Handler jdField_a_of_type_AndroidOsHandler = new auq(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aur(this);
  private int c;
  
  private String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.d)) {
          break label147;
        }
        if ("853".equals(this.d))
        {
          break label147;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        if (paramString.startsWith("1")) {
          break label137;
        }
        bool = "86".equals(this.d);
        if (!bool) {
          break label137;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label120;
        i = j;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.d);
      if (bool)
      {
        i = 9;
        continue;
        label120:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label137:
        continue;
        label147:
        i = 6;
      }
    }
  }
  
  private boolean c()
  {
    boolean bool = true;
    this.jdField_c_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      a(2131363326, 1);
      bool = false;
    }
    return bool;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298242));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363354) + "+" + this.d);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297382));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298243));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void f()
  {
    if (!c()) {}
    do
    {
      return;
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        a(2131362797, 0);
        return;
      }
      a(2131363309);
    } while (PhoneNumLoginImpl.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    g();
    a(getString(2131363296), 1);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (a(paramEditable.toString()) != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity2.class);
    localIntent.putExtra("phonenum", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("key", this.d);
    localIntent.putExtra("key_req_src", this.jdField_c_of_type_Int);
    startActivityForResult(localIntent, 10000);
  }
  
  public void d()
  {
    a(2131363397, 1);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra("last_account");
      str2 = paramIntent.getStringExtra("wtTicket");
      localIntent = new Intent();
      localIntent.putExtra("last_account", str1);
      localIntent.putExtra("wtTicket", str2);
      localIntent.putExtra("ssobundle", paramIntent.getBundleExtra("ssobundle"));
      setResult(-1, localIntent);
      finish();
    }
    while ((paramInt1 != 1) || (paramInt2 != -1))
    {
      String str2;
      Intent localIntent;
      return;
    }
    String str1 = paramIntent.getStringExtra("k_name");
    this.d = paramIntent.getStringExtra("k_code");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + " +" + this.d);
    try
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298242: 
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      return;
    }
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130903503));
    setTitle(2131362913);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("key_req_src", -1);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    e();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(getClass());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity2
 * JD-Core Version:    0.7.0.1
 */