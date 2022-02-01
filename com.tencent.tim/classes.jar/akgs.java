import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akgs
  implements View.OnClickListener
{
  akgs(akgm paramakgm) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aj.getIntExtra("param_mode", 0) == 1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 1)
      {
        aurd.cE(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696272));
        }
        else if (akgm.a(this.this$0))
        {
          this.this$0.GO();
          boolean bool1 = this.this$0.arK();
          boolean bool2 = ((Boolean)ajrb.c(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
          Object localObject;
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
          {
            localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696260, new Object[] { this.this$0.bTo });
            localObject = aqha.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((aqju)localObject).setPositiveButton(acfp.m(2131708823), new akgt(this, (aqju)localObject));
            ((aqju)localObject).setNegativeButton(acfp.m(2131708818), new akgu(this, (aqju)localObject));
            ((aqju)localObject).show();
          }
          else if ((bool1) && (bool2))
          {
            localObject = acfp.m(2131708847);
            localObject = aqha.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((aqju)localObject).setPositiveButton(acfp.m(2131708869), new akgv(this, (aqju)localObject));
            ((aqju)localObject).setNegativeButton(acfp.m(2131708902), new akgw(this, (aqju)localObject));
            ((aqju)localObject).show();
            ajrb.c(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
          }
          else if (bool1)
          {
            this.this$0.dBm();
            localObject = new Intent("tribe_profile_edit_finish");
            BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          }
          else
          {
            anot.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
            this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dAy();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgs
 * JD-Core Version:    0.7.0.1
 */