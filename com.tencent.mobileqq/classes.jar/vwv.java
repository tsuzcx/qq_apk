import com.tencent.biz.qqcircle.widgets.QCircleFollowTagView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleWrite.DoFollowTagRsp;

public class vwv
  implements zxa<QQCircleWrite.DoFollowTagRsp>
{
  public vwv(QCircleFollowTagView paramQCircleFollowTagView, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleWrite.DoFollowTagRsp paramDoFollowTagRsp)
  {
    boolean bool = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.a(this.jdField_a_of_type_Int);
      if (QCircleFollowTagView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView) != null)
      {
        QCircleFollowTagView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.getContext(), QCircleFollowTagView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView).tagId.get(), this.jdField_a_of_type_Int);
        paramString = vot.a();
        paramDoFollowTagRsp = QCircleFollowTagView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView).tagId.get();
        if (this.jdField_a_of_type_Int != 1) {
          break label101;
        }
      }
      label101:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramString.a(paramDoFollowTagRsp, paramBoolean);
        return;
      }
    }
    paramString = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.getContext();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131697161;; i = 2131697274)
    {
      QQToast.a(paramString, i, 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwv
 * JD-Core Version:    0.7.0.1
 */