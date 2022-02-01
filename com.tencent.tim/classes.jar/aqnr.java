import java.util.Comparator;

public final class aqnr
  implements Comparator<String>
{
  public int compare(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      if (paramString1.length() <= paramString2.length()) {}
    }
    while (paramString1 != null)
    {
      return -1;
      if (paramString1.length() >= paramString2.length()) {
        break;
      }
      return 1;
    }
    if (paramString2 != null) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnr
 * JD-Core Version:    0.7.0.1
 */