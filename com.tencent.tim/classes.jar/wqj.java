import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wqj
  implements View.OnClickListener
{
  public wqj(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onClick(View paramView)
  {
    VoiceTextEditPanel.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqj
 * JD-Core Version:    0.7.0.1
 */