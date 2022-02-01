import android.util.SparseIntArray;
import java.util.Comparator;

final class ygo
  implements Comparator<ygk>
{
  public int a(ygk paramygk1, ygk paramygk2)
  {
    if ((paramygk1 == null) || (paramygk2 == null)) {
      return 0;
    }
    float f1 = ygn.c().get(paramygk1.wJ());
    float f2 = ygn.c().get(paramygk2.wJ());
    float f3 = paramygk1.wI() * 100;
    float f4 = 1.0F / (paramygk1.wH() + 1) / 10.0F;
    return Float.compare(f2 + (paramygk2.wI() * 100 + 1.0F / (paramygk2.wH() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygo
 * JD-Core Version:    0.7.0.1
 */