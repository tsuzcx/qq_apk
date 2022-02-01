import android.text.Editable;
import java.util.Comparator;

final class apoh
  implements Comparator
{
  apoh(Editable paramEditable) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.f.getSpanStart(paramObject1) - this.f.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoh
 * JD-Core Version:    0.7.0.1
 */