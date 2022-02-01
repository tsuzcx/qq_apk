import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class jnw
  extends BroadcastReceiver
{
  jnw(jnv paramjnv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("request_type", 0);
    QLog.i(this.this$0.TAG, 2, "receive request" + paramIntent.getExtras());
    switch (i)
    {
    default: 
      return;
    }
    paramContext = new Intent();
    paramContext.setAction("com.tencent.mobileqq.NearbyJsInterface");
    paramContext.putExtra("command_type", 1);
    paramContext.putExtra("data", jnv.a(this.this$0));
    this.this$0.mAppInterface.getApp().sendBroadcast(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnw
 * JD-Core Version:    0.7.0.1
 */