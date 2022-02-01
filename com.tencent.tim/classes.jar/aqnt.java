import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.mobileqq.utils.VoicePlayer.1;
import com.tencent.mobileqq.utils.VoicePlayer.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aqnt
  implements alio
{
  private ArrayList<aqnt.a> CQ = new ArrayList();
  private alin a;
  private boolean audioFocus;
  private boolean cUJ;
  private String cup;
  private Handler handler;
  private Context mContext;
  private Runnable runnable = new VoicePlayer.1(this);
  private int state;
  private int type;
  
  public aqnt(Context paramContext, int paramInt)
  {
    this.a = new AmrPlayer(paramContext, paramInt);
    this.state = 1;
    this.type = 1;
  }
  
  public aqnt(String paramString, Handler paramHandler)
  {
    this(paramString, paramHandler, 0);
  }
  
  public aqnt(String paramString, Handler paramHandler, int paramInt)
  {
    this.cup = paramString;
    this.handler = paramHandler;
    if (paramInt == 0) {
      this.a = new AmrPlayer();
    }
    for (this.type = 2;; this.type = 3)
    {
      this.state = 1;
      return;
      this.a = new SilkPlayer();
    }
  }
  
  private void SO(boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (this.audioFocus) {
      aqge.m(this.mContext, false);
    }
    if (paramBoolean) {}
    for (this.state = 8;; this.state = 4)
    {
      if (this.a != null)
      {
        i = j;
        if (this.state == 4) {
          i = this.a.getDuration();
        }
        this.a.release();
        this.a = null;
      }
      Iterator localIterator = this.CQ.iterator();
      while (localIterator.hasNext()) {
        ((aqnt.a)localIterator.next()).c(this.state, this.cup, i);
      }
    }
  }
  
  private int getCurrentPosition()
  {
    if (this.a != null) {
      return this.a.getCurrentPosition();
    }
    return 0;
  }
  
  private int getDuration()
  {
    if (this.a != null) {
      return this.a.getDuration();
    }
    return 0;
  }
  
  private void handleCompletion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onCompletion duration=" + getDuration() + " current=" + getCurrentPosition() + " enableEndBuffer=" + this.cUJ + " thread=" + Thread.currentThread().getName());
    }
    if (this.cUJ)
    {
      if (this.handler != null)
      {
        this.state = 7;
        this.handler.postDelayed(new VoicePlayer.2(this), 500L);
        return;
      }
      SO(false);
      return;
    }
    SO(false);
  }
  
  public void Ce(int paramInt) {}
  
  public void a(alim paramalim)
  {
    if (aFj()) {
      ((SilkPlayer)this.a).a(paramalim);
    }
  }
  
  public void a(alin paramalin, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onError what=" + paramInt1 + " extra=" + paramInt2);
    }
    SO(true);
  }
  
  public void a(aqnt.a parama)
  {
    if (!this.CQ.contains(parama)) {
      this.CQ.add(parama);
    }
  }
  
  public boolean aFj()
  {
    return (this.a != null) && ((this.a instanceof SilkPlayer));
  }
  
  public boolean aFk()
  {
    if (this.handler == null)
    {
      this.cUJ = false;
      return false;
    }
    this.cUJ = true;
    return true;
  }
  
  public void bYG() {}
  
  public void bvB()
  {
    if ((this.a instanceof AmrPlayer))
    {
      this.state = 2;
      ((AmrPlayer)this.a).bvB();
      if (this.audioFocus) {
        aqge.m(this.mContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      if (this.handler != null) {
        this.handler.post(this.runnable);
      }
    }
  }
  
  public boolean cf(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null) {
      this.audioFocus = true;
    }
    return this.audioFocus;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void onCompletion()
  {
    handleCompletion();
  }
  
  public void pause()
  {
    if (this.state == 7) {}
    for (;;)
    {
      return;
      if (this.audioFocus) {
        aqge.m(this.mContext, false);
      }
      this.state = 3;
      this.a.pause();
      Iterator localIterator = this.CQ.iterator();
      while (localIterator.hasNext()) {
        ((aqnt.a)localIterator.next()).d(this.cup, getDuration(), getCurrentPosition());
      }
    }
  }
  
  public void release()
  {
    if (this.audioFocus) {
      aqge.m(this.mContext, false);
    }
    this.state = 6;
    if (this.a != null)
    {
      this.a.stop();
      this.a.release();
      this.a = null;
    }
  }
  
  public void seekTo(int paramInt)
  {
    this.a.seekTo(paramInt);
  }
  
  public void start()
  {
    if (this.state == 1)
    {
      try
      {
        this.state = 2;
        if (this.type != 1)
        {
          this.a.setDataSource(this.cup);
          this.a.prepare();
        }
        this.a.a(this);
        this.a.start();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          SO(true);
        }
      }
      if (this.audioFocus) {
        aqge.m(this.mContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "start to play...  for test time=" + System.currentTimeMillis());
    }
    for (;;)
    {
      if (this.handler != null) {
        this.handler.post(this.runnable);
      }
      return;
      if (this.state == 3)
      {
        this.state = 2;
        this.a.start();
        if (this.audioFocus) {
          aqge.m(this.mContext, true);
        }
        QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt1, String paramString, int paramInt2);
    
    public abstract void c(String paramString, int paramInt1, int paramInt2);
    
    public abstract void d(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnt
 * JD-Core Version:    0.7.0.1
 */