import android.widget.ImageView;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;

class bea
  implements Runnable
{
  bea(bdz parambdz, SOSOMapLBSApiResult paramSOSOMapLBSApiResult, String paramString) {}
  
  public void run()
  {
    GeoPoint localGeoPoint = new GeoPoint((int)(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Latitude * 1000000.0D), (int)(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Longitude * 1000000.0D));
    this.jdField_a_of_type_Bdz.a.a.setCenter(localGeoPoint);
    if (this.jdField_a_of_type_Bdz.a.h) {}
    for (;;)
    {
      this.jdField_a_of_type_Bdz.a.a(localGeoPoint, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bdz.a.h();
      return;
      this.jdField_a_of_type_Bdz.a.j = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bdz.a.b.setVisibility(0);
      this.jdField_a_of_type_Bdz.a.c.setVisibility(0);
      this.jdField_a_of_type_Bdz.a.a(localGeoPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bea
 * JD-Core Version:    0.7.0.1
 */