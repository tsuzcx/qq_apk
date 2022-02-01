import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wqi
  implements View.OnClickListener
{
  public wqi(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onClick(View paramView)
  {
    VoiceTextEditPanel.a(this.this$0).a.setVisibility(0);
    if (!this.this$0.RH())
    {
      VoiceTextEditPanel.a(this.this$0).wa(false);
      VoiceTextEditPanel.a(this.this$0).caz();
      VoiceTextEditPanel.b(this.this$0);
      anot.a(null, "dc00898", "", "", "0X800A1DB", "0X800A1DB", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      VoiceTextEditPanel.c(this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VoiceTextEditPanel.a(this.this$0).CA(1);
      VoiceTextEditPanel.a(this.this$0).hideAllPanels();
      anot.a(null, "dc00898", "", "", "0X800A1DB", "0X800A1DB", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqi
 * JD-Core Version:    0.7.0.1
 */