import java.util.Comparator;

class akoc
  implements Comparator<String>
{
  akoc(akob paramakob) {}
  
  public int compare(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 0;
    }
    return paramString2.length() - paramString1.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akoc
 * JD-Core Version:    0.7.0.1
 */