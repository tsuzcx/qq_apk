import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.GetStaticProxy;
import mqq.app.AppRuntime;

public final class anni
  implements IMCoreProxyRoute.GetStaticProxy<AppRuntime>
{
  public AppRuntime e()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anni
 * JD-Core Version:    0.7.0.1
 */