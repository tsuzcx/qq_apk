import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.MapWidget.a;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

class aiub
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aiub(aiua paramaiua) {}
  
  public void onGlobalLayout()
  {
    this.a.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    CameraPosition localCameraPosition = this.a.b.mTencentMap.getCameraPosition();
    if (localCameraPosition != null) {
      MapWidget.a(this.a.b).b(localCameraPosition.target);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiub
 * JD-Core Version:    0.7.0.1
 */