import android.view.View;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class zhq
  implements bldp
{
  private CopyOnWriteArraySet<bldp> a = new CopyOnWriteArraySet();
  
  public zhq(bldp parambldp)
  {
    if (parambldp != null) {
      this.a.add(parambldp);
    }
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bldp)localIterator.next()).onNotCompleteVisable(paramInt, paramView, paramListView);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bldp)localIterator.next()).onViewCompleteVisable(paramInt, paramView, paramListView);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      bldp localbldp = (bldp)localIterator.next();
      if ((bool) || (localbldp.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bldp)localIterator.next()).onViewNotCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhq
 * JD-Core Version:    0.7.0.1
 */