package com.tencent.qqmail.view.fingerprint;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FingerPrintDialog$1
  implements View.OnClickListener
{
  FingerPrintDialog$1(FingerPrintDialog paramFingerPrintDialog) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.FingerPrintDialog.1
 * JD-Core Version:    0.7.0.1
 */