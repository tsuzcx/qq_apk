import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;

public class uuc
  implements Runnable
{
  public uuc(FileVideoItemBuilder paramFileVideoItemBuilder, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder.a.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder.b.post(new uud(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uuc
 * JD-Core Version:    0.7.0.1
 */