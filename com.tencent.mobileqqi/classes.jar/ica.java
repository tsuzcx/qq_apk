import android.database.DataSetObserver;
import com.tencent.widget.XCursorAdapter;

public class ica
  extends DataSetObserver
{
  private ica(XCursorAdapter paramXCursorAdapter) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ica
 * JD-Core Version:    0.7.0.1
 */