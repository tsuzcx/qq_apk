import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.vip.DownloadListener;

public class xld
  extends AbsPreDownloadTask
{
  public xld(PreloadComDownloader paramPreloadComDownloader, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, Bundle paramBundle, DownloadListener paramDownloadListener)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  protected void a()
  {
    PreloadComDownloader.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadComDownloader, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xld
 * JD-Core Version:    0.7.0.1
 */