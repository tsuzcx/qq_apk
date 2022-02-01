import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class uhp
  implements URLDrawable.URLDrawableListener
{
  uhp(uhk paramuhk) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    uhk.a(this.a, null);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    uhk.a(this.a, null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    uhk.a(this.a, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhp
 * JD-Core Version:    0.7.0.1
 */