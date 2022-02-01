import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.c;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.ArrayList;

public class wfa
  implements ausj.a
{
  public wfa(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, UncommonlyUsedContactsActivity.c paramc, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b instanceof Friends)) {}
    for (paramView = ((Friends)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b).uin;; paramView = ((PhoneContact)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b).mobileCode) {
      switch (paramInt)
      {
      default: 
        this.val$sheet.dismiss();
        do
        {
          return;
        } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b instanceof PhoneContact));
      }
    }
    Object localObject = wja.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), SplashActivity.class), null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b instanceof Friends))
    {
      ((Intent)localObject).putExtra("uintype", 0);
      ((Intent)localObject).putExtra("uin", paramView);
      ((Intent)localObject).putExtra("uinname", aqgv.D(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, paramView));
      ((Intent)localObject).putExtra("entrance", 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.startActivity((Intent)localObject);
      anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C51", "0X8004C51", 0, 0, "", "", "", "");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b instanceof PhoneContact))
      {
        ((Intent)localObject).putExtra("uintype", 1006);
        ((Intent)localObject).putExtra("uin", paramView);
        ((Intent)localObject).putExtra("uinname", ((PhoneContact)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b).name);
        ((Intent)localObject).putExtra("entrance", 2);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b instanceof Friends))
    {
      paramView = new ProfileActivity.AllInOne(paramView, 1);
      paramView.bJa = 59;
      paramView.bJc = 2;
    }
    for (;;)
    {
      ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), paramView);
      anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C52", "0X8004C52", 0, 0, "", "", "", "");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b instanceof PhoneContact))
      {
        localObject = (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b;
        paramView = new ProfileActivity.AllInOne(((PhoneContact)localObject).mobileCode, 34);
        paramView.bJa = 59;
        paramView.nickname = ((PhoneContact)localObject).name;
        paramView.bJc = 2;
        continue;
        if (aqiw.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity())) {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b instanceof Friends))
          {
            localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getBusinessHandler(1);
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramView);
            ((FriendListHandler)localObject).a((short)1, localArrayList, false);
          }
        }
        for (;;)
        {
          anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C53", "0X8004C53", 0, 0, "", "", "", "");
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b instanceof PhoneContact))
          {
            ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getManager(11)).bd(((PhoneContact)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$c.b).mobileCode, false);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.cf(2131696349, 0);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.vT(paramView);
        anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C54", "0X8004C54", 0, 0, "", "", "", "");
        break;
      }
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfa
 * JD-Core Version:    0.7.0.1
 */