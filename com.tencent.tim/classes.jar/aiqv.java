import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

class aiqv
  implements TencentLocationListener
{
  private volatile boolean clE = true;
  private volatile boolean clF;
  private Runnable gP;
  
  aiqv(aiqs paramaiqs, boolean paramBoolean, Runnable paramRunnable, MqqHandler paramMqqHandler, LocationRoom paramLocationRoom)
  {
    if (!this.clG) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.clF = paramBoolean;
      this.gP = this.gQ;
      return;
    }
  }
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      LatLng localLatLng = new LatLng(paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
      paramTencentLocation = localLatLng;
      if (QLog.isColorLevel())
      {
        paramTencentLocation = localLatLng;
        if (aiqs.h != null) {
          paramTencentLocation = aiqs.h;
        }
      }
      if ((paramTencentLocation.getLatitude() == 0.0D) && (paramTencentLocation.getLongitude() == 0.0D))
      {
        if (this.clE)
        {
          this.clE = false;
          QLog.e("LocationHandler", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
        }
        return;
      }
      aiqs.a(this.this$0, paramTencentLocation);
    }
    if ((this.clF) && (this.gP != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
      }
      this.z.removeCallbacks(this.gP);
      this.gP = null;
    }
    if (paramInt != 0)
    {
      paramTencentLocation = this.a.a();
      aitg.a(this.this$0.app, paramTencentLocation.getSessionType(), paramTencentLocation.xc(), 1);
    }
    for (;;)
    {
      if ((paramInt == 0) || (HwNetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))) {
        MagnifierSDK.a().a().onGPSScan("requestSoso", new Object[] { Integer.valueOf(-1), Boolean.valueOf(false), "LocationHandler", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. errorCode: " + paramInt + " errorMsg: " + paramString);
      return;
      if (this.clF)
      {
        this.clF = false;
        this.this$0.dk(aiqs.a(this.this$0).getSessionType(), aiqs.a(this.this$0).xc());
      }
      aiqs.a(this.this$0, true);
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqv
 * JD-Core Version:    0.7.0.1
 */