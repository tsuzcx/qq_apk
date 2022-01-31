import android.text.Selection;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.EditTextAutoResizeFont;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class eug
  implements View.OnClickListener
{
  public eug(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    StringBuffer localStringBuffer = new StringBuffer(VoipDialInterfaceActivity.a(this.a).getText().toString().trim());
    int j;
    int i;
    if (VoipDialInterfaceActivity.a(this.a) == true)
    {
      j = VoipDialInterfaceActivity.a(this.a).getSelectionStart();
      i = j;
      paramView = localStringBuffer;
      if (j > 0)
      {
        paramView = localStringBuffer.delete(j - 1, j);
        i = j;
      }
    }
    for (;;)
    {
      VoipDialInterfaceActivity.a(this.a).setText(paramView.toString());
      if (i > 0) {
        Selection.setSelection(VoipDialInterfaceActivity.a(this.a).getText(), i - 1);
      }
      if (VoipDialInterfaceActivity.a(this.a).getText().toString().trim().length() <= 0)
      {
        VoipDialInterfaceActivity.a(this.a).setCursorVisible(false);
        VoipDialInterfaceActivity.a(this.a, false);
      }
      return;
      j = VoipDialInterfaceActivity.a(this.a).length();
      i = j;
      paramView = localStringBuffer;
      if (j > 0)
      {
        paramView = localStringBuffer.delete(j - 1, j);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eug
 * JD-Core Version:    0.7.0.1
 */