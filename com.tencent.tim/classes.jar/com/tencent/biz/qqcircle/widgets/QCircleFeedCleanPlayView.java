package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.superplayer.api.ISuperPlayer;
import feedcloud.FeedCloudMeta.StFeed;
import pcp;
import pem;
import pie;

public class QCircleFeedCleanPlayView
  extends BaseVideoView
{
  pie b;
  private boolean mAutoPlay;
  private int mPos;
  
  public QCircleFeedCleanPlayView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mPos = paramInt;
  }
  
  public void J(long paramLong1, long paramLong2) {}
  
  public void K(long paramLong1, long paramLong2) {}
  
  public void P(Object paramObject) {}
  
  public SeekBar a()
  {
    return null;
  }
  
  public void bjH()
  {
    super.bjH();
    if (this.a != null) {
      this.a.bjH();
    }
  }
  
  public void bjp()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null) {
      pcp.a(2, 4, 1, this.mPos, 0L, 0L, true, "", localStFeed, pcp.a(localStFeed));
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
      pcp.a(2, 7, 1, this.mPos, paramLong1, paramLong2, this.mAutoPlay, str, localStFeed, pcp.a(localStFeed));
    }
  }
  
  public void e(Context paramContext, View paramView) {}
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.a != null) {
        this.a.w("", paramMessage.arg2, paramMessage.arg1);
      }
    }
  }
  
  public boolean isPausing()
  {
    if (a() != null) {
      return a().isPausing();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    if (a() != null) {
      return a().isPlaying();
    }
    return false;
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    paramISuperPlayer.setXYaxis(2);
    if (this.a != null) {
      this.a.onVideoPrepared(paramISuperPlayer);
    }
  }
  
  public void setFeedPresenter(pie parampie)
  {
    this.b = parampie;
  }
  
  public void setIsAutoPlay(boolean paramBoolean)
  {
    this.mAutoPlay = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView
 * JD-Core Version:    0.7.0.1
 */