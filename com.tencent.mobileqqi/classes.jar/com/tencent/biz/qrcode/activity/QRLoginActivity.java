package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import bmp;
import bmq;
import bmr;
import bms;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class QRLoginActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final char jdField_a_of_type_Char = '_';
  protected static final int a = 1;
  protected static final long a = 16L;
  protected static final String a = "QRLoginActivity";
  static final short[] jdField_a_of_type_ArrayOfShort = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  public Handler a;
  public Button a;
  protected ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  public TextView a;
  public QQProgressDialog a;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new bmp(this);
  protected boolean a;
  protected byte[] a;
  protected Button b;
  public ImageView b;
  public TextView b;
  public String b;
  protected String c;
  public String d;
  public String e;
  
  public QRLoginActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new bms(this);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int n = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = n;
    n = k - 1;
    int i1 = i;
    if (k > 0)
    {
      i = j + 1;
      j = paramArrayOfByte[j];
      i1 = j;
      if (j != 0)
      {
        if (j != 95) {
          break label107;
        }
        i1 = j;
      }
    }
    if (i1 == 95)
    {
      i = paramInt;
      switch (m % 4)
      {
      }
    }
    for (;;)
    {
      return arrayOfByte;
      label107:
      k = j;
      if (j == 32) {
        k = 42;
      }
      j = jdField_a_of_type_ArrayOfShort[k];
      if (j < 0)
      {
        k = n;
        n = i;
        i = j;
        j = n;
        break;
      }
      switch (m % 4)
      {
      }
      for (;;)
      {
        i1 = m + 1;
        k = n;
        m = j;
        j = i;
        i = m;
        m = i1;
        break;
        arrayOfByte[paramInt] = ((byte)(j << 2));
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 4));
        arrayOfByte[k] = ((byte)((j & 0xF) << 4));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 2));
        arrayOfByte[k] = ((byte)((j & 0x3) << 6));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j));
        paramInt = k;
      }
      return null;
      i = paramInt + 1;
      arrayOfByte[i] = 0;
    }
  }
  
  protected void a()
  {
    if (super.isFinishing()) {
      return;
    }
    this.c = super.getIntent().getStringExtra("QR_CODE_STRING");
    int i = this.c.indexOf("?k=") + 3;
    Object localObject = this.c.substring(i, i + 32);
    this.jdField_a_of_type_ArrayOfByte = a(((String)localObject).getBytes(), ((String)localObject).length());
    localObject = this.jdField_a_of_type_MqqManagerWtloginManager;
    String str = this.jdField_b_of_type_JavaLangString;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
    ((WtloginManager)localObject).VerifyCode(str, 16L, true, arrayOfByte, new int[] { 5 }, 1, localWtloginObserver);
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    Object localObject;
    if (!HttpUtil.a(this))
    {
      localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setMessage(2131560464);
      ((QQCustomDialog)localObject).setPositiveButton(2131562539, new bmr(this));
      ((QQCustomDialog)localObject).show();
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = getString(2131560487);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131560467);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.d());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131560529);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnCancelListener(new bmq(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    byte[] arrayOfByte = QRUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Object localObject1 = ByteBuffer.allocate(arrayOfByte.length + 4);
    ((ByteBuffer)localObject1).putShort((short)2);
    ((ByteBuffer)localObject1).putShort((short)arrayOfByte.length);
    ((ByteBuffer)localObject1).put(arrayOfByte);
    arrayOfByte = ((ByteBuffer)localObject1).array();
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_JavaLangString);
    localObject1 = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(this.jdField_b_of_type_JavaLangString)))
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
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr(arrayOfByte));
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject2));
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqManagerWtloginManager.CloseCode(this.jdField_b_of_type_JavaLangString, 16L, this.jdField_a_of_type_ArrayOfByte, 1, (ArrayList)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr(arrayOfByte));
    }
  }
  
  public void o_()
  {
    Intent localIntent;
    if (!isFinishing())
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", 0);
      localIntent.setFlags(67108864);
      super.startActivity(localIntent);
    }
    Toast.makeText(this, 2131560488, 0).show();
    if (this.d.equals("QQ"))
    {
      localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("loginInfo", this.e);
      localIntent.putExtra("status", "login");
      super.sendBroadcast(localIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232593: 
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = new Intent(this, ScannerActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        return;
      }
      b();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903438);
    super.setTitle(2131560466);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131232589));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232593));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232594));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232591));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232592));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232590));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232587));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131232595));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(1));
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginActivity", 2, "wtloginManager:" + this.jdField_a_of_type_MqqManagerWtloginManager + " isLogin:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      a();
      return;
    }
    a(null);
  }
  
  protected void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginActivity
 * JD-Core Version:    0.7.0.1
 */