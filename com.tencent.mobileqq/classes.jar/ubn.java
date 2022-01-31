import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StFollowPageData;

class ubn
  implements zac<FeedCloudRead.StGetFeedListRsp>
{
  ubn(ubm paramubm, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    QLog.d("QCircleFeedViewModel", 1, "requestFeedsData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + bool);
    if (ubm.a(this.jdField_a_of_type_Ubm).a())
    {
      if (!bool) {
        break label182;
      }
      QLog.d("QCircleFeedViewModel", 1, "use cache data");
      ubm.a(this.jdField_a_of_type_Ubm, this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId());
    }
    else
    {
      label144:
      if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedListRsp != null)) {
        break label211;
      }
      ubm.a(this.jdField_a_of_type_Ubm).setValue(ubz.a(paramString).b(this.jdField_a_of_type_Boolean));
    }
    for (;;)
    {
      return;
      label182:
      if (!this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId().equals(ubm.a(this.jdField_a_of_type_Ubm))) {
        break label144;
      }
      QLog.d("QCircleFeedViewModel", 1, "from old cache data rsp,direct return!");
      return;
      label211:
      if (!bool)
      {
        if (!this.jdField_a_of_type_Boolean) {
          ubm.a(this.jdField_a_of_type_Ubm).clear();
        }
        ubm.a(this.jdField_a_of_type_Ubm).addAll(paramStGetFeedListRsp.vecFeed.get());
      }
      if (paramStGetFeedListRsp.extInfo.has())
      {
        ubm.a(this.jdField_a_of_type_Ubm, (FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
        this.jdField_a_of_type_Ubm.a(ubm.a(this.jdField_a_of_type_Ubm));
      }
      ubm.b(this.jdField_a_of_type_Ubm, paramStGetFeedListRsp.feedAttchInfo.get());
      paramString = this.jdField_a_of_type_Ubm;
      if (paramStGetFeedListRsp.isFinish.get() > 0)
      {
        paramBoolean = true;
        label331:
        ubm.a(paramString, paramBoolean);
        paramString = paramStGetFeedListRsp.vecFeed.get();
        QLog.d("QCircleFeedViewModel", 1, "feed size:" + paramString.size() + " | isFinish:" + ubm.a(this.jdField_a_of_type_Ubm) + " | feedAttachInfo:" + ubm.b(this.jdField_a_of_type_Ubm));
        if (paramString.size() <= 0) {
          break label535;
        }
        ubm.a(this.jdField_a_of_type_Ubm, paramString);
        ubm.a(this.jdField_a_of_type_Ubm).setValue(ubz.a(bool).a(this.jdField_a_of_type_Boolean, paramString).c(ubm.a(this.jdField_a_of_type_Ubm)));
        paramString = new QQCircleFeedBase.StFeedListBusiRspData();
        if (!paramStGetFeedListRsp.busiRspData.has()) {
          break;
        }
      }
      try
      {
        paramString.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (!paramString.followPageData.has()) {
          continue;
        }
        ubm.b(this.jdField_a_of_type_Ubm).setValue(paramString.followPageData.get());
        return;
        paramBoolean = false;
        break label331;
        label535:
        ubm.a(this.jdField_a_of_type_Ubm).setValue(ubz.a().b(this.jdField_a_of_type_Boolean).c(ubm.a(this.jdField_a_of_type_Ubm)));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        for (;;)
        {
          paramStGetFeedListRsp.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubn
 * JD-Core Version:    0.7.0.1
 */