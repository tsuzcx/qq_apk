import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget.a;
import com.tencent.mobileqq.location.ui.MapWidget.b;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class aivc
  implements MapWidget.a
{
  aivc(aiuz paramaiuz) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.a.E(paramList);
        if (localBitmap != null)
        {
          localBitmap = aqhu.r(localBitmap, 16, 16);
          aiuz.a(this.a).u(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint) {}
  
  public void a(boolean paramBoolean, MapWidget.b paramb) {}
  
  public void b(LocationRoom.Venue paramVenue) {}
  
  public void b(LatLng paramLatLng) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivc
 * JD-Core Version:    0.7.0.1
 */