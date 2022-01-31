import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import mqq.os.MqqHandler;

public class vsq
  implements Runnable
{
  public vsq(AIOGalleryScene paramAIOGalleryScene, File paramFile, ActionSheet paramActionSheet) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h != null) && (this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h.equals(this.jdField_a_of_type_JavaIoFile.getPath())) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_JavaIoFile).booleanValue()) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        ThreadManager.getUIHandler().post(new vsr(this));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("AIOGalleryScene", 1, "add qr action sheet error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsq
 * JD-Core Version:    0.7.0.1
 */