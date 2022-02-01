package com.tencent.mobileqq.activity.selectmember;

import com.tencent.qphone.base.util.QLog;

class TroopMemberListInnerFrame$4
  implements Runnable
{
  TroopMemberListInnerFrame$4(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "read troop members from database before updating data from server");
    }
    TroopMemberListInnerFrame.a(this.this$0, this.this$0.mTroopUin, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.4
 * JD-Core Version:    0.7.0.1
 */