import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class amjn
  implements Comparator<amow>
{
  amjn(amjm paramamjm) {}
  
  public int a(amow paramamow1, amow paramamow2)
  {
    int i = paramamow2.nd[2] - paramamow1.nd[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramamow1.nd[0] - paramamow2.nd[0];
      i = j;
    } while (j != 0);
    paramamow1 = paramamow1.name.substring(paramamow1.nd[0] + paramamow1.nd[1]);
    paramamow2 = paramamow2.name.substring(paramamow2.nd[0] + paramamow2.nd[1]);
    return ChnToSpell.aJ(paramamow1, 2).compareTo(ChnToSpell.aJ(paramamow2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjn
 * JD-Core Version:    0.7.0.1
 */