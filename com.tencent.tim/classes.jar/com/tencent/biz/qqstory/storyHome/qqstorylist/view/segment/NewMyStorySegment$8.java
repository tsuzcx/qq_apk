package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import qwm;
import qzh;
import rpq;

public class NewMyStorySegment$8
  implements Runnable
{
  public NewMyStorySegment$8(qzh paramqzh, TextView paramTextView, View paramView, ImageView paramImageView) {}
  
  public void run()
  {
    this.ya.setText(qzh.a(this.this$0, qzh.a(this.this$0), this.oz.getWidth() - this.nc.getWidth() - rpq.dip2px(qzh.a(this.this$0), 70.0F), this.ya.getPaint()));
    if (qzh.a(this.this$0).bop > 0)
    {
      this.ya.setTextColor(-65536);
      return;
    }
    this.ya.setTextColor(qzh.b(this.this$0).getResources().getColor(2131167393));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.8
 * JD-Core Version:    0.7.0.1
 */