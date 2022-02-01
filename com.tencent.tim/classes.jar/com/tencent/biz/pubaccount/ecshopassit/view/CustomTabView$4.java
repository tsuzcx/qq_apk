package com.tencent.biz.pubaccount.ecshopassit.view;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqmr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import rpq;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;

class CustomTabView$4
  implements Runnable
{
  CustomTabView$4(CustomTabView paramCustomTabView, qq_ad.QQAdGetRsp.RedPointInfo paramRedPointInfo, ImageView paramImageView, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    Object localObject = this.a.red_url.get();
    this.hR.setVisibility(0);
    this.hR.setTag(Integer.valueOf(this.a.task_id.get()));
    if (aqmr.isEmpty((String)localObject))
    {
      this.hR.setImageResource(2130844328);
      this.hR.getLayoutParams().width = rpq.dip2px(CustomTabView.a(this.this$0), 9.0F);
      this.hR.getLayoutParams().height = rpq.dip2px(CustomTabView.a(this.this$0), 9.0F);
      ((RelativeLayout.LayoutParams)this.hR.getLayoutParams()).leftMargin = (-rpq.dip2px(CustomTabView.a(this.this$0), 8.0F));
      return;
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      try
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (this.a.red_type.get() == 1)
        {
          this.this$0.bT(this.eD);
          this.hR.getLayoutParams().width = rpq.dip2px(CustomTabView.a(this.this$0), 63.0F);
          this.hR.getLayoutParams().height = rpq.dip2px(CustomTabView.a(this.this$0), 18.0F);
          ((RelativeLayout.LayoutParams)this.hR.getLayoutParams()).topMargin = (-rpq.dip2px(CustomTabView.a(this.this$0), 3.0F));
          ((RelativeLayout.LayoutParams)this.hR.getLayoutParams()).leftMargin = (-rpq.dip2px(CustomTabView.a(this.this$0), 10.0F));
          localURLDrawableOptions.mRequestWidth = rpq.dip2px(CustomTabView.a(this.this$0), 63.0F);
          localURLDrawableOptions.mRequestHeight = rpq.dip2px(CustomTabView.a(this.this$0), 20.0F);
          localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
          if (localObject == null) {
            break;
          }
          this.hR.setImageDrawable((Drawable)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(localException));
        return;
      }
      this.hR.getLayoutParams().width = rpq.dip2px(CustomTabView.a(this.this$0), 9.0F);
      this.hR.getLayoutParams().height = rpq.dip2px(CustomTabView.a(this.this$0), 9.0F);
      ((RelativeLayout.LayoutParams)this.hR.getLayoutParams()).leftMargin = (-rpq.dip2px(CustomTabView.a(this.this$0), 8.0F));
      localURLDrawableOptions.mRequestWidth = rpq.dip2px(CustomTabView.a(this.this$0), 9.0F);
      localURLDrawableOptions.mRequestHeight = rpq.dip2px(CustomTabView.a(this.this$0), 9.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView.4
 * JD-Core Version:    0.7.0.1
 */