package dov.com.qq.im.ae.play;

import android.content.Context;
import android.widget.ProgressBar;
import axgq;
import com.tencent.mobileqq.widget.QQToast;

public class AEPlayShowGridViewHolder$4
  implements Runnable
{
  public AEPlayShowGridViewHolder$4(axgq paramaxgq, boolean paramBoolean) {}
  
  public void run()
  {
    axgq.a(this.this$0).setVisibility(8);
    if (!this.val$isSuccess) {
      QQToast.a(axgq.q(), axgq.q().getString(2131718353), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.4
 * JD-Core Version:    0.7.0.1
 */