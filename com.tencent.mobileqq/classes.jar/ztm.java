import android.view.View;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class ztm
  implements blnt
{
  private CopyOnWriteArraySet<blnt> a = new CopyOnWriteArraySet();
  
  public ztm(blnt paramblnt)
  {
    if (paramblnt != null) {
      this.a.add(paramblnt);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((blnt)localIterator.next()).a(paramInt, paramView, paramListView);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      blnt localblnt = (blnt)localIterator.next();
      if ((bool) || (localblnt.a(paramInt, paramView, paramListView))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((blnt)localIterator.next()).b(paramInt, paramView, paramListView);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((blnt)localIterator.next()).c(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztm
 * JD-Core Version:    0.7.0.1
 */