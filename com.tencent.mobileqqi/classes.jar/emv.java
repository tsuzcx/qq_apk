import android.view.View;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class emv
  implements ActionSheet.OnButtonClickListener
{
  public emv(PhotoListActivity paramPhotoListActivity, ArrayList paramArrayList, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(paramInt);
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    } while (paramView == null);
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "onQualityBtnClick clikedBtn text:" + paramView);
    }
    if (paramView.contains(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getString(2131562937))) {
      paramInt = i;
    }
    for (;;)
    {
      PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramInt = i;
      if (paramView.contains(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getString(2131562273)))
      {
        i = 1;
        paramInt = i;
        if (QLog.isColorLevel())
        {
          QLog.d("raw_photo_4_test", 2, "start:" + paramView + ",photolist:" + this.jdField_a_of_type_JavaUtilArrayList.toString());
          paramInt = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     emv
 * JD-Core Version:    0.7.0.1
 */