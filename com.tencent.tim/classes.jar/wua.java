import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wua
  implements CompoundButton.OnCheckedChangeListener
{
  public wua(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AIOLongShotHelper.a(this.this$0, paramCompoundButton, paramBoolean);
    AIOLongShotHelper.report("0X8009DE8");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wua
 * JD-Core Version:    0.7.0.1
 */