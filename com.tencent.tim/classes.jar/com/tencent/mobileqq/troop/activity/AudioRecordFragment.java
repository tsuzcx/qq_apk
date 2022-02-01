package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import aosa;
import aosb;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.theme.SkinnableBitmapDrawable;

public class AudioRecordFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public View HQ;
  public CommonRecordSoundPanel a;
  public AudioInfo a;
  public String cmL;
  public int dRD;
  protected RelativeLayout hK;
  protected Handler handler = new aosb(this);
  protected QQAppInterface mApp;
  public String mBid;
  public String mFrom;
  protected View mRootView;
  public RelativeLayout root;
  
  protected void a(Resources paramResources, View paramView)
  {
    paramResources = paramResources.getDrawable(2130851275);
    if ((paramResources instanceof BitmapDrawable)) {
      paramResources = ((BitmapDrawable)paramResources).getBitmap();
    }
    for (;;)
    {
      paramResources = new BitmapDrawable(paramResources);
      paramResources.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramResources.setDither(true);
      paramView.setBackgroundDrawable(paramResources);
      return;
      if ((paramResources instanceof SkinnableBitmapDrawable)) {
        paramResources = ((SkinnableBitmapDrawable)paramResources).getBitmap();
      } else {
        paramResources = null;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = this.a.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool);
    }
    this.a.onBackEvent();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      getActivity().setResult(0);
      getActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mRootView = paramLayoutInflater.inflate(2131560108, null);
    this.mApp = getActivity().app;
    this.root = ((RelativeLayout)this.mRootView.findViewById(2131377546));
    this.dRD = getArguments().getInt("audio_max_length", 60000);
    boolean bool = getArguments().getBoolean("auto_start", false);
    this.mFrom = getArguments().getString("from");
    if ((this.mFrom != null) && (this.mFrom.equals("publish")))
    {
      this.mBid = getArguments().getString("bid");
      this.cmL = getArguments().getString("fromflag");
    }
    this.hK = ((RelativeLayout)this.mRootView.findViewById(2131363083));
    a(getResources(), this.hK);
    this.a = ((CommonRecordSoundPanel)paramLayoutInflater.inflate(2131560053, null));
    this.hK.addView(this.a);
    this.a.a(this.mApp, getActivity(), this.handler, 1, bool);
    this.a.reset();
    this.a.setTimeOutTime(this.dRD);
    this.HQ = this.mRootView.findViewById(2131380133);
    this.HQ.setOnClickListener(this);
    paramLayoutInflater = AnimationUtils.loadAnimation(getActivity(), 2130771991);
    paramLayoutInflater.setAnimationListener(new aosa(this));
    this.root.startAnimation(paramLayoutInflater);
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    boolean bool = this.a.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    this.a.onDestroy();
  }
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    boolean bool = this.a.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    this.a.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AudioRecordFragment
 * JD-Core Version:    0.7.0.1
 */