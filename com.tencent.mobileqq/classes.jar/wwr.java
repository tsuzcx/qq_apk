import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class wwr
  implements URLDrawable.URLDrawableListener
{
  wwr(wwq paramwwq) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    wwq.c(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    wwq.b(this.a, false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a("UrlDrawableDownloadJob_dra", paramURLDrawable.getCurrDrawable());
    wwq.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwr
 * JD-Core Version:    0.7.0.1
 */