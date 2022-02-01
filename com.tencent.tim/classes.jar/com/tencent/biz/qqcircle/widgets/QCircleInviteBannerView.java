package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StImage;
import ous;
import pco;
import pga;
import qqcircle.QQCircleDitto.StSinglePicBanner;
import riw;

public class QCircleInviteBannerView
  extends BaseWidgetView
  implements View.OnClickListener
{
  private URLImageView S;
  private a a;
  private RelativeLayout fK;
  
  public QCircleInviteBannerView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      float f = paramStImage.height.get() * 1.0F / paramStImage.width.get();
      int i = riw.getWindowScreenWidth(getContext());
      paramStImage = this.S.getLayoutParams();
      paramStImage.height = ((int)(f * i));
      paramStImage.width = i;
      this.S.setLayoutParams(paramStImage);
    }
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof QQCircleDitto.StSinglePicBanner))
    {
      paramObject = (QQCircleDitto.StSinglePicBanner)paramObject;
      if ((this.S != null) && (paramObject.image.get() != null) && (!TextUtils.isEmpty(paramObject.image.picUrl.get())))
      {
        QLog.d("QCircleInviteBannerPart", 1, "banner url is:" + paramObject.image.picUrl.get());
        a(paramObject.image);
        ous.a(paramObject.image.picUrl.get(), this.S, null, false, new pga(this));
      }
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.S = ((URLImageView)paramView.findViewById(2131369679));
      this.fK = ((RelativeLayout)paramView.findViewById(2131377390));
      this.S.setOnClickListener(this);
      this.fK.setOnClickListener(this);
      this.S.setAdjustViewBounds(true);
    }
  }
  
  public int getLayoutId()
  {
    return 2131560914;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    pco.b("", 22, 14L, 1L);
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
      if (this.a != null) {
        this.a.bhU();
      }
      pco.b("", 22, 14L, 2L);
      continue;
      if (this.a != null) {
        this.a.bhV();
      }
      pco.b("", 22, 14L, 3L);
    }
  }
  
  public void setInviteBannerClickListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bhU();
    
    public abstract void bhV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleInviteBannerView
 * JD-Core Version:    0.7.0.1
 */