import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

class akuc
  implements TencentLocationListener
{
  private volatile boolean clE = true;
  private Runnable gP = this.gQ;
  
  akuc(akub paramakub, Runnable paramRunnable, MqqHandler paramMqqHandler) {}
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      paramTencentLocation = new LatLng(paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
      if ((paramTencentLocation.getLatitude() == 0.0D) && (paramTencentLocation.getLongitude() == 0.0D)) {
        if (this.clE)
        {
          this.clE = false;
          QLog.e("LocationHandler", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
        }
      }
    }
    for (;;)
    {
      return;
      akub.a(this.this$0, paramTencentLocation);
      if (this.gP != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
        }
        this.z.removeCallbacks(this.gP);
        this.gP = null;
      }
      if (paramInt != 0) {}
      while (QLog.isColorLevel())
      {
        QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. errorCode: " + paramInt + " errorMsg: " + paramString);
        return;
        akub.a(this.this$0, true);
      }
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akuc
 * JD-Core Version:    0.7.0.1
 */