package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler;
import com.tencent.qqmail.utilities.common.CommUtils.Callback;

class ComposeMailActivity$34
  implements Runnable
{
  ComposeMailActivity$34(ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    Object localObject;
    do
    {
      return;
      localObject = new ComposeMailActivity.34.1(this);
      ComposeMailActivity.34.2 local2 = new ComposeMailActivity.34.2(this);
      localObject = ThirdPartyCallDialogHelpler.getComfirmDialog(this.this$0, (CommUtils.Callback)localObject, local2);
    } while (localObject == null);
    ((QMUIDialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.34
 * JD-Core Version:    0.7.0.1
 */