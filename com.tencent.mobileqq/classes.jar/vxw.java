import com.tencent.biz.qqcircle.widgets.QCircleAddBlackListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

public class vxw
  implements aaav<QQCircleRight.SetCircleUnCareRsp>
{
  public vxw(QCircleAddBlackListView paramQCircleAddBlackListView, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleRight.SetCircleUnCareRsp paramSetCircleUnCareRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCircleAddBlackListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView.a(QCircleAddBlackListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView).id.get());
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView.getContext(), 2, 2131697168, 0).a();
      return;
    }
    QLog.e("QCircleAddBlackListView", 1, "revertBlackUI:" + this.b + " retCode =" + paramLong);
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView.getContext(), 1, 2131697280, 0).a();
    QCircleAddBlackListView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxw
 * JD-Core Version:    0.7.0.1
 */