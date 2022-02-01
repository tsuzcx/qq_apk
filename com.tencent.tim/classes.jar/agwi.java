import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agwi
  implements SeekBar.OnSeekBarChangeListener
{
  agwi(agwh paramagwh) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.this$0.a != null))
    {
      this.this$0.a.Os(paramInt);
      this.this$0.OB(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    agwh.a(this.this$0, false);
    if ((this.this$0.a != null) && (!this.this$0.a.mD(agwh.a(this.this$0)))) {
      this.this$0.a.djo();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    agwh.a(this.this$0, true);
    if (this.this$0.a != null) {
      this.this$0.a.resume();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwi
 * JD-Core Version:    0.7.0.1
 */