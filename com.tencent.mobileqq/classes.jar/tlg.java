import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

class tlg
  implements GifDrawable.OnGIFPlayOnceListener
{
  AbstractGifImage a;
  
  tlg(AbstractGifImage paramAbstractGifImage)
  {
    this.a = paramAbstractGifImage;
  }
  
  public void onPlayOnce()
  {
    Object localObject = (List)tlf.a().get(this.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if (localWeakReference.get() != null) {
          ((tlh)localWeakReference.get()).a();
        }
      }
    }
    this.a.setGIFPlayOnceListener(null);
    tlf.b().remove(this.a);
    tlf.a().remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tlg
 * JD-Core Version:    0.7.0.1
 */