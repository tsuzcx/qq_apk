import android.view.ViewTreeObserver;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.MapWidget.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class aiua
  implements TencentMap.OnMapLoadedCallback
{
  public aiua(MapWidget paramMapWidget) {}
  
  public void onMapLoaded()
  {
    aiqn localaiqn = this.b.b.a();
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. selfItem: ", localaiqn.a() });
    }
    if ((localaiqn.a() != null) && (!aitz.a(this.b.getContext(), this.b.mTencentMap, localaiqn.a())))
    {
      this.b.Lv(false);
      this.b.setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. success moveMapToSelfCenter selfItem: ", localaiqn.a() });
      }
    }
    for (;;)
    {
      if (MapWidget.a(this.b) != null)
      {
        if (this.b.mTencentMap.getCameraPosition() != null) {
          break;
        }
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new aiub(this));
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. failed moveMapToSelfCenter selfItem: ", localaiqn.a() });
      }
    }
    MapWidget.a(this.b).b(this.b.mTencentMap.getCameraPosition().target);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiua
 * JD-Core Version:    0.7.0.1
 */