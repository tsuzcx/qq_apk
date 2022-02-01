package com.tencent.qqmini.sdk.widget;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniCustomDialog$7
  implements View.OnClickListener
{
  MiniCustomDialog$7(MiniCustomDialog paramMiniCustomDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.val$pl != null) {
      this.val$pl.onClick(this.this$0, 0);
    }
    try
    {
      if (this.this$0.isShowing()) {
        this.this$0.dismiss();
      }
      label38:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog.7
 * JD-Core Version:    0.7.0.1
 */