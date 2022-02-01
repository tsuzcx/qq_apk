import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class hap
  extends BitmapDrawable
{
  private final WeakReference a;
  
  public hap(Resources paramResources, Bitmap paramBitmap, haq paramhaq)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(paramhaq);
  }
  
  public haq a()
  {
    return (haq)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hap
 * JD-Core Version:    0.7.0.1
 */