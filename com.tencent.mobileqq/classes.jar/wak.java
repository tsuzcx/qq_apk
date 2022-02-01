import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class wak
  implements INetEventHandler
{
  private wak(wah paramwah) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    ykq.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wak
 * JD-Core Version:    0.7.0.1
 */