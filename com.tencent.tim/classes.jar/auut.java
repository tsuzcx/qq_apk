import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.c;
import com.tencent.widget.PinnedHeadAndFootExpandableListView;
import com.tencent.widget.PinnedHeadAndFootExpandableListView.a;

public class auut
  implements View.OnTouchListener
{
  public auut(PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      long l = this.a.getExpandableListPosition(this.a.getFirstVisiblePosition());
      if ((ExpandableListView.getPackedPositionType(l) == 0) || (ExpandableListView.getPackedPositionType(l) == 1))
      {
        int i = ExpandableListView.getPackedPositionGroup(l);
        if ((this.a.b == null) || (!this.a.b.a(this.a, paramView, i, this.a.a.getGroupId(i)))) {
          this.a.collapseGroup(i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auut
 * JD-Core Version:    0.7.0.1
 */