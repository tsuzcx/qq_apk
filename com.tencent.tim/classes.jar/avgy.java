import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qappcenter.remote.SendMsg;

class avgy
  implements ServiceConnection
{
  avgy(avgx paramavgx) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceConnected service:" + paramComponentName + ",mActionListener:" + avgx.a(this.this$0));
    }
    this.this$0.a = avgv.a.a(paramIBinder);
    if (avgx.a(this.this$0) != null)
    {
      paramComponentName = new SendMsg("cmd.registerListener");
      paramComponentName.b = avgx.a(this.this$0);
      this.this$0.a(paramComponentName);
    }
    this.this$0.onBaseServiceConnected();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceDisconnected " + paramComponentName + ",mActionListener:" + avgx.a(this.this$0));
    }
    this.this$0.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgy
 * JD-Core Version:    0.7.0.1
 */