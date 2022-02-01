import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wib
  implements CompoundButton.OnCheckedChangeListener
{
  wib(wia paramwia) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wia.a(this.a);
      if (wia.a(this.a)) {
        yup.a("video_shoot_slides", "clk_setting_on", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      wia.a(this.a, paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      wia.b(this.a);
      if (wia.a(this.a)) {
        yup.a("video_shoot_slides", "clk_setting_close", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wib
 * JD-Core Version:    0.7.0.1
 */