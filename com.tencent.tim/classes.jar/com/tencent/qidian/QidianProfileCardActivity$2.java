package com.tencent.qidian;

import acff;
import alcn;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

class QidianProfileCardActivity$2
  implements Runnable
{
  QidianProfileCardActivity$2(QidianProfileCardActivity paramQidianProfileCardActivity, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.c.e(this.val$uin);
    String str1 = "";
    Object localObject1 = str1;
    if (localObject2 != null)
    {
      localObject1 = str1;
      if (((Friends)localObject2).remark != null)
      {
        str1 = ((Friends)localObject2).remark;
        localObject1 = str1;
        if (((Friends)localObject2).remark.equals(((Friends)localObject2).name))
        {
          localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppCardHandler;
          localObject2 = this.this$0.app.getCurrentAccountUin();
          String str2 = this.this$0.jdField_a_of_type_Alcn.e.uin;
          long l = ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e, false);
          ((CardHandler)localObject1).a((String)localObject2, str2, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)0);
          localObject1 = str1;
        }
      }
    }
    this.this$0.jdField_a_of_type_Alcn.e.remark = ((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.2
 * JD-Core Version:    0.7.0.1
 */