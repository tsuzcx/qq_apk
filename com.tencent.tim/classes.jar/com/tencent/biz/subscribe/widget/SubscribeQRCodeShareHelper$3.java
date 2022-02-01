package com.tencent.biz.subscribe.widget;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import ayxa;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import sio;
import siq;
import sir;

public class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  public SubscribeQRCodeShareHelper$3(sio paramsio, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    sio.a(this.this$0, false);
    int j = this.this$0.a.lg.getHeight();
    int k = this.this$0.a.abA.getHeight();
    if (!ankt.bA(sio.a(this.this$0))) {}
    for (int i = ankt.getRealHeight(sio.a(this.this$0));; i = ankt.cIE)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - ayxa.getStatusBarHeight(sio.a(this.this$0)) - (k + j));
      this.this$0.a.setAdvBgColor(Color.parseColor("#00000000"));
      RelativeLayout localRelativeLayout = new RelativeLayout(sio.a(this.this$0));
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      localRelativeLayout.setBackgroundColor(0);
      localRelativeLayout.setOnClickListener(new siq(this));
      ImageView localImageView = new ImageView(sio.a(this.this$0));
      localImageView.setOnClickListener(new sir(this));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(ankt.dip2px(225.0F), ankt.dip2px(420.0F));
      localLayoutParams2.addRule(13);
      localRelativeLayout.addView(localImageView, localLayoutParams2);
      localImageView.setImageBitmap(this.b.ab());
      this.this$0.a.setAdvView(localRelativeLayout, localLayoutParams1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */