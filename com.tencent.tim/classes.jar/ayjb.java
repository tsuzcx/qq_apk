import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ayjb
{
  private List<ayjb.a> mListeners = new LinkedList();
  
  public static ayjb a()
  {
    return ayjb.b.a;
  }
  
  public void Zq(boolean paramBoolean)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((ayjb.a)localIterator.next()).Zr(paramBoolean);
    }
  }
  
  public boolean a(@NonNull ayjb.a parama)
  {
    return this.mListeners.add(parama);
  }
  
  public boolean b(@NonNull ayjb.a parama)
  {
    return this.mListeners.remove(parama);
  }
  
  public void eRW()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((ayjb.a)localIterator.next()).eRX();
    }
  }
  
  public static abstract interface a
  {
    public abstract void Zr(boolean paramBoolean);
    
    public abstract void eRX();
  }
  
  static class b
  {
    static final ayjb a = new ayjb(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjb
 * JD-Core Version:    0.7.0.1
 */