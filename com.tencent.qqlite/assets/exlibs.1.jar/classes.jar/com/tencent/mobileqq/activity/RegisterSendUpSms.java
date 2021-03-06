package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import bie;
import bif;
import bih;
import bii;
import bij;
import bik;
import bin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterSendUpSms
  extends RegisterBaseActivity
{
  public static final int a = 60;
  private static final String jdField_a_of_type_JavaLangString = "RegisterSendUpSms";
  public static final int b = 1000;
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new bin(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new bik(this);
  private String b;
  private int jdField_c_of_type_Int = 60;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private String f = null;
  
  public RegisterSendUpSms()
  {
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new bif(this, paramString));
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131363353) + "(" + this.jdField_c_of_type_Int + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131298716));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131298717));
    String str = getResources().getString(2131363348, new Object[] { this.f, this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bie(this));
  }
  
  private void f()
  {
    this.app.a(RegisterPhoneNumActivity.class).sendEmptyMessage(103);
    finish();
  }
  
  private void i()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131363297));
    localQQCustomDialog.setMessage(getString(2131363328));
    bih localbih = new bih(this);
    bii localbii = new bii(this);
    localQQCustomDialog.setPositiveButton(2131362802, localbih);
    localQQCustomDialog.setNegativeButton(2131362801, localbii);
    localQQCustomDialog.show();
  }
  
  private void j()
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new bij(this));
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130903606));
    setTitle(2131363331);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.d = getIntent().getStringExtra("key");
    this.e = getIntent().getStringExtra("key_register_now_account");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key_register_tel");
    this.f = getIntent().getStringExtra("key_register_smscode");
    e();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g();
    k();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */