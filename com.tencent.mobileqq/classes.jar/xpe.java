import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity;

public class xpe
  implements View.OnClickListener
{
  public xpe(NewFlowEditVideoActivity paramNewFlowEditVideoActivity) {}
  
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
 * Qualified Name:     xpe
 * JD-Core Version:    0.7.0.1
 */