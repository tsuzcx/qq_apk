import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class yoe
  extends zsj<yoh>
{
  private LruCache<yoh, Drawable> a = new yof(this, 5242880);
  
  public LruCache<yoh, Drawable> a()
  {
    return this.a;
  }
  
  public zsk a(ImageView paramImageView, yoh paramyoh)
  {
    return new yoi(paramImageView, paramyoh);
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
      this.a = new yog(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yoe
 * JD-Core Version:    0.7.0.1
 */