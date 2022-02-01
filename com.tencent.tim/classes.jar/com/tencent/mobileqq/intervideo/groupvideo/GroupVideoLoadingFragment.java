package com.tencent.mobileqq.intervideo.groupvideo;

import acfp;
import aicm;
import aicr;
import aics;
import aict;
import aicu;
import aidc;
import aids;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import aqiw;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GroupVideoLoadingFragment
  extends PublicBaseFragment
{
  public static boolean isRunning;
  private aicm jdField_a_of_type_Aicm;
  private aicu jdField_a_of_type_Aicu;
  private aidc jdField_a_of_type_Aidc = new aics(this);
  private IVPluginDataReporter b;
  private boolean cjQ;
  private Context mContext;
  private int mCurrentProgress;
  private int mCurrentState;
  private long mStartTime;
  private Handler mUIHandler = new aict(this, Looper.getMainLooper());
  
  private void KV(boolean paramBoolean)
  {
    this.mStartTime = System.currentTimeMillis();
    String str2 = getArguments().getString("roomCode");
    String str3 = getArguments().getString("uin");
    int i = getArguments().getInt("isGroupCode");
    String str4 = getArguments().getString("backType");
    String str1 = getArguments().getString("action");
    String str5 = getArguments().getString("fromId");
    String str6 = getArguments().getString("openType");
    String str7 = getArguments().getString("extra");
    this.cjQ = paramBoolean;
    if (paramBoolean) {
      str1 = "checkVersion";
    }
    this.mCurrentProgress = 0;
    this.jdField_a_of_type_Aicu.a(this.mContext, str2, str3, i, str1, str5, str4, str6, str7, this.jdField_a_of_type_Aidc);
  }
  
  private void checkNetwork()
  {
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      this.jdField_a_of_type_Aicm.gn(acfp.m(2131707089), "");
      this.jdField_a_of_type_Aicm.drZ();
      return;
    }
    this.jdField_a_of_type_Aicm.gn(acfp.m(2131707085), acfp.m(2131707081));
    aicu.a("group_video", new aicr(this));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    aids.report("2856633");
    this.b.opType("exitLoadPage").opIn(this.mCurrentState).opResult((int)(System.currentTimeMillis() - this.mStartTime)).report();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Aicu = ((aicu)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(236));
    isRunning = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559424, null);
    this.jdField_a_of_type_Aicm = new aicm();
    this.jdField_a_of_type_Aicm.c(getActivity(), paramLayoutInflater);
    this.mContext = getActivity();
    this.b = new IVPluginDataReporter();
    this.b.opDepartment("group_video");
    checkNetwork();
    aids.report("2856632");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    isRunning = false;
    this.jdField_a_of_type_Aicu.eu(getActivity());
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Aidc = null;
  }
  
  public class a
    implements View.OnClickListener
  {
    private a() {}
    
    public void onClick(View paramView)
    {
      GroupVideoLoadingFragment.a(GroupVideoLoadingFragment.this).gn(acfp.m(2131707086), acfp.m(2131707090));
      GroupVideoLoadingFragment.a(GroupVideoLoadingFragment.this).drZ();
      GroupVideoLoadingFragment.a(GroupVideoLoadingFragment.this, false);
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment
 * JD-Core Version:    0.7.0.1
 */