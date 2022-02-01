package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.view.View;
import aykb.b;
import aytm;

public class VoteDashItem$2
  implements Runnable
{
  public VoteDashItem$2(aytm paramaytm, aykb.b paramb, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    aykb.b localb;
    if (this.b.aHB != this.dwH)
    {
      localb = this.b;
      if (this.b.aHB) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localb.aHB = bool;
      this.val$container.invalidate();
      if (this.val$runnable != null) {
        this.val$runnable.run();
      }
      aytm.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2
 * JD-Core Version:    0.7.0.1
 */