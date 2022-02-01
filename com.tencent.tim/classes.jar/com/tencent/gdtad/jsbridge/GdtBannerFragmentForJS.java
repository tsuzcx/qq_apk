package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import thd;
import the;
import thf;
import tju;
import tkw;
import tls;

public class GdtBannerFragmentForJS
  extends tju
{
  private GdtBannerAd b;
  private thd bannerParams;
  private the d;
  
  public GdtAd a()
  {
    return this.b;
  }
  
  public void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams)
  {
    this.bannerParams = new thd();
    this.bannerParams.b = paramQQAdGet;
    this.bannerParams.c = paramParams;
    try
    {
      int i = new JSONObject(paramString).getInt("style");
      this.bannerParams.style = i;
      i = tls.b(getActivity(), 1080, 1026);
      int j = thf.ad(this.bannerParams.style, i);
      this.bannerParams.width = i;
      this.bannerParams.height = j;
      this.b = new GdtBannerAd(this.bannerParams);
      this.b.setListener(new WeakReference(this.a));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        tkw.e("GdtBannerFragmentForJS", "createParams error", paramString);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().addFlags(1024);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.d != null) {
      this.d.destroy(getActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.d != null) {
      this.d.pause(getActivity());
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.d != null) {
      this.d.resume(getActivity());
    }
  }
  
  public void onShow()
  {
    int i = tls.b(getActivity(), 1080, 1026);
    int j = thf.ad(this.bannerParams.style, i);
    this.d = this.b.render(getActivity(), i, j);
    if (this.d == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "ad is rendered", 0).show();
      return;
    }
    if (this.d.getView() == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, j);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = 100;
    localLayoutParams.bottomMargin = 100;
    this.containerView.addView(this.d.getView(), localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS
 * JD-Core Version:    0.7.0.1
 */