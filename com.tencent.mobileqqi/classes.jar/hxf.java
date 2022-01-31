import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.widget.XCursorAdapter;

public class hxf
  extends ContentObserver
{
  public hxf(XCursorAdapter paramXCursorAdapter)
  {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hxf
 * JD-Core Version:    0.7.0.1
 */