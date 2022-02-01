import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.MapWidget.a;
import com.tencent.mobileqq.location.ui.MapWidget.b;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class aitl
  implements MapWidget.a
{
  aitl(aitg paramaitg, Activity paramActivity) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.b.E(paramList);
        if (localBitmap != null)
        {
          localBitmap = aqhu.r(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          aitg.a(this.b).u(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      aitg.a(this.b).setClickable(false);
      if (auvj.isNightMode()) {
        aitg.a(this.b).setImageDrawable(this.val$activity.getResources().getDrawable(2130841359));
      }
    }
    Rect localRect;
    do
    {
      return;
      aitg.a(this.b).setImageDrawable(this.val$activity.getResources().getDrawable(2130841358));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      aitg.a(this.b).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    aitg.a(this.b).setClickable(true);
    aitg.a(this.b).setImageDrawable(this.val$activity.getResources().getDrawable(2130841360));
  }
  
  public void a(boolean paramBoolean, MapWidget.b paramb)
  {
    aitg.a(this.b, paramBoolean, paramb);
  }
  
  public void b(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      aitg.a(this.b);
      return;
    }
    aitg.b(this.b);
  }
  
  public void b(LatLng paramLatLng) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitl
 * JD-Core Version:    0.7.0.1
 */