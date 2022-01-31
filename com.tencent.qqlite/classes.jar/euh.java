import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class euh
  extends BitmapDrawable
{
  private final WeakReference a;
  
  public euh(Resources paramResources, Bitmap paramBitmap, eui parameui)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(parameui);
  }
  
  public eui a()
  {
    return (eui)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     euh
 * JD-Core Version:    0.7.0.1
 */