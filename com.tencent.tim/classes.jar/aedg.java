import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import java.util.Comparator;

public class aedg
  implements Comparator<ColorNote>
{
  public aedg(ColorNoteSettingFragment paramColorNoteSettingFragment) {}
  
  public int b(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    return -(int)(paramColorNote1.getTime() - paramColorNote2.getTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedg
 * JD-Core Version:    0.7.0.1
 */