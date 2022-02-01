package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import wtn;

public class AIOJubaoDialogHelper$3
  implements Runnable
{
  public AIOJubaoDialogHelper$3(wtn paramwtn) {}
  
  public void run()
  {
    if ((this.this$0.ac != null) && (this.this$0.ac.isShowing())) {
      this.this$0.ac.dismiss();
    }
    while ((this.this$0.ad == null) || (!this.this$0.ad.isShowing())) {
      return;
    }
    this.this$0.ad.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper.3
 * JD-Core Version:    0.7.0.1
 */