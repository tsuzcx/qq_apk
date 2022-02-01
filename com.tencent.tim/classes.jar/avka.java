import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class avka
{
  private final HashSet<WeakReference<avka.a>> bM = new HashSet();
  private final ConcurrentHashMap<Integer, HashSet<WeakReference<avka.a>>> jB = new ConcurrentHashMap();
  
  public void a(int paramInt, Object paramObject, Object... paramVarArgs)
  {
    Object localObject1 = new ArrayList();
    synchronized (this.jB)
    {
      HashSet localHashSet = (HashSet)this.jB.get(Integer.valueOf(paramInt));
      if (localHashSet != null) {
        ((ArrayList)localObject1).addAll(localHashSet);
      }
    }
    synchronized (this.bM)
    {
      ((ArrayList)localObject1).addAll(this.bM);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ??? = (avka.a)((WeakReference)((Iterator)localObject1).next()).get();
        if (??? != null)
        {
          ((avka.a)???).onDispatchEvent(paramInt, paramObject, paramVarArgs);
          continue;
          paramObject = finally;
          throw paramObject;
        }
      }
    }
  }
  
  public void b(avka.a parama)
  {
    if (parama == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    synchronized (this.bM)
    {
      localIterator = this.bM.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (WeakReference)localIterator.next();
        localObject3 = (avka.a)((WeakReference)localObject2).get();
        if ((localObject3 == null) || (parama == localObject3)) {
          localArrayList.add(localObject2);
        }
      }
    }
    this.bM.removeAll(localArrayList);
    for (;;)
    {
      synchronized (this.jB)
      {
        localIterator = this.jB.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        int i = ((Integer)localIterator.next()).intValue();
        localObject2 = (HashSet)this.jB.get(Integer.valueOf(i));
        localArrayList.clear();
        localObject3 = ((HashSet)localObject2).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          WeakReference localWeakReference = (WeakReference)((Iterator)localObject3).next();
          avka.a locala = (avka.a)localWeakReference.get();
          if ((locala != null) && (parama != locala)) {
            continue;
          }
          localArrayList.add(localWeakReference);
        }
      }
      ((HashSet)localObject2).removeAll(localArrayList);
    }
  }
  
  public void b(avka.a parama, int... arg2)
  {
    if (parama == null) {
      return;
    }
    b(parama);
    parama = new WeakReference(parama);
    if ((??? == null) || (???.length == 0)) {
      synchronized (this.bM)
      {
        this.bM.add(parama);
        return;
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jB)
      {
        int j = ???.length;
        i = 0;
        if (i < j)
        {
          int k = ???[i];
          if (this.jB.containsKey(Integer.valueOf(k)))
          {
            ((HashSet)this.jB.get(Integer.valueOf(k))).add(parama);
          }
          else
          {
            HashSet localHashSet = new HashSet();
            localHashSet.add(parama);
            this.jB.put(Integer.valueOf(k), localHashSet);
          }
        }
      }
      return;
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDispatchEvent(int paramInt, Object paramObject, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avka
 * JD-Core Version:    0.7.0.1
 */