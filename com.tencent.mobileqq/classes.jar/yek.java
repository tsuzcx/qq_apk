import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class yek
  extends zgn<yen>
{
  private LruCache<yen, Drawable> a = new yel(this, 5242880);
  
  public LruCache<yen, Drawable> a()
  {
    return this.a;
  }
  
  public zgo a(ImageView paramImageView, yen paramyen)
  {
    return new yeo(paramImageView, paramyen);
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
      this.a = new yem(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yek
 * JD-Core Version:    0.7.0.1
 */