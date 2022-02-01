import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class vdy
  implements Observer<vxq<FeedCloudRead.StGetMainPageRsp>>
{
  vdy(vdr paramvdr) {}
  
  public void a(@Nullable vxq<FeedCloudRead.StGetMainPageRsp> paramvxq)
  {
    if (paramvxq != null) {}
    try
    {
      if ((paramvxq.a() == 2) || (paramvxq.a() == 3))
      {
        vdr.a(this.a, (FeedCloudRead.StGetMainPageRsp)paramvxq.a());
        vdr.a(this.a, (FeedCloudMeta.StUser)vdr.a(this.a).user.get());
        vdr.a(this.a);
        vdr.b(this.a);
        vdr.c(this.a);
      }
      return;
    }
    catch (Exception paramvxq)
    {
      QLog.e("QCirclePersonalTitleBar", 1, "getShareInfo error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdy
 * JD-Core Version:    0.7.0.1
 */