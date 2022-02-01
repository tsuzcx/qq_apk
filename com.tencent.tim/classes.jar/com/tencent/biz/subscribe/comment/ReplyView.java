package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import rpq;
import sdj;
import sdl;
import sdu;
import sdw;

public class ReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String TAG = ReplyView.class.getName();
  private final String REPLY_STR = acfp.m(2131713900);
  private sdw a;
  private boolean axo;
  private BitmapDrawable jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
  RoundCornerImageView jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  AsyncRichTextView c;
  private Drawable cR;
  LinearLayout ey;
  private CertifiedAccountMeta.StComment jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StReply jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  ImageView ls;
  private int mPosition;
  TextView uk;
  TextView ul;
  TextView uo;
  TextView up;
  
  public ReplyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReplyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    bindEvents();
  }
  
  private String am(String paramString1, String paramString2)
  {
    try
    {
      String str = URLEncoder.encode(paramString2, "UTF-8");
      paramString2 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "build nickname partially failed" + localException);
      }
    }
    return "<uin:" + paramString1 + ",nickname:" + paramString2 + ">";
  }
  
  private void bindEvents()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.uk.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.uo.setOnClickListener(this);
    this.ey.setOnClickListener(this);
    setOnClickListener(this);
    this.c.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  private void initView()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558885, this, true);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131369668));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.uk = ((TextView)localView.findViewById(2131377156));
    this.c = ((AsyncRichTextView)localView.findViewById(2131377154));
    this.c.setNeedParseColor(true);
    this.up = ((TextView)localView.findViewById(2131377155));
    this.uo = ((TextView)localView.findViewById(2131363967));
    this.ey = ((LinearLayout)localView.findViewById(2131377148));
    this.ls = ((ImageView)localView.findViewById(2131377147));
    this.ul = ((TextView)localView.findViewById(2131377149));
    setPadding(0, 0, 0, Utils.dp2px(5.0D));
  }
  
  public void onClick(View paramView)
  {
    CertifiedAccountMeta.StComment localStComment;
    CertifiedAccountMeta.StReply localStReply;
    switch (paramView.getId())
    {
    default: 
      if ((((paramView instanceof ReplyView)) || (paramView.getId() == 2131363967)) && (this.a != null))
      {
        localStComment = this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
        localStReply = this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
        this.a.a(paramView, 7, this.mPosition, new Object[] { localStComment, localStReply });
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a != null) && (this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null))
      {
        this.a.a(paramView, 1, this.mPosition, this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser);
        continue;
        if ((this.a != null) && (this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null))
        {
          this.a.a(paramView, 2, this.mPosition, this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser);
          continue;
          if (this.a != null)
          {
            localStComment = this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
            localStReply = this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
            this.a.a(paramView, 7, this.mPosition, new Object[] { localStComment, localStReply });
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
    } while (this.a == null);
    CertifiedAccountMeta.StComment localStComment = this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
    CertifiedAccountMeta.StReply localStReply = this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
    this.a.b(paramView, 8, this.mPosition, new Object[] { localStComment, localStReply });
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, String paramString)
  {
    this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = paramStComment;
    this.jdField_g_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = paramStReply;
    if ((paramStComment == null) || (paramStReply == null)) {
      return;
    }
    if (paramStReply.postUser != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStReply.postUser.id.get())) && (aqmr.isEmpty(paramStReply.postUser.icon.get())))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(aqhu.r(sdu.a(sdu.a(null, 1, paramStReply.postUser.id.get(), 0)).bmp, 50, 50));
        }
        rpq.a(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 35.0F), rpq.dip2px(getContext(), 18.0F), this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable, null);
        this.uk.setText(paramStReply.postUser.nick.get());
        if (!paramStReply.postUser.id.get().equals(paramString)) {
          break label539;
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
      label259:
      paramString = new StringBuilder();
      if ((paramStComment != null) && (paramStReply.targetUser != null) && (!paramStComment.postUser.id.get().equals(paramStReply.targetUser.id.get())))
      {
        paramString.append("{text:").append(this.REPLY_STR).append(",color:").append(Integer.toHexString(getResources().getColor(2131167473))).append(",useDefaultFont:1,useSuperFont:0}");
        paramString.append(am(paramStReply.targetUser.id.get(), paramStReply.targetUser.nick.get()));
        paramString.append("{text:").append("：").append(",color:").append(Integer.toHexString(getResources().getColor(2131167474))).append(",useDefaultFont:1,useSuperFont:0}");
      }
      paramString.append(paramStReply.content.get());
      this.c.setText(paramString);
      this.up.setText(sdl.aN(paramStReply.createTime.get() * 1000L));
      this.axo = false;
      paramStComment = this.ey;
      if (sdj.MC()) {
        break label553;
      }
    }
    label539:
    label553:
    for (int i = 0;; i = 8)
    {
      paramStComment.setVisibility(i);
      return;
      rpq.a(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramStReply.postUser.icon.get(), rpq.dip2px(getContext(), 22.0F), rpq.dip2px(getContext(), 22.0F), rpq.dip2px(getContext(), 11.0F), aqhu.at(), null);
      break;
      this.uk.setCompoundDrawables(null, null, null, null);
      break label259;
    }
  }
  
  public void setOnCommentElementClickListener(sdw paramsdw)
  {
    this.a = paramsdw;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyView
 * JD-Core Version:    0.7.0.1
 */