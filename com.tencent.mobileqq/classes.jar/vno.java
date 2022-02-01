import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Arrays;

public class vno
  implements Observer<vup<FeedCloudRead.StGetMainPageRsp>>
{
  public vno(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void a(@Nullable vup<FeedCloudRead.StGetMainPageRsp> paramvup)
  {
    if (paramvup != null) {
      QLog.d("QCirclePersonalDetailFragment", 1, "Observe StGetMainPageRsp state:" + paramvup.a());
    }
    try
    {
      QLog.d("QCirclePersonalDetailFragment", 1, "personDetail uiStateData is" + paramvup.a());
      if ((paramvup != null) && ((paramvup.a() == 2) || (paramvup.a() == 3)))
      {
        if (this.a.a != null)
        {
          QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is not null");
          this.a.a.setDatas(new ArrayList(Arrays.asList(new FeedCloudRead.StGetMainPageRsp[] { (FeedCloudRead.StGetMainPageRsp)paramvup.a() })));
          this.a.a.notifyLoadingComplete(true);
          return;
        }
        QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is null");
        return;
      }
    }
    catch (Exception paramvup)
    {
      paramvup.printStackTrace();
      QLog.e("QCirclePersonalDetailFragment", 1, "personDetail setData error" + paramvup.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vno
 * JD-Core Version:    0.7.0.1
 */