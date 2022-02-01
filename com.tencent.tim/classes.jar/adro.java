import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class adro
  implements ArkAppCacheMgr.OnGetAppIcon
{
  adro(adrm paramadrm, Context paramContext) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      adrm.a(this.this$0, paramBitmap, this.val$context);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adro
 * JD-Core Version:    0.7.0.1
 */