import android.graphics.Rect;
import android.widget.GridView;
import com.tencent.mobileqq.app.QQServiceEntry;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;

public class cws
  implements Runnable
{
  public cws(QQServiceEntry paramQQServiceEntry) {}
  
  public void run()
  {
    this.a.a.a.requestRectangleOnScreen(new Rect(0, 0, 0, this.a.a.a.getHeight()), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cws
 * JD-Core Version:    0.7.0.1
 */