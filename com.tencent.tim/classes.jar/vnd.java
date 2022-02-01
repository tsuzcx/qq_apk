import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;

public class vnd
  implements View.OnTouchListener
{
  public vnd(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.this$0.ayl();
      kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573C", "0X800573C", 0, 0, "", "", "", "", false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnd
 * JD-Core Version:    0.7.0.1
 */