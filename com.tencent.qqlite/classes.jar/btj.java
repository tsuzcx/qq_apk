import android.os.Build;
import android.view.LayoutInflater;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.qphone.base.util.QLog;

public class btj
  implements Runnable
{
  public btj(AudioPanelAdapter paramAudioPanelAdapter) {}
  
  public void run()
  {
    if (this.a.b == null) {}
    try
    {
      ListenChangeVoicePanel localListenChangeVoicePanel = (ListenChangeVoicePanel)LayoutInflater.from(AudioPanelAdapter.a(this.a).a()).inflate(2130903468, null);
      if (this.a.b == null) {
        this.a.b = localListenChangeVoicePanel;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOAudioPanel", 2, "inflate ListenPanel on subthread get exception " + localException + " model=" + Build.MANUFACTURER + Build.MODEL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     btj
 * JD-Core Version:    0.7.0.1
 */