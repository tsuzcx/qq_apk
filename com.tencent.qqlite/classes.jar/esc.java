import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class esc
  extends BitmapDrawable
{
  private final WeakReference a;
  
  public esc(Resources paramResources, Bitmap paramBitmap, esd paramesd)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(paramesd);
  }
  
  public esd a()
  {
    return (esd)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     esc
 * JD-Core Version:    0.7.0.1
 */