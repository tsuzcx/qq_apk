import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView.AdapterDataSetObserver;
import com.tencent.widget.FastScroller;

public class huu
  extends AdapterView.AdapterDataSetObserver
{
  public huu(AbsListView paramAbsListView)
  {
    super(paramAbsListView);
  }
  
  public void onChanged()
  {
    super.onChanged();
    if (this.a.a != null) {
      this.a.a.c();
    }
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    if (this.a.a != null) {
      this.a.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     huu
 * JD-Core Version:    0.7.0.1
 */