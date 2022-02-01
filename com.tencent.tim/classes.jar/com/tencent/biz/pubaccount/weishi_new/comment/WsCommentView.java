package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
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
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import ohw;
import ooz;
import rpq;
import sdl;
import sds;
import sdu;
import sdw;

public class WsCommentView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public a a;
  public WsReplyContainer a;
  FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private sdw jdField_a_of_type_Sdw;
  private boolean axo;
  private int bfa;
  private Drawable cR;
  private Drawable cS;
  private stSimpleMetaComment e;
  RelativeLayout fE;
  ImageView ls;
  View mDivider;
  View mLikeContainer;
  private int mPosition;
  TextView uk;
  TextView ul;
  
  public WsCommentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WsCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WsCommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    bindEvents();
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ex != null))
    {
      if ((!paramBoolean) || (paramstSimpleMetaComment == null) || (paramstSimpleMetaComment.replyList.size() <= 0)) {
        break label127;
      }
      String str = sdl.aN(paramstSimpleMetaComment.createtime * 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ex.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.lt.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ka.setText(str);
      if (paramstSimpleMetaComment.replyList.size() > 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.um.setText(paramstSimpleMetaComment.replyNum + acfp.m(2131704213));
      }
    }
    return;
    label127:
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ex.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.lt.setVisibility(8);
  }
  
  private void bindEvents()
  {
    this.fE.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.uk.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.mLikeContainer.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnLongClickListener(this);
    this.fE.setOnLongClickListener(this);
  }
  
  private void initView()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560191, this, true);
    this.fE = ((RelativeLayout)localView.findViewById(2131364998));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131363175));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.uk = ((TextView)localView.findViewById(2131373533));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131373526));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer = ((WsReplyContainer)localView.findViewById(2131377134));
    this.mLikeContainer = localView.findViewById(2131370440);
    this.ls = ((ImageView)localView.findViewById(2131370437));
    this.ul = ((TextView)localView.findViewById(2131370441));
    this.mDivider = localView.findViewById(2131365990);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a = new a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.dX = ((LinearLayout)localView.findViewById(2131378305));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ka = ((TextView)localView.findViewById(2131365005));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.um = ((TextView)localView.findViewById(2131371958));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ex = ((LinearLayout)localView.findViewById(2131363913));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.un = ((TextView)localView.findViewById(2131363968));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.lt = ((ImageView)localView.findViewById(2131365996));
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Sdw != null) && (this.e != null))
      {
        this.jdField_a_of_type_Sdw.a(paramView, 1, this.mPosition, this.e.poster);
        continue;
        if ((this.jdField_a_of_type_Sdw != null) && (this.e != null))
        {
          this.jdField_a_of_type_Sdw.a(paramView, 2, this.mPosition, this.e.poster);
          continue;
          if (this.jdField_a_of_type_Sdw != null)
          {
            this.jdField_a_of_type_Sdw.a(paramView, 4, this.mPosition, this.e);
            continue;
            if (this.jdField_a_of_type_Sdw != null)
            {
              this.axo = true;
              label194:
              stSimpleMetaComment localstSimpleMetaComment;
              if (this.e.isDing == 1)
              {
                ooz.w("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + this.e.isDing);
                qH(bool);
                if (bool) {
                  break label377;
                }
                ooz.w("comment", "执行点赞 ...............");
                localstSimpleMetaComment = this.e;
                localstSimpleMetaComment.dingNum += 1L;
                this.ul.setText(sds.aO(this.e.dingNum));
              }
              for (;;)
              {
                this.e.isDing = ((this.e.isDing + 1) % 2);
                ooz.w("comment", "点赞后 mComment.isDing：" + this.e.isDing + ",clickPosition:" + this.mPosition);
                this.jdField_a_of_type_Sdw.a(paramView, 6, this.mPosition, this.e);
                break;
                bool = false;
                break label194;
                label377:
                if (this.e.dingNum > 1L)
                {
                  ooz.w("comment", "执行点赞-1 ...............");
                  localstSimpleMetaComment = this.e;
                  localstSimpleMetaComment.dingNum -= 1L;
                  this.ul.setText(sds.aO(this.e.dingNum));
                }
                else
                {
                  localstSimpleMetaComment = this.e;
                  localstSimpleMetaComment.dingNum -= 1L;
                  ooz.w("comment", "执行取消点赞 ...............");
                  this.ul.setText("");
                }
              }
            }
            ooz.w("comment", "mOnCommentElementClickListener is null ...............");
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
      this.jdField_a_of_type_Sdw.b(paramView, 5, this.mPosition, this.e);
    }
    return true;
  }
  
  public void qH(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.ls.setImageResource(2130851935);
      this.ul.setTextColor(getResources().getColor(2131165381));
      return;
    }
    this.ls.setImageResource(2130851936);
    this.ul.setTextColor(getResources().getColor(2131165857));
  }
  
  public void setData(stSimpleMetaComment paramstSimpleMetaComment, int paramInt, String paramString)
  {
    this.e = paramstSimpleMetaComment;
    if (paramstSimpleMetaComment == null) {
      return;
    }
    label235:
    boolean bool;
    if (paramstSimpleMetaComment.poster != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstSimpleMetaComment.poster.id)) && (aqmr.isEmpty(paramstSimpleMetaComment.poster.avatar)))
      {
        if (this.cS == null) {
          this.cS = new BitmapDrawable(aqhu.r(sdu.a(sdu.a(null, 1, paramstSimpleMetaComment.poster.id, 0)).bmp, 50, 50));
        }
        rpq.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 18.0F), this.cS, null);
        this.uk.setText(paramstSimpleMetaComment.poster.nick);
        if (!paramstSimpleMetaComment.poster.id.equals(paramString)) {
          break label402;
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
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstSimpleMetaComment.wording);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ka.setText(sdl.aN(paramstSimpleMetaComment.createtime * 1000L));
      a(paramstSimpleMetaComment, false);
      if (this.e.replyList.size() != 0) {
        break label416;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
      label296:
      if (this.e.isDing != 0) {
        break label500;
      }
      bool = true;
      label309:
      qH(bool);
      if (paramstSimpleMetaComment.dingNum <= 0L) {
        break label506;
      }
      this.ul.setText(sds.aO(paramstSimpleMetaComment.dingNum));
    }
    for (;;)
    {
      this.axo = false;
      this.mLikeContainer.setVisibility(0);
      return;
      rpq.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstSimpleMetaComment.poster.avatar, rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 18.0F), aqhu.at(), null);
      break;
      label402:
      this.uk.setCompoundDrawables(null, null, null, null);
      break label235;
      label416:
      if (this.e.replyList.size() > 0)
      {
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setData(this.e, paramInt, paramString);
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
          a(paramstSimpleMetaComment, true);
          break label296;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setData(this.e, paramInt, paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(0);
        break label296;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(8);
      break label296;
      label500:
      bool = false;
      break label309;
      label506:
      this.ul.setText("");
    }
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.bfa = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setDisplayNum(paramInt);
  }
  
  public void setOnCommentElementClickListener(sdw paramsdw)
  {
    this.jdField_a_of_type_Sdw = paramsdw;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setOnCommentElementClickListener(paramsdw);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ex != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentView$a.ex.setOnClickListener(new ohw(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setPosition(paramInt);
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView
 * JD-Core Version:    0.7.0.1
 */