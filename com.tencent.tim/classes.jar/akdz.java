import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.a;
import com.tencent.mobileqq.widget.TabBarView;

class akdz
  implements NearbyMomentFragment.a
{
  akdz(akcx paramakcx, int paramInt) {}
  
  public void onResult(int paramInt)
  {
    if ((this.bwX == -1) && (this.this$0.b != null))
    {
      if (paramInt > 0) {
        this.this$0.b.setSelectedTab(1, false);
      }
    }
    else
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(null);
      if (this.this$0.b != null)
      {
        if (this.this$0.b.qt() != 0) {
          break label160;
        }
        localObject = new anov(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label154;
        }
      }
    }
    label154:
    for (String str = "1";; str = "2")
    {
      ((anov)localObject).a(new String[] { str }).report();
      return;
      this.this$0.b.setSelectedTab(0, false);
      break;
    }
    label160:
    anov localanov = new anov(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      str = "1";
      if (paramInt != 0) {
        break label250;
      }
    }
    label250:
    for (Object localObject = "1";; localObject = "2")
    {
      localanov.a(new String[] { str, localObject }).report();
      return;
      str = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akdz
 * JD-Core Version:    0.7.0.1
 */