import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.location.ui.LocationMapWidget.a;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.List;

class aisd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aisd(aisc paramaisc) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    List localList = LocationMapWidget.a(this.a.a);
    CameraPosition localCameraPosition = this.a.a.mTencentMap.getCameraPosition();
    if (localCameraPosition != null) {
      LocationMapWidget.a(this.a.a).a(localCameraPosition.target, localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisd
 * JD-Core Version:    0.7.0.1
 */