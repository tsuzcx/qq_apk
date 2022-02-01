import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

public class afii
  extends DataSetObserver
{
  public afii(DragSortListView paramDragSortListView) {}
  
  private void cancel()
  {
    if (this.this$0.mDragState == 4) {
      this.this$0.cancelDrag();
    }
  }
  
  public void onChanged()
  {
    cancel();
  }
  
  public void onInvalidated()
  {
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afii
 * JD-Core Version:    0.7.0.1
 */