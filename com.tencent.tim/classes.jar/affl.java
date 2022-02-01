import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavVideoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class affl
  extends afeu
{
  public affl(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.video", paramQQAppInterface);
  }
  
  public void HL(boolean paramBoolean)
  {
    QavVideoData localQavVideoData = (QavVideoData)b();
    if ((localQavVideoData != null) && (!localQavVideoData.autoDownload))
    {
      localQavVideoData.autoDownload = true;
      afel.a(localQavVideoData, new String[] { "autoDownload" });
    }
    super.HL(paramBoolean);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoDownloadHandler", 2, "download success: " + paramString);
    }
    try
    {
      aqhq.W(paramString, jjy.hu(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public boolean aja()
  {
    return ((QavVideoData)b()).autoDownload;
  }
  
  public Class<? extends XmlData> g()
  {
    return QavVideoData.class;
  }
  
  public int getBusinessId()
  {
    return 10049;
  }
  
  public String un()
  {
    return "qavDownloadVideoDuration";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affl
 * JD-Core Version:    0.7.0.1
 */