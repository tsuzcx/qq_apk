import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;

public class uws
  implements Runnable
{
  public uws(FilePicItemBuilder paramFilePicItemBuilder, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    FilePicURLDrawlableHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder.b.post(new uwt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uws
 * JD-Core Version:    0.7.0.1
 */