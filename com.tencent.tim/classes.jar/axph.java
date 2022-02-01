import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.banner.QIMCaptureBannerConfig;
import dov.com.qq.im.capture.banner.QIMCaptureBannerConfig.BannerItem;
import dov.com.qq.im.capture.banner.QIMCaptureBannerManager.1;
import java.io.File;

public class axph
  extends axon
{
  public static Object LOCK = new Object();
  public static String cVD = axwf.g().getAbsolutePath() + File.separator + "banner_config";
  public QIMCaptureBannerConfig b;
  
  public axph()
  {
    eNF();
  }
  
  public void YN(boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (!paramBoolean) {
        break label36;
      }
      if (this.b.update) {
        QIMCaptureBannerConfig.saveBannerConfig(a(), this.b, cVD);
      }
    }
    return;
    label36:
    QIMCaptureBannerConfig.saveBannerConfig(a(), this.b, cVD);
  }
  
  public boolean a(QIMCaptureBannerConfig.BannerItem paramBannerItem)
  {
    if ((paramBannerItem == null) || (TextUtils.isEmpty(paramBannerItem.imgMd5))) {}
    File localFile;
    do
    {
      do
      {
        return false;
        localFile = new File(cVD, paramBannerItem.imgMd5);
        if (localFile.exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QIMCaptureBannerManager", 2, "isBannerIconUsable|file is not exist -> " + paramBannerItem.imgUrl);
      return false;
      try
      {
        String str = aqhq.px(localFile.getPath());
        if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramBannerItem.imgMd5))) {
          break;
        }
        return true;
      }
      catch (UnsatisfiedLinkError paramBannerItem) {}
    } while (!QLog.isColorLevel());
    paramBannerItem.printStackTrace();
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCaptureBannerManager", 2, "isBannerIconUsable|fileMd5 error " + paramBannerItem.imgUrl);
    }
    localFile.delete();
    return false;
  }
  
  public void eNF()
  {
    ThreadManager.post(new QIMCaptureBannerManager.1(this), 8, null, true);
  }
  
  public void onDestroy()
  {
    this.b = null;
  }
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axph
 * JD-Core Version:    0.7.0.1
 */