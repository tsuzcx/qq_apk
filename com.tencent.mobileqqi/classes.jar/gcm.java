import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.model.TroopInfoManager;

public class gcm
  extends Handler
{
  public gcm(TroopInfoManager paramTroopInfoManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TroopInfoManager.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gcm
 * JD-Core Version:    0.7.0.1
 */