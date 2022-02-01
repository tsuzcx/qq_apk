import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avol
  implements RadioGroup.OnCheckedChangeListener
{
  avol(avoj paramavoj) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    avoj.a(this.a, paramInt);
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avol
 * JD-Core Version:    0.7.0.1
 */