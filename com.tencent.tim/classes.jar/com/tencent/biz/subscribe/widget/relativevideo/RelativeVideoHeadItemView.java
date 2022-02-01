package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVisitor;
import acfp;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import aqmr;
import aqmu;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import rpq;

public class RelativeVideoHeadItemView
  extends RelativeFeedBaseHeaderView
{
  private TextView Ae;
  private TextView Ag;
  private TextView Ah;
  private TextView Ao;
  private AsyncRichTextView f;
  private View qd;
  
  public RelativeVideoHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void P(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    this.Ae.setText(paramObject.title.get());
    Object localObject = this.Ae;
    if (paramObject.title.get().trim().length() > 0)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      this.Ao.setText(aqmu.o(getContext(), paramObject.createTime.get() * 1000L));
      i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
      if (i <= 0) {
        break label241;
      }
      this.Ag.setVisibility(0);
      this.Ag.setText(rpq.aL(i) + acfp.m(2131720660));
      label139:
      localObject = this.f;
      if (paramObject.content.get().trim().length() <= 0) {
        break label253;
      }
    }
    label241:
    label253:
    for (int i = 0;; i = 8)
    {
      ((AsyncRichTextView)localObject).setVisibility(i);
      this.f.setText(paramObject.content.get());
      if (aqmr.isEmpty(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get())) {
        break label259;
      }
      this.qd.setVisibility(0);
      this.Ah.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
      i = 8;
      break;
      this.Ag.setVisibility(8);
      break label139;
    }
    label259:
    this.qd.setVisibility(8);
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.Ae = ((TextView)findViewById(2131380702));
    this.Ao = ((TextView)findViewById(2131380699));
    this.Ag = ((TextView)findViewById(2131380703));
    this.f = ((AsyncRichTextView)findViewById(2131380693));
    this.qd = findViewById(2131370712);
    this.Ah = ((TextView)findViewById(2131380846));
  }
  
  public int getLayoutId()
  {
    return 2131558868;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView
 * JD-Core Version:    0.7.0.1
 */