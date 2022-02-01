import android.os.Bundle;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget;
import com.tencent.biz.qqcircle.requests.QCircleJoinGroupReportRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public class vph
  implements wcr
{
  public vph(QCirclePersonInfoWidget paramQCirclePersonInfoWidget) {}
  
  public void a(long paramLong) {}
  
  public void b(long paramLong)
  {
    Bundle localBundle = TroopInfoActivity.a(String.valueOf(paramLong), 0);
    localBundle.putBoolean("troop_info_from_troopsetting", true);
    localBundle.putInt("exposureSource", 3);
    bguq.a(this.a.getContext(), localBundle, 2);
    VSNetworkHelper.a().a(this.a.getContext(), new QCircleJoinGroupReportRequest(paramLong), new vpi(this));
    vtq.a(QCirclePersonInfoWidget.a(this.a).id.get(), 11, 31, 2, "", QCirclePersonInfoWidget.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vph
 * JD-Core Version:    0.7.0.1
 */