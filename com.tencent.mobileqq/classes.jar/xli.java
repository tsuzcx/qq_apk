import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.ResUtil;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.lang.ref.WeakReference;

public class xli
  extends DownloadListener
{
  public xli(PreloadManager paramPreloadManager, WeakReference paramWeakReference, boolean paramBoolean, PreloadManager.OnGetPathListener paramOnGetPathListener) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    Object localObject = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!PreloadManager.a((PreloadManager)localObject)) {
      return;
    }
    if (paramDownloadTask.jdField_a_of_type_Int == 0)
    {
      localObject = ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, (PreloadManager)localObject, this.jdField_a_of_type_Boolean, 0);
      PreloadManager.PathResult localPathResult = new PreloadManager.PathResult();
      localPathResult.url = paramDownloadTask.jdField_a_of_type_JavaLangString;
      localPathResult.filePath = ((ResourceInfo)localObject).filePath;
      localPathResult.folderPath = ((ResourceInfo)localObject).folderPath;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener.onResult(0, localPathResult);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener.onResult(1, PreloadManager.PathResult.getFailRes(paramDownloadTask.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xli
 * JD-Core Version:    0.7.0.1
 */