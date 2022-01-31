import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.IQQServiceCallback.Stub;
import com.tencent.av.service.RecvMsg;

public class bha
  extends IQQServiceCallback.Stub
{
  public bha(VideoAppInterface paramVideoAppInterface) {}
  
  public void a(RecvMsg paramRecvMsg)
  {
    if (paramRecvMsg != null) {
      this.a.a(new Object[] { Integer.valueOf(12), paramRecvMsg });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bha
 * JD-Core Version:    0.7.0.1
 */