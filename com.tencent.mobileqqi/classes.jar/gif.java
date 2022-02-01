import com.tencent.mobileqq.search.ISearchable;
import java.util.Comparator;

public final class gif
  implements Comparator
{
  public int a(ISearchable paramISearchable1, ISearchable paramISearchable2)
  {
    long l1 = paramISearchable1.a();
    long l2 = paramISearchable2.a();
    if (l1 < l2) {
      return 1;
    }
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gif
 * JD-Core Version:    0.7.0.1
 */