import android.widget.TextView;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;

class gbz
  implements Runnable
{
  gbz(gby paramgby, SOSOMapLBSApiResult paramSOSOMapLBSApiResult, String paramString) {}
  
  public void run()
  {
    GeoPoint localGeoPoint = new GeoPoint((int)(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Latitude * 1000000.0D), (int)(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Longitude * 1000000.0D));
    this.jdField_a_of_type_Gby.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = localGeoPoint;
    this.jdField_a_of_type_Gby.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(localGeoPoint);
    this.jdField_a_of_type_Gby.a.f = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Gby.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(this.jdField_a_of_type_Gby.a.f);
    this.jdField_a_of_type_Gby.a.b.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Gby.a.b.startAnimation(this.jdField_a_of_type_Gby.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gbz
 * JD-Core Version:    0.7.0.1
 */