import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.tencentmap.mapsdk.map.ItemizedOverlay;
import com.tencent.tencentmap.mapsdk.map.ItemizedOverlay.OnFocusChangeListener;
import com.tencent.tencentmap.mapsdk.map.OverlayItem;

public class eqh
  implements ItemizedOverlay.OnFocusChangeListener
{
  public eqh(NearbyTroopsMapView paramNearbyTroopsMapView) {}
  
  public void onFocusChanged(ItemizedOverlay paramItemizedOverlay, OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem == null) {
      NearbyTroopsMapView.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eqh
 * JD-Core Version:    0.7.0.1
 */