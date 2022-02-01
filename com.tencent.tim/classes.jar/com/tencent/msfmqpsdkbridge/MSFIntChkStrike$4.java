package com.tencent.msfmqpsdkbridge;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;

class MSFIntChkStrike$4
  implements Runnable
{
  MSFIntChkStrike$4(MSFIntChkStrike paramMSFIntChkStrike, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, String paramString3, String paramString4, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    try
    {
      aqju localaqju = aqha.a(BaseActivity.sTopActivity, 230, this.val$fstrTitle, this.val$fstrWording, this.val$fonConfirm, this.val$fonCancel);
      if (localaqju == null) {
        return;
      }
      localaqju.setNegativeButton(this.val$fstrCancelText, this.val$fonCancel);
      localaqju.setPositiveButton(this.val$fstrConfirmText, this.val$fonConfirm);
      localaqju.setOnDismissListener(this.val$fonDismissListener);
      localaqju.setCancelable(false);
      localaqju.show();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    MSFIntChkStrike.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFIntChkStrike.4
 * JD-Core Version:    0.7.0.1
 */