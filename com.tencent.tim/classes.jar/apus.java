import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView.a;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class apus
  extends Handler
{
  public apus(AutoLocationMapView paramAutoLocationMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint = (GeoPoint)paramMessage.obj;
    this.b.getMap().clear();
    if (paramMessage.arg1 == 0)
    {
      this.b.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D)));
      this.b.getMap().moveCamera(CameraUpdateFactory.zoomTo(this.b.getMap().getMaxZoomLevel()));
      Bitmap localBitmap = aqcu.decodeResource(this.b.getContext().getResources(), 2130843334);
      this.b.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(localBitmap)).snippet("").position(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D))).showInfoWindow();
    }
    if (this.b.a != null) {
      this.b.a.b(paramMessage.arg1, localGeoPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apus
 * JD-Core Version:    0.7.0.1
 */