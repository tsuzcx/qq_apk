import java.io.File;
import java.util.Comparator;

public final class xhp
  implements Comparator
{
  private int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString.substring(0, paramString.lastIndexOf('.')));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public int a(File paramFile1, File paramFile2)
  {
    return a(paramFile1.getName()) - a(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xhp
 * JD-Core Version:    0.7.0.1
 */