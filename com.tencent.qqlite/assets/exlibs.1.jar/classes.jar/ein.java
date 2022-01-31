import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;

public class ein
  implements Runnable
{
  public ein(NearbyTroopsView.UIHandler paramUIHandler) {}
  
  public void run()
  {
    this.a.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMaxZoomLevel() - 1);
    this.a.a.a(this.a.a.d, this.a.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ein
 * JD-Core Version:    0.7.0.1
 */