import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity.d;
import java.util.HashMap;

public class ajnd
  implements ServiceConnection
{
  public ajnd(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MusicPlayerActivity.a(this.a, ajmj.a.a(paramIBinder));
    try
    {
      MusicPlayerActivity.a(this.a).a(MusicPlayerActivity.a(this.a));
      paramComponentName = MusicPlayerActivity.a(this.a).a();
      paramIBinder = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramComponentName, -1L);
      if (paramComponentName != null)
      {
        String str = MusicPlayerActivity.a(this.a, paramComponentName);
        if (MusicPlayerActivity.S().containsKey(str)) {
          MusicPlayerActivity.a(this.a, (MusicPlayerActivity.d)MusicPlayerActivity.S().get(str), paramIBinder);
        }
        for (;;)
        {
          int i = MusicPlayerActivity.a(this.a).getPlayState();
          Message.obtain(MusicPlayerActivity.a(this.a), 50, i, 0).sendToTarget();
          MusicPlayerActivity.a(this.a).a(this.a.app.getLongAccountUin(), paramComponentName.title, paramComponentName.singer, paramComponentName.album, String.valueOf(paramComponentName.id), paramComponentName.summary, MusicPlayerActivity.a(this.a).getDuration());
          return;
          MusicPlayerActivity.a(this.a, paramComponentName.title, paramComponentName.singer, paramComponentName.coverUrl, paramIBinder, false, false);
        }
      }
      return;
    }
    catch (Exception paramComponentName) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = MusicPlayerActivity.a(this.a);
    if (paramComponentName != null) {}
    try
    {
      paramComponentName.b(MusicPlayerActivity.a(this.a));
      return;
    }
    catch (RemoteException paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnd
 * JD-Core Version:    0.7.0.1
 */