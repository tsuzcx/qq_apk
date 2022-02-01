package com.tencent.qqmail.thirdpartycall;

import android.view.View;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.common.CommUtils.Callback;

final class ThirdPartyCallDialogHelpler$8
  implements CommUtils.Callback
{
  ThirdPartyCallDialogHelpler$8(QMBaseFragment paramQMBaseFragment) {}
  
  public void call()
  {
    DataCollector.logEvent("Event_Local_File_Bottom_Cancel");
    ThirdPartyCallDialogHelpler.access$500().recycle();
    ThirdPartyCallDialogHelpler.access$000().setVisibility(8);
    ThirdPartyCallDialogHelpler.access$200(this.val$fragment, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.8
 * JD-Core Version:    0.7.0.1
 */