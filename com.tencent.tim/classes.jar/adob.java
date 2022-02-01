import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.8;

public class adob
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public adob(ArkAppModuleReg.ModuleQQ.8 param8, aqju paramaqju) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.ak.findViewById(2131365822)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adob
 * JD-Core Version:    0.7.0.1
 */