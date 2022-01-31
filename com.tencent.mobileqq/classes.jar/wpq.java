import android.content.Intent;
import android.os.Build;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class wpq
  implements ActionSheet.OnButtonClickListener
{
  public wpq(AvatarPendantActivity paramAvatarPendantActivity, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        boolean bool;
        paramView.printStackTrace();
      }
      bool = VideoEnvironment.e();
      if ((AudioHelper.b()) || (Build.MODEL.contains("Redmi 3")) || (Build.MODEL.contains("M3S")))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, "该机型不支持动态头像功能。", 0).a();
      }
      else if (bool)
      {
        DynamicAvatarRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e)
        {
          ThreadManager.postImmediately(new wpr(this), null, true);
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e = true;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, "拍摄功能准备中，请稍候。", 0).a();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e();
        paramView = new Intent();
        paramInt = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity);
        paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        paramView.putExtra("Business_Origin", 100);
        paramView.putExtra("BUSINESS_ORIGIN_NEW", 100);
        paramView.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        paramView.putExtra("fromWhereClick", 11);
        PhotoUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, AvatarPendantActivity.class.getName(), paramInt, paramInt, 640, 640, ProfileCardUtil.a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004177", "0X8004177", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e();
        this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 5);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, QQBrowserActivity.class);
          paramView.putExtra("url", "https://ti.qq.com/avatarlist/public/index.html?_wv=3&_wwv=4");
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.startActivity(paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007C10", "0X8007C10", 0, 0, "", "", "", "");
        }
        else
        {
          ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpq
 * JD-Core Version:    0.7.0.1
 */