import android.view.View;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class wdf
  implements bfub
{
  private CopyOnWriteArraySet<bfub> a = new CopyOnWriteArraySet();
  
  public wdf(bfub parambfub)
  {
    if (parambfub != null) {
      this.a.add(parambfub);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bfub)localIterator.next()).a(paramInt, paramView, paramListView);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      bfub localbfub = (bfub)localIterator.next();
      if ((bool) || (localbfub.a(paramInt, paramView, paramListView))) {}
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
      ((bfub)localIterator.next()).b(paramInt, paramView, paramListView);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bfub)localIterator.next()).c(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wdf
 * JD-Core Version:    0.7.0.1
 */