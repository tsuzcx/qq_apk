import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class wzi
  implements ArkAppCacheMgr.OnGetAppIcon
{
  wzi(wzh paramwzh) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a.c.he.setVisibility(0);
      this.a.b.sN.setVisibility(0);
      this.a.b.sN.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzi
 * JD-Core Version:    0.7.0.1
 */