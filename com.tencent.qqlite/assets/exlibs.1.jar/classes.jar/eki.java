import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class eki
  implements ActionSheet.OnButtonClickListener
{
  String jdField_a_of_type_JavaLangString = (String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getItem(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
  
  public eki(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.c)
    {
      if (AvatarTroopUtil.b(this.jdField_a_of_type_JavaLangString)) {
        break label77;
      }
      i = 1;
      label22:
      if (i == 0) {
        break label82;
      }
      paramView = this.jdField_a_of_type_JavaLangString;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramInt = 2;
      break;
      label77:
      i = 0;
      break label22;
      label82:
      if (this.jdField_a_of_type_JavaLangString.equals("-5")) {}
      for (paramView = AvatarTroopUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.j, 0);; paramView = AvatarTroopUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.j, 1))
      {
        AvatarTroopUtil.a(paramView);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eki
 * JD-Core Version:    0.7.0.1
 */