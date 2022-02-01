package com.tencent.biz.qrcode.activity;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bmv;
import bmy;
import bmz;
import bna;
import bnb;
import bnc;
import bnd;
import bng;
import com.google.zxing.Result;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.CameraManager;
import com.tencent.biz.qrcode.DecodeHandler;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.ViewfinderView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EUCountryUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.app.permission.PermissionManager;
import oicq.wlogin_sdk.request.WtloginHelper;

public class ScannerActivity
  extends BaseActivity
  implements SurfaceHolder.Callback, View.OnClickListener
{
  protected static final int a = 200;
  protected static final String a = "QrcodeScanner";
  protected static final int b = 640;
  protected static final String b = "qrcode";
  protected static final int c = 0;
  protected static final String c = "needLandScape";
  protected static final int d = 1;
  protected static final String d = "lastCheckOrientation";
  protected static final int e = 2;
  protected static final String e = "hasShowGuide";
  protected static final String f = "http://qm.qq.com/cgi-bin/check_orientation";
  protected static final String g = "^mecard.*";
  public static int h = 0;
  protected static final String h = "^begin:vcard[\\s\\S]*end:vcard";
  protected static final String i = "^bizcard.*;;$";
  public static final String j = "issupportwpa";
  public static final String k = "exttype";
  public static final String l = "extvalue";
  public static final String m = "scanForResult";
  public static final String n = "from";
  public static final String o = "scanResult";
  public static final String p = "finishAfterSucc";
  public static String t = "addDisSource";
  public SharedPreferences a;
  protected Rect a;
  protected HandlerThread a;
  protected SurfaceView a;
  public View a;
  protected TextView a;
  public CameraManager a;
  protected DecodeHandler a;
  public ViewfinderView a;
  public ScannerActivity.ScannerActivityHandler a;
  protected Runnable a;
  protected WtloginHelper a;
  protected boolean a;
  public View b;
  protected TextView b;
  public Runnable b;
  protected boolean b;
  protected View c;
  protected TextView c;
  protected boolean c;
  protected TextView d;
  public boolean d;
  public boolean e = false;
  public int f;
  public boolean f;
  protected int g;
  public boolean g;
  public boolean h;
  protected boolean i = false;
  public boolean j = false;
  protected boolean k;
  public boolean l;
  protected String q;
  protected String r;
  protected String s;
  
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
    this.jdField_f_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new bmy(this);
    this.jdField_b_of_type_JavaLangRunnable = new bmz(this);
  }
  
  public Rect a()
  {
    int i1 = 640;
    int i4;
    int i3;
    int i5;
    int i2;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      i4 = this.jdField_a_of_type_ComTencentBizQrcodeViewfinderView.getWidth();
      i3 = this.jdField_a_of_type_ComTencentBizQrcodeViewfinderView.getHeight();
      i5 = Math.min(i4, i3);
      i2 = i5 * 5 / 7;
      if (i2 >= 200) {
        break label131;
      }
      i1 = Math.min(i5, 200);
      i4 = (i4 - i1) / 2;
      i2 = (i3 - i1) / 2;
      i5 = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
      if (i5 > i3 - i2 - i1) {
        break label143;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setHeight(i3 - i2 - i1);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i4, i2, i4 + i1, i1 + i2);
      return this.jdField_a_of_type_AndroidGraphicsRect;
      label131:
      if (i2 > 640) {
        break;
      }
      i1 = i2;
      break;
      label143:
      if (i5 <= i3 - i1) {
        i2 = (i3 - i1 - i5) / 2;
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity$ScannerActivityHandler;
  }
  
  public CameraManager a()
  {
    return this.jdField_a_of_type_ComTencentBizQrcodeCameraManager;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeViewfinderView.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = "ConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(getApplicationContext()).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", (String)localObject, 1);
      do
      {
        return;
        if (paramInt == 2)
        {
          localObject = "GroupQRcard";
          break;
        }
      } while (paramInt == 3);
      String str = "ThirdpartyQRcard";
      if (QRUtils.d(paramString))
      {
        StatisticCollector.a(getApplicationContext()).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        StatisticCollector.a(getApplicationContext()).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (QRUtils.f(paramString))
        {
          StatisticCollector.a(getApplicationContext()).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", "TPQRcardphone", 1);
          localObject = str;
        }
      }
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("QrcodeScanner", 2, "openCamera");
    SurfaceHolder localSurfaceHolder = paramSurfaceHolder;
    if (paramSurfaceHolder == null) {
      localSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    }
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    new bna(this, localSurfaceHolder).start();
  }
  
  protected void a(Result paramResult)
  {
    int i3 = 2;
    paramResult = paramResult.a().trim();
    QLog.d("QrcodeScanner", 2, "resultString:" + paramResult);
    if (this.k)
    {
      if ((!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k()) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h()) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.l())) {
        ((BaseApplicationImpl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(2131165213, false);
      }
      setResult(-1, getIntent().putExtra("scanResult", paramResult));
      finish();
      return;
    }
    Object localObject = paramResult.toLowerCase();
    if ((Pattern.compile("^mecard.*").matcher((CharSequence)localObject).matches()) && ((paramResult.length() > "MECARD:".length()) || (paramResult.contains(":")))) {}
    for (int i2 = 0;; i2 = -1)
    {
      int i1 = i2;
      if (Pattern.compile("^begin:vcard[\\s\\S]*end:vcard").matcher((CharSequence)localObject).matches()) {
        if (paramResult.length() <= "BEGIN:VCARD\nEND:VCARD".length())
        {
          i1 = i2;
          if (!paramResult.contains(":")) {}
        }
        else
        {
          i1 = 1;
        }
      }
      if (Pattern.compile("^bizcard.*;;$").matcher((CharSequence)localObject).matches())
      {
        i2 = i3;
        if (paramResult.length() <= "BIZCARD:;;:".length()) {
          if (!paramResult.contains(":")) {
            break label639;
          }
        }
      }
      label639:
      for (i2 = i3;; i2 = i1)
      {
        if (i2 != -1) {}
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0)
          {
            if ((!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k()) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h()) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.l())) {
              ((BaseApplicationImpl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(2131165213, false);
            }
            if (i1 != 0) {
              QRResultHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, paramResult, i2);
            }
            if (!this.l) {
              break;
            }
            finish();
            return;
          }
          if (!HttpUtil.a(this))
          {
            paramResult = DialogUtil.a(this, 230);
            paramResult.setMessage(2131560464);
            localObject = new bnc(this);
            paramResult.setPositiveButton(2131562539, (DialogInterface.OnClickListener)localObject);
            paramResult.setOnCancelListener((DialogInterface.OnCancelListener)localObject);
            paramResult.show();
            return;
          }
          if ((!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k()) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h()) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.l())) {
            ((BaseApplicationImpl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(2131165213, false);
          }
          if (this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper == null) {
            this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper = new WtloginHelper(getApplicationContext());
          }
          if ((this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.IsWtLoginUrl((String)localObject)) && (!QRUtils.a((String)localObject)))
          {
            if (EUCountryUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 1)
            {
              a(paramResult);
              return;
            }
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            localObject = new Intent(this, QRLoginActivity.class);
            ((Intent)localObject).putExtra("QR_CODE_STRING", paramResult);
            super.startActivity((Intent)localObject);
            if (!this.l) {
              break;
            }
            finish();
            return;
          }
          if (QRUtils.e((String)localObject))
          {
            if (QRUtils.b((String)localObject))
            {
              localObject = new Intent(this, JoinDiscussionActivity.class);
              ((Intent)localObject).putExtra("innerSig", paramResult);
              ((Intent)localObject).putExtra(t, jdField_h_of_type_Int);
              startActivity((Intent)localObject);
              return;
            }
            a(paramResult);
            return;
          }
          QRResultHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, paramResult);
          a(0, paramResult);
          if (!this.l) {
            break;
          }
          finish();
          return;
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    bnd localbnd = new bnd(this, paramString);
    NewIntent localNewIntent = new NewIntent(this, QRCodeServlet.class);
    localNewIntent.putExtra("d", paramString);
    localNewIntent.putExtra("cmd", "QRCodeSvc.decode");
    localNewIntent.putExtra("bqq", "1");
    localNewIntent.setObserver(localbnd);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("://aq.qq.com"))) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.sendWirelessPswReq(3);
    }
  }
  
  public Handler b()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeDecodeHandler == null) {
      this.jdField_a_of_type_ComTencentBizQrcodeDecodeHandler = new DecodeHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
    return this.jdField_a_of_type_ComTencentBizQrcodeDecodeHandler;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeViewfinderView.b();
  }
  
  protected boolean c()
  {
    boolean bool = false;
    QLog.i("QrcodeScanner", 2, "Product:" + Build.PRODUCT);
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.contains("needLandScape")) {}
    for (bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("needLandScape", false);; bool = true) {
      do
      {
        long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastCheckOrientation", 0L);
        if (System.currentTimeMillis() - l1 > 86400000L) {
          new bng(this).start();
        }
        return bool;
      } while ((!Build.PRODUCT.equals("GT-S5830i")) && ((!Build.PRODUCT.equals("meizu_m9")) || (Build.VERSION.SDK_INT >= 9)) && (!Build.PRODUCT.equals("GT-S6352")));
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeCameraManager.d();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((!this.jdField_b_of_type_Boolean) && (paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQrcodeViewfinderView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("QrcodeScanner", 2, "onCreate");
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("qrcode", 0);
    getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentBizQrcodeCameraManager = new CameraManager(getApplicationContext());
    this.jdField_f_of_type_Boolean = c();
    if (this.jdField_f_of_type_Boolean)
    {
      QLog.d("QrcodeScanner", 2, "needLandScapeMode");
      if (getRequestedOrientation() != 0)
      {
        this.jdField_a_of_type_Boolean = true;
        setRequestedOrientation(0);
      }
      super.setContentView(2130903442);
      this.q = "";
      this.r = "";
      this.jdField_a_of_type_ComTencentBizQrcodeViewfinderView = ((ViewfinderView)findViewById(2131232598));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131232603);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232599));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232601));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232600));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232602));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131232595);
      this.jdField_f_of_type_Int = getResources().getDimensionPixelOffset(2131427376);
      this.jdField_g_of_type_Int = getResources().getDimensionPixelOffset(2131427512);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizQrcodeViewfinderView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      paramBundle = getIntent();
      localObject = paramBundle.getStringExtra("from");
      if (!"addcontacts".equals(localObject)) {
        break label615;
      }
      StatisticCollector.a(getApplicationContext()).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", "addfriend_QR", 1);
      label297:
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("hasShowGuide", false)) {
        break label711;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidViewView = View.inflate(this, 2130903436, null);
      addContentView(this.jdField_c_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_c_of_type_AndroidViewView.findViewById(2131232587).setOnClickListener(this);
      localObject = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131231455);
      String str = getIntent().getExtras().getString("leftViewText");
      if (!TextUtils.isEmpty(str)) {
        ((TextView)localObject).setText(str);
      }
      str = paramBundle.getStringExtra("assignBackText");
      if (!TextUtils.isEmpty(str)) {
        ((TextView)localObject).setText(str);
      }
      ((TextView)localObject).setOnClickListener(this);
      ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131231375)).setText(2131560463);
    }
    for (;;)
    {
      b(2131231455).setOnClickListener(this);
      ((TextView)findViewById(2131231375)).setText(2131560463);
      setTitle(2131560463);
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity$ScannerActivityHandler = new ScannerActivity.ScannerActivityHandler(this);
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QrcodeDecodeThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_g_of_type_Boolean = false;
      if ((this.permissionManager.checkPermission("android.permission.CAMERA")) && (this.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))) {
        break label738;
      }
      paramBundle = new PermissionsDialog();
      localObject = new bmv(this);
      paramBundle.a(this, new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" }, (PermissionDialogCallback)localObject);
      return true;
      super.setContentView(2130903441);
      this.q = getString(2131560507);
      this.r = getString(2131560508);
      break;
      label615:
      if ("ImagePreviewActivity".equals(localObject))
      {
        StatisticCollector.a(getApplicationContext()).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", "bigpicture_QR", 1);
        break label297;
      }
      if ("Conversation".equals(localObject))
      {
        StatisticCollector.a(getApplicationContext()).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", "bulb_QR", 1);
        break label297;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label297;
      }
      StatisticCollector.a(getApplicationContext()).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", "find_QR", 1);
      break label297;
      label711:
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    label738:
    this.j = super.getPackageManager().hasSystemFeature("android.hardware.camera");
    if ((!this.j) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131560491);
    }
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131232596));
    Object localObject = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    ((SurfaceHolder)localObject).addCallback(this);
    ((SurfaceHolder)localObject).setType(3);
    this.s = paramBundle.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.s != null) {
      this.jdField_g_of_type_Boolean = true;
    }
    this.k = paramBundle.getBooleanExtra("scanForResult", false);
    this.l = paramBundle.getBooleanExtra("finishAfterSucc", false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    QLog.d("QrcodeScanner", 2, "onDestroy");
    if (this.jdField_a_of_type_AndroidViewSurfaceView != null) {
      this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().removeCallback(this);
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.s = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.s != null) {
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  protected void doOnPause()
  {
    QLog.d("QrcodeScanner", 2, "onPause");
    this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity$ScannerActivityHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentBizQrcodeDecodeHandler != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeDecodeHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentBizQrcodeCameraManager.jdField_b_of_type_Boolean = false;
    p_();
    Process.setThreadPriority(0);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    QLog.d("QrcodeScanner", 2, "onResume");
    super.doOnResume();
    Process.setThreadPriority(-19);
    this.jdField_a_of_type_ComTencentBizQrcodeCameraManager.jdField_b_of_type_Boolean = true;
    if (this.s != null)
    {
      Uri localUri = Uri.parse("file://" + this.s);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      Message.obtain(b(), 100, localUri).sendToTarget();
      this.s = null;
    }
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if ((this.jdField_h_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
        a(null);
      }
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("hasShowGuide", false)) {
      hideActionBar();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232587: 
      this.jdField_c_of_type_Boolean = false;
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      ((ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent()).removeView(this.jdField_c_of_type_AndroidViewView);
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean)) {
        a(null);
      }
      paramView = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      paramView.putBoolean("hasShowGuide", true);
      paramView.commit();
      hideActionBar();
      return;
    case 2131232600: 
      paramView = new Intent();
      paramView.setClass(this, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScannerActivity.class.getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
      startActivity(paramView);
      AlbumUtil.a(this, false, true);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "xiangce", 0, 1, 0, "", "", "", "");
      return;
    case 2131232601: 
      boolean bool;
      if (this.jdField_a_of_type_ComTencentBizQrcodeCameraManager != null)
      {
        paramView = this.jdField_a_of_type_ComTencentBizQrcodeCameraManager;
        if (!this.i)
        {
          bool = true;
          this.i = paramView.a(bool);
        }
      }
      else
      {
        if (!this.i) {
          break label373;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838498, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.r);
      }
      for (;;)
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "kaideng", 0, 1, 0, "", "", "", "");
        return;
        bool = false;
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838505, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.q);
      }
    case 2131232602: 
      label373:
      paramView = new Intent(this, QRDisplayActivity.class);
      String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramView.putExtra("title", getString(2131560517));
      paramView.putExtra("nick", ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str));
      paramView.putExtra("uin", str);
      paramView.putExtra("type", 1);
      startActivity(paramView);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "saoyisao", "wode", 0, 1, 0, "", "", "", "");
      return;
    }
    finish();
  }
  
  protected void p_()
  {
    QLog.d("QrcodeScanner", 2, "closeCamera");
    if ((this.jdField_a_of_type_ComTencentBizQrcodeCameraManager == null) || (!this.j)) {
      return;
    }
    this.e = false;
    if (this.i)
    {
      this.i = false;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838505, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.q);
    }
    b();
    new bnb(this).start();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder == null) {}
    this.jdField_h_of_type_Boolean = true;
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
      a(paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_h_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity
 * JD-Core Version:    0.7.0.1
 */