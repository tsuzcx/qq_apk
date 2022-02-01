import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;

public class wqg
  implements TextView.OnEditorActionListener
{
  public wqg(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      anot.a(null, "dc00898", "", "", "0X800A89F", "0X800A89F", 0, 0, "", "", "", "");
      VoiceTextEditPanel.a(this.this$0);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqg
 * JD-Core Version:    0.7.0.1
 */