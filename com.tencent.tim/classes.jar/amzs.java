import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class amzs
  extends amzt
{
  PeakAppInterface b;
  
  public amzs(PeakAppInterface paramPeakAppInterface)
  {
    this.b = paramPeakAppInterface;
  }
  
  protected void aTq()
  {
    try
    {
      super.aTq();
      a(new axbl(this.b));
      super.dOJ();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void g(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg, null, andz.class);
  }
  
  public AppInterface getAppInterface()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzs
 * JD-Core Version:    0.7.0.1
 */