package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.browser.BrowserPluginEngine;
import com.tencent.qqmini.sdk.browser.TranslucentBrowserFragment;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentActivity;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentActivity.Launcher;
import com.tencent.qqmini.sdk.launcher.ui.MiniTranslucentFragmentActivity;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

@MiniKeep
public class BaseBrowserFragment
  extends MiniBaseFragment
  implements View.OnClickListener
{
  public static final String KEY_COOKIE = "cookie";
  public static final String KEY_HIDE_LEFT_BUTTON = "hide_left_button";
  public static final String KEY_HIDE_MORE_BUTTON = "hide_more_button";
  public static final String KEY_HIDE_TITLE = "hide_title";
  public static final String KEY_HIDE_TITLE_BAR = "hide_title_bar";
  public static final String KEY_LEFT_BUTTON_TEXT = "left_button_text";
  public static final String KEY_MORE_BUTTON_TEXT = "more_button_text";
  public static final String KEY_TITLE_TEXT = "title_text";
  public static final String KEY_URL = "url";
  private final String TAG = "BaseBrowserFragment";
  BrowserPluginEngine mBrowerEngin;
  ArrayMap<String, Object> mCoreDumpData;
  TextView mLeftBtnView;
  View mTitleBar;
  TextView mTitleView;
  private WebView mWebView;
  
  private void initCookie(Intent paramIntent, String paramString)
  {
    paramIntent = paramIntent.getStringExtra("cookie");
    if (!TextUtils.isEmpty(paramIntent))
    {
      Object localObject = paramIntent.replace(" ", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((Build.VERSION.SDK_INT < 21) && (getActivity() != null)) {
          CookieSyncManager.createInstance(getActivity());
        }
        paramIntent = CookieManager.getInstance();
        paramIntent.setAcceptCookie(true);
        localObject = ((String)localObject).split(";");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          paramIntent.setCookie(Uri.parse(paramString).getHost(), str);
          i += 1;
        }
      }
    }
    try
    {
      CookieSyncManager.getInstance().sync();
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  private void initLeftView(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("hide_left_button", false))
    {
      this.mLeftBtnView.setVisibility(4);
      return;
    }
    String str = paramIntent.getStringExtra("left_button_text");
    TextView localTextView = this.mLeftBtnView;
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = "返回";
    }
    localTextView.setText(paramIntent);
    this.mLeftBtnView.setOnClickListener(this);
  }
  
  private void initTitle(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("hide_title", false))
    {
      this.mTitleView.setVisibility(4);
      return;
    }
    String str = paramIntent.getStringExtra("title_text");
    TextView localTextView = this.mTitleView;
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = "";
    }
    localTextView.setText(paramIntent);
  }
  
  private void initView(Intent paramIntent, View paramView)
  {
    this.mTitleBar = paramView.findViewById(R.id.title_bar);
    this.mLeftBtnView = ((TextView)paramView.findViewById(R.id.ivTitleBtnLeft));
    this.mTitleView = ((TextView)paramView.findViewById(R.id.ivTitleName));
    this.mWebView = ((WebView)paramView.findViewById(R.id.web_view));
    initWebview();
    if (paramIntent.getBooleanExtra("hide_title_bar", false))
    {
      this.mTitleBar.setVisibility(8);
      return;
    }
    initLeftView(paramIntent);
    initTitle(paramIntent);
  }
  
  private void initWebview()
  {
    if (needWebViewTranslucent()) {
      this.mWebView.setBackgroundColor(0);
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      WebView localWebView = this.mWebView;
      WebView.setWebContentsDebuggingEnabled(true);
    }
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.setWebViewClient(new BaseBrowserFragment.1(this));
    this.mBrowerEngin = new BrowserPluginEngine(getActivity(), this.mWebView);
    this.mBrowerEngin.bindFragment(this);
  }
  
  public static void launch(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.putExtra("public_fragment_window_feature", 1);
    MiniFragmentActivity.Launcher.start(paramActivity, paramIntent, MiniFragmentActivity.class, BaseBrowserFragment.class);
  }
  
  public static void launchForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("public_fragment_window_feature", 1);
    MiniFragmentActivity.Launcher.startForResult(paramActivity, paramIntent, MiniFragmentActivity.class, BaseBrowserFragment.class, paramInt);
  }
  
  public static void launchTranslucentForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("public_fragment_window_feature", 1);
    MiniFragmentActivity.Launcher.startForResult(paramActivity, paramIntent, MiniTranslucentFragmentActivity.class, TranslucentBrowserFragment.class, paramInt);
  }
  
  protected boolean needWebViewTranslucent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.ivTitleBtnLeft) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = null;
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.mini_sdk_fragment_browser, paramViewGroup, false);
    if (paramLayoutInflater == null)
    {
      getActivity().finish();
      paramLayoutInflater = paramBundle;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (DisplayUtil.isImmersiveSupported) {
        paramLayoutInflater.setFitsSystemWindows(true);
      }
      paramViewGroup = getActivity().getIntent();
      if (paramViewGroup == null)
      {
        getActivity().finish();
        paramLayoutInflater = paramBundle;
      }
      else
      {
        String str = paramViewGroup.getStringExtra("url");
        if (StringUtil.isEmpty(str))
        {
          getActivity().finish();
          paramLayoutInflater = paramBundle;
        }
        else
        {
          initView(paramViewGroup, paramLayoutInflater);
          initCookie(paramViewGroup, str);
          this.mWebView.loadUrl(str);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mBrowerEngin != null)
    {
      this.mBrowerEngin.onDestroy();
      this.mBrowerEngin = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.BaseBrowserFragment
 * JD-Core Version:    0.7.0.1
 */