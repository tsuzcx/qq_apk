package com.tencent.biz.qqcircle.comment;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.comment.ReplyView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import ovd;
import oye;
import oyf;
import rwv;
import rwx;
import sdw;

public class ItemReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, rwx
{
  private static final String TAG = ReplyView.class.getName();
  private final String REPLY_STR = acfp.m(2131713900);
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private QCircleCommentPraiseLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private sdw jdField_a_of_type_Sdw;
  private QCircleAsyncTextView b;
  private Drawable cT;
  private Drawable cU;
  private Drawable cV;
  private FeedCloudMeta.StFeed mFeed;
  private int mPosition;
  
  public ItemReplyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ItemReplyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ItemReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    bindEvents();
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.mFeed == null) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramStComment != null) && (paramStReply.targetUser != null) && (!TextUtils.isEmpty(paramStReply.targetUser.id.get())))
    {
      localSpannableStringBuilder.append(this.REPLY_STR).append(paramStReply.targetUser.nick.get());
      this.b.a(localSpannableStringBuilder, this.REPLY_STR.length(), this.REPLY_STR.length() + paramStReply.targetUser.nick.get().length(), new oyf(this, paramStReply));
      if (paramStReply.targetUser.id.get().equals(this.mFeed.poster.id.get()))
      {
        if (this.cT == null)
        {
          this.cT = getResources().getDrawable(2130844769);
          this.cT.setBounds(ImmersiveUtils.dpToPx(2.0F), 0, ImmersiveUtils.dpToPx(33.0F), ImmersiveUtils.dpToPx(14.0F));
        }
        this.b.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.cT);
      }
      localSpannableStringBuilder.append("：");
    }
    localSpannableStringBuilder.append(paramStReply.content.get());
    if (paramStReply.typeFlag.get() == 1)
    {
      if (this.cV == null)
      {
        this.cV = getResources().getDrawable(2130844771);
        this.cV.setBounds(ImmersiveUtils.dpToPx(2.0F), 0, ImmersiveUtils.dpToPx(33.0F), ImmersiveUtils.dpToPx(14.0F));
      }
      this.b.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.cV);
      this.b.uO(true);
    }
    for (;;)
    {
      this.b.bxX();
      this.b.setText(localSpannableStringBuilder);
      return;
      if (paramStReply.likeInfo.ownerStatus.get() == 1)
      {
        if (this.cU == null)
        {
          this.cU = getResources().getDrawable(2130844770);
          this.cU.setBounds(ImmersiveUtils.dpToPx(2.0F), 0, ImmersiveUtils.dpToPx(52.0F), ImmersiveUtils.dpToPx(14.0F));
        }
        this.b.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.cU);
        this.b.uO(true);
      }
      else
      {
        this.b.uO(false);
      }
    }
  }
  
  private void bindEvents()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    setOnClickListener(this);
    this.b.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  private void initView()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560950, this, true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131377156));
    this.b = ((QCircleAsyncTextView)localView.findViewById(2131377154));
    this.b.setNeedParseColor(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout = ((QCircleCommentPraiseLayout)localView.findViewById(2131373543));
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
    FeedCloudMeta.StComment localStComment;
    FeedCloudMeta.StReply localStReply;
    switch (paramView.getId())
    {
    case 2131377155: 
    default: 
      if (((paramView instanceof ReplyView)) && (this.jdField_a_of_type_Sdw != null))
      {
        localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
        localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
        this.jdField_a_of_type_Sdw.a(paramView, 7, this.mPosition, new Object[] { localStComment, localStReply });
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Sdw != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null))
      {
        this.jdField_a_of_type_Sdw.a(paramView, 2, this.mPosition, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser);
        continue;
        if (this.jdField_a_of_type_Sdw != null)
        {
          localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
          localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
          this.jdField_a_of_type_Sdw.a(paramView, 7, this.mPosition, new Object[] { localStComment, localStReply });
        }
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
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
    } while (this.jdField_a_of_type_Sdw == null);
    FeedCloudMeta.StComment localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    FeedCloudMeta.StReply localStReply = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
    this.jdField_a_of_type_Sdw.b(paramView, 8, this.mPosition, new Object[] { localStComment, localStReply });
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) || (this.mFeed == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mFeedId, this.mFeed.id.get()))) {}
    while ((((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mType != 2) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mCommentId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mReplyId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get()))) {
      return;
    }
    if (ovd.a((FeedCloudMeta.StUser)this.mFeed.poster.get())) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.ownerStatus.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedNum);
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  public void setData(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
    if ((paramStFeed == null) || (paramStComment == null) || (paramStReply == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder;
    if ((paramStReply.postUser != null) && (paramStReply.postUser.nick.get() != null))
    {
      localSpannableStringBuilder = new SpannableStringBuilder(paramStReply.postUser.nick.get());
      if (!paramStReply.postUser.id.get().equals(paramStFeed.poster.id.get())) {
        break label204;
      }
      if (this.cT == null)
      {
        this.cT = getResources().getDrawable(2130844769);
        this.cT.setBounds(ImmersiveUtils.dpToPx(2.0F), 0, ImmersiveUtils.dpToPx(33.0F), ImmersiveUtils.dpToPx(14.0F));
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.cT);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.uO(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localSpannableStringBuilder);
      a(paramStComment, paramStReply);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setData(2, paramStFeed, paramStComment, paramStReply, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setOnClickHookListener(new oye(this));
      return;
      label204:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.uO(false);
    }
  }
  
  public void setOnCommentElementClickListener(sdw paramsdw)
  {
    this.jdField_a_of_type_Sdw = paramsdw;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.ItemReplyView
 * JD-Core Version:    0.7.0.1
 */