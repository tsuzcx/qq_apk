package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import ovd;
import pcl;
import pcp;
import pex;
import rwv;
import rwx;

public class QCircleDoublePraiseView
  extends FrameLayout
  implements rwx
{
  private boolean azM;
  private ImageView dp;
  private AnimationSet j;
  private FeedCloudMeta.StFeed mFeed;
  private int mFeedPos;
  private int mPageType;
  
  public QCircleDoublePraiseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void bks()
  {
    ovd.a(getContext(), this.mFeed, null);
  }
  
  private void doReport()
  {
    if (this.mPageType == 57) {
      pcp.a(69, 2, this.mFeed, 2, this.mFeedPos);
    }
    while (this.mFeed == null) {
      return;
    }
    pcl.a(this.mFeed.poster.id.get(), 69, 2, this.mFeedPos, this.mFeed, null);
  }
  
  private void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131560960, this);
    this.dp = ((ImageView)findViewById(2131374509));
  }
  
  private void startAnimation()
  {
    if (this.azM)
    {
      QLog.d("QCircleDoublePraiseView", 1, "mIsInAnimation");
      return;
    }
    this.j = ((AnimationSet)AnimationUtils.loadAnimation(getContext(), 2130772281));
    this.j.setAnimationListener(new pex(this));
    this.dp.setVisibility(0);
    this.dp.startAnimation(this.j);
    bks();
    doReport();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleDoublePraiseAnimationEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
    QLog.d("QCircleDoublePraiseView", 1, "registerReceiver");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
    if (this.dp != null)
    {
      this.dp.setVisibility(8);
      this.azM = false;
    }
    QLog.d("QCircleDoublePraiseView", 1, "unRegisterReceiver");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleDoublePraiseAnimationEvent))
    {
      paramSimpleBaseEvent = (QCircleDoublePraiseAnimationEvent)paramSimpleBaseEvent;
      if ((this.mFeed != null) && (paramSimpleBaseEvent.mTargetFeedId.equals(this.mFeed.id.get())) && (paramSimpleBaseEvent.mPageType == this.mPageType))
      {
        this.mFeedPos = paramSimpleBaseEvent.mFeedPos;
        startAnimation();
        QLog.d("QCircleDoublePraiseView", 1, "ReceiveEvent cur id:" + this.mFeed.id.get() + " pageType:" + this.mPageType);
      }
    }
    else
    {
      return;
    }
    QLog.d("QCircleDoublePraiseView", 1, "id or pagetype not right");
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
    if (this.dp != null)
    {
      this.dp.setVisibility(8);
      this.azM = false;
    }
  }
  
  public void setPageType(int paramInt)
  {
    this.mPageType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView
 * JD-Core Version:    0.7.0.1
 */