import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qphone.base.util.QLog;

public class dcz
  extends SOSOMapLBSApiListener
{
  public dcz(QQMapActivity paramQQMapActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    String str;
    if (paramSOSOMapLBSApiResult.Address == null)
    {
      str = "";
      if (QLog.isColorLevel()) {
        QLog.d("get_location", 2, "get location finish, latitude = " + paramSOSOMapLBSApiResult.Latitude + " longitude=" + paramSOSOMapLBSApiResult.Longitude + " address=" + str);
      }
      if (paramSOSOMapLBSApiResult.Info != 1) {
        break label113;
      }
      this.a.runOnUiThread(new dda(this, paramSOSOMapLBSApiResult, str));
    }
    for (;;)
    {
      label113:
      try
      {
        this.a.dismissDialog(0);
        return;
      }
      catch (IllegalArgumentException paramSOSOMapLBSApiResult) {}
      str = paramSOSOMapLBSApiResult.Address;
      break;
      this.a.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dcz
 * JD-Core Version:    0.7.0.1
 */