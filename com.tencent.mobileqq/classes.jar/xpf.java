import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity;
import com.tencent.mobileqq.activity.richmedia.QzoneSyncQQStoryTool;

public class xpf
  implements View.OnClickListener
{
  public xpf(NewFlowEditVideoActivity paramNewFlowEditVideoActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (NewFlowEditVideoActivity.d(this.a))
    {
      NewFlowEditVideoActivity.c(this.a).setSelected(false);
      paramView = this.a;
      if (NewFlowEditVideoActivity.d(this.a)) {
        break label76;
      }
    }
    for (;;)
    {
      NewFlowEditVideoActivity.c(paramView, bool);
      QzoneSyncQQStoryTool.a(NewFlowEditVideoActivity.a(this.a), NewFlowEditVideoActivity.d(this.a));
      return;
      NewFlowEditVideoActivity.c(this.a).setSelected(true);
      break;
      label76:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpf
 * JD-Core Version:    0.7.0.1
 */