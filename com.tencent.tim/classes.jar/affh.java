import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavGAudioSoundData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class affh
  extends afeu
{
  public affh(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.muteaudio", paramQQAppInterface);
  }
  
  public void HL(boolean paramBoolean)
  {
    QavGAudioSoundData localQavGAudioSoundData = (QavGAudioSoundData)b();
    if ((localQavGAudioSoundData != null) && (!localQavGAudioSoundData.autoDownload))
    {
      localQavGAudioSoundData.autoDownload = true;
      afel.a(localQavGAudioSoundData, new String[] { "autoDownload" });
    }
    super.HL(paramBoolean);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavGAudioSoundHandler", 2, "download success: " + paramString);
    }
    try
    {
      aqhq.W(paramString, jjp.hr(), false);
      super.HO(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public boolean aja()
  {
    QavGAudioSoundData localQavGAudioSoundData = (QavGAudioSoundData)b();
    if (localQavGAudioSoundData == null) {
      return super.aja();
    }
    return localQavGAudioSoundData.autoDownload;
  }
  
  public Class<? extends XmlData> g()
  {
    return QavGAudioSoundData.class;
  }
  
  public int getBusinessId()
  {
    return 10046;
  }
  
  public String un()
  {
    return "qavDownloadGAudioSoundDuration";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affh
 * JD-Core Version:    0.7.0.1
 */