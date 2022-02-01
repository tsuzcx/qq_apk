import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

final class vhc
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetMainPageRsp>
{
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramStGetMainPageRsp == null) {
        break label54;
      }
      vhb.a((FeedCloudMeta.StUser)paramStGetMainPageRsp.user.get());
      if (TextUtils.isEmpty(vhb.c().nick.get())) {
        QLog.w("QCircleHostGlobalInfo", 1, "qCircle get nick empty");
      }
    }
    return;
    label54:
    QLog.w("QCircleHostGlobalInfo", 1, "getPuinUser empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhc
 * JD-Core Version:    0.7.0.1
 */