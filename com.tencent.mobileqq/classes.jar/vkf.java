import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

class vkf
  implements zxa<FeedCloudRead.StGetFeedListRsp>
{
  vkf(vkb paramvkb, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = true;
    QLog.d("QCircleContentModel", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean);
    Object localObject;
    if (paramStGetFeedListRsp != null)
    {
      vkb.a(this.jdField_a_of_type_Vkb).a(paramStGetFeedListRsp.feedAttchInfo.get());
      vkb.a(this.jdField_a_of_type_Vkb).c(paramStGetFeedListRsp.adAttchInfo.get());
      localObject = vkb.a(this.jdField_a_of_type_Vkb);
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label311;
      }
      paramBoolean = bool;
    }
    for (;;)
    {
      ((zxz)localObject).a(paramBoolean);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.jdField_a_of_type_Vkb.a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      if (paramStGetFeedListRsp.busiRspData.has()) {
        localObject = new QQCircleFeedBase.StFeedListBusiRspData();
      }
      try
      {
        ((QQCircleFeedBase.StFeedListBusiRspData)localObject).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.has()) {
          vkb.a(this.jdField_a_of_type_Vkb).b(((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.get());
        }
        uxx.a(vkb.a(this.jdField_a_of_type_Vkb), paramStGetFeedListRsp.vecFeed.get());
        vkb.a(this.jdField_a_of_type_Vkb).postValue(new uzp(paramLong, paramString, paramStGetFeedListRsp, this.jdField_a_of_type_Boolean));
        this.jdField_a_of_type_Vkb.a().a(4);
        return;
        label311:
        paramBoolean = false;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkf
 * JD-Core Version:    0.7.0.1
 */