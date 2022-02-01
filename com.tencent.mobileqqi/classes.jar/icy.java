import cooperation.qzone.music.RemoteMusicManager;
import cooperation.qzone.music.RemoteMusicManager.MusicEventListener;
import cooperation.qzone.remote.RecvMsg;
import java.util.ArrayList;
import java.util.Iterator;

class icy
  implements Runnable
{
  icy(icx paramicx, RecvMsg paramRecvMsg) {}
  
  public void run()
  {
    Iterator localIterator = RemoteMusicManager.access$000(this.jdField_a_of_type_Icx.a).iterator();
    while (localIterator.hasNext()) {
      ((RemoteMusicManager.MusicEventListener)localIterator.next()).onMusicEvent(this.jdField_a_of_type_CooperationQzoneRemoteRecvMsg.getServiceCmd(), this.jdField_a_of_type_CooperationQzoneRemoteRecvMsg.extraData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     icy
 * JD-Core Version:    0.7.0.1
 */