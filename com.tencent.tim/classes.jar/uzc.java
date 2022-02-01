import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.23.1;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class uzc
  implements ausj.a
{
  public uzc(FriendProfileCardActivity paramFriendProfileCardActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.this$0.fp == null) || (paramInt >= this.this$0.fp.length)) {
      return;
    }
    switch (this.this$0.fp[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        this.val$sheet.a(null);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      this.this$0.c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      if (ProfileActivity.AllInOne.a(this.this$0.jdField_a_of_type_Alcn.e))
      {
        this.this$0.copyContent(this.this$0.jdField_a_of_type_Alcn.e.uin);
        if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Alcn.e.uin))
        {
          ThreadManager.post(new FriendProfileCardActivity.23.1(this), 5, null, true);
          continue;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
          {
            paramView = (View)this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_face");
            View localView = (View)this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_avatar_pendant");
            long l = this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.pendantId;
            if ((!ProfileActivity.AllInOne.g(this.this$0.jdField_a_of_type_Alcn.e)) || (localView == null) || (paramView == null) || (localView.getVisibility() != 0) || (l == 0L)) {
              break label467;
            }
            aqep.a(this.this$0, paramView, this.this$0.jdField_a_of_type_Alcn.e.uin, l, 0);
          }
          for (;;)
          {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8004175", "0X8004175", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, "", "", "", "");
            break;
            label467:
            if (paramView != null) {
              aqep.a(this.this$0, paramView, this.this$0.jdField_a_of_type_Alcn.e.uin);
            }
          }
          this.this$0.x = ProfileActivity.a(this.this$0, 5);
          anot.a(this.this$0.app, "CliOper", "", "", "0X8004176", "0X8004176", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, "", "", "", "");
          continue;
          paramView = new Intent();
          paramInt = aqep.w(this.this$0);
          paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
          paramView.putExtra("Business_Origin", 100);
          PhotoUtils.a(paramView, this.this$0, FriendProfileCardActivity.class.getName(), paramInt, paramInt, 1080, 1080, aqep.BR());
          anot.a(this.this$0.app, "CliOper", "", "", "0X8004177", "0X8004177", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, "", "", "", "");
          continue;
          try
          {
            paramView = avpw.d.a();
            paramView.cMP = this.this$0.app.getCurrentAccountUin();
            paramView.nickname = this.this$0.app.getCurrentNickname();
            avpw.a(this.this$0, paramView, Long.valueOf(this.this$0.jdField_a_of_type_Alcn.e.uin).longValue(), -1);
            anot.a(this.this$0.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), "", "", "");
          }
          catch (Exception paramView) {}
          if (QLog.isColorLevel())
          {
            QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
            continue;
            if (!aqft.cC())
            {
              Toast.makeText(this.this$0.getApplicationContext(), this.this$0.getString(2131719242), 0).show();
            }
            else
            {
              boolean bool2 = true;
              boolean bool1 = bool2;
              if (this.this$0.jdField_a_of_type_Alcn != null)
              {
                bool1 = bool2;
                if (this.this$0.jdField_a_of_type_Alcn.e != null)
                {
                  bool1 = bool2;
                  if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
                    bool1 = false;
                  }
                }
              }
              this.this$0.e.dqV();
              aqgm.a(this.this$0.app, this.this$0, bool1, null);
              anot.a(this.this$0.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoButtonClick", 0, 0, "", "", "", "");
              continue;
              if (FriendProfileCardActivity.a(this.this$0) == 98)
              {
                anot.a(this.this$0.app, "dc00898", "", "", "0X800A97D", "0X800A97D", 3, 0, "0", "0", "", "");
                continue;
                FriendProfileCardActivity.a(this.this$0);
                if (FriendProfileCardActivity.a(this.this$0) == 98)
                {
                  anot.a(this.this$0.app, "dc00898", "", "", "0X800A97D", "0X800A97D", 1, 0, "0", "0", "", "");
                  continue;
                  aqep.fw(this.this$0);
                  if (FriendProfileCardActivity.a(this.this$0) == 98) {
                    anot.a(this.this$0.app, "dc00898", "", "", "0X800A97D", "0X800A97D", 2, 0, "0", "0", "", "");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzc
 * JD-Core Version:    0.7.0.1
 */