package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import jxc;
import jxd;
import jxe;
import jxf;
import jxg;
import jxh;
import jxi;
import wja;

public class VideoCoverFragment
  extends ReportV4Fragment
  implements View.OnClickListener
{
  public static boolean acG;
  public static boolean acH = true;
  public static boolean isSelected;
  private VideoCoverAdapter jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter;
  private AdControlView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private jxc jdField_a_of_type_Jxc;
  private int aDO;
  private int aEe;
  private int aEf = 1;
  private int aEg = 2;
  public int aEh;
  private boolean acI;
  private boolean acJ;
  private boolean acK;
  private boolean acq = true;
  public boolean acz = true;
  private AudioManager audioManager;
  private ViewPager.OnPageChangeListener c;
  private Runnable cr = new VideoCoverFragment.4(this);
  private ViewPager d;
  private URLImageView f;
  private View iY;
  private View iZ;
  private View ja;
  private View jb;
  private View jc;
  private View jd;
  private View je;
  private Context mContext;
  private Handler mHandler;
  private boolean mIsVisible = true;
  private TextView nK;
  private TextView nL;
  private TextView nM;
  private View.OnClickListener x;
  protected AnimatorSet y;
  
  @TargetApi(11)
  private void aAO()
  {
    this.jb.setAlpha(0.0F);
    this.jb.setVisibility(0);
    this.jc.setAlpha(0.0F);
    this.jc.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jc, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jb, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    localObjectAnimator1.setDuration(1800L);
    localObjectAnimator1.setRepeatCount(-1);
    localObjectAnimator1.setRepeatMode(1);
    localObjectAnimator1.setStartDelay(100L);
    localObjectAnimator2.setDuration(1800L);
    localObjectAnimator2.setRepeatCount(-1);
    localObjectAnimator2.setRepeatMode(1);
    localObjectAnimator2.setStartDelay(240L);
    this.y = new AnimatorSet();
    this.y.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
  }
  
  private void aAP()
  {
    if (this.audioManager == null) {}
    for (;;)
    {
      return;
      this.aEh = this.audioManager.getStreamVolume(3);
      if (this.jdField_a_of_type_Jxc.a.aDV == this.aEe)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverFragment", 2, "isVideoMute true");
        }
        acH = true;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ab().setBackgroundResource(2130842439);
      }
      while (yL())
      {
        acH = true;
        return;
        acH = false;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ab().setBackgroundResource(2130842440);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverFragment", 2, ",music system is " + this.aEh);
        }
        if (this.jdField_a_of_type_Jxc.a.aDV == this.aEg) {
          aAT();
        }
      }
    }
  }
  
  private void aAQ()
  {
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a();
    if (localBaseVideoView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "media play is null");
      }
    }
    do
    {
      return;
      if (!yL()) {
        break;
      }
    } while (this.audioManager == null);
    int i = this.audioManager.getStreamMaxVolume(3);
    this.audioManager.setStreamVolume(3, (int)(i * 0.2D), 1);
    localBaseVideoView.setMute(false);
    acH = false;
    this.acK = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ab().setBackgroundResource(2130842440);
    return;
    if (localBaseVideoView.isMute())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setMute(false);
      acH = false;
      this.acK = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ab().setBackgroundResource(2130842440);
      anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F62", "0X8008F62", 0, 0, this.jdField_a_of_type_Jxc.a.hT, "", ((jxd)this.jdField_a_of_type_Jxc.jw.get(this.aDO)).UC, this.jdField_a_of_type_Jxc.a.mNickName);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a() != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setMute(true);
    }
    acH = true;
    this.acK = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ab().setBackgroundResource(2130842439);
    anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F63", "0X8008F63", 0, 0, this.jdField_a_of_type_Jxc.a.hT, "", ((jxd)this.jdField_a_of_type_Jxc.jw.get(this.aDO)).UC, this.jdField_a_of_type_Jxc.a.mNickName);
  }
  
  private void aAS()
  {
    jxe localjxe = this.jdField_a_of_type_Jxc.a;
    if (yJ())
    {
      lE(true);
      if (!TextUtils.isEmpty(localjxe.UG))
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        Object localObject2 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(localjxe.UG, (URLDrawable.URLDrawableOptions)localObject1);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
        {
          localObject2 = this.f.getLayoutParams();
          int i = ((URLDrawable)localObject1).getIntrinsicWidth();
          int j = ((URLDrawable)localObject1).getIntrinsicHeight();
          ((ViewGroup.LayoutParams)localObject2).width = (i * wja.dp2px(23.0F, this.mContext.getResources()) / j);
          this.f.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.f.setURLDrawableDownListener(new jxi(this));
        this.f.setImageDrawable((Drawable)localObject1);
      }
      this.nL.setText(localjxe.bannerText);
      if (localjxe.aDW == 1)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setVisibility(0);
        this.je.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(localjxe.UH);
        this.acI = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "canShowBanner scrollUpToJump = " + localjxe.acF);
      }
      if (((this.jdField_a_of_type_Jxc.a.jumpType != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_Jxc.a.UI))) && ((this.jdField_a_of_type_Jxc.a.jumpType < 2) || (TextUtils.isEmpty(this.jdField_a_of_type_Jxc.a.jumpUrl)) || (!this.jdField_a_of_type_Jxc.a.acF) || (!this.acz))) {
        break;
      }
      lD(true);
      return;
      if (localjxe.aDW == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setVisibility(8);
        this.je.setVisibility(0);
        this.nM.setText(localjxe.UH);
        this.acI = false;
        continue;
        lE(false);
      }
    }
    lD(false);
  }
  
  private void aAT()
  {
    int i = 1;
    if (this.audioManager == null) {}
    int k;
    int m;
    do
    {
      return;
      k = this.audioManager.getStreamVolume(3);
      m = this.jdField_a_of_type_Jxc.a.aDU;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "audioFadeinDuration is " + m + ", maxMusicVolume is " + k);
      }
    } while (k == 0);
    int j = (int)(k * 0.2D);
    if (j < 1) {}
    for (;;)
    {
      this.audioManager.setStreamVolume(3, i, 0);
      i = (int)(m * 1000.0F / k);
      this.mHandler.postDelayed(new VideoCoverFragment.6(this, k, i), i);
      return;
      i = j;
    }
  }
  
  private void lD(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ja.setVisibility(0);
      if ((this.jdField_a_of_type_Jxc.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Jxc.a.UJ)))
      {
        this.nK.setVisibility(0);
        this.nK.setText(this.jdField_a_of_type_Jxc.a.UJ);
      }
      LinearLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.ja.getLayoutParams();
        if (!this.acJ) {
          break;
        }
        localLayoutParams.setMargins(0, 0, 0, wja.dp2px(18.0F, this.mContext.getResources()));
        return;
        this.nK.setVisibility(8);
      }
      localLayoutParams.setMargins(0, 0, 0, wja.dp2px(30.0F, this.mContext.getResources()));
      return;
    }
    this.ja.setVisibility(8);
    this.nK.setVisibility(8);
  }
  
  private void lE(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.acJ = true;
      this.jd.setVisibility(0);
      return;
    }
    this.acJ = false;
    this.jd.setVisibility(8);
  }
  
  private boolean yH()
  {
    return (this.iZ.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.getVisibility() == 0);
  }
  
  private boolean yJ()
  {
    boolean bool3 = false;
    jxe localjxe = this.jdField_a_of_type_Jxc.a;
    if ((localjxe == null) || (!this.acz)) {}
    StringBuilder localStringBuilder;
    label67:
    label94:
    label121:
    do
    {
      do
      {
        return false;
      } while (!localjxe.acD);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("canShowBanner bannerImgUrl == null ");
        if (TextUtils.isEmpty(localjxe.UG)) {
          break;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，bannerButtonText == null");
        if (TextUtils.isEmpty(localjxe.UH)) {
          break label433;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，bannerText == null");
        if (TextUtils.isEmpty(localjxe.bannerText)) {
          break label438;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，mNickName == null");
        if (TextUtils.isEmpty(localjxe.mNickName)) {
          break label443;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，mTrueUin == null");
        if (TextUtils.isEmpty(localjxe.UD)) {
          break label448;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，adId == null");
        if (TextUtils.isEmpty(localjxe.hT)) {
          break label453;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，adPosId == null");
        if (TextUtils.isEmpty(localjxe.UE)) {
          break label458;
        }
        bool1 = true;
        QLog.d("VideoCoverFragment", 2, bool1);
      }
    } while ((TextUtils.isEmpty(localjxe.UG)) || (TextUtils.isEmpty(localjxe.UH)) || (TextUtils.isEmpty(localjxe.bannerText)) || (TextUtils.isEmpty(localjxe.mNickName)) || (TextUtils.isEmpty(localjxe.UD)) || (TextUtils.isEmpty(localjxe.hT)) || (TextUtils.isEmpty(localjxe.UE)));
    label148:
    label175:
    label202:
    label229:
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverFragment", 2, "canShowBanner jumpType = " + localjxe.jumpType);
    }
    if (localjxe.jumpType == 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("canShowBanner jumpUrl = null ");
        if (TextUtils.isEmpty(localjxe.jumpUrl)) {
          break label463;
        }
      }
      label433:
      label438:
      label443:
      label448:
      label453:
      label458:
      label463:
      for (bool1 = true;; bool1 = false)
      {
        QLog.d("VideoCoverFragment", 2, bool1);
        if (TextUtils.isEmpty(localjxe.jumpUrl)) {
          break;
        }
        return true;
        bool1 = false;
        break label67;
        bool1 = false;
        break label94;
        bool1 = false;
        break label121;
        bool1 = false;
        break label148;
        bool1 = false;
        break label175;
        bool1 = false;
        break label202;
        bool1 = false;
        break label229;
      }
    }
    if (localjxe.jumpType == 1) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("canShowBanner myappDownloadUrl = null ");
        if (!TextUtils.isEmpty(localjxe.UI))
        {
          bool1 = true;
          QLog.d("VideoCoverFragment", 2, bool1);
        }
      }
      else
      {
        if (TextUtils.isEmpty(localjxe.UI)) {
          break label741;
        }
      }
    }
    label573:
    label600:
    label732:
    label739:
    label741:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("canShowBanner appId = null ");
        if (TextUtils.isEmpty(localjxe.appId)) {
          break label722;
        }
        bool2 = true;
        localStringBuilder = localStringBuilder.append(bool2).append(" appName = null ");
        if (TextUtils.isEmpty(localjxe.appName)) {
          break label727;
        }
        bool2 = true;
        localStringBuilder = localStringBuilder.append(bool2).append(" packagename = null ");
        if (TextUtils.isEmpty(localjxe.packagename)) {
          break label732;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        localStringBuilder = localStringBuilder.append(bool2).append(" downloadUrl = null ");
        bool2 = bool3;
        if (!TextUtils.isEmpty(localjxe.downloadUrl)) {
          bool2 = true;
        }
        QLog.d("VideoCoverFragment", 2, bool2);
        if ((TextUtils.isEmpty(localjxe.appId)) || (TextUtils.isEmpty(localjxe.appName)) || (TextUtils.isEmpty(localjxe.packagename)) || (TextUtils.isEmpty(localjxe.downloadUrl))) {
          break label739;
        }
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label573;
        bool2 = false;
        break label600;
      }
      return true;
      return bool1;
    }
  }
  
  private boolean yK()
  {
    Intent localIntent = getActivity().getIntent();
    try
    {
      this.jdField_a_of_type_Jxc = jxc.a(localIntent.getStringExtra("arg_ad_json"));
      if ((this.jdField_a_of_type_Jxc == null) || (this.jdField_a_of_type_Jxc.jw == null) || (this.jdField_a_of_type_Jxc.jw.size() <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverFragment", 2, "refetchItemData failed");
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_Jxc = null;
      }
    }
    return true;
  }
  
  private boolean yL()
  {
    if (this.audioManager == null) {}
    while (this.audioManager.getStreamVolume(3) != 0) {
      return false;
    }
    return true;
  }
  
  public void K(boolean paramBoolean, int paramInt)
  {
    this.mHandler.removeCallbacks(this.cr);
    if (paramBoolean)
    {
      this.iZ.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(0);
      this.mHandler.postDelayed(this.cr, paramInt * 1000L);
      anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F67", "0X8008F67", 0, 0, this.jdField_a_of_type_Jxc.a.hT, "", "", this.jdField_a_of_type_Jxc.a.mNickName);
      return;
    }
    this.iZ.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(4);
  }
  
  public View Z()
  {
    return this.jd;
  }
  
  public void a(jxc paramjxc, ViewPager.OnPageChangeListener paramOnPageChangeListener, View.OnClickListener paramOnClickListener, AudioManager paramAudioManager, AdControlView paramAdControlView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Jxc = paramjxc;
    this.x = paramOnClickListener;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView = paramAdControlView;
    this.acz = paramBoolean;
    this.c = new jxf(this, paramOnPageChangeListener);
    this.audioManager = paramAudioManager;
  }
  
  public void aAR()
  {
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a();
    if (localBaseVideoView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "media play is null");
      }
    }
    while (!localBaseVideoView.isMute()) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setMute(false);
  }
  
  public void lB(boolean paramBoolean)
  {
    K(paramBoolean, 6);
  }
  
  public void lC(boolean paramBoolean)
  {
    this.mIsVisible = paramBoolean;
  }
  
  public void lF(boolean paramBoolean)
  {
    View localView = this.jd;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localView.setClickable(paramBoolean);
      return;
    }
  }
  
  public void mE(int paramInt)
  {
    QLog.d("VideoCoverFragment", 2, "updateDownloadProgress progress " + paramInt);
    if (this.acI) {
      if ((getActivity() == null) || (getActivity().isFinishing())) {
        QLog.e("VideoCoverFragment", 1, "updateDownloadProgress null error");
      }
    }
    do
    {
      do
      {
        return;
        if (((PublicAccountAdvertisementActivity)getActivity()).yz())
        {
          QLog.d("VideoCoverFragment", 2, "updateDownloadProgress appInstalled!");
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839545);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
          return;
        }
        if (((PublicAccountAdvertisementActivity)getActivity()).yA())
        {
          QLog.d("VideoCoverFragment", 2, "updateDownloadProgress pkgExist!");
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839545);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
          return;
        }
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_Jxc.a.UH);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839545);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
          return;
        }
        if (paramInt == 100)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839545);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839559);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(paramInt);
        return;
      } while ((((PublicAccountAdvertisementActivity)getActivity()).yz()) || (((PublicAccountAdvertisementActivity)getActivity()).yA()));
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_Jxc.a.UH);
        return;
      }
    } while (paramInt != 100);
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.acP)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.aBb();
        if (!yI()) {
          lB(true);
        }
      }
      aAQ();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mContext = getActivity();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559802, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    acG = false;
    isSelected = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.onDestroy();
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.y != null) {
      this.y.cancel();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.onPause();
    if (this.audioManager != null) {
      this.audioManager.abandonAudioFocus(null);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    if (this.y == null) {
      aAO();
    }
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.yN())
    {
      if ((yL()) || (this.jdField_a_of_type_Jxc.a.aDV == this.aEe)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.aBa();
      }
      if ((this.jdField_a_of_type_Jxc.a.aDV == this.aEg) && (this.aEh == 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.aBa();
      }
    }
    this.y.start();
    if (this.acq)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.onResume(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setProgress(0, 0);
      this.acq = false;
    }
    for (;;)
    {
      if (this.audioManager != null) {
        this.audioManager.requestAudioFocus(null, 3, 1);
      }
      super.onResume();
      return;
      if (this.mIsVisible) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.onResume(false);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Jxc == null) && (!yK())) {
      getActivity().finish();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView != null) {
        break;
      }
    } while (!(getActivity() instanceof PublicAccountAdvertisementActivity));
    ((PublicAccountAdvertisementActivity)getActivity()).aAB();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverFragment", 2, "onViewCreated:" + hashCode());
    }
    this.mHandler = new Handler();
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.d = ((ViewPager)localViewGroup.findViewById(2131381751));
    this.iZ = localViewGroup.findViewById(2131368958);
    if ((!yI()) && (this.jdField_a_of_type_Jxc != null) && (this.jdField_a_of_type_Jxc.a != null) && (this.jdField_a_of_type_Jxc.a.aEb > 0)) {
      K(true, this.jdField_a_of_type_Jxc.a.aEb);
    }
    this.iY = localViewGroup.findViewById(2131368959);
    this.iY.setOnTouchListener(new jxg(this));
    this.ja = localViewGroup.findViewById(2131381657);
    this.nK = ((TextView)localViewGroup.findViewById(2131381617));
    this.jb = localViewGroup.findViewById(2131381397);
    this.jc = localViewGroup.findViewById(2131381398);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter = new VideoCoverAdapter(this.mContext, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a(), this.jdField_a_of_type_Jxc, new jxh(this));
    this.d.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter);
    this.d.setOnPageChangeListener(this.c);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.aa().setOnClickListener(this.x);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ab().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setTotalCount(this.jdField_a_of_type_Jxc.jw.size());
    this.ja.setOnClickListener(this.x);
    this.jd = localViewGroup.findViewById(2131381650);
    this.jd.setOnClickListener(this.x);
    this.f = ((URLImageView)localViewGroup.findViewById(2131381652));
    this.nL = ((TextView)localViewGroup.findViewById(2131381651));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131381656));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(this.mContext.getResources().getColor(2131165409));
    this.je = localViewGroup.findViewById(2131381654);
    this.nM = ((TextView)localViewGroup.findViewById(2131381653));
    aAS();
    aAP();
    super.onViewCreated(paramView, paramBundle);
  }
  
  public boolean yI()
  {
    if (QLog.isColorLevel()) {
      if ("forceSetControllerPanelVisible " + this.jdField_a_of_type_Jxc.a == null) {
        break label103;
      }
    }
    label103:
    for (Object localObject = Integer.valueOf(this.jdField_a_of_type_Jxc.a.aEa);; localObject = "null")
    {
      QLog.d("VideoCoverFragment", 2, new Object[] { localObject });
      if (this.jdField_a_of_type_Jxc.a.aEa != 2) {
        break;
      }
      this.iZ.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.acQ = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(0);
      return true;
    }
    return false;
  }
  
  public boolean yM()
  {
    return this.acJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment
 * JD-Core Version:    0.7.0.1
 */