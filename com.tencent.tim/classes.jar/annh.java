import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadRegulator.Proxy;

public final class annh
  implements IMCoreProxyRoute.ThreadRegulator.Proxy
{
  public void checkInNextBusiness()
  {
    ThreadRegulator.a().checkInNextBusiness();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annh
 * JD-Core Version:    0.7.0.1
 */