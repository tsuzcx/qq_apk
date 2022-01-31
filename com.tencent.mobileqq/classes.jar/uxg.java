import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.qphone.base.util.QLog;

public class uxg
  implements Runnable
{
  public uxg(FileVideoItemBuilder paramFileVideoItemBuilder, FileManagerEntity paramFileManagerEntity, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight > 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth > 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]download video thumb success， but entity has size(wh)[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ":" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder.a.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder.b.post(new uxh(this));
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      FilePicURLDrawlableHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath, localOptions);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth = localOptions.outWidth;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight = localOptions.outHeight;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]entity no size, get and use thumb size(wh)[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ":" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxg
 * JD-Core Version:    0.7.0.1
 */