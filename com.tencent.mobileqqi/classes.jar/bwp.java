import android.widget.CursorAdapter;
import com.tencent.mobileqq.activity.BaseSystemActivity;

public class bwp
  implements Runnable
{
  public bwp(BaseSystemActivity paramBaseSystemActivity) {}
  
  public void run()
  {
    if (this.a.a.getCursor() != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bwp
 * JD-Core Version:    0.7.0.1
 */