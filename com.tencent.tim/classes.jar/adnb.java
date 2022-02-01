import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ScanCodeMethod.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class adnb
  extends BroadcastReceiver
{
  adnb(admn.d paramd, long paramLong) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("com.tencent.ark.scanResultData");
    paramIntent = paramIntent.getStringExtra("com.tencent.ark.scanResultType");
    ArkAppCenter.a().post(this.b.this$0.mAppName, new ArkAppDeviceModule.ScanCodeMethod.1.1(this, paramContext, paramIntent));
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(admn.a(this.b.this$0));
      label56:
      admn.a(this.b.this$0, null);
      return;
    }
    catch (Exception paramContext)
    {
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnb
 * JD-Core Version:    0.7.0.1
 */