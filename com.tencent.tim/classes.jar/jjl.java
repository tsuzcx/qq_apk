import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class jjl
{
  public static boolean cK(String paramString)
  {
    return new File(hr(), paramString).exists();
  }
  
  public static String hr()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DingdongSoundUtil", 2, "[sound_early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/dingdong/sound_early/";
  }
  
  public static void y(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DingdongSoundUtil", 2, "[sound_early] trigger early download");
    }
    if (!new File(hr(), "dingdong_schedule_notify.mp3").exists())
    {
      paramQQAppInterface = (afem)paramQQAppInterface.getManager(77);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (affg)paramQQAppInterface.a("qq.android.dingdong.ring");
        if (paramQQAppInterface != null) {
          paramQQAppInterface.HL(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jjl
 * JD-Core Version:    0.7.0.1
 */