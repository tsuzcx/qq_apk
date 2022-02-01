package cooperation.troop;

import android.os.Handler;
import android.os.Message;
import avfw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;

class TroopPluginManager$1
  implements Runnable
{
  TroopPluginManager$1(TroopPluginManager paramTroopPluginManager, String paramString, TroopPluginManager.a parama) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.n.get();
    if (localObject == null) {
      return;
    }
    if (((avfw)((QQAppInterface)localObject).getManager(27)).isPlugininstalled(this.val$pluginId))
    {
      localObject = this.this$0.mHandler.obtainMessage(1001);
      ((Message)localObject).obj = this.a;
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      return;
    }
    if (this.this$0.V.contains(this.val$pluginId))
    {
      localObject = this.this$0.mHandler.obtainMessage(1001);
      ((Message)localObject).obj = this.a;
      ((Message)localObject).arg1 = 1;
      ((Message)localObject).sendToTarget();
    }
    this.this$0.V.add(this.val$pluginId);
    ThreadManager.post(new TroopPluginManager.InstallRunable(this.this$0, this.a, this.val$pluginId), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.1
 * JD-Core Version:    0.7.0.1
 */