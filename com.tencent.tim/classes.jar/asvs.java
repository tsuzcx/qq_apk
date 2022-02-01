import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

class asvs
  extends ajmi.a
{
  asvs(asvp paramasvp) {}
  
  public void onPlaySongChanged(com.tencent.mobileqq.music.SongInfo paramSongInfo)
    throws RemoteException
  {
    if (asvp.a(this.a) != null)
    {
      com.tencent.qqmini.sdk.launcher.core.model.SongInfo localSongInfo = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
      localSongInfo.album = paramSongInfo.album;
      localSongInfo.coverUrl = paramSongInfo.coverUrl;
      localSongInfo.detailUrl = paramSongInfo.detailUrl;
      localSongInfo.duration = paramSongInfo.duration;
      localSongInfo.fromMini = paramSongInfo.fromMini;
      localSongInfo.id = paramSongInfo.id;
      localSongInfo.mid = paramSongInfo.mid;
      localSongInfo.singer = paramSongInfo.singer;
      localSongInfo.singerId = paramSongInfo.singerId;
      localSongInfo.startTime = paramSongInfo.startTime;
      localSongInfo.summary = paramSongInfo.summary;
      localSongInfo.title = paramSongInfo.title;
      localSongInfo.type = paramSongInfo.type;
      localSongInfo.uin = paramSongInfo.uin;
      localSongInfo.url = paramSongInfo.url;
      asvp.a(this.a).onPlaySongChanged(localSongInfo);
    }
  }
  
  public void onPlayStateChanged(int paramInt)
    throws RemoteException
  {
    if ((asvp.a(this.a) == null) || ((asvp.a(this.a).getToken() != null) && (!asvp.a(this.a).getToken().equals(asvp.a(this.a))))) {}
    while (asvp.a(this.a) == null) {
      return;
    }
    asvp.a(this.a).onPlayStateChanged(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvs
 * JD-Core Version:    0.7.0.1
 */