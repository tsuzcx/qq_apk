import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class ule
  extends vpj<ulh>
{
  private LruCache<ulh, Drawable> a = new ulf(this, 5242880);
  
  public LruCache<ulh, Drawable> a()
  {
    return this.a;
  }
  
  public vpk a(ImageView paramImageView, ulh paramulh)
  {
    return new uli(paramImageView, paramulh);
  }
  
  public void a()
  {
    super.a();
    b();
  }
  
  public void b()
  {
    super.b();
    try
    {
      this.a.evictAll();
      return;
    }
    catch (Exception localException)
    {
      this.a = new ulg(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ule
 * JD-Core Version:    0.7.0.1
 */