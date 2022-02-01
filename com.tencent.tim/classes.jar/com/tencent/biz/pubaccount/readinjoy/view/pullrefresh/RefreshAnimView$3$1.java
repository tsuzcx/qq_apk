package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import nqe;

public class RefreshAnimView$3$1
  implements Runnable
{
  public RefreshAnimView$3$1(nqe paramnqe) {}
  
  public void run()
  {
    RefreshAnimView.a(this.a.this$0).setText(this.a.val$text);
    if (this.a.val$isSuccess) {
      RefreshAnimView.a(this.a.this$0).setCompoundDrawablesWithIntrinsicBounds(2130850296, 0, 0, 0);
    }
    for (;;)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setFillAfter(true);
      RefreshAnimView.a(this.a.this$0).startAnimation(localAlphaAnimation);
      return;
      RefreshAnimView.a(this.a.this$0).setCompoundDrawablesWithIntrinsicBounds(2130850297, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3.1
 * JD-Core Version:    0.7.0.1
 */