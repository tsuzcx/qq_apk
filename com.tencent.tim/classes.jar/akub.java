import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.location.LocationHandler.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.reflect.Field;
import mqq.os.MqqHandler;

public class akub
{
  private volatile akub.a jdField_a_of_type_Akub$a;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private TencentLocationListener b;
  private double cL = 0.0D;
  private LatLng i;
  
  private void Lu(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Akub$a != null) {
        this.jdField_a_of_type_Akub$a.a(this.i, Double.valueOf(this.cL), paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static akub a()
  {
    return akub.b.b();
  }
  
  private void dtS()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.getClass().getDeclaredField("c");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager);
      Field localField = localObject.getClass().getDeclaredField("b");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      localField = localObject.getClass().getDeclaredField("g");
      localField.setAccessible(true);
      localField.set(localObject, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
  
  public void a(akub.a parama)
  {
    try
    {
      this.jdField_a_of_type_Akub$a = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void b(akub.a parama)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + parama + " mLocationListener: " + this.jdField_a_of_type_Akub$a);
      }
      if (parama == this.jdField_a_of_type_Akub$a) {
        this.jdField_a_of_type_Akub$a = null;
      }
      return;
    }
    finally {}
  }
  
  public void cb(Activity paramActivity)
  {
    LocationHandler.1 local1 = new LocationHandler.1(this);
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
    }
    localMqqHandler.postDelayed(local1, 15000L);
    this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
    this.b = new akuc(this, local1, localMqqHandler);
    this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new akud(this);
    int j = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(60000L), this.b);
    if (j != 0)
    {
      QLog.e("LocationHandler", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + j);
      QQToast.a(BaseApplicationImpl.context, "地图定位系统初始化失败，请稍后重试", 0).show();
      if (paramActivity != null) {
        paramActivity.finish();
      }
    }
    j = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.startDirectionUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener, Looper.myLooper());
    if (j != 0)
    {
      QLog.e("LocationHandler", 1, "[LocationManager] startDirectionUpdates: invoked. error: " + j);
      QQToast.a(BaseApplicationImpl.context, 1, "方向箭头暂不可用", 0).show();
    }
  }
  
  public void dDx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. ");
    }
    if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.b);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
      dtS();
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean);
  }
  
  static final class b
  {
    private static final akub a = new akub();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akub
 * JD-Core Version:    0.7.0.1
 */