import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.JumpAction;

public class ett
  implements View.OnClickListener
{
  public ett(JumpAction paramJumpAction) {}
  
  public void onClick(View paramView)
  {
    if ((JumpAction.a(this.a) != null) && (JumpAction.a(this.a).isShowing())) {
      JumpAction.a(this.a).dismiss();
    }
    JumpAction.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ett
 * JD-Core Version:    0.7.0.1
 */