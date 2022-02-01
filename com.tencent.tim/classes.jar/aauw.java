import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class aauw
{
  private aauw.a a;
  private ConcurrentHashMap<Integer, aauy.a> dl = new ConcurrentHashMap();
  
  public aauw(aauw.a parama)
  {
    this.a = parama;
  }
  
  public aauy.a a(int paramInt)
  {
    return (aauy.a)this.dl.get(Integer.valueOf(paramInt));
  }
  
  public void a(aauy.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parama.index);
    }
    this.dl.putIfAbsent(Integer.valueOf(parama.index), parama);
    if (this.a != null) {
      this.a.onChanged();
    }
  }
  
  public void destroy()
  {
    Iterator localIterator = this.dl.values().iterator();
    while (localIterator.hasNext())
    {
      aauy.a locala = (aauy.a)localIterator.next();
      locala.ey.recycle();
      locala.ey = null;
    }
  }
  
  public boolean hF(int paramInt)
  {
    return this.dl.containsKey(Integer.valueOf(paramInt));
  }
  
  public boolean isEmpty()
  {
    return this.dl.size() == 0;
  }
  
  public static abstract interface a
  {
    public abstract void onChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aauw
 * JD-Core Version:    0.7.0.1
 */