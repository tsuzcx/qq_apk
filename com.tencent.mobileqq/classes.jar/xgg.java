import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class xgg
  implements URLDrawable.URLDrawableListener
{
  xgg(xgf paramxgf) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    xgf.c(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    xgf.b(this.a, false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a("UrlDrawableDownloadJob_dra", paramURLDrawable.getCurrDrawable());
    xgf.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgg
 * JD-Core Version:    0.7.0.1
 */