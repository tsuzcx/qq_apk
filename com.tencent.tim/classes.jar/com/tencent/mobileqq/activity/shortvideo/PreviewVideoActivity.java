package com.tencent.mobileqq.activity.shortvideo;

import aazd;
import aazd.a;
import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import anhm;
import ankt;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PreviewVideoActivity
  extends PeakActivity
  implements View.OnClickListener, ImageViewVideoPlayer.b
{
  private int Ob;
  private HWVideoPlayView jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  private String ya;
  
  public void Nn()
  {
    if (!TextUtils.isEmpty(this.ya))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(0, 0, this.Ob, this.ya);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
    }
  }
  
  public void No() {}
  
  public void Np() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      overridePendingTransition(2130772009, 2130772013);
      continue;
      setResult(-1);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    setContentView(2131562691);
    try
    {
      if (VideoEnvironment.d("AVCodec", getApplicationContext()) != 0)
      {
        QLog.e("PreviewVideoActivity", 4, "load so failed");
        finish();
      }
      anhm.ahH();
      if (getIntent() == null)
      {
        Toast.makeText(getApplicationContext(), acfp.m(2131709882), 1).show();
        finish();
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("PreviewVideoActivity", 4, "load so failed");
        finish();
      }
      Object localObject1;
      Object localObject2;
      if (getIntent().getBooleanExtra("from_qzone_camera", false))
      {
        localObject1 = getIntent().getStringExtra("video_path");
        localObject2 = getIntent().getStringExtra("audio_path");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          Toast.makeText(getApplicationContext(), acfp.m(2131709881), 1).show();
          QLog.e("PreviewVideoActivity", 4, "videoPath is null");
          finish();
          return;
        }
        paramBundle = new aazd.a();
        paramBundle.videoPath = ((String)localObject1);
        paramBundle.audioPath = ((String)localObject2);
        findViewById(2131377410).setVisibility(0);
        findViewById(2131363971).setOnClickListener(this);
        findViewById(2131363985).setOnClickListener(this);
      }
      FrameLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        localObject1 = (FrameLayout)findViewById(2131381934);
        localObject2 = getResources().getDisplayMetrics();
        localLayoutParams = new FrameLayout.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels, 17);
        if (paramBundle == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView = new HWVideoPlayView(this);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.setFilePath(paramBundle.videoPath, paramBundle.audioPath);
        ((FrameLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.startPlay();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.setRepeat(true);
        return;
        int i = getIntent().getIntExtra("video_type", -1);
        if ((i != 0) && (i != 1))
        {
          Toast.makeText(getApplicationContext(), acfp.m(2131709880), 1).show();
          QLog.e("PreviewVideoActivity", 4, "init error, mVideoType=" + i);
          finish();
          return;
        }
        this.ya = getIntent().getStringExtra("video_source_path");
        if (TextUtils.isEmpty(this.ya))
        {
          Toast.makeText(getApplicationContext(), acfp.m(2131709883), 1).show();
          QLog.e("PreviewVideoActivity", 4, "init error, mSourcePath=" + this.ya);
          finish();
          return;
        }
        findViewById(2131379401).setVisibility(0);
        findViewById(2131365322).setOnClickListener(this);
        paramBundle = aazd.a(this.ya);
      }
      this.Ob = getIntent().getBundleExtra("encode_video_params").getInt("sv_total_frame_count");
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = new ImageViewVideoPlayer(getApplicationContext());
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels, false, ankt.dip2px(5.0F));
      ((FrameLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewVideoActivity", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
    }
    anhm.ahI();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.stopPlay();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) && (!TextUtils.isEmpty(this.ya)))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(0, 0, this.Ob, this.ya);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.onResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity
 * JD-Core Version:    0.7.0.1
 */