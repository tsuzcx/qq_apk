import android.view.View;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class xrx
  implements bhuy
{
  private CopyOnWriteArraySet<bhuy> a = new CopyOnWriteArraySet();
  
  public xrx(bhuy parambhuy)
  {
    if (parambhuy != null) {
      this.a.add(parambhuy);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bhuy)localIterator.next()).a(paramInt, paramView, paramListView);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      bhuy localbhuy = (bhuy)localIterator.next();
      if ((bool) || (localbhuy.a(paramInt, paramView, paramListView))) {}
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
      ((bhuy)localIterator.next()).b(paramInt, paramView, paramListView);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bhuy)localIterator.next()).c(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xrx
 * JD-Core Version:    0.7.0.1
 */