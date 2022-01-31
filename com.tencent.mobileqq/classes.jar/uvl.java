import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PttTipSwitchView;

public class uvl
  implements Runnable
{
  public uvl(PressToSpeakPanel paramPressToSpeakPanel) {}
  
  public void run()
  {
    if (PressToSpeakPanel.a(this.a) != null) {
      PressToSpeakPanel.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvl
 * JD-Core Version:    0.7.0.1
 */