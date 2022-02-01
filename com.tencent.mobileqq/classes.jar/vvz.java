import com.tencent.biz.qcircleshadow.local.widgets.QCircleFollowView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.events.QCircleFollowUpdateEvent;
import cooperation.qqcircle.events.QCircleFuelAnimationEvent;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class vvz
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  public vvz(QCircleFollowView paramQCircleFollowView, int paramInt, boolean paramBoolean) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    boolean bool = true;
    QLog.d("QCircleFollowView", 1, "doFollow: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (!QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView)) {}
      this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.a(this.jdField_a_of_type_Int, true);
      if (this.jdField_a_of_type_Int == 1) {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
      }
      if (this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.a != null) {
        if (QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView) != null)
        {
          paramVSBaseRequest = QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView);
          if (this.jdField_a_of_type_Int != 1) {
            break label279;
          }
        }
      }
      label279:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramVSBaseRequest.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.a);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.a.id.get()));
        QCircleFollowView.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.getContext(), this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.a.id.get(), this.jdField_a_of_type_Int);
        QCircleFollowManager.getInstance().setUinFollowed(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.a.id.get(), this.jdField_a_of_type_Int);
        if (paramStDoFollowRsp != null) {
          QCircleDoubleFollowUserHepler.getInstance().updateFollowUser(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.a.id.get(), this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.a.nick.get(), paramStDoFollowRsp.isDoubly.get());
        }
        return;
      }
    }
    paramVSBaseRequest = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.getContext();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131697645;; i = 2131697776)
    {
      QQToast.a(paramVSBaseRequest, 1, i, 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvz
 * JD-Core Version:    0.7.0.1
 */