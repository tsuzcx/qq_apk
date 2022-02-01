package com.tencent.biz.qqcircle.widgets;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import ovd;
import pew;
import rpq;
import rwv;
import rwx;

public class QCircleCommentPraiseLayout
  extends LinearLayout
  implements View.OnClickListener, rwx
{
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout$a;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private boolean azH = true;
  private boolean azI;
  private int bhY = 2130844772;
  private int bhZ = 2130844774;
  private FeedCloudMeta.StFeed mFeed;
  private int mType;
  private ImageView me;
  private TextView wm;
  
  public QCircleCommentPraiseLayout(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public QCircleCommentPraiseLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public QCircleCommentPraiseLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void bko()
  {
    try
    {
      this.me.setBackgroundDrawable(getResources().getDrawable(this.bhZ));
      this.me.setVisibility(0);
      this.wm.setTextColor(getResources().getColor(2131166511));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPraiseLay", 1, "showLikeView setBackgroundDrawable error");
    }
  }
  
  private void bkp()
  {
    try
    {
      this.me.setBackgroundDrawable(getResources().getDrawable(this.bhY));
      this.me.setVisibility(0);
      this.wm.setTextColor(getResources().getColor(2131166510));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPraiseLay", 1, "showUnLikeView setBackgroundDrawable error");
    }
  }
  
  private void initView()
  {
    setOrientation(0);
    setGravity(16);
    this.wm = new TextView(getContext());
    this.wm.setTextSize(1, 12.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = rpq.dip2px(getContext(), 3.0F);
    addView(this.wm, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(rpq.dip2px(getContext(), 16.0F), rpq.dip2px(getContext(), 16.0F));
    this.me = new ImageView(getContext());
    addView(this.me, localLayoutParams);
    this.me.setOnClickListener(this);
    setTouchDelegate(this.me, 30);
  }
  
  public void Q(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      bko();
    }
    while (this.azI) {
      if (paramLong == 0L)
      {
        this.wm.setVisibility(4);
        return;
        if (paramInt == 0) {
          bkp();
        }
      }
      else
      {
        this.wm.setVisibility(0);
        this.wm.setText(ovd.aD(paramLong));
        return;
      }
    }
    this.wm.setVisibility(4);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    int k = 1;
    int j = 1;
    if (this.mFeed == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.azH) {
        break;
      }
      QQToast.a(getContext(), acfp.m(2131704186), 0).show();
    }
    this.azH = false;
    FeedCloudMeta.StLike localStLike = new FeedCloudMeta.StLike();
    int i;
    if ((this.mType == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null))
    {
      localStLike = (FeedCloudMeta.StLike)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.get();
      if (localStLike.status.get() == 0) {
        i = 3;
      }
    }
    for (;;)
    {
      label104:
      boolean bool;
      label131:
      int m;
      label154:
      label190:
      int n;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout$a != null)
      {
        a locala = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout$a;
        if (localStLike.status.get() == 0)
        {
          bool = true;
          locala.rj(bool);
        }
      }
      else
      {
        if (localStLike.status.get() != 0) {
          break label335;
        }
        m = 1;
        if ((this.mType != 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null)) {
          break label346;
        }
        k = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.get();
        if (m != 1) {
          break label341;
        }
        n = k + j;
        j = k;
        k = n;
      }
      for (;;)
      {
        Q(m, k);
        n = localStLike.status.get();
        VSNetworkHelper.a().a(getContext(), new QCircleDoLikeRequest(this.mFeed, i, localStLike, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply), new pew(this, m, k, n, j));
        break;
        i = 4;
        break label104;
        if ((this.mType != 2) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null)) {
          break label410;
        }
        localStLike = (FeedCloudMeta.StLike)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.get();
        if (localStLike.status.get() == 0) {}
        for (i = 5;; i = 6) {
          break;
        }
        bool = false;
        break label131;
        label335:
        m = 0;
        break label154;
        label341:
        j = -1;
        break label190;
        label346:
        if ((this.mType == 2) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null))
        {
          n = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.get();
          if (m == 1) {}
          for (j = k;; j = -1)
          {
            k = n + j;
            j = n;
            break;
          }
        }
        k = 0;
        j = 0;
      }
      label410:
      i = 0;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) && (this.mFeed != null) && (TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mFeedId, this.mFeed.id.get())))
    {
      paramSimpleBaseEvent = (QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent;
      if ((this.mType != 1) || (paramSimpleBaseEvent.mType != 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramSimpleBaseEvent.mCommentId))) {
        break label133;
      }
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
      Q(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
    }
    label133:
    while ((this.mType != 2) || (paramSimpleBaseEvent.mType != 2) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramSimpleBaseEvent.mCommentId)) || (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get(), paramSimpleBaseEvent.mReplyId))) {
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
    Q(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
  }
  
  public void setData(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    setData(paramInt, paramStFeed, paramStComment, paramStReply, false);
  }
  
  public void setData(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean)
  {
    setVisibility(8);
    if (paramStFeed == null) {}
    do
    {
      do
      {
        return;
        this.mType = paramInt;
        this.mFeed = paramStFeed;
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
        this.azI = paramBoolean;
        if (this.mType != 1) {
          break;
        }
      } while (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
      Q(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.get());
      setVisibility(0);
      return;
    } while ((this.mType != 2) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null));
    Q(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.get());
    setVisibility(0);
  }
  
  public void setOnClickHookListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout$a = parama;
  }
  
  public void setTouchDelegate(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      View localView = (View)paramView.getParent();
      localView.post(new QCircleCommentPraiseLayout.2(this, paramView, paramInt, localView));
    }
  }
  
  public static abstract interface a
  {
    public abstract void rj(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout
 * JD-Core Version:    0.7.0.1
 */