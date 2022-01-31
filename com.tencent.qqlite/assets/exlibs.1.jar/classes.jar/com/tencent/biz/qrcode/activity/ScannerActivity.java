package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.biz.widgets.ScannerView.ScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WtloginHelper;
import qm;
import qn;
import qo;
import qp;

public class ScannerActivity
  extends BaseActivity
  implements View.OnClickListener, ScannerView.FileDecodeListener, ScannerView.ScannerListener
{
  protected static final int a = 200;
  protected static final String a = "QrcodeScanner";
  protected static final int b = 640;
  protected static final String b = "hasShowGuide";
  protected static final int c = 0;
  protected static final String c = "^mecard.*";
  protected static final int d = 1;
  protected static final String d = "^begin:vcard[\\s\\S]*end:vcard";
  protected static final int e = 2;
  protected static final String e = "^bizcard.*;;$";
  public static final String f = "issupportwpa";
  public static final String g = "exttype";
  public static int h = 0;
  public static final String h = "extvalue";
  public static final int i = 2;
  public static final String i = "scanForResult";
  public static final String j = "from";
  public static final String k = "finishAfterSucc";
  public static String o = "addDisSource";
  protected SharedPreferences a;
  protected Rect a;
  protected View a;
  protected TextView a;
  public ScannerView a;
  protected Runnable a;
  protected WtloginHelper a;
  protected boolean a;
  protected View b;
  protected TextView b;
  protected boolean b;
  protected View c;
  protected TextView c;
  protected boolean c;
  protected TextView d;
  protected boolean d;
  protected boolean e = false;
  protected int f;
  public boolean f;
  protected int g;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  protected boolean j;
  protected String l;
  protected String m;
  protected String n;
  
  static
  {
    jdField_h_of_type_Int = 1;
  }
  
  public ScannerActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new qm(this);
  }
  
  public Rect a()
  {
    int i1 = 640;
    int i5;
    int i4;
    int i3;
    int i2;
    int i6;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      i5 = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getWidth();
      i4 = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getHeight();
      i3 = 0;
      i2 = i4;
      if (!this.e)
      {
        i2 = (int)(getResources().getDisplayMetrics().density * 110.0F + 0.5D);
        i3 = this.jdField_f_of_type_Int;
        i2 = i4 - i3 - i2;
      }
      i6 = Math.min(i5, i2);
      i4 = i6 * 5 / 7;
      if (i4 >= 200) {
        break label179;
      }
      i1 = Math.min(i6, 200);
      i6 = (i5 - i1) / 2;
      i4 = (i2 - i1) / 2;
      i5 = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
      if (i5 > i4) {
        break label193;
      }
      i2 = i4;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setHeight(i2);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i6, i2 + i3, i6 + i1, i3 + (i2 + i1));
      return this.jdField_a_of_type_AndroidGraphicsRect;
      label179:
      if (i4 > 640) {
        break;
      }
      i1 = i4;
      break;
      label193:
      if (i5 <= i2 - i1)
      {
        i2 = i5;
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        i2 = i4;
      }
    }
  }
  
  public void a()
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage("类库损坏请重新启动QQ");
    qo localqo = new qo(this);
    localQQCustomDialog.setPositiveButton(2131362802, localqo);
    localQQCustomDialog.setOnCancelListener(localqo);
    localQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    if ((isFinishing()) || (!isResume())) {}
    while (this.jdField_f_of_type_Boolean) {
      return;
    }
    b(paramString);
  }
  
  public void b()
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(2131362407);
    qp localqp = new qp(this);
    localQQCustomDialog.setPositiveButton(2131362802, localqp);
    localQQCustomDialog.setOnCancelListener(localqp);
    localQQCustomDialog.show();
  }
  
  protected void b(String paramString)
  {
    ScannerUtils.a(Boolean.valueOf(this.j), Boolean.valueOf(this.i), paramString, this, this.app, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentBizWidgetsScannerView, this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void c(String paramString)
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    b(paramString);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((!this.jdField_b_of_type_Boolean) && (paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("qrcode", 0);
    this.e = ScannerUtils.a(this, this.jdField_a_of_type_AndroidContentSharedPreferences);
    String str;
    if (this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrcodeScanner", 2, "needLandScapeMode");
      }
      if (getRequestedOrientation() != 0)
      {
        this.jdField_a_of_type_Boolean = true;
        setRequestedOrientation(0);
      }
      super.setContentView(2130903362);
      this.l = "";
      this.m = "";
      this.jdField_a_of_type_AndroidViewView = findViewById(2131297827);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297805));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297825));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297824));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297826));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131297823);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView = ((ScannerView)findViewById(2131297804));
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setScanListener(this);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setFileDecodeListener(this);
      this.jdField_f_of_type_Int = getResources().getDimensionPixelOffset(2131492887);
      this.jdField_g_of_type_Int = getResources().getDimensionPixelOffset(2131493009);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      paramBundle = getIntent();
      str = paramBundle.getStringExtra("from");
      if (!"addcontacts".equals(str)) {
        break label513;
      }
      StatisticCollector.a(getApplicationContext()).b(this.app, "", "addfriend_QR", 1);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      findViewById(2131296898).setOnClickListener(this);
      ((TextView)findViewById(2131296898)).setText(2131362376);
      ((TextView)findViewById(2131296892)).setText(2131362376);
      findViewById(2131296898).setContentDescription(getString(2131364539));
      this.jdField_f_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = super.getPackageManager().hasSystemFeature("android.hardware.camera");
      if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362404);
      }
      this.n = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (this.n != null) {
        this.jdField_f_of_type_Boolean = true;
      }
      this.i = paramBundle.getBooleanExtra("scanForResult", false);
      this.j = paramBundle.getBooleanExtra("finishAfterSucc", false);
      return true;
      super.setContentView(2130903361);
      this.l = getString(2131362417);
      this.m = getString(2131362418);
      break;
      label513:
      if ("ImagePreviewActivity".equals(str)) {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "bigpicture_QR", 1);
      } else if ("Conversation".equals(str)) {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "bulb_QR", 1);
      } else if (TextUtils.isEmpty(str)) {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "find_QR", 1);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onDestroy");
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.n = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.n != null) {
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onPause");
    }
    this.jdField_f_of_type_Boolean = false;
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838383, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.l);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
    this.jdField_d_of_type_Boolean = false;
    Process.setThreadPriority(0);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrcodeScanner", 2, "onResume");
    }
    super.doOnResume();
    Process.setThreadPriority(-19);
    if (this.n != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a(this.n);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.n = null;
    }
    if (!this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a();
    }
  }
  
  public void f()
  {
    if ((isFinishing()) || (!isResume())) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362403);
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a()) {
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      }
    } while (this.jdField_f_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362405);
  }
  
  public void h()
  {
    if ((isFinishing()) || (!isResume())) {}
    while (this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.c();
  }
  
  public void j()
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage("类库损坏请重新启动QQ");
    qn localqn = new qn(this);
    localQQCustomDialog.setPositiveButton(2131362802, localqn);
    localQQCustomDialog.setOnCancelListener(localqn);
    localQQCustomDialog.show();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297824: 
      paramView = new Intent();
      paramView.setClass(this, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScannerActivity.class.getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
      super.startActivity(paramView);
      AlbumUtil.a(this, false, true);
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "xiangce", 0, 1, 0, "", "", "", "");
      return;
    case 2131297825: 
      paramView = this.jdField_a_of_type_ComTencentBizWidgetsScannerView;
      boolean bool;
      if (!this.jdField_g_of_type_Boolean)
      {
        bool = true;
        this.jdField_g_of_type_Boolean = paramView.a(bool);
        if (!this.jdField_g_of_type_Boolean) {
          break label263;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838376, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.m);
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "kaideng", 0, 1, 0, "", "", "", "");
        return;
        bool = false;
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838383, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.l);
      }
    case 2131297826: 
      label263:
      paramView = new Intent(this, QRDisplayActivity.class);
      String str = this.app.a();
      paramView.putExtra("title", getString(2131362427));
      paramView.putExtra("nick", ContactUtils.g(this.app, str));
      paramView.putExtra("uin", str);
      paramView.putExtra("type", 1);
      super.startActivity(paramView);
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "wode", 0, 1, 0, "", "", "", "");
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity
 * JD-Core Version:    0.7.0.1
 */