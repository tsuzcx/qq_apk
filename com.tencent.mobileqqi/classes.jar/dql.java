import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.data.TroopMemberCard;

public class dql
  implements View.OnClickListener
{
  public dql(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    Object localObject;
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    case 4: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f;
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, ChatActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
      ((Intent)localObject).putExtra("PREVIOUS_WINDOW", TroopMemberCardActivity.class.getName());
      ((Intent)localObject).putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        ((Intent)localObject).putExtra("uintype", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("uinname", paramView);
        ((Intent)localObject).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c);
        ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("cSpecialFlag", 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity((Intent)localObject);
        return;
        ((Intent)localObject).putExtra("uintype", 1000);
      }
    case 5: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        paramView = null;
      }
      for (;;)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, i, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e, (String)localObject, null, true, paramView, true, true, null, "");
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d;
        i = 1000;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dql
 * JD-Core Version:    0.7.0.1
 */