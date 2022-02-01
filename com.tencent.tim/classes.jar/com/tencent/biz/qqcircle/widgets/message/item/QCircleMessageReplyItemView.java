package com.tencent.biz.qqcircle.widgets.message.item;

import acfp;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import ovx;
import pig;
import pih;

public class QCircleMessageReplyItemView
  extends BaseWidgetView<ovx>
  implements View.OnClickListener
{
  private final String REPLY_STR = acfp.m(2131700169);
  private a a;
  private QCircleAsyncTextView d;
  private ovx mInfo;
  private int mPosition;
  
  public QCircleMessageReplyItemView(@NonNull Context paramContext)
  {
    super(paramContext);
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
    setReplyTxt(this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.d = ((QCircleAsyncTextView)paramView.findViewById(2131369855));
    this.d.setOnClickListener(this);
  }
  
  public int getLayoutId()
  {
    return 2131560925;
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
      if ((this.mInfo != null) && (this.mInfo.mFeed != null) && (this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) && (this.a != null)) {
        this.a.b(this.mInfo);
      }
    }
  }
  
  public void setReplyItemListener(a parama)
  {
    this.a = parama;
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.d);
    String str1;
    if ((paramStReply != null) && (this.d != null) && (this.mInfo != null))
    {
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label286;
      }
      str1 = this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label301;
      }
    }
    label286:
    label301:
    for (String str2 = this.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();; str2 = paramStReply.targetUser.nick.get())
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.REPLY_STR).append(str2).append("：").append(paramStReply.content.get());
      this.d.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new pig(this, paramStReply));
      QCircleAsyncTextView localQCircleAsyncTextView = this.d;
      int i = paramStReply.postUser.nick.get().length();
      int j = this.REPLY_STR.length();
      int k = paramStReply.postUser.nick.get().length();
      int m = this.REPLY_STR.length();
      localQCircleAsyncTextView.a(localSpannableStringBuilder, i + j, str2.length() + (k + m), new pih(this, str1));
      this.d.bxX();
      this.d.setText(localSpannableStringBuilder);
      this.d.setVisibility(0);
      return;
      str1 = paramStReply.targetUser.id.get();
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(ovx paramovx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.message.item.QCircleMessageReplyItemView
 * JD-Core Version:    0.7.0.1
 */