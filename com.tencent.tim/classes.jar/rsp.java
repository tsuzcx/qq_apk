import android.view.View;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class rsp
  implements auuo
{
  private CopyOnWriteArraySet<auuo> listeners = new CopyOnWriteArraySet();
  
  public rsp(auuo paramauuo)
  {
    if (paramauuo != null) {
      this.listeners.add(paramauuo);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((auuo)localIterator.next()).a(paramInt, paramView, paramListView);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.listeners.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      auuo localauuo = (auuo)localIterator.next();
      if ((bool) || (localauuo.a(paramInt, paramView, paramListView))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((auuo)localIterator.next()).b(paramInt, paramView, paramListView);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((auuo)localIterator.next()).c(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsp
 * JD-Core Version:    0.7.0.1
 */