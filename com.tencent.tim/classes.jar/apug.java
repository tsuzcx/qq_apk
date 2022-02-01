import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class apug
  extends apun
{
  public void a(Class<? extends Thread> paramClass, ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList)
  {
    if ((this.a == null) || (this.a.getState() == Thread.State.TERMINATED) || (this.a.isStopped()))
    {
      this.a = ((TroopUploadingThread)apum.a(paramClass));
      this.a.a(paramArrayList, paramHashMap, paramList, this);
      this.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apug
 * JD-Core Version:    0.7.0.1
 */