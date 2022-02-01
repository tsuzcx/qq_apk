import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class ykj
  extends zoo<ykm>
{
  private LruCache<ykm, Drawable> a = new ykk(this, 5242880);
  
  public LruCache<ykm, Drawable> a()
  {
    return this.a;
  }
  
  public zop a(ImageView paramImageView, ykm paramykm)
  {
    return new ykn(paramImageView, paramykm);
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
      this.a = new ykl(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykj
 * JD-Core Version:    0.7.0.1
 */