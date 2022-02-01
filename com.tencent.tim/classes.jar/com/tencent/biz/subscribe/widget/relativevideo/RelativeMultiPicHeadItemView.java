package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVisitor;
import acfp;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import aqmr;
import aqmu;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import rpq;
import sjj;

public class RelativeMultiPicHeadItemView
  extends BaseWidgetView
{
  private TextView Ae;
  private TextView Af;
  private TextView Ag;
  private TextView Ah;
  private SubscribeBannerView b;
  private AsyncRichTextView f;
  private int mImageHeight;
  private final int mScreenWidth = ImmersiveUtils.getScreenWidth();
  private View qd;
  
  public RelativeMultiPicHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(CertifiedAccountMeta.StImage paramStImage)
  {
    float f1 = 1.333333F;
    float f2;
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      f2 = paramStImage.height.get() / paramStImage.width.get();
      if (f2 <= 1.333333F) {
        break label72;
      }
    }
    for (;;)
    {
      this.mImageHeight = ((int)(f1 * this.mScreenWidth));
      this.b.setBannerHeight(this.mImageHeight);
      return;
      label72:
      f1 = f2;
    }
  }
  
  public void P(Object paramObject)
  {
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    if ((this.b != null) && (paramObject.images.get().size() > 0))
    {
      a((CertifiedAccountMeta.StImage)paramObject.images.get(0));
      this.b.setDatas(paramObject.images.get());
    }
    this.f.setText(paramObject.content.get());
    Object localObject = this.f;
    int i;
    if (paramObject.content.get().trim().isEmpty())
    {
      i = 8;
      ((AsyncRichTextView)localObject).setVisibility(i);
      this.Ae.setText(paramObject.title.get());
      localObject = this.Ae;
      if (!paramObject.title.get().trim().isEmpty()) {
        break label288;
      }
      i = 8;
      label137:
      ((TextView)localObject).setVisibility(i);
      this.Af.setText(aqmu.o(getContext(), paramObject.createTime.get() * 1000L));
      i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
      if (i <= 0) {
        break label293;
      }
      this.Ag.setVisibility(0);
      this.Ag.setText(rpq.aL(i) + acfp.m(2131720660));
    }
    for (;;)
    {
      if (aqmr.isEmpty(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get())) {
        break label305;
      }
      this.qd.setVisibility(0);
      this.Ah.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
      i = 0;
      break;
      label288:
      i = 0;
      break label137;
      label293:
      this.Ag.setVisibility(8);
    }
    label305:
    this.qd.setVisibility(8);
  }
  
  public SubscribeBannerView a()
  {
    return this.b;
  }
  
  public void destroy()
  {
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.Ae = ((TextView)findViewById(2131380702));
    this.Af = ((TextView)findViewById(2131380694));
    this.Ag = ((TextView)findViewById(2131380703));
    this.f = ((AsyncRichTextView)findViewById(2131380693));
    this.qd = findViewById(2131370712);
    this.Ah = ((TextView)findViewById(2131380846));
    this.b = ((SubscribeBannerView)findViewById(2131364145));
    this.b.setAdapter(new sjj(this));
  }
  
  public int getLayoutId()
  {
    return 2131558845;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView
 * JD-Core Version:    0.7.0.1
 */