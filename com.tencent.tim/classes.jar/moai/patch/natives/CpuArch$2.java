package moai.patch.natives;

import java.util.Comparator;

final class CpuArch$2
  implements Comparator<String>
{
  public int compare(String paramString1, String paramString2)
  {
    if (paramString1.equals(paramString2)) {
      return 0;
    }
    CpuArch.ArchWithPriority[] arrayOfArchWithPriority = CpuArch.ArchWithPriority.values();
    int m = arrayOfArchWithPriority.length;
    int k = 0;
    int i = -1;
    int j = -1;
    if (k < m)
    {
      CpuArch.ArchWithPriority localArchWithPriority = arrayOfArchWithPriority[k];
      if (localArchWithPriority.name.equals(paramString1.toLowerCase())) {
        j = localArchWithPriority.priority;
      }
      if (localArchWithPriority.name.equals(paramString2.toLowerCase())) {
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
 * Qualified Name:     moai.patch.natives.CpuArch.2
 * JD-Core Version:    0.7.0.1
 */