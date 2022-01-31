package com.tencent.smtt.sdk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WebViewFragment
  extends Fragment
{
  private boolean mIsWebViewAvailable;
  private WebView mWebView;
  
  public WebView getWebView()
  {
    if (this.mIsWebViewAvailable) {
      return this.mWebView;
    }
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mWebView != null) {
      this.mWebView.destroy();
    }
    this.mWebView = new WebView(getActivity());
    this.mIsWebViewAvailable = true;
    return this.mWebView;
  }
  
  public void onDestroy()
  {
    if (this.mWebView != null)
    {
      this.mWebView.destroy();
      this.mWebView = null;
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.mIsWebViewAvailable = false;
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mWebView.onPause();
  }
  
  public void onResume()
  {
    this.mWebView.onResume();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebViewFragment
 * JD-Core Version:    0.7.0.1
 */