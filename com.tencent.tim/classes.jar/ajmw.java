import android.os.RemoteException;
import com.tencent.mobileqq.music.SongInfo;

class ajmw
  extends ajmi.a
{
  ajmw(ajmu paramajmu) {}
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
    throws RemoteException
  {
    if (ajmu.a(this.this$0) != null) {
      ajmu.a(this.this$0, ajmu.a(this.this$0).a());
    }
  }
  
  public void onPlayStateChanged(int paramInt)
    throws RemoteException
  {
    ajmu.a(this.this$0, paramInt);
    if (paramInt == 2) {
      ajmu.a(this.this$0, ajmu.a(this.this$0).getDuration());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmw
 * JD-Core Version:    0.7.0.1
 */