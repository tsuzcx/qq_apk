import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

final class tqh
  implements yvn<FeedCloudRead.StGetMainPageRsp>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramStGetMainPageRsp != null) {
        tqg.a((FeedCloudMeta.StUser)paramStGetMainPageRsp.user.get());
      }
    }
    else {
      return;
    }
    QLog.w(tqg.c(), 1, "getPuinUser empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqh
 * JD-Core Version:    0.7.0.1
 */