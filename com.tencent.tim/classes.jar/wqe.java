import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicInteger;

public class wqe
  implements CompoundButton.OnCheckedChangeListener
{
  public wqe(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((VoiceTextEditPanel.a(this.this$0).get() > 0) && (aqmr.isEmpty(VoiceTextEditPanel.a(this.this$0))) && (!VoiceTextEditPanel.a(this.this$0).isEnabled())) {
        this.this$0.setSendEnable(true);
      }
      if (VoiceTextEditPanel.a(this.this$0) != null) {
        VoiceTextEditPanel.a(this.this$0).edit().putBoolean("businessinfo_ptt_vt_send_type_" + VoiceTextEditPanel.a(this.this$0).getCurrentAccountUin(), true).commit();
      }
      VoiceTextEditPanel.a(this.this$0).setText(2131719514);
      if (this.this$0.RH()) {
        anot.a(null, "dc00898", "", "", "0X800A1D8", "0X800A1D8", 2, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      anot.a(null, "dc00898", "", "", "0X800A1D8", "0X800A1D8", 1, 0, "", "", "", "");
      continue;
      if (VoiceTextEditPanel.a(this.this$0) != null) {
        VoiceTextEditPanel.a(this.this$0).edit().putBoolean("businessinfo_ptt_vt_send_type_" + VoiceTextEditPanel.a(this.this$0).getCurrentAccountUin(), false).commit();
      }
      VoiceTextEditPanel.a(this.this$0).setText(2131719512);
      if ((VoiceTextEditPanel.a(this.this$0).get() == 5) && (aqmr.isEmpty(VoiceTextEditPanel.a(this.this$0)))) {
        this.this$0.setSendEnable(false);
      }
      if (this.this$0.RH()) {
        anot.a(null, "dc00898", "", "", "0X800A1D9", "0X800A1D9", 2, 0, "", "", "", "");
      } else {
        anot.a(null, "dc00898", "", "", "0X800A1D9", "0X800A1D9", 1, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqe
 * JD-Core Version:    0.7.0.1
 */