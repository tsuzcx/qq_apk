import android.widget.ImageView;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;

class ddb
  implements Runnable
{
  ddb(dda paramdda, SOSOMapLBSApiResult paramSOSOMapLBSApiResult, String paramString) {}
  
  public void run()
  {
    GeoPoint localGeoPoint = new GeoPoint((int)(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Latitude * 1000000.0D), (int)(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Longitude * 1000000.0D));
    this.jdField_a_of_type_Dda.a.a.setCenter(localGeoPoint);
    if (this.jdField_a_of_type_Dda.a.h) {}
    for (;;)
    {
      this.jdField_a_of_type_Dda.a.a(localGeoPoint, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Dda.a.h();
      return;
      this.jdField_a_of_type_Dda.a.j = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Dda.a.b.setVisibility(0);
      this.jdField_a_of_type_Dda.a.c.setVisibility(0);
      this.jdField_a_of_type_Dda.a.a(localGeoPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddb
 * JD-Core Version:    0.7.0.1
 */