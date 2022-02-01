import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vlm
  implements Observer<vxq<List<FeedCloudMeta.StFeed>>>
{
  public vlm(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void a(@Nullable vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    if (paramvxq != null) {
      QLog.d(QCircleBaseTabFragment.a, 4, "initViewData:getFeedListRequestRsp_" + this.a.a() + ",state:" + paramvxq.a());
    }
    this.a.a(paramvxq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlm
 * JD-Core Version:    0.7.0.1
 */