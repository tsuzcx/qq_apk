import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class ugl
  implements CompoundButton.OnCheckedChangeListener
{
  ugl(ugk paramugk) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ugk.a(this.a);
      if (ugk.a(this.a)) {
        wta.a("video_shoot_slides", "clk_setting_on", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      ugk.a(this.a, paramBoolean);
      return;
      ugk.b(this.a);
      if (ugk.a(this.a)) {
        wta.a("video_shoot_slides", "clk_setting_close", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugl
 * JD-Core Version:    0.7.0.1
 */