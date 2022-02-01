import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vjj
  implements Observer<vup<List<FeedCloudMeta.StFeed>>>
{
  public vjj(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void a(@Nullable vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    if (paramvup != null) {
      QLog.d(QCircleBaseTabFragment.a, 4, "initViewData:getFeedListRequestRsp_" + this.a.a() + ",state:" + paramvup.a());
    }
    this.a.a(paramvup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjj
 * JD-Core Version:    0.7.0.1
 */