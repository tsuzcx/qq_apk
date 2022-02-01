import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetGroupFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
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

class vtw
  implements zxa<FeedCloudRead.StGetFeedListRsp>
{
  vtw(vtv paramvtv, QCircleGetGroupFeedListRequest paramQCircleGetGroupFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    QLog.d("QCircleAggregationFeedViewModel", 1, "requestFeedsData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetGroupFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetGroupFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + bool);
    if (vtv.a(this.jdField_a_of_type_Vtv).a())
    {
      if (!bool) {
        break label186;
      }
      QLog.d("QCircleAggregationFeedViewModel", 1, "use cache data");
      vtv.a(this.jdField_a_of_type_Vtv, this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetGroupFeedListRequest.getTraceId());
    }
    else
    {
      label144:
      if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedListRsp != null)) {
        break label215;
      }
      vtv.a(this.jdField_a_of_type_Vtv).setValue(vup.a(paramString).a(paramLong).b(this.jdField_a_of_type_Boolean));
    }
    for (;;)
    {
      return;
      label186:
      if (!this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetGroupFeedListRequest.getTraceId().equals(vtv.a(this.jdField_a_of_type_Vtv))) {
        break label144;
      }
      QLog.d("QCircleAggregationFeedViewModel", 1, "from old cache data rsp,direct return!");
      return;
      label215:
      if (!bool)
      {
        if (!this.jdField_a_of_type_Boolean) {
          vtv.a(this.jdField_a_of_type_Vtv).clear();
        }
        vtv.a(this.jdField_a_of_type_Vtv).addAll(paramStGetFeedListRsp.vecFeed.get());
      }
      if (paramStGetFeedListRsp.extInfo.has())
      {
        vtv.a(this.jdField_a_of_type_Vtv, (FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
        this.jdField_a_of_type_Vtv.a(vtv.a(this.jdField_a_of_type_Vtv));
      }
      vtv.b(this.jdField_a_of_type_Vtv, paramStGetFeedListRsp.feedAttchInfo.get());
      paramString = this.jdField_a_of_type_Vtv;
      if (paramStGetFeedListRsp.isFinish.get() > 0)
      {
        paramBoolean = true;
        label335:
        vtv.a(paramString, paramBoolean);
        paramString = paramStGetFeedListRsp.vecFeed.get();
        QLog.d("QCircleAggregationFeedViewModel", 1, "feed size:" + paramString.size() + " | isFinish:" + vtv.a(this.jdField_a_of_type_Vtv) + " | feedAttachInfo:" + vtv.b(this.jdField_a_of_type_Vtv));
        if (paramString.size() <= 0) {
          break label566;
        }
        vtv.a(this.jdField_a_of_type_Vtv, paramString);
        vtv.a(this.jdField_a_of_type_Vtv).setValue(vup.a(bool).a(this.jdField_a_of_type_Boolean, paramString).c(vtv.a(this.jdField_a_of_type_Vtv)));
        paramString = new QQCircleFeedBase.StFeedListBusiRspData();
        if (!paramStGetFeedListRsp.busiRspData.has()) {
          break;
        }
      }
      try
      {
        paramString.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (paramString.followPageData.has()) {
          vtv.b(this.jdField_a_of_type_Vtv).setValue(paramString.followPageData.get());
        }
        if (!paramString.refreshAttachInfo.has()) {
          continue;
        }
        vtv.c(this.jdField_a_of_type_Vtv, paramString.refreshAttachInfo.get());
        return;
        paramBoolean = false;
        break label335;
        label566:
        vtv.a(this.jdField_a_of_type_Vtv).setValue(vup.a().b(this.jdField_a_of_type_Boolean).c(vtv.a(this.jdField_a_of_type_Vtv)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtw
 * JD-Core Version:    0.7.0.1
 */