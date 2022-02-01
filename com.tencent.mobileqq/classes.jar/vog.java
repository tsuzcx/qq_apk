import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment.6;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Result;
import feedcloud.FeedCloudRead.StClearCountRsp;
import feedcloud.FeedCloudRead.StClearCountRspInfo;
import java.util.Iterator;
import java.util.List;

public class vog
  implements aaav<FeedCloudRead.StClearCountRsp>
{
  public vog(QCircleFolderFollowTabFragment.6 param6) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StClearCountRsp paramStClearCountRsp)
  {
    paramString = new StringBuilder();
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString.append("[sendClearOuterEntranceRedPointRequest] clear outer red dot success!");
      if (paramStClearCountRsp != null)
      {
        paramString.append(", result.retCode: ").append(paramStClearCountRsp.result.retCode.get()).append(", result.msg: ").append(paramStClearCountRsp.result.msg.get());
        paramStClearCountRsp = paramStClearCountRsp.clearCountRspInfos.get();
        if (paramStClearCountRsp == null) {
          break label213;
        }
        paramString.append(", rspInfoList size: " + paramStClearCountRsp.size());
        paramStClearCountRsp = paramStClearCountRsp.iterator();
        while (paramStClearCountRsp.hasNext())
        {
          FeedCloudRead.StClearCountRspInfo localStClearCountRspInfo = (FeedCloudRead.StClearCountRspInfo)paramStClearCountRsp.next();
          if ((localStClearCountRspInfo != null) && (localStClearCountRspInfo.countType.get() == 1)) {
            vtd.f(localStClearCountRspInfo.clearTime.get());
          }
        }
      }
      for (;;)
      {
        QLog.d("QCircleEeveeRedPoint_" + QCircleFolderFollowTabFragment.e, 1, new Object[] { paramString });
        return;
        label213:
        paramString.append(", rspInfoList is null!");
      }
    }
    paramString.append("[sendClearOuterEntranceRedPointRequest] clear outer red dot error! isSuccess : ").append(paramBoolean).append(", retCode: ").append(paramLong);
    if (paramStClearCountRsp != null) {
      paramString.append(", result.retCode: ").append(paramStClearCountRsp.result.retCode.get()).append(", result.msg: ").append(paramStClearCountRsp.result.msg.get());
    }
    QLog.e("QCircleEeveeRedPoint_" + QCircleFolderFollowTabFragment.e, 1, new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vog
 * JD-Core Version:    0.7.0.1
 */