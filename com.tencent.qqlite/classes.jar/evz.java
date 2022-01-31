import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;

public class evz
  implements View.OnClickListener
{
  public evz(JumpAction paramJumpAction) {}
  
  public void onClick(View paramView)
  {
    if ((JumpAction.a(this.a) != null) && (JumpAction.a(this.a).isShowing())) {
      JumpAction.a(this.a).dismiss();
    }
    ((BaseActivity)JumpAction.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     evz
 * JD-Core Version:    0.7.0.1
 */