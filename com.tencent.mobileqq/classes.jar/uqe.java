import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;

public class uqe
  implements Runnable
{
  public uqe(PressToChangeVoicePanel paramPressToChangeVoicePanel) {}
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.a).sendAccessibilityEvent(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uqe
 * JD-Core Version:    0.7.0.1
 */