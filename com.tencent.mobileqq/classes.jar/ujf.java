import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskPreloadMgr.preloadSuperMaskRes.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskPreloadMgr;", "", "()V", "checkPreloadIfNeed", "", "preloadSuperMaskRes", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ujf
{
  public static final ujf a = new ujf();
  
  private final boolean a()
  {
    boolean bool = ujt.a.a("[PRELOAD]", new ujc[] { (ujc)new ujk(), (ujc)new ujo() });
    return (ujd.a.a() == 1) || (bool);
  }
  
  public final void a()
  {
    if (!a()) {
      return;
    }
    ThreadManagerV2.excute((Runnable)SuperMaskPreloadMgr.preloadSuperMaskRes.1.a, 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujf
 * JD-Core Version:    0.7.0.1
 */