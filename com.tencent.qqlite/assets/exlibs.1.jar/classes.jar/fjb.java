import android.database.DataSetObserver;
import com.tencent.widget.XCursorAdapter;

public class fjb
  extends DataSetObserver
{
  private fjb(XCursorAdapter paramXCursorAdapter) {}
  
  public void onChanged()
  {
    this.a.a = true;
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.a = false;
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjb
 * JD-Core Version:    0.7.0.1
 */