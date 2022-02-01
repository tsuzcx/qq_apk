import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity.d;
import java.util.HashMap;

public class ajne
  extends ajmi.a
{
  public ajne(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
    throws RemoteException
  {
    if (paramSongInfo != null)
    {
      localObject = MusicPlayerActivity.a(this.a, paramSongInfo);
      if (!MusicPlayerActivity.S().containsKey(localObject)) {
        break label64;
      }
      localObject = (MusicPlayerActivity.d)MusicPlayerActivity.S().get(localObject);
      paramSongInfo = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, ((MusicPlayerActivity.d)localObject).acZ);
      MusicPlayerActivity.a(this.a, (MusicPlayerActivity.d)localObject, paramSongInfo);
    }
    label64:
    while (MusicPlayerActivity.access$600().containsKey(localObject)) {
      return;
    }
    Object localObject = MusicPlayerActivity.a(this.a);
    if (localObject != null) {}
    for (int i = ((ajmj)localObject).getDuration();; i = 0)
    {
      localObject = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, -1L);
      MusicPlayerActivity.a(this.a, paramSongInfo.title, paramSongInfo.singer, paramSongInfo.coverUrl, (String)localObject, false, false);
      MusicPlayerActivity.a(this.a).a(this.a.app.getLongAccountUin(), paramSongInfo.title, paramSongInfo.singer, paramSongInfo.album, String.valueOf(paramSongInfo.id), paramSongInfo.summary, i);
      return;
    }
  }
  
  public void onPlayStateChanged(int paramInt)
    throws RemoteException
  {
    Message.obtain(MusicPlayerActivity.a(this.a), 50, paramInt, 0).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajne
 * JD-Core Version:    0.7.0.1
 */