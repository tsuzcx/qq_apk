import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class adrg
  implements ArkAppCacheMgr.OnGetAppIcon
{
  adrg(adrf paramadrf) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a.a.he.setVisibility(0);
      this.a.a.sN.setVisibility(0);
      this.a.a.sN.setImageBitmap(paramBitmap);
      return;
    }
    this.a.a.sN.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrg
 * JD-Core Version:    0.7.0.1
 */