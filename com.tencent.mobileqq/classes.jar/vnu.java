import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalPushFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vnu
  implements Observer<vup<List<FeedCloudMeta.StFeed>>>
{
  public vnu(QCirclePersonalPushFragment paramQCirclePersonalPushFragment) {}
  
  public void a(@Nullable vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    QLog.d("QCirclePersonalPushFragment", 4, "initViewData:getFeedListRequestRsp");
    this.a.a(paramvup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnu
 * JD-Core Version:    0.7.0.1
 */