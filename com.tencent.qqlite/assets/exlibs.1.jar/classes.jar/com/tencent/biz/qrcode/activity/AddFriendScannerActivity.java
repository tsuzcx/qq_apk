package com.tencent.biz.qrcode.activity;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.biz.widgets.ScannerView.ScannerListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtloginHelper;
import ou;
import ov;
import ow;
import ox;
import oy;
import oz;
import pa;

public class AddFriendScannerActivity
  extends BaseActivity
  implements View.OnClickListener, ScannerView.ScannerListener
{
  public static int g = 200;
  public static int h = 640;
  protected static final int i = 60000;
  protected static final int j = 4000;
  protected int a;
  public SharedPreferences a;
  protected Bitmap a;
  protected Rect a;
  protected Bundle a;
  protected Handler a;
  protected View a;
  protected ImageView a;
  protected RelativeLayout a;
  public TextView a;
  public BitMatrix a;
  protected CodeMaskManager a;
  protected ScannerView a;
  protected Runnable a;
  public String a;
  protected WtloginHelper a;
  protected boolean a;
  protected int b;
  protected Runnable b;
  protected String b;
  protected boolean b;
  protected int c;
  protected Runnable c;
  public boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  protected boolean f;
  
  public AddFriendScannerActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new ou(this);
    this.jdField_b_of_type_JavaLangRunnable = new ox(this);
    this.jdField_c_of_type_JavaLangRunnable = new oy(this);
  }
  
  private void k()
  {
    TextView localTextView = (TextView)findViewById(2131296898);
    localTextView.setText(2131363032);
    localTextView.setOnClickListener(this);
    ((TextView)findViewById(2131296892)).setText(2131363032);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362404);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setScanListener(this);
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 60000L);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("qrcode", 0);
    this.jdField_a_of_type_Boolean = ScannerUtils.a(this, this.jdField_a_of_type_AndroidContentSharedPreferences);
    this.jdField_b_of_type_Boolean = super.getPackageManager().hasSystemFeature("android.hardware.camera");
    this.jdField_a_of_type_Int = getResources().getDimensionPixelOffset(2131492887);
    this.jdField_a_of_type_JavaLangString = this.app.a();
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
      this.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
      this.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
      this.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
      this.jdField_a_of_type_AndroidOsBundle.putInt("B", -16777216);
      this.jdField_a_of_type_AndroidOsBundle.putInt("W", 16777215);
      this.jdField_a_of_type_AndroidOsBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
      this.jdField_a_of_type_AndroidOsBundle.putInt("head", 1);
    }
    this.jdField_b_of_type_JavaLangString = ((TicketManager)this.app.getManager(2)).getSkey(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this);
    WindowManager localWindowManager = (WindowManager)getSystemService("window");
    this.jdField_c_of_type_Int = localWindowManager.getDefaultDisplay().getHeight();
    this.jdField_d_of_type_Int = localWindowManager.getDefaultDisplay().getWidth();
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    if (this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper == null) {
      this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper = new WtloginHelper(getApplicationContext());
    }
  }
  
  protected Rect a()
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int m = ((Rect)localObject).top;
    int n = this.jdField_d_of_type_Int / 2;
    int i1;
    int i2;
    int k;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      i1 = this.jdField_c_of_type_Int - this.jdField_a_of_type_Int - m;
      i2 = Math.min(n, i1);
      k = i2 * 4 / 5;
      if (k >= g) {
        break label303;
      }
      k = Math.min(i2, g);
    }
    for (;;)
    {
      i2 = (n - k) / 2;
      i1 = (i1 - k) / 2;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i2, i1, i2 + k, i1 + k);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = (this.jdField_c_of_type_Int - this.jdField_a_of_type_Int - m);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(n, 0, 0, 0);
      ((FrameLayout.LayoutParams)localObject).width = n;
      ((FrameLayout.LayoutParams)localObject).height = (this.jdField_c_of_type_Int - this.jdField_a_of_type_Int - m);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      float f1 = super.getResources().getDimension(2131492890);
      Paint localPaint = new Paint();
      localPaint.setTextSize(f1);
      f1 = localPaint.measureText("将取景框对准二维码,");
      float f2 = i2;
      ((FrameLayout.LayoutParams)localObject).setMargins((int)((k - f1) / 2.0F + f2), 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return this.jdField_a_of_type_AndroidGraphicsRect;
      label303:
      if (k > h) {
        k = h;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
      this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = ScannerUtils.a(this.jdField_a_of_type_AndroidContentSharedPreferences, this.jdField_a_of_type_JavaLangString, -1);
    }
    if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix != null)
    {
      b();
      return;
    }
    QRUtils.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, new ov(this));
  }
  
  public void a(String paramString)
  {
    if ((isFinishing()) || (!isResume())) {
      return;
    }
    ScannerUtils.a(Boolean.valueOf(false), Boolean.valueOf(false), paramString, this, this.app, this.jdField_e_of_type_Boolean, this.jdField_a_of_type_ComTencentBizWidgetsScannerView, this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper, this.jdField_a_of_type_AndroidViewView);
  }
  
  protected Rect b()
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int k = ((Rect)localObject).top;
    int m = (this.jdField_c_of_type_Int - k - this.jdField_a_of_type_Int) / 2;
    int n;
    int i1;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      n = this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getWidth();
      i1 = Math.min(n, m);
      k = i1 * 5 / 7;
      if (k >= g) {
        break label256;
      }
      k = Math.min(i1, g);
    }
    for (;;)
    {
      n = (n - k) / 2;
      i1 = (m - k) / 2;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(n, i1, n + k, i1 + k);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizWidgetsScannerView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = (m * 2);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = m;
      ((FrameLayout.LayoutParams)localObject).gravity = 51;
      ((FrameLayout.LayoutParams)localObject).setMargins(0, m, 0, 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      float f1 = super.getResources().getDimension(2131492890);
      ((FrameLayout.LayoutParams)localObject).setMargins(0, (int)(k * 1 / 2 + i1 - f1), 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return this.jdField_a_of_type_AndroidGraphicsRect;
      label256:
      if (k > h) {
        k = h;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "get code template");
    }
    i();
  }
  
  public void c()
  {
    if (super.isResume())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage(2131362377);
      localQQCustomDialog.setPositiveButton(2131362802, new ow(this));
      localQQCustomDialog.show();
      return;
    }
    finish();
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (Rect localRect = b();; localRect = a())
    {
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.setViewFinder(localRect.left, localRect.top, localRect.right, localRect.bottom);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a();
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    l();
    if (this.jdField_a_of_type_Boolean)
    {
      if (getRequestedOrientation() != 0) {
        setRequestedOrientation(0);
      }
      paramBundle = (WindowManager)getSystemService("window");
      this.jdField_c_of_type_Int = paramBundle.getDefaultDisplay().getHeight();
      this.jdField_d_of_type_Int = paramBundle.getDefaultDisplay().getWidth();
      super.setContentView(2130903354);
    }
    for (;;)
    {
      e();
      k();
      return true;
      super.setContentView(2130903353);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.a();
    if (!this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView = ((ScannerView)findViewById(2131297804));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297807));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297805));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297806));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297808);
  }
  
  public void f()
  {
    if ((isFinishing()) || (!isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "onCameraReady");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362403);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 4000L);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362405);
  }
  
  public void h()
  {
    if ((isFinishing()) || (!isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "onScanFailed");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView.c();
  }
  
  public void i()
  {
    if ((this.jdField_c_of_type_Boolean) || (super.isFinishing())) {}
    Bitmap localBitmap;
    do
    {
      int i1;
      int i2;
      do
      {
        return;
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "template ready, draw qrcode");
        }
        i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("B");
        i2 = this.jdField_a_of_type_AndroidOsBundle.getInt("W");
        localObject = (Rect)this.jdField_a_of_type_AndroidOsBundle.getParcelable("qrloc");
      } while (super.isFinishing());
      int i3 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a();
      int[] arrayOfInt = new int[i3 * i3];
      k = 0;
      while (k < i3)
      {
        int m = 0;
        if (m < i3)
        {
          if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(m, k)) {}
          for (int n = i1;; n = i2)
          {
            arrayOfInt[(k * i3 + m)] = n;
            m += 1;
            break;
          }
        }
        k += 1;
      }
      localBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
      localBitmap.setPixels(arrayOfInt, 0, i3, 0, 0, i3, i3);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = ScannerUtils.a(this, localBitmap, (Rect)localObject);
    } while (this.jdField_a_of_type_AndroidGraphicsBitmap == null);
    localBitmap.recycle();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int k = ((Rect)localObject).top;
    if (this.jdField_a_of_type_Boolean) {}
    for (k = this.jdField_c_of_type_Int - k - this.jdField_a_of_type_Int;; k = (this.jdField_c_of_type_Int - k - this.jdField_a_of_type_Int) / 2)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (k * 4 / 5);
      ((ViewGroup.LayoutParams)localObject).width = (((ViewGroup.LayoutParams)localObject).height * this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    if (super.isResume())
    {
      localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setMessage(2131362378);
      ((QQCustomDialog)localObject).setPositiveButton(2131362802, new oz(this));
      ((QQCustomDialog)localObject).show();
      return;
    }
    super.finish();
  }
  
  public void j()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage("类库损坏请重新启动QQ");
    pa localpa = new pa(this);
    localQQCustomDialog.setPositiveButton(2131362802, localpa);
    localQQCustomDialog.setOnCancelListener(localpa);
    localQQCustomDialog.show();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.AddFriendScannerActivity
 * JD-Core Version:    0.7.0.1
 */