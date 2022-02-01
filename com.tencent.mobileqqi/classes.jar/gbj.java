import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class gbj
  implements Runnable
{
  public gbj(RoamingActivity paramRoamingActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
    {
      GeoPoint localGeoPoint = this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
      if (!this.a.a(localGeoPoint)) {
        this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = localGeoPoint;
      }
      RoamingActivity.a(this.a, this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint, this.a.b, new gbk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gbj
 * JD-Core Version:    0.7.0.1
 */