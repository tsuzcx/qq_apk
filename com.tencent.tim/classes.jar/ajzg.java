import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajzg
  implements View.OnClickListener
{
  public ajzg(VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.a.bhj();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzg
 * JD-Core Version:    0.7.0.1
 */