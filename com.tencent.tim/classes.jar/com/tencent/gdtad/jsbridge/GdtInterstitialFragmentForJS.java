package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tgc;
import tgc.a;
import tgk;
import thm;
import tkh;
import tki;
import tkj;
import tkk;
import tkv;
import tkw;
import tlo;
import tlo.a;

public class GdtInterstitialFragmentForJS
  extends PublicBaseFragment
{
  private GdtInterstitialParams jdField_b_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = new GdtInterstitialParams();
  private qq_ad_get.QQAdGet jdField_b_of_type_TencentGdtQq_ad_get$QQAdGet;
  private tgk jdField_b_of_type_Tgk;
  private thm jdField_b_of_type_Thm;
  private tgc.a loadListener = new tkk(this);
  private tgc loader;
  
  public static void a(Activity paramActivity, Class<? extends PublicFragmentActivity> paramClass, JSONObject paramJSONObject)
  {
    if ((paramActivity == null) || (paramJSONObject == null))
    {
      tkw.i("GdtInterstitialFragmentForJS", "start error");
      return;
    }
    tkw.i("GdtInterstitialFragmentForJS", "start");
    Bundle localBundle = new Bundle();
    localBundle.putString("params", paramJSONObject.toString());
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    paramJSONObject.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramJSONObject.putExtras(localBundle);
    PublicFragmentActivity.b.start(paramActivity, paramJSONObject, paramClass, GdtInterstitialFragmentForJS.class);
  }
  
  private static int q(Activity paramActivity)
  {
    int i = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int j = localDisplayMetrics.widthPixels;
    int k = localDisplayMetrics.heightPixels;
    if (((i != 0) && (i != 2)) || ((k > j) || (((i == 1) || (i == 3)) && (j > k))))
    {
      switch (i)
      {
      default: 
        tkw.e("GdtInterstitialFragmentForJS", "Unknown screen orientation. Defaulting to portrait.");
      case 0: 
        return 1;
      case 1: 
        return 0;
      case 2: 
        return 9;
      }
      return 8;
    }
    switch (i)
    {
    case 1: 
    default: 
      tkw.e("GdtInterstitialFragmentForJS", "Unknown screen orientation. Defaulting to landscape.");
      return 0;
    case 0: 
      return 0;
    case 2: 
      return 8;
    }
    return 9;
  }
  
  public int getErrorCode(GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 6;
    int i;
    if (paramInt1 == -2147483648) {
      i = 3;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramInt1 != 200);
        if (paramInt2 == 0) {
          break;
        }
        i = j;
      } while (paramInt2 != 1);
      return 4;
      if (paramInt3 == 0) {
        break;
      }
      i = j;
    } while (paramInt3 != 102006);
    return 5;
    if (paramGdtAd == null) {
      return 1;
    }
    if (!paramGdtAd.isValid()) {
      return 1;
    }
    return 0;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    tkw.i("GdtInterstitialFragmentForJS", String.format("onActivityResult requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (paramInt1 == 10001)
    {
      if (this.jdField_b_of_type_Thm != null) {
        this.jdField_b_of_type_Thm.onClose(getActivity(), paramInt2, paramIntent);
      }
      if (paramInt2 != -1) {
        break label79;
      }
    }
    label79:
    for (paramIntent = "on closed";; paramIntent = "on closed error")
    {
      Toast.makeText(getActivity().getApplicationContext(), paramIntent, 0).show();
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    tlo.a().a(getActivity(), new tlo.a());
    if (getArguments() == null) {
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater = getArguments().getString("params");
      try
      {
        paramViewGroup = new JSONObject(paramLayoutInflater);
        paramLayoutInflater = paramViewGroup.getJSONObject("requestParams");
        paramBundle = paramViewGroup.getJSONObject("clickParams");
        paramViewGroup = new JSONObject();
        paramViewGroup.put("options", paramBundle);
        this.jdField_b_of_type_TencentGdtQq_ad_get$QQAdGet = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGet(), paramLayoutInflater)));
        paramLayoutInflater = new GdtHandler.Options();
        GdtHandler.a(paramLayoutInflater, paramViewGroup.toString());
        this.jdField_b_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a = paramLayoutInflater;
        paramViewGroup = new Button(getActivity());
        paramViewGroup.setText("load");
        paramViewGroup.setOnClickListener(new tkh(this));
        paramBundle = new Button(getActivity());
        paramBundle.setText("show");
        paramBundle.setOnClickListener(new tki(this));
        Button localButton = new Button(getActivity());
        localButton.setText("show - close after 5s");
        localButton.setOnClickListener(new tkj(this));
        paramLayoutInflater = new LinearLayout(getActivity());
        paramLayoutInflater.setBackgroundColor(Color.parseColor("#DBDBDB"));
        paramLayoutInflater.setOrientation(1);
        paramLayoutInflater.addView(paramViewGroup);
        paramLayoutInflater.addView(paramBundle);
        paramLayoutInflater.addView(localButton);
      }
      catch (JSONException paramLayoutInflater)
      {
        for (;;)
        {
          tkw.e("GdtInterstitialFragmentForJS", "createParams error", paramLayoutInflater);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS
 * JD-Core Version:    0.7.0.1
 */