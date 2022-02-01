import android.support.annotation.UiThread;
import java.lang.ref.WeakReference;

public class olr<V extends oer>
  implements oeu<V>
{
  private WeakReference<V> X;
  private boolean axJ;
  
  @UiThread
  public void a(V paramV)
  {
    this.X = new WeakReference(paramV);
    this.axJ = false;
  }
  
  @UiThread
  public V b()
  {
    if (this.X == null) {
      return null;
    }
    return (oer)this.X.get();
  }
  
  public void destroy()
  {
    this.axJ = true;
  }
  
  public void detachView()
  {
    if (this.X != null)
    {
      this.X.clear();
      this.X = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olr
 * JD-Core Version:    0.7.0.1
 */