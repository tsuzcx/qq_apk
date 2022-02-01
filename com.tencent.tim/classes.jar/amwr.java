import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class amwr
  implements Comparator<amqy>
{
  public int a(amqy paramamqy1, amqy paramamqy2)
  {
    int j = Long.signum(paramamqy2.gN() - paramamqy1.gN());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.b(paramamqy1, paramamqy2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwr
 * JD-Core Version:    0.7.0.1
 */