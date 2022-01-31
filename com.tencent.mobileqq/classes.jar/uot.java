import com.tencent.mobileqq.activity.aio.doodle.DoodleLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker.GifTemplatePickerListener;
import com.tencent.mobileqq.util.SharePreferenceUtils;

public class uot
  implements GifTemplatePicker.GifTemplatePickerListener
{
  public uot(DoodlePanel paramDoodlePanel) {}
  
  public void a(int paramInt)
  {
    if (DoodlePanel.a(this.a) != null)
    {
      if (DoodlePanel.a(this.a) != null) {
        DoodlePanel.a(this.a).setTemplateID(paramInt);
      }
      DoodlePanel.a(this.a);
      SharePreferenceUtils.a(this.a.getContext(), "aio_doodle_template_picker_select", String.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uot
 * JD-Core Version:    0.7.0.1
 */