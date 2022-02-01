import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalWorksFragment;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vqc
  implements Observer<vxq<List<FeedCloudMeta.StFeed>>>
{
  public vqc(QCirclePersonalWorksFragment paramQCirclePersonalWorksFragment) {}
  
  public void a(@Nullable vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    QLog.d("QCirclePersonalWorksFragment", 4, "initViewData:getFeedListRequestRsp");
    this.a.a(paramvxq);
    if ((uzg.a(this.a.jdField_a_of_type_JavaLangString)) && (paramvxq != null) && (paramvxq.a() == 0) && (!this.a.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a())) {
      this.a.a().a().a("publish_show_or_hide", Boolean.valueOf(false));
    }
    while ((!uzg.a(this.a.jdField_a_of_type_JavaLangString)) || (paramvxq == null) || (paramvxq.a() == 1)) {
      return;
    }
    this.a.a().a().a("publish_show_or_hide", Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqc
 * JD-Core Version:    0.7.0.1
 */