import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class ube
  implements yvn<FeedCloudWrite.StDoFollowRsp>
{
  public ube(QCircleFollowView paramQCircleFollowView, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    boolean bool = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (!QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView)) {}
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a(this.jdField_a_of_type_Int, true);
      if ((QCircleFollowView.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView)) && (this.jdField_a_of_type_Int == 1)) {
        QQToast.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.getContext(), 2, 2131698317, 0).a();
      }
      if (QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView) != null)
      {
        if (QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView) != null) {
          QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView).a(true, QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView));
        }
        yej.a().a(new QCircleFollowUpdateEvent(this.jdField_a_of_type_Int, QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView).id.get()));
        QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.getContext(), QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView).id.get(), this.jdField_a_of_type_Int);
        paramString = txt.a();
        paramStDoFollowRsp = QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView).id.get();
        if (this.jdField_a_of_type_Int != 1) {
          break label208;
        }
      }
      label208:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramString.a(paramStDoFollowRsp, paramBoolean);
        return;
      }
    }
    paramString = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.getContext();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131698316;; i = 2131698381)
    {
      QQToast.a(paramString, 1, i, 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ube
 * JD-Core Version:    0.7.0.1
 */