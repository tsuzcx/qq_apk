import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoPushRsp;

class vfn
  implements aaav<FeedCloudWrite.StDoPushRsp>
{
  vfn(vfm paramvfm, QCircleDoRecommendRequest paramQCircleDoRecommendRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoPushRsp paramStDoPushRsp)
  {
    QLog.d("QCircleSharePart", 3, this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleDoRecommendRequest.getTraceId() + " " + paramLong);
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = new QCircleFeedEvent(vfi.a(this.jdField_a_of_type_Vfm.a).a.id.get(), 3);
      paramString.setTargetPage(9);
      aaak.a().a(paramString);
      QQToast.a(this.jdField_a_of_type_Vfm.a.a(), 2, 2131697198, 1).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Vfm.a.a(), 1, 2131697197, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfn
 * JD-Core Version:    0.7.0.1
 */