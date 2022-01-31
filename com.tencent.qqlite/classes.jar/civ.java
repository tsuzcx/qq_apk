import android.view.View;
import com.tencent.mobileqq.activity.photo.PhotoCropAction;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class civ
  implements ActionSheet.OnButtonClickListener
{
  public civ(PhotoCropAction paramPhotoCropAction, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.c();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     civ
 * JD-Core Version:    0.7.0.1
 */