import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Messenger;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

class acng
  implements ServiceConnection
{
  acng(acne paramacne) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    acne.a(this.this$0, 2);
    acne.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceConnected()...");
    }
    this.this$0.i = new Messenger(paramIBinder);
    this.this$0.mMessenger = new Messenger(this.this$0.handler);
    acne.b(this.this$0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceDisconnected()...");
    }
    this.this$0.i = null;
    acne.a(this.this$0, 4);
    this.this$0.cl.clear();
    this.this$0.mMessenger = null;
    acne.a(this.this$0, true);
    if (acne.a(this.this$0) != null) {
      acne.a(this.this$0).interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acng
 * JD-Core Version:    0.7.0.1
 */