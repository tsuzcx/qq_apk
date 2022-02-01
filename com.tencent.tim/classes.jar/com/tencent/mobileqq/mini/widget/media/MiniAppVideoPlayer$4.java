package com.tencent.mobileqq.mini.widget.media;

import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

class MiniAppVideoPlayer$4
  implements SeekBar.OnSeekBarChangeListener
{
  private long position;
  
  MiniAppVideoPlayer$4(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MiniAppVideoPlayer.access$1702(this.this$0, true);
    MiniAppVideoPlayer.access$1800(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.access$1800(this.this$0).setText("");
    MiniAppVideoPlayer.access$1900(this.this$0);
    if ((this.this$0.showCenterPlayBtn) && ("center".equals(this.this$0.playBtnPosition))) {
      MiniAppVideoPlayer.access$2000(this.this$0).setVisibility(8);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */