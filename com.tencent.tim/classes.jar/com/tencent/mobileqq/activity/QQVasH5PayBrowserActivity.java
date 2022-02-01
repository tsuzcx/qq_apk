package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import arcd;
import arcd.a;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.vip.manager.MonitorManager;
import rwt;

public class QQVasH5PayBrowserActivity
  extends QQBrowserActivity
{
  public QQVasH5PayBrowserActivity()
  {
    this.s = QQVasH5PayBrowserFragment.class;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "QQVasH5PayBrowserActivity doOnCreate: ");
    }
    boolean bool = super.doOnCreate(paramBundle);
    overridePendingTransition(0, 0);
    MonitorManager.a().j(1, 0, "会员：呼起透明支付Activity", "");
    return bool;
  }
  
  public void doOnDestroy()
  {
    setResult(-1);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    getWindow().setBackgroundDrawableResource(2131167595);
    findViewById(2131363728).setBackgroundResource(2131167595);
    return bool;
  }
  
  public static class QQVasH5PayBrowserFragment
    extends WebViewFragment
  {
    private void F(ViewGroup paramViewGroup)
    {
      if (paramViewGroup == null) {
        return;
      }
      int j = paramViewGroup.getChildCount();
      int i = 0;
      label12:
      View localView;
      if (i < j)
      {
        localView = paramViewGroup.getChildAt(i);
        if (!(localView instanceof ViewGroup)) {
          break label54;
        }
        localView.setBackgroundColor(0);
        F((ViewGroup)localView);
      }
      for (;;)
      {
        i += 1;
        break label12;
        break;
        label54:
        localView.setBackgroundColor(0);
      }
    }
    
    @TargetApi(11)
    private void bUH()
    {
      if (super.getWebView() != null)
      {
        if ((this.jdField_a_of_type_Arcd$a.gK & 0x80000) == 0L) {
          break label223;
        }
        this.jdField_a_of_type_Arcd.mLoadingProgressBar.setVisibility(8);
        Intent localIntent = getIntent();
        if ((localIntent == null) || (!localIntent.getBooleanExtra("from_qreader", false))) {
          break label172;
        }
        F((ViewGroup)getActivity().getWindow().getDecorView());
        if ((this.jdField_a_of_type_Arcd.eQ instanceof RefreshView)) {
          ((RefreshView)this.jdField_a_of_type_Arcd.eQ).uW(false);
        }
        if (this.jdField_a_of_type_Arcd.eG != null) {
          this.jdField_a_of_type_Arcd.eG.setVisibility(8);
        }
        if (this.j.getX5WebViewExtension() == null) {
          break label195;
        }
      }
      for (;;)
      {
        try
        {
          if (Build.VERSION.SDK_INT >= 11) {
            this.j.setLayerType(1, null);
          }
          this.j.getView().setBackgroundColor(0);
        }
        catch (Exception localException)
        {
          label172:
          localException.printStackTrace();
          continue;
        }
        Td(true);
        super.getWebView().setVisibility(4);
        return;
        super.getActivity().getWindow().setBackgroundDrawableResource(2131167595);
        break;
        label195:
        this.j.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.j.setLayerType(1, null);
          continue;
          label223:
          if (this.jdField_a_of_type_Arcd.eG != null) {
            this.jdField_a_of_type_Arcd.eG.setVisibility(0);
          }
        }
      }
    }
    
    public int a(Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "QQVasH5PayBrowserActivity doCreateLoopStep_Final: ");
      }
      int i = super.a(paramBundle);
      super.getWebView().setVisibility(0);
      return i;
    }
    
    @TargetApi(11)
    public int o(Bundle paramBundle)
    {
      int i = super.o(paramBundle);
      bUH();
      return i;
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      rwt.ez(1, 2131697427);
      super.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity
 * JD-Core Version:    0.7.0.1
 */