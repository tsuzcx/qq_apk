import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class ojd
  implements URLDrawable.URLDrawableListener
{
  ojd(oiy paramoiy) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    oiy.a(this.a, null);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    oiy.a(this.a, null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    oiy.a(this.a, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojd
 * JD-Core Version:    0.7.0.1
 */