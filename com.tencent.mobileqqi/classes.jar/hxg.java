import android.database.DataSetObserver;
import com.tencent.widget.XCursorAdapter;

public class hxg
  extends DataSetObserver
{
  private hxg(XCursorAdapter paramXCursorAdapter) {}
  
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
 * Qualified Name:     hxg
 * JD-Core Version:    0.7.0.1
 */