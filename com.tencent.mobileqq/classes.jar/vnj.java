import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vnj
  implements Observer<vup<List<FeedCloudMeta.StFeed>>>
{
  public vnj(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void a(@Nullable vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    if (QCirclePersonalBottomView.a(this.a) != null) {
      this.a.removeView(QCirclePersonalBottomView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnj
 * JD-Core Version:    0.7.0.1
 */