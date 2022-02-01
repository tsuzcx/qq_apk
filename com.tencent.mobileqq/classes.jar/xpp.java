import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class xpp
  extends yru<xps>
{
  private LruCache<xps, Drawable> a = new xpq(this, 5242880);
  
  public LruCache<xps, Drawable> a()
  {
    return this.a;
  }
  
  public yrv a(ImageView paramImageView, xps paramxps)
  {
    return new xpt(paramImageView, paramxps);
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
      this.a = new xpr(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpp
 * JD-Core Version:    0.7.0.1
 */