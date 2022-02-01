import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aubo
  implements SeekBar.OnSeekBarChangeListener
{
  aubo(aubn paramaubn) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$0.a.Os(paramInt);
      this.this$0.OB(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((this.this$0.a != null) && (!this.this$0.a.mD(aubn.a(this.this$0)))) {
      this.this$0.a.djo();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.this$0.a.resume();
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubo
 * JD-Core Version:    0.7.0.1
 */