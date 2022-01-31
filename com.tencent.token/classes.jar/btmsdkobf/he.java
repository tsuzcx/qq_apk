package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

final class he
  extends BroadcastReceiver
{
  private boolean b;
  
  private he(db paramdb) {}
  
  private void a(Context paramContext)
  {
    if (!this.b) {}
    try
    {
      String str = paramContext.getPackageName();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction(String.format("action.guid.got:%s", new Object[] { str }));
      localIntentFilter.addAction(String.format("action.rsa.got:%s", new Object[] { str }));
      localIntentFilter.addAction(String.format("action.reg.guid:%s", new Object[] { str }));
      localIntentFilter.addAction(String.format("action.up.rsa:%s", new Object[] { str }));
      localIntentFilter.addAction(String.format("action.d.a:%s", new Object[] { str }));
      paramContext.registerReceiver(this, localIntentFilter);
      this.b = true;
      return;
    }
    catch (Throwable paramContext)
    {
      eh.a("SharkProtocolQueue", "[cu_guid] register: " + paramContext, paramContext);
      paramContext.printStackTrace();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (paramIntent.getPackage().compareToIgnoreCase(bc.n().getPackageName()) != 0) {
      return;
    }
    ee.cT().addTask(new hf(this, paramContext, str, paramIntent), "GuidOrRsaKeyGotReceiver onRecv");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.he
 * JD-Core Version:    0.7.0.1
 */