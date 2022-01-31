import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

public class yfj
  implements View.OnClickListener
{
  public yfj(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if ((SubscribeVideoDetailFragment.a(this.a) != null) && (SubscribeVideoDetailFragment.a(this.a) != null))
    {
      paramView = SubscribeVideoDetailFragment.a(this.a).a(1);
      bool1 = bool2;
      if (SubscribeVideoDetailFragment.a(this.a).d()) {
        if (SubscribeVideoDetailFragment.a(this.a).f()) {
          break label78;
        }
      }
    }
    label78:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.c = bool1;
      this.a.a(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfj
 * JD-Core Version:    0.7.0.1
 */