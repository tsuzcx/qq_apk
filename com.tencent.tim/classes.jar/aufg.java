import android.database.DataSetObserver;
import com.tencent.tim.filemanager.widget.QfileHorizontalListView;

public class aufg
  extends DataSetObserver
{
  public aufg(QfileHorizontalListView paramQfileHorizontalListView) {}
  
  public void onChanged()
  {
    synchronized (this.this$0)
    {
      QfileHorizontalListView.a(this.this$0, true);
      this.this$0.invalidate();
      this.this$0.requestLayout();
      return;
    }
  }
  
  public void onInvalidated()
  {
    QfileHorizontalListView.a(this.this$0);
    this.this$0.invalidate();
    this.this$0.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufg
 * JD-Core Version:    0.7.0.1
 */