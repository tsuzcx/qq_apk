package com.tencent.mobileqq.search.fragment;

import amrk;
import amwd;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;

class GroupSearchFragment$2
  implements Runnable
{
  GroupSearchFragment$2(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void run()
  {
    if (!this.this$0.cDy)
    {
      this.this$0.a.init();
      this.this$0.cDy = true;
    }
    if (!GroupSearchFragment.a(this.this$0))
    {
      amrk localamrk = (amrk)this.this$0.d.getManager(318);
      if (localamrk != null) {
        localamrk.init();
      }
      GroupSearchFragment.a(this.this$0, true);
    }
    this.this$0.mHandler.removeMessages(100);
    this.this$0.mHandler.sendEmptyMessage(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */