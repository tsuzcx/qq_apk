import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.widget.XListView;

public class anp
  implements View.OnClickListener
{
  public anp(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ForwardRecentActivity.a(this.a).k();
    int j = ((Integer)paramView.getTag(-1)).intValue();
    this.a.a(ForwardRecentActivity.a(this.a), paramView, Integer.valueOf(j + i).intValue(), paramView.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anp
 * JD-Core Version:    0.7.0.1
 */