import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.eAnimType;

public class dun
  implements Runnable
{
  public dun(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    if (PreviewingOfflineFileViewBase.a(this.a) == null) {
      PreviewingOfflineFileViewBase.a(this.a, new FilePreviewAnimQueue(PreviewingOfflineFileViewBase.a(this.a)));
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localFilePreviewAnim.jdField_a_of_type_Boolean = false;
    localFilePreviewAnim.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$eAnimType = FilePreviewAnimQueue.eAnimType.eAlphaAnim;
    localFilePreviewAnim.jdField_a_of_type_Int = 1500;
    PreviewingOfflineFileViewBase.a(this.a).a(localFilePreviewAnim);
    PreviewingOfflineFileViewBase.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dun
 * JD-Core Version:    0.7.0.1
 */