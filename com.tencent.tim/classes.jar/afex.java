import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.HotFriendResData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afex
  extends afeu
{
  public afex(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.hotfriend.res", paramQQAppInterface);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriendResHandler", 2, "doOnDownloadSuccess:" + paramString);
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriendResHandler", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    try
    {
      String str = ajol.xu();
      if (QLog.isColorLevel()) {
        QLog.d("HotFriendResHandler", 2, "doOnDownloadSuccess imagePath=" + str);
      }
      if (!TextUtils.isEmpty(str)) {
        aqhq.W(paramString, str, false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
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
    return HotFriendResData.class;
  }
  
  public int getBusinessId()
  {
    return 10042;
  }
  
  public String un()
  {
    return "HotFriendResHandler";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afex
 * JD-Core Version:    0.7.0.1
 */