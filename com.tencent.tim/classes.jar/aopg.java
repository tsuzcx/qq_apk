import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aopg
  extends BroadcastReceiver
{
  aopg(aopd paramaopd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.innerdns.domainAddressDataUpdateAction".equals(paramIntent.getAction())) {
      aopd.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopg
 * JD-Core Version:    0.7.0.1
 */