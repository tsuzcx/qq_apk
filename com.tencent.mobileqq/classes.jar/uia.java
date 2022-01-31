import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class uia
  implements INetEventHandler
{
  private uia(uhx paramuhx) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    wsv.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uia
 * JD-Core Version:    0.7.0.1
 */