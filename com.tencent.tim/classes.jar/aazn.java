import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aazn
  implements SeekBar.OnSeekBarChangeListener
{
  public aazn(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onProgressChanged: progress = " + paramInt + ",fromUser=" + paramBoolean);
    }
    this.this$0.bBB = true;
    if (paramBoolean)
    {
      paramSeekBar = this.this$0;
      paramSeekBar.cmV += 1;
      ShortVideoPlayActivity.a(this.this$0, true);
      ShortVideoPlayActivity.b(this.this$0, true);
    }
    this.this$0.gJ(paramInt * this.this$0.mDuration / 10000L);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.this$0.mSeekBar.getProgress();
    ShortVideoPlayActivity.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStartTrackingTouch: progress = " + i);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.this$0.showAnimation();
    ShortVideoPlayActivity localShortVideoPlayActivity = this.this$0;
    localShortVideoPlayActivity.ceJ += 1;
    this.this$0.bsT = true;
    int i = this.this$0.mSeekBar.getProgress();
    int j = (int)(i * this.this$0.mDuration / 10000L);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStopTrackingTouch: seekProgress = " + i + ", mCacheProgress= " + ShortVideoPlayActivity.b(this.this$0) + ", timestamp = " + j);
    }
    if (this.this$0.fa != null)
    {
      if (this.this$0.mPlayState == 2) {
        this.this$0.resume();
      }
      if (i == 10000) {
        break label177;
      }
      this.this$0.play(j);
    }
    for (;;)
    {
      ShortVideoPlayActivity.a(this.this$0, false);
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      label177:
      this.this$0.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazn
 * JD-Core Version:    0.7.0.1
 */