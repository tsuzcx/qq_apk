import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity.UIHandler;
import com.tencent.qphone.base.util.QLog;

public class gpz
  extends SOSOMapLBSApiListener
{
  public gpz(NearbyTroopsActivity paramNearbyTroopsActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity", 2, "onLocationUpdate()");
    }
    if (paramSOSOMapLBSApiResult == null) {
      return;
    }
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    this.a.d = ((int)(paramSOSOMapLBSApiResult.Latitude * 1000000.0D));
    this.a.e = ((int)(paramSOSOMapLBSApiResult.Longitude * 1000000.0D));
    this.a.a.sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gpz
 * JD-Core Version:    0.7.0.1
 */