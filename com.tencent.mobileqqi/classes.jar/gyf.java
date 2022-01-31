import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView.AutoLocationCallback;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.Overlay;

public class gyf
  extends Handler
{
  public gyf(AutoLocationMapView paramAutoLocationMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint = (GeoPoint)paramMessage.obj;
    this.a.clearAllOverlays();
    if (paramMessage.arg1 == 0)
    {
      Object localObject = this.a.getController();
      ((MapController)localObject).setCenter(localGeoPoint);
      ((MapController)localObject).setZoom(this.a.getMaxZoomLevel());
      localObject = new gyh(BitmapManager.a(this.a.getContext().getResources(), 2130838399), localGeoPoint);
      this.a.addOverlay((Overlay)localObject);
    }
    if (this.a.a != null) {
      this.a.a.a(paramMessage.arg1, localGeoPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gyf
 * JD-Core Version:    0.7.0.1
 */