import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class eog
  extends Handler
{
  public eog(TroopFeedsDataManager paramTroopFeedsDataManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.a = ((List)paramMessage.obj);
      this.a.b();
      return;
      this.a.a = ((List)paramMessage.obj);
      TroopFeedsDataManager.a(this.a);
      this.a.notifyObservers(Integer.valueOf(101));
    } while (!QLog.isColorLevel());
    QLog.d("TroopFeedsDataManager", 2, "end load feed: " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eog
 * JD-Core Version:    0.7.0.1
 */