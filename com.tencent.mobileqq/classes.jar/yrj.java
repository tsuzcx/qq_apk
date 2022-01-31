import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class yrj
  implements URLDrawable.URLDrawableListener
{
  yrj(yri paramyri) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    yri.a(this.a, paramURLDrawable);
    yny.b("GdtDrawableLoader", "onLoadCanceled " + yri.a(this.a));
    yri.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    yri.a(this.a, paramURLDrawable);
    yny.d("GdtDrawableLoader", "onLoadFialed " + yri.a(this.a), paramThrowable);
    if (!yri.a(this.a)) {
      yri.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    yri.a(this.a, paramURLDrawable);
    yny.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + yri.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    yri.a(this.a, paramURLDrawable);
    yny.b("GdtDrawableLoader", "onLoadSuccessed " + yri.a(this.a));
    yri.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yrj
 * JD-Core Version:    0.7.0.1
 */