import android.database.DataSetObserver;
import com.tencent.mobileqq.filemanager.widget.QfileHorizontalListView;

public class dxc
  extends DataSetObserver
{
  public dxc(QfileHorizontalListView paramQfileHorizontalListView) {}
  
  public void onChanged()
  {
    synchronized (this.a)
    {
      QfileHorizontalListView.a(this.a, true);
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public void onInvalidated()
  {
    QfileHorizontalListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dxc
 * JD-Core Version:    0.7.0.1
 */