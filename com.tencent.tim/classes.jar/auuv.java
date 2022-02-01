import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.c;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.a;

public class auuv
  implements View.OnTouchListener
{
  public auuv(PinnedHeaderExpandableListView paramPinnedHeaderExpandableListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      long l = this.b.getExpandableListPosition(this.b.getFirstVisiblePosition());
      if ((ExpandableListView.getPackedPositionType(l) == 0) || (ExpandableListView.getPackedPositionType(l) == 1))
      {
        int i = ExpandableListView.getPackedPositionGroup(l);
        if ((PinnedHeaderExpandableListView.a(this.b) == null) || (!PinnedHeaderExpandableListView.a(this.b).a(this.b, paramView, i, PinnedHeaderExpandableListView.a(this.b).getGroupId(i)))) {
          this.b.collapseGroup(i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auuv
 * JD-Core Version:    0.7.0.1
 */