package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.widget.ImageView;
import aqcx;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import nqe;

public class RefreshAnimView$3$2
  implements Runnable
{
  public RefreshAnimView$3$2(nqe paramnqe) {}
  
  public void run()
  {
    float f = aqcx.dip2px(this.a.this$0.getContext(), 44.0F) / 88.0F;
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(RefreshAnimView.a(this.a.this$0));
    localLottieDrawable.loop(false);
    RefreshAnimView.a(this.a.this$0).setImageDrawable(localLottieDrawable);
    RefreshAnimView.a(this.a.this$0).invalidate();
    RefreshAnimView.a(this.a.this$0).setScaleX(f);
    RefreshAnimView.a(this.a.this$0).setScaleY(f);
    RefreshAnimView.a(this.a.this$0).setPivotX(RefreshAnimView.a(this.a.this$0).getWidth() / 2);
    RefreshAnimView.a(this.a.this$0).setPivotY(RefreshAnimView.a(this.a.this$0).getHeight() / 2);
    localLottieDrawable.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3.2
 * JD-Core Version:    0.7.0.1
 */