package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import bhl;
import bhm;
import bho;
import bhq;
import bht;
import bhu;
import bhv;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterPhoneNumActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "RegisterPhoneNumActivity";
  private static final String jdField_b_of_type_JavaLangString = "visibility";
  private static final String f = "enableVersion";
  private static final String g = "checked";
  private static final String h = "openDevLockText";
  private static final String i = "openDevLockHelpText";
  private static final String j = "openDevLockHelpURL";
  private Handler jdField_a_of_type_AndroidOsHandler = new bhl(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new bhu(this);
  private boolean jdField_a_of_type_Boolean = true;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private TextView c;
  private TextView d;
  private String k = null;
  
  private int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPhoneNumActivity", 2, "v1:" + paramString1 + " v2:" + paramString2);
    }
    String[] arrayOfString = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int n;
    int i1;
    if (arrayOfString.length > paramString2.length)
    {
      n = arrayOfString.length;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= n) {
        break label141;
      }
      int m;
      int i2;
      for (;;)
      {
        try
        {
          m = Integer.parseInt(arrayOfString[i1]);
        }
        catch (Exception paramString1)
        {
          m = 0;
        }
        try
        {
          i2 = Integer.parseInt(paramString2[i1]);
          if (m <= i2) {
            break label124;
          }
          return 1;
        }
        catch (Exception paramString1)
        {
          break label114;
        }
        n = paramString2.length;
        break;
        label114:
        paramString1.printStackTrace();
        i2 = 0;
      }
      label124:
      if (m < i2) {
        return -1;
      }
      i1 += 1;
    }
    label141:
    return 0;
  }
  
  private String a(String paramString)
  {
    int i1 = 0;
    int n = 1;
    if (paramString != null) {}
    for (;;)
    {
      int m;
      try
      {
        if ("852".equals(this.jdField_d_of_type_JavaLangString)) {
          break label170;
        }
        if ("853".equals(this.jdField_d_of_type_JavaLangString))
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
        if (paramString.length() < m) {
          n = 0;
        }
        m = n;
        if (!paramString.startsWith("1"))
        {
          m = n;
          if ("86".equals(this.jdField_d_of_type_JavaLangString)) {
            m = 0;
          }
        }
        if (!"86".equals(this.jdField_d_of_type_JavaLangString)) {
          break label162;
        }
        n = paramString.length();
        if (n == 11) {
          break label162;
        }
        m = i1;
      }
      catch (Exception localException)
      {
        break label145;
        continue;
        m = 3;
      }
      if (m == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.jdField_d_of_type_JavaLangString);
      if (bool)
      {
        m = 9;
        continue;
        label145:
        m = 0;
        continue;
        m = 0;
        paramString = null;
      }
      else
      {
        label162:
        continue;
        label170:
        m = 6;
      }
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new bht(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("key_register_now_account", this.e);
    localIntent.putExtra("key_register_tel", paramString1);
    localIntent.putExtra("key_register_smscode", paramString2);
    PhoneNumLoginImpl.a().a(this.app, this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void c(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new bhq(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean c()
  {
    this.jdField_c_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      a(2131363326, 1);
      return false;
    }
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      a(2131363306, 1);
      return false;
    }
    return true;
  }
  
  private void e()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298622));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298623));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new bhm(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298621));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298620));
    if (getResources().getDisplayMetrics().heightPixels >= 480) {
      new RegisterPhoneNumActivity.RegDevLockCfgDownloadTask(this).execute(new Void[0]);
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298618));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298619));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bho(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298242));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131363354) + "+" + this.jdField_d_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297382));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298243));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void f()
  {
    if (!c()) {
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131362797, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "RegisterPhoneNumActivity.startQueryAccount countryCode=" + this.jdField_d_of_type_JavaLangString + " phoneNum=" + this.jdField_c_of_type_JavaLangString);
      }
      ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverAccountObserver);
      a(2131363309);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void i()
  {
    if (!c()) {
      return;
    }
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber((byte)2, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, Long.valueOf(AppSetting.a), this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.app.runOnUiThread(new bhv(this, paramBundle));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((a(paramEditable.toString()) != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    Intent localIntent = new Intent(this, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("key_register_now_account", this.e);
    PhoneNumLoginImpl.a().a(this.app, this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str + " +" + this.jdField_d_of_type_JavaLangString);
      try
      {
        if ((a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
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
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130903580));
    setTitle(2131363331);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.e = paramBundle.getStringExtra("key_register_now_account");
    }
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    e();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    g();
    this.app.a(getClass());
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131298621)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
    if ((paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox) && (paramBoolean) && (a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
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
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */