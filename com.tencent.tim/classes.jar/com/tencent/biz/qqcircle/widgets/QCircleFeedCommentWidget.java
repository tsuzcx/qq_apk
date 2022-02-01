package com.tencent.biz.qqcircle.widgets;

import acfp;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.b;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import ouy;
import ovd;
import ovv;
import ovx;
import oyh;
import oyu;
import pcl;
import pcp;
import pcr;
import pfa;
import pfb;
import pfc;
import pfd;
import pfe;
import pfl;
import pfo;
import rwv;
import rwx;

public class QCircleFeedCommentWidget
  extends BaseWidgetView<ovx>
  implements View.OnClickListener, View.OnLongClickListener, rwx
{
  private final String REPLY_STR = acfp.m(2131700169);
  BubblePopupWindow.b a = new pfo(this);
  private QCircleAsyncTextView d;
  private ovx mInfo;
  private int mPosition;
  
  public QCircleFeedCommentWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private oyh a()
  {
    if (((getInteractor() instanceof ovv)) && (((ovv)getInteractor()).a() != null)) {
      return ((ovv)getInteractor()).a().a();
    }
    return null;
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    vk(62);
    ouy.a().a(paramView, paramStFeed, paramStComment, new pfe(this, paramStFeed, paramStComment), this.a);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    ouy.a().a(paramView, paramStFeed, paramStReply, new pfl(this, paramStReply, paramStFeed, paramStComment), this.a);
  }
  
  private void a(QCircleCommentPraiseUpdateEvent paramQCircleCommentPraiseUpdateEvent)
  {
    if ((this.mInfo == null) || (this.mInfo.mFeed == null) || (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(this.mInfo.mFeed.id.get(), paramQCircleCommentPraiseUpdateEvent.mFeedId))) {}
    do
    {
      do
      {
        return;
        if ((paramQCircleCommentPraiseUpdateEvent.mType != 1) || (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null)) {
          break;
        }
      } while (!TextUtils.equals(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId));
      if (ovd.a((FeedCloudMeta.StUser)this.mInfo.mFeed.poster.get())) {
        this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      }
      this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
      setCommentTxt(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while ((paramQCircleCommentPraiseUpdateEvent.mType != 2) || (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId)) || (!TextUtils.equals(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get(), paramQCircleCommentPraiseUpdateEvent.mReplyId)));
    if (ovd.a((FeedCloudMeta.StUser)this.mInfo.mFeed.poster.get())) {
      this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    }
    this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
    setReplyTxt(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  private void a(QCircleAsyncTextView paramQCircleAsyncTextView)
  {
    if (paramQCircleAsyncTextView != null)
    {
      paramQCircleAsyncTextView.uO(false);
      paramQCircleAsyncTextView.setText("");
      paramQCircleAsyncTextView.setVisibility(8);
    }
  }
  
  private void e(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (HW()) {}
    while ((!(getInteractor() instanceof ovv)) || (((ovv)getInteractor()).a() == null)) {
      return;
    }
    ovv localovv = (ovv)getInteractor();
    localovv.a().setFeedData(this.mInfo.mFeed);
    localovv.a().setExtraTypeInfo(getExtraTypeInfo());
    localovv.a().setAniView(localovv.a());
    localovv.a().e(paramStComment, paramStReply);
    if ((paramStComment == null) && (paramStReply == null))
    {
      pcl.a(6, 2, getExtraTypeInfo());
      return;
    }
    pcl.a(9, 2, getExtraTypeInfo());
    localovv.a().vj(9);
  }
  
  private void vk(int paramInt)
  {
    if (pcr.a().ez(57))
    {
      pcp.b(paramInt, 2, getExtraTypeInfo());
      return;
    }
    pcl.a(paramInt, 2, getExtraTypeInfo());
  }
  
  public boolean HW()
  {
    return false;
  }
  
  protected void a(ovx paramovx) {}
  
  public void a(ovx paramovx, int paramInt)
  {
    if (paramovx == null) {}
    do
    {
      return;
      this.mInfo = paramovx;
      this.mPosition = paramInt;
    } while (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
    if (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null)
    {
      setCommentTxt(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    }
    setReplyTxt(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.d = ((QCircleAsyncTextView)paramView.findViewById(2131374505));
    this.d.setOnClickListener(this);
    this.d.setOnLongClickListener(this);
    this.d.setOnTriggerEllipseListener(new pfa(this));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131560895;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
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
      if ((this.mInfo != null) && (this.mInfo.mFeed != null) && (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)) {
        e(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if ((this.mInfo != null) && (this.mInfo.mFeed != null) && (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)) {
        if (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) {
          a(paramView, this.mInfo.mFeed, this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        } else {
          a(paramView, this.mInfo.mFeed, this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) {
      a((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setCommentTxt(FeedCloudMeta.StComment paramStComment)
  {
    a(this.d);
    if ((paramStComment.postUser.get() != null) && (!TextUtils.isEmpty(paramStComment.postUser.nick.get())) && (this.d != null))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStComment.postUser.nick.get()).append("：").append(paramStComment.content.get());
      this.d.a(localSpannableStringBuilder, 0, paramStComment.postUser.nick.get().length(), new pfb(this, paramStComment));
      this.d.bxX();
      this.d.setText(localSpannableStringBuilder);
      this.d.setVisibility(0);
    }
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.d);
    String str1;
    if ((paramStReply != null) && (this.d != null) && (this.mInfo != null))
    {
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label287;
      }
      str1 = this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label302;
      }
    }
    label287:
    label302:
    for (String str2 = this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();; str2 = paramStReply.targetUser.nick.get())
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.REPLY_STR).append(str2).append("：").append(paramStReply.content.get());
      this.d.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new pfc(this, paramStReply));
      QCircleAsyncTextView localQCircleAsyncTextView = this.d;
      int i = paramStReply.postUser.nick.get().length();
      int j = this.REPLY_STR.length();
      int k = paramStReply.postUser.nick.get().length();
      int m = this.REPLY_STR.length();
      localQCircleAsyncTextView.a(localSpannableStringBuilder, i + j, str2.length() + (k + m), new pfd(this, str1));
      this.d.bxX();
      this.d.setText(localSpannableStringBuilder);
      this.d.setVisibility(0);
      return;
      str1 = paramStReply.targetUser.id.get();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget
 * JD-Core Version:    0.7.0.1
 */