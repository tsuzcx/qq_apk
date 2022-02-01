import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class aszl
  implements IRuntimeInterface
{
  private static volatile aszl a;
  
  private aszl()
  {
    QSecFramework.a(3L, new aszm(this));
  }
  
  public static aszl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aszl();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      asxw.cN(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    asxw.gL(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszl
 * JD-Core Version:    0.7.0.1
 */