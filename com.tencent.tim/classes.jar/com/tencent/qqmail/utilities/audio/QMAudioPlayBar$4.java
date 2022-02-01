package com.tencent.qqmail.utilities.audio;

import android.media.MediaPlayer;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMUIHelper;

class QMAudioPlayBar$4
  implements CompoundButton.OnCheckedChangeListener
{
  QMAudioPlayBar$4(QMAudioPlayBar paramQMAudioPlayBar) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (QMAudioPlayBar.access$000(this.this$0) != null) {
        QMAudioPlayBar.access$000(this.this$0).pause();
      }
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        if (QMAudioPlayBar.access$000(this.this$0) != null) {
          QMAudioPlayBar.access$000(this.this$0).start();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMUIHelper.showToast(QMAudioPlayBar.access$500(this.this$0), 2131690627, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioPlayBar.4
 * JD-Core Version:    0.7.0.1
 */