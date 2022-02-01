import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class anhn
{
  protected String TAG = getClass().getSimpleName();
  private anhn.a<Integer, anho> a = new anhn.a();
  
  public void a(anho paramanho)
  {
    try
    {
      this.a.bv(paramanho);
      return;
    }
    finally
    {
      paramanho = finally;
      throw paramanho;
    }
  }
  
  public void a(anho paramanho, int... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.a.put(Integer.valueOf(k), paramanho);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void notify(int paramInt, Object... paramVarArgs)
  {
    try
    {
      Object localObject = this.a.b(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          anho localanho = (anho)((Iterator)localObject).next();
          if (localanho != null) {
            localanho.a(this, paramInt, paramVarArgs);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void remove(int paramInt)
  {
    try
    {
      ArrayList localArrayList = this.a.b(Integer.valueOf(paramInt));
      if (localArrayList != null) {
        localArrayList.clear();
      }
      return;
    }
    finally {}
  }
  
  class a<K, V>
  {
    private HashMap<K, ArrayList<V>> mMap = new HashMap();
    
    public a() {}
    
    public ArrayList<V> b(K paramK)
    {
      return (ArrayList)this.mMap.get(paramK);
    }
    
    public void bv(V paramV)
    {
      Iterator localIterator = this.mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ArrayList localArrayList = (ArrayList)localEntry.getValue();
        int i = 0;
        while (i < localArrayList.size())
        {
          Object localObject = localArrayList.get(i);
          if ((localObject == paramV) || ((localObject != null) && (localObject.equals(paramV)))) {
            ((ArrayList)localEntry.getValue()).remove(paramV);
          } else {
            i += 1;
          }
        }
      }
    }
    
    public void put(K paramK, V paramV)
    {
      ArrayList localArrayList2 = (ArrayList)this.mMap.get(paramK);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.mMap.put(paramK, localArrayList1);
      }
      if (!localArrayList1.contains(paramV)) {
        localArrayList1.add(paramV);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhn
 * JD-Core Version:    0.7.0.1
 */