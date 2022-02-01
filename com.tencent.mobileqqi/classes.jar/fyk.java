import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;

public class fyk
  implements Animation.AnimationListener
{
  public fyk(FilePreviewAnimQueue paramFilePreviewAnimQueue, FilePreviewAnimQueue.FilePreviewAnim paramFilePreviewAnim) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$FilePreviewAnim.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fyk
 * JD-Core Version:    0.7.0.1
 */