import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import java.util.concurrent.atomic.AtomicInteger;

public class wqh
  implements TextWatcher
{
  public wqh(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (VoiceTextEditPanel.a(this.this$0).get() == 5)
    {
      VoiceTextEditPanel.a(this.this$0, paramEditable.toString());
      if (!aqmr.isEmpty(VoiceTextEditPanel.a(this.this$0))) {
        break label55;
      }
      this.this$0.setSendEnable(false);
    }
    for (;;)
    {
      this.this$0.caH();
      return;
      label55:
      this.this$0.setSendEnable(true);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqh
 * JD-Core Version:    0.7.0.1
 */