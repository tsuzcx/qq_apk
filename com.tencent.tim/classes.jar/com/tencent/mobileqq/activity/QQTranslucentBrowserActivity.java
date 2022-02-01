package com.tencent.mobileqq.activity;

import aihl;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import arcd;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.WebView;
import vql;
import vqm;

public class QQTranslucentBrowserActivity
  extends QQBrowserActivity
{
  private Dialog k;
  
  public QQTranslucentBrowserActivity()
  {
    this.s = QQTranslucentBrowserFragment.class;
  }
  
  public void Sa()
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.k == null) {
        this.k = new a(this);
      }
    } while (this.k == null);
    this.k.show();
  }
  
  public void bpm()
  {
    if ((this.k != null) && (this.k.isShowing()))
    {
      this.k.dismiss();
      this.k = null;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    getWindow().setBackgroundDrawableResource(2131167595);
    View localView = findViewById(2131363728);
    if (localView != null) {
      localView.setBackgroundResource(2131167595);
    }
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getIntExtra("key_dialog_type", -1);
      if (!paramBundle.getBooleanExtra("flag_show_loading_dialog", false)) {
        break label68;
      }
      Sa();
    }
    label68:
    do
    {
      return bool;
      if (i == 4)
      {
        this.k = aihl.c(this);
        this.k.setOnDismissListener(new vql(this));
        Sa();
        return bool;
      }
    } while (i != 5);
    this.k = aihl.a(this, paramBundle);
    this.k.setOnDismissListener(new vqm(this));
    Sa();
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bpm();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    bpm();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    bpm();
    super.onPageFinished(paramWebView, paramString);
  }
  
  public static class QQTranslucentBrowserFragment
    extends WebViewFragment
  {
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      if ((getActivity() == null) || (getActivity().getIntent() == null)) {}
      while (this.intent.getIntExtra("key_dialog_type", -1) == -1) {
        return i;
      }
      getActivity().getWindow().setFlags(1024, 1024);
      this.jdField_a_of_type_Arcd.mLoadingProgressBar.setVisibility(8);
      this.jdField_a_of_type_Arcd$a.isFullScreen = true;
      egN();
      Tl(false);
      return i;
    }
    
    @TargetApi(11)
    public int o(Bundle paramBundle)
    {
      int i = super.o(paramBundle);
      super.getActivity().getWindow().setBackgroundDrawableResource(2131167595);
      if ((this.jdField_a_of_type_Arcd.eQ instanceof RefreshView)) {
        ((RefreshView)this.jdField_a_of_type_Arcd.eQ).uW(false);
      }
      if (this.jdField_a_of_type_Arcd.eG != null) {
        this.jdField_a_of_type_Arcd.eG.setVisibility(8);
      }
      if (this.j.getX5WebViewExtension() != null) {}
      for (;;)
      {
        try
        {
          this.j.getView().setBackgroundColor(0);
          this.j.setBackgroundColor(0);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.setBackgroundColor(0);
          return i;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          continue;
        }
        this.j.setBackgroundColor(0);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      paramLayoutInflater.setBackgroundColor(0);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public static class a
    extends ReportDialog
  {
    public a(Context paramContext)
    {
      super(2131756293);
      setContentView(2131562441);
      getWindow().setFlags(1024, 2048);
    }
    
    public void dismiss()
    {
      try
      {
        super.dismiss();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("WebLog_QQBrowserActivity", 2, localException, new Object[0]);
      }
    }
    
    public void setTitle(int paramInt)
    {
      if (paramInt == 0) {}
      for (String str = null;; str = getContext().getResources().getString(paramInt))
      {
        setTitle(str);
        return;
      }
    }
    
    public void setTitle(String paramString)
    {
      ((TextView)findViewById(2131379769)).setText(paramString);
    }
    
    public void show()
    {
      try
      {
        super.show();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("WebLog_QQBrowserActivity", 2, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */