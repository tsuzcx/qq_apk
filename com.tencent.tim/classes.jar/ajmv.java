import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

class ajmv
  implements ServiceConnection
{
  ajmv(ajmu paramajmu) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    ajmu.a(this.this$0, ajmj.a.a(paramIBinder));
    try
    {
      ajmu.a(this.this$0).a(ajmu.a(this.this$0));
      if (ajmu.a(this.this$0) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        ajmu.a(this.this$0).onComplete(paramComponentName);
        ajmu.a(this.this$0, null);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (ajmu.a(this.this$0) != null) {
        ajmu.a(this.this$0).b(ajmu.a(this.this$0));
      }
      if (ajmu.a(this.this$0) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        ajmu.a(this.this$0).onComplete(paramComponentName);
        ajmu.a(this.this$0, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    ajmu.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmv
 * JD-Core Version:    0.7.0.1
 */