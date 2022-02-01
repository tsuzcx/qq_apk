package com.tencent.biz.pubaccount.readinjoy.pts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.Builder;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kgi;
import kgi.b;
import kxm;
import lus;
import lut;
import luu;
import luv;
import lwc;
import lwc.a;

public class PTSFragment
  extends PublicBaseFragment
{
  kgi.b a = new luu(this);
  private Activity activity;
  private String afO;
  private String afP;
  private String frameTreeJson;
  private String pageJs;
  private String pageName;
  private PTSAppInstance ptsAppInstance;
  
  private void aKY()
  {
    Intent localIntent = this.activity.getIntent();
    if (localIntent != null)
    {
      this.pageName = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName");
      this.frameTreeJson = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.FrameTreeJson");
      this.pageJs = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageJs");
      this.afO = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.BindDataJs");
      this.afP = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.AnimationJs");
    }
    QLog.i("PTSFragment", 1, "[initArguments], pageName = " + this.pageName);
  }
  
  private void aNz()
  {
    lwc.f("0X800A7C7", "", "", "", new lwc.a().a("page_name", this.pageName).build());
  }
  
  private void cD(View paramView)
  {
    kgi.a().a(9999, this.a);
    this.ptsAppInstance.addOnRecyclerViewScrollListener(new luv(this));
  }
  
  private void o(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    while (!TextUtils.equals(this.pageName, "daily_feeds")) {
      return;
    }
    paramViewGroup = View.inflate(this.activity, 2131560346, paramViewGroup);
    View localView1 = paramViewGroup.findViewById(2131370961);
    View localView2 = paramViewGroup.findViewById(2131370969);
    ((TextView)paramViewGroup.findViewById(2131380987)).setVisibility(8);
    localView1.setOnClickListener(new lus(this));
    localView2.setOnClickListener(new lut(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.activity = getActivity();
    aKY();
    paramViewGroup = paramLayoutInflater.inflate(2131560448, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (ViewGroup)paramViewGroup.findViewById(2131365382);
    o((ViewGroup)paramViewGroup.findViewById(2131379796));
    paramBundle = PTSJSBridgeManager.getInstance().getJSBridge(this.activity, this.afO, this.afP);
    this.ptsAppInstance = new PTSAppInstance.Builder().withContext(this.activity).withRootView(paramLayoutInflater).withRootNodeType(0).withPTSJSBridge(paramBundle).withPageName(this.pageName).withFrameTreeJson(this.frameTreeJson).withPageJs(this.pageJs).build();
    this.ptsAppInstance.onCreate();
    cD(paramViewGroup);
    aNz();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    QLog.i("PTSFragment", 1, "[onDestroy]");
    super.onDestroy();
    PTSThreadUtil.runOnSubThread(new PTSFragment.1(this, this.activity));
    kgi.a().b(9999, this.a);
  }
  
  public void onFinish()
  {
    QLog.i("PTSFragment", 2, "[onFinish]");
    super.onFinish();
    PTSThreadUtil.runOnSubThread(new PTSFragment.2(this));
  }
  
  public void onPause()
  {
    super.onPause();
    this.ptsAppInstance.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    kxm.a(this.activity, true, kxm.a(this.activity));
    this.ptsAppInstance.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment
 * JD-Core Version:    0.7.0.1
 */