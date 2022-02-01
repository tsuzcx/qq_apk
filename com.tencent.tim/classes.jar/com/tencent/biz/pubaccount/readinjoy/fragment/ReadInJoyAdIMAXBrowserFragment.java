package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import aqzl;
import arcd;
import arju;
import ayxa;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import ldf;
import ldg;
import mqq.app.AppRuntime;
import muj;
import rpq;

public class ReadInJoyAdIMAXBrowserFragment
  extends WebViewFragment
{
  private boolean abl;
  private AdvertisementInfo advertisementInfo;
  private AppRuntime app;
  public long gK = 8996L;
  private ImageView iG;
  private ImageView iH;
  
  private void aKy()
  {
    ayxa.initLiuHaiProperty(getActivity());
    if (ayxa.isLiuHaiUseValid()) {
      ayxa.enableNotch(getActivity());
    }
    if (ayxa.isLiuHaiUseValid()) {}
    for (int i = ayxa.getNotchInScreenHeight(getActivity());; i = 0)
    {
      if (this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzl.aK != null) {
        this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzl.aK.setVisibility(8);
      }
      if (this.jdField_a_of_type_Arcd.mRootView != null) {
        ks(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296723), 0);
      }
      if (this.jdField_a_of_type_Arcd.eQ == null) {
        return;
      }
      int j = rpq.dip2px(getActivity(), 30.0F);
      this.iG = new ImageView(getActivity());
      this.iG.setBackgroundResource(2130843747);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = rpq.dip2px(getActivity(), 15.0F);
      localLayoutParams.topMargin = (rpq.dip2px(getActivity(), 15.0F) + i);
      this.jdField_a_of_type_Arcd.eQ.addView(this.iG, localLayoutParams);
      this.iG.setOnClickListener(new ldf(this));
      this.iH = new ImageView(getActivity());
      this.iH.setBackgroundResource(2130843749);
      localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = rpq.dip2px(getActivity(), 15.0F);
      localLayoutParams.topMargin = (i + rpq.dip2px(getActivity(), 15.0F));
      this.jdField_a_of_type_Arcd.eQ.addView(this.iH, localLayoutParams);
      this.iH.setOnClickListener(s());
      return;
    }
  }
  
  private View.OnClickListener s()
  {
    return new ldg(this);
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    if ((this.jdField_a_of_type_Arcd != null) && (this.jdField_a_of_type_Arcd.mProgressBarController != null)) {
      this.jdField_a_of_type_Arcd.mProgressBarController.xW(false);
    }
    if ((this.jdField_a_of_type_Arcd != null) && (this.jdField_a_of_type_Arcd.mRootView != null))
    {
      paramBundle = this.jdField_a_of_type_Arcd.mRootView.findViewById(2131365391);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.Js != null) {
      this.Js.setVisibility(8);
    }
    muj.aM(getHostActivity());
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle instanceof ToolAppRuntime)) {
      this.app = paramBundle.getAppRuntime("modular_web");
    }
    aKy();
    this.advertisementInfo = ((AdvertisementInfo)getIntent().getParcelableExtra("ad"));
    return i;
  }
  
  public int n(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Arcd != null)
    {
      this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYM = true;
      this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYp = true;
      this.jdField_a_of_type_Arcd$a.cYx = true;
    }
    muj.aM(getHostActivity());
    return super.n(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    muj.aM(getHostActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment
 * JD-Core Version:    0.7.0.1
 */