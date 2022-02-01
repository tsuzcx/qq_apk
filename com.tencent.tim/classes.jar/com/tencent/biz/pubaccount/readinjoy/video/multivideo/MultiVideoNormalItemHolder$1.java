package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.view.ViewGroup;
import aqnm;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import nap;
import nav;

public class MultiVideoNormalItemHolder$1
  implements Runnable
{
  public MultiVideoNormalItemHolder$1(nav paramnav) {}
  
  public void run()
  {
    if (this.this$0.pw != null)
    {
      int i = nap.bu(this.this$0.c.playCount).length();
      int j = aqnm.dip2px(12.0F);
      nav.a(this.this$0).setMaxWidth(nav.a(this.this$0).getWidth() - nav.a(this.this$0).getPaddingLeft() - nav.a(this.this$0).getPaddingRight() - i * j - aqnm.dip2px(30.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.1
 * JD-Core Version:    0.7.0.1
 */