import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.BeautyToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ixv
  implements SeekBar.OnSeekBarChangeListener
{
  public ixv(BeautyToolbar paramBeautyToolbar) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.a.mBeautyValue != paramInt)
    {
      this.a.updateTip(paramInt);
      if ((paramInt != 0) || (this.a.mBeautyValue <= 0)) {
        break label125;
      }
      this.a.mSeek.setThumb(this.a.mThumb_0);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.a.mSeek.setContentDescription(paramInt + "%");
      }
      this.a.mBeautyValue = paramInt;
      this.a.mApp.c("BEAUTY_SKIN", this.a.mBeautyValue, false);
      EffectSettingUi.a(this.a.mApp, -1003L);
      return;
      label125:
      if ((paramInt > 0) && (paramInt <= 30) && ((this.a.mBeautyValue <= 0) || (this.a.mBeautyValue > 30))) {
        this.a.mSeek.setThumb(this.a.mThumb_30);
      } else if ((paramInt > 30) && (paramInt <= 60) && ((this.a.mBeautyValue <= 30) || (this.a.mBeautyValue > 60))) {
        this.a.mSeek.setThumb(this.a.mThumb_60);
      } else if ((paramInt > 60) && (paramInt <= 100) && ((this.a.mBeautyValue <= 60) || (this.a.mBeautyValue > 100))) {
        this.a.mSeek.setThumb(this.a.mThumb_100);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    EffectSettingUi.a(this.a.mApp, -1004L);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.mApp.c("BEAUTY_SKIN", this.a.mBeautyValue, true);
    EffectSettingUi.a(this.a.mApp, -1005L);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixv
 * JD-Core Version:    0.7.0.1
 */