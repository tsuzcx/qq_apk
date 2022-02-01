import java.io.File;
import java.util.Comparator;

final class aage
  implements Comparator<File>
{
  private int bT(String paramString)
  {
    try
    {
      int i = paramString.lastIndexOf('.');
      if (i == -1) {
        return Integer.parseInt(paramString);
      }
      i = Integer.parseInt(paramString.substring(0, i));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return bT(paramFile1.getName()) - bT(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aage
 * JD-Core Version:    0.7.0.1
 */