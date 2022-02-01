import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class psc<DATA>
{
  public static final String TAG = psc.class.getName();
  protected DATA data;
  protected List<psc.a<DATA>> listeners = new CopyOnWriteArrayList();
  
  public void a(@NonNull psc.a<DATA> parama)
  {
    if (!this.listeners.contains(parama)) {
      this.listeners.add(parama);
    }
  }
  
  protected abstract void a(pua parampua);
  
  public void b(@NonNull psc.a<DATA> parama)
  {
    if (this.listeners.contains(parama)) {
      this.listeners.remove(parama);
    }
  }
  
  public void b(pua parampua)
  {
    a(parampua);
  }
  
  public void biW()
  {
    a(null);
  }
  
  public DATA getData()
  {
    return this.data;
  }
  
  protected void k(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((psc.a)localIterator.next()).l(paramBoolean, paramDATA);
    }
  }
  
  public void onDestroy()
  {
    ram.d(TAG, "onDestroy");
    this.listeners.clear();
  }
  
  public void onInit()
  {
    ram.d(TAG, "onInit");
  }
  
  public static abstract interface a<DATA>
  {
    public abstract void l(boolean paramBoolean, DATA paramDATA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psc
 * JD-Core Version:    0.7.0.1
 */