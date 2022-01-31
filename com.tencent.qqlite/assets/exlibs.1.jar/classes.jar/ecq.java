import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.tencent.mobileqq.richstatus.StatusJsHandler;

public class ecq
  implements Runnable
{
  public ecq(StatusJsHandler paramStatusJsHandler, LocationManager paramLocationManager) {}
  
  public void run()
  {
    Object localObject1 = new Criteria();
    ((Criteria)localObject1).setAltitudeRequired(false);
    ((Criteria)localObject1).setBearingRequired(false);
    ((Criteria)localObject1).setCostAllowed(true);
    ((Criteria)localObject1).setPowerRequirement(1);
    try
    {
      ((Criteria)localObject1).setAccuracy(1);
      Object localObject2 = this.jdField_a_of_type_AndroidLocationLocationManager.getBestProvider((Criteria)localObject1, true);
      localObject2 = this.jdField_a_of_type_AndroidLocationLocationManager.getLastKnownLocation((String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.b, ((Location)localObject2).getLongitude() + "," + ((Location)localObject2).getLatitude());
      return;
    }
    catch (Exception localException2)
    {
      try
      {
        ((Criteria)localObject1).setAccuracy(2);
        localObject1 = this.jdField_a_of_type_AndroidLocationLocationManager.getBestProvider((Criteria)localObject1, true);
        localObject1 = this.jdField_a_of_type_AndroidLocationLocationManager.getLastKnownLocation((String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.b, ((Location)localObject1).getLongitude() + "," + ((Location)localObject1).getLatitude());
        return;
      }
      catch (Exception localException1)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler.b, "0, 0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecq
 * JD-Core Version:    0.7.0.1
 */