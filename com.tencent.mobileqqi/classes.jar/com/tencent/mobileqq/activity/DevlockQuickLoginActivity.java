package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cmz;
import cna;
import cnc;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class DevlockQuickLoginActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 1;
  static final long jdField_a_of_type_Long = 16L;
  static final String jdField_a_of_type_JavaLangString = "DevlockQuickLoginActivity";
  public static final String b = "QR_CODE_STRING";
  Handler jdField_a_of_type_AndroidOsHandler = new cmz(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new cnc(this);
  byte[] jdField_a_of_type_ArrayOfByte;
  TextView b;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  
  private void d()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void b()
  {
    byte[] arrayOfByte = QRUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Object localObject1 = ByteBuffer.allocate(arrayOfByte.length + 4);
    ((ByteBuffer)localObject1).putShort((short)2);
    ((ByteBuffer)localObject1).putShort((short)arrayOfByte.length);
    ((ByteBuffer)localObject1).put(arrayOfByte);
    arrayOfByte = ((ByteBuffer)localObject1).array();
    localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject1);
    ArrayList localArrayList = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(localObject1)))
    {
      localObject2 = ((String)localObject2).getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject2.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)localObject2.length);
      localByteBuffer.put((byte[])localObject2);
      localObject2 = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(localObject2.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)localObject2.length);
      localByteBuffer.put((byte[])localObject2);
      localObject2 = localByteBuffer.array();
      localArrayList.add(HexUtil.bytes2HexStr(arrayOfByte));
      localArrayList.add(HexUtil.bytes2HexStr((byte[])localObject2));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "confirmLogin start CloseCode..");
      }
      ((WtloginManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(1)).CloseCode((String)localObject1, 16L, this.jdField_a_of_type_ArrayOfByte, 1, localArrayList, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      localArrayList.add(HexUtil.bytes2HexStr(arrayOfByte));
    }
  }
  
  protected boolean b()
  {
    super.finish();
    super.overridePendingTransition(0, 2130968599);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131231380: 
      super.finish();
      super.overridePendingTransition(0, 2130968599);
      return;
    }
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, super.getString(2131562452), 0).b(super.d());
      return;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString is empty");
      }
      QQToast.a(super.getApplicationContext(), 1, super.getString(2131562052), 0).b(d());
      super.finish();
      super.overridePendingTransition(0, 2130968599);
      return;
    }
    int i = this.jdField_c_of_type_JavaLangString.indexOf("?k=") + 3;
    if (i < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString  error");
      }
      QQToast.a(super.getApplicationContext(), 1, super.getString(2131562052), 0).b(d());
      super.finish();
      super.overridePendingTransition(0, 2130968599);
      return;
    }
    paramView = this.jdField_c_of_type_JavaLangString.substring(i, i + 32);
    this.jdField_a_of_type_ArrayOfByte = QRLoginActivity.a(paramView.getBytes(), paramView.length());
    paramView = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && (!super.isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.d());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562645);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin start verifyCode..");
      }
      WtloginManager localWtloginManager = (WtloginManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(1);
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
      localWtloginManager.VerifyCode(paramView, 16L, true, arrayOfByte, new int[] { 5 }, 1, localWtloginObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.setTheme(2131624531);
    super.onCreate(paramBundle);
    super.setContentView(2130903569);
    super.setTitle(2131562700);
    this.k.setVisibility(4);
    super.c(2131561842, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232587));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232588));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232949));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232950));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232951));
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("qrcode");
      this.d = paramBundle.getStringExtra("maintip");
      this.e = paramBundle.getStringExtra("smalltip");
    }
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "onCreate qrCodeSting=" + this.jdField_c_of_type_JavaLangString + " mainTip=" + this.d + " smallTip=" + this.e);
    }
    ThreadManager.b(new cna(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131563285));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131563270));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("qrcode");
      this.d = paramIntent.getStringExtra("maintip");
      this.e = paramIntent.getStringExtra("smalltip");
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent qrCodeSting=" + this.jdField_c_of_type_JavaLangString + " mainTip=" + this.d + " smallTip=" + this.e);
      }
      if ((this.d != null) && (this.d.length() > 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.d);
        if ((this.e == null) || (this.e.length() <= 0)) {
          break label177;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.e);
      }
    }
    label177:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131563285));
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131563270));
      return;
    }
    QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent intent is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */