import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class wfv
  implements INetEventHandler
{
  private wfv(wfs paramwfs) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    yqp.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfv
 * JD-Core Version:    0.7.0.1
 */