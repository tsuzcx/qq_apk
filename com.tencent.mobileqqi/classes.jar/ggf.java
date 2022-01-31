import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;

public class ggf
  implements Runnable
{
  public ggf(RoamingActivity paramRoamingActivity) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMaxZoomLevel() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ggf
 * JD-Core Version:    0.7.0.1
 */