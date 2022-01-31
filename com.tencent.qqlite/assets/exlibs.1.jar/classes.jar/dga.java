import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.eAnimType;
import com.tencent.qphone.base.util.QLog;

public class dga
  implements Runnable
{
  public dga(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.a.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue == null) {
      this.a.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = new FilePreviewAnimQueue(this.a.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.a.jdField_c_of_type_AndroidWidgetTextView.setText(2131363572);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
    localAlphaAnimation.setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localFilePreviewAnim.jdField_a_of_type_Boolean = true;
    localFilePreviewAnim.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$eAnimType = FilePreviewAnimQueue.eAnimType.eAlphaAnim;
    localFilePreviewAnim.jdField_a_of_type_Int = 1000;
    this.a.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a(localFilePreviewAnim);
    this.a.jdField_c_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "showGetmore(1000)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dga
 * JD-Core Version:    0.7.0.1
 */