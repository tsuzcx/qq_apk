import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class umj
  implements INetEventHandler
{
  private umj(umg paramumg) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    wxe.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umj
 * JD-Core Version:    0.7.0.1
 */