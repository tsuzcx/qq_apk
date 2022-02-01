import android.graphics.Point;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.location.ui.LocationMapWidget.a;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import java.util.List;

public class aise
  implements TencentMapGestureListener
{
  private boolean clI;
  private volatile boolean clJ;
  
  public aise(LocationMapWidget paramLocationMapWidget) {}
  
  public boolean onDoubleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onDown(float paramFloat1, float paramFloat2)
  {
    this.clJ = true;
    if (LocationMapWidget.a(this.a) != null) {
      LocationMapWidget.a(this.a).a(false, new Point(Math.round(paramFloat1), Math.round(paramFloat2)));
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
    if ((this.clJ) && (LocationMapWidget.a(this.a) != null))
    {
      List localList = LocationMapWidget.a(this.a);
      LocationMapWidget.a(this.a).a(this.a.mTencentMap.getCameraPosition().target, localList);
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
 * Qualified Name:     aise
 * JD-Core Version:    0.7.0.1
 */