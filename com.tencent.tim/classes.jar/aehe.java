import android.graphics.Rect;
import java.util.Comparator;

class aehe
  implements Comparator<Rect>
{
  aehe(aehc.b paramb) {}
  
  public int a(Rect paramRect1, Rect paramRect2)
  {
    if (paramRect1.height() * paramRect1.width() > paramRect2.height() * paramRect2.width()) {}
    do
    {
      return 1;
      if (paramRect1.height() * paramRect1.width() < paramRect2.height() * paramRect2.width()) {
        return -1;
      }
    } while (paramRect1.width() > paramRect2.width());
    if (paramRect1.width() < paramRect2.width()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aehe
 * JD-Core Version:    0.7.0.1
 */