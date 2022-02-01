package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import kcr;
import kcs;
import mry.a;
import muj;
import mvi;

public class VideoFeedsLazyLoadDelegate
  extends VideoFeedsLoadDelegate
  implements View.OnClickListener
{
  protected LoadingFragment a;
  protected kcr a;
  protected FrameLayout al;
  protected boolean aoG;
  protected kcs b;
  protected VideoInfo e;
  protected ImageView kc;
  protected TextView sl;
  
  public VideoFeedsLazyLoadDelegate(mry.a parama, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    super(parama, paramBundle, paramQQAppInterface, paramFragmentActivity, paramString1, paramString2, paramBoolean, paramInt);
  }
  
  private boolean i(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.Wz));
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560511, paramViewGroup, false);
    this.al = ((FrameLayout)paramLayoutInflater.findViewById(2131381670));
    this.kc = ((ImageView)paramLayoutInflater.findViewById(2131381677));
    this.sl = ((TextView)paramLayoutInflater.findViewById(2131381692));
    paramLayoutInflater.findViewById(2131381668).setOnClickListener(this);
    aSz();
    sB(0);
    return paramLayoutInflater;
  }
  
  protected ViewGroup a(int paramInt, Fragment paramFragment)
  {
    if (paramFragment != null) {}
    for (;;)
    {
      return super.a(paramInt, paramFragment);
      paramFragment = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLazyLoadDelegate$LoadingFragment;
    }
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLazyLoadDelegate$LoadingFragment = LoadingFragment.a(this);
    this.jdField_a_of_type_Kcr = ((kcr)this.mApp.getBusinessHandler(90));
    this.b = new mvi(this);
    this.mActivity.addObserver(this.b);
    ie();
    return null;
  }
  
  public void a(VideoInfo paramVideoInfo, Bundle paramBundle)
  {
    muj.c(this.mActivity);
    this.mBundle.putString("VIDEO_ARTICLE_ID", paramVideoInfo.Wz);
    this.mBundle.putAll(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = VideoFeedsRecommendFragment.a(this.mBundle, paramVideoInfo, this.aks, this.akt, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.sH(1);
    if (this.jdField_a_of_type_Mry$a != null) {
      this.jdField_a_of_type_Mry$a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
    }
    this.mActivity.getSupportFragmentManager().beginTransaction().replace(this.mContainerId, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).commitAllowingStateLoss();
    aSy();
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int k = this.mBundle.getInt("item_x", 0);
    int n = this.mBundle.getInt("item_y", 0);
    int i1 = this.mBundle.getInt("item_width", 0);
    int i = this.mBundle.getInt("item_height", 0);
    int[] arrayOfInt = muj.c(this.mActivity);
    int j = arrayOfInt[0];
    int m = arrayOfInt[1];
    if ((i1 == 0) || (i == 0))
    {
      i = (int)(m * 0.4D);
      k = (j - (int)(j * 0.4D)) / 2;
    }
    for (j = (m - i) / 2;; j = arrayOfInt[1])
    {
      float f = i * 1.0F / m;
      this.mActivity.overridePendingTransition(0, 0);
      paramDragFrameLayout.setSizeAndPosition(f, k, j);
      paramDragFrameLayout.post(new VideoFeedsLazyLoadDelegate.2(this, paramDragFrameLayout));
      return;
      arrayOfInt = muj.a(this.mActivity, k, n);
      k = arrayOfInt[0];
    }
  }
  
  protected void aSA()
  {
    if (this.aoG)
    {
      ie();
      this.aoG = false;
      this.kc.setImageResource(2130843901);
      this.sl.setText("");
    }
  }
  
  protected void aSy()
  {
    this.mActivity.removeObserver(this.b);
    this.b = null;
    this.jdField_a_of_type_Kcr = null;
    this.al = null;
    this.kc = null;
    this.sl = null;
  }
  
  protected void aSz()
  {
    this.al.setBackgroundColor(-16777216);
  }
  
  protected VideoInfo c()
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.Wz = this.mBundle.getString("VIDEO_ARTICLE_ID", null);
    return localVideoInfo;
  }
  
  public void g(VideoInfo paramVideoInfo)
  {
    aSy();
    super.g(paramVideoInfo);
  }
  
  protected void ie()
  {
    int i = this.mBundle.getInt("VIDEO_FROM_TYPE", -1);
    String str1 = this.mBundle.getString("VIDEO_SECOND_INDEX_INNER_ID");
    long l3 = this.mBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    String str2 = this.mBundle.getString("VIDEO_COMMON_DATA");
    String str3 = this.mBundle.getString("VALUE_COOKIE");
    long l2 = this.mBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = Long.parseLong(this.mApp.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Kcr.a(this.b, l1, c(), i, null, str1, l3, true, 0, str2, str3, null, 0, null, null, 0, null);
  }
  
  public void o(boolean paramBoolean, Bundle paramBundle)
  {
    VideoFeedsPlayActivity.nX("懒加载数据get isSuccess" + paramBoolean);
    if (!paramBoolean)
    {
      this.aoG = true;
      sB(1);
      return;
    }
    if (!p(paramBundle))
    {
      sB(2);
      return;
    }
    a(this.e, paramBundle);
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
      aSA();
    }
  }
  
  protected boolean p(Bundle paramBundle)
  {
    VideoInfo localVideoInfo2 = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    VideoInfo localVideoInfo1 = localVideoInfo2;
    if (!i(localVideoInfo2))
    {
      localVideoInfo1 = localVideoInfo2;
      if (localArrayList != null)
      {
        localVideoInfo1 = localVideoInfo2;
        if (localArrayList.size() > 0) {
          localVideoInfo1 = (VideoInfo)localArrayList.remove(0);
        }
      }
    }
    if (!i(localVideoInfo1)) {
      return false;
    }
    this.e = localVideoInfo1;
    paramBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", localArrayList);
    paramBundle.remove("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    muj.x(this.e);
    return true;
  }
  
  protected void sB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 2130843979;
    }
    for (;;)
    {
      this.sl.setText("");
      this.kc.setImageResource(paramInt);
      return;
      paramInt = 2130843901;
      continue;
      paramInt = 2130843939;
    }
  }
  
  public static class LoadingFragment
    extends ReportV4Fragment
  {
    private VideoFeedsLazyLoadDelegate a;
    
    public static LoadingFragment a(VideoFeedsLazyLoadDelegate paramVideoFeedsLazyLoadDelegate)
    {
      LoadingFragment localLoadingFragment = new LoadingFragment();
      localLoadingFragment.a = paramVideoFeedsLazyLoadDelegate;
      return localLoadingFragment;
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      paramLayoutInflater = this.a.a(paramLayoutInflater, paramViewGroup, paramBundle);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLazyLoadDelegate
 * JD-Core Version:    0.7.0.1
 */