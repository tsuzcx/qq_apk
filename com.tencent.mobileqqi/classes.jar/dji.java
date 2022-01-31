import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SpaceGateActivity;
import com.tencent.mobileqq.widget.SlipLimitedListView;

public class dji
  implements View.OnClickListener
{
  public dji(SpaceGateActivity paramSpaceGateActivity) {}
  
  public void onClick(View paramView)
  {
    if (SpaceGateActivity.a(this.a) != null) {
      SpaceGateActivity.a(this.a).b();
    }
    SpaceGateActivity.a(this.a).a("");
    SpaceGateActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dji
 * JD-Core Version:    0.7.0.1
 */