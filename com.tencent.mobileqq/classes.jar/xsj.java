import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity;
import com.tencent.mobileqq.activity.richmedia.QzEditVideoPartManager;
import com.tencent.open.base.ToastUtil;

public class xsj
  implements View.OnClickListener
{
  public xsj(NewFlowEditVideoActivity paramNewFlowEditVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NewFlowEditVideoActivity.a(this.a))
    {
      NewFlowEditVideoActivity.a(this.a);
      return;
    }
    if (NewFlowEditVideoActivity.b(this.a))
    {
      ToastUtil.a().a("不使用超清");
      NewFlowEditVideoActivity.a(this.a, false);
      NewFlowEditVideoActivity.a(this.a).setBackgroundResource(2130845304);
      ((QzEditVideoPartManager)NewFlowEditVideoActivity.a(this.a)).f = false;
      return;
    }
    ToastUtil.a().a("使用超清");
    NewFlowEditVideoActivity.a(this.a, true);
    NewFlowEditVideoActivity.a(this.a).setBackgroundResource(2130845303);
    ((QzEditVideoPartManager)NewFlowEditVideoActivity.b(this.a)).f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsj
 * JD-Core Version:    0.7.0.1
 */