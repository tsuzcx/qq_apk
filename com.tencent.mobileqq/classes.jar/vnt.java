import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDynamicFragment;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vnt
  implements Observer<vup<List<FeedCloudMeta.StFeed>>>
{
  public vnt(QCirclePersonalDynamicFragment paramQCirclePersonalDynamicFragment) {}
  
  public void a(@Nullable vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    QLog.d("QCirclePersonalDynamicFragment", 4, "initViewData:getFeedListRequestRsp");
    this.a.a(paramvup);
    if ((uxx.a(this.a.jdField_a_of_type_JavaLangString)) && (paramvup != null) && (paramvup.a() == 0) && (!this.a.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a())) {
      this.a.a().a().a("publish_show_or_hide", Boolean.valueOf(false));
    }
    while ((!uxx.a(this.a.jdField_a_of_type_JavaLangString)) || (paramvup == null) || (paramvup.a() == 1)) {
      return;
    }
    this.a.a().a().a("publish_show_or_hide", Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnt
 * JD-Core Version:    0.7.0.1
 */