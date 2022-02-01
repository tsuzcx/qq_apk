import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Arrays;

public class vpt
  implements Observer<vxq<FeedCloudRead.StGetMainPageRsp>>
{
  public vpt(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void a(@Nullable vxq<FeedCloudRead.StGetMainPageRsp> paramvxq)
  {
    if (paramvxq != null) {
      QLog.d("QCirclePersonalDetailFragment", 1, "Observe StGetMainPageRsp state:" + paramvxq.a());
    }
    try
    {
      QLog.d("QCirclePersonalDetailFragment", 1, "personDetail uiStateData is" + paramvxq.a());
      if ((paramvxq != null) && ((paramvxq.a() == 2) || (paramvxq.a() == 3)))
      {
        if (this.a.a != null)
        {
          QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is not null");
          this.a.a.setDatas(new ArrayList(Arrays.asList(new FeedCloudRead.StGetMainPageRsp[] { (FeedCloudRead.StGetMainPageRsp)paramvxq.a() })));
          this.a.a.notifyLoadingComplete(true);
          return;
        }
        QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is null");
        return;
      }
    }
    catch (Exception paramvxq)
    {
      paramvxq.printStackTrace();
      QLog.e("QCirclePersonalDetailFragment", 1, "personDetail setData error" + paramvxq.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpt
 * JD-Core Version:    0.7.0.1
 */