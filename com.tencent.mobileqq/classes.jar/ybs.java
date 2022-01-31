import com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class ybs
  implements INetInfoHandler
{
  public ybs(AudioTranslator paramAudioTranslator) {}
  
  public void onNetMobile2None()
  {
    boolean bool = true;
    synchronized (this.a)
    {
      if (AudioTranslator.a(this.a) == null) {
        return;
      }
      if (AudioTranslator.a(this.a).a == null) {
        return;
      }
    }
    AudioTranslator localAudioTranslator2 = this.a;
    if (!AudioTranslator.a(this.a).c) {}
    for (;;)
    {
      localAudioTranslator2.a(bool, true);
      return;
      bool = false;
    }
  }
  
  public void onNetMobile2Wifi(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AudioTranslator.a(), 2, "onNetMobile2Wifi, AutoTranslate:  ");
    }
    synchronized (this.a)
    {
      if (AudioTranslator.a(this.a) == null) {
        return;
      }
      if (AudioTranslator.a(this.a).a == null) {
        return;
      }
    }
    this.a.a(false, true);
    AudioTranslator.a(this.a);
  }
  
  public void onNetNone2Mobile(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AudioTranslator.a(), 2, "onNetNone2Mobile ");
    }
    synchronized (this.a)
    {
      if (AudioTranslator.a(this.a) == null) {
        return;
      }
      if (AudioTranslator.a(this.a).a == null) {
        return;
      }
    }
    this.a.a(false, true);
    AudioTranslator.a(this.a);
  }
  
  public void onNetNone2Wifi(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AudioTranslator.a(), 2, "onNetNone2Wifi, AutoTranslate:  ");
    }
    synchronized (this.a)
    {
      if (AudioTranslator.a(this.a) == null) {
        return;
      }
      if (AudioTranslator.a(this.a).a == null) {
        return;
      }
    }
    this.a.a(false, true);
    AudioTranslator.a(this.a);
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AudioTranslator.a(), 2, "onNetWifi2Mobile, need restore:  ");
    }
    synchronized (this.a)
    {
      if (AudioTranslator.a(this.a) == null) {
        return;
      }
      if (AudioTranslator.a(this.a).a == null) {
        return;
      }
    }
    this.a.a(false, true);
    AudioTranslator.a(this.a);
  }
  
  public void onNetWifi2None()
  {
    boolean bool = true;
    synchronized (this.a)
    {
      if (AudioTranslator.a(this.a) == null) {
        return;
      }
      if (AudioTranslator.a(this.a).a == null) {
        return;
      }
    }
    AudioTranslator localAudioTranslator2 = this.a;
    if (!AudioTranslator.a(this.a).c) {}
    for (;;)
    {
      localAudioTranslator2.a(bool, true);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ybs
 * JD-Core Version:    0.7.0.1
 */