import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.1;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.2;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class abqy
  implements abiy
{
  private abrc a;
  private volatile boolean bES;
  private volatile boolean bET;
  private String bht;
  private Runnable fA = new SpriteBackgroundManager.2(this);
  private WeakReference<ApolloTextureView> fJ;
  private Runnable fz = new SpriteBackgroundManager.1(this);
  private ConcurrentLinkedQueue v = new ConcurrentLinkedQueue();
  
  public abqy(abrc paramabrc, ApolloTextureView paramApolloTextureView)
  {
    this.a = paramabrc;
    this.fJ = new WeakReference(paramApolloTextureView);
  }
  
  private void HQ(int paramInt)
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.fJ.get();
    if (localApolloTextureView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, new Object[] { "[execAction], ready to play, actionId:", Integer.valueOf(paramInt) });
    }
    String[] arrayOfString = abvg.e(paramInt);
    this.bht = arrayOfString[1];
    localApolloTextureView.getRenderImpl().a(1, null, paramInt, 0, arrayOfString[0], arrayOfString[1]);
  }
  
  private void HR(int paramInt)
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.fJ.get();
    if ((localApolloTextureView != null) && (localApolloTextureView.getVisibility() != paramInt)) {
      ThreadManager.getUIHandler().post(new SpriteBackgroundManager.3(this, localApolloTextureView, paramInt));
    }
  }
  
  public void B(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "[onCompleteRender]");
    }
    this.bES = false;
    if ((this.v != null) && (!this.v.isEmpty()))
    {
      paramString = (Integer)this.v.poll();
      if (paramString != null) {
        HQ(paramString.intValue());
      }
    }
    while (this.bES) {
      return;
    }
    HR(8);
  }
  
  public void bH(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "[onStartRender]");
    }
    this.bES = true;
    HR(0);
  }
  
  public void cEv()
  {
    if (((ApolloTextureView)this.fJ.get() == null) || (this.bht == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, new Object[] { "removeBackgroundAction isRunning:", Boolean.valueOf(this.bES), ",actionName:", this.bht });
      }
      if ((this.v != null) && (!this.v.isEmpty())) {
        this.v.clear();
      }
    } while (!this.bES);
    this.bES = false;
  }
  
  public void cEw()
  {
    if ((this.a == null) || (this.a.getApp() == null)) {}
    abrg localabrg;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "[onSurfaceReady]");
      }
      this.a.Ed(true);
      localabrg = (abrg)this.a.getApp().getManager(249);
    } while ((!this.a.isSurfaceReady()) || (localabrg.a().d(null)));
    cEz();
  }
  
  public void cEx()
  {
    if (!this.bES) {}
    ApolloTextureView localApolloTextureView;
    do
    {
      return;
      this.bET = true;
      localApolloTextureView = (ApolloTextureView)this.fJ.get();
    } while (localApolloTextureView == null);
    localApolloTextureView.queueEvent(this.fz);
  }
  
  public void cEy()
  {
    this.bET = false;
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.fJ.get();
    if (localApolloTextureView != null) {
      localApolloTextureView.queueEvent(this.fA);
    }
  }
  
  public void cEz()
  {
    HR(8);
    cEv();
  }
  
  public void hZ(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.v == null)) {}
    do
    {
      do
      {
        return;
        if (this.bES) {
          cEv();
        }
        this.v.clear();
        this.v.addAll(paramList);
      } while (this.v.isEmpty());
      paramList = (Integer)this.v.poll();
    } while (paramList == null);
    HQ(paramList.intValue());
  }
  
  public void onDestroy()
  {
    if (this.v != null) {
      this.v.clear();
    }
    Object localObject = (ApolloTextureView)this.fJ.get();
    if (localObject != null)
    {
      localObject = ((ApolloTextureView)localObject).getRenderImpl();
      if (localObject != null) {
        ((abii)localObject).onDestroy();
      }
    }
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqy
 * JD-Core Version:    0.7.0.1
 */