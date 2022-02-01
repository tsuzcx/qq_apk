import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class vcf
  implements Observer<vup<FeedCloudRead.StGetMainPageRsp>>
{
  vcf(vcb paramvcb) {}
  
  public void a(@Nullable vup<FeedCloudRead.StGetMainPageRsp> paramvup)
  {
    if (paramvup != null) {}
    try
    {
      if ((paramvup.a() == 2) || (paramvup.a() == 3))
      {
        vcb.a(this.a, (FeedCloudRead.StGetMainPageRsp)paramvup.a());
        vcb.a(this.a, (FeedCloudMeta.StUser)vcb.a(this.a).user.get());
        vcb.a(this.a);
        vcb.b(this.a);
        vcb.c(this.a);
      }
      return;
    }
    catch (Exception paramvup)
    {
      QLog.e("QCirclePersonalTitleBar", 1, "getShareInfo error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcf
 * JD-Core Version:    0.7.0.1
 */