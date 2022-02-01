package com.tencent.mobileqq.nearby.profilecard;

import acfp;
import advm;
import advm.a;
import advr;
import ajrm;
import ajrw;
import akbz;
import akca;
import akcb;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqiw;
import ausj;
import auss;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.File;

public class NearbyAuthVideoPlayerFragment
  extends PublicBaseFragment
  implements View.OnClickListener, URLDrawableDownListener, VideoDrawable.OnPlayRepeatListener
{
  private TextView Vs;
  private advm a;
  public VideoDrawable a;
  private advm.a jdField_b_of_type_Advm$a = new akbz(this);
  private advr jdField_b_of_type_Advr;
  public ajrw b;
  private int bHh;
  private String bTb;
  private ImageView bU;
  private URLImageView bs;
  private URLImageView bt;
  private boolean cro;
  private LinearLayout ju;
  private int mMode;
  private View mRootView;
  private String mUin;
  private String mVideoPath;
  private String mVideoUrl;
  
  public NearbyAuthVideoPlayerFragment()
  {
    this.jdField_b_of_type_Ajrw = new akca(this);
  }
  
  private void Qq()
  {
    ausj localausj = (ausj)auss.b(getActivity(), null);
    localausj.addButton(acfp.m(2131708656), 1);
    localausj.addButton(2131692505, 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new akcb(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  private void initData()
  {
    this.mVideoPath = getActivity().getIntent().getStringExtra("file_send_path");
    this.mVideoUrl = getActivity().getIntent().getStringExtra("video_url");
    this.bTb = getActivity().getIntent().getStringExtra("video_thumb_url");
    this.mUin = getActivity().getIntent().getStringExtra("uin");
    this.mMode = getActivity().getIntent().getIntExtra("mode", 0);
    this.cro = getActivity().getIntent().getBooleanExtra("is_authentic", false);
  }
  
  private void initView()
  {
    ((ImageView)this.mRootView.findViewById(2131364687)).setOnClickListener(this);
    ImageView localImageView = (ImageView)this.mRootView.findViewById(2131371935);
    localImageView.setOnClickListener(this);
    if (this.mMode == 3)
    {
      localImageView.setVisibility(8);
      this.bU = ((ImageView)this.mRootView.findViewById(2131373378));
      this.Vs = ((TextView)this.mRootView.findViewById(2131373561));
      this.bs = ((URLImageView)this.mRootView.findViewById(2131381646));
      this.bt = ((URLImageView)this.mRootView.findViewById(2131381594));
      this.ju = ((LinearLayout)this.mRootView.findViewById(2131370805));
      this.bt.setURLDrawableDownListener(this);
      if ((this.mMode != 3) || (this.cro)) {
        break label212;
      }
      this.Vs.setVisibility(0);
      label159:
      if ((TextUtils.isEmpty(this.mVideoPath)) || (this.mMode != 2)) {
        break label224;
      }
      m(this.mVideoPath, false, false);
    }
    for (;;)
    {
      this.bU.setOnClickListener(this);
      this.Vs.setOnClickListener(this);
      return;
      localImageView.setVisibility(0);
      break;
      label212:
      this.Vs.setVisibility(8);
      break label159;
      label224:
      if ((!TextUtils.isEmpty(this.mVideoUrl)) && (!TextUtils.isEmpty(this.bTb))) {
        if (advm.lj(this.mVideoUrl))
        {
          m(this.mVideoUrl, false, false);
        }
        else if (aqiw.isWifiConnected(getActivity()))
        {
          m(this.bTb, true, true);
          Nj(this.mVideoUrl);
        }
        else
        {
          m(this.bTb, true, false);
        }
      }
    }
  }
  
  private void m(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    Object localObject = getResources().getDrawable(2130851773);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    if ((paramBoolean1) && (!TextUtils.isEmpty(this.bTb)))
    {
      paramString = URLDrawable.getDrawable(this.bTb);
      this.bs.setImageDrawable(paramString);
      if (paramBoolean2)
      {
        this.ju.setVisibility(0);
        this.bU.setVisibility(8);
        this.bs.setVisibility(0);
        this.bt.setVisibility(8);
      }
    }
    while (!ShortVideoUtils.awI()) {
      for (;;)
      {
        return;
        this.ju.setVisibility(8);
        this.bU.setVisibility(0);
      }
    }
    localObject = new VideoDrawable.VideoDrawableParams();
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayAudioFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = 18;
    localURLDrawableOptions.mExtraInfo = localObject;
    localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      paramString = URLDrawable.getDrawable((File)localObject, localURLDrawableOptions);
      this.bt.setImageDrawable(paramString);
      this.ju.setVisibility(8);
      this.bU.setVisibility(8);
      this.bs.setVisibility(8);
      this.bt.setVisibility(0);
      paramString = new StringBuilder().append("");
      if (this.mMode != 3) {
        break label311;
      }
    }
    for (;;)
    {
      ajrm.k("play_video", new String[] { i, this.mUin });
      return;
      paramString = URLDrawable.getDrawable(advm.h(paramString), localURLDrawableOptions);
      this.bt.setImageDrawable(paramString);
      break;
      label311:
      i = 1;
    }
  }
  
  protected void Nj(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getActivity().app != null))
    {
      if (aqiw.isNetSupport(getActivity())) {
        break label54;
      }
      QQToast.a(getActivity(), getString(2131696270), 0).show(getActivity().getTitleBarHeight());
    }
    label54:
    while ((isDetached()) || (getActivity() == null)) {
      return;
    }
    ThreadManager.post(new NearbyAuthVideoPlayerFragment.1(this, paramString), 5, null, true);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
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
    if ((paramInt1 == 11000) && (paramInt2 == -1))
    {
      if (this.mMode != 3) {
        break label39;
      }
      this.Vs.setVisibility(8);
    }
    for (;;)
    {
      getActivity().setResult(-1, paramIntent);
      return;
      label39:
      String str = paramIntent.getStringExtra("video_path");
      if (!TextUtils.isEmpty(str)) {
        m(str, false, false);
      }
    }
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
      getActivity().finish();
      continue;
      Qq();
      continue;
      if (advm.lj(this.mVideoUrl))
      {
        Drawable localDrawable = ((URLDrawable)this.bt.getDrawable()).getCurrDrawable();
        if ((localDrawable != null) && ((localDrawable instanceof VideoDrawable))) {
          ((VideoDrawable)localDrawable).resetAndPlayAudioCircle();
        } else {
          m(this.mVideoUrl, false, false);
        }
      }
      else
      {
        Nj(this.mVideoUrl);
        continue;
        if (!ajrm.a(getActivity(), getActivity().app)) {
          ajrm.b(getActivity(), getActivity().app, 3);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getActivity().getWindow().addFlags(128);
    this.mRootView = paramLayoutInflater.inflate(2131559682, paramViewGroup, false);
    this.jdField_b_of_type_Advr = ((advr)getActivity().app.getManager(180));
    this.jdField_a_of_type_Advm = this.jdField_b_of_type_Advr.a();
    if (this.jdField_a_of_type_Advm != null) {
      this.jdField_a_of_type_Advm.a(this.jdField_b_of_type_Advm$a);
    }
    ShortVideoUtils.B(getActivity().app);
    getActivity().app.addObserver(this.jdField_b_of_type_Ajrw);
    initData();
    initView();
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().app.removeObserver(this.jdField_b_of_type_Ajrw);
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    this.bU.setVisibility(0);
    QQToast.a(getActivity(), 1, acfp.m(2131708659), 0).show(getActivity().getTitleBarHeight());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.bU.setVisibility(0);
    QQToast.a(getActivity(), 1, acfp.m(2131708655), 0).show(getActivity().getTitleBarHeight());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    this.bU.setVisibility(0);
    QQToast.a(getActivity(), 1, acfp.m(2131708658), 0).show(getActivity().getTitleBarHeight());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAuthVideoPlayerFragment", 2, "URLDrawable load success, url=" + this.mVideoUrl);
    }
    paramView = paramURLDrawable.getCurrDrawable();
    if (VideoDrawable.class.isInstance(paramView))
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable = ((VideoDrawable)paramView);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(this);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    NativeVideoImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.stopAudio();
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    int i = 2;
    StringBuilder localStringBuilder;
    if (paramInt > this.bHh)
    {
      localStringBuilder = new StringBuilder().append("");
      if (this.mMode != 3) {
        break label66;
      }
    }
    for (;;)
    {
      ajrm.k("play_video", new String[] { i, this.mUin });
      this.bHh = paramInt;
      return;
      label66:
      i = 1;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment
 * JD-Core Version:    0.7.0.1
 */