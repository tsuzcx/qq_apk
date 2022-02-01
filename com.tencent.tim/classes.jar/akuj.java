import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.location.ui.LocationMapWidget.a;
import com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

public class akuj
  implements LocationMapWidget.a
{
  private long JZ;
  
  public akuj(OnlineStatusLocationFragment paramOnlineStatusLocationFragment) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList) {}
  
  public void a(LatLng paramLatLng, List<String> paramList)
  {
    if (System.currentTimeMillis() - this.JZ < 1000L) {}
    for (;;)
    {
      return;
      this.JZ = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusLocationFragment", 2, "onMapStable onClick: invoked. center: " + paramLatLng);
      }
      OnlineStatusLocationFragment.a(this.this$0, paramLatLng);
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
            OnlineStatusLocationFragment.a(this.this$0).u(paramList, localBitmap);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      this.this$0.AX.setClickable(false);
      if (auvj.isNightMode()) {
        this.this$0.AX.setImageDrawable(this.this$0.getActivity().getResources().getDrawable(2130841359));
      }
    }
    Rect localRect;
    do
    {
      return;
      this.this$0.AX.setImageDrawable(this.this$0.getActivity().getResources().getDrawable(2130841358));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      this.this$0.AX.getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    this.this$0.AX.setClickable(true);
    this.this$0.AX.setImageDrawable(this.this$0.getActivity().getResources().getDrawable(2130841360));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akuj
 * JD-Core Version:    0.7.0.1
 */