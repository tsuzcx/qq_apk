import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class haq
  extends BitmapDrawable
{
  private final WeakReference a;
  
  public haq(Resources paramResources, Bitmap paramBitmap, har paramhar)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(paramhar);
  }
  
  public har a()
  {
    return (har)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     haq
 * JD-Core Version:    0.7.0.1
 */