import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class uwp
  implements Runnable
{
  public uwp(FileItemBuilder paramFileItemBuilder, uwr paramuwr, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    TextView localTextView = this.jdField_a_of_type_Uwr.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName;
    boolean bool = FileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder);
    int j = this.jdField_a_of_type_Uwr.a.getMeasuredWidth();
    TextPaint localTextPaint = this.jdField_a_of_type_Uwr.a.getPaint();
    if (FileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder)) {}
    for (int i = 2;; i = 3)
    {
      localTextView.setText(FileManagerUtil.a(str, bool, j, localTextPaint, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwp
 * JD-Core Version:    0.7.0.1
 */