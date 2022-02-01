package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ankt;
import aqcx;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.AddFollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import rwv;
import rwx;
import ryx;
import rzd;
import rzs;
import rzt;
import rzu;
import sgs;
import sha;
import sqn;

public class RecommendBannerFeedItemView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, rwx
{
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private AddFollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView;
  private boolean aKG;
  private boolean avA;
  private RoundCornerImageView e;
  private TextView mDesc;
  private CertifiedAccountMeta.StFeed mFeed;
  private TextView mName;
  private int mPosition;
  
  public RecommendBannerFeedItemView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public RecommendBannerFeedItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public RecommendBannerFeedItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void initView(Context paramContext)
  {
    inflate(paramContext, 2131558863, this);
    setId(2131364401);
    setMinimumHeight(aqcx.dip2px(paramContext, 213.0F));
    setPadding(aqcx.dip2px(paramContext, 6.0F), aqcx.dip2px(paramContext, 10.0F), aqcx.dip2px(paramContext, 6.0F), aqcx.dip2px(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.e = ((RoundCornerImageView)findViewById(2131365477));
    this.e.setCorner(ImmersiveUtils.dpToPx(6.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131363175));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(24.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBorder(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBorderWidth(ImmersiveUtils.dpToPx(2.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = ankt.dip2px(26.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ankt.dip2px(26.0F);
    this.mName = ((TextView)findViewById(2131372190));
    this.mDesc = ((TextView)findViewById(2131365721));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView = ((AddFollowTextView)findViewById(2131367405));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setItemPreClickListener(new rzs(this));
    setOnClickListener(this);
    setOnLongClickListener(this);
  }
  
  protected void onAttachedToWindow()
  {
    rwv.a().a(this);
    super.onAttachedToWindow();
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
      rzd.a(null, this.mFeed);
      sqn.b(this.mFeed.poster.id.get(), "auth_page", "recom_head_b", 0, 0, new String[] { "", this.mPosition + "", this.mFeed.poster.nick.get(), this.mFeed.title.get() });
    }
  }
  
  protected void onDetachedFromWindow()
  {
    rwv.a().b(this);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getWidth();
    int m = getPaddingRight();
    int n = getHeight();
    int i1 = getPaddingBottom();
    Paint localPaint = new Paint();
    if (this.avA) {
      localPaint.setColor(-15263977);
    }
    for (;;)
    {
      if (!this.aKG)
      {
        i2 = aqcx.dip2px(getContext(), 5.0F);
        localPaint.setShadowLayer(aqcx.dip2px(getContext(), 15.0F), 0, i2, 436207616);
      }
      int i2 = aqcx.dip2px(getContext(), 6.0F);
      paramCanvas.drawRoundRect(new RectF(i, j, k - m, n - i1), i2, i2, localPaint);
      super.onDraw(paramCanvas);
      return;
      localPaint.setColor(-1);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return false;
    } while (this.mFeed == null);
    sgs.a(getContext(), this.mFeed, new rzt(this), new rzu(this));
    sqn.b(this.mFeed.poster.id.get(), "auth_page", "recom_remove", 0, 0, new String[] { "", this.mPosition + "", this.mFeed.poster.nick.get(), this.mFeed.title.get() });
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.mFeed != null) && (TextUtils.equals(((FollowUpdateEvent)paramSimpleBaseEvent).useId, this.mFeed.poster.id.get()))) {
      this.mFeed.poster.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
    }
  }
  
  public void setData(CertifiedAccountMeta.StFeed paramStFeed, int paramInt)
  {
    if ((paramStFeed == null) || (!paramStFeed.has())) {}
    while ((this.mFeed != null) && (TextUtils.equals(this.mFeed.id.get(), paramStFeed.id.get()))) {
      return;
    }
    this.mFeed = paramStFeed;
    this.mPosition = paramInt;
    ryx.b(this.mFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
    this.mName.setText(this.mFeed.poster.nick.get());
    this.mDesc.setText(this.mFeed.title.get());
    if (this.mFeed.cover.width.get() > this.mFeed.cover.height.get())
    {
      sha.b(this.mFeed.cover.url.get(), this.e);
      if (this.mFeed.poster.followState.get() != 1) {
        break label294;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setVisibility(8);
    }
    for (;;)
    {
      sqn.b(this.mFeed.poster.id.get(), "auth_page", "recom_exp_b", 0, 0, new String[] { "", this.mPosition + "", this.mFeed.poster.nick.get(), this.mFeed.title.get() });
      return;
      ryx.b(this.mFeed.cover.url.get(), this.e);
      break;
      label294:
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAddFollowTextView.setUserData((CertifiedAccountMeta.StUser)this.mFeed.poster.get());
    }
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
  }
  
  public void setIsCloseShadow(boolean paramBoolean)
  {
    this.aKG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView
 * JD-Core Version:    0.7.0.1
 */