import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.redpacket.AVRedPacketManager;

public class ijp
{
  private ijo[] a = new ijo[15];
  private Object lock = new Object();
  private VideoAppInterface mApp;
  
  public ijp(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public void V(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 15) && (!ijo.a("BusinessManagerFactory", this.mApp, paramInt)) && (a(paramInt).cs(paramString))) {
      ijo.a("BusinessManagerFactory", this.mApp.getApplication(), paramInt, true);
    }
  }
  
  public ijo a(int paramInt)
  {
    Object localObject1 = this.a[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.lock)
    {
      ijo localijo = this.a[paramInt];
      localObject1 = localijo;
      if (localijo == null)
      {
        localijo = a(this.mApp, paramInt);
        localObject1 = localijo;
        if (localijo != null)
        {
          this.a[paramInt] = localijo;
          localObject1 = localijo;
        }
      }
      return localObject1;
    }
  }
  
  protected ijo a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      igd.aJ("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.onCreate();
      }
      long l2 = System.currentTimeMillis();
      igd.aJ("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new ilg(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new iju(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ikl(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ikr(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ikt(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ijv(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new jht(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ila(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ikz(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ijt(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ikd(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ikm(paramVideoAppInterface);
    }
  }
  
  public boolean ch(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < 15)
      {
        bool1 = bool2;
        if (this.a[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void kI(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijp
 * JD-Core Version:    0.7.0.1
 */