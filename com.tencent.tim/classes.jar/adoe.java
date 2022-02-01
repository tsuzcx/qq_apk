import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9;

public class adoe
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public adoe(ArkAppModuleReg.ModuleQQ.9 param9, aqju paramaqju) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.ak.findViewById(2131365822)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adoe
 * JD-Core Version:    0.7.0.1
 */