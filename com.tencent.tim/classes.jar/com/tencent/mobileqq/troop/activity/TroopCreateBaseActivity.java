package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

public abstract class TroopCreateBaseActivity
  extends AbsBaseWebViewActivity
{
  CustomWebView a;
  protected a a;
  
  protected void Wp(int paramInt)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getWindowToken(), 2);
  }
  
  protected void dXt()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
      return;
    }
    finish();
  }
  
  protected void dXu() {}
  
  protected void dXv() {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = b((ViewGroup)null);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setId(2131382171);
    setContentView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    paramBundle = getIntent().getStringExtra("url");
    if (TextUtils.isEmpty(paramBundle)) {
      return false;
    }
    Object localObject = Uri.parse(paramBundle);
    if (((Uri)localObject).isHierarchical())
    {
      localObject = ((Uri)localObject).getQueryParameter("_wv");
      if (localObject == null) {}
    }
    try
    {
      this.gK = Long.parseLong((String)localObject, 10);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramBundle);
      this.leftView.setOnClickListener(new a(this, 0, null));
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopCreateBaseActivity", 4, "_wv param not found");
        }
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity$a.onClick(this.leftView);
      return true;
    }
    return false;
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
  
  public static class a
    implements View.OnClickListener
  {
    TroopCreateBaseActivity a = null;
    int btnType = 0;
    String callback;
    
    public a(TroopCreateBaseActivity paramTroopCreateBaseActivity, int paramInt, String paramString)
    {
      this.a = paramTroopCreateBaseActivity;
      this.btnType = paramInt;
      this.callback = paramString;
    }
    
    public void onClick(View paramView)
    {
      if (this.a == null)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      if (TextUtils.isEmpty(this.callback)) {
        if (this.btnType == 0) {
          this.a.dXt();
        }
      }
      for (;;)
      {
        this.a.Wp(this.btnType);
        break;
        if (this.btnType == 1)
        {
          this.a.dXu();
        }
        else if (this.btnType == 2)
        {
          this.a.dXv();
          continue;
          CustomWebView localCustomWebView = this.a.a;
          if (localCustomWebView != null) {
            localCustomWebView.callJs(this.callback, new String[] { "" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity
 * JD-Core Version:    0.7.0.1
 */