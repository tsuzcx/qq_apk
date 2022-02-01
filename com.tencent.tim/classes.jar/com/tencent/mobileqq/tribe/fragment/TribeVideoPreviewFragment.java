package com.tencent.mobileqq.tribe.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import aorc;
import aord;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.os.MqqHandler;

public class TribeVideoPreviewFragment
  extends PublicBaseFragment
{
  private TextureVideoView b;
  
  private void Rf(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new TribeVideoPreviewFragment.3(this, paramBoolean));
  }
  
  public void Se(String paramString)
  {
    ThreadManager.post(new TribeVideoPreviewFragment.4(this, paramString), 5, null, true);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563228, paramViewGroup, false);
    this.b = ((TextureVideoView)paramLayoutInflater.findViewById(2131380184));
    paramViewGroup = paramLayoutInflater.findViewById(2131380185);
    paramBundle = (ImageButton)paramLayoutInflater.findViewById(2131377625);
    String str = getActivity().getIntent().getStringExtra("path");
    this.b.setVideoPath(str);
    this.b.setLooping(true);
    this.b.setCenterInside(true);
    paramLayoutInflater.setOnTouchListener(new aorc(this));
    this.b.start();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(3000L);
    paramViewGroup.startAnimation(localAlphaAnimation);
    paramBundle.setOnClickListener(new aord(this, str));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.stopPlayback();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(0, 2130772400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */