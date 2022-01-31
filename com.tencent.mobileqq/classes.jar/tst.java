import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class tst
  implements Observer<ubz<FeedCloudRead.StGetMainPageRsp>>
{
  tst(tss paramtss) {}
  
  public void a(@Nullable ubz<FeedCloudRead.StGetMainPageRsp> paramubz)
  {
    if (paramubz != null) {}
    try
    {
      if ((paramubz.a() == 2) || (paramubz.a() == 3))
      {
        tss.a(this.a, (FeedCloudRead.StGetMainPageRsp)paramubz.a());
        tss.a(this.a, (FeedCloudMeta.StUser)tss.a(this.a).user.get());
        tss.a(this.a);
        tss.b(this.a);
        tss.c(this.a);
      }
      return;
    }
    catch (Exception paramubz)
    {
      QLog.e("QCirclePersonalTitleBar", 1, "getShareInfo error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tst
 * JD-Core Version:    0.7.0.1
 */