import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkPlayer;
import com.tencent.ark.ark.PlayerStubFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMediaPlayer.2;
import com.tencent.mobileqq.ark.ArkMediaPlayer.3;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class adrh
  extends ArkPlayer
{
  private static final Set<WeakReference<adrh>> cd = Collections.synchronizedSet(new HashSet());
  public static final ark.PlayerStubFactory sFactory = new adri();
  private int cJA = 3;
  private int cJB = 4;
  private int cJC = this.cJx;
  private int cJx;
  private int cJy = 1;
  private int cJz = 2;
  private boolean mActive = true;
  
  protected adrh()
  {
    cd.add(new WeakReference(this));
    ENV.logI("Ark.ArkMediaPlayer", String.format("ArkMediaPlayer.create.%h", new Object[] { this }));
  }
  
  public static void cTW()
  {
    synchronized (cd)
    {
      Iterator localIterator = cd.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (adrh)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((adrh)localObject2).cTX();
          }
        }
      }
    }
  }
  
  public static void onBackground()
  {
    synchronized (cd)
    {
      Iterator localIterator = cd.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (adrh)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((adrh)localObject2).cTY();
          }
        }
      }
    }
  }
  
  public boolean Pause()
  {
    if (!this.mActive) {
      this.cJC = this.cJA;
    }
    return super.Pause();
  }
  
  public boolean Play()
  {
    if (!this.mActive) {
      this.cJC = this.cJy;
    }
    return super.Play();
  }
  
  public boolean Resume()
  {
    if (!this.mActive) {
      this.cJC = this.cJB;
    }
    return super.Resume();
  }
  
  public boolean Stop()
  {
    if (!this.mActive) {
      this.cJC = this.cJz;
    }
    return super.Stop();
  }
  
  public void cTX()
  {
    ArkAppCenter.a().post(this.mQueueKey, new ArkMediaPlayer.2(this));
  }
  
  public void cTY()
  {
    ArkAppCenter.a().post(this.mQueueKey, new ArkMediaPlayer.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     adrh
 * JD-Core Version:    0.7.0.1
 */