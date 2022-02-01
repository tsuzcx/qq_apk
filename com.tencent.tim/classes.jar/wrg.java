import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.a;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.b;

public class wrg
  implements ColorPicker.b
{
  public wrg(DoodlePanel paramDoodlePanel) {}
  
  public void b(ColorPicker.a parama)
  {
    this.b.a(parama);
    parama = "" + parama.mType + ";" + parama.mID + ";" + parama.mValue;
    aqfe.J(this.b.getContext(), "aio_doodle_colorpicker_select", parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrg
 * JD-Core Version:    0.7.0.1
 */