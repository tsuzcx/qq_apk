import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.6;

public class admw
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public admw(ArkAppDeviceModule.ObserverMethod.6 param6, aqju paramaqju) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.ak.findViewById(2131365822)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admw
 * JD-Core Version:    0.7.0.1
 */