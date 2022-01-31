import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;

public class elb
  extends TroopObserver
{
  public elb(RecommendTroopView paramRecommendTroopView) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if ((this.a.a == null) || (paramLong != Long.valueOf(this.a.a.uin).longValue())) {
      return;
    }
    this.a.l();
    if (paramBoolean)
    {
      this.a.a.option = paramTroopInfo.cGroupOption;
      RecommendTroopView.a(this.a, this.a.a, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer);
    }
    for (;;)
    {
      this.a.a = null;
      return;
      this.a.b(2131561435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     elb
 * JD-Core Version:    0.7.0.1
 */