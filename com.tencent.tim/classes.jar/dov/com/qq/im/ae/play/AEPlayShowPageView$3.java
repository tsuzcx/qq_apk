package dov.com.qq.im.ae.play;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import axiy;

class AEPlayShowPageView$3
  implements Runnable
{
  AEPlayShowPageView$3(AEPlayShowPageView paramAEPlayShowPageView, int paramInt) {}
  
  public void run()
  {
    axiy.d("AEPlayShowPart", "in........");
    if (AEPlayShowPageView.a(this.this$0) != null)
    {
      View localView = AEPlayShowPageView.a(this.this$0).findViewByPosition(this.val$pos);
      if (localView != null)
      {
        AEPlayShowPageView.a(this.this$0);
        localView.performClick();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView.3
 * JD-Core Version:    0.7.0.1
 */