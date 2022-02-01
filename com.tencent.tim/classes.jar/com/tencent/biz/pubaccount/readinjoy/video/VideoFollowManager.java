package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import muj;
import naf;

public class VideoFollowManager
{
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private naf jdField_a_of_type_Naf;
  private List<VideoInfo> jG;
  private Activity mActivity;
  private QQAppInterface mApp;
  private Handler mHandler;
  
  public VideoFollowManager(Activity paramActivity, QQAppInterface paramQQAppInterface, naf paramnaf, VideoFeedsPlayManager paramVideoFeedsPlayManager, List<VideoInfo> paramList, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jG = paramList;
    this.jdField_a_of_type_Naf = paramnaf;
    this.mHandler = new Handler();
  }
  
  private boolean a(VideoInfo paramVideoInfo, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramVideoInfo.hH != null)
    {
      bool1 = bool3;
      if (paramVideoInfo.hH.equals(paramString))
      {
        bool1 = bool2;
        if (!paramVideoInfo.isFollowed) {
          bool1 = true;
        }
        paramVideoInfo.isFollowed = true;
      }
    }
    return bool1;
  }
  
  private void ai(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFollowHelper", 2, "followPubAccount() uin=" + paramString);
    }
    if ((paramString == null) || (this.mApp == null)) {}
    do
    {
      return;
      muj.a(this.mApp, paramString, paramBoolean);
      Iterator localIterator = this.jG.iterator();
      paramBoolean = false;
      while (localIterator.hasNext())
      {
        Object localObject = (VideoInfo)localIterator.next();
        boolean bool = paramBoolean | a((VideoInfo)localObject, paramString);
        paramBoolean = bool;
        if (((VideoInfo)localObject).jT != null)
        {
          localObject = ((VideoInfo)localObject).jT.iterator();
          for (;;)
          {
            paramBoolean = bool;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            bool = a((VideoInfo)((Iterator)localObject).next(), paramString) | bool;
          }
        }
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Naf.nS(paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoFollowHelper", 2, "followPubAccount() isDataChanged=" + paramBoolean);
  }
  
  private void k(VideoInfo paramVideoInfo)
  {
    int i = paramVideoInfo.a.aHc;
    if (QLog.isColorLevel()) {
      QLog.d("VideoFollowHelper", 2, "innerSubscribeColume() columeid=" + i);
    }
    muj.b(this.mApp, i);
    paramVideoInfo = this.jG.iterator();
    while (paramVideoInfo.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramVideoInfo.next();
      if ((localVideoInfo.yV()) && (localVideoInfo.a.aHc == i))
      {
        localVideoInfo.a.amw = true;
        VideoColumnInfo localVideoColumnInfo = localVideoInfo.a;
        localVideoColumnInfo.subscribeCount += 1;
        this.jdField_a_of_type_Naf.i(localVideoInfo);
      }
    }
    this.jdField_a_of_type_Naf.sw(i);
  }
  
  public void E(VideoInfo paramVideoInfo)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.hH)) || (paramVideoInfo.adB)) {
      return;
    }
    ThreadManager.post(new CheckAccountFollowedRunnable(paramVideoInfo), 1, null, true);
  }
  
  public void L(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.yV()) {
      if (!paramVideoInfo.a.amw) {}
    }
    while (paramVideoInfo.isFollowed)
    {
      return;
      k(paramVideoInfo);
      muj.a(this.mActivity, paramVideoInfo.a.j);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFollowHelper", 2, "followPubAccount onClick() puin=" + paramVideoInfo.hH + ", isFollowed=" + paramVideoInfo.isFollowed + ", pname=" + paramVideoInfo.accountName);
    }
    ai(paramVideoInfo.hH, paramVideoInfo.adB);
  }
  
  class CheckAccountFollowedRunnable
    implements Runnable
  {
    private VideoInfo d;
    
    public CheckAccountFollowedRunnable(VideoInfo paramVideoInfo)
    {
      this.d = paramVideoInfo;
    }
    
    private boolean a(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      if ((paramVideoInfo.hH != null) && (paramVideoInfo.hH.equals(this.d.hH)) && (!paramVideoInfo.isAD) && (paramVideoInfo.isFollowed != paramBoolean))
      {
        paramVideoInfo.isFollowed = paramBoolean;
        return true;
      }
      return false;
    }
    
    public void run()
    {
      try
      {
        boolean bool = muj.b(VideoFollowManager.a(VideoFollowManager.this), Long.valueOf(this.d.hH).longValue());
        if (VideoFollowManager.a(VideoFollowManager.this) == null) {
          return;
        }
        VideoFollowManager.a(VideoFollowManager.this).post(new VideoFollowManager.CheckAccountFollowedRunnable.1(this, bool));
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager
 * JD-Core Version:    0.7.0.1
 */