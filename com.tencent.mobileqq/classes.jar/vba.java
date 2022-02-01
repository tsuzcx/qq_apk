import android.os.Bundle;
import com.tencent.biz.qqcircle.requests.QCircleJoinGroupReportRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;

class vba
  implements vzb
{
  vba(vax paramvax) {}
  
  public void a(long paramLong)
  {
    if (vax.a(this.a) != null)
    {
      vax.a(this.a).remove(Long.valueOf(paramLong));
      vax.a(this.a);
      vrf.a(vax.a(this.a).id.get(), 11, 25, 7, "", String.valueOf(paramLong), "", "", "", this.a.b());
    }
  }
  
  public void b(long paramLong)
  {
    Bundle localBundle = TroopInfoActivity.a(String.valueOf(paramLong), 0);
    localBundle.putBoolean("troop_info_from_troopsetting", true);
    localBundle.putInt("exposureSource", 3);
    bfup.a(this.a.a(), localBundle, 2);
    VSNetworkHelper.a().a(this.a.a(), new QCircleJoinGroupReportRequest(paramLong), new vbb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vba
 * JD-Core Version:    0.7.0.1
 */