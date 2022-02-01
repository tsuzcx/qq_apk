import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class aviw
  implements ServiceConnection
{
  aviw(aviq paramaviq) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.this$0.dnf = false;
    this.this$0.a = avix.a.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService connected");
    }
    paramComponentName = (ackv)this.this$0.app.getBusinessHandler(10);
    this.this$0.b(paramComponentName.bi(), paramComponentName.AO(), paramComponentName.AP(), paramComponentName.AQ(), paramComponentName.eW());
    aviq.d(this.this$0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.this$0.app.getApplication().unbindService(aviq.a(this.this$0));
    this.this$0.a = null;
    this.this$0.dnf = false;
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService disconnected");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aviw
 * JD-Core Version:    0.7.0.1
 */