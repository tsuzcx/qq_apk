import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vpo
  implements Observer<vxq<List<FeedCloudMeta.StFeed>>>
{
  public vpo(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void a(@Nullable vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    if (QCirclePersonalBottomView.a(this.a) != null) {
      this.a.removeView(QCirclePersonalBottomView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpo
 * JD-Core Version:    0.7.0.1
 */