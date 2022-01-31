import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.widget.XCursorAdapter;

public class fja
  extends ContentObserver
{
  public fja(XCursorAdapter paramXCursorAdapter)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fja
 * JD-Core Version:    0.7.0.1
 */