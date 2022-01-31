import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity;

public class xyr
  implements View.OnClickListener
{
  public xyr(NewFlowEditVideoActivity paramNewFlowEditVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NewFlowEditVideoActivity.c(this.a))
    {
      NewFlowEditVideoActivity.b(this.a);
      return;
    }
    NewFlowEditVideoActivity.b(this.a, false);
    NewFlowEditVideoActivity.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyr
 * JD-Core Version:    0.7.0.1
 */