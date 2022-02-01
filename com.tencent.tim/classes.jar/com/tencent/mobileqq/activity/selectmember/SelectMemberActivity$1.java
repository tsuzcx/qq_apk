package com.tencent.mobileqq.activity.selectmember;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class SelectMemberActivity$1
  implements Runnable
{
  SelectMemberActivity$1(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void run()
  {
    acms localacms = (acms)this.this$0.app.getBusinessHandler(20);
    if (localacms != null) {}
    try
    {
      localacms.l(Long.valueOf(this.this$0.aRJ));
      localacms.k(Long.valueOf(this.this$0.aRJ));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SelectMemberActivity", 2, "NumberFormatException : mGroupCode = " + this.this$0.aRJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.1
 * JD-Core Version:    0.7.0.1
 */