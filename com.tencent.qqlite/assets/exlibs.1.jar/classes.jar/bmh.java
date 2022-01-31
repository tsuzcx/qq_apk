import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bmh
  extends Thread
{
  public bmh(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  public void run()
  {
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.a.app.a(17);
      if (localTroopHandler != null)
      {
        long l = Long.parseLong(this.a.b);
        localTroopHandler.a(l, 0L, 5, null, 6, 1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(l));
        localTroopHandler.a(localArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.disband", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bmh
 * JD-Core Version:    0.7.0.1
 */