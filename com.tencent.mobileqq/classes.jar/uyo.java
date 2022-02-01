import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

final class uyo
  implements aaav<FeedCloudRead.StGetMainPageRsp>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramStGetMainPageRsp == null) {
        break label54;
      }
      uyn.a((FeedCloudMeta.StUser)paramStGetMainPageRsp.user.get());
      if (TextUtils.isEmpty(uyn.c().nick.get())) {
        QLog.w("QCircleGlobalInfo", 1, "qCircle get nick empty");
      }
    }
    return;
    label54:
    QLog.w("QCircleGlobalInfo", 1, "getPuinUser empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyo
 * JD-Core Version:    0.7.0.1
 */