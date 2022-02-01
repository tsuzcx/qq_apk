import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.impl.SuperMaskPreloadMgr.preloadSuperMaskRes.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/impl/SuperMaskPreloadMgr;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/ISuperMaskPreload;", "()V", "checkPreloadIfNeed", "", "preloadSuperMaskRes", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvf
{
  public static final tvf a = new tvf();
  
  private final boolean a()
  {
    boolean bool = tvs.a.a("[PRELOAD]", new tvc[] { (tvc)new tvj(), (tvc)new tvn() });
    return (tvd.a.a() == 1) || (bool);
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
    ThreadManagerV2.excute((Runnable)SuperMaskPreloadMgr.preloadSuperMaskRes.1.a, 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvf
 * JD-Core Version:    0.7.0.1
 */