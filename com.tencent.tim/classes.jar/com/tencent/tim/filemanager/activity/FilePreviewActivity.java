package com.tencent.tim.filemanager.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import arhz;
import atoc;
import atod;
import atoe;
import atof;
import atoh;
import atoi;
import atoj;
import atok;
import atol;
import attf;
import attt;
import atvw;
import atvz;
import atwe;
import audw;
import audw.b;
import audx;
import aueg;
import aueh;
import aulg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.tim.filemanager.widget.FileWebView;
import com.tencent.tim.filemanager.widget.FileWebView.a;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Map;
import wja;

@SuppressLint({"NewApi"})
public class FilePreviewActivity
  extends BaseFileViewerActivity
{
  private View KF;
  private View KG;
  private View KH;
  private ViewStub N;
  private arhz P;
  TextView Sg = null;
  public TextView Sh = null;
  public TextView Si = null;
  final String TAG = "<FileAssistant>FilePreviewActivity";
  long Yj = 0L;
  long Yk = 0L;
  attt jdField_a_of_type_Attt = null;
  public atwe a;
  aueg jdField_a_of_type_Aueg = null;
  private aulg jdField_a_of_type_Aulg = new atoc(this);
  a jdField_a_of_type_ComTencentTimFilemanagerActivityFilePreviewActivity$a = null;
  public FileWebView.a a;
  public FileWebView a;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo;
  aueg b = null;
  public String bGp;
  String bGq;
  public String bGr = null;
  String bGs = null;
  public String bGt;
  public String bGu;
  public String bGv;
  public String bGw;
  String bGx = null;
  aueg c;
  public int cWD = -1;
  int cWE = -1;
  public boolean ccL = false;
  boolean ccN = false;
  public boolean ccO = false;
  boolean ccP = false;
  public boolean ccQ = false;
  public boolean ccR = false;
  private boolean diw;
  View.OnClickListener eP = null;
  private int eqH = 1;
  public LinearLayout iR = null;
  public LinearLayout iS = null;
  RelativeLayout kl;
  public ProgressBar mProgressBar = null;
  ViewGroup mTitleBar = null;
  public String mUuid = null;
  public int nFileType = -1;
  public String strCookie;
  long uFileSize = -1L;
  public ImageView zE = null;
  
  public FilePreviewActivity()
  {
    this.jdField_a_of_type_Atwe = null;
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView$a = null;
  }
  
  private boolean T(Intent paramIntent)
  {
    this.cWD = paramIntent.getIntExtra("offline_file_type", -1);
    if (this.cWD == -1) {
      return false;
    }
    this.bGq = paramIntent.getStringExtra("offline_file_name");
    if (this.cWD == 1) {
      this.bGr = paramIntent.getStringExtra("OfflinePreZipPath");
    }
    this.bGq = paramIntent.getStringExtra("offline_file_name");
    Object localObject = atvz.j(this, this.bGq, "FileType");
    this.bGw = atvz.j(this, this.bGq, "InterfacePage");
    String str = atvz.j(this, this.bGq, "PreviewMode");
    this.bGu = paramIntent.getStringExtra("offline_file_domain");
    this.bGv = paramIntent.getStringExtra("offline_file_port");
    this.bGt = paramIntent.getStringExtra("offline_file_domain_key");
    this.nFileType = paramIntent.getIntExtra("offline_file_type_key", -1);
    this.strCookie = paramIntent.getStringExtra("COOKIE");
    this.ccN = paramIntent.getBooleanExtra("offline_file_show_team_work_menu", false);
    this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.nFileType = Integer.parseInt((String)localObject);
    }
    if ((str != null) && (str.length() > 0)) {
      this.cWE = Integer.parseInt(str);
    }
    if (this.cWD != 0)
    {
      this.ccL = paramIntent.getBooleanExtra("offline_file_bZip", false);
      if (!akS()) {
        break label333;
      }
      setContentViewForImage(2131561046);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131377547);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
    }
    for (;;)
    {
      initWebView();
      if (this.cWD != 0) {
        break label418;
      }
      this.jdField_a_of_type_Attt = this.app.a().a();
      if (this.jdField_a_of_type_Attt != null) {
        break label342;
      }
      QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it!");
      finish();
      return false;
      this.ccL = audx.jP(this.cWE);
      break;
      label333:
      setContentView(2131561046);
    }
    label342:
    this.bGx = String.valueOf(this.jdField_a_of_type_Attt.Em());
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityFilePreviewActivity$a == null) {
      dfh();
    }
    this.jdField_a_of_type_Attt.a(this.jdField_a_of_type_ComTencentTimFilemanagerActivityFilePreviewActivity$a);
    this.leftView.setVisibility(8);
    this.uFileSize = paramIntent.getLongExtra("offline_file_size", 0L);
    startTitleProgress();
    if (this.ccL) {
      this.ccR = true;
    }
    for (;;)
    {
      return true;
      label418:
      this.bGp = paramIntent.getStringExtra("offline_file_url");
      this.leftView.setVisibility(0);
      if (this.bGp != null) {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.loadUrl(this.bGp);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + this.bGp + ")");
      this.mUuid = paramIntent.getStringExtra("OfflinePreZipUUID");
      break;
      paramIntent = atvz.b(this, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
      if (paramIntent == null) {
        return true;
      }
      if (Integer.parseInt(paramIntent) == 0) {
        return true;
      }
      setRequestedOrientation(-1);
    }
  }
  
  private boolean akT()
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "call controller.sendCS()");
    }
    this.Yj = System.currentTimeMillis();
    this.jdField_a_of_type_Atwe = new atwe(this.app.getCurrentAccountUin());
    atwe localatwe1 = this.jdField_a_of_type_Atwe;
    atwe localatwe2 = this.jdField_a_of_type_Atwe;
    long l = System.currentTimeMillis();
    localatwe2.mInitTime = l;
    localatwe1.startTime = l;
    this.jdField_a_of_type_Atwe.bGx = String.valueOf(this.bGx);
    this.jdField_a_of_type_Atwe.bIw = "1";
    this.jdField_a_of_type_Atwe.bIt = this.bGq;
    this.jdField_a_of_type_Atwe.bIv = aueh.getExtension(this.bGq).replace(".", "").toLowerCase();
    this.jdField_a_of_type_Atwe.mFileSize = this.uFileSize;
    return this.jdField_a_of_type_Attt.alr();
  }
  
  private void dfg()
  {
    if (this.eP != null) {
      return;
    }
    this.eP = new atoh(this);
  }
  
  private void dfh()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityFilePreviewActivity$a = new atoi(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void NR(int paramInt)
  {
    runOnUiThread(new FilePreviewActivity.14(this, paramInt));
  }
  
  boolean akS()
  {
    return (!audx.jP(this.cWE)) && (!this.ccL);
  }
  
  void dfi()
  {
    runOnUiThread(new FilePreviewActivity.10(this));
  }
  
  public void dfj()
  {
    runOnUiThread(new FilePreviewActivity.11(this));
  }
  
  public void dfk()
  {
    runOnUiThread(new FilePreviewActivity.12(this));
  }
  
  public void dfl()
  {
    runOnUiThread(new FilePreviewActivity.13(this));
  }
  
  void dfm()
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView$a != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView$a = new atod(this);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          Bundle localBundle = paramIntent.getExtras();
          Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
          localIntent.putExtras(new Bundle(localBundle));
          startActivity(localIntent);
        }
        setResult(4, paramIntent);
      }
    }
    else {
      return;
    }
    setResult(0, paramIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (!T(paramBundle))
    {
      finish();
      return false;
    }
    setRightButton(2131721059, new atoe(this));
    this.mTitleBar = ((ViewGroup)findViewById(2131377361));
    this.iR = ((LinearLayout)findViewById(2131368014));
    this.iR.setVisibility(4);
    this.Sg = ((TextView)findViewById(2131372832));
    this.Sg.setVisibility(4);
    this.N = ((ViewStub)findViewById(2131365442));
    if (this.ccN)
    {
      this.KF = this.N.inflate();
      this.KF.setPadding(0, 0, 70, 120);
      this.KG = this.KF.findViewById(2131380969);
      this.KH = this.KF.findViewById(2131380970);
      this.app.addObserver(this.jdField_a_of_type_Aulg);
    }
    boolean bool = this.app.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + this.app.getCurrentUin(), 4).getBoolean("tim_convert_teamwork_open_with_share_doc", false);
    if (!bool)
    {
      if (this.KG != null) {
        this.KG.setVisibility(8);
      }
      if (this.KH != null) {
        this.KH.setVisibility(8);
      }
      if ((this.KG != null) && (bool)) {
        this.KG.setOnClickListener(new atof(this));
      }
      if (this.KH != null) {}
      this.zE = ((ImageView)findViewById(2131366494));
      this.Sh = ((TextView)findViewById(2131377221));
      this.zE.setVisibility(8);
      this.mProgressBar = ((ProgressBar)findViewById(2131368015));
      this.Si = ((TextView)findViewById(2131368013));
      this.iS = ((LinearLayout)findViewById(2131377232));
      setTitle(BaseApplicationImpl.getContext().getString(2131694129));
      if (this.cWD != 0) {
        break label455;
      }
      akT();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setVisibility(4);
      dfg();
      return true;
      anot.a(this.app, "CliOper", "", "", "0X8008D2C", "0X8008D2C", 0, 0, "", "", "", "");
      break;
      label455:
      this.bGs = paramBundle.getStringExtra("OfflinePreZipDirName");
      setTitle(BaseApplicationImpl.getContext().getString(2131694129));
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.P != null) && (this.P.isShowing())) {
      this.P.dismiss();
    }
    this.app.removeObserver(this.jdField_a_of_type_Aulg);
    if (this.jdField_a_of_type_Attt != null) {
      this.jdField_a_of_type_Attt.clear();
    }
    if (this.c != null) {
      this.c.removeAll();
    }
    if (this.jdField_a_of_type_Aueg != null) {
      this.jdField_a_of_type_Aueg.removeAll();
    }
    if (this.b != null) {
      this.b.removeAll();
    }
    audw.b localb = new audw.b();
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.Yj;
    localb.bJE = "file_preview_time_stay";
    localb.uTime = l2;
    localb.cew = true;
    localb.bJF = aueh.getExtension(this.bGq);
    localb.nFileSize = this.uFileSize;
    audw.a(this.app.getCurrentAccountUin(), localb);
    if ((this.jdField_a_of_type_Atwe != null) && ((!this.ccO) || (this.jdField_a_of_type_Atwe.endTime < this.jdField_a_of_type_Atwe.startTime)))
    {
      this.jdField_a_of_type_Atwe.Zl = l2;
      this.jdField_a_of_type_Atwe.endTime = l1;
      this.jdField_a_of_type_Atwe.Zk = (this.jdField_a_of_type_Atwe.endTime - this.jdField_a_of_type_Atwe.startTime);
      this.jdField_a_of_type_Atwe.bIq = String.valueOf(9037);
      this.jdField_a_of_type_Atwe.bIu = ("LoadInterface[" + this.ccQ + "]");
      this.jdField_a_of_type_Atwe.cew = false;
      this.jdField_a_of_type_Atwe.doReport();
    }
    this.jdField_a_of_type_Atwe = null;
    try
    {
      if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView != null)
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(null);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.clearCache(false);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setVisibility(4);
        this.kl.removeView(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.destroy();
        this.kl.removeAllViews();
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnPause");
      }
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.onPause();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnResume");
      }
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.onResume();
    }
    super.doOnResume();
  }
  
  public String getInitString(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    if (this.diw)
    {
      Object localObject = (atvw)this.jdField_a_of_type_Attt;
      localHashMap.put("uin", ((atvw)localObject).getUin());
      localHashMap.put("uuid", this.mUuid);
      localHashMap.put("ownerType", Integer.valueOf(this.eqH));
      localHashMap.put("appid", Integer.valueOf(((atvw)localObject).getAppId()));
      localHashMap.put("tstime", Long.valueOf(NetConnInfoCenter.getServerTime()));
      localObject = ((atvw)localObject).EZ();
      if (localObject != null) {
        localHashMap.put("dirkey", localObject);
      }
    }
    localHashMap.put("domain", paramString1);
    localHashMap.put("fileType", Integer.valueOf(paramInt1));
    localHashMap.put("port", Integer.valueOf(paramInt2));
    localHashMap.put("downloadkey", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("cookie", paramString3);
    }
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = "";
    }
    localHashMap.put("path", paramString1);
    paramString1 = "javascript:qpreview.onClientResponse('init'," + audx.mapToJson(localHashMap) + ")";
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "getInitString:" + paramString1);
    }
    return paramString1;
  }
  
  void i(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Atwe != null) {
      this.jdField_a_of_type_Atwe.endTime = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Atwe != null)
      {
        this.jdField_a_of_type_Atwe.Zk = (this.jdField_a_of_type_Atwe.endTime - this.jdField_a_of_type_Atwe.startTime);
        this.jdField_a_of_type_Atwe.cew = true;
        this.jdField_a_of_type_Atwe.bIu = "";
        this.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.jdField_a_of_type_Atwe.mInitTime);
        this.jdField_a_of_type_Atwe.doReport();
      }
      this.zE.setVisibility(8);
      this.Sh.setVisibility(4);
      this.iS.setVisibility(4);
      this.iS.setOnClickListener(null);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setVisibility(0);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFnish suc[" + paramBoolean + "] retCode[" + paramLong + "]");
        paramLong = System.currentTimeMillis();
        long l = this.Yj;
        paramString = new audw.b();
        paramString.bJE = "file_preview_time_first";
        paramString.uTime = (paramLong - l);
        paramString.cew = paramBoolean;
        paramString.bJF = aueh.getExtension(this.bGq);
        paramString.nFileSize = this.uFileSize;
        audw.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_Atwe != null)
      {
        this.jdField_a_of_type_Atwe.Zk = (this.jdField_a_of_type_Atwe.endTime - this.jdField_a_of_type_Atwe.startTime);
        this.jdField_a_of_type_Atwe.cew = false;
        this.jdField_a_of_type_Atwe.bIq = String.valueOf(paramLong);
        this.jdField_a_of_type_Atwe.bIu = paramString;
        this.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.jdField_a_of_type_Atwe.mInitTime);
        this.jdField_a_of_type_Atwe.doReport();
      }
      this.zE.setVisibility(0);
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        str = getString(2131693692);
      }
      paramString = str + getString(2131693690);
      this.Sh.setText(paramString);
      this.Sh.setVisibility(0);
      this.iS.setOnClickListener(this.eP);
      this.iS.setVisibility(0);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setVisibility(4);
    }
  }
  
  void initWebView()
  {
    this.kl = ((RelativeLayout)findViewById(2131382154));
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "init WebView:" + System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView = new FileWebView(getApplicationContext());
    this.kl.addView(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView);
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "add WebView:" + System.currentTimeMillis());
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).widthPixels;
    int j = ((DisplayMetrics)localObject).heightPixels;
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = j;
    ((RelativeLayout.LayoutParams)localObject).width = i;
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    removeWebViewLayerType();
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "removeWebViewLayerType:" + System.currentTimeMillis());
    dfm();
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "initJsInterface:" + System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setWebViewClient(new atoj(this));
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "setWebViewClient:" + System.currentTimeMillis());
    localObject = new Handler();
    if (akS()) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new atok(this, (Handler)localObject));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setWebChromeClient(new ReportX5CoreWebChromeClient());
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.requestFocus();
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setFocusableInTouchMode(false);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "init WebView end:" + System.currentTimeMillis());
      localObject = this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.getSettings();
      ((WebSettings)localObject).setJavaScriptEnabled(true);
      ((WebSettings)localObject).setCacheMode(-1);
      if (this.ccL) {
        ((WebSettings)localObject).setCacheMode(2);
      }
      ((WebSettings)localObject).setBuiltInZoomControls(true);
      ((WebSettings)localObject).setSupportZoom(true);
      ((WebSettings)localObject).setUseWideViewPort(true);
      ((WebSettings)localObject).setLoadWithOverviewMode(true);
      if (Build.VERSION.SDK_INT < 16)
      {
        localObject = this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView;
        FileWebView.enablePlatformNotifications();
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "set WebView Setting:" + System.currentTimeMillis());
      return;
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(new atol(this));
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  void j(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Atwe != null) {
      this.jdField_a_of_type_Atwe.endTime = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Atwe != null)
      {
        this.jdField_a_of_type_Atwe.Zk = (this.jdField_a_of_type_Atwe.endTime - this.jdField_a_of_type_Atwe.startTime);
        this.jdField_a_of_type_Atwe.cew = true;
        this.jdField_a_of_type_Atwe.bIu = "";
        this.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.jdField_a_of_type_Atwe.mInitTime);
        this.jdField_a_of_type_Atwe.doReport();
      }
      this.zE.setVisibility(8);
      this.Sh.setVisibility(4);
      this.iS.setVisibility(4);
      this.iS.setOnClickListener(null);
      NR(1000);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setVisibility(0);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call reportGetmoreTimeV2[" + paramBoolean + "],retCode[" + paramLong + "]");
        stopTitleProgress();
        setTitle(BaseApplicationImpl.getContext().getString(2131694129));
        paramLong = System.currentTimeMillis();
        long l = this.Yj;
        paramString = new audw.b();
        paramString.bJE = "file_preview_time_more";
        paramString.uTime = (paramLong - l);
        paramString.cew = paramBoolean;
        paramString.bJF = aueh.getExtension(this.bGq);
        paramString.nFileSize = this.uFileSize;
        audw.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_Atwe != null)
      {
        this.jdField_a_of_type_Atwe.Zk = (this.jdField_a_of_type_Atwe.endTime - this.jdField_a_of_type_Atwe.startTime);
        this.jdField_a_of_type_Atwe.cew = false;
        this.jdField_a_of_type_Atwe.bIq = String.valueOf(paramLong);
        this.jdField_a_of_type_Atwe.bIu = paramString;
        this.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.jdField_a_of_type_Atwe.mInitTime);
        this.jdField_a_of_type_Atwe.doReport();
      }
      this.mProgressBar.setVisibility(8);
      this.Si.setText(2131695453);
      this.Si.setVisibility(0);
      NR(5000);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.goBack();
      return true;
    }
    return super.onBackEvent();
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6);
    
    public abstract void g(boolean paramBoolean, String paramString1, String paramString2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity
 * JD-Core Version:    0.7.0.1
 */