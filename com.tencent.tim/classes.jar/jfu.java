import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.av.ui.beauty.BeautySeekView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jfu
  implements SeekBar.OnSeekBarChangeListener
{
  public jfu(BeautySeekView paramBeautySeekView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (BeautySeekView.a(this.this$0) != paramInt)
    {
      BeautySeekView.a(this.this$0, paramInt);
      if (paramBoolean) {
        BeautySeekView.a(this.this$0).setContentDescription(paramInt + "%");
      }
      BeautySeekView.a(this.this$0, paramInt);
      BeautySeekView.b(this.this$0, BeautySeekView.a(this.this$0));
    }
    if (BeautySeekView.a(this.this$0) != null) {
      BeautySeekView.a(this.this$0).j(BeautySeekView.a(this.this$0), 2, paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    BeautySeekView.a(this.this$0).removeCallbacks(this.this$0.ck);
    BeautySeekView.a(this.this$0).setVisibility(0);
    if (BeautySeekView.a(this.this$0) != null) {
      BeautySeekView.a(this.this$0).j(BeautySeekView.a(this.this$0), 1, BeautySeekView.a(this.this$0));
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BeautySeekView.a(this.this$0).postDelayed(this.this$0.ck, 300L);
    if (BeautySeekView.a(this.this$0) != null) {
      BeautySeekView.a(this.this$0).j(BeautySeekView.a(this.this$0), 3, BeautySeekView.a(this.this$0));
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfu
 * JD-Core Version:    0.7.0.1
 */