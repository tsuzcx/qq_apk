import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.HashMap;

public class cti
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  private long b;
  
  public cti(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject2;
    long l;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramView.getTag() instanceof DataTag));
        localObject2 = (DataTag)paramView.getTag();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "onClickListener and DataTag type=" + ((DataTag)localObject2).C);
        }
        l = System.currentTimeMillis();
      } while (Math.abs(l - this.jdField_b_of_type_Long) < 1000L);
      this.jdField_b_of_type_Long = l;
    } while ((!FriendProfileCardActivity.a(this.a)) && (FriendProfileCardActivity.a(this.a, ((DataTag)localObject2).C)));
    label277:
    Object localObject1;
    label555:
    int i;
    switch (((DataTag)localObject2).C)
    {
    case 11: 
    case 12: 
    case 15: 
    case 25: 
    default: 
      return;
    case 1: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        if (ProfileCardUtil.a()) {
          this.a.a(2131563147, 1);
        }
      }
    case 17: 
      for (;;)
      {
        ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004173", "0X8004173", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if ((!ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null)) {
          break;
        }
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
        localObject1 = QZoneHelper.UserInfo.a();
        ((QZoneHelper.UserInfo)localObject1).jdField_a_of_type_JavaLangString = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((QZoneHelper.UserInfo)localObject1).b = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
        ((QZoneHelper.UserInfo)localObject1).c = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          QZoneHelper.b(this.a, (QZoneHelper.UserInfo)localObject1, paramView, 1008);
          localObject1 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label555;
          }
        }
        for (paramView = "pro_self";; paramView = "pro_other")
        {
          ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "photo_wall", paramView, ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if (paramView == null) {
            break;
          }
          QZoneHelper.b(this.a, (QZoneHelper.UserInfo)localObject1, paramView, 1008);
          break;
        }
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
        this.a.a(this.a.jdField_a_of_type_ArrayOfInt);
        continue;
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {
          break;
        }
        if (!ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          paramView = this.a.c();
          if ((paramView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
          {
            localObject1 = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
            if (localObject1 != null) {
              ProfileCardUtil.a(this.a, (View)localObject1, paramView);
            }
          }
        }
        else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramView = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
          localObject1 = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
          l = this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
          if ((!ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject1 == null) || (paramView == null) || (((View)localObject1).getVisibility() != 0) || (l == 0L)) {
            break label1117;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label925;
          }
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "ZhurenInfoHeadClick", 0, 0, "", "", "", "");
          i = 0;
          label898:
          ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, l, i);
        }
      }
      label925:
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) {
        i = 1;
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
        break label898;
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
        {
          i = 2;
        }
        else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21)
        {
          i = 3;
        }
        else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45)
        {
          i = 4;
        }
        else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
        {
          i = 5;
        }
        else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41)
        {
          i = 6;
        }
        else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42)
        {
          i = 7;
          continue;
          label1117:
          if (paramView == null) {
            break label277;
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
          {
            ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o);
            break label277;
          }
          ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          break label277;
          this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject2).a);
          if (this.a.jdField_a_of_type_ArrayOfInt == null) {
            this.a.jdField_a_of_type_ArrayOfInt = new int[5];
          }
          this.a.jdField_a_of_type_ArrayOfInt[0] = 7;
          this.a.jdField_a_of_type_ArrayOfInt[1] = 8;
          if (ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
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
          FriendProfileCardActivity.a(true);
          this.a.a(this.a.jdField_a_of_type_ArrayOfInt);
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_phone_number", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          this.a.i();
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_new_photo", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          this.a.j();
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          this.a.g();
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i), "", "");
          return;
          this.a.h();
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i), "", "");
          return;
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break;
          }
          paramView = new Intent(this.a.a(), DetailProfileActivity.class);
          this.a.startActivityForResult(paramView, 1007);
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f == 8)
          {
            ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004178", "0X8004178", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004178", "0X8004178", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if (FriendProfileCardActivity.a(this.a) != null)
          {
            this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("svip_profile_show_newer_guide_flag", true).commit();
            FriendProfileCardActivity.a(this.a).setVisibility(8);
            FriendProfileCardActivity.a(this.a, null);
          }
          paramView = new Intent(this.a, ProfileCardBrowserActivity.class);
          paramView.putExtra("AllInOne", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (FriendProfileCardActivity.a(this.a) != null) {
            paramView.putExtra("CurrentTemplateId", FriendProfileCardActivity.a(this.a).jdField_a_of_type_Long);
          }
          for (;;)
          {
            this.a.startActivity(paramView);
            localObject1 = "CLICK_PERSOMCARD";
            paramView = (View)localObject1;
            if (((DataTag)localObject2).a != null)
            {
              paramView = (View)localObject1;
              if ((((DataTag)localObject2).a instanceof String)) {
                paramView = (String)((DataTag)localObject2).a;
              }
            }
            ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", paramView, ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            return;
            paramView.putExtra("CurrentTemplateId", 0L);
          }
          int j = ((Integer)((DataTag)localObject2).a).intValue();
          if ((j == 101107) || (j == 101108))
          {
            if (j != 101108) {
              break label2282;
            }
            i = 5;
            if (j != 101108) {
              break label2287;
            }
            VipUtils.b(this.a, 3, ProfileCardUtil.a(i));
          }
          for (;;)
          {
            ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            return;
            label2282:
            i = 2;
            break;
            label2287:
            VipUtils.a(this.a, 3, ProfileCardUtil.a(i));
          }
          if ((((DataTag)localObject2).a instanceof Card))
          {
            this.a.a((Card)((DataTag)localObject2).a);
            return;
          }
          this.a.a(null);
          return;
          this.a.f();
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_clk_myQR", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          FriendProfileCardActivity.a(this.a);
          return;
          paramView = new Intent(this.a, ProfileCardMoreActivity.class);
          paramView.putExtra("AllInOne", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          paramView.addFlags(536870912);
          this.a.startActivityForResult(paramView, 1012);
          return;
          this.a.e();
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "QQ_rank", "click_qrank_in", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          l = System.currentTimeMillis();
          if (!ProfileActivity.a(this.a.jdField_b_of_type_Long, l)) {
            break;
          }
          this.a.jdField_b_of_type_Long = l;
          ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a);
          ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pro_account_info", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if ((((DataTag)localObject2).a instanceof ProfileBusiEntry))
          {
            paramView = (ProfileBusiEntry)((DataTag)localObject2).a;
            localObject1 = new Intent(this.a, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("portraitOnly", true);
            ((Intent)localObject1).putExtra("url", paramView.d);
          }
          try
          {
            this.a.startActivity((Intent)localObject1);
            ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004184", "0X8004184", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            return;
            if ((((DataTag)localObject2).a instanceof Object[]))
            {
              paramView = (Object[])((DataTag)localObject2).a;
              boolean bool = ((Boolean)paramView[0]).booleanValue();
              paramView = (String)paramView[1];
              this.a.a(bool, paramView);
            }
            ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004183", "0X8004183 ", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            return;
            if ((((DataTag)localObject2).a instanceof String))
            {
              paramView = (String)((DataTag)localObject2).a;
              if ((TextUtils.isEmpty(paramView)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
              {
                paramView = new Intent(this.a, EditActivity.class);
                paramView.putExtra("k_source", 4);
                this.a.startActivity(paramView);
              }
              for (;;)
              {
                ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004172", "0X8004172", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
                return;
                StatusHistoryActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
              }
              ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_freecall", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
              i = ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
              localObject2 = null;
              String str1 = null;
              if (ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
              {
                localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
                localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
                paramView = (View)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
                }
                String str2 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
                localObject1 = str2;
                if (TextUtils.isEmpty(str2)) {
                  localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.l;
                }
                if ((i != 0) || (TextUtils.isEmpty(paramView))) {
                  break label3520;
                }
                label3297:
                localObject1 = null;
                if (i != 1000) {
                  break label3724;
                }
                localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c;
                label3322:
                ChatActivityUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a, i, (String)localObject2, paramView, str1, true, (String)localObject1, true, true, null, "from_internal");
                switch (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
                {
                default: 
                  paramView = "4";
                }
              }
              for (;;)
              {
                ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramView, "", "", "");
                return;
                str1 = this.a.c();
                break;
                label3520:
                if ((i == 1000) || (i == 1020))
                {
                  paramView = (View)localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label3297;
                  }
                }
                if (i == 1021)
                {
                  if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a == null)) {
                    break label4059;
                  }
                  localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
                  paramView = (View)localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label4056;
                  }
                  localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
                  paramView = (View)localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label4056;
                  }
                  paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
                  break label3297;
                }
                paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
                if (ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
                  paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
                }
                localObject1 = paramView;
                if (TextUtils.isEmpty(paramView)) {
                  localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g;
                }
                paramView = (View)localObject1;
                break label3297;
                label3724:
                if (i != 1004) {
                  break label3322;
                }
                localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
                break label3322;
                paramView = "4";
                continue;
                paramView = "5";
                continue;
                paramView = "6";
                continue;
                paramView = "7";
              }
              paramView = new Intent(this.a, QQBrowserActivity.class);
              paramView.putExtra("url", "http://web.p.qq.com/qqmpmobile/profilevipcard/index.html?uin=" + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              paramView.putExtra("hide_operation_bar", true);
              paramView.putExtra("hide_more_button", true);
              this.a.startActivity(paramView);
              ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
              return;
              this.a.c();
              return;
              if ((((DataTag)localObject2).a instanceof ProfileBusiEntry))
              {
                paramView = (ProfileBusiEntry)((DataTag)localObject2).a;
                localObject1 = new Intent(this.a, QQBrowserActivity.class);
                ((Intent)localObject1).putExtra("url", paramView.d);
                ((Intent)localObject1).putExtra("hide_operation_bar", true);
                ((Intent)localObject1).putExtra("hide_more_button", true);
                this.a.startActivity((Intent)localObject1);
              }
              if (28 != ((DataTag)localObject2).C) {
                break;
              }
              ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004181", "0X8004181", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
              return;
            }
          }
          catch (SecurityException paramView)
          {
            for (;;)
            {
              continue;
              label4056:
              continue;
              label4059:
              localObject1 = null;
              continue;
              paramView = null;
            }
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cti
 * JD-Core Version:    0.7.0.1
 */