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

class vua
  implements zxa<FeedCloudRead.StGetFeedListRsp>
{
  vua(vtz paramvtz, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    QLog.d("QCircleFeedViewModel", 1, "requestFeedsData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + bool);
    if (vtz.a(this.jdField_a_of_type_Vtz).a())
    {
      if (!bool) {
        break label186;
      }
      QLog.d("QCircleFeedViewModel", 1, "use cache data");
      vtz.a(this.jdField_a_of_type_Vtz, this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId());
    }
    else
    {
      label144:
      if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedListRsp != null)) {
        break label254;
      }
      vtz.a(this.jdField_a_of_type_Vtz).setValue(vup.a(paramString).a(paramLong).b(this.jdField_a_of_type_Boolean));
    }
    for (;;)
    {
      return;
      label186:
      if (!this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId().equals(vtz.a(this.jdField_a_of_type_Vtz))) {
        break label144;
      }
      if ((!paramBoolean) && (paramLong == -2L))
      {
        vtz.a(this.jdField_a_of_type_Vtz).setValue(vup.a(paramString).a(paramLong).b(this.jdField_a_of_type_Boolean));
        return;
      }
      QLog.d("QCircleFeedViewModel", 1, "from old cache data rsp,direct return!");
      return;
      label254:
      if (!bool)
      {
        if (!this.jdField_a_of_type_Boolean) {
          vtz.a(this.jdField_a_of_type_Vtz).clear();
        }
        vtz.a(this.jdField_a_of_type_Vtz).addAll(paramStGetFeedListRsp.vecFeed.get());
      }
      if (paramStGetFeedListRsp.extInfo.has())
      {
        vtz.a(this.jdField_a_of_type_Vtz, (FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
        this.jdField_a_of_type_Vtz.a(vtz.a(this.jdField_a_of_type_Vtz));
      }
      vtz.b(this.jdField_a_of_type_Vtz, paramStGetFeedListRsp.feedAttchInfo.get());
      paramString = this.jdField_a_of_type_Vtz;
      if (paramStGetFeedListRsp.isFinish.get() > 0)
      {
        paramBoolean = true;
        label374:
        vtz.a(paramString, paramBoolean);
        paramString = paramStGetFeedListRsp.vecFeed.get();
        QLog.d("QCircleFeedViewModel", 1, "feed size:" + paramString.size() + " | isFinish:" + vtz.a(this.jdField_a_of_type_Vtz) + " | feedAttachInfo:" + vtz.b(this.jdField_a_of_type_Vtz));
        if (paramString.size() <= 0) {
          break label677;
        }
        vtz.a(this.jdField_a_of_type_Vtz, paramString);
        vtz.a(this.jdField_a_of_type_Vtz).setValue(vup.a(bool).a(this.jdField_a_of_type_Boolean, paramString).c(vtz.a(this.jdField_a_of_type_Vtz)));
        paramString = new QQCircleFeedBase.StFeedListBusiRspData();
        if (!paramStGetFeedListRsp.busiRspData.has()) {
          break;
        }
      }
      try
      {
        paramString.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (paramString.followPageData.has()) {
          vtz.b(this.jdField_a_of_type_Vtz).setValue(paramString.followPageData.get());
        }
        if (paramString.refreshAttachInfo.has()) {
          vtz.c(this.jdField_a_of_type_Vtz, paramString.refreshAttachInfo.get());
        }
        if ((this.jdField_a_of_type_Boolean) || (vtz.a(this.jdField_a_of_type_Vtz) == null) || (vtz.a(this.jdField_a_of_type_Vtz).a == null) || (vtz.a(this.jdField_a_of_type_Vtz).a.tabType.get() != 1) || (!paramString.rspTimestamp.has())) {
          continue;
        }
        vqs.b(paramString.rspTimestamp.get());
        return;
        paramBoolean = false;
        break label374;
        label677:
        vtz.a(this.jdField_a_of_type_Vtz).setValue(vup.a().b(this.jdField_a_of_type_Boolean).c(vtz.a(this.jdField_a_of_type_Vtz)));
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
 * Qualified Name:     vua
 * JD-Core Version:    0.7.0.1
 */