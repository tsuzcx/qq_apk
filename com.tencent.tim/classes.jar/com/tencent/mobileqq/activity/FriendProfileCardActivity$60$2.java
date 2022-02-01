package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import vaq;

public class FriendProfileCardActivity$60$2
  implements Runnable
{
  public FriendProfileCardActivity$60$2(vaq paramvaq) {}
  
  public void run()
  {
    try
    {
      if (this.a.this$0.root == null) {
        return;
      }
      this.a.this$0.ZM();
      if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null)
      {
        this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.a.this$0.jdField_a_of_type_Alcn, false, new String[0]);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("FriendProfileCardActivity", 1, "onConfigUpdate fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.60.2
 * JD-Core Version:    0.7.0.1
 */