package com.tencent.av.random;

import android.content.Context;
import android.os.Handler;
import anot;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import irh;

public class RandomController$5
  implements Runnable
{
  RandomController$5(RandomController paramRandomController) {}
  
  private void showDialog()
  {
    if (!this.this$0.Us)
    {
      Context localContext = RandomController.a(this.this$0).getApp().getApplicationContext();
      PopupDialog.b(localContext, 230, localContext.getString(2131697954), localContext.getString(2131697955), 0, 2131697810, new irh(this), null);
      this.this$0.Us = true;
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "mRandomKickTimeoutRunnable trigger, request room owner!");
    }
    RandomController.a(this.this$0).apL();
    showDialog();
    anot.a(null, "CliOper", "", "", "0X8007430", "0X8007430", 0, 0, "", "", "", "");
    RandomController.a(this.this$0).getHandler().removeCallbacks(RandomController.a(this.this$0));
    RandomController.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController.5
 * JD-Core Version:    0.7.0.1
 */