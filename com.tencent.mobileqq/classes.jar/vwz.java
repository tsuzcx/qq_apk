import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
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
import qqcircle.QQCircleFeedBase.StTabInfo;

class vwz
  implements aaav<FeedCloudRead.StGetFeedListRsp>
{
  vwz(vwy paramvwy, vbe paramvbe, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    int i = -1;
    if (this.jdField_a_of_type_Vbe.a != null) {
      i = this.jdField_a_of_type_Vbe.a.tabType.get();
    }
    QLog.d("QCircleFeedViewModel", 1, "requestFeedsData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + bool + " | tabType:" + i + " | pullSceneType:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Vbe.a())
    {
      if (!bool) {
        break label233;
      }
      QLog.d("QCircleFeedViewModel", 1, "use cache data");
      vwy.a(this.jdField_a_of_type_Vwy, this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId());
    }
    else
    {
      label191:
      if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedListRsp != null)) {
        break label301;
      }
      vwy.a(this.jdField_a_of_type_Vwy).setValue(vxq.a(paramString).a(paramLong).b(this.jdField_a_of_type_Boolean));
    }
    for (;;)
    {
      return;
      label233:
      if (!this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId().equals(vwy.a(this.jdField_a_of_type_Vwy))) {
        break label191;
      }
      if ((!paramBoolean) && (paramLong == -2L))
      {
        vwy.a(this.jdField_a_of_type_Vwy).setValue(vxq.a(paramString).a(paramLong).b(this.jdField_a_of_type_Boolean));
        return;
      }
      QLog.d("QCircleFeedViewModel", 1, "from old cache data rsp,direct return!");
      return;
      label301:
      if (!bool)
      {
        if (!this.jdField_a_of_type_Boolean) {
          vwy.a(this.jdField_a_of_type_Vwy).clear();
        }
        vwy.a(this.jdField_a_of_type_Vwy).addAll(paramStGetFeedListRsp.vecFeed.get());
      }
      if (paramStGetFeedListRsp.extInfo.has())
      {
        vwy.a(this.jdField_a_of_type_Vwy, (FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
        this.jdField_a_of_type_Vwy.a(vwy.a(this.jdField_a_of_type_Vwy));
      }
      vwy.b(this.jdField_a_of_type_Vwy, paramStGetFeedListRsp.feedAttchInfo.get());
      paramString = this.jdField_a_of_type_Vwy;
      if (paramStGetFeedListRsp.isFinish.get() > 0)
      {
        paramBoolean = true;
        label421:
        vwy.a(paramString, paramBoolean);
        paramString = paramStGetFeedListRsp.vecFeed.get();
        QLog.d("QCircleFeedViewModel", 1, "feed size:" + paramString.size() + " | isFinish:" + vwy.a(this.jdField_a_of_type_Vwy) + " | feedAttachInfo:" + vwy.b(this.jdField_a_of_type_Vwy));
        if (paramString.size() <= 0) {
          break label769;
        }
        vwy.a(this.jdField_a_of_type_Vwy).setValue(vxq.a(bool).a(this.jdField_a_of_type_Boolean, paramString).c(vwy.a(this.jdField_a_of_type_Vwy)));
        paramString = new QQCircleFeedBase.StFeedListBusiRspData();
        if (!paramStGetFeedListRsp.busiRspData.has()) {
          break;
        }
      }
      try
      {
        paramString.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (paramString.followPageData.has()) {
          vwy.b(this.jdField_a_of_type_Vwy).setValue(paramString.followPageData.get());
        }
        if (paramString.refreshAttachInfo.has()) {
          vwy.c(this.jdField_a_of_type_Vwy, paramString.refreshAttachInfo.get());
        }
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Vbe.a != null) && (this.jdField_a_of_type_Vbe.a.tabType.get() == 1) && (paramString.rspTimestamp.has())) {
          if (this.jdField_a_of_type_Int == 1)
          {
            vtd.c(paramString.rspTimestamp.get());
            paramStGetFeedListRsp = new StringBuilder();
            paramStGetFeedListRsp.append("[requestFeedsData] preload response: ").append(", followTabFeedListLastPreRspTimestamp: ").append(paramString.rspTimestamp.get()).append(", followTabFeedListLastRspTimestamp: ").append(vtd.b());
            QLog.d("QCircleEeveeRedPoint_QCircleFeedViewModel", 1, new Object[] { paramStGetFeedListRsp });
            return;
            paramBoolean = false;
            break label421;
            label769:
            vwy.a(this.jdField_a_of_type_Vwy).setValue(vxq.a().b(this.jdField_a_of_type_Boolean).c(vwy.a(this.jdField_a_of_type_Vwy)));
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        for (;;)
        {
          paramStGetFeedListRsp.printStackTrace();
        }
        vtd.b(paramString.rspTimestamp.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwz
 * JD-Core Version:    0.7.0.1
 */