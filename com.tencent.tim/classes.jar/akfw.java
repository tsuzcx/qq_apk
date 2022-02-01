import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

class akfw
  implements View.OnClickListener
{
  akfw(akfk paramakfk) {}
  
  public void onClick(View paramView)
  {
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aj.getIntExtra("param_mode", 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.MI(false);
    if ((i == 1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 1)
        {
          aurd.cE(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
          if (aqiw.isNetSupport(BaseApplication.getContext())) {
            break;
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696272));
        }
      }
    } while (!akfk.a(this.this$0));
    this.this$0.GO();
    boolean bool1 = this.this$0.arK();
    boolean bool2 = ((Boolean)ajrb.c(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
    boolean bool3 = this.this$0.arN();
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get() != null)) {}
    for (i = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).uint32_state.get();; i = 0)
    {
      if ((i == 1) || (i == 2)) {}
      for (i = 1;; i = 0)
      {
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!bool3) || (i == 0)) {
          break label413;
        }
        new anov(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_change").a(new String[] { "", "" + (this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1) }).report();
        this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crJ = bool3;
        this.this$0.dBm();
        break;
      }
      label413:
      Object localObject;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
      {
        localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696260, new Object[] { this.this$0.bTo });
        localObject = aqha.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
        ((aqju)localObject).setPositiveButton(acfp.m(2131708795), new akfx(this, (aqju)localObject));
        ((aqju)localObject).setNegativeButton(acfp.m(2131708924), new akfy(this, (aqju)localObject));
        ((aqju)localObject).show();
        break;
      }
      if ((bool1) && (bool2))
      {
        localObject = acfp.m(2131708912);
        localObject = aqha.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
        ((aqju)localObject).setPositiveButton(acfp.m(2131708861), new akfz(this, (aqju)localObject));
        ((aqju)localObject).setNegativeButton(acfp.m(2131708863), new akga(this, (aqju)localObject));
        ((aqju)localObject).show();
        ajrb.c(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
        break;
      }
      if (bool1)
      {
        this.this$0.dBm();
        break;
      }
      anot.a(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dAy();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akfw
 * JD-Core Version:    0.7.0.1
 */