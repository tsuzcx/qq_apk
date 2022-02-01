import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class amws
  implements Comparator<amqy>
{
  public int a(amqy paramamqy1, amqy paramamqy2)
  {
    int j = Long.signum(paramamqy2.gN() - paramamqy1.gN());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramamqy2.gM() - paramamqy1.gM());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.b(paramamqy1, paramamqy2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amws
 * JD-Core Version:    0.7.0.1
 */