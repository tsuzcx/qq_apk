import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import java.util.Comparator;

public class faa
  implements Comparator
{
  public faa(ConditionSearchManager paramConditionSearchManager) {}
  
  public int a(BaseAddress paramBaseAddress1, BaseAddress paramBaseAddress2)
  {
    int j = paramBaseAddress1.d.compareTo(paramBaseAddress2.d);
    int i = j;
    if (j == 0) {
      i = paramBaseAddress1.c.compareTo(paramBaseAddress2.c);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     faa
 * JD-Core Version:    0.7.0.1
 */