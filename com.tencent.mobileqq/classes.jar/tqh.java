import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

final class tqh
  implements zac<FeedCloudRead.StGetMainPageRsp>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramStGetMainPageRsp == null) {
        break label54;
      }
      tqg.a((FeedCloudMeta.StUser)paramStGetMainPageRsp.user.get());
      if (TextUtils.isEmpty(tqg.c().nick.get())) {
        QLog.w("QCircleGlobalInfo", 1, "qCircle get nick empty");
      }
    }
    return;
    label54:
    QLog.w("QCircleGlobalInfo", 1, "getPuinUser empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqh
 * JD-Core Version:    0.7.0.1
 */