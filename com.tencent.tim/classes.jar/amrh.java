import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class amrh
  implements Comparator<amrg.a>
{
  public int a(amrg.a parama1, amrg.a parama2)
  {
    int j = Long.signum(parama2.dDD - parama1.dDD);
    int i = j;
    if (j == 0) {
      i = Long.signum(parama2.a.timeStamp - parama1.a.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrh
 * JD-Core Version:    0.7.0.1
 */