import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;

public class uvd
  implements Runnable
{
  public uvd(PressToChangeVoicePanel paramPressToChangeVoicePanel) {}
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.a).sendAccessibilityEvent(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvd
 * JD-Core Version:    0.7.0.1
 */