import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.WebpSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;

public class affp
  extends afeu
{
  QQAppInterface mApp = null;
  
  public affp(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.webp.so", paramQQAppInterface);
    this.mApp = paramQQAppInterface;
  }
  
  public void HO(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWebpSoDownloadHandler", 2, "onDownload success: " + paramString);
      }
      String str = WebpSoLoader.getSoLibPath(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty(str)) {
        aqhq.W(paramString, str, false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QWebpSoDownloadHandler", 2, localException.getMessage());
        }
      }
    }
    super.HO(paramString);
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public Class<? extends XmlData> g()
  {
    return WebpSoData.class;
  }
  
  public int getBusinessId()
  {
    return 10056;
  }
  
  public String un()
  {
    return "QWebpSoDownloadDuration";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affp
 * JD-Core Version:    0.7.0.1
 */