import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class utm
  implements Runnable
{
  public utm(FileItemBuilder paramFileItemBuilder, utp paramutp, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    TextView localTextView = this.jdField_a_of_type_Utp.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    boolean bool = FileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder);
    int j = this.jdField_a_of_type_Utp.a.getMeasuredWidth();
    TextPaint localTextPaint = this.jdField_a_of_type_Utp.a.getPaint();
    if (FileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder)) {}
    for (int i = 2;; i = 3)
    {
      localTextView.setText(FileManagerUtil.a(str, bool, j, localTextPaint, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utm
 * JD-Core Version:    0.7.0.1
 */