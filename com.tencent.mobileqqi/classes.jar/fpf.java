import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.ArrayList;
import java.util.Iterator;

public class fpf
  extends LBSObserver
{
  public fpf(EnterpriseQQManager paramEnterpriseQQManager) {}
  
  protected void a(boolean paramBoolean, byte[] arg2, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean)
    {
      double d1 = Double.valueOf(paramString1).doubleValue();
      double d2 = Double.valueOf(paramString2).doubleValue();
      EnterpriseQQManager.a(this.a, d1);
      EnterpriseQQManager.b(this.a, d2);
      EnterpriseQQManager.a(this.a, System.currentTimeMillis());
      synchronized (EnterpriseQQManager.a())
      {
        if ((EnterpriseQQManager.a(this.a) == null) || (EnterpriseQQManager.a(this.a).size() <= 0)) {
          break label173;
        }
        paramString1 = EnterpriseQQManager.a(this.a).iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (fpg)paramString1.next();
          if (paramString2 != null) {
            this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), paramString2.a, paramString2.b, true, d1, d2);
          }
        }
      }
      EnterpriseQQManager.a(this.a).clear();
    }
    label173:
    label338:
    for (;;)
    {
      if (EnterpriseQQManager.a(this.a) != null) {
        EnterpriseQQManager.a(this.a).c(this.a.a);
      }
      EnterpriseQQManager.a(this.a, null);
      EnterpriseQQManager.a(this.a, null);
      return;
      synchronized (EnterpriseQQManager.a())
      {
        if ((EnterpriseQQManager.a(this.a) == null) || (EnterpriseQQManager.a(this.a).size() <= 0)) {
          break label338;
        }
        paramString1 = EnterpriseQQManager.a(this.a).iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (fpg)paramString1.next();
          if (paramString2 != null) {
            this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), paramString2.a, paramString2.b, false, 0.0D, 0.0D);
          }
        }
      }
      EnterpriseQQManager.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fpf
 * JD-Core Version:    0.7.0.1
 */