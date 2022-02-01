import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.a;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class arhy
  implements TencentMap.OnCameraChangeListener
{
  public arhy(QQMapView paramQQMapView) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    if ((this.a.a != null) && (!this.a.mIsScrolling))
    {
      this.a.mIsScrolling = true;
      this.a.a.onMapScrollStart(new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D)));
    }
  }
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if (this.a.mIsScrolling) {
      QQMapView.a(this.a, paramCameraPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhy
 * JD-Core Version:    0.7.0.1
 */