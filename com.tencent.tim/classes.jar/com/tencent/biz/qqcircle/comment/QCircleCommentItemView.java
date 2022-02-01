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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import ovd;
import oys;
import oyt;
import rpq;
import rwv;
import rwx;
import sdl;
import sdw;

public class QCircleCommentItemView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, rwx
{
  private ItemReplyContainer jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer;
  public a a;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleCommentPraiseLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private sdw jdField_a_of_type_Sdw;
  private QCircleAsyncTextView b;
  private Drawable cT;
  private Drawable cU;
  private Drawable cV;
  private LinearLayout eE;
  private RelativeLayout fE;
  private FeedCloudMeta.StFeed mFeed;
  private int mPosition;
  
  public QCircleCommentItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCommentItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCommentItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    bindEvents();
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a != null) && (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ex != null))
    {
      if ((!paramBoolean) || (paramStComment == null) || (paramStComment.vecReply.size() <= 0)) {
        break label137;
      }
      String str = sdl.aN(paramStComment.createTime.get() * 1000L);
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ex.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.lt.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ka.setText(str);
      if (paramStComment.vecReply.size() > 0) {
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.um.setText(ovd.e(paramStComment.replyCount.get(), true) + acfp.m(2131704213));
      }
    }
    return;
    label137:
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ex.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.lt.setVisibility(8);
  }
  
  private void bindEvents()
  {
    this.fE.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.b.setOnLongClickListener(this);
    this.fE.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.un.setOnClickListener(this);
  }
  
  private void d(FeedCloudMeta.StComment paramStComment)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramStComment.content.get());
    if (paramStComment.typeFlag.get() == 1)
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
      if (paramStComment.likeInfo.ownerStatus.get() == 1)
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
  
  private void initView()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560881, this, true);
    localView.setPadding(0, 0, 0, rpq.dip2px(getContext(), 12.0F));
    this.fE = ((RelativeLayout)localView.findViewById(2131364998));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)localView.findViewById(2131363175));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)localView.findViewById(2131373533));
    this.b = ((QCircleAsyncTextView)localView.findViewById(2131373526));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer = ((ItemReplyContainer)localView.findViewById(2131377134));
    this.eE = ((LinearLayout)localView.findViewById(2131377138));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout = ((QCircleCommentPraiseLayout)localView.findViewById(2131373543));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a = new a();
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.dX = ((LinearLayout)localView.findViewById(2131378305));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ka = ((TextView)localView.findViewById(2131365005));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.um = ((TextView)localView.findViewById(2131371958));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ex = ((LinearLayout)localView.findViewById(2131363913));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.un = ((TextView)localView.findViewById(2131363968));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.un.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.lt = ((ImageView)localView.findViewById(2131365996));
  }
  
  public FeedCloudMeta.StComment a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  }
  
  public LinearLayout f()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer;
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
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Sdw != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null))
      {
        this.jdField_a_of_type_Sdw.a(paramView, 1, this.mPosition, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
        continue;
        if ((this.jdField_a_of_type_Sdw != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null))
        {
          this.jdField_a_of_type_Sdw.a(paramView, 2, this.mPosition, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
          continue;
          if (this.jdField_a_of_type_Sdw != null)
          {
            this.jdField_a_of_type_Sdw.a(paramView, 4, this.mPosition, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
            continue;
            if (this.jdField_a_of_type_Sdw != null) {
              this.jdField_a_of_type_Sdw.a(paramView, 13, this.mPosition, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
            }
          }
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
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Sdw != null) {
      this.jdField_a_of_type_Sdw.b(paramView, 5, this.mPosition, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
    }
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) || (this.mFeed == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mFeedId, this.mFeed.id.get()))) {}
    while ((((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mType != 1) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mCommentId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()))) {
      return;
    }
    if (ovd.a((FeedCloudMeta.StUser)this.mFeed.poster.get())) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.ownerStatus.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedNum);
    d(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
  }
  
  public void setData(FeedCloudMeta.StComment paramStComment, int paramInt1, FeedCloudMeta.StFeed paramStFeed, int paramInt2, boolean paramBoolean)
  {
    this.mFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    if ((paramStComment == null) || (paramStFeed == null)) {
      return;
    }
    if ((paramStComment.postUser != null) && (paramStComment.postUser.nick.get() != null))
    {
      if ((getContext() instanceof BaseActivity)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, paramStComment.postUser);
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramStComment.postUser.nick.get());
      if (paramStComment.postUser.id.get().equals(paramStFeed.poster.id.get()))
      {
        if (this.cT == null)
        {
          this.cT = getResources().getDrawable(2130844769);
          this.cT.setBounds(ImmersiveUtils.dpToPx(2.0F), 0, ImmersiveUtils.dpToPx(33.0F), ImmersiveUtils.dpToPx(14.0F));
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.cT);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.uO(true);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localSpannableStringBuilder);
      }
    }
    else
    {
      d(paramStComment);
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ka.setText(sdl.aN(paramStComment.createTime.get() * 1000L));
      a(paramStComment, false);
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size() != 0) {
        break label301;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(8);
      this.eE.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setData(1, paramStFeed, paramStComment, null, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setOnClickHookListener(new oyt(this));
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.uO(false);
      break;
      label301:
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size() > 0)
      {
        if (paramInt1 == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(8);
          this.eE.setVisibility(8);
          a(paramStComment, true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setData(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, paramInt1, paramStFeed, paramInt2, paramBoolean);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(0);
          this.eE.setVisibility(0);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setVisibility(8);
        this.eE.setVisibility(8);
      }
    }
  }
  
  public void setOnCommentElementClickListener(sdw paramsdw)
  {
    this.jdField_a_of_type_Sdw = paramsdw;
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setOnCommentElementClickListener(paramsdw);
    if ((this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a != null) && (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ex != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentItemView$a.ex.setOnClickListener(new oys(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
    this.jdField_a_of_type_ComTencentBizQqcircleCommentItemReplyContainer.setPosition(paramInt);
  }
  
  public static class a
  {
    public LinearLayout dX;
    public LinearLayout ex;
    public TextView ka;
    public ImageView lt;
    public TextView um;
    public TextView un;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentItemView
 * JD-Core Version:    0.7.0.1
 */