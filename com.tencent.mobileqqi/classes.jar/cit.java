import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

public class cit
  implements ActionSheet.OnButtonClickListener
{
  public cit(DoodleActivity paramDoodleActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    case 0: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity.getIntent();
      paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      PhotoUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity, DoodleActivity.class.getName(), 1, true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    paramView = new Intent();
    this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity.a = FileProvider7Helper.setSystemCapture(this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity, new File(AppConstants.an + "photo/" + System.currentTimeMillis() + ".jpg"), paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity.startActivityForResult(paramView, 1);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cit
 * JD-Core Version:    0.7.0.1
 */