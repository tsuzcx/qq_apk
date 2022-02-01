package com.tencent.biz.qqcircle.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import aeay;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import aqiw;
import arcd;
import arcd.a;
import arju;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import oum;
import ovd;
import siu;
import sqn;

public class QCircleHybirdFragment
  extends WebViewFragment
{
  private static final String TAG = QCircleHybirdFragment.class.getSimpleName();
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private a jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleHybirdFragment$a;
  private CommentBottomBar jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private siu jdField_a_of_type_Siu;
  protected aeay mColorNoteController;
  private ExtraTypeInfo mExtraTypeInfo;
  private ImageView mLoadingView;
  
  private void biS()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = new StatusView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
    this.jdField_a_of_type_Arcd.eQ.addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
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
    if (!this.jdField_a_of_type_Arcd$a.cYw) {
      ovd.bc(getActivity());
    }
    if (getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleHybirdFragment$a = new a(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_update_web_user_follow_state");
      paramBundle.addAction("action_update_web_tag_follow_state");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleHybirdFragment$a, paramBundle);
    }
    biS();
    return i;
  }
  
  public void bc(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_user_follow_state");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("type", paramInt);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void bd(String paramString, int paramInt)
  {
    paramString = new Intent();
    paramString.setAction("action_update_native_tag_follow_state");
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(paramString);
    }
    qy(oum.lQ());
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
  
  public int n(Bundle paramBundle)
  {
    this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYM = false;
    this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYp = true;
    this.jdField_a_of_type_Arcd.ees = ovd.p(false);
    this.jdField_a_of_type_Siu = new siu(getHostActivity());
    initData();
    return super.n(paramBundle);
  }
  
  public void o(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_auth_info");
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("status", paramInt2);
    localIntent.putExtra("tagName", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
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
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleHybirdFragment$a != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleHybirdFragment$a);
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
  
  public void qy(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void vm(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_clear_message_red_poiont");
    localIntent.putExtra("createTime", paramInt);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    private WeakReference<QCircleHybirdFragment> F;
    
    public a(QCircleHybirdFragment paramQCircleHybirdFragment)
    {
      this.F = new WeakReference(paramQCircleHybirdFragment);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = (QCircleHybirdFragment)this.F.get();
      Object localObject;
      if ((paramContext != null) && (paramIntent != null))
      {
        localObject = paramIntent.getAction();
        if (!TextUtils.equals((CharSequence)localObject, "action_update_web_user_follow_state")) {
          break label96;
        }
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("uin", paramIntent.getStringExtra("uin"));
          ((JSONObject)localObject).put("followstate", paramIntent.getIntExtra("followstate", 0));
          if (paramContext.getWebView() != null) {
            paramContext.getWebView().callJs(WebViewPlugin.toJsScript("updateQCircleFollowState", (JSONObject)localObject, null));
          }
          return;
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        label96:
        if (TextUtils.equals((CharSequence)localObject, "action_update_web_tag_follow_state")) {
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("tagId", paramIntent.getStringExtra("tagId"));
            ((JSONObject)localObject).put("followstate", paramIntent.getIntExtra("followstate", 0));
            if (paramContext.getWebView() != null)
            {
              paramContext.getWebView().callJs(WebViewPlugin.toJsScript("updateQCircleTagFollowState", (JSONObject)localObject, null));
              return;
            }
          }
          catch (Exception paramContext)
          {
            QLog.e(QCircleHybirdFragment.TAG, 1, "update tag follow state error.", paramContext);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleHybirdFragment
 * JD-Core Version:    0.7.0.1
 */