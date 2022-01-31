import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class wqy
  extends xvd<wrb>
{
  private LruCache<wrb, Drawable> a = new wqz(this, 5242880);
  
  public LruCache<wrb, Drawable> a()
  {
    return this.a;
  }
  
  public xve a(ImageView paramImageView, wrb paramwrb)
  {
    return new wrc(paramImageView, paramwrb);
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
      this.a = new wra(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqy
 * JD-Core Version:    0.7.0.1
 */