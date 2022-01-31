import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class wmp
  extends xqu<wms>
{
  private LruCache<wms, Drawable> a = new wmq(this, 5242880);
  
  public LruCache<wms, Drawable> a()
  {
    return this.a;
  }
  
  public xqv a(ImageView paramImageView, wms paramwms)
  {
    return new wmt(paramImageView, paramwms);
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
      this.a = new wmr(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmp
 * JD-Core Version:    0.7.0.1
 */