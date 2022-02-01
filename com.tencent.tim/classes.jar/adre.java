import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class adre
  implements ArkAppCacheMgr.OnGetAppIcon
{
  adre(adrd paramadrd, adrd.a parama) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a.he.setVisibility(0);
      this.a.sN.setVisibility(0);
      this.a.sN.setImageBitmap(paramBitmap);
      return;
    }
    this.a.sN.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adre
 * JD-Core Version:    0.7.0.1
 */