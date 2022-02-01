import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavImageData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class affi
  extends afeu
{
  QQAppInterface mApp = null;
  
  public affi(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.image2", paramQQAppInterface);
    this.mApp = paramQQAppInterface;
  }
  
  public void HL(boolean paramBoolean)
  {
    QavImageData localQavImageData = (QavImageData)b();
    if ((localQavImageData != null) && (!localQavImageData.autoDownload))
    {
      localQavImageData.autoDownload = true;
      afel.a(localQavImageData, new String[] { "autoDownload" });
    }
    super.HL(paramBoolean);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavImageHandler", 2, "download success: " + paramString);
    }
    try
    {
      aqhq.W(paramString, jjy.ht(), false);
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
    return ((QavImageData)b()).autoDownload;
  }
  
  public Class<? extends XmlData> g()
  {
    return QavImageData.class;
  }
  
  public int getBusinessId()
  {
    return 10047;
  }
  
  public String un()
  {
    return "qavDownloadImageDuration";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affi
 * JD-Core Version:    0.7.0.1
 */