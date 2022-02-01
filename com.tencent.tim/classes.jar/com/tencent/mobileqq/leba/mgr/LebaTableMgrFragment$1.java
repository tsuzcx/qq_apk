package com.tencent.mobileqq.leba.mgr;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import zjp;

class LebaTableMgrFragment$1
  implements Runnable
{
  LebaTableMgrFragment$1(LebaTableMgrFragment paramLebaTableMgrFragment, List paramList1, List paramList2, int paramInt) {}
  
  public void run()
  {
    if (LebaTableMgrFragment.a(this.this$0) != null)
    {
      LebaTableMgrFragment.a(this.this$0).a(this.this$0.getActivity(), this.val$list, this.uw, this.ddS, LebaTableMgrFragment.a(this.this$0));
      return;
    }
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "mDataLogic == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.LebaTableMgrFragment.1
 * JD-Core Version:    0.7.0.1
 */