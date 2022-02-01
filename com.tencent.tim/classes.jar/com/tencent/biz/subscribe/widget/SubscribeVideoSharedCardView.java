package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import san;

public class SubscribeVideoSharedCardView
  extends SubscribeMultiPicSharedCardView
{
  private ImageView oi;
  
  public SubscribeVideoSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubscribeVideoSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubscribeVideoSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(san paramsan, Bitmap paramBitmap, AbsSubscribeShareCardView.a parama)
  {
    super.a(paramsan, paramBitmap, parama);
    paramsan = paramsan.a();
    a(this.aL, paramsan.cover.width.get(), paramsan.cover.height.get());
    this.nZ.add(paramsan.poster.icon.get());
    this.oa.add(this.m);
    this.nZ.add(paramsan.cover.url.get());
    this.oa.add(this.a);
    a(this.nZ, this.oa, parama);
  }
  
  public void u(View paramView)
  {
    super.u(paramView);
    this.oi = ((ImageView)this.pZ.findViewById(2131364411));
    this.oi.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeVideoSharedCardView
 * JD-Core Version:    0.7.0.1
 */