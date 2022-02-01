import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class avde
{
  public static long sStartTime;
  
  public static String FM()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return new File(localBaseApplicationImpl.getFilesDir(), "comic_so").getAbsolutePath() + File.separator;
  }
  
  public static void V(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipComicSoHelper", 2, "onSoDownloadCompleted");
    }
    if (aqnl.B(FM() + "libQGamePlayer.zip", FM(), "libqgplayer_765.so")) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "comic player unCompressSo success");
      }
    }
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = sStartTime;
        annx.b(paramQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", "2|" + (l1 - l2) + "|" + paramInt, true);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "comic player unCompressSo failure");
      }
    }
  }
  
  public static void eO(QQAppInterface paramQQAppInterface)
  {
    if (!new File(FM() + "libqgplayer_765.so").exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "initComicPlayerSo start download");
      }
      ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(1004L, "libqgplayer_765", "comic");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        sStartTime = SystemClock.elapsedRealtime();
        annx.b(paramQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", "1|" + sStartTime + "|0", true);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    QLog.d("VipComicSoHelper", 2, "initComicPlayerSo has exists");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avde
 * JD-Core Version:    0.7.0.1
 */