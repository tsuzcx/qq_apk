import com.tencent.util.DumpMemInfoHandler;
import java.util.Comparator;
import java.util.Map.Entry;

public class fiz
  implements Comparator
{
  public fiz(DumpMemInfoHandler paramDumpMemInfoHandler) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = ((Integer)((Map.Entry)paramObject1).getValue()).intValue();
    int j = ((Integer)((Map.Entry)paramObject2).getValue()).intValue();
    if (i == j) {
      return 0;
    }
    if (i < j) {
      return 2;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fiz
 * JD-Core Version:    0.7.0.1
 */