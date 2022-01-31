import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.utils.ViewUtils;

public class vpe
  implements Runnable
{
  public vpe(PhotoListPanel paramPhotoListPanel, String paramString) {}
  
  public void run()
  {
    Object localObject = PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).getPaint();
    int i = ViewUtils.a((Paint)localObject, "《");
    int j = PhotoListPanel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).getLeft();
    int k = PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).getRight();
    localObject = ViewUtils.a((Paint)localObject, this.jdField_a_of_type_JavaLangString, j - k - i * 2);
    PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).setText("《" + (String)localObject + "》");
    PhotoListPanel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel).setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpe
 * JD-Core Version:    0.7.0.1
 */