package com.tencent.biz.pubaccount.readinjoy.viola;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import ntp;
import ntv;
import ntw;
import ntx;
import nty;
import ntz;
import nui;
import nuk;
import nuk.a;
import org.json.JSONException;
import org.json.JSONObject;
import rvx;

public class ViolaFragment
  extends ViolaLazyFragment
{
  public static String anG = "pageConfigParams";
  private a a;
  public nui a;
  public nuk a;
  private boolean auL;
  
  public ViolaFragment()
  {
    this.jdField_a_of_type_Nui = new nui(this);
    this.jdField_a_of_type_Nuk = new nuk(this);
  }
  
  private static ViolaFragment a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new ViolaFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  public static ViolaFragment a(String paramString1, String paramString2, ReadInJoyChannelActivity.SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    paramString2 = new Bundle();
    paramString2.putString("url", paramString1);
    paramString2.putSerializable(anG, paramSerializableMap);
    if (paramBoolean) {
      paramString2.putInt(nuk.anP, 1);
    }
    return a(paramString2);
  }
  
  private void aL(Bundle paramBundle)
  {
    this.jdField_a_of_type_Nui.aL(paramBundle);
  }
  
  private void b(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.jdField_a_of_type_Nuk.w(paramViewGroup);
        this.jdField_a_of_type_Nuk.z(paramViewGroup);
        this.jdField_a_of_type_Nuk.a(paramViewGroup, new ntv(this));
        this.jdField_a_of_type_Nui.a(j(), paramBundle, this.jdField_a_of_type_Nuk.Gh(), new ntw(this));
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle = localJSONObject;
        continue;
      }
      paramBundle = localJSONObject;
    }
  }
  
  private void bbt() {}
  
  private void v(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Nuk.y(paramViewGroup);
  }
  
  public boolean Gh()
  {
    return this.jdField_a_of_type_Nuk.Gh();
  }
  
  public void L(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nuk.L(paramBoolean);
  }
  
  public CommonSuspensionGestureLayout a()
  {
    return this.jdField_a_of_type_Nui.a();
  }
  
  public nuk.a a()
  {
    return this.jdField_a_of_type_Nuk.a();
  }
  
  public void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    aL(paramBundle);
    v(paramViewGroup);
    b(paramBundle, paramViewGroup);
    w(paramViewGroup);
    bbt();
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment$a = parama;
  }
  
  public void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Nuk.b(paramHashMap, paramViewGroup);
  }
  
  public void aF(Bundle paramBundle)
  {
    this.jdField_a_of_type_Nuk.aM(paramBundle);
  }
  
  public void bbu()
  {
    FrameLayout localFrameLayout;
    if ((o() != null) && (!TextUtils.isEmpty(getUrl())) && ("1".equals(ntp.Y(getUrl(), "support_night"))))
    {
      boolean bool = ThemeUtil.isInNightMode(getActivity().app);
      localFrameLayout = new FrameLayout(j().getContext());
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localFrameLayout.setBackgroundColor(Color.parseColor("#77000000"));
      o().addView(localFrameLayout, localLayoutParams);
      if (!bool) {
        break label109;
      }
      if (localFrameLayout != null)
      {
        localFrameLayout.setVisibility(0);
        an("#ff888888", true);
      }
    }
    label109:
    while (localFrameLayout == null) {
      return;
    }
    localFrameLayout.setVisibility(8);
  }
  
  public void doOnBackPressed()
  {
    this.jdField_a_of_type_Nui.doOnBackPressed();
    if (this.jdField_a_of_type_Nuk.Gh()) {
      this.jdField_a_of_type_Nui.b(j(), true);
    }
    while (getActivity() == null) {
      return;
    }
    getActivity().doOnBackPressed();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      boolean bool = this.jdField_a_of_type_Nui.Gi();
      if (this.jdField_a_of_type_Nuk.Gh())
      {
        this.jdField_a_of_type_Nui.b(j(), true);
        return true;
      }
      return bool;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public String getUrl()
  {
    return this.jdField_a_of_type_Nui.kN();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Nui.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (getActivity() == null) {
        break label41;
      }
      getActivity().finishAndRemoveTask();
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_Nui.onDestroy();
        label33:
        rvx.cJ(getActivity());
        return;
        label41:
        BaseActivity.sTopActivity.finishAndRemoveTask();
      }
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((!this.jdField_a_of_type_Nuk.Gh()) && (getActivity() != null)) {
      getActivity().overridePendingTransition(0, 2130772028);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Nui.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Nui.onResume();
    super.onResume();
  }
  
  public int pw()
  {
    return 2131558520;
  }
  
  public void reloadPage()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.jdField_a_of_type_Nuk.bby();
    this.jdField_a_of_type_Nui.a(new ntz(this));
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nui.setCanCloseFromBottom(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_a_of_type_Nui.setUserVisibleHint(paramBoolean);
  }
  
  public HashMap v()
  {
    return this.jdField_a_of_type_Nuk.w();
  }
  
  public void w(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Nuk.Gh())
    {
      this.jdField_a_of_type_Nui.w(paramViewGroup);
      this.jdField_a_of_type_Nui.a(new ntx(this));
      this.jdField_a_of_type_Nuk.a(new nty(this, paramViewGroup));
    }
  }
  
  public static abstract interface a
  {
    public abstract void mT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment
 * JD-Core Version:    0.7.0.1
 */