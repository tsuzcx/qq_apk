import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.voip.EditTextAutoResizeFont;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class eue
  implements View.OnLongClickListener
{
  public eue(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    VoipDialInterfaceActivity.a(this.a).setText("");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eue
 * JD-Core Version:    0.7.0.1
 */