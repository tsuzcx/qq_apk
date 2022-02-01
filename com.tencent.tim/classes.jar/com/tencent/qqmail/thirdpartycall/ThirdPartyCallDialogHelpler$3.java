package com.tencent.qqmail.thirdpartycall;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.protocol.DataCollector;

final class ThirdPartyCallDialogHelpler$3
  implements DialogInterface.OnCancelListener
{
  ThirdPartyCallDialogHelpler$3(boolean paramBoolean, QMBaseFragment paramQMBaseFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.val$isAbandon)
    {
      DataCollector.logEvent("Event_Local_File_Cancel");
      ThirdPartyCallDialogHelpler.access$500().recycle();
      ThirdPartyCallDialogHelpler.access$000().setVisibility(8);
      ThirdPartyCallDialogHelpler.access$200(this.val$fragment, 0);
      return;
    }
    ThirdPartyCallDialogHelpler.access$100(ThirdPartyCallDialogHelpler.access$000(), this.val$fragment);
    ThirdPartyCallDialogHelpler.access$400(this.val$fragment, ThirdPartyCallDialogHelpler.access$000(), true, null, new ThirdPartyCallDialogHelpler.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.3
 * JD-Core Version:    0.7.0.1
 */