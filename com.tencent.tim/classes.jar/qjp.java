import android.support.annotation.NonNull;
import android.util.SparseArray;
import java.util.LinkedList;

public class qjp
{
  private final SparseArray<LinkedList<Object>> aM = new SparseArray();
  
  public <CLASS> CLASS c(@NonNull Class<CLASS> paramClass)
  {
    paramClass = (LinkedList)this.aM.get(paramClass.hashCode());
    if (paramClass != null)
    {
      paramClass = paramClass.poll();
      if (paramClass != null) {}
      return paramClass;
    }
    return null;
  }
  
  public void recycle(@NonNull Object paramObject)
  {
    int i = paramObject.getClass().hashCode();
    LinkedList localLinkedList2 = (LinkedList)this.aM.get(i);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      this.aM.put(i, localLinkedList1);
    }
    localLinkedList1.offer(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjp
 * JD-Core Version:    0.7.0.1
 */