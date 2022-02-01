import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import qqcircle.QQCircleFeedBase.StPolyLike;

class vqd
  implements zxa<FeedCloudWrite.StDoLikeRsp>
{
  vqd(vqa paramvqa, QCircleDoLikeRequest paramQCircleDoLikeRequest, int paramInt, FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    QLog.d(vqa.a(), 1, "onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleDoLikeRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleDoLikeRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    vqa.b(this.jdField_a_of_type_Vqa, true);
    if ((paramBoolean) && (paramLong == 0L))
    {
      if ((!vqa.b(this.jdField_a_of_type_Vqa)) && (this.jdField_a_of_type_Int != 21)) {
        this.jdField_a_of_type_Vqa.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike, this.b);
      }
      if ((this.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_Int == 21)) {
        vqa.a(this.jdField_a_of_type_Vqa, paramStDoLikeRsp);
      }
    }
    vqa.a(this.jdField_a_of_type_Vqa, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqd
 * JD-Core Version:    0.7.0.1
 */