import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment.5;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Result;
import feedcloud.FeedCloudRead.StClearCountRsp;

public class vof
  implements aaav<FeedCloudRead.StClearCountRsp>
{
  public vof(QCircleFolderFollowTabFragment.5 param5) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StClearCountRsp paramStClearCountRsp)
  {
    paramString = new StringBuilder();
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramLong = vtd.b();
      if (this.a.a > paramLong) {
        vtd.b(this.a.a);
      }
      paramString.append("[sendClearFollowTabRedPointRequest] clear outer red dot success!");
      if (paramStClearCountRsp != null) {
        paramString.append(", result.retCode: ").append(paramStClearCountRsp.result.retCode.get()).append(", result.msg: ").append(paramStClearCountRsp.result.msg.get());
      }
      paramString.append(", followTabFeedListLastPreRspTimestamp: ").append(this.a.a).append(", followTabFeedListLastRspTimestamp: ").append(paramLong);
      QLog.d("QCircleEeveeRedPoint_" + QCircleFolderFollowTabFragment.e, 1, new Object[] { paramString });
      return;
    }
    paramString.append("[sendClearFollowTabRedPointRequest] clear outer red dot error! isSuccess : ").append(paramBoolean).append(", retCode: ").append(paramLong);
    if (paramStClearCountRsp != null) {
      paramString.append(", result.retCode: ").append(paramStClearCountRsp.result.retCode.get()).append(", result.msg: ").append(paramStClearCountRsp.result.msg.get());
    }
    QLog.e("QCircleEeveeRedPoint_" + QCircleFolderFollowTabFragment.e, 1, new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vof
 * JD-Core Version:    0.7.0.1
 */