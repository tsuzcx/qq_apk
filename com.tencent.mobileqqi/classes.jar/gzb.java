import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView.NearbyTroopsMapViewObserver;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class gzb
  extends Handler
{
  public gzb(NearbyTroopsMapView paramNearbyTroopsMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        return;
        if (paramMessage.what != 3) {
          break;
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem == null);
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapViewOverlayItem);
      return;
    } while ((paramMessage.obj == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver == null));
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 0: 
      paramMessage = (GeoPoint)paramMessage.obj;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver.a(paramMessage);
      return;
    case 1: 
      paramMessage = (GeoPoint)paramMessage.obj;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver.b(paramMessage);
      return;
    }
    paramMessage = (Point)paramMessage.obj;
    int i = paramMessage.x;
    int j = paramMessage.y;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView$NearbyTroopsMapViewObserver.b(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzb
 * JD-Core Version:    0.7.0.1
 */