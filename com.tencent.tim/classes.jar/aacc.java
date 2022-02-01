import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aacc
{
  private static volatile aacc a;
  private aqva jdField_b_of_type_Aqva;
  private aqvc jdField_b_of_type_Aqvc;
  
  private aacc()
  {
    if (this.jdField_b_of_type_Aqva == null)
    {
      this.jdField_b_of_type_Aqva = new aqva(null);
      this.jdField_b_of_type_Aqvc = this.jdField_b_of_type_Aqva.a(1);
    }
  }
  
  public static aacc a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aacc();
      }
      return a;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, aquy paramaquy, DownloadParam paramDownloadParam)
  {
    ThreadManager.post(new PreloadComDownloader.3(this, paramDownloadParam, paramaquy, paramBundle), 8, null, true);
  }
  
  public void a(DownloadParam paramDownloadParam, aquy paramaquy, Bundle paramBundle)
  {
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url)) || (TextUtils.isEmpty(paramDownloadParam.filePath))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      if (!paramDownloadParam.isPreDownload) {
        break;
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (localQQAppInterface == null);
    paramaquy = new aacd(this, paramaquy);
    paramaquy = new aace(this, localQQAppInterface, paramDownloadParam.url, paramBundle, paramaquy, paramDownloadParam);
    ((aopo)localQQAppInterface.getManager(193)).a(10069, "qqpay", paramDownloadParam.url, 0, paramDownloadParam.url, paramDownloadParam.filePath, 2, 0, true, paramaquy);
    return;
    a(paramBundle, paramaquy, paramDownloadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacc
 * JD-Core Version:    0.7.0.1
 */