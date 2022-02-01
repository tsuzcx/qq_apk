package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import aeay;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import aqiw;
import aqmr;
import aqzl;
import arcd;
import arju;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import rzd;
import rze;
import san;
import scw;
import seg;
import seh;
import sei;
import sej;
import sek;
import sgy;
import siu;
import sqn;

public class SubscribeHybirdFragment
  extends WebViewFragment
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CommentBottomBar jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
  private a jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$a;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private sgy jdField_a_of_type_Sgy;
  private siu jdField_a_of_type_Siu;
  private CertifiedAccountMeta.StShare b;
  private int bwx;
  protected aeay mColorNoteController;
  private ExtraTypeInfo mExtraTypeInfo;
  private ImageView mLoadingView;
  private View pJ;
  
  private void Je()
  {
    if ((this.mExtraTypeInfo.pageType != 7000) && (this.mExtraTypeInfo.pageType != 8001)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject1).gravity = 80;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(getActivity());
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(getHostActivity(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new sek(this));
      Object localObject2 = new san();
      ((san)localObject2).ayK = false;
      ((san)localObject2).shareFromType = 2;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(a((san)localObject2));
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_Arcd.cg.addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
      localObject1 = new ViewStub(getHostActivity());
      localObject2 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject2).gravity = 80;
      ((ViewStub)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_Arcd.cg.addView((View)localObject1);
      this.jdField_a_of_type_Arcd.eQ.setPadding(0, 0, 0, ImmersiveUtils.dpToPx(50.0F));
    } while (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() == null);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().b((ViewStub)localObject1);
  }
  
  private View.OnClickListener a(san paramsan)
  {
    return new sej(this, paramsan);
  }
  
  private void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setCurrentFeed(paramStFeed);
    }
    if (this.jdField_a_of_type_Sgy != null) {
      this.jdField_a_of_type_Sgy.a(paramStFeed.poster);
    }
  }
  
  private void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, long paramLong, String paramString)
  {
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if (f(paramLong, paramString)) {}
    while (d(localStFeed)) {
      return;
    }
    this.b = ((CertifiedAccountMeta.StShare)paramStGetFeedDetailRsp.share.get());
    a(localStFeed);
    if (this.mExtraTypeInfo.pageType == 8001)
    {
      WebSoService.a().clearCache();
      sqn.b(this.uin, "auth_image", "exp", 0, 0, new String[] { "", "", localStFeed.poster.nick.get(), localStFeed.title.get() });
    }
    if (!aqmr.isEmpty(paramStGetFeedDetailRsp.detailUrl.get()))
    {
      if (getWebView() != null)
      {
        getWebView().loadUrl(paramStGetFeedDetailRsp.detailUrl.get());
        return;
      }
      QLog.e("SubscribeHybirdFragment", 2, "webview init exception it's null");
      return;
    }
    QLog.e("SubscribeHybirdFragment", 2, "detailUrl is null");
  }
  
  public static void a(Context paramContext, FollowUpdateEvent paramFollowUpdateEvent)
  {
    if ((paramContext == null) || (paramFollowUpdateEvent == null)) {
      return;
    }
    Intent localIntent = new Intent("action_update_follow_state");
    localIntent.putExtra("uin", paramFollowUpdateEvent.useId);
    localIntent.putExtra("followState", paramFollowUpdateEvent.followStatus);
    paramContext.sendBroadcast(localIntent);
  }
  
  private void aYx()
  {
    if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType != 8001)) {}
    while (this.mColorNoteController != null) {
      return;
    }
    this.mColorNoteController = new aeay(getActivity(), false, true);
    this.mColorNoteController.attachToActivity(getActivity());
    this.mColorNoteController.setServiceInfo(new seg(this));
    this.mColorNoteController.a(new seh(this));
    this.mColorNoteController.setOnColorNoteCurdListener(new sei(this));
  }
  
  private void biS()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = new StatusView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
    this.jdField_a_of_type_Arcd.eQ.addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
  }
  
  private void byd()
  {
    this.jdField_a_of_type_Aqzl.aK.setBackgroundColor(-1);
    this.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130840664);
    this.jdField_a_of_type_Aqzl.leftView.setBackgroundResource(2130840658);
    this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(0);
  }
  
  private boolean d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (!rze.fh(paramStFeed.status.get())) {
      if (rze.bg(paramStFeed.poster.attr.get()))
      {
        if (this.pJ == null)
        {
          this.pJ = LayoutInflater.from(getActivity()).inflate(2131558876, null, false);
          this.pJ.setLayoutParams(new ViewGroup.LayoutParams(-1, ImmersiveUtils.dpToPx(44.0F)));
          this.jdField_a_of_type_Arcd.eQ.addView(this.pJ);
        }
        this.pJ.setVisibility(0);
      }
    }
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.getVisibility() == 8))
      {
        if ((this.pJ != null) && (this.pJ.getVisibility() == 0)) {
          this.pJ.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.qH(null);
      }
      return true;
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.bkV();
      }
    } while ((this.pJ == null) || (this.pJ.getVisibility() != 0));
    this.pJ.setVisibility(8);
    return false;
  }
  
  private boolean f(long paramLong, String paramString)
  {
    if (paramLong != 0L)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.qH(paramString);
      }
      return true;
    }
    return false;
  }
  
  private void initData()
  {
    if (getIntent() != null)
    {
      long l = getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l != 0L) {
        sqn.n("subscribe_open_h5_page_time", sqn.i(0L, System.currentTimeMillis() - l));
      }
      this.mExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    }
    if (this.mExtraTypeInfo == null) {
      this.mExtraTypeInfo = new ExtraTypeInfo();
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(this.intent.getByteArrayExtra("bundle_key_subscribe_feed_bytes_array")));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void initLoadingView()
  {
    Object localObject = rze.no();
    if (new File((String)localObject).exists())
    {
      this.mLoadingView = new ImageView(getActivity());
      this.mLoadingView.setBackgroundColor(-1);
      this.mLoadingView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    try
    {
      this.mLoadingView.setImageURI(Uri.fromFile(new File((String)localObject + "/certified_account_preload_pic.png")));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.mLoadingView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((this.jdField_a_of_type_Arcd != null) && (this.jdField_a_of_type_Arcd.eQ != null)) {
        this.jdField_a_of_type_Arcd.eQ.addView(this.mLoadingView);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void ys(int paramInt)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (!aqmr.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()))) {
      sqn.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_" + siu.b(this.mExtraTypeInfo), paramInt, 0, new String[0]);
    }
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    getWebView().getSettings().setDefaultTextEncodingName("utf-8");
    getWebView().getSettings().setUserAgentString(getWebView().getSettings().getUserAgentString() + " QQ_APP_Subscribe");
    if (aqiw.isNetworkAvailable(getActivity())) {
      getWebView().getSettings().setCacheMode(2);
    }
    if ((this.jdField_a_of_type_Arcd != null) && (this.jdField_a_of_type_Arcd.mProgressBarController != null)) {
      this.jdField_a_of_type_Arcd.mProgressBarController.xW(false);
    }
    switch (this.mExtraTypeInfo.pageType)
    {
    default: 
      if ((anlm.ayn()) && (Build.VERSION.SDK_INT >= 23))
      {
        if (this.Js != null) {
          this.Js.setBackgroundColor(-1);
        }
        this.bwx = (getActivity().getWindow().getDecorView().getSystemUiVisibility() | 0x400 | 0x2000);
        getActivity().getWindow().getDecorView().setSystemUiVisibility(this.bwx);
      }
      if (this.mExtraTypeInfo.pageType == 8002) {
        this.jdField_a_of_type_Aqzl.rightViewImg.setOnClickListener(this);
      }
      break;
    }
    for (;;)
    {
      Je();
      biS();
      aYx();
      if (this.mExtraTypeInfo.pageType == 8001) {
        this.jdField_a_of_type_Sgy = new sgy(getActivity());
      }
      if (getActivity() != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$a = new a(null);
        paramBundle = new IntentFilter();
        paramBundle.addAction("action_update_follow_state");
        paramBundle.addAction("action_get_lbs_location");
        getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$a, paramBundle);
      }
      return i;
      byd();
      initLoadingView();
      break;
      if ((getActivity().getIntent() != null) && (this.mExtraTypeInfo.pageType == 8002))
      {
        this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
      break;
      paramBundle = new san();
      paramBundle.ayK = true;
      paramBundle.shareFromType = 1;
      this.jdField_a_of_type_Aqzl.rightViewImg.setOnClickListener(a(paramBundle));
    }
  }
  
  public void a(san paramsan)
  {
    san localsan = paramsan;
    if (paramsan == null) {
      localsan = new san();
    }
    if (this.jdField_a_of_type_Siu != null)
    {
      ys(localsan.shareFromType);
      localsan.mUrl = getCurrentUrl();
      localsan.mFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      localsan.a = this.b;
      localsan.mExtraTypeInfo = this.mExtraTypeInfo;
      this.jdField_a_of_type_Siu.a(localsan, this.mColorNoteController);
    }
  }
  
  public void biT()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.onBackPressed())) {
      return;
    }
    String str;
    if (this.mExtraTypeInfo != null)
    {
      str = "";
      switch (this.mExtraTypeInfo.pageType)
      {
      }
    }
    for (;;)
    {
      sqn.b(this.uin, str, "clk_return", 0, 0, new String[] { "", "" });
      super.biT();
      return;
      str = "auth_image";
      continue;
      str = "auth_video";
      continue;
      str = "auth_person";
    }
  }
  
  public void bye()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void byf()
  {
    if (getHostActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_refresh_return_page");
      if (getHostActivity() != null) {
        getHostActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void cy(ArrayList<CommodityBean> paramArrayList)
  {
    if (getHostActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("attach_goods", paramArrayList);
      localIntent.setAction("action_attach_goods");
      if (getHostActivity() != null) {
        getHostActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (rzd.fg(paramStFeed.type.get()))
    {
      if (this.mLoadingView != null) {
        this.mLoadingView.setVisibility(0);
      }
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.l(paramStFeed);
      if (getWebView() != null) {
        getWebView().pageUp(true);
      }
    }
    do
    {
      return;
      rzd.a(getActivity(), paramStFeed);
    } while (getActivity() == null);
    getActivity().finish();
  }
  
  public void h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.set(paramString1);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.set(paramString2);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.set(paramString3);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.desc.set(paramString4);
      paramString2 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.type;
      if (!aqmr.isEmpty(paramString5)) {
        break label108;
      }
    }
    label108:
    for (int i = 0;; i = Integer.parseInt(paramString5))
    {
      paramString2.set(i);
      sqn.b(paramString1, "auth_person", "exp", 0, 0, new String[0]);
      return;
    }
  }
  
  public int n(Bundle paramBundle)
  {
    this.jdField_a_of_type_Arcd.a.cYM = false;
    this.jdField_a_of_type_Arcd.a.cYp = true;
    this.jdField_a_of_type_Siu = new siu(getHostActivity());
    initData();
    return super.n(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.release();
    }
    if (this.mLoadingView != null) {
      this.mLoadingView.setImageDrawable(null);
    }
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onDestroy();
    }
    if (this.jdField_a_of_type_Siu != null) {
      this.jdField_a_of_type_Siu.onDestroy();
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$a != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeHybirdFragment$a);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onPause();
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if ((paramInt > 25) && (this.mLoadingView != null)) {
      this.mLoadingView.setVisibility(8);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onResume();
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = 0;
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        if (!TextUtils.equals(paramContext, "action_update_follow_state")) {
          break label89;
        }
      }
      label89:
      while (!TextUtils.equals(paramContext, "action_get_lbs_location")) {
        try
        {
          paramContext = new JSONObject();
          paramContext.put("uin", paramIntent.getStringExtra("uin"));
          paramContext.put("followState", paramIntent.getIntExtra("followState", 0));
          if (SubscribeHybirdFragment.this.getWebView() != null) {
            SubscribeHybirdFragment.this.getWebView().callJs(WebViewPlugin.toJsScript("updateFollowState", paramContext, null));
          }
          return;
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
      for (;;)
      {
        try
        {
          paramContext = paramIntent.getStringArrayExtra("code");
          String[] arrayOfString = paramIntent.getStringArrayExtra("location");
          paramIntent = new JSONObject();
          JSONObject localJSONObject = new JSONObject();
          if ((paramContext != null) && (arrayOfString != null) && (paramContext.length == 4) && (arrayOfString.length == 4))
          {
            if (i < 4)
            {
              if ("0".equals(paramContext[i]))
              {
                paramContext[i] = "";
                arrayOfString[i] = "";
              }
            }
            else
            {
              paramIntent.put("country", paramContext[0]);
              paramIntent.put("province", paramContext[1]);
              paramIntent.put("city", paramContext[2]);
              paramIntent.put("area", paramContext[3]);
              localJSONObject.put("country", arrayOfString[0]);
              localJSONObject.put("province", arrayOfString[1]);
              localJSONObject.put("city", arrayOfString[2]);
              localJSONObject.put("area", arrayOfString[3]);
            }
          }
          else
          {
            paramContext = new JSONObject();
            paramContext.put("code", paramIntent);
            paramContext.put("location", localJSONObject);
            if (SubscribeHybirdFragment.this.getWebView() == null) {
              break;
            }
            SubscribeHybirdFragment.this.getWebView().callJs(WebViewPlugin.toJsScript("getlbslocationCallback", paramContext, null));
            return;
          }
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment
 * JD-Core Version:    0.7.0.1
 */