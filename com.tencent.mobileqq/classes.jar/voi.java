import com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment.3;
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

public class voi
  implements aaav<FeedCloudRead.StClearCountRsp>
{
  public voi(QCircleFolderRcmdTabFragment.3 param3) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StClearCountRsp paramStClearCountRsp)
  {
    paramString = new StringBuilder();
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString.append("[sendOuterEntranceRedPointRequest] request success!");
      if (paramStClearCountRsp != null)
      {
        paramString.append(", result.retCode: ").append(paramStClearCountRsp.result.retCode.get()).append(", result.msg: ").append(paramStClearCountRsp.result.msg.get());
        paramStClearCountRsp = paramStClearCountRsp.clearCountRspInfos.get();
        if (paramStClearCountRsp != null)
        {
          paramStClearCountRsp = paramStClearCountRsp.iterator();
          while (paramStClearCountRsp.hasNext())
          {
            FeedCloudRead.StClearCountRspInfo localStClearCountRspInfo = (FeedCloudRead.StClearCountRspInfo)paramStClearCountRsp.next();
            if ((localStClearCountRspInfo != null) && (localStClearCountRspInfo.countType.get() == 1)) {
              vtd.f(localStClearCountRspInfo.clearTime.get());
            }
          }
        }
      }
      QLog.d("QCircleEeveeRedPoint_" + QCircleFolderRcmdTabFragment.e, 1, new Object[] { paramString });
      return;
    }
    paramString.append("[sendOuterEntranceRedPointRequest] request error! isSuccess : ").append(paramBoolean).append(", retCode: ").append(paramLong);
    if (paramStClearCountRsp != null) {
      paramString.append(", result.retCode: ").append(paramStClearCountRsp.result.retCode.get()).append(", result.msg: ").append(paramStClearCountRsp.result.msg.get());
    }
    QLog.e("QCircleEeveeRedPoint_" + QCircleFolderRcmdTabFragment.e, 1, new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voi
 * JD-Core Version:    0.7.0.1
 */