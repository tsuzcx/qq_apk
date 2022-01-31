import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.IQQPlayerService.Stub;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import org.json.JSONObject;

public class ghm
  implements ServiceConnection
{
  public ghm(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MusicGeneWebViewPlugin.a(this.a, IQQPlayerService.Stub.a(paramIBinder));
    try
    {
      paramComponentName = MusicGeneWebViewPlugin.a(this.a).a(3, MusicGeneWebViewPlugin.a());
      paramIBinder = MusicGeneWebViewPlugin.a(this.a).a();
      if ((paramIBinder != null) && (paramIBinder.equals(paramComponentName))) {
        MusicGeneWebViewPlugin.a(this.a).a(MusicGeneWebViewPlugin.a(this.a));
      }
      if (MusicGeneWebViewPlugin.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        MusicGeneWebViewPlugin.a(this.a).a(paramComponentName);
        MusicGeneWebViewPlugin.a(this.a, null);
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
      if (MusicGeneWebViewPlugin.a(this.a) != null) {
        MusicGeneWebViewPlugin.a(this.a).b(MusicGeneWebViewPlugin.a(this.a));
      }
      if (MusicGeneWebViewPlugin.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        MusicGeneWebViewPlugin.a(this.a).a(paramComponentName);
        MusicGeneWebViewPlugin.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    MusicGeneWebViewPlugin.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghm
 * JD-Core Version:    0.7.0.1
 */