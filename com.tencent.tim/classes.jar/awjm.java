import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.troop.TroopPluginManager;
import cooperation.troop.TroopPluginManager.a;

public class awjm
  extends Handler
{
  public awjm(TroopPluginManager paramTroopPluginManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ((TroopPluginManager.a)paramMessage.obj).onInstallFinish(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjm
 * JD-Core Version:    0.7.0.1
 */