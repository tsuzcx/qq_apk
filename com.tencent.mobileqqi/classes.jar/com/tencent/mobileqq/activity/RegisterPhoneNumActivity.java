package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EUCountryUtils;
import com.tencent.widget.TimePickerView;
import dfi;
import dfj;
import dfk;
import dfl;
import dfm;
import dfn;
import dfo;
import dfp;
import dfq;
import dfr;
import dft;
import dfv;
import dfx;
import dfy;
import dfz;
import dga;
import dgd;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterPhoneNumActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  public static final String a = "RegisterPhoneNumActivity";
  private static final String jdField_g_of_type_JavaLangString = "visibility";
  private static final String h = "enableVersion";
  private static final String i = "checked";
  private static final String j = "openDevLockText";
  private static final String k = "openDevLockHelpText";
  private static final String l = "openDevLockHelpURL";
  private Handler jdField_a_of_type_AndroidOsHandler = new dfi(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new dfk(this);
  private boolean jdField_a_of_type_Boolean = true;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  public String f;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String m = null;
  
  public RegisterPhoneNumActivity()
  {
    this.jdField_b_of_type_JavaLangString = "http://www.imqq.com/mobile/terms/terms.html?language={language}";
    this.jdField_f_of_type_JavaLangString = "http://www.imqq.com/mobile/privacy/privacy.html?language={language}";
  }
  
  private int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPhoneNumActivity", 2, "v1:" + paramString1 + " v2:" + paramString2);
    }
    String[] arrayOfString = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i1;
    int i2;
    if (arrayOfString.length > paramString2.length)
    {
      i1 = arrayOfString.length;
      i2 = 0;
    }
    for (;;)
    {
      if (i2 >= i1) {
        break label141;
      }
      int n;
      int i3;
      for (;;)
      {
        try
        {
          n = Integer.parseInt(arrayOfString[i2]);
        }
        catch (Exception paramString1)
        {
          n = 0;
        }
        try
        {
          i3 = Integer.parseInt(paramString2[i2]);
          if (n <= i3) {
            break label124;
          }
          return 1;
        }
        catch (Exception paramString1)
        {
          break label114;
        }
        i1 = paramString2.length;
        break;
        label114:
        paramString1.printStackTrace();
        i3 = 0;
      }
      label124:
      if (n < i3) {
        return -1;
      }
      i2 += 1;
    }
    label141:
    return 0;
  }
  
  private String a(String paramString)
  {
    int i2 = 0;
    int i1 = 1;
    if (paramString != null) {}
    for (;;)
    {
      int n;
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
        if (paramString.length() < n) {
          i1 = 0;
        }
        n = i1;
        if (!paramString.startsWith("1"))
        {
          n = i1;
          if ("86".equals(this.jdField_d_of_type_JavaLangString)) {
            n = 0;
          }
        }
        if (!"86".equals(this.jdField_d_of_type_JavaLangString)) {
          break label162;
        }
        i1 = paramString.length();
        if (i1 == 11) {
          break label162;
        }
        n = i2;
      }
      catch (Exception localException)
      {
        break label145;
        continue;
        n = 3;
      }
      if (n == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.jdField_d_of_type_JavaLangString);
      if (bool)
      {
        n = 9;
        continue;
        label145:
        n = 0;
        continue;
        n = 0;
        paramString = null;
      }
      else
      {
        label162:
        continue;
        label170:
        n = 6;
      }
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new dfj(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int n = 0;; n = 8)
    {
      localLinearLayout.setVisibility(n);
      if ((paramBoolean) && (this.jdField_g_of_type_AndroidWidgetTextView != null)) {
        this.jdField_g_of_type_AndroidWidgetTextView.setText("");
      }
      return;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("key_register_now_account", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("key_register_tel", paramString1);
    localIntent.putExtra("key_register_smscode", paramString2);
    PhoneNumLoginImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void c(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new dga(this, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean c()
  {
    return (!g()) || ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_g_of_type_AndroidWidgetTextView.getText())));
  }
  
  private void d(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new dgd(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void f()
  {
    i();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233286));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233287));
    this.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFlags(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new dfr(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233285));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233284));
    if (getResources().getDisplayMetrics().heightPixels >= 480) {
      new RegisterPhoneNumActivity.RegDevLockCfgDownloadTask(this).execute(new Void[0]);
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233280));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233282));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new dft(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233283));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new dfv(this));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232996));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131561809) + "+" + this.jdField_d_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232016));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232997));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233288)).setOnClickListener(this);
  }
  
  private boolean f()
  {
    if (g()) {
      return EUCountryUtils.a(this.jdField_g_of_type_AndroidWidgetTextView.getText().toString());
    }
    return false;
  }
  
  private boolean g()
  {
    return (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0);
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233276));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233278));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233277));
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233281).setOnClickListener(this);
    if (this.jdField_g_of_type_Int <= 0) {
      this.jdField_g_of_type_Int = 131072257;
    }
  }
  
  private boolean i()
  {
    this.jdField_c_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      a(2131562244, 1);
      return false;
    }
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      a(2131562637, 1);
      return false;
    }
    return true;
  }
  
  private void j()
  {
    new TimePickerView(this, ProfileUtil.b(this.jdField_g_of_type_Int), ProfileUtil.c(this.jdField_g_of_type_Int), ProfileUtil.d(this.jdField_g_of_type_Int), new dfx(this)).b();
  }
  
  private void k()
  {
    try
    {
      if ((a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (c()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if (!g())
    {
      m();
      return;
    }
    if (EUCountryUtils.c((String)localObject))
    {
      localObject = new dfy(this);
      a(null, getString(2131563361), getString(2131561692), (DialogInterface.OnClickListener)localObject);
      return;
    }
    boolean bool = f();
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_privacy_type", 2);
    localBundle.putBoolean("key_privacy_underage", bool);
    localBundle.putString("key_privacy_uin", (String)localObject);
    PrivacyDeclareHelper.a(this, localBundle, new dfz(this, bool, (String)localObject));
  }
  
  private void m()
  {
    if (!i()) {
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131562452, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "RegisterPhoneNumActivity.startQueryAccount countryCode=" + this.jdField_d_of_type_JavaLangString + " phoneNum=" + this.jdField_c_of_type_JavaLangString);
      }
      ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegisterQueryMobile(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverAccountObserver);
      a(2131562877);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    if (!i()) {
      return;
    }
    try
    {
      ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegistByPhoneNumber((byte)2, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, Long.valueOf(AppSetting.a), this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void o()
  {
    e();
    Dialog localDialog = new Dialog(this, 2131624405);
    localDialog.setContentView(2130903162);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131231468);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131562928));
    }
    localTextView1 = (TextView)localDialog.findViewById(2131231029);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131559803));
    }
    localTextView1 = (TextView)localDialog.findViewById(2131231467);
    if (localTextView1 != null)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(Html.fromHtml(getString(2131558612)));
      localTextView1.getPaint().setFlags(8);
    }
    localTextView1.setOnClickListener(new dfm(this));
    localTextView1 = (TextView)localDialog.findViewById(2131231471);
    if (localTextView1 != null) {
      localTextView1.setText(2131561746);
    }
    TextView localTextView2 = (TextView)localDialog.findViewById(2131231472);
    if (localTextView2 != null) {
      localTextView2.setText(2131561578);
    }
    localDialog.setOnDismissListener(new dfn(this));
    localDialog.setOnKeyListener(new dfo(this));
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(new dfp(this));
    }
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(new dfq(this));
    }
    this.jdField_b_of_type_AndroidAppDialog = localDialog;
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new dfl(this, paramBundle));
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    k();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    PrivacyDeclareHelper.a(this, paramInt1, paramInt2);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str + " +" + this.jdField_d_of_type_JavaLangString);
    }
    try
    {
      a(EUCountryUtils.b(this.jdField_d_of_type_JavaLangString));
      k();
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)c(2130903655));
    setTitle(2131562112);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("key_register_now_account");
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    f();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    g();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_b_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131233285)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
    if (paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox)
    {
      k();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      return;
      paramView = new StringBuilder();
      paramView.append("+").append(this.jdField_d_of_type_JavaLangString).append(" ").append(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()).append("\n").append("\n").append(getString(2131563362));
      d(getResources().getString(2131559805), paramView.toString());
      return;
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", "http://passport.imqq.com/Mqqjp/signup.html");
      startActivity(paramView);
      return;
      j();
      return;
    } while (this.jdField_a_of_type_AndroidWidgetCheckBox == null);
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (;;)
    {
      paramView.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void s_()
  {
    Intent localIntent = new Intent(this, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("key_register_now_account", this.jdField_e_of_type_JavaLangString);
    if (g()) {
      localIntent.putExtra("eu_birthday_bundle", this.jdField_g_of_type_Int);
    }
    PhoneNumLoginImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */