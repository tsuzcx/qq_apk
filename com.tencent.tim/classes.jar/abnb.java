import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class abnb
  implements abnm
{
  private abob a;
  
  public abnb(abob paramabob)
  {
    this.a = paramabob;
  }
  
  public void Zx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmAudioManager", 2, "pause all music");
    }
    if (abnc.ws != null) {
      synchronized (abnc.ws)
      {
        Iterator localIterator = abnc.ws.iterator();
        while (localIterator.hasNext())
        {
          abnc localabnc = (abnc)localIterator.next();
          if ((localabnc != null) && (localabnc.getGameId() == zI())) {
            localabnc.l(new JSONObject());
          }
        }
      }
    }
  }
  
  public int a(abjq paramabjq, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    return 0;
  }
  
  public void a(int paramInt, AppInterface paramAppInterface) {}
  
  public int c(AppInterface paramAppInterface)
  {
    return 0;
  }
  
  public int gc(int paramInt)
  {
    return 0;
  }
  
  public int getDuration(int paramInt)
  {
    return 0;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmAudioManager", 2, "destroy all music");
    }
    if (abnc.ws != null) {
      synchronized (abnc.ws)
      {
        Iterator localIterator = abnc.ws.iterator();
        while (localIterator.hasNext())
        {
          abnc localabnc = (abnc)localIterator.next();
          if ((localabnc != null) && (localabnc.getGameId() == zI()))
          {
            localabnc.rf();
            localIterator.remove();
          }
        }
      }
    }
    if (this.a != null)
    {
      this.a.destroyHandler();
      this.a = null;
    }
  }
  
  public void pauseMusic(int paramInt, String paramString) {}
  
  public void resumeMusic()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmAudioManager", 2, "resume all music");
    }
  }
  
  public void resumeMusic(int paramInt, String paramString) {}
  
  public void seekTo(int paramInt1, int paramInt2) {}
  
  public void stopMusic(int paramInt, String paramString) {}
  
  public int zI()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.mGameId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnb
 * JD-Core Version:    0.7.0.1
 */