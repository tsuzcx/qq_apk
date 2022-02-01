import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class aczq
  extends amzq
{
  BrowserAppInterface a;
  
  public aczq(BrowserAppInterface paramBrowserAppInterface)
  {
    this.a = paramBrowserAppInterface;
  }
  
  public void g(ToServiceMsg paramToServiceMsg)
  {
    super.a(paramToServiceMsg, null, ailu.class);
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczq
 * JD-Core Version:    0.7.0.1
 */