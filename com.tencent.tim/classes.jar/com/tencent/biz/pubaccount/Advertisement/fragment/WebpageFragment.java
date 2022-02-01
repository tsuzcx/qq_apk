package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import anot;
import arcd;
import arcd.a;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import jqo;
import jxc;
import jxe;

public class WebpageFragment
  extends WebViewFragment
{
  private jxc a;
  
  public static WebpageFragment a(Intent paramIntent)
  {
    WebpageFragment localWebpageFragment = new WebpageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localWebpageFragment.setArguments(localBundle);
    return localWebpageFragment;
  }
  
  public void a(jxc paramjxc)
  {
    this.jdField_a_of_type_Jxc = paramjxc;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F6B", "0X8008F6B", 0, 0, this.jdField_a_of_type_Jxc.a.hT, "", "", this.jdField_a_of_type_Jxc.a.mNickName);
  }
  
  public void onResume()
  {
    super.onResume();
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null)
    {
      int i = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
  
  public boolean showPreview()
  {
    jqo.le("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.jdField_a_of_type_Arcd.dU(this.intent);
    this.jdField_a_of_type_Arcd$a.Dr = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.init(this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYM);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    setImmersiveStatus();
    if (QLog.isColorLevel()) {
      QLog.d("WebpageFragment", 2, "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    }
    this.jdField_a_of_type_Arcd.cYj = true;
    this.jdField_a_of_type_Arcd.ar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.aq;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.ce.setVisibility(8);
    this.jdField_a_of_type_Arcd.rS(this.mUrl);
    this.jdField_a_of_type_Arcd.zP = false;
    jqo.lf("Web_qqbrowser_ShowPreview");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment
 * JD-Core Version:    0.7.0.1
 */