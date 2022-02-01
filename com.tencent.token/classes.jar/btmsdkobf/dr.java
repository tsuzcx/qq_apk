package btmsdkobf;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public class dr<T>
{
  private TreeMap<T, LinkedList<T>> nj = null;
  
  public dr(Comparator<T> paramComparator)
  {
    this.nj = new TreeMap(paramComparator);
  }
  
  private LinkedList<T> cA()
  {
    return new LinkedList();
  }
  
  public void add(T paramT)
  {
    try
    {
      LinkedList localLinkedList2 = (LinkedList)this.nj.get(paramT);
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = cA();
        this.nj.put(paramT, localLinkedList1);
      }
      localLinkedList1.addLast(paramT);
      return;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.nj.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEmpty()
  {
    try
    {
      boolean bool = this.nj.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public T poll()
  {
    try
    {
      boolean bool = isEmpty();
      if (bool) {
        return null;
      }
      Object localObject1 = this.nj.firstKey();
      LinkedList localLinkedList = (LinkedList)this.nj.get(localObject1);
      Object localObject3 = localLinkedList.poll();
      if (localLinkedList.size() <= 0) {
        this.nj.remove(localObject1);
      }
      return localObject3;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dr
 * JD-Core Version:    0.7.0.1
 */