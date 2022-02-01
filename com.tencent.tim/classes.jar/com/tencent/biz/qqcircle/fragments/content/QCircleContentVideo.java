package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.superplayer.api.ISuperPlayer;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import ous;
import pbo;
import pcp;
import pdx;

public class QCircleContentVideo
  extends BaseVideoView
{
  private volatile QCircleContentOperationView a;
  private boolean mIsCompleted;
  private int mPos;
  
  public QCircleContentVideo(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void aAz()
  {
    setOnClickListener(new pbo(this));
  }
  
  public boolean HK()
  {
    return true;
  }
  
  public void J(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null) {
      pcp.a(2, 5, 2, this.mPos, paramLong1, paramLong2, true, "", localStFeed, pcp.a(localStFeed));
    }
  }
  
  public void K(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null) {
      pcp.a(2, 6, 2, this.mPos, paramLong1, paramLong2, true, "", localStFeed, pcp.a(localStFeed));
    }
  }
  
  public void P(Object paramObject) {}
  
  public SeekBar a()
  {
    if (this.a != null) {
      return this.a.mSeekBar;
    }
    return null;
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mPos = paramInt;
    paramObject = (FeedCloudMeta.StFeed)paramObject;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = ous.b(a());
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130851770);
    paramObject = new QCircleFeedPicLoader.b().a(paramObject.cover.picUrl.get()).a(a()).b(localURLDrawableOptions.mRequestWidth).a(localURLDrawableOptions.mRequestHeight).a(true).a(localURLDrawableOptions.mLoadingDrawable);
    QCircleFeedPicLoader.a().a(paramObject, null);
  }
  
  public void bjp()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null) {
      pcp.a(2, 4, 2, this.mPos, 0L, 0L, true, "", localStFeed, pcp.a(localStFeed));
    }
  }
  
  public void d(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null)
    {
      String str = "";
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        str = paramInt2 + ":" + paramInt1;
      }
      pcp.a(2, 7, 2, this.mPos, paramLong1, paramLong2, true, str, localStFeed, pcp.a(localStFeed));
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    aAz();
    setLoopBack(true);
  }
  
  public long getCurrentPosition()
  {
    if (a() != null) {
      return a().getCurrentPositionMs();
    }
    return 0L;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public String getPlayUrl()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if ((localStFeed != null) && (localStFeed.type.get() == 3)) {
      return localStFeed.video.playUrl.get();
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!this.aKA) {
        getMainHandler().postDelayed(new QCircleContentVideo.3(this), 1500L);
      }
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.mIsCompleted = true;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    super.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    if ((this.aKA) && (this.a != null))
    {
      if (this.a.wj != null) {
        this.a.wj.setText(pdx.bO(paramInt) + " | ");
      }
      if (this.a.eF != null) {
        this.a.eF.setVisibility(0);
      }
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    getMainHandler().post(new QCircleContentVideo.2(this, paramISuperPlayer));
    start();
  }
  
  public void pause()
  {
    super.pause();
    if ((this.a != null) && (this.a.d != null)) {
      this.a.d.setVisibility(0);
    }
  }
  
  public void replay()
  {
    super.replay();
    this.mIsCompleted = false;
  }
  
  public void setOperationView(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.a = paramQCircleContentOperationView;
  }
  
  public void setVideoPath(String paramString1, String paramString2, int paramInt)
  {
    if (a() != null) {
      a().setOnSeekBarChangeListener(this);
    }
    this.mIsCompleted = false;
    super.setVideoPath(paramString1, paramString2, paramInt);
  }
  
  public void start()
  {
    if ((this.FD) && (this.Z != null)) {
      this.Z.setVisibility(8);
    }
    super.start();
    if ((this.a != null) && (this.a.d != null)) {
      this.a.d.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo
 * JD-Core Version:    0.7.0.1
 */