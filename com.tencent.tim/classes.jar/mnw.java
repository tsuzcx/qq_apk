import android.content.Context;
import android.support.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.10;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.11;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.5;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.6;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.8;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.9;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

public class mnw
  implements Manager
{
  private EntityManager a;
  private boolean amf;
  private boolean ans;
  private QQAppInterface app;
  private List<mnw.c> jp = new ArrayList();
  private final ArrayList<UgcVideo> lg = new ArrayList();
  private final ArrayList<mnw.b> lh = new ArrayList();
  private INetInfoHandler netInfoHandler = new mnx(this);
  private final LinkedHashMap<String, mnt> z = new LinkedHashMap();
  
  public mnw(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.a = paramQQAppInterface.a().createEntityManager();
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.netInfoHandler);
  }
  
  private List<UgcVideo> a(long paramLong, List<UgcVideo> paramList)
  {
    if (paramLong == 0L) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)paramList.next();
      if (localUgcVideo.columnId == paramLong) {
        localArrayList.add(localUgcVideo);
      }
    }
    return localArrayList;
  }
  
  public static mnw a(QQAppInterface paramQQAppInterface)
  {
    return (mnw)paramQQAppInterface.getManager(356);
  }
  
  private void aQJ()
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.8(this), 32, null, false);
  }
  
  private void aQK()
  {
    if (this.ans)
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent is doing");
      return;
    }
    List localList = bc();
    if (localList.isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent, ugcVideoList isEmpty");
      return;
    }
    this.ans = true;
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      d((UgcVideo)((Iterator)localObject).next());
    }
    long l = mix.b(localList);
    localObject = BaseActivity.sTopActivity;
    if ((l > 0L) && (kxm.Bb()) && (localObject != null))
    {
      mix.a((Context)localObject, l, new mny(this, localList), new mnz(this));
      return;
    }
    this.ans = false;
  }
  
  private List<UgcVideo> bc()
  {
    Object localObject = this.z.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      mnt localmnt = (mnt)((Iterator)localObject).next();
      if (localmnt.a().status == UgcVideo.STATUS_UPLOADING) {
        localArrayList.add(localmnt.a());
      }
    }
    return localArrayList;
  }
  
  private void h(UgcVideo paramUgcVideo)
  {
    Iterator localIterator = this.jp.iterator();
    while (localIterator.hasNext()) {
      ((mnw.c)localIterator.next()).i(paramUgcVideo);
    }
  }
  
  @UiThread
  public void a(long paramLong, @NotNull mnw.a parama)
  {
    if (this.amf)
    {
      parama.bl(a(paramLong, this.lg));
      return;
    }
    this.lh.add(new mod(this, paramLong, parama));
    aQJ();
  }
  
  @UiThread
  public final void a(@NotNull UgcVideo paramUgcVideo, boolean paramBoolean)
  {
    QLog.d("RIJUGC.RIJUgcVideoPublishManager", 1, "addVideoTask: ugcVideo.seqId = " + paramUgcVideo.seqId);
    mnt localmnt = (mnt)this.z.get(paramUgcVideo.seqId);
    if (localmnt == null)
    {
      localmnt = new mnt(paramUgcVideo);
      localmnt.a(new moa(this));
      localmnt.a(new mob(this));
      Object localObject1 = new moc(this, paramUgcVideo);
      Object localObject2 = new kpm(localmnt, new kpi[] { new mnq(this.app, localmnt, (mns)localObject1), new mog(this.app, localmnt, (mns)localObject1, new mqq(this.app)) });
      localObject2 = new kpg(localmnt, new kpi[] { new moe(this.app, localmnt, (mns)localObject1), localObject2 });
      localObject1 = new mnu(localmnt, (mns)localObject1);
      localmnt.E(new RIJUgcVideoPublishManager.5(this, paramUgcVideo));
      localmnt.a(new kpi[] { localObject2, localObject1 }, paramBoolean);
      this.z.put(paramUgcVideo.seqId, localmnt);
    }
    for (;;)
    {
      if (paramBoolean) {
        paramUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      }
      if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()))
      {
        if (!this.lg.contains(paramUgcVideo)) {
          this.lg.add(paramUgcVideo);
        }
        e(paramUgcVideo);
      }
      return;
      localmnt.aFJ();
    }
  }
  
  @UiThread
  public void a(@NotNull mnw.c paramc)
  {
    this.jp.add(paramc);
  }
  
  @UiThread
  public void b(@NotNull mnw.c paramc)
  {
    this.jp.remove(paramc);
  }
  
  @UiThread
  public void c(UgcVideo paramUgcVideo)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "removeVideoTask, ugcVideo.seqId =" + paramUgcVideo.seqId);
    if (paramUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
      d(paramUgcVideo);
    }
    paramUgcVideo.title = "";
    this.z.remove(paramUgcVideo.seqId);
    this.lg.remove(paramUgcVideo);
    g(paramUgcVideo);
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.6(this, paramUgcVideo), 64, null, false);
  }
  
  public void d(UgcVideo paramUgcVideo)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "pauseVideoTask, ugcVideo.seqId =" + paramUgcVideo.seqId);
    paramUgcVideo.status = UgcVideo.STATUS_PAUSE;
    mnt localmnt = (mnt)this.z.get(paramUgcVideo.seqId);
    if (paramUgcVideo.startUploadingTime > 0L) {
      mix.a("pause", paramUgcVideo);
    }
    if (localmnt != null) {
      localmnt.aFL();
    }
  }
  
  public void e(UgcVideo paramUgcVideo)
  {
    if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()) && (this.lg.contains(paramUgcVideo))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ThreadManagerV2.excute(new RIJUgcVideoPublishManager.9(this, paramUgcVideo), 32, null, false);
      }
      return;
    }
  }
  
  public void f(UgcVideo paramUgcVideo)
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.10(this, paramUgcVideo), 32, null, false);
  }
  
  public void g(UgcVideo paramUgcVideo)
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.11(this, paramUgcVideo), 32, null, false);
  }
  
  public void onDestroy()
  {
    this.z.clear();
    this.lg.clear();
    this.lh.clear();
    this.amf = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.netInfoHandler);
    uk();
  }
  
  public void uk()
  {
    Iterator localIterator = this.lg.iterator();
    while (localIterator.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
      if (localUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
        d(localUgcVideo);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bl(@NotNull List<UgcVideo> paramList);
  }
  
  public static abstract interface b
  {
    public abstract void onFinish();
  }
  
  public static abstract interface c
  {
    public abstract void i(UgcVideo paramUgcVideo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnw
 * JD-Core Version:    0.7.0.1
 */