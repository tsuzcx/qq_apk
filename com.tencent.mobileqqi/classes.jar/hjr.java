import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.SwitchAccountActivity;

public class hjr
  implements View.OnClickListener
{
  public hjr(SwitchAccountActivity paramSwitchAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a) {
      return;
    }
    this.a.b = ((String)paramView.getTag());
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hjr
 * JD-Core Version:    0.7.0.1
 */