package com.tencent.biz.pubaccount;

import acly;
import aeay;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoag;
import aqgz;
import aqha;
import aqho;
import aqiw;
import aqju;
import aqzl;
import araz;
import araz.b;
import arbo;
import arbt;
import arcd;
import arcd.a;
import asgx;
import awit;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.FadeIconImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import jml;
import jqo;
import jzw;
import jzx;
import jzy;
import jzz;
import kaa;
import kab;
import kac;
import kae;
import kah;
import kai;
import kaj;
import kak;
import kal;
import kbp;
import kxm;
import kxm.b;
import lcc;
import lce;
import mfc;
import mqq.app.AppRuntime;
import obw;
import ocp;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import rwt;
import zxs;

public class PublicAccountBrowser
  extends QQBrowserActivity
{
  public final Pattern H = Pattern.compile("<meta.*itemprop=\"name\"\\s.*content=\"(.*)\">");
  public String Vs = "";
  private String Vt;
  private RIJRedPacketPopupView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView;
  @Nullable
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private TouchWebView.OnScrollChangedListener jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener;
  private lce jdField_a_of_type_Lce = new jzx(this);
  private int aGM;
  private int aGN;
  private Handler aS = new Handler(Looper.getMainLooper());
  private Handler aT = new Handler(Looper.getMainLooper());
  public boolean adb;
  private boolean adc;
  private boolean add;
  private RIJRedPacketPopupView jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView;
  private FadeIconImageView jdField_b_of_type_ComTencentWidgetFadeIconImageView;
  private Runnable cs;
  private ImageView hM;
  public String rowkey = "";
  
  public PublicAccountBrowser()
  {
    this.s = PublicAccountBrowserFragment.class;
  }
  
  private void RX()
  {
    if (this.jdField_b_of_type_ComTencentWidgetFadeIconImageView == null)
    {
      this.jdField_b_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131369594));
      if (this.jdField_b_of_type_ComTencentWidgetFadeIconImageView != null) {
        this.jdField_b_of_type_ComTencentWidgetFadeIconImageView.setVisibilityHandler(new jzz(this));
      }
    }
    if (this.hM == null)
    {
      this.hM = ((ImageView)findViewById(2131369599));
      if (this.hM != null) {
        this.hM.setOnClickListener(new kaa(this));
      }
    }
  }
  
  private void a(RIJRedPacketPopupView paramRIJRedPacketPopupView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, int paramInt3)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramRIJRedPacketPopupView.getLayoutParams();
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.topMargin = paramInt2;
    paramRIJRedPacketPopupView.setLayoutParams(localLayoutParams);
    paramRIJRedPacketPopupView.setText(paramCharSequence);
    paramRIJRedPacketPopupView.nO(paramBoolean2);
    if (paramBoolean2) {
      paramRIJRedPacketPopupView.setOnCloseIconClickListener(new kah(this, paramRIJRedPacketPopupView));
    }
    paramRIJRedPacketPopupView.nP(paramBoolean1);
    l(paramRIJRedPacketPopupView, true);
    this.aT.postDelayed(new PublicAccountBrowser.10(this, paramRIJRedPacketPopupView), paramInt3);
  }
  
  private void aBy()
  {
    if (!awit.aML()) {
      return;
    }
    awit.eDM();
    this.jdField_b_of_type_ComTencentWidgetFadeIconImageView.postDelayed(new PublicAccountBrowser.8(this), 200L);
  }
  
  private void aBz()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.aOP();
      QLog.i("PublicAccountBrowser", 1, "report timinggggggg");
      this.aS.removeCallbacksAndMessages(null);
      this.aT.removeCallbacksAndMessages(null);
    }
  }
  
  private String ec(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString).getQueryParameter("redpackid");
    }
    return "";
  }
  
  private void l(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || ((paramBoolean) && (paramView.getVisibility() == 0)) || ((!paramBoolean) && (paramView.getVisibility() != 0))) {
      return;
    }
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new jzw(this, paramBoolean, paramView));
      paramView.startAnimation(localAlphaAnimation);
      return;
    }
  }
  
  private void lG(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication();
    if (paramString != null)
    {
      paramString = awit.a(paramString.getRuntime(), false, true);
      if (paramString != null)
      {
        paramString = paramString.edit();
        paramString.putString("mLoadingUrl", str);
        paramString.commit();
        Log.d("KandianVideoUpload", "正在添加url" + str);
      }
    }
  }
  
  private void lH(String paramString)
  {
    int j = 1;
    kxm.b localb = new kxm.b();
    paramString = localb.a("uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())).a("rowkey", paramString).a("os", Integer.valueOf(1)).a("imsi", aqgz.getIMSI()).a("imei", kxm.iT());
    if (aqiw.isWifiConnected(BaseApplicationImpl.getContext()))
    {
      i = 2;
      paramString = paramString.a("network_type", Integer.valueOf(i));
      if (!this.add) {
        break label175;
      }
      i = 1;
      label99:
      paramString = paramString.a("is_redpack", Integer.valueOf(i)).a("redpack_style", Integer.valueOf(this.aGN));
      if (TextUtils.isEmpty(this.Vs)) {
        break label180;
      }
    }
    label175:
    label180:
    for (int i = j;; i = 0)
    {
      paramString.a("is_tips", Integer.valueOf(i)).a("page_type", Integer.valueOf(2));
      kbp.bp("0X800AD2F", localb.build());
      return;
      i = 1;
      break;
      i = 0;
      break label99;
    }
  }
  
  private void lI(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://post.mp.qq.com/kan/article/")))
    {
      String str = Uri.parse(paramString).getQueryParameter("rowkey");
      if (!TextUtils.isEmpty(str))
      {
        this.rowkey = str;
        if ((mfc.a().Dx()) && (mfc.a().Dr()) && (mfc.a().Dt()))
        {
          RIJRedPacketManager.a().a(str, new kab(this));
          mfc.a().b(new kac(this, str));
        }
        this.Vt = ec(paramString);
        if ((!TextUtils.isEmpty(this.Vt)) && (mfc.a().Dt())) {
          this.aT.postDelayed(new PublicAccountBrowser.6(this, str), 500L);
        }
      }
    }
  }
  
  private void lJ(String paramString)
  {
    RIJRedPacketManager.a().a(paramString, this.Vt, 5, new kae(this, paramString));
  }
  
  private void lK(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView == null) {
      return;
    }
    this.aS.removeCallbacksAndMessages(null);
    QLog.i("PublicAccountBrowser", 1, "resume timing:  task time has gone: " + this.aGM);
    this.cs = new PublicAccountBrowser.12(this, paramString);
    this.aS.post(this.cs);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    lG(str);
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.openQQBrowserActivity(this, str, 16L, localIntent, false, -1);
      super.finish();
      return false;
    }
    super.bSL();
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_SLIDE_RIGHT_BACK_ENABLE", true))
    {
      super.bSK();
      a(new PublicAccountCompactSwipeBackLayout(this));
      paramBundle = super.getColorNoteController();
      if (paramBundle != null) {
        paramBundle.cVy();
      }
    }
    lcc.a().b(this.jdField_a_of_type_Lce);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    lcc.a().c(this.jdField_a_of_type_Lce);
    if (!TextUtils.isEmpty(this.rowkey)) {
      lH(this.rowkey);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) && (mfc.a().Dx()) && (mfc.a().Dr()) && (mfc.a().Dt()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getVisibility() == 0)) {
      aBz();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    String str = getIntent().getStringExtra("url");
    RX();
    new Handler().postDelayed(new PublicAccountBrowser.1(this, str), 200L);
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("public_account_finish_animation_out_to_bottom", false)) {
      overridePendingTransition(0, 2130771990);
    }
  }
  
  public ColorNote getColorNote()
  {
    ColorNote localColorNote = super.getColorNote();
    if (ocp.ez(getIntent().getStringExtra("url"))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(new String(localColorNote.getReserve()));
      localJSONObject.put("h5_type_read_in_joy", true);
      localColorNote.mReserve = localJSONObject.toString().getBytes();
      return localColorNote;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PublicAccountBrowser", 1, localJSONException, new Object[0]);
    }
    return localColorNote;
  }
  
  public String hX()
  {
    return getIntent().getExtras().getString("puin");
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TouchWebView localTouchWebView = (TouchWebView)findViewById(2131382171);
    if (localTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener = new jzy(this);
      localTouchWebView.addScrollChangedListener(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TouchWebView localTouchWebView = (TouchWebView)findViewById(2131382171);
    if ((localTouchWebView != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener != null)) {
      localTouchWebView.removeScrollChangedListener(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
    }
  }
  
  public static class PublicAccountBrowserFragment
    extends WebViewFragment
  {
    protected String Vx;
    private int aGO = -1;
    protected boolean ade;
    protected boolean adf = true;
    protected boolean adg;
    protected boolean adh;
    protected boolean adi;
    protected Bundle y;
    
    private void ao(Bundle paramBundle)
    {
      if ((this.mApp != null) && (!aqiw.isNetSupport(this.mApp.getApplication()))) {
        QQToast.a(this.mApp.getApplication(), 2131696270, 0).show(super.getTitleBarHeight());
      }
      if (!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen)
      {
        paramBundle = this.y.getString("assignBackText");
        if (!TextUtils.isEmpty(paramBundle)) {
          this.jdField_a_of_type_Aqzl.leftView.setText(paramBundle);
        }
        if (this.adg) {
          break label186;
        }
        this.jdField_a_of_type_Aqzl.rightViewText.setText("");
        this.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130840667);
        this.jdField_a_of_type_Aqzl.rightViewImg.setContentDescription(super.getText(2131693966));
      }
      for (;;)
      {
        if (this.aGO == 1001)
        {
          this.jdField_a_of_type_Aqzl.leftView.setVisibility(8);
          this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
          this.jdField_a_of_type_Aqzl.rightViewText.setOnClickListener(this);
          this.jdField_a_of_type_Aqzl.rightViewText.setVisibility(0);
        }
        return;
        label186:
        this.jdField_a_of_type_Aqzl.rightViewText.setVisibility(8);
        this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
        int i = (int)aqho.convertDpToPixel(BaseApplicationImpl.getApplication(), 8.0F);
        if (this.jdField_a_of_type_Aqzl.mx != null) {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_Aqzl.mx.getLayoutParams()).setMargins(i, 0, i, 0);
        }
      }
    }
    
    public static String ed(String paramString)
    {
      Object localObject2 = null;
      Object localObject1;
      if (paramString.startsWith("qqnews://")) {
        localObject1 = "即将离开\"QQ\"\r\n打开" + "\"腾讯新闻\"";
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return localObject1;
                          if ((paramString.startsWith("tenvideo://")) || (paramString.startsWith("tenvideo2://")) || (paramString.startsWith("tenvideo3://")) || (paramString.startsWith("tencent1004498506://"))) {
                            return "即将离开\"QQ\"\r\n打开" + "\"腾讯视频\"";
                          }
                          if (paramString.startsWith("mttbrowser://")) {
                            return "即将离开\"QQ\"\r\n打开" + "\"QQ浏览器\"";
                          }
                          if (paramString.startsWith("qnreading://")) {
                            return "即将离开\"QQ\"\r\n打开" + "\"天天快报\"";
                          }
                          if ((paramString.startsWith("weishiandroidscheme://")) || (paramString.startsWith("weishi://"))) {
                            return "即将离开\"QQ\"\r\n打开" + "\"微视\"";
                          }
                          if (paramString.startsWith("tnow://")) {
                            return "即将离开\"QQ\"\r\n打开" + "\"NOW直播\"";
                          }
                          localObject1 = localObject2;
                        } while (paramString.startsWith("sms://"));
                        localObject1 = localObject2;
                      } while (paramString.startsWith("tel://"));
                      localObject1 = localObject2;
                    } while (paramString.startsWith("tel://"));
                    localObject1 = localObject2;
                  } while (paramString.startsWith("mailto://"));
                  localObject1 = localObject2;
                } while (paramString.startsWith("file://"));
                localObject1 = localObject2;
              } while (paramString.startsWith("ftp://"));
              localObject1 = localObject2;
            } while (paramString.startsWith("mqqapi://"));
            localObject1 = localObject2;
          } while (paramString.startsWith("http://"));
          localObject1 = localObject2;
        } while (paramString.startsWith("https://"));
        localObject1 = localObject2;
      } while (paramString.indexOf("://") == -1);
      return null;
    }
    
    private void initParams()
    {
      boolean bool2 = false;
      this.y = this.intent.getExtras();
      this.uin = this.y.getString("uin");
      this.Vx = this.y.getString("uin_name");
      this.uinType = this.y.getInt("uin_type");
      String str1 = this.y.getString("openid");
      String str2 = this.y.getString("token");
      Object localObject2 = this.y.getString("url");
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("WebLog_WebViewFragment", 2, "url not found, use \"\" default");
        }
        localObject1 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "get a url:" + jqo.filterKeyForLog((String)localObject1, new String[0]));
      }
      localObject2 = localObject1;
      if (((String)localObject1).startsWith("http://browserApp.p.qq.com/"))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).contains("?")) {
          localObject2 = (String)localObject1 + "?";
        }
        localObject2 = (String)localObject2 + "&openid=" + str1 + "&token=" + str2;
        this.intent.putExtra("url", (String)localObject2);
      }
      localObject1 = Uri.parse((String)localObject2);
      if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()))
      {
        localObject1 = ((Uri)localObject1).getQueryParameter("_wv");
        if (localObject1 == null) {}
      }
      try
      {
        this.jdField_a_of_type_Arcd$a.gK = Long.parseLong(((String)localObject1).trim());
        this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.gK = this.jdField_a_of_type_Arcd$a.gK;
        this.aGO = this.y.getInt("call_from");
        this.intent.removeExtra("call_from");
        this.awT = this.y.getString("puin");
        this.msgid = this.y.getString("msg_id");
        if (this.msgid == null) {
          this.msgid = "";
        }
        if (!this.y.getBoolean("hide_operation_bar"))
        {
          bool1 = true;
          this.adf = bool1;
          if ((!((String)localObject2).startsWith("http://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("http://s.p.qq.com/pub/show"))) {
            break label699;
          }
          bool1 = true;
          this.ade = bool1;
          if (!this.y.containsKey("hide_operation_bar"))
          {
            if (this.ade) {
              break label704;
            }
            bool1 = true;
            this.adf = bool1;
            localObject1 = this.intent;
            if (this.adf) {
              break label709;
            }
            bool1 = true;
            ((Intent)localObject1).putExtra("hide_operation_bar", bool1);
          }
          localObject1 = this.y.getString("webStyle");
          if ((localObject1 != null) && (((String)localObject1).equals("noBottomBar"))) {
            this.adf = false;
          }
          localObject1 = this.y.getString("disableshare");
          if (!this.y.getBoolean("hideRightButton", false))
          {
            bool1 = bool2;
            if (localObject1 != null)
            {
              bool1 = bool2;
              if (!((String)localObject1).equals("true")) {}
            }
          }
          else
          {
            bool1 = true;
          }
          this.adg = bool1;
          localObject1 = (arbt)this.jdField_a_of_type_Araz.q(4);
          if ((!this.adg) && ((this.jdField_a_of_type_Arcd$a.gK & 0x2378) == 9080L) && (!((arbt)localObject1).aGf())) {
            this.adg = true;
          }
          localObject1 = localObject2;
          if (ocp.eC((String)localObject2)) {
            localObject1 = ocp.fp((String)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 1, "initParams url = " + (String)localObject1);
          }
          this.intent.putExtra("url", (String)localObject1);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          boolean bool1;
          if (QLog.isDevelopLevel())
          {
            QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
            continue;
            bool1 = false;
            continue;
            label699:
            bool1 = false;
            continue;
            label704:
            bool1 = false;
            continue;
            label709:
            bool1 = false;
          }
        }
      }
    }
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      if ((this.intent.getIntExtra("reqType", -1) == 5) && (!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen))
      {
        kai localkai = new kai(this);
        this.jdField_a_of_type_Aqzl.leftView.setOnClickListener(localkai);
        this.jdField_a_of_type_Aqzl.rightViewText.setText(2131693029);
        this.jdField_a_of_type_Aqzl.rightViewText.setOnClickListener(localkai);
      }
      ao(paramBundle);
      return i;
    }
    
    public araz a()
    {
      return new araz(this, 127, new kaj(this));
    }
    
    public void a(Context paramContext, Uri paramUri, String paramString)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
      localIntent.addFlags(268435456);
      try
      {
        ActivityInfo localActivityInfo = localIntent.resolveActivityInfo(getActivity().getPackageManager(), 0);
        paramUri = "";
        if (localActivityInfo != null) {
          paramUri = localActivityInfo.packageName;
        }
        acly.j("scheme", paramString, paramUri, "1", "web", getActivity().getClass().getName());
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("WebLog_WebViewFragment", 1, "afterWebViewEngineHandleOverrideUrl error!", paramContext);
      }
    }
    
    public void a(Context paramContext, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4)
    {
      try
      {
        paramContext = aqha.b(paramContext, 230, null, paramString3, "", "", new kak(this, paramContext, paramUri, paramString1, paramString4), new kal(this, paramString4));
        paramContext.show();
        paramContext.setCancelable(false);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    
    public void a(DialogInterface paramDialogInterface, boolean paramBoolean, String paramString)
    {
      paramDialogInterface.dismiss();
      if (!paramBoolean) {
        if (this.mApp != null) {
          anot.a(null, "dc01160", "Pb_account_lifeservice", this.mApp.getCurrentAccountUin(), "0X80090F3", "0X80090F3", 0, 0, "", "", "", paramString);
        }
      }
      while (this.mApp == null) {
        return;
      }
      anot.a(null, "dc01160", "Pb_account_lifeservice", this.mApp.getCurrentAccountUin(), "0X80090F4", "0X80090F4", 0, 0, "", "", "", paramString);
    }
    
    public boolean a(WebView paramWebView, String paramString)
    {
      Uri localUri = Uri.parse(paramString);
      String str = localUri.getScheme();
      if ((super.getActivity().isResume()) && ((System.currentTimeMillis() - this.iJ < 1000L) || (this.authConfig.a(paramWebView.getUrl(), str).booleanValue())))
      {
        long l = System.currentTimeMillis();
        boolean bool = zxs.a().a(paramString, this);
        QLog.i("WebLog_WebViewFragment", 1, "TryPayIntercept result:" + bool + " cost:" + (System.currentTimeMillis() - l) + " ms.");
        if (!bool) {}
      }
      else
      {
        return true;
      }
      if ("2909288299".equalsIgnoreCase(this.awT))
      {
        paramString = ed(paramString);
        if (!TextUtils.isEmpty(paramString))
        {
          paramWebView = paramWebView.getUrl();
          a(getActivity(), paramWebView, localUri, "QQ", paramString, this.awT);
          return true;
        }
      }
      a(getActivity(), localUri, paramWebView.getUrl());
      return true;
    }
    
    public void aBA()
    {
      if ((this.mUrl != null) && (this.mApp != null) && (this.authConfig != null) && (!TextUtils.isEmpty(this.awT)) && (!TextUtils.isEmpty(this.authConfig.dE(this.mUrl)))) {
        this.mUrl = Uri.parse(this.mUrl).buildUpon().appendQueryParameter("puin", this.awT).appendQueryParameter("uin", this.mApp.getAccount()).toString();
      }
    }
    
    public void aBB()
    {
      super.aBB();
      if (this.aGO == 1001) {
        ThreadManager.executeOnSubThread(new PublicAccountBrowser.PublicAccountBrowserFragment.5(this));
      }
    }
    
    public boolean doOnCreate(Bundle paramBundle)
    {
      initParams();
      return super.doOnCreate(paramBundle);
    }
    
    public String getUAMark()
    {
      return "PA";
    }
    
    void lL(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = this.awT;
      }
      if (str != null)
      {
        paramString = new Intent(super.getActivity(), AccountDetailActivity.class);
        paramString.putExtra("uin", str);
        paramString.putExtra("source", 111);
        super.startActivity(paramString);
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      if (paramInt == -8) {
        rwt.ez(1, 2131697427);
      }
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public void ou(int paramInt)
    {
      Object localObject1 = getShareUrl();
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.mUrl;
      }
      if (TextUtils.isEmpty(this.awT)) {
        return;
      }
      localObject1 = "";
      Object localObject3 = Uri.parse((String)localObject2);
      try
      {
        localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "";
      }
      switch (paramInt)
      {
      default: 
      case 7: 
        kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800572A", "0X800572A", 1010, 0, this.awT, (String)localObject2, this.msgid, (String)localObject3, false);
        return;
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "shouldOverride: " + jqo.filterKeyForLog(paramString, new String[0]));
      }
      Object localObject = paramWebView.getUrl();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).startsWith("http://s.p.qq.com/pub/jump"))) {}
      for (int i = 1; (this.adf) || (!this.ade) || (i != 0); i = 0)
      {
        this.adi = false;
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("https://www.urlshare.cn/")))
        {
          localObject = getActivity();
          if ((localObject instanceof PublicAccountBrowser)) {
            PublicAccountBrowser.a((PublicAccountBrowser)localObject, paramString);
          }
        }
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!this.adh)
      {
        paramWebView = new Intent(super.getActivity(), PublicAccountBrowser.class);
        if (this.mApp != null) {
          paramWebView.putExtra("uin", this.mApp.getCurrentAccountUin());
        }
        paramWebView.putExtra("url", paramString);
        super.startActivity(paramWebView);
        return true;
      }
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    
    public class a
      extends arbt
    {
      public a() {}
      
      public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
      {
        ArrayList localArrayList1 = new ArrayList();
        arbt localarbt = (arbt)PublicAccountBrowser.PublicAccountBrowserFragment.this.a.q(4);
        if ((localarbt != null) && (localarbt.aGh()) && (!obw.a(this.qo, "menuItem:share:diandian")))
        {
          localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698635);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843490;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 34;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        if ((!obw.a(this.qo, "menuItem:share:qq")) && ((this.gK & 0x8) == 0L))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(2);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131720051);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847134;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        if ((!obw.a(this.qo, "menuItem:share:QZone")) && ((this.gK & 0x10) == 0L))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(3);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698643);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847140;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        if (((this.gK & 0x8000000) != 0L) && (awit.aMA()) && (PublicAccountBrowser.PublicAccountBrowserFragment.this.mApp != null))
        {
          localObject1 = "readinjoy_" + PublicAccountBrowser.PublicAccountBrowserFragment.this.mApp.getAccount() + "_" + 1;
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
          if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
          {
            localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698644);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839250;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 13;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
            localArrayList1.add(localObject1);
          }
        }
        if ((!obw.a(this.qo, "menuItem:share:appMessage")) && ((this.gK & 0x4000) == 0L))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(9);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698652);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847144;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        if ((!obw.a(this.qo, "menuItem:share:timeline")) && ((this.gK & 0x8000) == 0L))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(10);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698633);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847146;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        if ((localarbt != null) && (localarbt.aGg()) && (!obw.a(this.qo, "menuItem:share:sinaWeibo")))
        {
          localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698647);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839255;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 12;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        if ((!obw.a(this.qo, "menuItem:openWithQQBrowser")) && ((this.gK & 0x200) == 0L))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(5);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131720050);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847125;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        if ((!obw.a(this.qo, "menuItem:openWithSafari")) && ((this.gK & 0x100) == 0L))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(4);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131720137);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847128;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        Object localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
        if ((!obw.a(this.qo, "menuItem:share:qiDian")) && ((this.gK & 0x10) == 0L)) {
          asgx.g(BaseApplicationImpl.getApplication(), localArrayList1);
        }
        if ((!obw.a(this.qo, "menuItem:share:qiYeQQ")) && ((this.gK & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
        {
          localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698641);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130845292;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 20;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList1.add(localObject1);
        }
        ArrayList localArrayList2 = new ArrayList();
        int i;
        Object localObject2;
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
        if ((this.bfD) && (this.qp != null))
        {
          localObject1 = this.qp.iterator();
          j = 0;
          i = j;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PublicAccountJavascriptInterface.a)((Iterator)localObject1).next();
            localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
            switch (((PublicAccountJavascriptInterface.a)localObject2).itemType)
            {
            default: 
              i = j;
            }
            for (;;)
            {
              j = i;
              break;
              if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.a)localObject2).itemName)) {}
              for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131697409);; localActionSheetItem.label = ((PublicAccountJavascriptInterface.a)localObject2).itemName)
              {
                localActionSheetItem.icon = 2130843495;
                localActionSheetItem.iconNeedBg = true;
                localActionSheetItem.action = 30;
                localActionSheetItem.argus = "";
                localArrayList2.add(localActionSheetItem);
                i = 1;
                break;
              }
              localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131697470);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130843487;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 31;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
              localArrayList2.add(localObject2);
              i = 1;
            }
          }
        }
        else
        {
          i = 0;
        }
        int j = i;
        if (this.bfE)
        {
          j = i;
          if (this.qp != null)
          {
            localObject1 = this.qp.iterator();
            for (;;)
            {
              j = i;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (PublicAccountJavascriptInterface.a)((Iterator)localObject1).next();
              localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
              switch (((PublicAccountJavascriptInterface.a)localObject2).itemType)
              {
              case 2: 
              default: 
                break;
              case 1: 
                if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.a)localObject2).itemName)) {}
                for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131697409);; localActionSheetItem.label = ((PublicAccountJavascriptInterface.a)localObject2).itemName)
                {
                  localActionSheetItem.icon = 2130843495;
                  localActionSheetItem.iconNeedBg = true;
                  localActionSheetItem.action = 37;
                  localActionSheetItem.argus = "";
                  localArrayList2.add(localActionSheetItem);
                  i = 1;
                  break;
                }
              case 3: 
                localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
                ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698631);
                ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130843496;
                ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
                ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 35;
                ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
                localArrayList2.add(localObject2);
                i = 1;
              }
            }
          }
        }
        localObject1 = (arbo)PublicAccountBrowser.PublicAccountBrowserFragment.this.a.q(64);
        if ((localObject1 != null) && (((arbo)localObject1).aGe()) && (!obw.a(this.qo, "menuItem:screenShotShare")))
        {
          localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698656);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843494;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 21;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList2.add(localObject1);
        }
        if ((!obw.a(this.qo, "menuItem:favorite")) && ((this.gK & 0x2000) == 0L))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(6);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698616);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847178;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList2.add(localObject1);
        }
        if ((!obw.a(this.qo, "menuItem:exportTencentDocs")) && ((((arcd)this.jdField_a_of_type_Araz$b.c().q(2)).a.Ds & 0x4000) == 0L))
        {
          localObject2 = getShareUrl();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = PublicAccountBrowser.PublicAccountBrowserFragment.this.mUrl;
          }
          if (aoag.pL((String)localObject1))
          {
            localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698624);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130851586;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 68;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
            localArrayList2.add(localObject1);
            aoag.jI(0, 0);
          }
        }
        if ((!obw.a(this.qo, "menuItem:setFont")) && (this.bfy))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(7);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698625);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847163;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList2.add(localObject1);
        }
        if ((!obw.a(this.qo, "menuItem:copyUrl")) && ((this.gK & 0x20) == 0L))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(1);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698622);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847172;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList2.add(localObject1);
        }
        if ((!TextUtils.isEmpty(this.awT)) && ((this.gK & 0x40) == 0L) && (j == 0))
        {
          localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698657);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843487;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 8;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList2.add(localObject1);
        }
        if ((localarbt != null) && (localarbt.aGi()))
        {
          localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698637);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843492;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 38;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList2.add(localObject1);
        }
        if (!obw.a(this.qo, "menuItem:exposeArticle"))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(11);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698628);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130847202;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
          localArrayList2.add(localObject1);
        }
        return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      }
      
      public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
        int i = paramActionSheetItem.action;
        if (i == 7)
        {
          super.onItemClick(paramActionSheetItem, paramShareActionSheet);
          PublicAccountBrowser.PublicAccountBrowserFragment.this.ou(i);
        }
        do
        {
          do
          {
            return;
            if (i == 8)
            {
              PublicAccountBrowser.PublicAccountBrowserFragment.this.lL(this.awT);
              PublicAccountBrowser.PublicAccountBrowserFragment.this.ou(i);
              return;
            }
            super.onItemClick(paramActionSheetItem, paramShareActionSheet);
            if ((i != 2) && (i != 3)) {
              break;
            }
          } while (PublicAccountBrowser.PublicAccountBrowserFragment.this.mApp == null);
          anot.a(null, "CliOper", "", PublicAccountBrowser.PublicAccountBrowserFragment.this.mApp.getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
          return;
        } while ((i != 6) || (PublicAccountBrowser.PublicAccountBrowserFragment.this.mApp == null));
        anot.a(null, "CliOper", "", PublicAccountBrowser.PublicAccountBrowserFragment.this.mApp.getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static class a
  {
    public int action;
    public String argus;
    public int icon;
    public boolean iconNeedBg;
    public String label;
  }
  
  public static class b
    extends ArrayAdapter<PublicAccountBrowser.a>
  {
    private LayoutInflater inflater;
    private List<PublicAccountBrowser.a> items;
    
    public b(Context paramContext, int paramInt, List<PublicAccountBrowser.a> paramList)
    {
      super(paramInt, paramList);
      this.items = paramList;
      this.inflater = LayoutInflater.from(paramContext);
    }
    
    public PublicAccountBrowser.a a(int paramInt)
    {
      return (PublicAccountBrowser.a)this.items.get(paramInt);
    }
    
    public int getCount()
    {
      return this.items.size();
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = this.inflater.inflate(2131559309, null);
        paramView = new PublicAccountBrowser.c();
        paramView.vIcon = ((ImageView)localView.findViewById(2131373753));
        paramView.vLabel = ((TextView)localView.findViewById(2131373754));
        localView.setTag(paramView);
      }
      for (;;)
      {
        Object localObject = a(paramInt);
        paramView.a = ((PublicAccountBrowser.a)localObject);
        paramView.vLabel.setText(((PublicAccountBrowser.a)localObject).label);
        paramView.vIcon.setBackgroundResource(((PublicAccountBrowser.a)localObject).icon);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (PublicAccountBrowser.c)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
    }
  }
  
  public static class c
  {
    public PublicAccountBrowser.a a;
    ImageView vIcon;
    TextView vLabel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */