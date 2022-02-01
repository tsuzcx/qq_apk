package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
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
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import sdw;

public class ReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private ReplyActionView jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView;
  private sdw jdField_a_of_type_Sdw;
  private int bfa;
  private int bfb;
  private CertifiedAccountMeta.StComment g;
  private int mPosition;
  
  public ReplyContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    bindEvents();
  }
  
  private void bindEvents() {}
  
  private void initView() {}
  
  public ReplyView a(String paramString)
  {
    if ((this.g != null) && (this.g.vecReply.get() != null))
    {
      int j = this.g.vecReply.get().size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          if ((((CertifiedAccountMeta.StReply)this.g.vecReply.get(i)).id.get().equals(paramString)) && (getChildCount() > i + 1) && ((getChildAt(i) instanceof ReplyView))) {
            return (ReplyView)getChildAt(i);
          }
          i += 1;
        }
      }
    }
    return null;
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
      if (this.jdField_a_of_type_Sdw != null)
      {
        this.jdField_a_of_type_Sdw.a(paramView, 10, this.mPosition, this.g);
        continue;
        if (this.jdField_a_of_type_Sdw != null)
        {
          CertifiedAccountMeta.StComment localStComment = this.g;
          int i = getHeight() / this.bfb;
          this.jdField_a_of_type_Sdw.a(paramView, 11, this.mPosition, new Object[] { localStComment, Integer.valueOf(i) });
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  protected void setData(CertifiedAccountMeta.StComment paramStComment, int paramInt, String paramString)
  {
    if ((paramStComment == null) || (paramStComment.vecReply.size() == 0))
    {
      setVisibility(8);
      return;
    }
    this.g = paramStComment;
    List localList = paramStComment.vecReply.get();
    int j = localList.size();
    if (j > 0) {
      if (paramInt <= 0) {
        break label442;
      }
    }
    label286:
    label442:
    for (paramInt = Math.min(j, paramInt);; paramInt = j)
    {
      this.bfb = paramInt;
      setVisibility(0);
      removeAllViews();
      int i = 0;
      while (i < paramInt)
      {
        CertifiedAccountMeta.StReply localStReply = (CertifiedAccountMeta.StReply)localList.get(i);
        ReplyView localReplyView = new ReplyView(getContext());
        localReplyView.setPosition(i);
        localReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_Sdw);
        localReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localReplyView.setClickable(true);
        localReplyView.setFocusable(true);
        localReplyView.setData(paramStComment, localStReply, paramString);
        addView(localReplyView);
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
          break label327;
        }
        if (paramInt != j) {
          break label286;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.u().setVisibility(0);
      }
      for (;;)
      {
        addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView);
        setVisibility(0);
        return;
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setText(acfp.m(2131713886));
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.t().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyActionView.u().setVisibility(8);
        continue;
        label327:
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
      setVisibility(8);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyContainer
 * JD-Core Version:    0.7.0.1
 */