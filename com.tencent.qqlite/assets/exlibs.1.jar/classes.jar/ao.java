import android.widget.TextView;
import com.dataline.activities.LiteActivity;

public class ao
  implements Runnable
{
  public ao(LiteActivity paramLiteActivity) {}
  
  public void run()
  {
    if (LiteActivity.a(this.a) != null) {
      LiteActivity.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ao
 * JD-Core Version:    0.7.0.1
 */