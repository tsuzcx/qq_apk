package com.tencent.biz.qqcircle.widgets;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCirclePraiseUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import pgk;
import rwv;
import rwx;

public class QCirclePraiseImageView
  extends ImageView
  implements View.OnClickListener, rwx
{
  private boolean azH = true;
  private int bhY = 2130844808;
  private int bhZ = 2130844809;
  private FeedCloudMeta.StFeed l = new FeedCloudMeta.StFeed();
  
  public QCirclePraiseImageView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public QCirclePraiseImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public QCirclePraiseImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void bko()
  {
    try
    {
      setBackgroundDrawable(getResources().getDrawable(this.bhZ));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCirclePraise_", 1, "showLikeView setBackgroundDrawable error");
    }
  }
  
  private void bkp()
  {
    try
    {
      setBackgroundDrawable(getResources().getDrawable(this.bhY));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCirclePraise_", 1, "showUnLikeView setBackgroundDrawable error");
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void initView()
  {
    setOnClickListener(this);
    bkp();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (!this.azH) {
      QQToast.a(getContext(), acfp.m(2131704186), 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.l != null) && (this.l.likeInfo.get() != null))
      {
        this.azH = false;
        if (this.l.likeInfo.status.get() == 0) {
          i = 1;
        }
        VSNetworkHelper.a().a(new QCircleDoLikeRequest(this.l, i, this.l.likeInfo, null), new pgk(this, i));
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int i = 1;
    int j;
    if ((this.l != null) && ((paramSimpleBaseEvent instanceof QCirclePraiseUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCirclePraiseUpdateEvent)paramSimpleBaseEvent;
      if (this.l.id.get().equals(paramSimpleBaseEvent.mTargetFeedId))
      {
        vx(paramSimpleBaseEvent.mPraisedStatus);
        if (this.l.likeInfo.status.get() != paramSimpleBaseEvent.mPraisedStatus)
        {
          this.l.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
          j = this.l.likeInfo.count.get();
          if (paramSimpleBaseEvent.mPraisedStatus != 1) {
            break label125;
          }
        }
      }
    }
    for (;;)
    {
      this.l.likeInfo.count.set(i + j);
      return;
      label125:
      i = -1;
    }
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.likeInfo.get() != null))
    {
      this.l = paramStFeed;
      vx(paramStFeed.likeInfo.status.get());
    }
  }
  
  public void setPraisedDrawable(int paramInt)
  {
    this.bhZ = paramInt;
  }
  
  public void setUnPraiseDrawable(int paramInt)
  {
    this.bhY = paramInt;
  }
  
  public void vx(int paramInt)
  {
    if (this.l != null) {
      this.l.likeInfo.status.set(paramInt);
    }
    if (paramInt == 1)
    {
      bko();
      return;
    }
    bkp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePraiseImageView
 * JD-Core Version:    0.7.0.1
 */