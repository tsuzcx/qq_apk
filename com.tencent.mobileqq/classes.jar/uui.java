import android.os.Build;
import android.view.LayoutInflater;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.qphone.base.util.QLog;

public class uui
  implements Runnable
{
  public uui(AudioPanelAdapter paramAudioPanelAdapter) {}
  
  public void run()
  {
    if (this.a.b == null) {}
    try
    {
      ListenChangeVoicePanel localListenChangeVoicePanel = (ListenChangeVoicePanel)LayoutInflater.from(AudioPanelAdapter.a(this.a).getApp()).inflate(2130970195, null);
      if (this.a.b == null) {
        this.a.b = localListenChangeVoicePanel;
      }
      PttPreSendManager.a(AudioPanelAdapter.a(this.a));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "inflate ListenPanel on subthread get exception " + localException + " model=" + Build.MANUFACTURER + Build.MODEL);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uui
 * JD-Core Version:    0.7.0.1
 */