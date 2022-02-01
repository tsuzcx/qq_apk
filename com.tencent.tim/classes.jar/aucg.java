import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aucg
  implements SeekBar.OnSeekBarChangeListener
{
  aucg(aucd paramaucd) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (aucd.a(this.this$0) != null))
    {
      aucd.a(this.this$0, aucd.b(this.this$0, paramInt));
      this.this$0.a.setCurrentTime(aucd.a(this.this$0));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + aucd.a(this.this$0) + "]");
      }
      this.this$0.a.JU(false);
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((aucd.a(this.this$0) == null) || (!aucd.a(this.this$0).isPlaying()))
    {
      this.this$0.cfF = false;
      return;
    }
    aucd.d(this.this$0);
    aucd.a(this.this$0).removeCallbacks(this.this$0.eu);
    this.this$0.cfF = aucd.a(this.this$0).isPlaying();
    aucd.a(this.this$0).pause();
    this.this$0.a.U(null);
    aucd.a(this.this$0, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (aucd.a(this.this$0) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      aucd.a(this.this$0, aucd.b(this.this$0, paramSeekBar.getProgress()));
      if (QLog.isDevelopLevel()) {
        QLog.d("##########", 1, "mMediaPlayer sekTo [" + aucd.a(this.this$0) + "]");
      }
      aucd.a(this.this$0).seekTo(aucd.a(this.this$0));
      if (this.this$0.cfF)
      {
        aucd.a(this.this$0).post(this.this$0.eu);
        this.this$0.a.JU(true);
        aucd.a(this.this$0).play();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucg
 * JD-Core Version:    0.7.0.1
 */