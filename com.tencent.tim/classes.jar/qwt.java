import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class qwt
{
  private LinkedHashMap<rrv, WeakReference<ImageView>> A = new LinkedHashMap(10, 0.75F, true);
  private WeakHashMap<ImageView, rrv> d = new WeakHashMap();
  
  public ListIterator<Map.Entry<rrv, WeakReference<ImageView>>> a()
  {
    return new ArrayList(this.A.entrySet()).listIterator(this.A.size());
  }
  
  public rrv a(ImageView paramImageView)
  {
    paramImageView = (rrv)this.d.remove(paramImageView);
    if (paramImageView != null) {
      this.A.remove(paramImageView);
    }
    return paramImageView;
  }
  
  public void a(ImageView paramImageView, rrv paramrrv)
  {
    rrv localrrv = (rrv)this.d.put(paramImageView, paramrrv);
    if (localrrv != null) {
      this.A.remove(localrrv);
    }
    this.A.put(paramrrv, new WeakReference(paramImageView));
  }
  
  public void a(rrv paramrrv)
  {
    this.A.remove(paramrrv);
  }
  
  public rrv b(ImageView paramImageView)
  {
    return (rrv)this.d.get(paramImageView);
  }
  
  public void clear()
  {
    this.d.clear();
    this.A.clear();
  }
  
  public int sV()
  {
    return this.A.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwt
 * JD-Core Version:    0.7.0.1
 */