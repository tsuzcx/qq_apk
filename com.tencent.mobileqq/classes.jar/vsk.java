import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ActionSheet;
import java.io.File;
import mqq.os.MqqHandler;

public class vsk
  implements Runnable
{
  public vsk(AIOGalleryScene paramAIOGalleryScene, File paramFile, ActionSheet paramActionSheet) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h.equals(this.jdField_a_of_type_JavaIoFile.getPath())) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_JavaIoFile).booleanValue()) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      ThreadManager.getUIHandler().post(new vsl(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsk
 * JD-Core Version:    0.7.0.1
 */