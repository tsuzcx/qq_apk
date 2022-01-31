import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class erx
  extends BitmapDrawable
{
  private final WeakReference a;
  
  public erx(Resources paramResources, Bitmap paramBitmap, ery paramery)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(paramery);
  }
  
  public ery a()
  {
    return (ery)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erx
 * JD-Core Version:    0.7.0.1
 */