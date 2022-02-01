import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nwu
  implements SeekBar.OnSeekBarChangeListener
{
  public nwu(ViolaVideoView paramViolaVideoView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!ViolaVideoView.a(this.this$0).Gl()) {
      return;
    }
    long l = ViolaVideoView.a(this.this$0).getDuration();
    double d = paramInt / 100.0D;
    paramInt = (int)(l * d);
    muj.a(ViolaVideoView.a(this.this$0), paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    ViolaVideoView.a(this.this$0, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (!ViolaVideoView.a(this.this$0).Gl()) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      ViolaVideoView.a(this.this$0, false);
      int i = paramSeekBar.getProgress();
      long l = ViolaVideoView.a(this.this$0).getDuration();
      i = (int)(i / 100.0D * l);
      ViolaVideoView.a(this.this$0).seekTo(i);
      if (ViolaVideoView.a(this.this$0) != null) {
        ViolaVideoView.a(this.this$0).um(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwu
 * JD-Core Version:    0.7.0.1
 */