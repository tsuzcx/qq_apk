import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class abrf
{
  private CopyOnWriteArrayList<abqu> L = new CopyOnWriteArrayList();
  private AtomicBoolean ax = new AtomicBoolean(true);
  private abrk b;
  private abrc c;
  
  public abrf(abrc paramabrc, abrk paramabrk)
  {
    this.b = paramabrk;
    this.c = paramabrc;
  }
  
  public abqu a(int paramInt)
  {
    Iterator localIterator = this.L.iterator();
    while (localIterator.hasNext())
    {
      abqu localabqu = (abqu)localIterator.next();
      if (localabqu.zL() == paramInt) {
        return localabqu;
      }
    }
    return null;
  }
  
  public abqu a(int paramInt1, int paramInt2)
  {
    if (this.c == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = a(paramInt1);
    boolean bool = this.ax.get();
    if (localObject != null)
    {
      if (bool)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "createScript init load but has last script");
        this.L.clear();
      }
    }
    else {
      switch (paramInt1)
      {
      }
    }
    for (localObject = new abra(paramInt1, paramInt2, this.c); (localObject != null) && (((abqu)localObject).YY()); localObject = new abqt(paramInt1, this.c))
    {
      ((abqu)localObject).cEs();
      ((abqu)localObject).a(this.b);
      ((abqu)localObject).cEr();
      this.L.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("cmshow_scripted_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
    }
  }
  
  public void cED()
  {
    if (this.c == null) {}
    abqu localabqu;
    do
    {
      return;
      if (this.c.a() == null)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
        return;
      }
      localabqu = a(0, -1);
      this.ax.set(false);
    } while ((localabqu == null) || (!(localabqu instanceof abqt)) || ((abqt)localabqu != null));
  }
  
  public void clear()
  {
    if ((this.L == null) || (this.L.size() == 0)) {
      return;
    }
    Iterator localIterator = this.L.iterator();
    while (localIterator.hasNext()) {
      ((abqu)localIterator.next()).onDestroy();
    }
    this.L.clear();
    this.ax.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrf
 * JD-Core Version:    0.7.0.1
 */