import android.os.Handler;
import android.os.Looper;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.1;
import dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2;

public class aytm
{
  private volatile boolean aHB;
  private Handler el;
  
  public void a(aykb.b paramb, View paramView, boolean paramBoolean, int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    if (this.aHB) {
      return;
    }
    this.aHB = true;
    if (this.el == null) {
      this.el = new Handler(Looper.getMainLooper());
    }
    int i;
    for (;;)
    {
      i = 0;
      while (i < paramInt1 - paramInt2)
      {
        this.el.postDelayed(new VoteDashItem.1(this, paramb, paramView), i);
        i += paramInt2;
      }
      this.el.removeCallbacksAndMessages(null);
    }
    this.el.postDelayed(new VoteDashItem.2(this, paramb, paramBoolean, paramView, paramRunnable), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytm
 * JD-Core Version:    0.7.0.1
 */