import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView.AdapterDataSetObserver;
import com.tencent.widget.FastScroller;

public class fgy
  extends AdapterView.AdapterDataSetObserver
{
  public fgy(AbsListView paramAbsListView)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fgy
 * JD-Core Version:    0.7.0.1
 */