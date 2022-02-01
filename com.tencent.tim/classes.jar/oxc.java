import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;

class oxc
  implements View.OnClickListener
{
  oxc(oww.a parama, FeedCloudMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    oux.a(this.b);
    if (paramView == oww.a.a(this.a)) {
      pcl.a(71, 2, oww.a(this.a.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pcl.a(72, 2, oww.a(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxc
 * JD-Core Version:    0.7.0.1
 */