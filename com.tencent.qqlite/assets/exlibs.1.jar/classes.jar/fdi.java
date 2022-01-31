import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.BragActivity;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class fdi
  implements ImageLoader.ImageLoadListener
{
  public fdi(BragActivity paramBragActivity) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.a.a.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fdi
 * JD-Core Version:    0.7.0.1
 */