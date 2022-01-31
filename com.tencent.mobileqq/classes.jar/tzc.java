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
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StFollowPageData;

class tzc
  implements yvn<FeedCloudRead.StGetFeedListRsp>
{
  tzc(tzb paramtzb, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = VSNetworkHelper.a(paramString);
    QLog.d("QCircleFeedViewModel", 1, "requestFeedsData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + bool3);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFeedListRsp == null)) {
      tzb.a(this.jdField_a_of_type_Tzb).setValue(tzm.a(paramString).b(this.jdField_a_of_type_Boolean));
    }
    for (;;)
    {
      return;
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.jdField_a_of_type_Tzb.a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      tzb.a(this.jdField_a_of_type_Tzb, paramStGetFeedListRsp.feedAttchInfo.get());
      paramString = paramStGetFeedListRsp.vecFeed.get();
      Object localObject = new StringBuilder().append("feed size:").append(paramString.size()).append(" | isFinish:");
      if (paramStGetFeedListRsp.isFinish.get() > 0)
      {
        paramBoolean = true;
        label244:
        QLog.d("QCircleFeedViewModel", 1, paramBoolean + " | feedAttachInfo:" + tzb.a(this.jdField_a_of_type_Tzb));
        if (paramString.size() <= 0) {
          break label421;
        }
        tzb.a(this.jdField_a_of_type_Tzb, paramString);
        localObject = tzb.a(this.jdField_a_of_type_Tzb);
        paramString = tzm.a(bool3).a(this.jdField_a_of_type_Boolean, paramString);
        if (paramStGetFeedListRsp.isFinish.get() <= 0) {
          break label416;
        }
        paramBoolean = bool1;
        label333:
        ((MutableLiveData)localObject).setValue(paramString.c(paramBoolean));
        paramString = new QQCircleFeedBase.StFeedListBusiRspData();
        if (!paramStGetFeedListRsp.busiRspData.has()) {
          continue;
        }
      }
      try
      {
        paramString.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (!paramString.followPageData.has()) {
          continue;
        }
        tzb.b(this.jdField_a_of_type_Tzb).setValue(paramString.followPageData.get());
        return;
        paramBoolean = false;
        break label244;
        label416:
        paramBoolean = false;
        break label333;
        label421:
        paramString = tzb.a(this.jdField_a_of_type_Tzb);
        localObject = tzm.a().b(this.jdField_a_of_type_Boolean);
        if (paramStGetFeedListRsp.isFinish.get() > 0) {}
        for (paramBoolean = bool2;; paramBoolean = false)
        {
          paramString.setValue(((tzm)localObject).c(paramBoolean));
          return;
        }
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
 * Qualified Name:     tzc
 * JD-Core Version:    0.7.0.1
 */