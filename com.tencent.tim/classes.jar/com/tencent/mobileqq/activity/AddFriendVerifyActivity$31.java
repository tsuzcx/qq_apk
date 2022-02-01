package com.tencent.mobileqq.activity;

import anot;
import com.tencent.mobileqq.app.QQAppInterface;

class AddFriendVerifyActivity$31
  implements Runnable
{
  AddFriendVerifyActivity$31(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3) {}
  
  public void run()
  {
    String str1;
    QQAppInterface localQQAppInterface;
    String str3;
    if ((this.val$sourceId == 3004) && ((this.bDH == 5) || (this.bDH == 6) || (this.bDH == 7) || (this.bDH == 8)))
    {
      if (!this.aRm) {
        break label102;
      }
      str1 = "multiMode_send";
      localQQAppInterface = this.this$0.app;
      str3 = this.Uf;
      if (!this.aRm) {
        break label108;
      }
    }
    label102:
    label108:
    for (String str2 = "1";; str2 = String.valueOf(this.bDI))
    {
      anot.a(localQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str1, 0, 0, str3, str2, "", "");
      return;
      str1 = "singleMode_send";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.31
 * JD-Core Version:    0.7.0.1
 */