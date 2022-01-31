import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.widget.ActionSheet;
import java.io.File;

public class bza
  implements Runnable
{
  public bza(AIOGalleryScene paramAIOGalleryScene, File paramFile, ActionSheet paramActionSheet) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d.equals(this.jdField_a_of_type_JavaIoFile.getPath())) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_JavaIoFile).booleanValue())) {
      new Handler(Looper.getMainLooper()).post(new bzb(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bza
 * JD-Core Version:    0.7.0.1
 */