import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.troop.TroopPluginManager.InstallRunable;
import cooperation.troop.TroopPluginManager.a;

public class awjn
  extends Handler
{
  public awjn(TroopPluginManager.InstallRunable paramInstallRunable, Looper paramLooper)
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
      do
      {
        return;
      } while (this.a.b == null);
      this.a.b.onInstallFinish(0);
      return;
    } while (this.a.b == null);
    this.a.b.onInstallFinish(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjn
 * JD-Core Version:    0.7.0.1
 */