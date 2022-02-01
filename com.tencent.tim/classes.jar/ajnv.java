import java.util.Comparator;

final class ajnv
  implements Comparator<String>
{
  public int compare(String paramString1, String paramString2)
  {
    if (paramString1.length() > paramString2.length()) {
      return -1;
    }
    if (paramString1.length() < paramString2.length()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnv
 * JD-Core Version:    0.7.0.1
 */