import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.eAnimType;
import com.tencent.qphone.base.util.QLog;

public class duk
  implements Runnable
{
  public duk(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase, int paramInt) {}
  
  public void run()
  {
    PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).c(false);
    if (PreviewingOfflineFileViewBase.j(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null) {
      PreviewingOfflineFileViewBase.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).d(false);
    }
    if (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null) {
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, (LinearLayout)PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).findViewById(2131298078));
    }
    if (PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null) {
      PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, new FilePreviewAnimQueue(PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase)));
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localFilePreviewAnim.jdField_a_of_type_Boolean = false;
    localFilePreviewAnim.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$eAnimType = FilePreviewAnimQueue.eAnimType.eAlphaAnim;
    localFilePreviewAnim.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).a(localFilePreviewAnim);
    PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).a();
    if (QLog.isColorLevel()) {
      QLog.i("PreviewingOfflineFileViewBase<FileAssistant>", 2, "hideGetMore(" + this.jdField_a_of_type_Int + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     duk
 * JD-Core Version:    0.7.0.1
 */