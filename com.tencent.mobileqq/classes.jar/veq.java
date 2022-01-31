import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class veq
  implements URLDrawable.URLDrawableListener
{
  veq(vep paramvep) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    vep.c(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    vep.b(this.a, false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a("UrlDrawableDownloadJob_dra", paramURLDrawable.getCurrDrawable());
    vep.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     veq
 * JD-Core Version:    0.7.0.1
 */