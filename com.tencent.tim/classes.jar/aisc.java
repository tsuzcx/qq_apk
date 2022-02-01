import android.view.ViewTreeObserver;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.location.ui.LocationMapWidget.a;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.List;

public class aisc
  implements TencentMap.OnMapLoadedCallback
{
  public aisc(LocationMapWidget paramLocationMapWidget) {}
  
  public void onMapLoaded()
  {
    if (LocationMapWidget.a(this.a) != null)
    {
      if (this.a.mTencentMap.getCameraPosition() == null) {
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new aisd(this));
      }
    }
    else {
      return;
    }
    List localList = LocationMapWidget.a(this.a);
    LocationMapWidget.a(this.a).a(this.a.mTencentMap.getCameraPosition().target, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisc
 * JD-Core Version:    0.7.0.1
 */