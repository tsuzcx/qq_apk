import android.os.Handler;
import cooperation.qzone.music.RemoteMusicManager;
import cooperation.qzone.remote.IActionListener.Stub;
import cooperation.qzone.remote.RecvMsg;

public class icy
  extends IActionListener.Stub
{
  public icy(RemoteMusicManager paramRemoteMusicManager) {}
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
  {
    if (RemoteMusicManager.access$000(this.a) != null) {
      RemoteMusicManager.access$100(this.a).post(new icz(this, paramRecvMsg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     icy
 * JD-Core Version:    0.7.0.1
 */