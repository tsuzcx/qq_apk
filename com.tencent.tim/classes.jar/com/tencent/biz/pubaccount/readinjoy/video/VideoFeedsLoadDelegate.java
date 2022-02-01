package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mry;
import mry.a;
import muj;
import mzr;

public class VideoFeedsLoadDelegate
  implements mry
{
  protected static ArrayList<VideoInfo> lr;
  protected VideoFeedsRecommendFragment a;
  protected mry.a a;
  protected String aks;
  protected String akt;
  protected boolean anU;
  protected String[] bB = new String[0];
  protected FragmentActivity mActivity;
  protected QQAppInterface mApp;
  protected Bundle mBundle;
  protected ViewGroup mContainer;
  protected int mContainerId = 2131365322;
  protected int mFromType;
  
  public VideoFeedsLoadDelegate(mry.a parama, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Mry$a = parama;
    this.mBundle = paramBundle;
    this.mApp = paramQQAppInterface;
    this.mActivity = paramFragmentActivity;
    this.aks = paramString1;
    this.akt = paramString2;
    this.anU = paramBoolean;
    this.mFromType = paramInt;
  }
  
  public static void a(PendingIntent paramPendingIntent)
  {
    lr = null;
  }
  
  private VideoInfo d()
  {
    Object localObject1 = new VideoInfo();
    if (this.mBundle.getParcelable("VIDEO_OBJ") != null)
    {
      localObject1 = (VideoInfo)this.mBundle.getParcelable("VIDEO_OBJ");
      muj.x((VideoInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLoadDelegate", 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + ((VideoInfo)localObject1).toLogString());
      }
      this.mBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject1).Wz);
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = (MessageForShortVideo)this.mBundle.getParcelable("key_message_for_shortvideo");
      if (localObject2 != null)
      {
        ((VideoInfo)localObject1).busiType = 0;
        ((VideoInfo)localObject1).a = ((MessageForShortVideo)localObject2);
        return localObject1;
      }
      localObject2 = muj.a(this.mBundle);
      muj.x((VideoInfo)localObject2);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsLoadDelegate", 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + ((VideoInfo)localObject2).toLogString());
    return localObject2;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = a();
    this.mContainer = a(this.mContainerId, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.addView(this.mContainer, 0, paramLayoutInflater);
    return this.mContainer;
  }
  
  protected ViewGroup a(int paramInt, Fragment paramFragment)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.mActivity);
    localFrameLayout.setId(paramInt);
    this.mActivity.getSupportFragmentManager().beginTransaction().replace(paramInt, paramFragment).commitAllowingStateLoss();
    return localFrameLayout;
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    Object localObject;
    if (this.mBundle.getBoolean("VIDEO_IS_CACHE_CACHE_INFO_LIST", false))
    {
      localObject = lr;
      lr = null;
    }
    for (;;)
    {
      int i;
      VideoInfo localVideoInfo;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        i = this.mBundle.getInt("VIDEO_FIRST_INFO_POSITION", 0);
        localVideoInfo = (VideoInfo)((ArrayList)localObject).remove(0);
        this.mBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", (ArrayList)localObject);
      }
      for (localObject = VideoFeedsRecommendFragment.a(this.mBundle, localVideoInfo, this.aks, this.akt, true, i);; localObject = VideoFeedsRecommendFragment.a(this.mBundle, d(), this.aks, this.akt))
      {
        if (this.jdField_a_of_type_Mry$a != null) {
          this.jdField_a_of_type_Mry$a.a((VideoFeedsRecommendFragment)localObject);
        }
        return localObject;
      }
      localObject = null;
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int k = this.mBundle.getInt("item_x", 0);
    int m = this.mBundle.getInt("item_y", 0);
    int i = this.mBundle.getInt("item_width", 0);
    int n = this.mBundle.getInt("item_height", 0);
    int j = muj.c(this.mActivity)[0];
    if (((k == 0) && (m == 0) && (i == 0)) || (i >= n))
    {
      this.mActivity.overridePendingTransition(2130772289, 0);
      return;
    }
    int[] arrayOfInt = muj.a(this.mActivity, k, m);
    k = arrayOfInt[0];
    m = arrayOfInt[1];
    this.mActivity.overridePendingTransition(0, 0);
    paramDragFrameLayout.setSizeAndPosition(i * 1.0F / j, k, m);
    paramDragFrameLayout.post(new VideoFeedsLoadDelegate.1(this, paramDragFrameLayout));
  }
  
  public void g(VideoInfo paramVideoInfo)
  {
    if (this.mBundle == null) {}
    while (this.mBundle.getInt("KEY_OLD_LOAD_DELEGATE_TYPE", -1) != 2) {
      return;
    }
    new mzr(null, this.mBundle, this.mApp, this.mActivity, this.aks, this.akt, this.anU, this.mFromType).N(paramVideoInfo);
  }
  
  public static class Adapter
    extends FragmentStatePagerAdapter
  {
    private String[] bC;
    private List<Fragment> jk;
    
    public int getCount()
    {
      if (this.jk != null) {
        return this.jk.size();
      }
      return 0;
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)this.jk.get(paramInt);
    }
    
    public int getItemPosition(Object paramObject)
    {
      if (this.jk.indexOf(paramObject) < 0) {
        return -2;
      }
      return -1;
    }
    
    public CharSequence getPageTitle(int paramInt)
    {
      if ((this.bC != null) && (paramInt < this.bC.length)) {
        return this.bC[paramInt];
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLoadDelegate
 * JD-Core Version:    0.7.0.1
 */