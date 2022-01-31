import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView.AutoLocationCallback;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.Overlay;

public class epd
  extends Handler
{
  public epd(AutoLocationMapView paramAutoLocationMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint = (GeoPoint)paramMessage.obj;
    this.a.clearAllOverlays();
    if (paramMessage.arg1 == 0)
    {
      Object localObject = this.a.getController();
      ((MapController)localObject).setCenter(localGeoPoint);
      ((MapController)localObject).setZoom(this.a.getMaxZoomLevel());
      localObject = new epf(BitmapManager.a(this.a.getContext().getResources(), 2130838290), localGeoPoint);
      this.a.addOverlay((Overlay)localObject);
    }
    if (this.a.a != null) {
      this.a.a.a(paramMessage.arg1, localGeoPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     epd
 * JD-Core Version:    0.7.0.1
 */