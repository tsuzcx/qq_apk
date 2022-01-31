import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;

public class bpk
  extends BroadcastReceiver
{
  public bpk(SosoPlugin paramSosoPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.tencent.receiver.soso.type", SosoSrvAddrProvider.a);
    if (i == SosoSrvAddrProvider.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d(SosoPlugin.a(this.a), 2, "soso receiver ACTION_SOSO_TYPE_UPDATE");
      }
      SosoSrvAddrProvider.a().c();
    }
    while (i != SosoSrvAddrProvider.b) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(SosoPlugin.b(this.a), 2, "soso receiver ACTION_SOSO_TYPE_CLEAR");
    }
    SosoSrvAddrProvider.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpk
 * JD-Core Version:    0.7.0.1
 */