import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class wai
  implements aaav<FeedCloudWrite.StDoFollowRsp>
{
  public wai(QCircleFollowView paramQCircleFollowView, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    boolean bool = true;
    QLog.d("QCircleFollowView", 1, "doFollow: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (!QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView)) {}
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a(this.jdField_a_of_type_Int, true);
      if (this.jdField_a_of_type_Int == 1) {
        aaak.a().a(new QCircleFuelAnimationEvent());
      }
      String str;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a != null)
      {
        if (QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView) != null)
        {
          paramString = QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView);
          if (this.jdField_a_of_type_Int != 1) {
            break label296;
          }
          paramBoolean = true;
          paramString.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a);
        }
        aaak.a().a(new QCircleFollowUpdateEvent(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a.id.get()));
        QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.getContext(), this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a.id.get(), this.jdField_a_of_type_Int);
        paramString = vqn.a();
        str = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a.id.get();
        if (this.jdField_a_of_type_Int != 1) {
          break label301;
        }
      }
      label296:
      label301:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramString.a(str, paramBoolean);
        if (paramStDoFollowRsp != null) {
          vwh.a().a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a.id.get(), this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a.nick.get(), paramStDoFollowRsp.isDoubly.get());
        }
        return;
        paramBoolean = false;
        break;
      }
    }
    QLog.d("QCircleFollowView", 1, "revertFollowUI:" + this.b);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wai
 * JD-Core Version:    0.7.0.1
 */