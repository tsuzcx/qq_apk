import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.tim.filemanager.widget.QfileHorizontalListView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.AdapterView.e;

public class aufh
  extends GestureDetector.SimpleOnGestureListener
{
  public aufh(QfileHorizontalListView paramQfileHorizontalListView) {}
  
  private boolean b(MotionEvent paramMotionEvent, View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = paramView.getWidth();
    int k = arrayOfInt[1];
    localRect.set(i, k, j + i, paramView.getHeight() + k);
    return localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return this.this$0.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.this$0.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    int j = this.this$0.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        View localView = this.this$0.getChildAt(i);
        if (!b(paramMotionEvent, localView)) {
          break label99;
        }
        if (QfileHorizontalListView.a(this.this$0) != null) {
          QfileHorizontalListView.a(this.this$0).a(this.this$0, localView, QfileHorizontalListView.a(this.this$0) + 1 + i, this.this$0.mAdapter.getItemId(i + (QfileHorizontalListView.a(this.this$0) + 1)));
        }
      }
      return;
      label99:
      i += 1;
    }
  }
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.this$0)
    {
      paramMotionEvent2 = this.this$0;
      paramMotionEvent2.mNextX += (int)paramFloat1;
      this.this$0.requestLayout();
      return true;
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.this$0.getChildCount())
      {
        View localView = this.this$0.getChildAt(i);
        if (!b(paramMotionEvent, localView)) {
          break label155;
        }
        if (QfileHorizontalListView.a(this.this$0) != null) {
          QfileHorizontalListView.a(this.this$0).onItemClick(this.this$0, localView, QfileHorizontalListView.a(this.this$0) + 1 + i, this.this$0.mAdapter.getItemId(QfileHorizontalListView.a(this.this$0) + 1 + i));
        }
        if (QfileHorizontalListView.a(this.this$0) != null) {
          QfileHorizontalListView.a(this.this$0).onItemSelected(this.this$0, localView, QfileHorizontalListView.a(this.this$0) + 1 + i, this.this$0.mAdapter.getItemId(QfileHorizontalListView.a(this.this$0) + 1 + i));
        }
      }
      return true;
      label155:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufh
 * JD-Core Version:    0.7.0.1
 */