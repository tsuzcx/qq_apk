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
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class aisp
  implements MapWidget.a
{
  private long JZ;
  
  aisp(aisj paramaisj, Activity paramActivity) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.this$0.E(paramList);
        if (localBitmap != null)
        {
          localBitmap = aqhu.r(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          aisj.a(this.this$0).u(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      aisj.a(this.this$0).setClickable(false);
      if (auvj.isNightMode()) {
        aisj.a(this.this$0).setImageDrawable(this.val$activity.getResources().getDrawable(2130841359));
      }
    }
    Rect localRect;
    do
    {
      return;
      aisj.a(this.this$0).setImageDrawable(this.val$activity.getResources().getDrawable(2130841358));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      aisj.a(this.this$0).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    aisj.a(this.this$0).setClickable(true);
    aisj.a(this.this$0).setImageDrawable(this.val$activity.getResources().getDrawable(2130841360));
  }
  
  public void a(boolean paramBoolean, MapWidget.b paramb) {}
  
  public void b(LocationRoom.Venue paramVenue) {}
  
  public void b(LatLng paramLatLng)
  {
    if (System.currentTimeMillis() - this.JZ < 1000L) {
      return;
    }
    this.JZ = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onMapStable onClick: invoked. center: " + paramLatLng);
    }
    aisj.a(this.this$0, paramLatLng);
    aisj.a(this.this$0).a(aisj.a(this.this$0), aisj.a(this.this$0).getMap(), paramLatLng, "");
    anot.a(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisp
 * JD-Core Version:    0.7.0.1
 */