import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseAggregationFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vje
  implements Observer<vup<List<FeedCloudMeta.StFeed>>>
{
  public vje(QCircleBaseAggregationFragment paramQCircleBaseAggregationFragment) {}
  
  public void a(@Nullable vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    if (paramvup != null) {
      QLog.d(QCircleBaseAggregationFragment.a, 4, "initViewData:getFeedListRequestRsp_" + this.a.a() + ",state:" + paramvup.a());
    }
    this.a.a(paramvup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vje
 * JD-Core Version:    0.7.0.1
 */