import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;

public class aiuf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aiuf(MapWidget paramMapWidget, ViewTreeObserver paramViewTreeObserver) {}
  
  public void onGlobalLayout()
  {
    this.a.removeGlobalOnLayoutListener(this);
    if (this.b.a != null) {
      MapWidget.a(this.b, this.b.a.getPoints());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiuf
 * JD-Core Version:    0.7.0.1
 */