import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class wzg
  implements ArkAppCacheMgr.OnGetAppIcon
{
  wzg(wzb.a parama1, wzb.a parama2) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.c.he.setVisibility(0);
      this.b.sN.setVisibility(0);
      this.b.sN.setImageBitmap(paramBitmap);
      return;
    }
    this.b.sN.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzg
 * JD-Core Version:    0.7.0.1
 */