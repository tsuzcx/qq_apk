import java.util.Comparator;

final class ajon
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajon
 * JD-Core Version:    0.7.0.1
 */