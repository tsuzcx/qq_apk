package com.tencent.mobileqq.activity;

import aig;
import aih;
import aij;
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
  Handler jdField_a_of_type_AndroidOsHandler = new aig(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aij(this);
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  
  private void c()
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
  
  protected boolean a()
  {
    super.finish();
    super.overridePendingTransition(0, 2130968593);
    return false;
  }
  
  public void b()
  {
    Object localObject1 = QRUtils.a(this.app.a());
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    Object localObject3 = ((ByteBuffer)localObject2).array();
    localObject1 = this.app.a();
    Object localObject4 = this.app.b((String)localObject1);
    localObject2 = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!((String)localObject4).equals(localObject1)))
    {
      localObject4 = ((String)localObject4).getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject4.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)localObject4.length);
      localByteBuffer.put((byte[])localObject4);
      localObject4 = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(localObject4.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)localObject4.length);
      localByteBuffer.put((byte[])localObject4);
      localObject4 = localByteBuffer.array();
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject4));
      localObject3 = ByteBuffer.allocate(8);
      ((ByteBuffer)localObject3).putShort((short)21);
      ((ByteBuffer)localObject3).putShort((short)4);
      if (!this.jdField_b_of_type_Boolean) {
        break label309;
      }
    }
    label309:
    for (int i = 1;; i = 0)
    {
      ((ByteBuffer)localObject3).putInt(i);
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject3).array()));
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "confirmLogin start CloseCode..");
      }
      ((WtloginManager)this.app.getManager(1)).CloseCode((String)localObject1, 16L, this.jdField_a_of_type_ArrayOfByte, 1, (ArrayList)localObject2, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    int i = paramView.getId();
    switch (i)
    {
    default: 
      return;
    case 2131296905: 
      super.finish();
      super.overridePendingTransition(0, 2130968593);
      return;
    }
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, super.getString(2131362785), 0).b(super.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString is empty");
      }
      QQToast.a(super.getApplicationContext(), 1, super.getString(2131364241), 0).b(getTitleBarHeight());
      super.finish();
      super.overridePendingTransition(0, 2130968593);
      return;
    }
    int j = this.jdField_c_of_type_JavaLangString.indexOf("?k=") + 3;
    if (j < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString  error");
      }
      QQToast.a(super.getApplicationContext(), 1, super.getString(2131364241), 0).b(getTitleBarHeight());
      super.finish();
      super.overridePendingTransition(0, 2130968593);
      return;
    }
    paramView = this.jdField_c_of_type_JavaLangString.substring(j, j + 32);
    this.jdField_a_of_type_ArrayOfByte = QRLoginActivity.a(paramView.getBytes(), paramView.length());
    paramView = this.app.a();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && (!super.isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363564);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin start verifyCode..");
      }
      if (i == 2131297833) {
        bool = true;
      }
      this.jdField_b_of_type_Boolean = bool;
      WtloginManager localWtloginManager = (WtloginManager)this.app.getManager(1);
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
    super.setTheme(2131624267);
    super.onCreate(paramBundle);
    super.setContentView(2130903491);
    super.setTitle(2131364235);
    this.h.setVisibility(4);
    super.setRightButton(2131363522, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297827));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297828));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298221));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298222));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298223));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297833));
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("qrcode");
      this.d = paramBundle.getStringExtra("maintip");
      this.e = paramBundle.getStringExtra("smalltip");
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("allowLoginOnce", false);
    }
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = this.jdField_b_of_type_AndroidWidgetButton;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 0;
      paramBundle.setVisibility(i);
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "onCreate qrCodeSting=" + this.jdField_c_of_type_JavaLangString + " mainTip=" + this.d + " smallTip=" + this.e);
      }
      ThreadManager.b(new aih(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.app.c());
      if ((this.d == null) || (this.d.length() <= 0)) {
        break label364;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.d);
      label321:
      if ((this.e == null) || (this.e.length() <= 0)) {
        break label381;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.e);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      i = 8;
      break;
      label364:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131364239));
      break label321;
      label381:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131364240));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    int i = 0;
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("qrcode");
      this.d = paramIntent.getStringExtra("maintip");
      this.e = paramIntent.getStringExtra("smalltip");
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("allowLoginOnce", false);
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent qrCodeSting=" + this.jdField_c_of_type_JavaLangString + " mainTip=" + this.d + " smallTip=" + this.e);
      }
      if ((this.d != null) && (this.d.length() > 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.d);
        if ((this.e == null) || (this.e.length() <= 0)) {
          break label208;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.e);
        paramIntent = this.jdField_b_of_type_AndroidWidgetButton;
        if (!this.jdField_a_of_type_Boolean) {
          break label225;
        }
        paramIntent.setVisibility(i);
      }
    }
    label208:
    label225:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131364239));
        continue;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131364240));
        continue;
        i = 8;
      }
    }
    QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent intent is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */