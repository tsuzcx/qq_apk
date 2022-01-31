import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.utils.ViewUtils;

public class wuc
  implements Runnable
{
  public wuc(PhotoListActivity paramPhotoListActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_AndroidWidgetTextView.getPaint();
    int i = ViewUtils.a((Paint)localObject, "《");
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_AndroidViewView.getLeft();
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.d.getRight();
    localObject = ViewUtils.a((Paint)localObject, this.jdField_a_of_type_JavaLangString, j - k - i * 2);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_AndroidWidgetTextView.setText("《" + (String)localObject + "》");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wuc
 * JD-Core Version:    0.7.0.1
 */