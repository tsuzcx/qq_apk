import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTrans;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderGen;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderGen.IUniformDownloaderGenListener;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class fyx
  implements UniformDownloaderGen.IUniformDownloaderGenListener
{
  public fyx(UniformDownloaderGen paramUniformDownloaderGen) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.b(paramInt);
    if ((UniformDownloaderGen.a(this.a) != null) && (paramInt - this.a.g() > 0))
    {
      this.a.a(paramInt);
      UniformDownloaderGen.a(this.a).c(paramInt, paramBundle);
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    UniformDownloaderGen.a(this.a);
    this.a.c(5);
    if (UniformDownloaderGen.a(this.a) != null) {
      UniformDownloaderGen.a(this.a).a(paramInt, paramString, paramBundle);
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    UniformDownloaderGen.a(this.a);
    this.a.c(4);
    if (FileUtils.a(this.a.e)) {
      this.a.e = UniformDownloadUtil.c(this.a.e);
    }
    QLog.i(UniformDownloaderGen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. >>>Download SUCCESS.  save file to: =" + this.a.e);
    int i = 1;
    long l2;
    long l1;
    if (paramBundle != null)
    {
      l2 = paramBundle.getLong("EXT_TRANS_SIZE ");
      l1 = paramBundle.getLong("EXT_TTRANS_SIZE ");
      i = paramBundle.getInt("EXT_AUTOTRY_COUNT");
    }
    for (;;)
    {
      if (!FileUtils.a(new File(this.a.f), new File(this.a.e)))
      {
        QLog.e(UniformDownloaderGen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].rename failed.temppath=" + this.a.f + " path=" + this.a.e);
        this.a.c(5);
        paramString = UniformDownloader.a(7);
        QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
        if (localQQAppInterface != null)
        {
          FileManagerUtil.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfGenDownload", this.a.jdField_a_of_type_Long, "", "", "", 7, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
          FileManagerUtil.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.a.jdField_a_of_type_Long, "", "", "", 7, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
          StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.a(), "Stop_download_2-0_3-1");
          if (UniformDownloaderGen.a(this.a) != null) {
            UniformDownloaderGen.a(this.a).a(7, paramString, paramBundle);
          }
        }
      }
      for (;;)
      {
        return;
        QLog.w(UniformDownloaderGen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 5");
        break;
        UniformDownloadBPTrans.a().a(this.a.jdField_c_of_type_JavaLangString);
        paramString = UniformDownloadMgr.a().a();
        if (paramString != null)
        {
          FileManagerUtil.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfGenDownload", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", l1, l2, this.a.b, i, null);
          FileManagerUtil.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", l1, l2, this.a.b, i, null);
          StatisticAssist.a(paramString.getApplication().getApplicationContext(), paramString.a(), "Complete_download_2_1");
        }
        while (UniformDownloaderGen.a(this.a) != null)
        {
          UniformDownloaderGen.a(this.a).a(this.a.e, paramLong, paramBundle);
          return;
          QLog.i(UniformDownloaderGen.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 0");
        }
      }
      l1 = paramLong;
      l2 = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fyx
 * JD-Core Version:    0.7.0.1
 */