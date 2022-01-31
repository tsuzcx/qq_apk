import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class zay
  implements URLDrawable.URLDrawableListener
{
  zay(zax paramzax) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    zax.a(this.a, paramURLDrawable);
    yxp.b("GdtDrawableLoader", "onLoadCanceled " + zax.a(this.a));
    zax.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    zax.a(this.a, paramURLDrawable);
    yxp.d("GdtDrawableLoader", "onLoadFialed " + zax.a(this.a), paramThrowable);
    if (!zax.a(this.a)) {
      zax.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    zax.a(this.a, paramURLDrawable);
    yxp.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + zax.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    zax.a(this.a, paramURLDrawable);
    yxp.b("GdtDrawableLoader", "onLoadSuccessed " + zax.a(this.a));
    zax.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zay
 * JD-Core Version:    0.7.0.1
 */