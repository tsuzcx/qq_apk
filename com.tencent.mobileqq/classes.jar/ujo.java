import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/PreloadIntervalCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ujo
  extends ujc
{
  public boolean a()
  {
    long l1 = ujd.a.a();
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (ujd.a.b() <= 0L) {
      ujd.a.b(1800L);
    }
    if (l2 - l1 >= ujd.a.b()) {}
    for (boolean bool = true;; bool = false) {
      return ujt.a.a(bool, (ujc)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujo
 * JD-Core Version:    0.7.0.1
 */