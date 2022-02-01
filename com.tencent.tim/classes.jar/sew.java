import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sew
  implements View.OnClickListener
{
  public sew(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    san localsan;
    if ((SubscribeVideoDetailFragment.a(this.this$0) != null) && (SubscribeVideoDetailFragment.a(this.this$0) != null))
    {
      localsan = SubscribeVideoDetailFragment.a(this.this$0).a(1);
      bool1 = bool2;
      if (SubscribeVideoDetailFragment.a(this.this$0).ML()) {
        if (SubscribeVideoDetailFragment.a(this.this$0).isFullScreen()) {
          break label88;
        }
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localsan.aKK = bool1;
      this.this$0.a(localsan);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sew
 * JD-Core Version:    0.7.0.1
 */