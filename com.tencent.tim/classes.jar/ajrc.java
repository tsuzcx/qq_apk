import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Random;

public class ajrc
  extends amzq
{
  NearbyAppInterface a;
  Random random = new Random();
  
  public ajrc(NearbyAppInterface paramNearbyAppInterface)
  {
    this.a = paramNearbyAppInterface;
    seq = Math.abs(this.random.nextInt());
  }
  
  protected void aTq()
  {
    try
    {
      super.aTq();
      super.a(new anaw(this.a));
      super.dOJ();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg)
  {
    super.a(paramToServiceMsg, null, ajrd.class);
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrc
 * JD-Core Version:    0.7.0.1
 */