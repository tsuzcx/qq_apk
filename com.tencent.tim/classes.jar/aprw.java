import android.text.Spanned;
import java.util.Comparator;

final class aprw
  implements Comparator<Object>
{
  aprw(Spanned paramSpanned) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.c.getSpanStart(paramObject1) - this.c.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprw
 * JD-Core Version:    0.7.0.1
 */