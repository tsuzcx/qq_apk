import android.database.DataSetObserver;
import com.tencent.widget.XCursorAdapter;

public class hxf
  extends DataSetObserver
{
  private hxf(XCursorAdapter paramXCursorAdapter) {}
  
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
 * Qualified Name:     hxf
 * JD-Core Version:    0.7.0.1
 */