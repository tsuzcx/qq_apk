import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class tpy
  implements URLDrawable.URLDrawableListener
{
  tpy(tpx paramtpx) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    tpx.c(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    tpx.b(this.a, false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a("UrlDrawableDownloadJob_dra", paramURLDrawable.getCurrDrawable());
    tpx.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpy
 * JD-Core Version:    0.7.0.1
 */