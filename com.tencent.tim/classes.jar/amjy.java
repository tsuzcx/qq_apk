import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class amjy
  implements GifDrawable.OnGIFPlayOnceListener
{
  amjy(amjx paramamjx, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.b.setStrongGIFPlayOnceListener(null);
    AbstractGifImage.pauseAll();
    if (this.a.a != null) {
      this.a.a.dOa();
    }
    if (this.a.B.get() == null) {
      return;
    }
    ((URLImageView)this.a.B.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjy
 * JD-Core Version:    0.7.0.1
 */