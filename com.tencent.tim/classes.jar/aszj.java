import com.tencent.qqprotect.qsec.IQSecRuntime;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class aszj
  implements IQSecRuntime
{
  public static IQSecRuntime a;
  private HashMap<String, IRuntimeInterface> qb = new HashMap();
  
  public aszj()
  {
    a = this;
  }
  
  public void a(IRuntimeInterface paramIRuntimeInterface)
  {
    String str = paramIRuntimeInterface.getInterfaceName();
    if ((str != null) && (!this.qb.containsKey(str))) {
      this.qb.put(str, paramIRuntimeInterface);
    }
  }
  
  public Object getApplicationContext()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public Object getQQAppInterface()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public int getRuntimeVersion()
  {
    return 1;
  }
  
  public IRuntimeInterface queryRuntimeInterface(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    IRuntimeInterface localIRuntimeInterface2 = (IRuntimeInterface)this.qb.get(paramString);
    IRuntimeInterface localIRuntimeInterface1 = localIRuntimeInterface2;
    if (localIRuntimeInterface2 != null)
    {
      localIRuntimeInterface1 = localIRuntimeInterface2;
      if (!paramString.equals(localIRuntimeInterface2.getInterfaceName())) {
        localIRuntimeInterface1 = null;
      }
    }
    return localIRuntimeInterface1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszj
 * JD-Core Version:    0.7.0.1
 */