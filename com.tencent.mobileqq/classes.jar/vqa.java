import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalPushFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vqa
  implements Observer<vxq<List<FeedCloudMeta.StFeed>>>
{
  public vqa(QCirclePersonalPushFragment paramQCirclePersonalPushFragment) {}
  
  public void a(@Nullable vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    QLog.d("QCirclePersonalPushFragment", 4, "initViewData:getFeedListRequestRsp");
    this.a.a(paramvxq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqa
 * JD-Core Version:    0.7.0.1
 */