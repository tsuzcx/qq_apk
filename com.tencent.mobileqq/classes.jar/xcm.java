import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.TimerTask;

public class xcm
  extends TimerTask
{
  public xcm(PreloadManager paramPreloadManager, WeakReference paramWeakReference, List paramList, DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a(localPreloadManager)) {
      PreloadManager.a(localPreloadManager, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcm
 * JD-Core Version:    0.7.0.1
 */