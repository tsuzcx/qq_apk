import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class qbz
  implements URLDrawable.URLDrawableListener
{
  qbz(qby paramqby) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    qby.c(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    qby.b(this.a, false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.p("UrlDrawableDownloadJob_dra", paramURLDrawable.getCurrDrawable());
    qby.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbz
 * JD-Core Version:    0.7.0.1
 */