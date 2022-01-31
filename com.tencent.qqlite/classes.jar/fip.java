import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;

public class fip
  implements View.OnTouchListener
{
  public fip(PinnedHeaderExpandableListView paramPinnedHeaderExpandableListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      long l = this.a.b(this.a.q());
      if ((ExpandableListView.b(l) == 0) || (ExpandableListView.b(l) == 1))
      {
        int i = ExpandableListView.c(l);
        if ((PinnedHeaderExpandableListView.a(this.a) == null) || (!PinnedHeaderExpandableListView.a(this.a).a(this.a, paramView, i, PinnedHeaderExpandableListView.a(this.a).getGroupId(i)))) {
          this.a.d(i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fip
 * JD-Core Version:    0.7.0.1
 */