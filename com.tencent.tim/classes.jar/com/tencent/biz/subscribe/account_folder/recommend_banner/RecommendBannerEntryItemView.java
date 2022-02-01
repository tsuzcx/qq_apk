package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import rpq;
import rzd;
import rzr;

public class RecommendBannerEntryItemView
  extends RelativeLayout
{
  private CertifiedAccountMeta.StEntry jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private boolean aKG;
  private boolean avA;
  private RoundCornerImageView d;
  private ImageView jn;
  private TextView mActionButton;
  private TextView mTitle;
  
  public RecommendBannerEntryItemView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public RecommendBannerEntryItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public RecommendBannerEntryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  protected void initView(Context paramContext)
  {
    inflate(paramContext, 2131558862, this);
    setMinimumHeight(aqcx.dip2px(paramContext, 213.0F));
    setPadding(aqcx.dip2px(paramContext, 6.0F), aqcx.dip2px(paramContext, 10.0F), aqcx.dip2px(paramContext, 6.0F), aqcx.dip2px(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131363175));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(7.0F));
    this.d = ((RoundCornerImageView)findViewById(2131363190));
    this.d.setCorner(ImmersiveUtils.dpToPx(7.0F));
    this.mTitle = ((TextView)findViewById(2131372369));
    this.mActionButton = ((TextView)findViewById(2131361976));
    this.jn = ((ImageView)findViewById(2131373385));
    setOnClickListener(new rzr(this));
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
  
  public void setEntry(CertifiedAccountMeta.StEntry paramStEntry)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry = paramStEntry;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry == null) {
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry.cover != null) {
      rpq.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry.cover.url.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getHeight(), null, "");
    }
    this.mTitle.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry.title.get());
    if (rzd.fe(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StEntry.type.get()))
    {
      this.jn.setVisibility(0);
      return;
    }
    this.jn.setVisibility(8);
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
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerEntryItemView
 * JD-Core Version:    0.7.0.1
 */