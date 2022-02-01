import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.Comparator;

class aebp
  implements Comparator<ColorNote>
{
  aebp(aebo paramaebo) {}
  
  public int b(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    int j = 0;
    int k = 1;
    boolean bool1 = aebs.i(paramColorNote1);
    boolean bool2 = aebs.i(paramColorNote2);
    int i;
    if ((bool1) && (bool2)) {
      i = aebo.a(this.this$0, paramColorNote1, paramColorNote2);
    }
    do
    {
      do
      {
        do
        {
          return i;
          if (bool1) {
            return -1;
          }
          i = k;
        } while (bool2);
        bool1 = aebs.h(paramColorNote1);
        bool2 = aebs.h(paramColorNote2);
        if ((bool1) && (bool2)) {
          return aebo.a(this.this$0, paramColorNote1, paramColorNote2);
        }
        if (bool1) {
          return -1;
        }
        i = k;
      } while (bool2);
      if (paramColorNote1.getServiceType() == 16973824) {}
      for (i = 1;; i = 0)
      {
        if (paramColorNote2.getServiceType() == 16973824) {
          j = 1;
        }
        if ((i == 0) || (j == 0)) {
          break;
        }
        return aebo.a(this.this$0, paramColorNote1, paramColorNote2);
      }
      if (i != 0) {
        return -1;
      }
      i = k;
    } while (j != 0);
    return aebo.a(this.this$0, paramColorNote1, paramColorNote2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebp
 * JD-Core Version:    0.7.0.1
 */