import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import mqq.os.MqqHandler;

public class apcc
  implements ThreadExcutor.IThreadListener
{
  apcc(apca paramapca, TroopFileTransferManager paramTroopFileTransferManager, apbr paramapbr) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ThreadManager.getUIHandler().post(new TroopFileItemOperation.10.1(this));
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apcc
 * JD-Core Version:    0.7.0.1
 */