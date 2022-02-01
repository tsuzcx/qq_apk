package moai.patch.natives;

import android.util.Pair;
import java.util.Comparator;

final class CpuArch$1
  implements Comparator<Pair<String, String>>
{
  public int compare(Pair<String, String> paramPair1, Pair<String, String> paramPair2)
  {
    if (((String)paramPair1.first).equals(paramPair2.first)) {
      return 0;
    }
    CpuArch.ArchWithPriority[] arrayOfArchWithPriority = CpuArch.ArchWithPriority.values();
    int m = arrayOfArchWithPriority.length;
    int k = 0;
    int j = -1;
    int i = -1;
    if (k < m)
    {
      CpuArch.ArchWithPriority localArchWithPriority = arrayOfArchWithPriority[k];
      if (localArchWithPriority.name.equals(paramPair1.first)) {
        j = localArchWithPriority.priority;
      }
      if (localArchWithPriority.name.equals(paramPair2.first)) {
        i = localArchWithPriority.priority;
      }
      if ((j == -1) || (i == -1)) {}
    }
    for (;;)
    {
      return i - j;
      k += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.natives.CpuArch.1
 * JD-Core Version:    0.7.0.1
 */