package com.tencent.gamecenter.activities;

import ahrx;
import ahrx.a;
import ahsx;
import ahtc;
import allf;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import aqzl;
import arwo;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.ReportInfoManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import jml;
import jpa;
import jqc;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.client.ClientProtocolException;
import stw;
import tau;
import tav;
import taw;
import tbb;
import tbl;

public class GameCenterActivity
  extends QQBrowserActivity
  implements Handler.Callback
{
  private static int bAR;
  private boolean aOq;
  private boolean aOr;
  private Drawable ad;
  private TouchWebView.OnScrollChangedListener b;
  public Handler bE;
  private boolean isFinish;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  
  public GameCenterActivity()
  {
    this.s = GameCenterFragment.class;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString2 = "uin=" + paramString3;
    paramString3 = new Bundle();
    paramString3.putString("Cookie", paramString2);
    try
    {
      paramContext = jqc.a(paramContext, paramString1, "POST", localBundle, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest: result:" + paramContext);
      }
      return paramContext;
    }
    catch (ClientProtocolException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:" + paramContext.getMessage());
      }
    }
    return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
  }
  
  private void bCn()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra("game_msg_enter_from", 0) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterActivity", 2, "handlePushReport() called");
      }
      localIntent.removeExtra("game_msg_enter_from");
      ahtc.report(10004, 2);
    }
  }
  
  private boolean startTitleProgress()
  {
    TextView localTextView = c().a.centerView;
    if (localTextView == null) {}
    while (this.ad != null) {
      return false;
    }
    this.ad = super.getResources().getDrawable(2130839655);
    this.mOldDrawables = localTextView.getCompoundDrawables();
    this.mOldPadding = localTextView.getCompoundDrawablePadding();
    localTextView.setCompoundDrawablePadding(10);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(this.ad, this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
    ((Animatable)this.ad).start();
    return true;
  }
  
  private boolean stopTitleProgress()
  {
    TextView localTextView = c().a.centerView;
    if (localTextView == null) {
      return false;
    }
    if (this.ad != null)
    {
      ((Animatable)this.ad).stop();
      this.ad = null;
      localTextView.setCompoundDrawablePadding(this.mOldPadding);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(this.mOldDrawables[0], this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      return true;
    }
    return false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    bAR += 1;
    bCn();
    allf.a(BaseApplicationImpl.getApplication(), new tau(this));
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnDestroy()
  {
    this.isFinish = true;
    if (this.bE != null)
    {
      this.bE.removeCallbacksAndMessages(null);
      this.bE = null;
    }
    super.doOnDestroy();
    bAR -= 1;
    if (bAR <= 0) {
      MiniMsgIPCClient.getInstance().clearBusiness(8);
    }
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 8;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    localMiniMsgUserParam.filterMsgType = 0;
    return localMiniMsgUserParam;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.isFinish) {
      return true;
    }
    switch (paramMessage.what)
    {
    case 2005: 
    default: 
      return true;
    case 2003: 
      startTitleProgress();
      this.bE.sendEmptyMessageDelayed(2004, 45000L);
      return true;
    case 2004: 
      stopTitleProgress();
      return true;
    }
    Toast.makeText(BaseApplicationImpl.getApplication(), (String)paramMessage.obj, 0).show();
    return true;
  }
  
  public boolean isNeedMiniMsg()
  {
    Intent localIntent;
    Uri localUri;
    if (!this.aOr)
    {
      localIntent = getIntent();
      localUri = null;
      if (localIntent == null) {}
    }
    try
    {
      localUri = Uri.parse(localIntent.getStringExtra("url"));
      if (localUri != null) {
        this.aOq = "1".equals(localUri.getQueryParameter("gc_mini_floating"));
      }
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    this.aOr = true;
    return this.aOq;
  }
  
  public boolean onBackEvent()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = ahsx.a().a();
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController.isFullScreenMode()))
    {
      localGameCenterVideoViewController.aUp();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((paramWebView instanceof TouchWebView)) {
      ((TouchWebView)paramWebView).setOnScrollChangedListener(this.b);
    }
  }
  
  public void setOnScrollChangedListener(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.b = paramOnScrollChangedListener;
  }
  
  public static class GameCenterFragment
    extends WebViewFragment
  {
    public static long DV;
    public static long DW;
    public static int bAS;
    public long DX;
    private String aIG = "";
    private boolean aOs;
    public boolean aOt = true;
    private AppInterface d;
    private DisplayMetrics dm;
    protected boolean isFinish;
    private String mUrl = "";
    private long startTime;
    protected String uin;
    
    private void bCo()
    {
      if (this.mApp == null) {
        this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
      }
      if (this.d == null) {
        this.d = this.mApp;
      }
      if (this.d != null) {
        this.uin = this.d.getCurrentAccountUin();
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(this.uin)) && (!TextUtils.isEmpty(this.mUrl)) && (isHomePage(this.mUrl))) {}
        try
        {
          String str = Uri.parse(this.mUrl).getQueryParameter("uin");
          if (str == null)
          {
            this.mUrl = jpa.r(this.mUrl, "uin=" + this.uin);
            this.intent.putExtra("url", this.mUrl);
          }
          return;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("GameCenterFragment", 2, "GameCenterActivity..gcRuntime is null");
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject = null;
          }
        }
      }
    }
    
    private void d(WebView paramWebView)
    {
      if (!tbb.gv("gamecenter_shot_switch")) {
        return;
      }
      QLog.i("GameCenterFragment", 1, "startMaskOpt murl=" + this.mUrl);
      Object localObject = null;
      try
      {
        String str = Uri.parse(this.mUrl).getQueryParameter("preMask");
        localObject = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("GameCenterFragment", 1, "GAMECENTER_MASK_KEY error=" + localException.toString());
        }
      }
      tbl.a().b(paramWebView, localObject, new tav(this, paramWebView));
    }
    
    private String getBid(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        paramString = Uri.parse(paramString).getQueryParameter("_bid");
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return null;
    }
    
    private boolean isHomePage(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      Object localObject = null;
      try
      {
        paramString = Uri.parse(paramString).getQueryParameter("status");
        if (TextUtils.isEmpty(paramString)) {
          return false;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localObject;
        }
      }
      return true;
    }
    
    private String nZ()
    {
      String str = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127";
      if (!TextUtils.isEmpty(this.aIG)) {
        str = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127" + "&" + this.aIG;
      }
      return str + "&st=" + this.startTime;
    }
    
    private void ue(String paramString)
    {
      String str3 = null;
      try
      {
        boolean bool = TextUtils.isEmpty(this.mUrl);
        String str1 = str3;
        if (!bool) {}
        for (;;)
        {
          try
          {
            str1 = Uri.parse(this.mUrl).getQueryParameter("status");
            if (QLog.isColorLevel()) {
              QLog.i("GameCenterFragment", 2, "parseExtraParamToReport , status" + str1);
            }
            if (!TextUtils.isEmpty(str1))
            {
              if (TextUtils.isEmpty(paramString))
              {
                paramString = "0";
                if (this.dm == null)
                {
                  this.dm = new DisplayMetrics();
                  super.getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.dm);
                }
                str3 = arwo.bE(super.getActivity().getApplicationContext());
                String str4 = this.dm.widthPixels + " * " + this.dm.heightPixels;
                paramString = ReportInfoManager.getInstance().genClickReportInfo(this.uin, str1, paramString, str3, str4);
                ReportInfoManager.getInstance().postClickReportInfo(paramString);
              }
            }
            else {
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            String str2 = str3;
          }
        }
      }
      finally {}
    }
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      if (this.a.centerView != null)
      {
        this.a.centerView.setVisibility(0);
        if ((this.a.centerView instanceof TextView)) {
          this.a.centerView.setText(2131691763);
        }
      }
      return i;
    }
    
    public void aBA()
    {
      int i = 0;
      super.aBA();
      if (jml.a().cY(this.mUrl)) {
        bCo();
      }
      if (isHomePage(this.mUrl))
      {
        Object localObject2 = getWebView().getX5WebViewExtension();
        if (localObject2 != null)
        {
          localObject1 = ahrx.a(this.mApp);
          if ((((ahrx.a)localObject1).Fa != 0L) && (((ahrx.a)localObject1).aaR != ((ahrx.a)localObject1).Fa))
          {
            if (!TextUtils.isEmpty(((ahrx.a)localObject1).bLC))
            {
              ((IX5WebViewExtension)localObject2).updateServiceWorkerBackground(this.mUrl);
              localObject2 = jpa.r(((ahrx.a)localObject1).bLC, "jump_url=" + this.mUrl);
              this.mUrl = ((String)localObject2);
              this.mUrl = ((String)localObject2);
              this.intent.putExtra("url", this.mUrl);
              QLog.e("GameCenterFragment", 1, new Object[] { "doCreateLoopStep_InitWebView: replace url with: ", this.mUrl });
            }
            ahrx.a(this.mApp, ((ahrx.a)localObject1).Fa);
          }
        }
        Object localObject1 = ahrx.a(getActivity().getIntent());
        if (localObject1 != null)
        {
          if ((((PadFaceAd)localObject1).isValid()) || (((PadFaceAd)localObject1).redPointId > 0)) {
            i = 1;
          }
          if (i != 0) {
            QQGamePadFaceFragment.a(getActivity(), (PadFaceAd)localObject1);
          }
        }
      }
    }
    
    public boolean doOnCreate(Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterFragment", 2, "game center fragment doOnCreate");
      }
      bAS += 1;
      this.startTime = System.currentTimeMillis();
      if (this.intent != null)
      {
        this.mUrl = this.intent.getStringExtra("url");
        this.aIG = this.intent.getStringExtra("redTouch");
        if (TextUtils.isEmpty(this.mUrl))
        {
          this.mUrl = nZ();
          this.intent.putExtra("url", this.mUrl);
        }
        Object localObject;
        if ((!TextUtils.isEmpty(this.mUrl)) && (isHomePage(this.mUrl)))
        {
          DV = this.intent.getLongExtra("plugin_start_time", 0L);
          if (DV == 0L) {
            localObject = null;
          }
        }
        try
        {
          String str = Uri.parse(this.mUrl).getQueryParameter("st");
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!TextUtils.isEmpty(localObject)) {
          DV = Long.valueOf(localObject).longValue();
        }
      }
      for (;;)
      {
        super.doOnCreate(paramBundle);
        this.isFinish = false;
        return true;
        Toast.makeText(super.getActivity().getApplicationContext(), 2131691761, 0).show();
        super.getActivity().finish();
      }
    }
    
    public String getUAMark()
    {
      return "gamecenter";
    }
    
    public void onDestroy()
    {
      this.isFinish = true;
      bAS -= 1;
      if (bAS == 0)
      {
        this.DX = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterFragment", 2, "enterGameCenterTime = " + DV + " , startLoadGameCenterTime = " + DW + " , exitGameCenterTime = " + this.DX);
        }
        VipUtils.a(null, "vip", "0X8004BFB", "0X8004BFB", 0, 0, new String[] { String.valueOf(DV), String.valueOf(DW), String.valueOf(this.DX) });
      }
      super.onDestroy();
      ahsx.a().cOC();
      System.gc();
      tbl.a().bCs();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if ((this.aOt) && (!this.isDestroyed))
      {
        if ((this.j == null) || (!this.j.canGoBack()) || (this.a.leftView == null)) {
          break label116;
        }
        this.a.leftView.setText(2131690700);
      }
      for (;;)
      {
        ud(paramString);
        this.aOt = false;
        if ((!TextUtils.isEmpty(paramString)) && (isHomePage(paramString)) && (tbl.a().NG()))
        {
          tbl.a().a(paramWebView, new taw(this));
          tbl.a().bCt();
        }
        super.onPageFinished(paramWebView, paramString);
        return;
        label116:
        this.a.setLeftViewName(this.intent);
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      if ((!this.aOs) && (!TextUtils.isEmpty(paramString)) && (isHomePage(paramString)))
      {
        DW = System.currentTimeMillis();
        d(paramWebView);
      }
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void ud(String paramString)
    {
      Object localObject;
      if (this.j == null) {
        localObject = null;
      }
      while ((!this.aOs) && (!paramString.startsWith("data")) && (localObject != null))
      {
        localObject = ((WebViewPluginEngine)localObject).b("offline");
        if ((localObject != null) && ((localObject instanceof stw)))
        {
          if (((stw)localObject).mOfflineLoadMode == 0) {
            ue("0");
          }
        }
        else
        {
          return;
          localObject = this.j.getPluginEngine();
          continue;
        }
        ue(jpa.dL(getBid(paramString)));
        return;
      }
      this.aOs = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */