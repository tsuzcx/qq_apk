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

class vmj
  implements aaav<FeedCloudRead.StGetFeedListRsp>
{
  vmj(vmf paramvmf, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = true;
    QLog.d("QCircleContentModel", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean);
    Object localObject;
    if (paramStGetFeedListRsp != null)
    {
      vmf.a(this.jdField_a_of_type_Vmf).a(paramStGetFeedListRsp.feedAttchInfo.get());
      vmf.a(this.jdField_a_of_type_Vmf).c(paramStGetFeedListRsp.adAttchInfo.get());
      localObject = vmf.a(this.jdField_a_of_type_Vmf);
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label311;
      }
      paramBoolean = bool;
    }
    for (;;)
    {
      ((aabu)localObject).a(paramBoolean);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.jdField_a_of_type_Vmf.a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      if (paramStGetFeedListRsp.busiRspData.has()) {
        localObject = new QQCircleFeedBase.StFeedListBusiRspData();
      }
      try
      {
        ((QQCircleFeedBase.StFeedListBusiRspData)localObject).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.has()) {
          vmf.a(this.jdField_a_of_type_Vmf).b(((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.get());
        }
        uzg.a(vmf.a(this.jdField_a_of_type_Vmf), paramStGetFeedListRsp.vecFeed.get());
        vmf.a(this.jdField_a_of_type_Vmf).postValue(new vbf(paramLong, paramString, paramStGetFeedListRsp, this.jdField_a_of_type_Boolean));
        this.jdField_a_of_type_Vmf.a().a(4);
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
 * Qualified Name:     vmj
 * JD-Core Version:    0.7.0.1
 */