import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class uya
  extends wcf<uyd>
{
  private LruCache<uyd, Drawable> a = new uyb(this, 5242880);
  
  public LruCache<uyd, Drawable> a()
  {
    return this.a;
  }
  
  public wcg a(ImageView paramImageView, uyd paramuyd)
  {
    return new uye(paramImageView, paramuyd);
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
      this.a = new uyc(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uya
 * JD-Core Version:    0.7.0.1
 */