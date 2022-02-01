package com.tencent.qqmail.activity.vipcontacts;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class VIPContactsFragment$18
  implements View.OnClickListener
{
  VIPContactsFragment$18(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      VIPContactsOtherFragment localVIPContactsOtherFragment = new VIPContactsOtherFragment();
      this.this$0.startFragmentForResult(localVIPContactsOtherFragment, 200);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "VIPContactsFragment", Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.18
 * JD-Core Version:    0.7.0.1
 */