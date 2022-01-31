package android.support.v7.app;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AlertController$AlertParams$3
  implements AdapterView.OnItemClickListener
{
  AlertController$AlertParams$3(AlertController.AlertParams paramAlertParams, AlertController paramAlertController) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.this$0.mOnClickListener.onClick(this.val$dialog.mDialog, paramInt);
    if (!this.this$0.mIsSingleChoice) {
      this.val$dialog.mDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.3
 * JD-Core Version:    0.7.0.1
 */