import java.util.Comparator;

final class abea
  implements Comparator<String>
{
  public int compare(String paramString1, String paramString2)
  {
    if ("★".equals(paramString2)) {}
    do
    {
      return 1;
      if ("★".equals(paramString1)) {
        return -1;
      }
      if ("#".equals(paramString2)) {
        return -1;
      }
    } while ("#".equals(paramString1));
    return paramString1.compareTo(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abea
 * JD-Core Version:    0.7.0.1
 */