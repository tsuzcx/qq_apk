import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Random;

public class mwo
  extends amzq
{
  VideoFeedsAppInterface a;
  Random random = new Random();
  
  public mwo(VideoFeedsAppInterface paramVideoFeedsAppInterface)
  {
    this.a = paramVideoFeedsAppInterface;
    seq = Math.abs(this.random.nextInt());
  }
  
  protected void aTq()
  {
    try
    {
      super.aTq();
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
    super.a(paramToServiceMsg, null, mwp.class);
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwo
 * JD-Core Version:    0.7.0.1
 */