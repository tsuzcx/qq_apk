import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/PreloadIntervalCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvn
  extends tvc
{
  public boolean a()
  {
    long l1 = tvd.a.a();
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (tvd.a.b() <= 0L) {
      tvd.a.b(1800L);
    }
    if (l2 - l1 >= tvd.a.b()) {}
    for (boolean bool = true;; bool = false) {
      return tvs.a.a(bool, (tvc)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvn
 * JD-Core Version:    0.7.0.1
 */