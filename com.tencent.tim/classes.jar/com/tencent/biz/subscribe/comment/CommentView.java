package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcu.a;
import aqhu;
import aqmr;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import rpq;
import sdj;
import sdk;
import sdl;
import sdu;
import sdw;

public class CommentView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  public a a;
  public ReplyContainer a;
  private sdw jdField_a_of_type_Sdw;
  private boolean axo;
  private int bfa;
  AsyncRichTextView c;
  private Drawable cR;
  private Drawable cS;
  RelativeLayout fE;
  private CertifiedAccountMeta.StComment g;
  ImageView ls;
  View mDivider;
  View mLikeContainer;
  private int mPosition;
  TextView uk;
  TextView ul;
  
  public CommentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    bindEvents();
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ex != null))
    {
      if ((!paramBoolean) || (paramStComment == null) || (paramStComment.vecReply.size() <= 0)) {
        break label129;
      }
      String str = sdl.aN(paramStComment.createTime.get() * 1000L);
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ex.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.lt.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ka.setText(str);
      if (paramStComment.vecReply.size() > 0) {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.um.setText(paramStComment.replyCount + acfp.m(2131704213));
      }
    }
    return;
    label129:
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ex.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.lt.setVisibility(8);
  }
  
  private void bindEvents()
  {
    this.fE.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.uk.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.mLikeContainer.setOnClickListener(this);
    this.c.setOnLongClickListener(this);
    this.fE.setOnLongClickListener(this);
  }
  
  private void initView()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558884, this, true);
    this.fE = ((RelativeLayout)localView.findViewById(2131364998));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131363175));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.uk = ((TextView)localView.findViewById(2131373533));
    this.c = ((AsyncRichTextView)localView.findViewById(2131373526));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer = ((ReplyContainer)localView.findViewById(2131377134));
    this.mLikeContainer = localView.findViewById(2131370440);
    this.ls = ((ImageView)localView.findViewById(2131370437));
    this.ul = ((TextView)localView.findViewById(2131370441));
    this.mDivider = localView.findViewById(2131365990);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a = new a();
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.dX = ((LinearLayout)localView.findViewById(2131378305));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ka = ((TextView)localView.findViewById(2131365005));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.um = ((TextView)localView.findViewById(2131371958));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ex = ((LinearLayout)localView.findViewById(2131363913));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.un = ((TextView)localView.findViewById(2131363968));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.lt = ((ImageView)localView.findViewById(2131365996));
  }
  
  public ReplyView a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.a(paramString);
  }
  
  public LinearLayout f()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer;
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
      if ((this.jdField_a_of_type_Sdw != null) && (this.g != null))
      {
        this.jdField_a_of_type_Sdw.a(paramView, 1, this.mPosition, this.g.postUser);
        continue;
        if ((this.jdField_a_of_type_Sdw != null) && (this.g != null))
        {
          this.jdField_a_of_type_Sdw.a(paramView, 2, this.mPosition, this.g.postUser);
          continue;
          if (this.jdField_a_of_type_Sdw != null) {
            this.jdField_a_of_type_Sdw.a(paramView, 4, this.mPosition, this.g);
          }
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Sdw != null) {
      this.jdField_a_of_type_Sdw.b(paramView, 5, this.mPosition, this.g);
    }
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StComment paramStComment, int paramInt, String paramString)
  {
    this.g = paramStComment;
    if (paramStComment == null) {
      return;
    }
    if (paramStComment.postUser != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStComment.postUser.id.get())) && (aqmr.isEmpty(paramStComment.postUser.icon.get())))
      {
        if (this.cS == null) {
          this.cS = new BitmapDrawable(aqhu.r(sdu.a(sdu.a(null, 1, paramStComment.postUser.id.get(), 0)).bmp, 50, 50));
        }
        rpq.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 18.0F), this.cS, null);
        this.uk.setText(paramStComment.postUser.nick.get());
        if (!paramStComment.postUser.id.get().equals(paramString)) {
          break label393;
        }
        if (this.cR == null)
        {
          this.cR = getResources().getDrawable(2130851969);
          this.cR.setBounds(0, 0, ImmersiveUtils.dpToPx(21.0F), ImmersiveUtils.dpToPx(12.0F));
        }
        this.uk.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0F));
        this.uk.setCompoundDrawables(null, null, this.cR, null);
      }
    }
    else
    {
      label250:
      this.c.setText(paramStComment.content.get());
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ka.setText(sdl.aN(paramStComment.createTime.get() * 1000L));
      a(paramStComment, false);
      if (this.g.vecReply.size() != 0) {
        break label407;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
      label316:
      this.axo = false;
      paramStComment = this.mLikeContainer;
      if (!sdj.MC()) {
        break label491;
      }
    }
    label393:
    label407:
    label491:
    for (paramInt = 0;; paramInt = 8)
    {
      paramStComment.setVisibility(paramInt);
      return;
      rpq.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramStComment.postUser.icon.get(), rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 18.0F), aqhu.at(), null);
      break;
      this.uk.setCompoundDrawables(null, null, null, null);
      break label250;
      if (this.g.vecReply.size() > 0)
      {
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setData(this.g, paramInt, paramString);
          this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
          a(paramStComment, true);
          break label316;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setData(this.g, paramInt, paramString);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(0);
        break label316;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(8);
      break label316;
    }
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.bfa = paramInt;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setDisplayNum(paramInt);
  }
  
  public void setOnCommentElementClickListener(sdw paramsdw)
  {
    this.jdField_a_of_type_Sdw = paramsdw;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setOnCommentElementClickListener(paramsdw);
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ex != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentView$a.ex.setOnClickListener(new sdk(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setPosition(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentView
 * JD-Core Version:    0.7.0.1
 */