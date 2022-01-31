import android.graphics.Point;
import android.os.Handler;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class erw
  extends Thread
{
  public erw(NearbyTroopsMapView paramNearbyTroopsMapView, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    if (this.a.i <= 0) {
      try
      {
        while (this.a.jdField_a_of_type_JavaLangThread != null) {
          synchronized (this.a.jdField_a_of_type_JavaLangThread)
          {
            this.a.i = 0;
            this.a.b = true;
            wait();
          }
        }
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    this.a.b = false;
    GeoPoint localGeoPoint = this.a.getMapCenter();
    if ((this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null) && (localGeoPoint != null))
    {
      if ((Math.abs(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() - localGeoPoint.getLatitudeE6()) >= 1) || (Math.abs(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() - localGeoPoint.getLongitudeE6()) >= 1)) {
        break label284;
      }
      if ((this.a.d) && (!this.a.c))
      {
        this.a.d = false;
        if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.a(0, localGeoPoint));
        }
      }
    }
    for (;;)
    {
      int i = this.a.getZoomLevel();
      if ((this.a.j != i) && (this.a.jdField_a_of_type_AndroidOsHandler != null)) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.a(2, new Point(this.a.j, i)));
      }
      this.a.j = i;
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = localGeoPoint;
      this.a.i = 0;
      break;
      label284:
      if ((!this.a.d) && (this.a.c))
      {
        this.a.d = true;
        if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.a(1, localGeoPoint));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     erw
 * JD-Core Version:    0.7.0.1
 */