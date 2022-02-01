import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.PttTransitonAnimData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afff
  extends afeu
{
  public afff(QQAppInterface paramQQAppInterface)
  {
    super("ptt.transition.anim.res.zip", paramQQAppInterface);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, " PttTransitionAnimHandler download success: " + paramString);
    }
    try
    {
      String str = wpj.FilePath;
      if ((str != null) && (!str.equals("")))
      {
        aqhq.cn(str);
        if (new File(str).mkdir())
        {
          aqhq.W(paramString, str, false);
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, " PttTransitionAnimHandler uncompressZip success: " + paramString + " tempPath=" + str);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "PttTransitionAnimHandler uncompressZip failed: " + localException.getMessage());
        }
      }
    }
    super.HO(paramString);
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler onDownloadBegin()");
    }
    super.a(paramXmlData);
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public boolean aja()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler isUserNeedDownload");
    }
    if ((PttTransitonAnimData)b() == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler isUserNeedDownload return " + true);
    }
    return true;
  }
  
  public void aq(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler onDownloadProgeress() curOffset=" + paramLong1 + " totalLen=" + paramLong2);
    }
    super.aq(paramLong1, paramLong2);
  }
  
  public void f(XmlData paramXmlData)
  {
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof JpegSoData))) {
      QLog.d("EarlyDown", 2, new Object[] { "PttTransitionAnimHandler doOnServerResp, xmlData=", paramXmlData });
    }
    super.f(paramXmlData);
  }
  
  public Class<? extends XmlData> g()
  {
    return PttTransitonAnimData.class;
  }
  
  public int getBusinessId()
  {
    return 10094;
  }
  
  public String un()
  {
    return "PttTransitionAnimZip";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afff
 * JD-Core Version:    0.7.0.1
 */