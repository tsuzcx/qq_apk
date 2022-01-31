import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class xtv
  implements Runnable
{
  public xtv(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void run()
  {
    if (EditLocalVideoActivity.a(this.a)) {
      EditLocalVideoActivity.b(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtv
 * JD-Core Version:    0.7.0.1
 */