import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class uxx
  extends wcc<uya>
{
  private LruCache<uya, Drawable> a = new uxy(this, 5242880);
  
  public LruCache<uya, Drawable> a()
  {
    return this.a;
  }
  
  public wcd a(ImageView paramImageView, uya paramuya)
  {
    return new uyb(paramImageView, paramuya);
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
      this.a = new uxz(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxx
 * JD-Core Version:    0.7.0.1
 */