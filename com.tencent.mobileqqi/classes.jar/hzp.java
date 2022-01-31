import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView.AdapterDataSetObserver;
import com.tencent.widget.FastScroller;

public class hzp
  extends AdapterView.AdapterDataSetObserver
{
  public hzp(AbsListView paramAbsListView)
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
 * Qualified Name:     hzp
 * JD-Core Version:    0.7.0.1
 */