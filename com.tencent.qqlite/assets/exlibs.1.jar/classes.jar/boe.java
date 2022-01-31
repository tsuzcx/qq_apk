import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.data.TroopMemberCard;

public class boe
  implements View.OnClickListener
{
  public boe(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    case 4: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f;
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, ChatActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
      localIntent.putExtra("PREVIOUS_WINDOW", TroopMemberCardActivity.class.getName());
      localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        localIntent.putExtra("uintype", 0);
      }
      for (;;)
      {
        localIntent.putExtra("uinname", paramView);
        localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c);
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d);
        localIntent.addFlags(67108864);
        localIntent.putExtra("cSpecialFlag", 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity(localIntent);
        return;
        localIntent.putExtra("uintype", 1000);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     boe
 * JD-Core Version:    0.7.0.1
 */