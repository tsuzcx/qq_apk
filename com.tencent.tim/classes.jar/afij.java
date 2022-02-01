import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.a;

public class afij
  extends DataSetObserver
{
  public afij(DragSortListView.a parama, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.b.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afij
 * JD-Core Version:    0.7.0.1
 */