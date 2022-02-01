import android.content.Context;
import android.graphics.Point;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class adln
  implements TencentMap.OnMapLoadedCallback
{
  public adln(ARScanEntryView paramARScanEntryView) {}
  
  public void onMapLoaded()
  {
    this.this$0.bPv = true;
    if (ARScanEntryView.a(this.this$0) != null)
    {
      Projection localProjection = ARScanEntryView.a(this.this$0).getMap().getProjection();
      TencentMap localTencentMap = ARScanEntryView.a(this.this$0).getMap();
      if ((localProjection != null) && (localTencentMap != null))
      {
        Point localPoint = localProjection.toScreenLocation(localTencentMap.getCameraPosition().target);
        if (localPoint != null)
        {
          localPoint.offset(0, wja.dp2px(60.0F, this.this$0.mContext.getResources()) * -1);
          localTencentMap.moveCamera(CameraUpdateFactory.newLatLng(localProjection.fromScreenLocation(localPoint)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adln
 * JD-Core Version:    0.7.0.1
 */