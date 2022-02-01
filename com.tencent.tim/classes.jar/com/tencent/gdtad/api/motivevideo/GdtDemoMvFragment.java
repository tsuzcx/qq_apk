package com.tencent.gdtad.api.motivevideo;

import abmt;
import acfp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForQzone;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;
import tgc;
import tgc.b;
import tgd;
import tgg;
import tgh;
import tgk;
import tgl;
import tgo;
import tgp;
import tih;
import tir;
import tis;
import tkv;
import tkw;
import tlb;

public class GdtDemoMvFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static int bBy;
  private long Er = 15L;
  private com.tencent.gdtad.api.GdtAd a;
  private EditText ak;
  private long lastClickTime;
  
  public static GdtHandler.Params a(boolean paramBoolean, Activity paramActivity)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = 1;
    localParams.activity = new WeakReference(paramActivity);
    localParams.reportForClick = paramBoolean;
    return localParams;
  }
  
  public static qq_ad_get.QQAdGet a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    Object localObject1 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_rate.set(paramInt2);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_check.set(tgd.a(paramLong2, paramLong3, paramInt2));
    Object localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).share_info.set((MessageMicro)localObject1);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(1);
    localObject1 = new qq_ad_get.QQAdGet.PositionInfo();
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_id.set(paramString);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).ad_count.set(1);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_ext.set((MessageMicro)localObject2);
    paramString = new qq_ad_get.QQAdGet.ContextInfo();
    paramString.public_id.set(paramLong2);
    paramString.article_id.set(paramLong3);
    paramString.source_from.set(paramInt1);
    localObject2 = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(paramLong1);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add((MessageMicro)localObject1);
    localQQAdGet.context_info.set(paramString);
    localQQAdGet.user_info.set((MessageMicro)localObject2);
    return localQQAdGet;
  }
  
  private qq_ad_get.QQAdGetRsp.AdInfo a()
  {
    Object localObject1 = b(0, this.a, 1, true);
    if (localObject1 != null) {
      try
      {
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(((GdtMotiveVideoPageData)localObject1).adsContent)));
        Object localObject2 = this.a.getAd();
        if ((localObject2 != null) && (localObject1 != null))
        {
          ArrayList localArrayList1 = new ArrayList();
          localArrayList1.add(((com.tencent.gdtad.aditem.GdtAd)localObject2).getUrlForClick());
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(((com.tencent.gdtad.aditem.GdtAd)localObject2).getUrlForImpression());
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add("https://tytx.m.cn.miaozhen.com/x/k=2137392&p=7Sm5F&dx=__IPDX__&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&xa=__ADPLATFORM__&tr=__REQUESTID__&mo=__OS__&m0=__OPENUDID__&m0a=__DUID__&m1=__ANDROIDID1__&m1a=__ANDROIDID__&m2=__IMEI__&m4=__AAID__&m5=__IDFA__&m6=__MAC1__&m6a=__MAC__&m11=__OAID__&txp=__TXP__&o=");
          String str = this.ak.getText().toString();
          if (!TextUtils.isEmpty(str)) {
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.aid.set(Long.parseLong(str));
          }
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(localArrayList1);
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(localArrayList2);
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.video_play_monitor_url.set((List)localObject2);
        }
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return null;
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      paramGdtMotiveVideoPageData.setVideoCountDown(paramInt1);
    }
  }
  
  private GdtMotiveVideoPageData b(int paramInt1, com.tencent.gdtad.api.GdtAd paramGdtAd, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = null;
    QLog.i("GdtMotiveVideoAd", 1, "mockMVPageData createSize " + paramInt1 + " portrait " + paramInt2 + " useRealData " + paramBoolean);
    if ((paramGdtAd == null) || (!paramGdtAd.isLoaded()) || (paramGdtAd.isInvalidated()) || (!(paramGdtAd instanceof GdtMotiveVideoAd)))
    {
      QLog.i("GdtMotiveVideoAd", 1, String.format("mockMVPageData null %d", new Object[] { Integer.valueOf(paramInt1) }) + paramInt2);
      QQToast.a(getActivity(), acfp.m(2131706867), 0).show();
      return null;
    }
    Object localObject2 = (GdtMotiveVideoAd)paramGdtAd;
    com.tencent.gdtad.aditem.GdtAd localGdtAd = ((GdtMotiveVideoAd)localObject2).getAd();
    if (localGdtAd != null)
    {
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
      localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
      if (paramBoolean) {
        paramInt1 = localGdtAd.getCreativeSize();
      }
      localGdtMotiveVideoPageData.vSize = paramInt1;
      localGdtMotiveVideoPageData.screenOrientation = paramInt2;
      localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
      localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
      localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
      tkw.e("GdtMotiveVideoAd", "VideoUrl " + localGdtMotiveVideoPageData.url);
      if ((!TextUtils.isEmpty(localGdtMotiveVideoPageData.url)) && (localGdtMotiveVideoPageData.url.startsWith("https://"))) {
        localGdtMotiveVideoPageData.url = localGdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
      }
      if (localGdtAd.getImageData() == null)
      {
        paramGdtAd = "";
        localGdtMotiveVideoPageData.previewImgUrl = paramGdtAd;
        localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
        localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
        localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
        localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
        localGdtMotiveVideoPageData.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
        localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
        localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
        localObject2 = ((GdtMotiveVideoAd)localObject2).getGdtAdLoader();
        paramGdtAd = localObject1;
        if (localObject2 != null)
        {
          paramGdtAd = localObject1;
          if (((tgc)localObject2).a() != null)
          {
            paramGdtAd = localObject1;
            if (((tgc)localObject2).a().a != null) {
              paramGdtAd = tkv.pbToJson((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)((tgc)localObject2).a().a.pos_ads_info.get(0)).ads_info.get(0));
            }
          }
        }
        if (paramGdtAd != null) {
          break label505;
        }
      }
      label505:
      for (paramGdtAd = "";; paramGdtAd = paramGdtAd.toString())
      {
        localGdtMotiveVideoPageData.adsContent = paramGdtAd;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        return localGdtMotiveVideoPageData;
        paramGdtAd = localGdtAd.getImageData().url;
        break;
      }
    }
    return null;
  }
  
  private void bDg()
  {
    if (this.a == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j = bBy;
    bBy = j + 1;
    int i = 0;
    while (i < j % 10)
    {
      localArrayList.add(this.a.getAd());
      i += 1;
    }
    tgo.a(getActivity()).a(new GdtAdBoxData(localArrayList)).a(new tih(this)).a().show();
  }
  
  public void bDf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveVideoAd", 2, "[loadMotiveVideoAd]");
    }
    try
    {
      Object localObject = new tis();
      ((tis)localObject).b = a(Long.parseLong(abmt.getAppInterface().getCurrentAccountUin()), "3050948280108638", 3503183690L, 2011L, 208, 75);
      ((tis)localObject).c = a(true, getActivity());
      localObject = new GdtMotiveVideoAd((tis)localObject);
      ((GdtMotiveVideoAd)localObject).setListener(new WeakReference(new a(getActivity())));
      ((GdtMotiveVideoAd)localObject).load(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtMotiveVideoAd", 1, localThrowable, new Object[0]);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt2 == -1) && (paramInt1 == 101))
    {
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle == null)
      {
        tkw.e("GdtMotiveVideoAd", "onActivityResult b==null ");
        return;
      }
      long l1 = localBundle.getLong("duration_time");
      long l2 = localBundle.getLong("elapsed_time");
      boolean bool = localBundle.getBoolean("profitable_flag", false);
      Toast.makeText(getActivity(), bool + " elaspedTime/duration " + l2 + "/" + l1, 0).show();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (SystemClock.uptimeMillis() - this.lastClickTime < 600L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i;
      try
      {
        String str = this.ak.getText().toString();
        if (!TextUtils.isEmpty(str))
        {
          i = Integer.parseInt(str);
          this.lastClickTime = SystemClock.uptimeMillis();
          switch (j)
          {
          default: 
            break;
          case 2131362065: 
            tlb.a(1, 1, a());
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          i = 0;
        }
        bDf();
      }
      continue;
      bDg();
      continue;
      Object localObject1 = b(185, this.a, 1, false);
      if (localObject1 != null)
      {
        a((GdtMotiveVideoPageData)localObject1, i, -1);
        ((GdtMotiveVideoPageData)localObject1).url = "https://vgdt.gtimg.cn/14636/EAAAE95AUAALQAAHsqVBZYyEwBJdEPRsQ.mp4?ck=ea3d79d3dd265628a3002ba3885fcb6c";
        GdtMotiveVideoFragment.b(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
        continue;
        Object localObject2 = b(65, this.a, 1, false);
        if (localObject2 != null)
        {
          a((GdtMotiveVideoPageData)localObject2, i, -1);
          Object localObject3 = new Bundle();
          ((Bundle)localObject3).putSerializable("data", (Serializable)localObject2);
          ((Bundle)localObject3).putString("big_brother_ref_source_key", ((GdtMotiveVideoPageData)localObject2).refId);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
          ((Intent)localObject1).putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
          ((Intent)localObject1).putExtras((Bundle)localObject3);
          if (TextUtils.isEmpty(((Intent)localObject1).getStringExtra("big_brother_ref_source_key"))) {
            tkw.e("GdtMotiveVideoAd", "start gdt empty refId");
          }
          localObject2 = new tir((GdtMotiveVideoPageData)localObject2);
          ((Intent)localObject1).setClass(getActivity(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("fragment_class", GdtMotiveBrowsingFragment.class.getCanonicalName());
          ((Intent)localObject1).putExtra("url", "https://test-xj.gdt.qq.com/xjviewer/nemo/1004689?ist=1&click_ext=eyJzY2VuY2VzX3R5cGUiOjF9");
          ((Intent)localObject1).putExtra("isTransparentTitle", true);
          ((Intent)localObject1).putExtra("GdtWebReportQQ_TRACE_ID", ((tir)localObject2).a().getTraceId());
          ((Intent)localObject1).putExtra("GdtWebReportQQ_ACTION_URL", ((tir)localObject2).a().getUrlForAction());
          getActivity().startActivity((Intent)localObject1);
          continue;
          localObject1 = b(185, this.a, 0, false);
          if (localObject1 != null)
          {
            a((GdtMotiveVideoPageData)localObject1, i, -1);
            ((GdtMotiveVideoPageData)localObject1).url = "https://adsmind.apdcdn.tc.qq.com/vcloud.tc.qq.com/1050_000001004y2sk0zk0k00st9pojifv3rl.f32.mp4?vkey=6C7D1F5EF7D2D51C89580BA6DC924507BB741055A42116515BBB04E87D347AA30C4318F43ECFC6EA61C1BE66102F19F8821394588EC15EF9956B7DE79BF5E6C8C9E1F69AB1585D0DE547A44F554791AE81C1CFE023F7757F";
            GdtMotiveVideoFragment.b(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
            continue;
            localObject1 = b(185, this.a, 8, false);
            if (localObject1 != null)
            {
              a((GdtMotiveVideoPageData)localObject1, i, -1);
              ((GdtMotiveVideoPageData)localObject1).url = "https://adsmind.tc.qq.com/vcloud.tc.qq.com/1050_000001004vj2x0zk0k002bypexipm58g.f32.mp4?vkey=6764FB31E38EDE078A3BF8D07D7CE93EAF20A188675F62AC6BAD9E785AA3E5A029FBE7819922D4859A87BD5BE1BE90BB3C8F12B7BA3481BB0FB88A9BB9E3EF39D56C8B7201F6C189DF10BD6F502280468DE9F9E791A323DE";
              GdtMotiveVideoFragment.b(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
              continue;
              localObject1 = b(585, this.a, 1, false);
              if (localObject1 != null)
              {
                a((GdtMotiveVideoPageData)localObject1, i, -1);
                ((GdtMotiveVideoPageData)localObject1).url = "https://adsmind.tc.qq.com/vcloud.tc.qq.com/1050_0000010001p1e0k00zk03ydpd32lm4rt.f20.mp4?vkey=0BA8604245D02BDE0CCBF1696E48A039A3F152B5C2D114AF7990C4043EA438218B0E693D2F7E005B38EC42CD36CF598352A6E88B3B16768D44C799AB256B9A84C6A8E4D40B5AB22F52691FAA957D4BCFC884DCA3EC432D99";
                GdtMotiveVideoFragment.b(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
                continue;
                localObject1 = b(185, this.a, 1, false);
                if (localObject1 != null)
                {
                  ((GdtMotiveVideoPageData)localObject1).containerType = 1;
                  ((GdtMotiveVideoPageData)localObject1).resultReceiver = new GdtDemoMvFragment.1(this, new Handler(Looper.getMainLooper()));
                  a((GdtMotiveVideoPageData)localObject1, i, -1);
                  ((GdtMotiveVideoPageData)localObject1).url = "https://vgdt.gtimg.cn/14636/EAAAE95AUAALQAAHsqVBZYyEwBJdEPRsQ.mp4?ck=ea3d79d3dd265628a3002ba3885fcb6c";
                  GdtMotiveVideoFragment.b(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
                  continue;
                  localObject1 = b(0, this.a, 1, true);
                  if (localObject1 != null)
                  {
                    a((GdtMotiveVideoPageData)localObject1, i, -1);
                    GdtMotiveVideoFragment.b(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
                    continue;
                    localObject1 = b(0, this.a, 0, true);
                    if (localObject1 != null)
                    {
                      a((GdtMotiveVideoPageData)localObject1, i, -1);
                      GdtMotiveVideoFragment.b(getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject1);
                      continue;
                      tlb.a(0, 0, a());
                      continue;
                      tlb.a(2, 1, a());
                      continue;
                      try
                      {
                        localObject1 = this.ak.getText().toString();
                        if (TextUtils.isEmpty((CharSequence)localObject1)) {
                          continue;
                        }
                        long l = Long.parseLong((String)localObject1);
                        localObject1 = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=1&referer=2066&_sig=da2a4472ac1a98a2d4f5cc0d86428bc1fc05b69a936b919303c45fcd37947008&areaId=" + l;
                        MiniAppLauncher.startMiniApp(getActivity(), (String)localObject1, 2066, null);
                      }
                      catch (Exception localException2)
                      {
                        localException2.printStackTrace();
                      }
                      continue;
                      if (this.a != null)
                      {
                        com.tencent.gdtad.aditem.GdtAd localGdtAd = this.a.getAd();
                        if (localGdtAd != null)
                        {
                          localObject2 = new Intent();
                          localObject3 = new GdtImaxData();
                          ((GdtImaxData)localObject3).setAd(localGdtAd);
                          GdtVideoData localGdtVideoData = new GdtVideoData();
                          localGdtVideoData.setUrl(localGdtAd.getVideoUrl());
                          localGdtVideoData.setStartPositionMillis(0L);
                          localGdtVideoData.setLoop(true);
                          localGdtVideoData.setDirectPlay(true);
                          localGdtVideoData.setAd(localGdtAd);
                          localGdtVideoData.setVideoDefaultBackgroundColor(0);
                          localGdtVideoData.setForceNotShowControllerView(true);
                          localGdtVideoData.setCoverUrl(localGdtAd.info.display_info.basic_info.img.get());
                          ((GdtImaxData)localObject3).setVideoData(localGdtVideoData);
                          ((GdtImaxData)localObject3).setWebUrl(localGdtAd.getUrlForLandingPage());
                          ((Intent)localObject2).putExtra("data", (Serializable)localObject3);
                          PublicFragmentActivity.b.startForResult(getActivity(), (Intent)localObject2, PublicFragmentActivityForQzone.class, GdtMotiveVideoMockQzoneImaxFeedsFragment.class, 1);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559396, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131363766).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363958).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379401).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379402).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379404).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379407).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379408).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379409).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379457).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131379435).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362065).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362135).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131382148).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362086).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371976).setOnClickListener(this);
    this.ak = ((EditText)paramLayoutInflater.findViewById(2131366521));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    bDf();
  }
  
  class a
    implements tgl
  {
    private Activity activity;
    
    public a(Activity paramActivity)
    {
      this.activity = paramActivity;
    }
    
    private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
        return paramGdtAd.getAd().getAId();
      }
      return -2147483648L;
    }
    
    public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      GdtDemoMvFragment.a(GdtDemoMvFragment.this, paramGdtAd);
      QQToast.a(this.activity, "demo数据构造成功", 0).show();
      QLog.i("GdtMotiveVideoAd", 1, String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
      tgh.a().a(paramGdtAd.getAd());
    }
    
    public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, tgk paramtgk)
    {
      QLog.e("GdtMotiveVideoAd", 1, "onAdFailedToLoad " + paramtgk.getErrorMessage());
    }
    
    public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      QLog.i("GdtMotiveVideoAd", 1, String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    }
    
    public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      QLog.i("GdtMotiveVideoAd", 1, String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    }
    
    public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
    {
      QLog.i("GdtMotiveVideoAd", 1, String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment
 * JD-Core Version:    0.7.0.1
 */