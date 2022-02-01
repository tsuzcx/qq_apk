package com.tencent.mobileqq.emotionintegrate;

import acfp;
import afrb;
import afrc;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.app.AppRuntime;

public abstract class AIOEmotionBaseFragment
  extends PublicBaseFragment
{
  protected int cTw;
  public Context mContext;
  protected View mRootView;
  
  public boolean ajM()
  {
    return true;
  }
  
  protected abstract void c(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem);
  
  public abstract void dbC();
  
  public abstract View f(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  protected abstract void gw(View paramView);
  
  protected void initTitleBar(View paramView)
  {
    paramView.setFitsSystemWindows(true);
    TextView localTextView = (TextView)paramView.findViewById(2131369579);
    localTextView.setText(acfp.m(2131702186));
    localTextView.setOnClickListener(new afrb(this));
    if (ajM())
    {
      paramView = (ImageView)paramView.findViewById(2131369594);
      paramView.setImageResource(2130838126);
      paramView.setVisibility(0);
      paramView.setContentDescription(acfp.m(2131702185));
      paramView.setOnClickListener(new afrc(this));
    }
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    report("0X800997D");
    paramLayoutInflater = f(paramLayoutInflater, paramViewGroup);
    this.mRootView = paramLayoutInflater;
    this.mContext = getActivity();
    initTitleBar(paramLayoutInflater);
    gw(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
  
  public void report(String paramString)
  {
    anot.a(null, "dc00898", "", "", paramString, paramString, this.cTw, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */