import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class amwh
  implements Comparator<amqc>
{
  public amwh(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(amqc paramamqc1, amqc paramamqc2)
  {
    int i = paramamqc2.nd[2] - paramamqc1.nd[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramamqc1.nd[0] - paramamqc2.nd[0];
      i = j;
    } while (j != 0);
    paramamqc1 = paramamqc1.za().substring(paramamqc1.nd[0] + paramamqc1.nd[1]);
    paramamqc2 = paramamqc2.za().substring(paramamqc2.nd[0] + paramamqc2.nd[1]);
    return ChnToSpell.aJ(paramamqc1, 2).compareTo(ChnToSpell.aJ(paramamqc2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwh
 * JD-Core Version:    0.7.0.1
 */