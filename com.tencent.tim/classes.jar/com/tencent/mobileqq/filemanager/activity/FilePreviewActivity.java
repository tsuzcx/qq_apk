package com.tencent.mobileqq.filemanager.activity;

import aetp;
import aetq;
import agbn;
import agbo;
import agbp;
import agbs;
import agbt;
import agbu;
import agbv;
import agbw;
import agbx;
import agby;
import agbz;
import agkf;
import agku;
import agmx;
import agmy;
import agnf;
import ahau;
import ahau.a;
import ahav;
import ahbi;
import ahbj;
import ahcc;
import android.annotation.SuppressLint;
import android.content.Intent;
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
import aobe;
import arhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.a;
import com.tencent.mobileqq.filemanager.widget.FileWebView.b;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebChromeClient;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Map;
import wja;

@SuppressLint({"NewApi"})
public class FilePreviewActivity
  extends BaseFileViewerActivity
{
  private arhz P;
  TextView Sg = null;
  public TextView Sh = null;
  public TextView Si = null;
  final String TAG = "<FileAssistant>FilePreviewActivity";
  long Yj = 0L;
  long Yk = 0L;
  agku jdField_a_of_type_Agku = null;
  public agnf a;
  ahbi jdField_a_of_type_Ahbi = null;
  private aobe jdField_a_of_type_Aobe = new agbn(this);
  FilePreviewActivity.a jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$a = null;
  public FileWebView.a a;
  public FileWebView a;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  ahbi b = null;
  public String bGp;
  public String bGq;
  public String bGr = null;
  String bGs = null;
  public String bGt;
  public String bGu;
  public String bGv;
  public String bGw;
  String bGx = null;
  ahbi c;
  public int cWD = -1;
  int cWE = -1;
  public boolean ccL = false;
  public boolean ccM = false;
  boolean ccN = false;
  public boolean ccO = false;
  boolean ccP = false;
  public boolean ccQ = false;
  public boolean ccR = false;
  View.OnClickListener eP = null;
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
    this.jdField_a_of_type_Agnf = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$a = null;
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
    Object localObject = agmx.j(this, this.bGq, "FileType");
    this.bGw = agmx.j(this, this.bGq, "InterfacePage");
    String str = agmx.j(this, this.bGq, "PreviewMode");
    this.bGu = paramIntent.getStringExtra("offline_file_domain");
    this.bGv = paramIntent.getStringExtra("offline_file_port");
    this.bGt = paramIntent.getStringExtra("offline_file_domain_key");
    this.nFileType = paramIntent.getIntExtra("offline_file_type_key", -1);
    this.strCookie = paramIntent.getStringExtra("COOKIE");
    this.ccN = paramIntent.getBooleanExtra("offline_file_show_team_work_menu", false);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.dNQ = 3;
    }
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
        break label348;
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
        break label433;
      }
      this.jdField_a_of_type_Agku = this.app.a().a();
      if (this.jdField_a_of_type_Agku != null) {
        break label357;
      }
      QLog.e("<FileAssistant>FilePreviewActivity", 1, "controller is null, should finish it!");
      finish();
      return false;
      this.ccL = ahav.jP(this.cWE);
      break;
      label348:
      setContentView(2131561046);
    }
    label357:
    this.bGx = String.valueOf(this.jdField_a_of_type_Agku.Em());
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$a == null) {
      dfh();
    }
    this.jdField_a_of_type_Agku.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$a);
    this.leftView.setVisibility(8);
    this.uFileSize = paramIntent.getLongExtra("offline_file_size", 0L);
    startTitleProgress();
    if (this.ccL) {
      this.ccR = true;
    }
    for (;;)
    {
      return true;
      label433:
      this.bGp = paramIntent.getStringExtra("offline_file_url");
      this.leftView.setVisibility(0);
      this.leftView.setText(2131690700);
      if (this.bGp != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.bGp);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "mWebView.loadUrl(" + this.bGp + ")");
      this.mUuid = paramIntent.getStringExtra("OfflinePreZipUUID");
      break;
      paramIntent = agmx.b(this, "OnlinePreView", "RotateScreen", "FunctionalSwitch");
      if (paramIntent == null) {
        return true;
      }
      if (Integer.parseInt(paramIntent) == 0) {
        return true;
      }
      setRequestedOrientation(-1);
    }
  }
  
  private FileWebView.b a()
  {
    return new agbz(this, new Handler());
  }
  
  private WebViewClient a()
  {
    return new agby(this);
  }
  
  private boolean akT()
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "call controller.sendCS()");
    }
    this.Yj = System.currentTimeMillis();
    this.jdField_a_of_type_Agnf = new agnf(this.app.getCurrentAccountUin());
    agnf localagnf1 = this.jdField_a_of_type_Agnf;
    agnf localagnf2 = this.jdField_a_of_type_Agnf;
    long l = System.currentTimeMillis();
    localagnf2.mInitTime = l;
    localagnf1.startTime = l;
    this.jdField_a_of_type_Agnf.bGx = String.valueOf(this.bGx);
    this.jdField_a_of_type_Agnf.bIw = "1";
    this.jdField_a_of_type_Agnf.bIt = this.bGq;
    this.jdField_a_of_type_Agnf.bIv = ahbj.getExtension(this.bGq).replace(".", "").toLowerCase();
    this.jdField_a_of_type_Agnf.mFileSize = this.uFileSize;
    return this.jdField_a_of_type_Agku.alr();
  }
  
  private FileWebView.b b()
  {
    return new agbo(this);
  }
  
  private void bX(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.ccN) {
      return;
    }
    View localView2 = ((ViewStub)findViewById(2131365442)).inflate();
    localView2.setPadding(0, 0, 70, 120);
    View localView1 = localView2.findViewById(2131380969);
    localView2 = localView2.findViewById(2131380970);
    this.app.addObserver(this.jdField_a_of_type_Aobe);
    if (!paramBoolean1)
    {
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
      label78:
      if (paramBoolean2) {
        break label176;
      }
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((localView1 != null) && (paramBoolean1)) {
        localView1.setOnClickListener(new agbu(this));
      }
      if ((localView2 == null) || (!paramBoolean2)) {
        break;
      }
      localView2.setOnClickListener(new agbv(this));
      return;
      anot.a(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      break label78;
      label176:
      anot.a(this.app, "dc00898", "", "", "0X8008A30", "0X8008A30", 0, 0, "", "", "", "");
    }
  }
  
  private void dfg()
  {
    if (this.eP != null) {
      return;
    }
    this.eP = new agbw(this);
  }
  
  private void dfh()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$a = new agbx(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String kM(String paramString)
  {
    int k = paramString.lastIndexOf("/") + 1;
    int j = paramString.lastIndexOf("&");
    int i = j;
    if (j < k) {
      i = paramString.length();
    }
    return paramString.substring(k, i);
  }
  
  public void NR(int paramInt)
  {
    runOnUiThread(new FilePreviewActivity.15(this, paramInt));
  }
  
  boolean akS()
  {
    return (this.cWE != agmy.cXT) && (!ahav.jP(this.cWE)) && (!this.ccL);
  }
  
  void dfi()
  {
    runOnUiThread(new FilePreviewActivity.11(this));
  }
  
  public void dfj()
  {
    runOnUiThread(new FilePreviewActivity.12(this));
  }
  
  public void dfk()
  {
    runOnUiThread(new FilePreviewActivity.13(this));
  }
  
  public void dfl()
  {
    runOnUiThread(new FilePreviewActivity.14(this));
  }
  
  void dfm()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$a != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$a = new agbp(this);
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
    setRightButton(2131721059, new agbs(this));
    this.mTitleBar = ((ViewGroup)findViewById(2131377361));
    this.iR = ((LinearLayout)findViewById(2131368014));
    this.iR.setVisibility(4);
    this.Sg = ((TextView)findViewById(2131372832));
    this.Sg.setVisibility(4);
    Object localObject = aetq.a();
    boolean bool1 = ((aetp)localObject).ahR();
    boolean bool2 = ((aetp)localObject).ahS();
    if ((bool2) || (!ahcc.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo)))
    {
      bX(bool1, bool2);
      this.zE = ((ImageView)findViewById(2131366494));
      this.Sh = ((TextView)findViewById(2131377221));
      this.zE.setVisibility(8);
      this.mProgressBar = ((ProgressBar)findViewById(2131368015));
      this.Si = ((TextView)findViewById(2131368013));
      this.iS = ((LinearLayout)findViewById(2131377232));
      setTitle(BaseApplicationImpl.getContext().getString(2131694129));
      if (this.cWD != 0) {
        break label355;
      }
      akT();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
      dfg();
      return true;
      localObject = (ViewStub)findViewById(2131378858);
      if ((!this.ccN) || (!bool1)) {
        break;
      }
      localObject = ((ViewStub)localObject).inflate();
      this.app.addObserver(this.jdField_a_of_type_Aobe);
      anot.a(this.app, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      ahcc.a(this.app, this, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, new agbt(this));
      break;
      label355:
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
    this.app.removeObserver(this.jdField_a_of_type_Aobe);
    if (this.jdField_a_of_type_Agku != null) {
      this.jdField_a_of_type_Agku.clear();
    }
    if (this.c != null) {
      this.c.removeAll();
    }
    if (this.jdField_a_of_type_Ahbi != null) {
      this.jdField_a_of_type_Ahbi.removeAll();
    }
    if (this.b != null) {
      this.b.removeAll();
    }
    ahau.a locala = new ahau.a();
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.Yj;
    locala.bJE = "file_preview_time_stay";
    locala.uTime = l2;
    locala.cew = true;
    locala.bJF = ahbj.getExtension(this.bGq);
    locala.nFileSize = this.uFileSize;
    ahau.a(this.app.getCurrentAccountUin(), locala);
    if ((this.jdField_a_of_type_Agnf != null) && ((!this.ccO) || (this.jdField_a_of_type_Agnf.endTime < this.jdField_a_of_type_Agnf.startTime)))
    {
      this.jdField_a_of_type_Agnf.Zl = l2;
      this.jdField_a_of_type_Agnf.endTime = l1;
      this.jdField_a_of_type_Agnf.Zk = (this.jdField_a_of_type_Agnf.endTime - this.jdField_a_of_type_Agnf.startTime);
      this.jdField_a_of_type_Agnf.bIq = String.valueOf(9037);
      this.jdField_a_of_type_Agnf.bIu = ("LoadInterface[" + this.ccQ + "]");
      this.jdField_a_of_type_Agnf.cew = false;
      this.jdField_a_of_type_Agnf.doReport();
    }
    this.jdField_a_of_type_Agnf = null;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.clearCache(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
        this.kl.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.destroy();
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnPause");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.onPause();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "doOnResume");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.onResume();
    }
    super.doOnResume();
  }
  
  public String getInitString(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
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
    paramString1 = "javascript:qpreview.onClientResponse('init'," + ahav.mapToJson(localHashMap) + ")";
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "getInitString:" + paramString1);
    }
    return paramString1;
  }
  
  public void i(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Agnf != null) {
      this.jdField_a_of_type_Agnf.endTime = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Agnf != null)
      {
        this.jdField_a_of_type_Agnf.Zk = (this.jdField_a_of_type_Agnf.endTime - this.jdField_a_of_type_Agnf.startTime);
        this.jdField_a_of_type_Agnf.cew = true;
        this.jdField_a_of_type_Agnf.bIu = "";
        this.jdField_a_of_type_Agnf.Zl = (System.currentTimeMillis() - this.jdField_a_of_type_Agnf.mInitTime);
        this.jdField_a_of_type_Agnf.doReport();
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFnish suc[" + paramBoolean + "] retCode[" + paramLong + "]");
        paramLong = System.currentTimeMillis();
        long l = this.Yj;
        paramString = new ahau.a();
        paramString.bJE = "file_preview_time_first";
        paramString.uTime = (paramLong - l);
        paramString.cew = paramBoolean;
        paramString.bJF = ahbj.getExtension(this.bGq);
        paramString.nFileSize = this.uFileSize;
        ahau.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_Agnf != null)
      {
        this.jdField_a_of_type_Agnf.Zk = (this.jdField_a_of_type_Agnf.endTime - this.jdField_a_of_type_Agnf.startTime);
        this.jdField_a_of_type_Agnf.cew = false;
        this.jdField_a_of_type_Agnf.bIq = String.valueOf(paramLong);
        this.jdField_a_of_type_Agnf.bIu = paramString;
        this.jdField_a_of_type_Agnf.Zl = (System.currentTimeMillis() - this.jdField_a_of_type_Agnf.mInitTime);
        this.jdField_a_of_type_Agnf.doReport();
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
    }
  }
  
  void initWebView()
  {
    this.kl = ((RelativeLayout)findViewById(2131382154));
    Object localObject = new HashMap();
    ((HashMap)localObject).put("data_directory_suffix", "qfile");
    QbSdk.initTbsSettings((Map)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView = new FileWebView(getApplicationContext());
    this.kl.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView);
    localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).widthPixels;
    int j = ((DisplayMetrics)localObject).heightPixels;
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = j;
    ((RelativeLayout.LayoutParams)localObject).width = i;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    removeWebViewLayerType();
    dfm();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebViewClient(a());
    if (akS()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setWebChromeClient(new ReportX5CoreWebChromeClient());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setFocusableInTouchMode(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.getSettings();
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView;
        FileWebView.enablePlatformNotifications();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOnCustomScroolChangeListener(b());
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j(boolean paramBoolean, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Agnf != null) {
      this.jdField_a_of_type_Agnf.endTime = System.currentTimeMillis();
    }
    stopTitleProgress();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Agnf != null)
      {
        this.jdField_a_of_type_Agnf.Zk = (this.jdField_a_of_type_Agnf.endTime - this.jdField_a_of_type_Agnf.startTime);
        this.jdField_a_of_type_Agnf.cew = true;
        this.jdField_a_of_type_Agnf.bIu = "";
        this.jdField_a_of_type_Agnf.Zl = (System.currentTimeMillis() - this.jdField_a_of_type_Agnf.mInitTime);
        this.jdField_a_of_type_Agnf.doReport();
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call reportGetmoreTimeV2[" + paramBoolean + "],retCode[" + paramLong + "]");
        stopTitleProgress();
        setTitle(BaseApplicationImpl.getContext().getString(2131694129));
        paramLong = System.currentTimeMillis();
        long l = this.Yj;
        paramString = new ahau.a();
        paramString.bJE = "file_preview_time_more";
        paramString.uTime = (paramLong - l);
        paramString.cew = paramBoolean;
        paramString.bJF = ahbj.getExtension(this.bGq);
        paramString.nFileSize = this.uFileSize;
        ahau.a(this.app.getCurrentAccountUin(), paramString);
        return;
      }
      catch (NullPointerException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setOverrideOnCheckIsTextEditor(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(0);
        continue;
      }
      if (this.jdField_a_of_type_Agnf != null)
      {
        this.jdField_a_of_type_Agnf.Zk = (this.jdField_a_of_type_Agnf.endTime - this.jdField_a_of_type_Agnf.startTime);
        this.jdField_a_of_type_Agnf.cew = false;
        this.jdField_a_of_type_Agnf.bIq = String.valueOf(paramLong);
        this.jdField_a_of_type_Agnf.bIu = paramString;
        this.jdField_a_of_type_Agnf.Zl = (System.currentTimeMillis() - this.jdField_a_of_type_Agnf.mInitTime);
        this.jdField_a_of_type_Agnf.doReport();
      }
      this.mProgressBar.setVisibility(8);
      this.Si.setText(2131695453);
      this.Si.setVisibility(0);
      NR(5000);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.goBack();
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity
 * JD-Core Version:    0.7.0.1
 */