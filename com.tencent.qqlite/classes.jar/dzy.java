import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.IQQPlayerService.Stub;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;

public class dzy
  implements ServiceConnection
{
  public dzy(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin) {}
  
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
      return;
    }
    catch (RemoteException paramComponentName)
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
      MusicGeneWebViewPlugin.a(this.a, null);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dzy
 * JD-Core Version:    0.7.0.1
 */