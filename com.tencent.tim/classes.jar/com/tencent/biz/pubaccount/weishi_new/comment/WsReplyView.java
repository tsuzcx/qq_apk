package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import rpq;
import sdj;
import sdl;
import sdu;
import sdw;

public class WsReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String TAG = WsReplyView.class.getName();
  private final String REPLY_STR = acfp.m(2131713900);
  FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private sdw jdField_a_of_type_Sdw;
  private boolean axo;
  private BitmapDrawable jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
  RoundCornerImageView jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private Drawable cR;
  private stSimpleMetaComment jdField_e_of_type_UserGrowthStSimpleMetaComment;
  private stSimpleMetaReply jdField_e_of_type_UserGrowthStSimpleMetaReply;
  LinearLayout ey;
  ImageView ls;
  private int mPosition;
  TextView uk;
  TextView ul;
  TextView uo;
  TextView up;
  
  public WsReplyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WsReplyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WsReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    bindEvents();
  }
  
  private void bindEvents()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.uk.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.uo.setOnClickListener(this);
    this.ey.setOnClickListener(this);
    setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  private void initView()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560195, this, true);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131369668));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.uk = ((TextView)localView.findViewById(2131377156));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)localView.findViewById(2131377154));
    this.up = ((TextView)localView.findViewById(2131377155));
    this.uo = ((TextView)localView.findViewById(2131363967));
    this.ey = ((LinearLayout)localView.findViewById(2131377148));
    this.ls = ((ImageView)localView.findViewById(2131377147));
    this.ul = ((TextView)localView.findViewById(2131377149));
    setPadding(0, 0, 0, Utils.dp2px(5.0D));
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaComment localstSimpleMetaComment;
    stSimpleMetaReply localstSimpleMetaReply;
    switch (paramView.getId())
    {
    default: 
      if ((((paramView instanceof WsReplyView)) || (paramView.getId() == 2131363967)) && (this.jdField_a_of_type_Sdw != null))
      {
        localstSimpleMetaComment = this.jdField_e_of_type_UserGrowthStSimpleMetaComment;
        localstSimpleMetaReply = this.jdField_e_of_type_UserGrowthStSimpleMetaReply;
        this.jdField_a_of_type_Sdw.a(paramView, 7, this.mPosition, new Object[] { localstSimpleMetaComment, localstSimpleMetaReply });
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Sdw != null) && (this.jdField_e_of_type_UserGrowthStSimpleMetaReply != null))
      {
        this.jdField_a_of_type_Sdw.a(paramView, 2, this.mPosition, this.jdField_e_of_type_UserGrowthStSimpleMetaReply.poster);
        continue;
        if (this.jdField_a_of_type_Sdw != null)
        {
          localstSimpleMetaComment = this.jdField_e_of_type_UserGrowthStSimpleMetaComment;
          localstSimpleMetaReply = this.jdField_e_of_type_UserGrowthStSimpleMetaReply;
          this.jdField_a_of_type_Sdw.a(paramView, 7, this.mPosition, new Object[] { localstSimpleMetaComment, localstSimpleMetaReply });
          continue;
          if (this.jdField_a_of_type_Sdw != null)
          {
            localstSimpleMetaComment = this.jdField_e_of_type_UserGrowthStSimpleMetaComment;
            localstSimpleMetaReply = this.jdField_e_of_type_UserGrowthStSimpleMetaReply;
            this.jdField_a_of_type_Sdw.a(paramView, 77, this.mPosition, new Object[] { localstSimpleMetaComment, localstSimpleMetaReply });
          }
        }
      }
    }
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
    stSimpleMetaComment localstSimpleMetaComment = this.jdField_e_of_type_UserGrowthStSimpleMetaComment;
    stSimpleMetaReply localstSimpleMetaReply = this.jdField_e_of_type_UserGrowthStSimpleMetaReply;
    this.jdField_a_of_type_Sdw.b(paramView, 8, this.mPosition, new Object[] { localstSimpleMetaComment, localstSimpleMetaReply });
    return true;
  }
  
  public void setData(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, String paramString)
  {
    this.jdField_e_of_type_UserGrowthStSimpleMetaComment = paramstSimpleMetaComment;
    this.jdField_e_of_type_UserGrowthStSimpleMetaReply = paramstSimpleMetaReply;
    if ((paramstSimpleMetaComment == null) || (paramstSimpleMetaReply == null)) {
      return;
    }
    if (paramstSimpleMetaReply.poster != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstSimpleMetaReply.poster.id)) && (aqmr.isEmpty(paramstSimpleMetaReply.poster.avatar)))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(aqhu.r(sdu.a(sdu.a(null, 1, paramstSimpleMetaReply.poster.id, 0)).bmp, 50, 50));
        }
        rpq.a(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable, null);
        this.uk.setText(paramstSimpleMetaReply.poster.nick);
        if (!paramstSimpleMetaReply.poster.id.equals(paramString)) {
          break label351;
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
      label244:
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramstSimpleMetaReply.wording);
      this.up.setText(sdl.aN(paramstSimpleMetaReply.createtime * 1000L));
      this.axo = false;
      paramstSimpleMetaComment = this.ey;
      if (sdj.MC()) {
        break label365;
      }
    }
    label351:
    label365:
    for (int i = 0;; i = 8)
    {
      paramstSimpleMetaComment.setVisibility(i);
      return;
      rpq.a(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramstSimpleMetaReply.poster.avatar, rpq.dip2px(getContext(), 22.0F), rpq.dip2px(getContext(), 22.0F), rpq.dip2px(getContext(), 11.0F), aqhu.at(), null);
      break;
      this.uk.setCompoundDrawables(null, null, null, null);
      break label244;
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyView
 * JD-Core Version:    0.7.0.1
 */