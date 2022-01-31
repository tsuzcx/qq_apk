import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class axg
  implements ActionSheet.OnButtonClickListener
{
  public axg(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a();
      return;
      NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity, ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity, 5));
      continue;
      paramView = new ArrayList();
      paramInt = 0;
      while (paramInt < NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).size() - 1)
      {
        localObject = (ayx)NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).get(paramInt);
        if (!StringUtil.b(((ayx)localObject).a)) {
          paramView.add(((ayx)localObject).a);
        }
        paramInt += 1;
      }
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.getClass().getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
      paramView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      paramView.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      Object localObject = AppConstants.as + this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.app.a() + "/" + "nearby_people_photo/";
      paramView.putExtra("PhotoConst.TARGET_PATH", (String)localObject + System.currentTimeMillis() + ".jpg");
      paramView.putExtra("PhotoConst.CLIP_WIDTH", 640);
      paramView.putExtra("PhotoConst.CLIP_HEIGHT", 640);
      paramView.putExtra("PhotoConst.TARGET_WIDTH", 640);
      paramView.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.startActivity(paramView);
      AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity, false, true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axg
 * JD-Core Version:    0.7.0.1
 */