import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class abam
  implements SeekBar.OnSeekBarChangeListener
{
  public abam(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.this$0.p.getProgress();
    if (this.this$0.B != null) {
      this.this$0.B.removeCallbacks(this.this$0.fo);
    }
    this.this$0.pause();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onStartTrackingTouch: progress = " + i);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.this$0.p.getProgress();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onStopTrackingTouch: 当前位置为 = " + i);
    }
    if (this.this$0.a != null)
    {
      if (this.this$0.getPlayState() == 2) {
        this.this$0.resume();
      }
      this.this$0.wQ.setImageResource(2130847021);
      this.this$0.a.start();
      this.this$0.a.seekTo(i);
      this.this$0.B.post(this.this$0.fo);
      this.this$0.OV.setEnabled(false);
      this.this$0.OV.setTextColor(-2130706433);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abam
 * JD-Core Version:    0.7.0.1
 */