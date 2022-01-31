import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.widget.Gallery;

public class vrs
  implements FMDialogUtil.FMDialogInterface
{
  public vrs(AIOGalleryScene paramAIOGalleryScene, AIORichMediaInfo paramAIORichMediaInfo) {}
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b.setText(AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, (float)((AIOFilePicData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_Int));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_Vss.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_Vss.jdField_a_of_type_Int, 20);
      AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).b(true);
      AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).a(true);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrs
 * JD-Core Version:    0.7.0.1
 */