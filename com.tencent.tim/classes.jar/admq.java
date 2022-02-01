import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3;

public class admq
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public admq(ArkAppDeviceModule.ObserverMethod.3 param3, aqju paramaqju) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.ak.findViewById(2131365822)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admq
 * JD-Core Version:    0.7.0.1
 */