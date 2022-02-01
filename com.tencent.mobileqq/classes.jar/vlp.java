import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class vlp
  implements INetEventHandler
{
  private vlp(vlm paramvlm) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    xvv.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlp
 * JD-Core Version:    0.7.0.1
 */