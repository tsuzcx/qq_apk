import com.tencent.mobileqq.app.DiscussionIconHelper;
import java.util.Comparator;

public class fbo
  implements Comparator
{
  public fbo(DiscussionIconHelper paramDiscussionIconHelper) {}
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (l1 == l2) {
        return 0;
      }
      if (l1 > l2) {
        return 2;
      }
      return -1;
    }
    catch (Exception paramString1) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fbo
 * JD-Core Version:    0.7.0.1
 */