package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.data.TroopMemberCard;
import uvq;

public class EditInfoActivity$11$2
  implements Runnable
{
  public EditInfoActivity$11$2(uvq paramuvq, TroopMemberCard paramTroopMemberCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.colorCard);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Uvq.this$0.mAction);
      this.jdField_a_of_type_Uvq.this$0.setResult(-1, localIntent);
      EditInfoActivity.d(this.jdField_a_of_type_Uvq.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.11.2
 * JD-Core Version:    0.7.0.1
 */