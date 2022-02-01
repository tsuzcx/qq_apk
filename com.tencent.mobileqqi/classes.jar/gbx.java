import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;

public class gbx
  extends SOSOMapLBSApiListener
{
  public gbx(RoamingActivity paramRoamingActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    if (paramSOSOMapLBSApiResult.Address == null) {}
    for (String str = "";; str = paramSOSOMapLBSApiResult.Address)
    {
      if (paramSOSOMapLBSApiResult.Info == 1) {
        this.a.runOnUiThread(new gby(this, paramSOSOMapLBSApiResult, str));
      }
      try
      {
        this.a.dismissDialog(0);
        return;
      }
      catch (IllegalArgumentException paramSOSOMapLBSApiResult)
      {
        paramSOSOMapLBSApiResult.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gbx
 * JD-Core Version:    0.7.0.1
 */