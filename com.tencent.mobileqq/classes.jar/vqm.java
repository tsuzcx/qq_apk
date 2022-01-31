import android.view.View;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class vqm
  implements belq
{
  private CopyOnWriteArraySet<belq> a = new CopyOnWriteArraySet();
  
  public vqm(belq parambelq)
  {
    if (parambelq != null) {
      this.a.add(parambelq);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((belq)localIterator.next()).a(paramInt, paramView, paramListView);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      belq localbelq = (belq)localIterator.next();
      if ((bool) || (localbelq.a(paramInt, paramView, paramListView))) {}
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
      ((belq)localIterator.next()).b(paramInt, paramView, paramListView);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((belq)localIterator.next()).c(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqm
 * JD-Core Version:    0.7.0.1
 */