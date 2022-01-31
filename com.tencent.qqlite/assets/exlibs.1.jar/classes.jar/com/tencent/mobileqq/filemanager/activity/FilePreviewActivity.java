package com.tencent.mobileqq.filemanager.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import dfz;
import dga;
import dgb;
import dgc;
import dge;
import dgf;
import dgh;
import dgm;
import dgp;
import dgq;
import dgr;

@SuppressLint({"NewApi"})
public class FilePreviewActivity
  extends BaseFileViewerActivity
{
  int jdField_a_of_type_Int = -1;
  public long a;
  public View.OnClickListener a;
  public ViewGroup a;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  FilePreviewActivity.ControlerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback = null;
  FilePreViewControllerBase jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
  public FilePreviewDataReporter a;
  public FilePreviewAnimQueue a;
  public FileWebView a;
  final String jdField_a_of_type_JavaLangString = "<FileAssistant>FilePreviewActivity";
  public boolean a;
  public int b;
  long b;
  public LinearLayout b;
  public TextView b;
  public FilePreviewAnimQueue b;
  public String b;
  public boolean b;
  int c;
  public long c;
  public TextView c;
  public FilePreviewAnimQueue c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  public String g;
  
  public FilePreviewActivity()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = null;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = null;
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("offline_file_type", -1);
    if (this.jdField_a_of_type_Int == -1) {
      throw new NullPointerException();
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_name");
    String str1 = FMConfig.a(this.app, this.jdField_c_of_type_JavaLangString, "FileType");
    this.g = FMConfig.a(this.app, this.jdField_c_of_type_JavaLangString, "InterfacePage");
    String str2 = FMConfig.a(this.app, this.jdField_c_of_type_JavaLangString, "PreviewMode");
    this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_domain");
    this.f = paramIntent.getStringExtra("offline_file_port");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_domain_key");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("offline_file_type_key", -1);
    if ((str1 != null) && (str1.length() > 0)) {
      this.jdField_b_of_type_Int = Integer.parseInt(str1);
    }
    if ((str2 != null) && (str2.length() > 0)) {
      this.jdField_c_of_type_Int = Integer.parseInt(str2);
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("offline_file_bZip", false);
      if (!c()) {
        break label310;
      }
      setContentViewForImage(2130903439);
      label192:
      c();
      if (this.jdField_a_of_type_Int != 0) {
        break label319;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = this.app.a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase == null)
      {
        QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it, but now for test so throw exception");
        finish();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback == null) {
        j();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback);
      this.h.setVisibility(8);
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("offline_file_size", 0L);
      d();
      label283:
      if (!this.jdField_a_of_type_Boolean) {
        break label412;
      }
      this.jdField_e_of_type_Boolean = true;
    }
    label310:
    label319:
    do
    {
      return;
      this.jdField_a_of_type_Boolean = FileManagerUtil.a(this.jdField_c_of_type_Int);
      break;
      setContentView(2130903439);
      break label192;
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("offline_file_url");
      this.h.setVisibility(0);
      this.h.setText(2131364513);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = true;
      }
      if (this.jdField_b_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.jdField_b_of_type_JavaLangString);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + this.jdField_b_of_type_JavaLangString + ")");
      break label283;
      paramIntent = FMConfig.a(this.app, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    } while ((paramIntent == null) || (Integer.parseInt(paramIntent) == 0));
    label412:
    setRequestedOrientation(-1);
  }
  
  private boolean f()
  {
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "call controller.sendCS()");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = new FilePreviewDataReporter(this.app.a());
    FilePreviewDataReporter localFilePreviewDataReporter1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
    FilePreviewDataReporter localFilePreviewDataReporter2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
    long l = System.currentTimeMillis();
    localFilePreviewDataReporter2.jdField_a_of_type_Long = l;
    localFilePreviewDataReporter1.jdField_e_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.k = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "1";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.h = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.j = FileUtil.a(this.jdField_c_of_type_JavaLangString).replace(".", "").toLowerCase();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dgc(this);
  }
  
  private void j()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback = new dge(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new dgb(this, paramInt));
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.goBack();
      return true;
    }
    return super.a();
  }
  
  protected boolean b()
  {
    return true;
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298074));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView = new FileWebView(getApplicationContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).widthPixels;
    int j = ((DisplayMetrics)localObject).heightPixels;
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = j;
    ((RelativeLayout.LayoutParams)localObject).width = i;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    removeWebViewLayerType();
    d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebViewClient(new dgf(this));
    localObject = new Handler();
    if (c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new dgh(this, (Handler)localObject));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebChromeClient(new WebChromeClient());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setFocusableInTouchMode(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getSettings();
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setCacheMode(-1);
      ((WebSettings)localObject).setBuiltInZoomControls(true);
      ((WebSettings)localObject).setSupportZoom(true);
      ((WebSettings)localObject).setUseWideViewPort(true);
      ((WebSettings)localObject).setLoadWithOverviewMode(true);
      if (Build.VERSION.SDK_INT < 16)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView;
        FileWebView.enablePlatformNotifications();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new dgm(this));
    }
  }
  
  boolean c()
  {
    return (this.jdField_c_of_type_Int != FMConstants.cP) && (!FileManagerUtil.a(this.jdField_c_of_type_Int)) && (!this.jdField_a_of_type_Boolean);
  }
  
  void d() {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      setResult(0, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(getIntent());
    setRightButton(2131363522, new dfz(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131296894));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298078));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298081));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298076));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298077));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131298079));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298080));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298075));
    setTitle(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int == 0) {
      f();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
    i();
    return true;
  }
  
  public void e()
  {
    runOnUiThread(new dgp(this));
  }
  
  public void f()
  {
    runOnUiThread(new dgq(this));
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.b();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue != null) {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.b();
    }
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_b_of_type_Long;
    localfileAssistantReportData.jdField_b_of_type_JavaLangString = "file_preview_time_stay";
    localfileAssistantReportData.jdField_b_of_type_Long = l2;
    localfileAssistantReportData.jdField_a_of_type_Boolean = true;
    localfileAssistantReportData.jdField_c_of_type_JavaLangString = FileUtil.a(this.jdField_c_of_type_JavaLangString);
    localfileAssistantReportData.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    FileManagerReporter.a(this.app.a(), localfileAssistantReportData);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) && ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f < this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = l2;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = l1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = String.valueOf(9037);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = ("LoadInterface[" + this.jdField_d_of_type_Boolean + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter = null;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.clearCache(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.destroy();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      }
      super.finish();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
    }
  }
  
  public void g()
  {
    runOnUiThread(new dgr(this));
  }
  
  public void h()
  {
    runOnUiThread(new dga(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity
 * JD-Core Version:    0.7.0.1
 */