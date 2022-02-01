import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class adrq
  implements ArkAppCacheMgr.OnGetAppIcon
{
  adrq(adrp paramadrp) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      adrm.a(this.a.this$0, paramBitmap, this.a.val$context);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrq
 * JD-Core Version:    0.7.0.1
 */