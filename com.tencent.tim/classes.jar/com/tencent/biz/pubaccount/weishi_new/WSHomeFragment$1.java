package com.tencent.biz.pubaccount.weishi_new;

import acfp;
import android.widget.TextView;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;

class WSHomeFragment$1
  implements Runnable
{
  WSHomeFragment$1(WSHomeFragment paramWSHomeFragment) {}
  
  public void run()
  {
    String str = acfp.m(2131708400) + TaskMonitorManager.g().getMemeryUsage() + "%";
    if (WSHomeFragment.a(this.this$0) != null) {
      WSHomeFragment.a(this.this$0).setText(str);
    }
    this.this$0.startRefreshMonitorUi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.1
 * JD-Core Version:    0.7.0.1
 */