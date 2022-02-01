import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class ubg
  implements ubd
{
  ubd.a a;
  BroadcastReceiver mReceiver;
  
  private void bbD()
  {
    if (this.mReceiver == null) {
      try
      {
        if (this.mReceiver == null)
        {
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.mobileqq.Doraemon.monitor.update");
          localIntentFilter.addAction("com.tencent.mobileqq.Doraemon.monitor.update_batch");
          ubh localubh = new ubh(this);
          BaseApplicationImpl.getContext().registerReceiver(localubh, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
          this.mReceiver = localubh;
        }
        return;
      }
      finally {}
    }
  }
  
  public void A(String paramString1, int paramInt, String paramString2)
  {
    bbD();
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("type", paramInt);
    localBundle.putString("appid", paramString2);
    tzj.a(2, localBundle, null);
  }
  
  public void a(ubd.a parama)
  {
    this.a = parama;
  }
  
  public void f(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    bbD();
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("type", paramInt);
    localBundle.putString("appid", paramString2);
    localBundle.putString("api", paramString3);
    tzj.a(3, localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubg
 * JD-Core Version:    0.7.0.1
 */