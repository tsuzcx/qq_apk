import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
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

class pdz
  implements rxc.a<FeedCloudRead.StGetFeedListRsp>
{
  pdz(pdy parampdy, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.fQ(paramString);
    QLog.d("QCircleFeedViewModel", 1, "requestFeedsData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.b.getTraceId() + " | SeqId:" + this.b.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.us + " | isCache:" + bool);
    if (pdy.a(this.c).HE())
    {
      if (!bool) {
        break label182;
      }
      QLog.d("QCircleFeedViewModel", 1, "use cache data");
      pdy.a(this.c, this.b.getTraceId());
    }
    else
    {
      label144:
      if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedListRsp != null)) {
        break label211;
      }
      pdy.a(this.c).setValue(pel.a(paramString).b(this.us));
    }
    for (;;)
    {
      return;
      label182:
      if (!this.b.getTraceId().equals(pdy.a(this.c))) {
        break label144;
      }
      QLog.d("QCircleFeedViewModel", 1, "from old cache data rsp,direct return!");
      return;
      label211:
      if (!bool)
      {
        if (!this.us) {
          pdy.a(this.c).clear();
        }
        pdy.a(this.c).addAll(paramStGetFeedListRsp.vecFeed.get());
      }
      if (paramStGetFeedListRsp.extInfo.has())
      {
        pdy.a(this.c, (FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
        this.c.a(pdy.a(this.c));
      }
      pdy.b(this.c, paramStGetFeedListRsp.feedAttchInfo.get());
      paramString = this.c;
      if (paramStGetFeedListRsp.isFinish.get() > 0)
      {
        paramBoolean = true;
        label331:
        pdy.a(paramString, paramBoolean);
        paramString = paramStGetFeedListRsp.vecFeed.get();
        QLog.d("QCircleFeedViewModel", 1, "feed size:" + paramString.size() + " | isFinish:" + pdy.b(this.c) + " | feedAttachInfo:" + pdy.b(this.c));
        if (paramString.size() <= 0) {
          break label535;
        }
        pdy.a(this.c, paramString);
        pdy.a(this.c).setValue(pel.a(bool).a(this.us, paramString).c(pdy.b(this.c)));
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
        pdy.b(this.c).setValue(paramString.followPageData.get());
        return;
        paramBoolean = false;
        break label331;
        label535:
        pdy.a(this.c).setValue(pel.a().b(this.us).c(pdy.b(this.c)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdz
 * JD-Core Version:    0.7.0.1
 */