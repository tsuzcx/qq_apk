package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.animation.AnimationUtils;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;

class ReadinjoyTabFrame$16
  implements Runnable
{
  ReadinjoyTabFrame$16(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void run()
  {
    if (ReadinjoyTabFrame.b(this.this$0) != null)
    {
      ReadinjoyTabFrame.b(this.this$0).setAnimation(AnimationUtils.loadAnimation(this.this$0.a(), 2130772393));
      ReadinjoyTabFrame.b(this.this$0).setVisibility(8);
      aqmj.cO(this.this$0.a(), this.this$0.app.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.16
 * JD-Core Version:    0.7.0.1
 */