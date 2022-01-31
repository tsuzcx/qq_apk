import com.tencent.mobileqq.search.ISearchable;
import java.util.Comparator;

public final class eeg
  implements Comparator
{
  public int a(ISearchable paramISearchable1, ISearchable paramISearchable2)
  {
    long l1 = paramISearchable1.d();
    long l2 = paramISearchable2.d();
    if (l1 < l2) {
      return 1;
    }
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eeg
 * JD-Core Version:    0.7.0.1
 */