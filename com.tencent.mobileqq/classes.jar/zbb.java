import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class zbb
  implements URLDrawable.URLDrawableListener
{
  zbb(zba paramzba) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    zba.a(this.a, paramURLDrawable);
    yxs.b("GdtDrawableLoader", "onLoadCanceled " + zba.a(this.a));
    zba.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    zba.a(this.a, paramURLDrawable);
    yxs.d("GdtDrawableLoader", "onLoadFialed " + zba.a(this.a), paramThrowable);
    if (!zba.a(this.a)) {
      zba.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    zba.a(this.a, paramURLDrawable);
    yxs.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + zba.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    zba.a(this.a, paramURLDrawable);
    yxs.b("GdtDrawableLoader", "onLoadSuccessed " + zba.a(this.a));
    zba.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zbb
 * JD-Core Version:    0.7.0.1
 */