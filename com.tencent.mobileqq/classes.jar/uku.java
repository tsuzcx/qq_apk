import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class uku
  implements CompoundButton.OnCheckedChangeListener
{
  uku(ukt paramukt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ukt.a(this.a);
      if (ukt.a(this.a)) {
        wxj.a("video_shoot_slides", "clk_setting_on", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      ukt.a(this.a, paramBoolean);
      return;
      ukt.b(this.a);
      if (ukt.a(this.a)) {
        wxj.a("video_shoot_slides", "clk_setting_close", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uku
 * JD-Core Version:    0.7.0.1
 */