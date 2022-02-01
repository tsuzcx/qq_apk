import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.a;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.MapWidget.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import java.lang.ref.SoftReference;
import java.util.Map;

public class aiuh
  implements LocationRoom.a
{
  public aiuh(MapWidget paramMapWidget) {}
  
  public void LU(String paramString)
  {
    Marker localMarker = (Marker)MapWidget.a(this.b).get(paramString);
    if (localMarker != null)
    {
      localMarker.remove();
      MapWidget.a(this.b).remove(paramString);
    }
    localMarker = (Marker)this.b.lB.get(paramString);
    if (localMarker != null)
    {
      localMarker.remove();
      this.b.lB.remove(paramString);
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    Object localObject = (aekm)aeif.a().o(575);
    if (localObject != null) {}
    for (localObject = ((aekm)localObject).tj();; localObject = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = this.b.mTencentMap.addMarker(new MarkerOptions(paramVenue.g).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromResource(2130841386)));; localObject = this.b.mTencentMap.addMarker(new MarkerOptions(paramVenue.g).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromBitmap((Bitmap)localObject))))
      {
        if (localObject != null)
        {
          paramVenue.t = new SoftReference(localObject);
          MapWidget.a(this.b, (Marker)localObject);
          ((Marker)localObject).setClickable(false);
          ((Marker)localObject).refreshInfoWindow();
        }
        if (MapWidget.a(this.b) != null) {
          MapWidget.a(this.b).b(paramVenue);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MapWidget", 2, new Object[] { "[map][venue]onNewVenue invoked. Result venue: ", paramVenue });
        }
        return;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).downloadImediatly();
        localObject = aqhu.drawableToBitmap((Drawable)localObject);
      }
    }
  }
  
  public void dtN()
  {
    if (this.b.a != null) {
      this.b.a.remove();
    }
    if (MapWidget.a(this.b) != null) {
      MapWidget.a(this.b).b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiuh
 * JD-Core Version:    0.7.0.1
 */