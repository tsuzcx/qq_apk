package com.tencent.biz.pubaccount.readinjoy.activity;

import aeay;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqfo;
import aqhu;
import aqzl;
import araz;
import araz.b;
import arbt;
import arbz;
import arcd;
import arcd.a;
import aviz;
import awit;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kgy;
import kgz;
import khb;
import kxm;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ocp;
import odv;
import skj;
import sum;
import tzd;

public class ReadInJoyArticleDetailActivity
  extends QQBrowserActivity
{
  protected String Zk;
  private boolean aeS;
  private boolean aeT = true;
  boolean aeU;
  public BrowserAppInterface browserApp;
  skj c = null;
  protected int channelId;
  private int fromType;
  public String hashName;
  public Object lock = new Object();
  private long mAlgorithmID;
  public volatile AppInterface mApp;
  private int mStrategyId;
  private long rV;
  private long rW;
  protected long rX;
  protected long recommendSeq;
  private byte[] result;
  protected String rowKey;
  protected String subscribeName;
  protected String url;
  
  public ReadInJoyArticleDetailActivity()
  {
    this.s = ReadInJoyArticleDetailFragment.class;
  }
  
  private void aCL()
  {
    if ((getIntent() != null) && (!getIntent().getBooleanExtra("from_native", false))) {
      return;
    }
    getMainLooper();
    Looper.myQueue().addIdleHandler(new kgz(this));
  }
  
  private void aCN() {}
  
  public byte[] C()
  {
    synchronized (this.lock)
    {
      if (this.result == null)
      {
        boolean bool = TextUtils.isEmpty(this.hashName);
        if (bool) {}
      }
      try
      {
        this.lock.wait(500L);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetail", 2, "等待结束时间时" + System.currentTimeMillis());
        }
        if (this.result == null) {
          this.hashName = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetail", 2, "返回结果时间" + System.currentTimeMillis());
        }
        return this.result;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  public void aCJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetail", 2, "请求开始时间" + System.currentTimeMillis());
    }
    this.c.b(this.hashName, new kgy(this));
  }
  
  @TargetApi(14)
  public void aCK()
  {
    WebViewFragment localWebViewFragment = c();
    if ((localWebViewFragment instanceof ReadInJoyArticleDetailFragment))
    {
      ((ReadInJoyArticleDetailFragment)localWebViewFragment).aCK();
      return;
    }
    QLog.e("ReadInJoyArticleDetail", 1, "setWebViewVisibility error curFragment error");
  }
  
  public void aCM()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label105;
      }
      if ((!aqfo.isMIUI()) && (!aqfo.isFlyme())) {
        this.mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label105:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      lU(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while (paramInt2 != 1)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      anot.a(null, "CliOper", "", "", "0X8005438", "0X8005438", 0, 0, "", "", "", "");
      aviz.A(this, paramIntent);
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.mApp != null) && ((this.mApp instanceof BrowserAppInterface))) {
      this.browserApp = ((BrowserAppInterface)this.mApp);
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.1(this));
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.3(this));
    if (this.c != null) {
      this.c.bzk();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.rW = System.currentTimeMillis();
    long l = this.rW - this.rV;
    if ((l > 0L) && (this.rX > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "start to report article read info:" + kxm.a(this.rowKey, this.mAlgorithmID, 0));
      }
      if (!odv.aT(this.channelId)) {
        break label281;
      }
    }
    label281:
    for (Object localObject = "0X8009359";; localObject = "0X80066FB")
    {
      kbp.a(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, Long.toString(l / 1000L), Long.toString(this.rX), Integer.toString(this.mStrategyId), kxm.a(this.rowKey, this.mAlgorithmID, 0), false);
      localObject = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = kxm.getLongAccountUin();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = this.rX;
      localReportInfo.mChannelId = this.channelId;
      localReportInfo.mAlgorithmId = ((int)this.mAlgorithmID);
      localReportInfo.mStrategyId = this.mStrategyId;
      localReportInfo.mOperation = 9;
      localReportInfo.mReadTimeLength = ((int)(l / 1000L));
      localReportInfo.mInnerId = this.rowKey;
      ((List)localObject).add(localReportInfo);
      ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.2(this, (List)localObject));
      if (this.c != null) {
        this.c.bzr();
      }
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.rV = System.currentTimeMillis();
    aCM();
    aCL();
    aCN();
  }
  
  public boolean du(String paramString)
  {
    return paramString.equalsIgnoreCase(this.hashName);
  }
  
  @TargetApi(23)
  public void lU(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  @TargetApi(12)
  public void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      finish();
      return;
    }
    this.url = localBundle.getString("url");
    this.aeS = localBundle.getBoolean("ip_connect", false);
    this.hashName = localBundle.getString("read_in_joy_from_cache");
    String str = PreloadManager.fk(this.url);
    this.Zk = localBundle.getString("preload_iamge_url");
    this.aeU = localBundle.getBoolean("from_native", false);
    if (this.aeU) {
      this.aeT = false;
    }
    if (this.c == null)
    {
      this.c = skj.a();
      this.c.bzj();
    }
    if ((!TextUtils.isEmpty(this.hashName)) && (!TextUtils.isEmpty(str)) && (str.equals(this.hashName)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "在onCreate中执行操作的时间时" + System.currentTimeMillis());
      }
      aCJ();
    }
    super.onCreate(paramBundle);
    if (this.url == null)
    {
      QLog.d("ReadInJoyArticleDetail", 2, "initModel url empty");
      return;
    }
    this.subscribeName = localBundle.getString("subscribename");
    if (this.subscribeName == null) {
      this.subscribeName = "";
    }
    paramBundle = String.valueOf(53);
    str = localBundle.getString("from");
    if (str == null) {}
    for (;;)
    {
      this.fromType = Integer.valueOf(paramBundle).intValue();
      this.rX = localBundle.getLong("articleid", -1L);
      this.rowKey = localBundle.getString("row_key", "");
      this.channelId = localBundle.getInt("channelid", -1);
      this.mStrategyId = localBundle.getInt("strategyid", -1);
      this.mAlgorithmID = localBundle.getLong("algorithmid", -1L);
      this.recommendSeq = localBundle.getLong("recommendSeq", -1L);
      if (!localIntent.hasExtra("big_brother_source_key")) {
        localIntent.putExtra("big_brother_source_key", kxm.bg(this.channelId));
      }
      paramBundle = super.getColorNoteController();
      if (paramBundle == null) {
        break;
      }
      paramBundle.cVA();
      paramBundle.Hc(false);
      return;
      paramBundle = str;
    }
  }
  
  public static class ReadInJoyArticleDetailFragment
    extends WebViewFragment
  {
    public static final String TAG = ReadInJoyArticleDetailFragment.class.getSimpleName();
    public String Zl = "-1";
    public boolean aeV;
    public boolean aeW;
    public ImageView hW;
    public long mCreateTime;
    public long mPageStartTime;
    public long rY;
    public long rZ;
    
    private void aCO()
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null)
      {
        localObject = (AppInterface)((AppRuntime)localObject).getAppRuntime("modular_web");
        if (localObject != null)
        {
          localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject).getCurrentAccountUin(), 4);
          if (localObject != null)
          {
            this.aeV = ((SharedPreferences)localObject).getBoolean("readInJoy_loading_img", false);
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "showGif" + this.aeV);
            }
          }
        }
      }
    }
    
    private void aCQ()
    {
      int j = 2;
      long l1 = this.intent.getLongExtra("click_time", -1L);
      long l2 = this.intent.getLongExtra("available_memory", -1L);
      boolean bool = this.intent.getBooleanExtra("preload_tool_white_list", false);
      int i;
      if (this.jdField_a_of_type_Arbz.isWebViewCache)
      {
        i = 2;
        if (i == 0) {
          break label103;
        }
        i = 1;
      }
      for (;;)
      {
        if (l1 > 0L) {
          ThreadManager.post(new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.3(this, l2, l1, i, bool), 8, null, true);
        }
        return;
        if (arbz.aeo)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        label103:
        i = j;
        if (!arbz.cXW) {
          i = 0;
        }
      }
    }
    
    public araz a()
    {
      return new araz(this, 127, new khb(this));
    }
    
    public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, tzd paramtzd)
    {
      this.jdField_a_of_type_Aqzl.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramtzd);
      if ((this.jdField_a_of_type_Aqzl.leftView != null) && (this.jdField_a_of_type_Aqzl.rightViewImg != null) && (this.jdField_a_of_type_Aqzl.aK != null) && (!paramBoolean) && (paramInt1 == 4))
      {
        if ((this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl) || (this.jdField_a_of_type_Arcd$a.cYw)) {
          break label128;
        }
        this.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130850361);
        this.jdField_a_of_type_Aqzl.Yg(-16777216);
      }
      for (;;)
      {
        ((arbt)this.jdField_a_of_type_Araz.q(4)).ehb();
        this.jdField_a_of_type_Arcd.ehp();
        return;
        label128:
        paramString1 = aqhu.d(getResources().getDrawable(2130850361), -1);
        this.jdField_a_of_type_Aqzl.rightViewImg.setImageDrawable(paramString1);
        this.jdField_a_of_type_Aqzl.Yg(-1);
      }
    }
    
    @TargetApi(14)
    public void aCK()
    {
      if (!this.aeV) {
        return;
      }
      ThreadManager.getUIHandler().post(new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.2(this));
    }
    
    public void aCP()
    {
      this.rY = System.currentTimeMillis();
      super.aCP();
    }
    
    public void d(Intent paramIntent, String paramString)
    {
      super.d(paramIntent, paramString);
      if ((this.jdField_a_of_type_Aqzl.leftView != null) && (this.jdField_a_of_type_Aqzl.rightViewImg != null) && (this.jdField_a_of_type_Aqzl.aK != null))
      {
        if ((this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl) || (this.jdField_a_of_type_Arcd$a.cYw)) {
          break label92;
        }
        this.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130850361);
        this.jdField_a_of_type_Aqzl.Yg(-16777216);
      }
      for (;;)
      {
        this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(0);
        return;
        label92:
        paramIntent = aqhu.d(getResources().getDrawable(2130850361), -1);
        this.jdField_a_of_type_Aqzl.rightViewImg.setImageDrawable(paramIntent);
        this.jdField_a_of_type_Aqzl.Yg(-1);
      }
    }
    
    @TargetApi(12)
    public boolean doOnCreate(Bundle paramBundle)
    {
      this.mCreateTime = System.currentTimeMillis();
      Bundle localBundle = this.intent.getExtras();
      String str = localBundle.getString("url");
      Object localObject = str;
      if (ocp.eC(str))
      {
        localObject = ocp.fp(str);
        localBundle.putString("url", (String)localObject);
        this.intent.putExtra("url", (String)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "doOnCreate url = " + (String)localObject);
      }
      try
      {
        bool = super.doOnCreate(paramBundle);
        paramBundle = localBundle.getString("preload_iamge_url");
        if (this.mPluginEngine != null)
        {
          localObject = (sum)this.mPluginEngine.b("pubAccountPreload");
          if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
            ((sum)localObject).aG(paramBundle, true);
          }
        }
        aCO();
        return bool;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          boolean bool = false;
        }
      }
    }
    
    public void initWebView()
    {
      super.initWebView();
      if (this.j != null) {
        this.j.setMask(false);
      }
      boolean bool = this.intent.getExtras().getBoolean("ip_connect", false);
      if ((this.j != null) && (bool))
      {
        localIX5WebSettingsExtension = this.j.getSettingsExtension();
        i = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "tbsCoreVersion: " + i);
        }
        if ((localIX5WebSettingsExtension != null) && (i >= 36855))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "rij webview use ip connect");
          }
          localArrayList = new ArrayList();
          localArrayList.add("post.mp.qq.com");
          localArrayList.add("*.qpic.cn");
          localIX5WebSettingsExtension.setHttpDnsDomains(localArrayList);
        }
      }
      while (!QLog.isColorLevel())
      {
        IX5WebSettingsExtension localIX5WebSettingsExtension;
        int i;
        ArrayList localArrayList;
        return;
      }
      QLog.d(TAG, 2, "ipConnect: " + bool);
    }
    
    public void onDestroy()
    {
      if (!this.aeW) {
        aCQ();
      }
      super.onDestroy();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      boolean bool = this.jdField_a_of_type_Arbz.cXR;
      super.onPageFinished(paramWebView, paramString);
      if (bool)
      {
        this.rZ = System.currentTimeMillis();
        this.aeW = true;
        paramWebView = BaseApplicationImpl.getApplication().getRuntime();
        if (paramWebView != null) {
          if (!awit.Q(paramWebView)) {
            break label62;
          }
        }
      }
      label62:
      for (paramWebView = "1";; paramWebView = "0")
      {
        this.Zl = paramWebView;
        aCQ();
        return;
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      boolean bool = this.jdField_a_of_type_Arbz.mIsFirstOnPageStart;
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (bool) {
        this.mPageStartTime = System.currentTimeMillis();
      }
    }
    
    public boolean showPreview()
    {
      boolean bool = super.showPreview();
      if ((this.jdField_a_of_type_Aqzl != null) && (this.jdField_a_of_type_Aqzl.leftView != null) && (this.jdField_a_of_type_Aqzl.rightViewImg != null) && (this.jdField_a_of_type_Aqzl.aK != null))
      {
        this.jdField_a_of_type_Aqzl.leftView.setBackgroundResource(2130850370);
        this.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130839618);
        if ((!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl) && (!this.jdField_a_of_type_Arcd$a.cYw))
        {
          this.jdField_a_of_type_Aqzl.aK.setBackgroundResource(0);
          this.jdField_a_of_type_Aqzl.aK.setBackgroundColor(-1);
          if (this.jdField_a_of_type_Arcd.mLoadingProgressBar != null) {
            this.jdField_a_of_type_Arcd.mLoadingProgressBar.setCustomColor(-1);
          }
          if (this.Js != null)
          {
            this.Js.setBackgroundColor(-1);
            this.jdField_a_of_type_Arcd$a.cYs = true;
          }
          this.jdField_a_of_type_Aqzl.Yh(-16777216);
          this.jdField_a_of_type_Aqzl.Yj(-16777216);
          this.jdField_a_of_type_Aqzl.leftView.setBackgroundResource(2130850369);
          this.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130850361);
          this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(0);
        }
      }
      if (this.avR)
      {
        View localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        getActivity().addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
      }
      return bool;
    }
    
    public class a
      extends arcd
    {
      public a() {}
      
      public void aCR()
      {
        super.aCR();
        if ((this.a.getWebView() != null) && (ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.this.aeV) && (ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.this.j != null) && (this.eQ != null))
        {
          ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.this.hW = new ImageView(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.this));
          ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.this.hW.setImageResource(2130842498);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(13);
          ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.this.hW.setLayoutParams(localLayoutParams);
          this.eQ.addView(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.this.hW);
          if (IPluginAdapterProxy.getProxy().isNightMode())
          {
            this.eQ.setBackgroundColor(-6710887);
            ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.this.hW.setImageResource(2130842499);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity
 * JD-Core Version:    0.7.0.1
 */