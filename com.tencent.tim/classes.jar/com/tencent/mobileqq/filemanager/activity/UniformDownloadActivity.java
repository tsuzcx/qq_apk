package com.tencent.mobileqq.filemanager.activity;

import adph;
import agdd;
import agdf;
import agdg;
import agdh;
import agdi;
import agdj;
import agdk;
import agdl;
import agdm;
import agdn;
import aglz;
import ahal;
import ahao;
import ahav;
import ahbj;
import ahcj.b;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqiw;
import aqmj;
import arxn;
import aryb;
import aryx;
import ausj;
import ausj.a;
import auss;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import cooperation.qzone.LocalMultiProcConfig;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class UniformDownloadActivity
  extends BaseActivity
{
  public static String TAG = "UniformDownloadActivity<FileAssistant>";
  public static String bGD = "URL";
  public static String bGE = "buttonType";
  public static String bGF = "filename";
  public static String bGG = "filesize";
  public static String bGH = "filetype";
  public static String bGI = "iconpath";
  public static String bGJ = "filememo";
  public static String bGK = "isqbdownload";
  public static String bGL = "fileMimeType";
  public static String bGM = "refer_url";
  private static final String bGO = null;
  private TextView Sl;
  private TextView Sm;
  private ProgressBar Y;
  private ahcj.b a = new agdg(this);
  public QQAppInterface app;
  public final String bGN = "application/vnd.android.package-archive";
  private String bGP;
  private String bGQ = "";
  private aryx c = new agdf(this);
  private boolean ccX;
  public ausj e;
  private View.OnClickListener eS = new agdl(this);
  private ausj.a j = new agdm(this);
  private RelativeLayout km;
  private RelativeLayout kn;
  private String mDownloadUrl;
  private long mFileSize;
  private String mFilename;
  private String uin;
  
  private void IA(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.setFlags(268435456);
    try
    {
      startActivity(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  @NonNull
  private OuterCallReportModel a()
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mOuterCallMode = 1;
    localOuterCallReportModel.mOuterCallType = 1;
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    localOuterCallReportModel.mVia = "ANDROIDQQ.POPUP.YYBDOWNAPP";
    localOuterCallReportModel.mComponentName = "SplashActivity";
    return localOuterCallReportModel;
  }
  
  @NonNull
  private String a(OuterCallReportModel paramOuterCallReportModel)
  {
    return "tmast://download?downl_biz_id=ANDROIDQQ&down_ticket=" + System.currentTimeMillis() + "&downl_url=" + URLEncoder.encode(this.mDownloadUrl) + "&via=" + "ANDROIDQQ.POPUP.YYBDOWNAPP" + "&hostpname=com.tencent.mobileqq&outerCallTime=" + paramOuterCallReportModel.mOuterCallTime + "&outerCallType=" + paramOuterCallReportModel.mOuterCallType + "&outerCallMode=" + paramOuterCallReportModel.mOuterCallMode + "&hostversion=" + GlobalUtil.getAppVersionCode(this);
  }
  
  private void a(OuterCallReportModel paramOuterCallReportModel)
  {
    GlobalUtil.getInstance().setContext(getApplicationContext());
    SDKReportManager2.getInstance().postReport(15, paramOuterCallReportModel.toString());
  }
  
  private boolean akV()
  {
    return ("application/vnd.android.package-archive".equals(this.bGP)) || (this.mFilename.toLowerCase().endsWith(".apk"));
  }
  
  private boolean akW()
  {
    return arxn.fA("com.tencent.android.qqdownloader") >= 5202129;
  }
  
  private void akZ()
  {
    anot.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_click", 0, 1, 0, "", "", "", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", this.mFilename);
    localBundle.putLong("_filesize_from_dlg", this.mFileSize);
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_WEBVIEW");
    localBundle.putString("FILE_MIME_TYPE", this.bGP);
    localBundle.putString("param_refer_url", this.bGQ);
    aglz.a().a(this.mDownloadUrl, localBundle, this.a);
    dfx();
    aryb.a().d(this.uin, "", "ANDROIDQQ.POPUP.SDKDOWNAPP", "202", false);
    anot.a(null, "dc00898", "", "", "0X8008FF9", "0X8008FF9", 1, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[UniformDL]. >>> downloadFile. url:" + this.mDownloadUrl);
    }
  }
  
  private View bZ()
  {
    this.kn = new RelativeLayout(this);
    this.Y = new ProgressBar(this);
    this.Y.setIndeterminateDrawable(getResources().getDrawable(2130839657));
    this.Y.setId(241);
    this.Sl = new TextView(this);
    this.Sl.setId(242);
    this.Sl.setTextColor(-1);
    this.Sl.setTextSize(14.0F);
    this.Sm = new TextView(this);
    this.Sm.setText(2131692976);
    this.Sm.setVisibility(4);
    this.Sm.setTextColor(getResources().getColor(2131167193));
    this.Sm.setTextSize(14.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, dip2px(30.0F));
    localLayoutParams.addRule(13);
    this.kn.addView(this.Y, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 241);
    localLayoutParams.addRule(13);
    localLayoutParams.topMargin = dip2px(5.0F);
    this.kn.addView(this.Sl, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 242);
    localLayoutParams.addRule(13);
    localLayoutParams.topMargin = dip2px(5.0F);
    this.kn.addView(this.Sm, localLayoutParams);
    this.kn.setVisibility(4);
    return this.kn;
  }
  
  private void dfw()
  {
    super.setContentView(2131561057);
    Object localObject1 = (TextView)findViewById(2131381248);
    Object localObject2 = (TextView)findViewById(2131381249);
    this.km = ((RelativeLayout)findViewById(2131381247));
    if (localObject2 != null)
    {
      if (getIntent().getLongExtra(bGE, 0L) == 1L) {
        ((TextView)localObject2).setText(2131690838);
      }
      ((TextView)localObject2).setOnClickListener(new agdd(this));
    }
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener(new agdh(this));
    }
    Intent localIntent = getIntent();
    TextView localTextView1 = (TextView)findViewById(2131381253);
    TextView localTextView2 = (TextView)findViewById(2131381254);
    ImageView localImageView = (ImageView)findViewById(2131381252);
    localObject2 = localIntent.getStringExtra(bGJ);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mFilename;
    }
    localTextView1.setText((CharSequence)localObject1);
    localTextView2.setText(ahbj.g(this.mFileSize));
    int i = ahav.r(this.mFilename);
    localObject1 = localIntent.getStringExtra(bGI);
    if (i != 0) {
      localImageView.setImageResource(i);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        ((URLDrawable)localObject1).setURLDrawableListener(new agdi(this, localImageView));
        localImageView.setImageDrawable((Drawable)localObject1);
      }
      return;
      localImageView.setImageResource(2130845241);
    }
  }
  
  private void dfx()
  {
    if ((!TextUtils.isEmpty(this.mFilename)) && (this.mFilename.startsWith("qzone"))) {
      LocalMultiProcConfig.putLong("qzonedownloadtime", System.currentTimeMillis());
    }
  }
  
  private void dfz()
  {
    if (akW()) {
      aryb.a().d(this.uin, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3008", false);
    }
    while (aqiw.isNetSupport(getActivity())) {
      if (ahav.amK())
      {
        ahal.a(getActivity(), 2131693826, 2131721505, new agdn(this));
        return;
        aryb.a().d(this.uin, "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3005", false);
      }
      else
      {
        akZ();
        return;
      }
    }
    ahao.OS(2131693819);
    finish();
    overridePendingTransition(0, 0);
  }
  
  private int dip2px(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private boolean mk(String paramString)
  {
    PortalManager localPortalManager = (PortalManager)this.app.getManager(79);
    if (localPortalManager == null) {
      return true;
    }
    if (((!adph.bQc) || (!this.ccX)) && (localPortalManager.nV(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void dfy()
  {
    this.e = ((ausj)auss.a(getActivity(), null));
    int m = 1;
    Object localObject = aqmj.ac(this, "noSafeDown");
    Log.d(TAG, this.mDownloadUrl);
    if (((String)localObject).equals("true")) {
      this.e.addButton(2131690405);
    }
    for (;;)
    {
      this.e.a(this.j);
      this.e.a(new agdj(this));
      this.e.show();
      this.e.setOnKeyListener(new agdk(this));
      View localView = LayoutInflater.from(this).inflate(2131558465, null);
      localObject = (Button)localView.findViewById(2131362004);
      ((Button)localObject).setOnClickListener(this.eS);
      ((Button)localObject).setText(2131692930);
      ((Button)localObject).setTextColor(getResources().getColor(2131165229));
      this.e.addView(localView);
      if (0 != 0)
      {
        localObject = this.e;
        throw new NullPointerException();
      }
      aryb.a().d(this.uin, "", "ANDROIDQQ.POPUP", "100", false);
      anot.a(null, "dc00898", "", "", "0X8008FF8", "0X8008FF8", 1, 0, "", "", "", "");
      return;
      int k = 0;
      int i = k;
      if (akV())
      {
        boolean bool = mk(this.mDownloadUrl);
        i = k;
        m = bool;
        if (bool)
        {
          DownloadSDKConfigManager.isDownloadUrlBlocked(this, this.mDownloadUrl);
          i = 1;
          Log.d(TAG, "url is blocked!! show only normal download");
          m = bool;
        }
      }
      if (m != 0)
      {
        if (i != 0) {
          this.e.addButton(2131690405);
        } else {
          this.e.addButton(2131692931);
        }
      }
      else if (0 == 0) {
        this.e.addButton(2131690406);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.mDownloadUrl = paramBundle.getStringExtra(bGD);
    this.mFilename = paramBundle.getStringExtra(bGF);
    this.mFileSize = paramBundle.getLongExtra(bGG, 0L);
    this.bGP = paramBundle.getStringExtra(bGL);
    this.bGQ = paramBundle.getStringExtra(bGM);
    this.ccX = paramBundle.getBooleanExtra("fromArkAppDownload", false);
    this.app = ((QQAppInterface)getAppRuntime());
    this.uin = this.app.getCurrentAccountUin();
    if (paramBundle.getBooleanExtra(bGK, false)) {
      dfw();
    }
    for (;;)
    {
      if (this.bGQ == null) {
        this.bGQ = "";
      }
      return true;
      setContentView(bZ(), new FrameLayout.LayoutParams(-1, -1));
      dfy();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new UniformDownloadActivity.9(this));
    aglz.a().IW(this.mDownloadUrl);
    this.app = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity
 * JD-Core Version:    0.7.0.1
 */