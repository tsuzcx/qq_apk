package com.tencent.qqmail.utilities.audio;

import android.media.MediaPlayer;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqmail.utilities.dateextension.DateExtension;

class QMAudioPlayBar$3
  implements SeekBar.OnSeekBarChangeListener
{
  QMAudioPlayBar$3(QMAudioPlayBar paramQMAudioPlayBar) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    try
    {
      if (QMAudioPlayBar.access$000(this.this$0) != null)
      {
        QMAudioPlayBar.access$400(this.this$0).setText(DateExtension.getTimeMinuteSecondString(paramInt * 1000));
        if (paramBoolean) {
          QMAudioPlayBar.access$000(this.this$0).seekTo(paramInt * 1000);
        }
        if (QMAudioPlayBar.access$000(this.this$0).isPlaying()) {
          QMAudioPlayBar.access$000(this.this$0).start();
        }
      }
      return;
    }
    catch (Exception paramSeekBar) {}
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioPlayBar.3
 * JD-Core Version:    0.7.0.1
 */