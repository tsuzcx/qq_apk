import android.os.Bundle;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class wyn
  implements Runnable
{
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference b;
  
  public wyn(AvatarPendantActivity paramAvatarPendantActivity, DownloadListener paramDownloadListener, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDownloadListener);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      DownloaderInterface localDownloaderInterface = ((DownloaderFactory)((QQAppInterface)this.b.get()).getManager(46)).a(1);
      if (localDownloaderInterface.a(AvatarPendantUtil.a) == null)
      {
        Object localObject = new File(AvatarPendantUtil.b + "/icon.zip");
        localObject = new DownloadTask(AvatarPendantUtil.a, (File)localObject);
        ((DownloadTask)localObject).n = false;
        Bundle localBundle = new Bundle();
        localDownloaderInterface.a((DownloadTask)localObject, (DownloadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyn
 * JD-Core Version:    0.7.0.1
 */