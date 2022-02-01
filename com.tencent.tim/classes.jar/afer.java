import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler.1;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afer
  extends afeu
{
  public afer(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.appleemoji", paramQQAppInterface);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess:" + paramString);
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    ThreadManager.excute(new AppleEmojiHandler.1(this, localFile, paramString), 64, null, true);
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public Class<? extends XmlData> g()
  {
    return AppleEmojiData.class;
  }
  
  public int getBusinessId()
  {
    return 10001;
  }
  
  public String un()
  {
    return "AppleMojiHandler";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afer
 * JD-Core Version:    0.7.0.1
 */