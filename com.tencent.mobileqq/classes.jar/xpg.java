import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity;
import com.tencent.mobileqq.activity.richmedia.QzEditVideoPartManager.GenerateGifCheck;

public class xpg
  implements QzEditVideoPartManager.GenerateGifCheck
{
  public xpg(NewFlowEditVideoActivity paramNewFlowEditVideoActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NewFlowEditVideoActivity.c(this.a).setVisibility(8);
      NewFlowEditVideoActivity.a(this.a).setVisibility(8);
      NewFlowEditVideoActivity.c(this.a, false);
      return;
    }
    NewFlowEditVideoActivity.c(this.a).setVisibility(0);
    NewFlowEditVideoActivity.a(this.a).setVisibility(0);
    NewFlowEditVideoActivity.c(this.a, NewFlowEditVideoActivity.c(this.a).isSelected());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpg
 * JD-Core Version:    0.7.0.1
 */