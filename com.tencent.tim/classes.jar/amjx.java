import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

final class amjx
  implements URLDrawable.URLDrawableListener2
{
  amjx(SoftReference paramSoftReference, URLDrawable paramURLDrawable, amju.a parama) {}
  
  public void onFileDownloaded(URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.B.get() == null) {}
    do
    {
      do
      {
        return;
        paramURLDrawable = (URLImageView)this.B.get();
      } while (!(this.g.getCurrDrawable() instanceof GifDrawable));
      AbstractGifImage localAbstractGifImage = ((GifDrawable)this.g.getCurrDrawable()).getImage();
      localAbstractGifImage.reset();
      localAbstractGifImage.setStrongGIFPlayOnceListener(new amjy(this, localAbstractGifImage));
      paramURLDrawable.setVisibility(0);
      paramURLDrawable.setImageDrawable(this.g);
    } while (this.a == null);
    this.a.dNZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjx
 * JD-Core Version:    0.7.0.1
 */