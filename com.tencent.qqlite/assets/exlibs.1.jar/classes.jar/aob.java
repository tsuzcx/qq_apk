import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aob
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  private long b = 0L;
  
  public aob(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      break label4;
    }
    label4:
    long l;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramView.getTag() instanceof DataTag));
        paramView = (DataTag)paramView.getTag();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "onClickListener and DataTag type=" + paramView.z);
        }
        l = System.currentTimeMillis();
        if (Math.abs(l - this.b) < 1000L) {
          break;
        }
        this.b = l;
        if ((!FriendProfileCardActivity.a(this.a)) && (FriendProfileCardActivity.a(this.a, paramView.z))) {
          break;
        }
        int i;
        switch (paramView.z)
        {
        case 11: 
        case 12: 
        case 15: 
        case 17: 
        case 19: 
        case 20: 
        case 22: 
        case 23: 
        case 24: 
        case 25: 
        default: 
          return;
        case 1: 
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int == 0) {
            if (ProfileCardUtil.a()) {
              this.a.a(2131363439, 1);
            }
          }
          for (;;)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8004173", "0X8004173", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
            return;
            if (this.a.jdField_a_of_type_ArrayOfInt == null) {
              this.a.jdField_a_of_type_ArrayOfInt = new int[5];
            }
            this.a.jdField_a_of_type_ArrayOfInt[0] = 13;
            this.a.jdField_a_of_type_ArrayOfInt[1] = 14;
            this.a.jdField_a_of_type_ArrayOfInt[2] = 12;
            i = 3;
            while (i < 5)
            {
              this.a.jdField_a_of_type_ArrayOfInt[i] = -1;
              i += 1;
            }
            this.a.a(this.a.jdField_a_of_type_ArrayOfInt, 2131624119);
            continue;
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int == 33) {
              break;
            }
            if (!ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a))
            {
              paramView = this.a.c();
              if ((paramView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
              {
                View localView = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.get("map_key_face");
                if (localView != null) {
                  ProfileCardUtil.a(this.a, localView, paramView);
                }
              }
            }
            else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
            {
              paramView = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.get("map_key_face");
              if (paramView != null) {
                if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString.equals("0"))) {
                  ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.p);
                } else {
                  ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString);
                }
              }
            }
          }
        case 4: 
          this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)paramView.a);
          if (this.a.jdField_a_of_type_ArrayOfInt == null) {
            this.a.jdField_a_of_type_ArrayOfInt = new int[5];
          }
          this.a.jdField_a_of_type_ArrayOfInt[0] = 7;
          this.a.jdField_a_of_type_ArrayOfInt[1] = 8;
          if (ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a))
          {
            this.a.jdField_a_of_type_ArrayOfInt[2] = 9;
            this.a.jdField_a_of_type_ArrayOfInt[3] = 16;
          }
          for (;;)
          {
            i = 4;
            while (i < 5)
            {
              this.a.jdField_a_of_type_ArrayOfInt[i] = -1;
              i += 1;
            }
            this.a.jdField_a_of_type_ArrayOfInt[2] = 16;
            this.a.jdField_a_of_type_ArrayOfInt[3] = -1;
          }
          this.a.a(this.a.jdField_a_of_type_ArrayOfInt, 2131624119);
          return;
        case 6: 
          this.a.h();
          ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Prof_new_photo", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
          return;
        case 5: 
          this.a.i();
          ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
          return;
        case 7: 
          this.a.f();
          ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.j), "", "");
          return;
        case 8: 
          this.a.g();
          ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.j), "", "");
          return;
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int != 0);
      paramView = new Intent(this.a.getActivity(), DetailProfileActivity.class);
      this.a.startActivityForResult(paramView, 1007);
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g == 8)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004178", "0X8004178", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004178", "0X8004178", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
      return;
      if ((paramView.a instanceof Card))
      {
        this.a.a((Card)paramView.a);
        return;
      }
      this.a.a(null);
      return;
      this.a.e();
      ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_clk_myQR", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
      return;
      FriendProfileCardActivity.a(this.a);
      return;
      paramView = new Intent(this.a, ProfileCardMoreActivity.class);
      paramView.putExtra("AllInOne", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
      paramView.addFlags(536870912);
      this.a.startActivityForResult(paramView, 1012);
      return;
      this.a.d();
      ReportController.b(this.a.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
      return;
      l = System.currentTimeMillis();
    } while (!ProfileActivity.a(this.a.c, l));
    this.a.c = l;
    ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString, this.a.app, this.a);
    ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pro_account_info", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
    return;
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004184", "0X8004184", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
    return;
    if ((paramView.a instanceof String)) {}
    for (paramView = (String)paramView.a;; paramView = null)
    {
      if ((TextUtils.isEmpty(paramView)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int == 0))
      {
        paramView = new Intent(this.a, EditActivity.class);
        paramView.putExtra("k_source", 4);
        this.a.startActivity(paramView);
      }
      for (;;)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004172", "0X8004172", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
        return;
        StatusHistoryActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
      }
      paramView = new Intent(this.a, QQBrowserActivity.class);
      paramView.putExtra("url", "http://web.p.qq.com/qqmpmobile/profilevipcard/index.html?uin=" + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("hide_more_button", true);
      this.a.startActivity(paramView);
      ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aob
 * JD-Core Version:    0.7.0.1
 */