import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity.UIHandler;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;

public class gqb
  implements Runnable
{
  public gqb(NearbyTroopsActivity.UIHandler paramUIHandler) {}
  
  public void run()
  {
    this.a.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMaxZoomLevel() - 1);
    this.a.a.a(this.a.a.d, this.a.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gqb
 * JD-Core Version:    0.7.0.1
 */