import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class hex
  extends BitmapDrawable
{
  private final WeakReference a;
  
  public hex(Resources paramResources, Bitmap paramBitmap, hey paramhey)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(paramhey);
  }
  
  public hey a()
  {
    return (hey)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hex
 * JD-Core Version:    0.7.0.1
 */