import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zin
  implements View.OnClickListener
{
  public zin(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    zda localzda;
    if ((SubscribeVideoDetailFragment.a(this.a) != null) && (SubscribeVideoDetailFragment.a(this.a) != null))
    {
      localzda = SubscribeVideoDetailFragment.a(this.a).a(1);
      bool1 = bool2;
      if (SubscribeVideoDetailFragment.a(this.a).g()) {
        if (SubscribeVideoDetailFragment.a(this.a).i()) {
          break label88;
        }
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localzda.c = bool1;
      this.a.a(localzda);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zin
 * JD-Core Version:    0.7.0.1
 */