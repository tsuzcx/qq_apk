package com.tencent.mobileqq.fragment;

import acfp;
import acig;
import acih;
import aehy;
import ahnn;
import ahno;
import ahnp;
import ahnq;
import ahnr;
import ahns;
import ahnt;
import ahnu;
import ahnv;
import ahnw;
import ahnx;
import ahny;
import ahnz;
import ahoa;
import ahpb;
import ajph;
import ajpu;
import ajpu.a;
import ajrb;
import ajrk;
import ajvd;
import ajve;
import akjq;
import akjr;
import akjs;
import akju;
import akkk;
import akkq.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoop;
import aqbn;
import aqiw;
import aqyg;
import ardk;
import ardn;
import aurr;
import ausj;
import awff;
import awsw;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.CircleImageView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.RefreshView.b;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.a;
import com.tencent.mobileqq.nearby.widget.OverlapLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jml;
import jqc;
import mqq.manager.TicketManager;
import ocp;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONObject;
import sux;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople;
import wja;

public class NearbyHybridFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public static long aaH;
  public static boolean chH;
  public static SosoInterface.SosoLbsInfo g;
  public static final Runnable gy = new NearbyHybridFragment.2();
  public View Do;
  public View Dp;
  protected View Dq;
  protected View Dr;
  protected View Ds;
  public RedTouch M;
  protected TextView Tu;
  protected acih a;
  public ajph a;
  public ajpu a;
  protected ajve a;
  public akkq.b a;
  protected RefreshView.b a;
  public RefreshView a;
  public NearbyActivity a;
  public a a;
  protected OverCoverFrameLayout.a a;
  public OverCoverFrameLayout a;
  protected OverlapLayout a;
  protected long aaI;
  protected long aaJ;
  protected long aaK;
  protected long aaL;
  public CookieManager b;
  protected FrameLayout bF;
  public String bKW = "";
  protected String bLb = "";
  String bLc = "";
  protected String bZ = "";
  public URLImageView bg;
  protected boolean chB = true;
  protected boolean chC;
  protected boolean chD;
  protected boolean chE;
  protected boolean chF;
  public boolean chG;
  protected boolean chI;
  public int dao = -1;
  int dap = 0;
  protected LinearLayout iY;
  public LinearLayout iZ;
  public ausj mActionSheet;
  protected boolean mIsResume;
  public String mMsgUin = "";
  protected View.OnClickListener mOnClickListener = new ahno(this);
  protected AdapterView.OnItemClickListener mOnItemClickListener = new ahnq(this);
  
  public NearbyHybridFragment()
  {
    this.jdField_a_of_type_Ajph = new ajph();
    this.jdField_a_of_type_ComTencentBizUiRefreshView$b = new ahnz(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$a = new ahoa(this);
    this.jdField_a_of_type_Akkq$b = new ahnp(this);
    this.jdField_a_of_type_Ajve = new ahnt(this);
    this.jdField_a_of_type_Acih = new ahnu(this);
  }
  
  private void W(Drawable paramDrawable)
  {
    URLImageView localURLImageView = new URLImageView(getActivity());
    localURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(wja.dp2px(30.0F, getActivity().getResources()), wja.dp2px(30.0F, getActivity().getResources())));
    localURLImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView(localURLImageView);
  }
  
  private void a(akjs paramakjs)
  {
    acig localacig = (acig)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getBusinessHandler(3);
    if (!akjr.xE().equals(paramakjs.bTD)) {
      localacig.Et(paramakjs.bTD);
    }
  }
  
  private void d(String paramString, Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommend", 2, "addAvatarImg,avatarUrl =  " + paramString);
    }
    FrameLayout localFrameLayout = (FrameLayout)getActivity().getLayoutInflater().inflate(2131559694, null);
    CircleImageView localCircleImageView = (CircleImageView)localFrameLayout.findViewById(2131368866);
    localCircleImageView.setBorderColor(-11382188);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(aqbn.e(1000, 1000));
    paramString.setDecodeHandler(aqbn.o);
    localCircleImageView.setImageDrawable(paramString);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView(localFrameLayout);
  }
  
  private void dpa()
  {
    int i;
    if (akjr.fL() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.removeAllViews();
      Iterator localIterator = akjr.fL().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        localObject = (oidb_0x8dd.NearbyPeople)localIterator.next();
        if (i < 3) {
          break label49;
        }
      }
    }
    return;
    label49:
    Object localObject = ((oidb_0x8dd.NearbyPeople)localObject).bytes_picture_face.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      d((String)localObject, getResources().getDrawable(2130840645));
      i += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public int Fc()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.arU()) {
      return 0;
    }
    return 1;
  }
  
  protected int Fd()
  {
    int i = -1;
    Intent localIntent = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localIntent != null) {
      i = localIntent.getIntExtra("nearby_main_init_tab", -1);
    }
    return i;
  }
  
  public void Pj(int paramInt)
  {
    boolean bool = aqiw.isNetworkAvailable(BaseApplicationImpl.getContext());
    if (bool) {}
    for (String str1 = "0";; str1 = "1")
    {
      String str3 = aqiw.K(BaseApplicationImpl.getContext());
      String str2 = str3;
      if (str3 == null) {
        str2 = "";
      }
      anot.a(null, "dc00899", "grp_lbs", "", "home", "loc_time_out", 0, 0, String.valueOf(paramInt), String.valueOf(5000), str1, str2);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "reportTimeOut: isNetworkOk=" + bool + ", APN=" + str2);
      }
      return;
    }
  }
  
  public ajph a()
  {
    return this.jdField_a_of_type_Ajph;
  }
  
  public void a(ajpu.a parama)
  {
    Intent localIntent;
    int i;
    if ((parama.jumpUrl != null) && (g != null) && (g.a != null))
    {
      if (!parama.jumpUrl.startsWith("http")) {
        break label226;
      }
      localIntent = new Intent(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
      if ((parama.id != 14) && (!parama.jumpUrl.contains("nearbyjiaoyou"))) {
        break label211;
      }
      if (TextUtils.isEmpty(g.a.cityCode)) {
        break label206;
      }
      i = 0;
      localIntent.putExtra("url", parama.jumpUrl + "&areaStat=" + i + "&code=" + g.a.cityCode);
      if (QLog.isDevelopLevel()) {
        QLog.i("NearbyHybridFragment", 4, " jumpByUrl url = " + this.bKW);
      }
      label178:
      localIntent.putExtra("big_brother_source_key", "biz_src_hdsp_now");
      ocp.f(localIntent, parama.jumpUrl);
      this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
    }
    label206:
    label211:
    label226:
    do
    {
      do
      {
        return;
        i = 1;
        break;
        localIntent.putExtra("url", parama.jumpUrl);
        break label178;
      } while ((!parama.jumpUrl.startsWith("mqqapi")) && (!parama.jumpUrl.startsWith("nowmqqapi")));
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(new Intent(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class).setData(Uri.parse(parama.jumpUrl)));
        return;
      }
      catch (Exception parama) {}
    } while (!QLog.isColorLevel());
    QLog.w("nearby.NearbyHybridFragment", 2, "onItemClick exp" + parama.toString());
  }
  
  public void a(ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    int i;
    if ((paramNearAnchorInfo == null) || (paramNearAnchorInfo.jump_type.get() == 1))
    {
      i = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().GC() + 1;
      this.bLb = "";
      if (g != null) {
        this.bLb = ("&latitude=" + g.a.cd + "&longitude=" + g.a.ce);
      }
      if (i != -1)
      {
        paramNearAnchorInfo = new StringBuilder().append(this.bLb).append("&gender=");
        if (i == 2)
        {
          i = 2;
          this.bLb = i;
        }
      }
      else
      {
        if ((NowLiveFragment.aWM == null) || (NowLiveFragment.aWM.length() <= 0)) {
          break label233;
        }
        this.jdField_b_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + NowLiveFragment.aWM);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment", 2, "now.qq.com pskey : " + NowLiveFragment.aWM);
        }
        CookieSyncManager.getInstance().sync();
        doX();
      }
    }
    label233:
    Object localObject1;
    do
    {
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_b_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com") != null)
        {
          paramNearAnchorInfo = this.jdField_b_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com");
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyHybridFragment", 2, "now.qq.com cookie : " + paramNearAnchorInfo);
          }
          if (paramNearAnchorInfo.contains("p_skey"))
          {
            doX();
            return;
          }
        }
        NowLiveFragment.aWM = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
        long l = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
        if ((NowLiveFragment.aWM != null) && (NowLiveFragment.aWM.length() > 0) && (System.currentTimeMillis() - l < 21600000L))
        {
          this.jdField_b_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + NowLiveFragment.aWM);
          CookieSyncManager.getInstance().sync();
          doX();
          return;
        }
        paramNearAnchorInfo = new NearbyHybridFragment.14(this);
        this.mHandler.postDelayed(paramNearAnchorInfo, 1000L);
        paramNearAnchorInfo = (TicketManager)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(2);
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
        localObject2 = new ahnr(this);
        paramNearAnchorInfo.GetPskey((String)localObject1, 16L, new String[] { "now.qq.com" }, (WtTicketPromise)localObject2);
        return;
      } while (paramNearAnchorInfo.jump_type.get() != 2);
      Object localObject2 = String.format("nowmqqapi://now/openroom?src_type=app&version=1&fromid=10006&roomid=%d&first=1&startsrc=fujin7", new Object[] { Integer.valueOf(paramNearAnchorInfo.root_roomid.get()) });
      localObject1 = localObject2;
      if (paramNearAnchorInfo.cover_url.has())
      {
        paramNearAnchorInfo = paramNearAnchorInfo.cover_url.get().toStringUtf8();
        localObject1 = (String)localObject2 + "&coverurl=" + paramNearAnchorInfo;
      }
      paramNearAnchorInfo = null;
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
      if (localObject2 != null) {
        paramNearAnchorInfo = ((Intent)localObject2).getStringExtra("big_brother_source_key");
      }
      localObject2 = new Intent(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class);
      if (!TextUtils.isEmpty(paramNearAnchorInfo)) {
        ((Intent)localObject2).putExtra("big_brother_source_key", paramNearAnchorInfo);
      }
      ((Intent)localObject2).setData(Uri.parse((String)localObject1));
      this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity((Intent)localObject2);
    } while (!QLog.isColorLevel());
    QLog.d("nearby.NearbyHybridFragmentQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "jump from nearby|uri:" + (String)localObject1);
  }
  
  protected ajph b()
  {
    int j = 0;
    Object localObject2 = (aehy)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(210);
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localObject1 != null) {
      ((aehy)localObject2).Hq(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("filter"));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "initNearbyFilter, filterMode=" + ((aehy)localObject2).Cn());
      }
      if (((aehy)localObject2).Cn() == 0) {
        break label377;
      }
      int i = ((Intent)localObject1).getIntExtra("filterGender", 0);
      int m = ((Intent)localObject1).getIntExtra("filter_time", 0);
      int n = ((Intent)localObject1).getIntExtra("filter_age", 0);
      int i1 = ((Intent)localObject1).getIntExtra("filter_xingzuo", 0);
      int k = ((Intent)localObject1).getIntExtra("filter_interest", 0);
      int i2 = ((Intent)localObject1).getIntExtra("filter_career", 0);
      Object localObject3 = ((Intent)localObject1).getStringExtra("filter_location");
      localObject2 = new ajph();
      ((ajph)localObject2).gender = i;
      ((ajph)localObject2).time = m;
      ((ajph)localObject2).age = n;
      ((ajph)localObject2).dkf = i1;
      ((ajph)localObject2).career = i2;
      if (k >= 0)
      {
        i = k;
        if (k <= ajph.fw.length - 1) {}
      }
      else
      {
        i = 0;
      }
      ((ajph)localObject2).dke = i;
      localObject1 = new String[5];
      localObject1[0] = "0";
      localObject1[1] = "0";
      localObject1[2] = "0";
      localObject1[3] = "0";
      localObject1[4] = "不限";
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label362;
      }
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        label298:
        break label298;
      }
      if (localObject1.length < 4) {
        break label362;
      }
      i = j;
      while (i < 4)
      {
        ((ajph)localObject2).fx[i] = localObject1[i];
        i += 1;
      }
      localObject1 = new Intent();
    }
    if (localObject1.length >= 5)
    {
      localObject1 = localObject1[4];
      ((ajph)localObject2).bRX = ((String)localObject1);
      label362:
      localObject1 = localObject2;
    }
    label377:
    do
    {
      do
      {
        return localObject1;
        localObject1 = "不限";
        break;
        localObject2 = ajph.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = new ajph();
      ((ajph)localObject2).gender = 0;
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("nearby.heart_beat", 2, "defFilter: filters.gender=" + ((ajph)localObject2).gender);
    return localObject2;
  }
  
  public aqyg b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a;
  }
  
  protected void b(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append("&").append(paramString).append("=").append(paramObject);
  }
  
  protected StringBuilder c()
  {
    if (this.jdField_a_of_type_Ajph != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      b(localStringBuilder, "sex", Integer.valueOf(this.jdField_a_of_type_Ajph.gender));
      b(localStringBuilder, "time", Integer.valueOf(this.jdField_a_of_type_Ajph.time));
      b(localStringBuilder, "age", Integer.valueOf(this.jdField_a_of_type_Ajph.age));
      b(localStringBuilder, "interest", Integer.valueOf(this.jdField_a_of_type_Ajph.dke));
      b(localStringBuilder, "profession", Integer.valueOf(this.jdField_a_of_type_Ajph.career));
      b(localStringBuilder, "country", this.jdField_a_of_type_Ajph.fx[0]);
      b(localStringBuilder, "province", this.jdField_a_of_type_Ajph.fx[1]);
      b(localStringBuilder, "city", this.jdField_a_of_type_Ajph.fx[2]);
      b(localStringBuilder, "contellation", Integer.valueOf(this.jdField_a_of_type_Ajph.dkf));
      return localStringBuilder;
    }
    return null;
  }
  
  void c(NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("nearby.NearbyHybridFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (paramNearbyAppInterface != null))
      {
        Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getBaseContext();
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a = new a(localContext, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramNearbyAppInterface);
        paramNearbyAppInterface = new TouchWebView(localContext);
        paramNearbyAppInterface.setBackgroundColor(-1);
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.a(paramNearbyAppInterface);
        if (QSecFramework.a().c(1001).booleanValue()) {
          QSecFramework.a().sendCmdToLib(5, 0, 1, new Object[] { Integer.valueOf(83), paramNearbyAppInterface }, null);
        }
        paramNearbyAppInterface.setOnTouchListener(new ahny(this));
        long l = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.init();
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          ajrk.f("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime) });
        }
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, "init webView time:" + this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime);
        }
        this.mIsInited = true;
      }
      return;
    }
    finally {}
  }
  
  public void ckW()
  {
    super.ckW();
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void d(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    try
    {
      CustomWebView localCustomWebView;
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout: mAbsWebView == null");
        }
      }
      else
      {
        localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.getWebView();
        if (localCustomWebView != null) {
          localJSONObject = new JSONObject();
        }
      }
      label74:
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      try
      {
        localJSONObject.put("lat", paramSosoLbsInfo.a.cd);
        localJSONObject.put("lng", paramSosoLbsInfo.a.ce);
        paramSosoLbsInfo = WebViewPlugin.toJsScript("onNearbyLocationChange", localJSONObject, null);
        localCustomWebView.callJs(paramSosoLbsInfo);
        if (QLog.isColorLevel())
        {
          QLog.d("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout:" + paramSosoLbsInfo);
          return;
          paramSosoLbsInfo = paramSosoLbsInfo;
          if (QLog.isColorLevel())
          {
            QLog.e("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout, exp=" + paramSosoLbsInfo.toString());
            return;
            if (QLog.isColorLevel())
            {
              QLog.w("nearby.NearbyHybridFragment.webloading", 2, "callJsAfterLocTimeout, webView==null");
              return;
            }
          }
        }
      }
      catch (Exception paramSosoLbsInfo)
      {
        break label74;
      }
    }
  }
  
  protected ArrayList<ajpu.a> df()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (String)ajrb.c(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_banner_enter_items", "");
    this.chC = false;
    for (;;)
    {
      ajpu.a locala;
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          locala = new ajpu.a();
          locala.iconUrl = localJSONObject.optString("iconUrl");
          locala.jumpUrl = localJSONObject.optString("jumpUrl");
          locala.scheme = localJSONObject.optString("scheme");
          locala.packageName = localJSONObject.optString("package");
          locala.name = localJSONObject.optString("name");
          locala.id = localJSONObject.optInt("id");
          locala.dko = localJSONObject.optInt("openapp");
        }
        switch (locala.id)
        {
        case 1: 
          ajrk.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_op_button", locala.id);
          localArrayList.add(locala);
          i += 1;
          continue;
          this.chC = true;
          locala.bHY = 6;
          continue;
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("nearby.NearbyHybridFragment", 2, "getBannerItems:" + localException.toString());
        }
      }
      locala.bHY = 1;
      continue;
      locala.bHY = 2;
      continue;
      locala.bHY = 7;
      continue;
      locala.bHY = 4;
      continue;
      locala.bHY = 8;
    }
  }
  
  protected void doM()
  {
    doY();
    this.jdField_a_of_type_Ahpb.a(acfp.m(2131708743)).a(new ahns(this));
    this.jdField_a_of_type_Ahpb.refresh();
  }
  
  public void doR()
  {
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, "checkLocation");
    if ((Build.VERSION.SDK_INT >= 23) && (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.e("nearby.NearbyHybridFragment.webloading", 1, "ACCESS_FINE_LOCATION permission not granted!");
      this.dao = 1;
      return;
    }
    long l = System.currentTimeMillis() - aaH;
    if ((g == null) || (l > 300000L))
    {
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.w("nearby.NearbyHybridFragment.webloading", 2, "send [MSG_SHOW_LOADING | MSG_LOCATION_TIME_OUT] before startLocation");
      }
      this.mHandler.removeMessages(3);
      this.mHandler.removeMessages(7);
      this.chI = false;
      this.chG = false;
      this.mHandler.sendEmptyMessageDelayed(3, 500L);
      this.mHandler.sendEmptyMessageDelayed(7, 5000L);
      SosoInterface.a(new ahnx(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab", l));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "startLocation useCache timeDiff=" + l);
    }
    doS();
    anot.a(null, "dc00899", "grp_lbs", "", "home", "loc_use_cache", 0, 0, "", "", "", "");
  }
  
  public void doS()
  {
    int i;
    if (!TextUtils.isEmpty(g.a.cityCode))
    {
      i = 0;
      this.bKW = ("latitude=" + g.a.cd + "&longitude=" + g.a.ce + "&areaStat=" + i + "&code=" + g.a.cityCode);
      if (QLog.isColorLevel()) {
        QLog.i("NearbyHybridFragment", 4, " nearbyTabLocParams = " + this.bKW);
      }
      this.bZ = getUrl();
      if (!ardk.rX(this.bZ)) {
        break label217;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "onLocationSucc, hasProxyParam");
      }
      ThreadManager.postImmediately(new NearbyHybridFragment.4(this), null, false);
    }
    for (;;)
    {
      this.dao = 0;
      this.mHandler.sendEmptyMessage(5);
      this.mHandler.postDelayed(new NearbyHybridFragment.5(this), 500L);
      return;
      i = 1;
      break;
      label217:
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "onLocationSucc, !hasProxyParam:" + this.bZ);
      }
    }
  }
  
  protected void doT()
  {
    awsw.dv(BaseApplicationImpl.getContext(), "nearby_shouye_preload");
  }
  
  public void doU()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh: mAbsWebView == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.getWebView();
        if (localCustomWebView == null) {
          break;
        }
        str = WebViewPlugin.toJsScript("qbrowserPullDown", null, null);
        localCustomWebView.callJs(str);
      } while (!QLog.isColorLevel());
      QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh:" + str);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh, webView==null");
  }
  
  public void doV()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewShow: mAbsWebView == null");
      }
    }
    for (;;)
    {
      return;
      CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.getWebView();
      Object localObject;
      if (localCustomWebView != null) {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("hidden", false);
        label53:
        localObject = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject, null);
        localCustomWebView.callJs((String)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewShow:" + (String)localObject);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("nearby.NearbyHybridFragment", 2, "notifyWebViewShow, webView==null");
        return;
      }
      catch (Exception localException)
      {
        break label53;
      }
    }
  }
  
  public void doW()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewHide: mAbsWebView == null");
      }
    }
    for (;;)
    {
      return;
      CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.getWebView();
      Object localObject;
      if (localCustomWebView != null) {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("hidden", true);
        label53:
        localObject = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject, null);
        localCustomWebView.callJs((String)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewHide:" + (String)localObject);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("nearby.NearbyHybridFragment", 2, "notifyWebViewHide, webView==null");
        return;
      }
      catch (Exception localException)
      {
        break label53;
      }
    }
  }
  
  protected void doX()
  {
    if (!this.mIsResume) {
      return;
    }
    String str = NearbyActivity.aOq + this.bLb + "&_t=" + System.currentTimeMillis();
    Intent localIntent = new Intent(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
  }
  
  public void doY()
  {
    int j = -1;
    Object localObject = (NearbyActivity)getActivity();
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateRightBtnRedTouch, selectIdx=");
      if (localObject == null)
      {
        i = -1;
        localStringBuilder = localStringBuilder.append(i).append(", selfIdx=");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) {
          break label179;
        }
        i = j;
        label60:
        QLog.d("nearby.NearbyHybridFragment", 2, i);
      }
    }
    else
    {
      if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo == null) || (((NearbyActivity)localObject).getCurrentIndex() != this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.tabIndex)) {
        break label190;
      }
      localObject = (NearbyActivity)getActivity();
      if (localObject != null)
      {
        if (this.M == null)
        {
          this.M = new RedTouch((Context)localObject, ((NearbyActivity)localObject).rightViewText);
          this.M.a(53).a();
        }
        localObject = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(9);
        this.M.c((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      }
    }
    label179:
    label190:
    while (this.M == null)
    {
      return;
      i = ((NearbyActivity)localObject).getCurrentIndex();
      break;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.tabIndex;
      break label60;
    }
    this.M.c(null);
  }
  
  public void doZ()
  {
    if ((this.iZ == null) || (getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    ajvd localajvd = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    Object localObject2 = localajvd.a(10);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redTypeInfo==null");
      }
      this.iZ.setVisibility(8);
      return;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        j = Integer.valueOf(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get()).intValue();
        if (j <= 99) {
          continue;
        }
        str = "99+";
        i = j;
      }
      catch (Exception localException)
      {
        int j;
        String str;
        akjs localakjs;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch exp=", localException);
        Object localObject1 = "";
        continue;
        this.iZ.setVisibility(0);
        if ((i != 1) || (!localakjs.cst) || (TextUtils.isEmpty(localakjs.bTB))) {
          continue;
        }
        this.Tu.setText(localakjs.bTB);
        if (localakjs.content_type != 2) {
          continue;
        }
        a(localakjs);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.removeAllViews();
        if ((TextUtils.isEmpty(localakjs.bTE)) || (!jqc.isValidUrl(localakjs.bTE))) {
          continue;
        }
        localObject1 = getResources().getDrawable(2130840645);
        d(localakjs.bTE, (Drawable)localObject1);
        localObject1 = localajvd.b();
        if ((i != 1) || (((akju)localObject1).dna != 1)) {
          continue;
        }
        dpa();
        akjq.a().a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "home", "news_slip_exp");
        ajrk.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_msg", 0);
        if (i <= 1) {
          return;
        }
        return;
        this.Tu.setText((String)localObject1 + acfp.m(2131708741));
        continue;
        if (localakjs.uin <= 0L) {
          continue;
        }
        localObject1 = String.valueOf(localakjs.uin);
        this.mMsgUin = ((String)localObject1);
        localObject1 = localajvd.a((String)localObject1, 1, true);
        localObject2 = new URLImageView(getActivity());
        ((URLImageView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(wja.dp2px(30.0F, getActivity().getResources()), wja.dp2px(30.0F, getActivity().getResources())));
        if ((localObject1 == null) || (((Bitmap)localObject1).getByteCount() <= 0)) {
          continue;
        }
        ((URLImageView)localObject2).setImageBitmap((Bitmap)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout.addView((View)localObject2);
        continue;
        ((URLImageView)localObject2).setImageDrawable(getResources().getDrawable(2130840645));
        continue;
        W(getResources().getDrawable(2130840645));
        continue;
      }
      j = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get();
      localakjs = new akjs();
      localakjs.b((BusinessInfoCheckUpdate.RedTypeInfo)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redType=" + j + ", numStr=" + str);
      }
      if (((localakjs.cst) || (j == 5)) && (!TextUtils.isEmpty(str))) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "!isOfficialNotify && redType != RedTouch.RED_TOUCH_NUM) || TextUtils.isEmpty(numStr)");
      }
      this.iZ.setVisibility(8);
      return;
      str = String.valueOf(j);
    }
  }
  
  public void dpb()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a == null) {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewSheetDismiss: mAbsWebView == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.getWebView();
        if (localCustomWebView == null) {
          break;
        }
        str = WebViewPlugin.toJsScript("closeFilterAndExitSheet", null, null);
        localCustomWebView.callJs(str);
      } while (!QLog.isColorLevel());
      QLog.d("nearby.NearbyHybridFragment", 2, "ActionSheet onDissmiss:" + str);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("nearby.NearbyHybridFragment", 2, "ActionSheet onDissmiss, webView==null");
  }
  
  public void dpc()
  {
    String str = aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter("https://nearby.qq.com/people_filter/index.html", "_wwv", "4"), "sex", String.valueOf(this.jdField_a_of_type_Ajph.gender)), "time", String.valueOf(this.jdField_a_of_type_Ajph.time)), "age", String.valueOf(this.jdField_a_of_type_Ajph.age)), "interest", String.valueOf(this.jdField_a_of_type_Ajph.dke)), "profession", String.valueOf(this.jdField_a_of_type_Ajph.career)), "country", String.valueOf(this.jdField_a_of_type_Ajph.fx[0])), "strCountry", this.jdField_a_of_type_Ajph.country), "province", String.valueOf(this.jdField_a_of_type_Ajph.fx[1])), "strProvince", this.jdField_a_of_type_Ajph.province), "city", String.valueOf(this.jdField_a_of_type_Ajph.fx[2])), "strCity", this.jdField_a_of_type_Ajph.city), "contellation", String.valueOf(this.jdField_a_of_type_Ajph.dkf));
    Intent localIntent = new Intent(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    getActivity().startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "jump2FilterSettingPage:" + str);
    }
  }
  
  public void dpd()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.aaL;
    long l3 = System.currentTimeMillis();
    long l4 = this.aaJ;
    if (QLog.isColorLevel()) {
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "hideWebLoadingView:" + this.chI + ", timeCostFromLoad=" + (l1 - l2) + ", timeCostFromAttach=" + (l3 - l4));
    }
    this.mHandler.removeMessages(3);
    this.chI = true;
    if (this.Dq != null) {
      this.Dq.setVisibility(8);
    }
    if (this.Dr != null) {
      this.Dr.setVisibility(8);
    }
    if (this.Ds != null) {
      this.Ds.setVisibility(8);
    }
  }
  
  public void dpe()
  {
    this.aaI = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.duration", 2, "resetUserBrowseTime");
    }
  }
  
  public void dpf()
  {
    int i = ((Integer)ajrb.c(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    long l = (System.currentTimeMillis() - this.aaI) / 1000L;
    if (l <= 0L) {
      l = 1L;
    }
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", "", "home", "home_exp", 0, 0, "", String.valueOf(i), "", String.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.duration", 2, "reportUserBroseTime: d2[gender]=" + i + ", d4[duration]=" + l);
      }
      return;
    }
  }
  
  public void dpg()
  {
    try
    {
      ajvd localajvd = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
      Object localObject = localajvd.a(11);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handleNearbyActivityTip, dotInfo=");
        if (localObject != null) {
          break label184;
        }
      }
      label184:
      for (String str = "";; str = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.get())
      {
        QLog.d("nearby.redpoint", 2, str + ", isFinish=" + this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing());
        if ((localObject == null) || (this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing())) {
          break;
        }
        str = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.get();
        localObject = new akkk(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
        if (((akkk)localObject).nH(str)) {
          ((akkk)localObject).show();
        }
        localajvd.Ru(58);
        anot.a(null, "dc00899", "grp_lbs", "", "entry", "pop_clk_red", 0, 0, String.valueOf(((Integer)ajrb.c(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("nearby.redpoint", 1, "handleNearbyActivityTip, exp=" + localException.toString());
    }
  }
  
  public void e(boolean paramBoolean, int paramInt, long paramLong)
  {
    boolean bool = aqiw.isNetworkAvailable(BaseApplicationImpl.getContext());
    String str1;
    String str2;
    int i;
    if (bool)
    {
      str1 = "0";
      String str3 = aqiw.K(BaseApplicationImpl.getContext());
      str2 = str3;
      if (str3 == null) {
        str2 = "";
      }
      if (!this.chG) {
        break label183;
      }
      i = 1;
      label49:
      if (!paramBoolean) {
        break label189;
      }
      anot.a(null, "dc00899", "grp_lbs", "", "home", "loc_succ", i, 0, String.valueOf(paramInt), String.valueOf(paramLong), str1, str2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "reportLocation: isSucc=" + paramBoolean + ", errCode=" + paramInt + ", timeCost=" + paramLong + ", isNetworkOk=" + bool + ", APN=" + str2 + ", isTimeOut=" + this.chG);
      }
      return;
      str1 = "1";
      break;
      label183:
      i = 0;
      break label49;
      label189:
      anot.a(null, "dc00899", "grp_lbs", "", "home", "loc_failed", i, 0, String.valueOf(paramInt), String.valueOf(paramLong), str1, str2);
    }
  }
  
  protected String getUrl()
  {
    Object localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.tabUrl;
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (!((String)localObject1).contains("?")) {
        break label265;
      }
    }
    label265:
    for (localObject1 = (String)localObject1 + "&";; localObject1 = (String)localObject1 + "?")
    {
      localObject2 = (String)localObject1 + this.bKW;
      Object localObject3 = c();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (String)localObject2 + ((StringBuilder)localObject3).toString();
      }
      localObject3 = ajrb.mq(ajrb.xy());
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = (String)localObject1 + (String)localObject3;
      }
      int i = Fd();
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = (String)localObject2 + "&initTab=" + i;
      }
      localObject2 = localObject1;
      if (this.aaK != 0L) {
        localObject2 = (String)localObject1 + "&_t=" + this.aaK;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "getUrl, url=" + (String)localObject2);
      }
      return localObject2;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 2;
    switch (paramMessage.what)
    {
    case 2: 
    case 4: 
    default: 
    case 3: 
    case 1: 
    case 5: 
    case 6: 
      label366:
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
                return false;
                if (QLog.isColorLevel()) {
                  QLog.w("nearby.NearbyHybridFragment.webloading", 2, "handleMessage MSG_SHOW_LOADING: isLoadingFinished=" + this.chI);
                }
              } while ((this.chI) || (this.Dq == null));
              if (this.Dq != null) {
                this.Dq.setVisibility(0);
              }
              if (this.Dr != null) {
                this.Dr.setVisibility(8);
              }
            } while (this.Ds == null);
            this.Ds.setVisibility(8);
            return false;
            if (paramMessage.what == 5) {
              if (QLog.isColorLevel()) {
                QLog.d("nearby.NearbyHybridFragment.webloading", 2, "handleMessage attach-locationEnd cost=" + (System.currentTimeMillis() - this.aaJ));
              }
            }
            while (this.chE)
            {
              if (this.dao != 0) {
                break label366;
              }
              if ((this.chC) && (!this.chD) && (g != null))
              {
                this.chD = true;
                this.mHandler.postDelayed(new NearbyHybridFragment.7(this), 2000L);
              }
              if ((!this.chA) || (this.chF)) {
                break;
              }
              this.chF = true;
              this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.Ko(this.bZ);
              return false;
              if (paramMessage.what == 6)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("nearby.NearbyHybridFragment.webloading", 2, "handleMessage attach-viewInitEnd cost=" + (System.currentTimeMillis() - this.aaJ));
                }
              }
              else if ((paramMessage.what == 1) && (QLog.isColorLevel())) {
                QLog.d("nearby.NearbyHybridFragment.webloading", 2, "handleMessage MSG_INIT");
              }
            }
          } while (this.dao != 1);
          if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
            break;
          }
          if (this.Ds != null) {
            this.Ds.setVisibility(0);
          }
          if (this.Dq != null) {
            this.Dq.setVisibility(8);
          }
        } while (this.Dr == null);
        this.Dr.setVisibility(8);
        return false;
        if (this.Ds != null) {
          this.Ds.setVisibility(8);
        }
        if (this.Dq != null) {
          this.Dq.setVisibility(8);
        }
      } while (this.Dr == null);
      this.Dr.setVisibility(0);
      return false;
    }
    this.chG = true;
    if (g == null)
    {
      g = ajrb.b(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      i = 1;
    }
    if (g == null)
    {
      g = new SosoInterface.SosoLbsInfo();
      g.a = new SosoInterface.SosoLocation();
      g.a.cd = 0.0D;
      g.a.ce = 0.0D;
      i = 3;
    }
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, "handleMessage MSG_LOCATION_TIME_OUT， locType=" + i);
    doS();
    Pj(i);
    return false;
  }
  
  public void m(boolean paramBoolean, int paramInt, String paramString)
  {
    this.bLc = paramString;
    this.dap = paramInt;
    if (paramBoolean)
    {
      this.Do.setVisibility(0);
      ajrk.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_pub", 1);
      return;
    }
    this.Do.setVisibility(8);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
    }
    this.jdField_a_of_type_Ajph = b();
    this.aaJ = System.currentTimeMillis();
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ == 0) {
      this.aaK = System.currentTimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "onAttach, mLastTabIndex=" + this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.bTJ);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp) });
      }
    }
    super.onCreate(paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime) });
      }
    }
    ajrb.D(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), true);
    long l = System.currentTimeMillis();
    ajrb.c(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(l));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "onCreateView");
    }
    dpe();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (QLog.isColorLevel()) {
        ajrk.m("nearby.NearbyHybridFragment", new Object[] { "onCreateView", Long.valueOf(l1) });
      }
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (this.chB) {
        doR();
      }
      if (this.rootView == null)
      {
        long l2 = System.currentTimeMillis();
        c(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        CookieSyncManager.createInstance(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
        this.jdField_b_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_b_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, "total createWebView time:" + (System.currentTimeMillis() - l2));
        }
        this.rootView = paramLayoutInflater.inflate(2131559687, null);
        this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.rootView.findViewById(2131382153));
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout = ((OverCoverFrameLayout)this.rootView.findViewById(2131372773));
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.setOnActionListener(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$a);
        this.Do = this.rootView.findViewById(2131366480);
        this.Do.setOnClickListener(this.mOnClickListener);
        this.iY = ((LinearLayout)this.rootView.findViewById(2131366468));
        this.bF = ((FrameLayout)this.rootView.findViewById(2131382158));
        this.Dp = this.rootView.findViewById(2131362846);
        paramLayoutInflater = this.rootView.findViewById(2131363288);
        if (("Meizu".equalsIgnoreCase(Build.BRAND)) && ("M040".equalsIgnoreCase(Build.MODEL)) && (paramLayoutInflater != null)) {
          paramLayoutInflater.setVisibility(8);
        }
        paramLayoutInflater = df();
        this.jdField_a_of_type_Ajpu = new ajpu(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.iY);
        this.jdField_a_of_type_Ajpu.setData(paramLayoutInflater);
        this.jdField_a_of_type_Ajpu.setOnItemClickListener(this.mOnItemClickListener);
        this.iZ = ((LinearLayout)this.rootView.findViewById(2131374939));
        this.iZ.setOnClickListener(this.mOnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverlapLayout = ((OverlapLayout)this.rootView.findViewById(2131374938));
        this.Tu = ((TextView)this.rootView.findViewById(2131374940));
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.mWebview.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.mWebview.setOnScrollChangedListener(new ahnn(this));
        paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
        this.bF.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.mWebview, 0, paramLayoutInflater);
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, "webView add to container:" + (System.currentTimeMillis() - l2));
        }
        this.Dq = this.bF.findViewById(2131382163);
        paramLayoutInflater = (URLImageView)this.Dq.findViewById(2131374326);
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mLoadingDrawable = aoop.TRANSPARENT;
        paramViewGroup.mPlayGifImage = true;
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://qpic.url.cn/feeds_pic/ajNVdqHZLLAyBjp36ialuzyODWtr9VCdVQJo0JTrkib9eDlHdRtvS90g/", paramViewGroup));
        this.Dq.setVisibility(8);
        this.Dr = this.bF.findViewById(2131382160);
        this.Ds = this.bF.findViewById(2131370848);
        this.Dq.setOnClickListener(this.mOnClickListener);
        this.Dr.setOnClickListener(this.mOnClickListener);
        this.Ds.setOnClickListener(this.mOnClickListener);
      }
      this.jdField_a_of_type_Ahpb.b(getString(2131696191)).a(false);
      doM();
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(this.jdField_a_of_type_ComTencentBizUiRefreshView$b);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv == 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv = (System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          ajrk.f("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv) });
        }
      }
      if (this.chB)
      {
        this.chB = false;
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_Acih);
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_Ajve);
        this.jdField_a_of_type_Ajpu.d(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        doZ();
        this.chE = true;
        this.mHandler.sendEmptyMessage(6);
      }
      paramLayoutInflater = this.rootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.mIsInited) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Acih);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_Ajve);
    this.jdField_a_of_type_Ajpu.lz(null);
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.onDestroy();
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyHybridFragment", 2, "onDestroyView");
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyHybridFragment", 2, "onHiddenChanged: hidden=" + paramBoolean);
    }
    if (paramBoolean)
    {
      doW();
      dpf();
      if (this.M != null) {
        this.M.c((BusinessInfoCheckUpdate.RedTypeInfo)null);
      }
      return;
    }
    doV();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.mIsInited) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyHybridFragment", 2, "onPause:" + this.mIsResume);
    }
    this.mIsResume = false;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.mIsInited) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("nearby.NearbyHybridFragment", 2, "onResume:" + this.mIsResume);
        }
        dpe();
        this.mIsResume = true;
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.onResume();
        if (!aqiw.isNetworkAvailable(getActivity())) {
          QQToast.a(getActivity(), 1, acfp.m(2131708742), 0).show(getActivity().getTitleBarHeight());
        }
        if (this.jdField_a_of_type_Ajpu != null) {
          this.jdField_a_of_type_Ajpu.d(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        }
        doY();
        doZ();
        if (this.dao == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyHybridFragment", 2, "onResume, re checkLocation");
          }
          doR();
        }
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
        str1 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_param", "");
      } while (TextUtils.isEmpty(str1));
      str2 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_callback", "");
    } while (TextUtils.isEmpty(str2));
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$a.mWebview.callJs(str2, new String[] { str1 });
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("nearby_now_delete_success_js_param", "");
    ((SharedPreferences.Editor)localObject).remove("nearby_now_delete_success_js_param").commit();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    doT();
  }
  
  public void showFilterAndExitSheet()
  {
    if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
      return;
    }
    this.mActionSheet = ausj.d(getActivity());
    this.mActionSheet.addButton(2131700957);
    this.mActionSheet.addButton(2131700919);
    this.mActionSheet.addCancelButton(2131721058);
    this.mActionSheet.a(new ahnv(this));
    this.mActionSheet.a(new ahnw(this));
    this.mActionSheet.show();
  }
  
  public final class a
    extends aqyg
  {
    public boolean atY;
    boolean avR = false;
    public boolean chJ;
    protected boolean chK;
    protected boolean chL;
    public boolean isLoadFinish;
    
    public a(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
    {
      super(paramActivity, paramAppInterface);
    }
    
    public void Ko(String paramString)
    {
      this.mUrl = paramString;
      if (QLog.isColorLevel()) {
        QLog.w("nearby.NearbyHybridFragment.webloading", 2, "start load url, from attach cost=" + (System.currentTimeMillis() - NearbyHybridFragment.this.aaJ) + ", url=" + paramString);
      }
      NearbyHybridFragment.this.aaL = System.currentTimeMillis();
      this.mWebview.loadUrl(this.mUrl);
      if (NearbyHybridFragment.this.Dq.getVisibility() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment.webloading", 2, "send MSG_SHOW_LOADING before loadUrl");
        }
        NearbyHybridFragment.this.mHandler.removeMessages(3);
        NearbyHybridFragment.this.chI = false;
        NearbyHybridFragment.this.mHandler.sendEmptyMessageDelayed(3, 500L);
      }
    }
    
    public void a(TouchWebView paramTouchWebView)
    {
      this.mWebview = paramTouchWebView;
    }
    
    public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
    {
      if (paramArrayList != null)
      {
        paramArrayList.add(new ardn());
        paramArrayList.add(new sux());
        paramArrayList.add(new awff());
      }
    }
    
    public void init()
    {
      if (this.chJ) {
        return;
      }
      if (NearbyHybridFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
      for (long l = System.currentTimeMillis();; l = 0L)
      {
        this.chJ = true;
        jml.a();
        super.buildBaseWebView(this.mInterface);
        onWebViewReady();
        if ((this.mWebview != null) && (Build.VERSION.SDK_INT >= 21)) {
          this.mWebview.getSettings().setMixedContentMode(0);
        }
        this.avR = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
        if ((this.avR) && (this.mWebview != null)) {
          this.mWebview.setMask(true);
        }
        setmTimeBeforeLoadUrl(System.currentTimeMillis());
        if (QLog.isDevelopLevel()) {
          ajrk.f("WebSpeedTrace", "mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.mTimeBeforeLoadUrl) });
        }
        if ((NearbyHybridFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) || (NearbyHybridFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw != 0L)) {
          break;
        }
        NearbyHybridFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw = (System.currentTimeMillis() - l);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        ajrk.f("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(NearbyHybridFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw) });
        return;
      }
    }
    
    public WebAccelerateHelper.CommonJsPluginFactory myCommonJsPlugins()
    {
      return new WebAccelerateHelper.CommonJsPluginFactory();
    }
    
    public void onDestroy()
    {
      super.doOnDestroy();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (this.chL) {}
      do
      {
        return;
        this.chL = true;
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment.webloading", 2, "onPageFinished:" + paramString);
        }
        if (NearbyHybridFragment.this.jdField_a_of_type_Ahpb != null)
        {
          NearbyHybridFragment.this.jdField_a_of_type_Ahpb.Kv(true);
          NearbyHybridFragment.this.jdField_a_of_type_Ahpb.refresh();
        }
        this.isLoadFinish = true;
        if ((NearbyHybridFragment.this.Dq == null) || (!NearbyHybridFragment.chH))
        {
          NearbyHybridFragment.this.mHandler.postDelayed(NearbyHybridFragment.gy, 500L);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.w("AbsWebView", 2, "already called pre load now plugin!, isCalledNowPreLoad=" + NearbyHybridFragment.chH);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      if (this.chK) {
        return;
      }
      this.chK = true;
      if (QLog.isColorLevel()) {
        QLog.w("nearby.NearbyHybridFragment.webloading", 2, "onPageStarted:" + paramString);
      }
      this.atY = true;
      if (NearbyHybridFragment.this.jdField_a_of_type_Ahpb != null)
      {
        NearbyHybridFragment.this.jdField_a_of_type_Ahpb.Kv(true);
        NearbyHybridFragment.this.jdField_a_of_type_Ahpb.refresh();
      }
      this.isLoadFinish = false;
    }
    
    public void onPause()
    {
      super.doOnPause();
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("nearby.NearbyHybridFragment.webloading", 2, "onReceivedError: errorCode=" + paramInt + ", description=" + paramString1 + ", failingUrl=" + paramString2);
      }
      if (NearbyHybridFragment.this.Dr != null) {
        NearbyHybridFragment.this.Dr.setVisibility(0);
      }
      if (NearbyHybridFragment.this.Dq != null) {
        NearbyHybridFragment.this.Dq.setVisibility(8);
      }
      if (NearbyHybridFragment.this.Ds != null) {
        NearbyHybridFragment.this.Ds.setVisibility(8);
      }
    }
    
    public void onResume()
    {
      super.doOnResume();
    }
    
    public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      if (QLog.isColorLevel()) {
        QLog.w("nearby.NearbyHybridFragment.webloading", 2, "showCustomView: view=" + paramView + ", orientation=" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment
 * JD-Core Version:    0.7.0.1
 */