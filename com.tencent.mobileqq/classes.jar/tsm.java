import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class tsm
  implements Observer<tzm<FeedCloudRead.StGetMainPageRsp>>
{
  tsm(tsl paramtsl) {}
  
  public void a(@Nullable tzm<FeedCloudRead.StGetMainPageRsp> paramtzm)
  {
    if (paramtzm != null) {}
    try
    {
      if ((paramtzm.a() == 2) || (paramtzm.a() == 3))
      {
        tsl.a(this.a, (FeedCloudRead.StGetMainPageRsp)paramtzm.a());
        tsl.a(this.a, (FeedCloudMeta.StUser)tsl.a(this.a).user.get());
        tsl.a(this.a);
        tsl.b(this.a);
        tsl.c(this.a);
      }
      return;
    }
    catch (Exception paramtzm)
    {
      QLog.e("QCirclePersonalTitleBar", 1, "getShareInfo error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsm
 * JD-Core Version:    0.7.0.1
 */