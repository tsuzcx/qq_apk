import android.annotation.TargetApi;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agxf
  implements SeekBar.OnSeekBarChangeListener
{
  agxf(agxa paramagxa) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (agxa.a(this.this$0) != null))
    {
      agxa.a(this.this$0, agxa.b(this.this$0, paramInt));
      this.this$0.a.setCurrentTime(agxa.a(this.this$0));
      if (QLog.isDevelopLevel()) {
        QLog.d("#@#@", 1, "onProgressChanged userPos[" + agxa.a(this.this$0) + "]");
      }
      this.this$0.a.JU(false);
    }
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((agxa.a(this.this$0) == null) || (!agxa.a(this.this$0).isPlaying()))
    {
      this.this$0.cfF = false;
      return;
    }
    agxa.d(this.this$0);
    agxa.a(this.this$0).removeCallbacks(this.this$0.eu);
    this.this$0.cfF = agxa.a(this.this$0).isPlaying();
    agxa.a(this.this$0).pause();
    this.this$0.a.U(null);
    agxa.a(this.this$0, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (agxa.a(this.this$0) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      agxa.a(this.this$0, agxa.b(this.this$0, paramSeekBar.getProgress()));
      if (QLog.isDevelopLevel()) {
        QLog.d("##########", 1, "mMediaPlayer sekTo [" + agxa.a(this.this$0) + "]");
      }
      agxa.a(this.this$0).seekTo(agxa.a(this.this$0));
      if (this.this$0.cfF)
      {
        agxa.a(this.this$0).post(this.this$0.eu);
        this.this$0.a.JU(true);
        agxa.a(this.this$0).play();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxf
 * JD-Core Version:    0.7.0.1
 */