package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;
import acfp;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.comment.ReplyActionView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import sdw;

public class WsReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private ReplyActionView jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView;
  private sdw jdField_a_of_type_Sdw;
  private int bfa;
  private int bfb;
  private stSimpleMetaComment e;
  private int mPosition;
  
  public WsReplyContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WsReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WsReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    bindEvents();
  }
  
  private void bindEvents() {}
  
  private void initView() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Sdw != null)
      {
        this.jdField_a_of_type_Sdw.a(paramView, 10, this.mPosition, this.e);
        continue;
        if (this.jdField_a_of_type_Sdw != null)
        {
          stSimpleMetaComment localstSimpleMetaComment = this.e;
          int i = getHeight() / this.bfb;
          this.jdField_a_of_type_Sdw.a(paramView, 11, this.mPosition, new Object[] { localstSimpleMetaComment, Integer.valueOf(i) });
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  protected void setData(stSimpleMetaComment paramstSimpleMetaComment, int paramInt, String paramString)
  {
    if ((paramstSimpleMetaComment == null) || (paramstSimpleMetaComment.replyList.size() == 0))
    {
      setVisibility(8);
      return;
    }
    this.e = paramstSimpleMetaComment;
    ArrayList localArrayList = paramstSimpleMetaComment.replyList;
    int j = localArrayList.size();
    if (paramInt > 0) {}
    for (paramInt = Math.min(j, paramInt);; paramInt = j)
    {
      this.bfb = paramInt;
      setVisibility(0);
      removeAllViews();
      int i = 0;
      while (i < paramInt)
      {
        stSimpleMetaReply localstSimpleMetaReply = (stSimpleMetaReply)localArrayList.get(i);
        WsReplyView localWsReplyView = new WsReplyView(getContext());
        localWsReplyView.setPosition(i);
        localWsReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_Sdw);
        localWsReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localWsReplyView.setClickable(true);
        localWsReplyView.setFocusable(true);
        localWsReplyView.setData(paramstSimpleMetaComment, localstSimpleMetaReply, paramString);
        addView(localWsReplyView);
        i += 1;
      }
      if (paramInt <= j)
      {
        if (this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView == null)
        {
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView = new ReplyActionView(getContext());
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.setClickable(true);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.u().setOnClickListener(this);
        }
        if (paramInt <= this.bfa) {
          break label318;
        }
        if (paramInt != j) {
          break label278;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.u().setVisibility(0);
      }
      for (;;)
      {
        addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView);
        setVisibility(0);
        return;
        label278:
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setText(acfp.m(2131713886));
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.u().setVisibility(0);
        continue;
        label318:
        if (j > paramInt)
        {
          paramInt = j - paramInt;
          if (paramInt > 0)
          {
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setText(acfp.m(2131713884) + paramInt + acfp.m(2131713885));
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setVisibility(0);
            this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.u().setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setVisibility(8);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.u().setVisibility(8);
        }
      }
    }
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.bfa = paramInt;
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyContainer
 * JD-Core Version:    0.7.0.1
 */