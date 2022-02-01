import android.graphics.Point;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.MapWidget.a;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;

public class aiuc
  implements TencentMapGestureListener
{
  private boolean clI;
  private volatile boolean clJ;
  
  public aiuc(MapWidget paramMapWidget) {}
  
  public boolean onDoubleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onDown(float paramFloat1, float paramFloat2)
  {
    this.clJ = true;
    if (MapWidget.a(this.b) != null) {
      MapWidget.a(this.b).a(false, new Point(Math.round(paramFloat1), Math.round(paramFloat2)));
    }
    return false;
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onLongPress(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onMapStable()
  {
    if ((this.clJ) && (MapWidget.a(this.b) != null)) {
      MapWidget.a(this.b).b(this.b.mTencentMap.getCameraPosition().target);
    }
    this.clJ = false;
  }
  
  public boolean onScroll(float paramFloat1, float paramFloat2)
  {
    this.clI = true;
    return false;
  }
  
  public boolean onSingleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onUp(float paramFloat1, float paramFloat2)
  {
    if (this.clI)
    {
      anot.a(null, "CliOper", "", "", "0X800A772", "0X800A772", 0, 0, "", "0", "0", "");
      this.clI = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiuc
 * JD-Core Version:    0.7.0.1
 */