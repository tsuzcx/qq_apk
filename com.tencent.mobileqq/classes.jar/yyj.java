import com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler;
import com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.GameShareResult;
import java.util.Comparator;

public class yyj
  implements Comparator
{
  public yyj(CmGameShareDataHandler paramCmGameShareDataHandler) {}
  
  public int a(CmGameShareDataHandler.GameShareResult paramGameShareResult1, CmGameShareDataHandler.GameShareResult paramGameShareResult2)
  {
    if (paramGameShareResult1.a == paramGameShareResult2.a) {
      return 0;
    }
    if (paramGameShareResult1.a > paramGameShareResult2.a) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yyj
 * JD-Core Version:    0.7.0.1
 */