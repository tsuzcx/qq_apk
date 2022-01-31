import android.view.View;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class vbq
{
  private Map a = new HashMap();
  
  public View a(int paramInt)
  {
    LinkedList localLinkedList = (LinkedList)this.a.get(Integer.valueOf(paramInt));
    if (localLinkedList == null) {
      return null;
    }
    return (View)localLinkedList.poll();
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(int paramInt, View paramView)
  {
    LinkedList localLinkedList2 = (LinkedList)this.a.get(Integer.valueOf(paramInt));
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      this.a.put(Integer.valueOf(paramInt), localLinkedList1);
    }
    localLinkedList1.add(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbq
 * JD-Core Version:    0.7.0.1
 */