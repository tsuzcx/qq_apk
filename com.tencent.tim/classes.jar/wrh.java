import com.tencent.mobileqq.activity.aio.doodle.DoodleLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker.b;

public class wrh
  implements GifTemplatePicker.b
{
  public wrh(DoodlePanel paramDoodlePanel) {}
  
  public void CI(int paramInt)
  {
    if (DoodlePanel.a(this.b) != null)
    {
      if (DoodlePanel.a(this.b) != null) {
        DoodlePanel.a(this.b).setTemplateID(paramInt);
      }
      DoodlePanel.a(this.b);
      aqfe.J(this.b.getContext(), "aio_doodle_template_picker_select", String.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrh
 * JD-Core Version:    0.7.0.1
 */