import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper.Proxy;

public final class annf
  implements IMCoreProxyRoute.ThreadTraceHelper.Proxy
{
  public void addWaitingTransThread(long paramLong, String paramString)
  {
    anpi.addWaitingTransThread(paramLong, paramString);
  }
  
  public void removeWaitingTransThread(long paramLong)
  {
    anpi.removeWaitingTransThread(paramLong);
  }
  
  public void setCurrentTransThread(long paramLong, String paramString)
  {
    anpi.setCurrentTransThread(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annf
 * JD-Core Version:    0.7.0.1
 */