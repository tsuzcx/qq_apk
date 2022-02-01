package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import cut;
import cuu;
import cux;
import mqq.observer.WtloginObserver;

public class LoginPhoneNumActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "LoginPhoneNumActivity";
  public static final int b = 2014;
  public static final int c = 2015;
  private long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler = new cut(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new cux(this);
  private boolean jdField_a_of_type_Boolean = false;
  
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
          break label170;
        }
        if ("853".equals(this.d))
        {
          break label170;
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
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.d)) {
            i = 0;
          }
        }
        if (!"86".equals(this.d)) {
          break label162;
        }
        j = paramString.length();
        if (j == 11) {
          break label162;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label145;
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
        label145:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label162:
        continue;
        label170:
        i = 6;
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new cuu(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean c()
  {
    boolean bool = true;
    this.c = a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
    if (this.c == null)
    {
      a(2131562244, 1);
      bool = false;
    }
    return bool;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232996));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561809) + "+" + this.d);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232016));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232997));
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
        a(2131562452, 0);
        return;
      }
      a(2131562877);
    } while (PhoneNumLoginImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.d, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    g();
    a(getString(2131561658), 1);
  }
  
  protected boolean a()
  {
    return false;
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.d = paramIntent.getStringExtra("k_code");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str + " +" + this.d);
      try
      {
        if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if ((paramInt1 == 14826) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232996: 
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      return;
    }
    b(getResources().getString(2131559805), "+" + this.d + " " + this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)c(2130903589));
    setTitle(2131562351);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isSubaccount", false);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    }
    e();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void s_()
  {
    com.tencent.common.app.BaseApplicationImpl.e = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    boolean bool = getIntent().getBooleanExtra("login_from_account_change", false);
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.c);
    localIntent.putExtra("key", this.d);
    localIntent.putExtra("isSubaccount", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("login_from_account_change", bool);
    if (bool)
    {
      startActivityForResult(localIntent, 14826);
      return;
    }
    startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */