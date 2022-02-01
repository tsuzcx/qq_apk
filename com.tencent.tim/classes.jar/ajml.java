import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;

public class ajml
  extends ajmj.a
{
  public ajml(QQPlayerService paramQQPlayerService) {}
  
  public int Gt()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentPlayPosition");
    }
    return QQPlayerService.Gt();
  }
  
  public String I(int paramInt, String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : generateToken : callerType=" + paramInt + ",id=" + paramString);
    }
    return QQPlayerService.I(paramInt, paramString);
  }
  
  public SongInfo a()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSong");
    }
    return QQPlayerService.a();
  }
  
  public void a(ajmi paramajmi)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : registerCallback");
    }
    if (paramajmi == null) {
      return;
    }
    if (QQPlayerService.a(this.this$0) == null) {}
    try
    {
      if (QQPlayerService.a(this.this$0) == null) {
        QQPlayerService.a(this.this$0, new RemoteCallbackList());
      }
      QQPlayerService.a(this.this$0).register(paramajmi);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : startPlay sCallback = " + QQPlayerService.h() + ",startIndex" + paramInt);
    }
    if (QQPlayerService.h() != null)
    {
      QQPlayerService.b(QQPlayerService.h());
      QQPlayerService.c(null);
    }
    QQPlayerService.a(this.this$0, paramString, paramArrayOfSongInfo, paramInt);
  }
  
  public SongInfo[] a()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayList");
    }
    return QQPlayerService.a();
  }
  
  public void ag(Intent paramIntent)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setPlayBarIntent: " + paramIntent.toString());
    }
    QQPlayerService.ag(paramIntent);
  }
  
  public void b(ajmi paramajmi)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : unRegisterCallback");
    }
    if ((paramajmi != null) && (QQPlayerService.a(this.this$0) != null)) {
      QQPlayerService.a(this.this$0).unregister(paramajmi);
    }
  }
  
  public SongInfo c()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getNextSong");
    }
    return QQPlayerService.f();
  }
  
  public void dyn()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : playPrev");
    }
    QQPlayerService.bq(this.this$0);
  }
  
  public int getCurrentSongPosition()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSongPosition");
    }
    return QQPlayerService.getCurrentSongPosition();
  }
  
  public int getDuration()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getDuration");
    }
    return QQPlayerService.getDuration();
  }
  
  public Bundle getExtras()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getExtras ");
    }
    return QQPlayerService.getExtras();
  }
  
  public int getPlayMode()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayMode");
    }
    return QQPlayerService.getPlayMode();
  }
  
  public int getPlayState()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayState");
    }
    return QQPlayerService.getPlayState();
  }
  
  public String getToken()
    throws RemoteException
  {
    return QQPlayerService.getToken();
  }
  
  public Intent i()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayBarIntent ");
    }
    return QQPlayerService.i();
  }
  
  public int iH()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSongIndex");
    }
    return QQPlayerService.iH();
  }
  
  public int iI()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayListCount");
    }
    return QQPlayerService.iI();
  }
  
  public boolean isPlaying()
    throws RemoteException
  {
    return QQPlayerService.isPlaying();
  }
  
  public boolean nt(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : isPlayingMySong : token=" + paramString);
    }
    return QQPlayerService.nt(paramString);
  }
  
  public void pause()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : pause");
    }
    QQPlayerService.eE(this.this$0);
  }
  
  public void resume()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : resume");
    }
    QQPlayerService.eF(this.this$0);
  }
  
  public void seekTo(int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : seekTo " + paramInt);
    }
    QQPlayerService.seekTo(paramInt);
  }
  
  public void setExtras(Bundle paramBundle)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setExtras ");
    }
    QQPlayerService.setExtras(paramBundle);
  }
  
  public void setPlayMode(int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setPlayMode");
    }
    QQPlayerService.setPlayMode(paramInt);
  }
  
  public void stop()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : stop");
    }
    QQPlayerService.eG(this.this$0);
  }
  
  public void yO()
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : playNext");
    }
    QQPlayerService.br(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajml
 * JD-Core Version:    0.7.0.1
 */