package com.tencent.mobileqq.mini.share;

import android.content.Context;
import android.view.Window;
import arhz;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;

final class MiniProgramOpenSdkUtil$1
  implements Runnable
{
  MiniProgramOpenSdkUtil$1(Context paramContext, MiniProgramOpenSdkUtil.TimeOutInfo paramTimeOutInfo) {}
  
  public void run()
  {
    try
    {
      if (((this.val$context instanceof JumpActivity)) && (!((JumpActivity)this.val$context).isFinishing()))
      {
        this.val$outInfo.progressDialog = new arhz(this.val$context, 0, 2131558750, 17);
        this.val$outInfo.progressDialog.setMessage(this.val$context.getString(2131690520));
        this.val$outInfo.progressDialog.getWindow().setDimAmount(0.0F);
        this.val$outInfo.progressDialog.setCanceledOnTouchOutside(true);
        this.val$outInfo.progressDialog.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniProgramOpenSdkUtil", 1, "forwardShare showLoadingRunnable has Exception" + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.1
 * JD-Core Version:    0.7.0.1
 */