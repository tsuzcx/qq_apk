import android.text.Selection;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.EditTextAutoResizeFont;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class etv
  implements View.OnClickListener
{
  public etv(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (VoipDialInterfaceActivity.a(this.a).length() >= this.a.a) {}
    int i;
    do
    {
      return;
      StringBuffer localStringBuffer = new StringBuffer(VoipDialInterfaceActivity.a(this.a).getText().toString().trim());
      if (!VoipDialInterfaceActivity.a(this.a)) {
        break;
      }
      i = VoipDialInterfaceActivity.a(this.a).getSelectionStart();
      if (i >= 0) {
        localStringBuffer.insert(i, paramView);
      }
      VoipDialInterfaceActivity.a(this.a).setText(localStringBuffer.toString());
      if (i >= 0) {
        Selection.setSelection(VoipDialInterfaceActivity.a(this.a).getText(), i + 1);
      }
      if (VoipDialInterfaceActivity.a(this.a).getText().toString().trim().length() <= 0)
      {
        VoipDialInterfaceActivity.a(this.a).setCursorVisible(false);
        VoipDialInterfaceActivity.a(this.a, false);
      }
    } while (!VoipDialInterfaceActivity.b(this.a));
    if (paramView == "1") {
      VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.a(this.a));
    }
    for (;;)
    {
      new Thread(new etw(this)).start();
      return;
      i = VoipDialInterfaceActivity.a(this.a).length();
      break;
      if (paramView == "2") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.b(this.a));
      } else if (paramView == "3") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.c(this.a));
      } else if (paramView == "4") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.d(this.a));
      } else if (paramView == "5") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.e(this.a));
      } else if (paramView == "6") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.f(this.a));
      } else if (paramView == "7") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.g(this.a));
      } else if (paramView == "8") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.h(this.a));
      } else if (paramView == "9") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.i(this.a));
      } else if (paramView == "0") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.j(this.a));
      } else if (paramView == "*") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.k(this.a));
      } else if (paramView == "#") {
        VoipDialInterfaceActivity.a(this.a, VoipDialInterfaceActivity.l(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etv
 * JD-Core Version:    0.7.0.1
 */