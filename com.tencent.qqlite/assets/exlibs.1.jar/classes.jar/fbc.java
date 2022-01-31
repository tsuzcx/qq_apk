import android.os.Handler;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class fbc
  extends Thread
{
  public fbc(QQMapView paramQQMapView, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    for (;;)
    {
      if (this.a.e <= 0) {
        try
        {
          if (this.a.jdField_a_of_type_JavaLangThread != null) {
            synchronized (this.a.jdField_a_of_type_JavaLangThread)
            {
              this.a.e = 0;
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
        int i = Math.abs(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() - localGeoPoint.getLatitudeE6());
        int j = Math.abs(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() - localGeoPoint.getLongitudeE6());
        if ((i < 1) && (j < 1) && (this.a.d) && (!this.a.c))
        {
          this.a.d = false;
          if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.a(0, localGeoPoint));
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = localGeoPoint;
      this.a.e = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fbc
 * JD-Core Version:    0.7.0.1
 */