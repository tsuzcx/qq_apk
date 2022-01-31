import android.support.annotation.NonNull;
import android.util.SparseArray;
import java.util.LinkedList;

public class uau
{
  private final SparseArray<LinkedList<Object>> a = new SparseArray();
  
  public <CLASS> CLASS a(@NonNull Class<CLASS> paramClass)
  {
    paramClass = (LinkedList)this.a.get(paramClass.hashCode());
    if (paramClass != null)
    {
      paramClass = paramClass.poll();
      if (paramClass != null) {}
      return paramClass;
    }
    return null;
  }
  
  public void a(@NonNull Object paramObject)
  {
    int i = paramObject.getClass().hashCode();
    LinkedList localLinkedList2 = (LinkedList)this.a.get(i);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      this.a.put(i, localLinkedList1);
    }
    localLinkedList1.offer(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uau
 * JD-Core Version:    0.7.0.1
 */