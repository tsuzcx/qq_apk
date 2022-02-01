import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QQDingdongSoundData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class affg
  extends afeu
{
  public affg(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.dingdong.ring", paramQQAppInterface);
  }
  
  public void HL(boolean paramBoolean)
  {
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)b();
    if ((localQQDingdongSoundData != null) && (!localQQDingdongSoundData.autoDownload))
    {
      localQQDingdongSoundData.autoDownload = true;
      afel.a(localQQDingdongSoundData, new String[] { "autoDownload" });
    }
    super.HL(paramBoolean);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDingdongSoundHandler", 2, "download success: " + paramString);
    }
    try
    {
      aqhq.W(paramString, jjl.hr(), false);
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
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)b();
    if (localQQDingdongSoundData == null) {
      return super.aja();
    }
    return localQQDingdongSoundData.autoDownload;
  }
  
  public Class<? extends XmlData> g()
  {
    return QQDingdongSoundData.class;
  }
  
  public int getBusinessId()
  {
    return 10050;
  }
  
  public String un()
  {
    return "dingdongDownloadAudioSoundDuration";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affg
 * JD-Core Version:    0.7.0.1
 */