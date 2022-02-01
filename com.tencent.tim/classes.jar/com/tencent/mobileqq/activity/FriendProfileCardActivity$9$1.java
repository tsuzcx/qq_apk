package com.tencent.mobileqq.activity;

import acff;
import alcn;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$9$1
  implements Runnable
{
  FriendProfileCardActivity$9$1(FriendProfileCardActivity.9 param9) {}
  
  public void run()
  {
    Object localObject = (acff)this.a.this$0.app.getManager(51);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((acff)localObject).e(this.a.this$0.a.e.uin);
    } while ((localObject == null) || ((((Friends)localObject).abilityBits & 0x2) == 0L));
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "mReportPCCameraAblibityRunnable-->report");
    }
    anot.a(null, "CliOper", "", "", "0X8004991", "0X8004991", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.9.1
 * JD-Core Version:    0.7.0.1
 */