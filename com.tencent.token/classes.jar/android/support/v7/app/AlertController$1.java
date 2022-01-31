package android.support.v7.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class AlertController$1
  implements View.OnClickListener
{
  AlertController$1(AlertController paramAlertController) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == this.this$0.mButtonPositive) && (this.this$0.mButtonPositiveMessage != null)) {
      paramView = Message.obtain(this.this$0.mButtonPositiveMessage);
    }
    for (;;)
    {
      if (paramView != null) {
        paramView.sendToTarget();
      }
      this.this$0.mHandler.obtainMessage(1, this.this$0.mDialog).sendToTarget();
      return;
      if ((paramView == this.this$0.mButtonNegative) && (this.this$0.mButtonNegativeMessage != null)) {
        paramView = Message.obtain(this.this$0.mButtonNegativeMessage);
      } else if ((paramView == this.this$0.mButtonNeutral) && (this.this$0.mButtonNeutralMessage != null)) {
        paramView = Message.obtain(this.this$0.mButtonNeutralMessage);
      } else {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.1
 * JD-Core Version:    0.7.0.1
 */