import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Comparator;

class aehd
  implements Comparator<Rect>
{
  aehd(aehc.b paramb) {}
  
  public int a(Rect paramRect1, Rect paramRect2)
  {
    if (this.a.fails.contains(paramRect1)) {}
    do
    {
      do
      {
        return 1;
        if (this.a.fails.contains(paramRect2)) {
          return -1;
        }
        if (paramRect1.height() * paramRect1.width() > paramRect2.height() * paramRect2.width()) {
          return -1;
        }
      } while (paramRect1.height() * paramRect1.width() < paramRect2.height() * paramRect2.width());
      if (paramRect1.width() > paramRect2.width()) {
        return -1;
      }
    } while (paramRect1.width() < paramRect2.width());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aehd
 * JD-Core Version:    0.7.0.1
 */