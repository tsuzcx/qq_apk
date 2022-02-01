import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.tencentmap.mapsdk.map.ItemizedOverlay;
import com.tencent.tencentmap.mapsdk.map.ItemizedOverlay.OnFocusChangeListener;
import com.tencent.tencentmap.mapsdk.map.OverlayItem;

public class gzd
  implements ItemizedOverlay.OnFocusChangeListener
{
  public gzd(NearbyTroopsMapView paramNearbyTroopsMapView) {}
  
  public void onFocusChanged(ItemizedOverlay paramItemizedOverlay, OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem == null) {
      NearbyTroopsMapView.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzd
 * JD-Core Version:    0.7.0.1
 */