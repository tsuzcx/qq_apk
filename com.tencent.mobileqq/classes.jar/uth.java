import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorView;

public class uth
  implements View.OnClickListener
{
  public uth(ColorView paramColorView) {}
  
  public void onClick(View paramView)
  {
    if (ColorView.a(this.a) != null) {
      ColorView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uth
 * JD-Core Version:    0.7.0.1
 */