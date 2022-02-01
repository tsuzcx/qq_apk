package com.tencent.qqmail.thirdpartycall;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmail.fragment.base.QMBaseFragment;

final class ThirdPartyCallDialogHelpler$9
  implements DialogInterface.OnCancelListener
{
  ThirdPartyCallDialogHelpler$9(QMBaseFragment paramQMBaseFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    ThirdPartyCallDialogHelpler.access$100(ThirdPartyCallDialogHelpler.access$000(), this.val$fragment);
    ThirdPartyCallDialogHelpler.access$400(this.val$fragment, ThirdPartyCallDialogHelpler.access$000(), true, null, new ThirdPartyCallDialogHelpler.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.9
 * JD-Core Version:    0.7.0.1
 */