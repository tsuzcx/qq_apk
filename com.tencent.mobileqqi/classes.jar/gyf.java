import android.os.Handler;
import android.os.Message;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class gyf
  extends SOSOMapLBSApiListener
{
  public gyf(AutoLocationMapView paramAutoLocationMapView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    Message localMessage = this.a.a.obtainMessage(1);
    if (paramSOSOMapLBSApiResult.Info == 1)
    {
      paramSOSOMapLBSApiResult = new GeoPoint((int)(paramSOSOMapLBSApiResult.Latitude * 1000000.0D), (int)(paramSOSOMapLBSApiResult.Longitude * 1000000.0D));
      localMessage.arg1 = 0;
      localMessage.obj = paramSOSOMapLBSApiResult;
    }
    for (;;)
    {
      localMessage.sendToTarget();
      return;
      localMessage.arg2 = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gyf
 * JD-Core Version:    0.7.0.1
 */